package gr.aueb.cf.cf9.ch18.bankapp;

import gr.aueb.cf.cf9.ch18.bankapp.controller.AccountController;
import gr.aueb.cf.cf9.ch18.bankapp.core.exceptions.AccountNotFoundException;
import gr.aueb.cf.cf9.ch18.bankapp.core.exceptions.InsufficientBalanceException;
import gr.aueb.cf.cf9.ch18.bankapp.core.exceptions.ValidationException;
import gr.aueb.cf.cf9.ch18.bankapp.dao.AccountDAOImpl;
import gr.aueb.cf.cf9.ch18.bankapp.dao.IAccountDAO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountReadOnlyDTO;
import gr.aueb.cf.cf9.ch18.bankapp.service.AccountServiceImpl;
import gr.aueb.cf.cf9.ch18.bankapp.service.IAccountService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static IAccountDAO accountDAO = new AccountDAOImpl();
    private final static IAccountService accountService = new AccountServiceImpl(accountDAO);
    private final static AccountController accountController = new AccountController(accountService);
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String option;
        String iban;
        while (true) {
            printMenu();
            option = scanner.nextLine();

            try {
                switch (option) {
                    case "1" -> {
                        System.out.print("Παρακαλω εισαγετε το iban:");
                        iban = scanner.nextLine().trim();
                        System.out.println("Παρακαλω εισαγετε το υπολοιπο");
                        BigDecimal balance = new BigDecimal(scanner.nextLine().trim());

                        AccountReadOnlyDTO readOnlyDTO = accountController.createNewAccount(iban, balance);
                        System.out.println("Ο λογαριασμος δημιουργηθηκε (ανανεωθηκε) επιτυχως με iban: " +
                                readOnlyDTO.iban() + "υπολοιπο: " + readOnlyDTO.balance());
                    }
                    case "2" -> {
                        System.out.print("Παρακαλω εισαγετε το iban:");
                        iban = scanner.nextLine().trim();
                        System.out.println("Παρακαλω εισαγετε το ποσο καταθεσης");
                        BigDecimal depositAmount = new BigDecimal(scanner.nextLine().trim());

                        accountController.deposit(iban, depositAmount);
                        System.out.println("Επιτυχης καταθεση: " + depositAmount + ", Νεο Υπολοιπο: " +
                                accountController.getBalance(iban));
                    }
                    case "3" -> {
                        System.out.print("Παρακαλω εισαγετε το iban:");
                        iban = scanner.nextLine().trim();
                        System.out.println("Παρακαλω εισαγετε το ποσο αναληψης");
                        BigDecimal withdrawAmount = new BigDecimal(scanner.nextLine().trim());

                        accountController.withdraw(iban, withdrawAmount);
                        System.out.println("Επιτυχης αναληψη: " + withdrawAmount + ", Νεο Υπολοιπο: " +
                                accountController.getBalance(iban));
                    }
                    case "4" -> {
                        System.out.print("Παρακαλω εισαγετε το iban:");
                        iban = scanner.nextLine().trim();

                        BigDecimal balance = accountController.getBalance(iban);
                        System.out.println("Υπολοιπο: " + balance);
                    }
                    case "5" -> {
                        List<AccountReadOnlyDTO> readOnlyDTOs = accountController.getAllAccounts();

                        if (readOnlyDTOs.isEmpty()) {
                            System.out.println("Δεν βρεθηκαν λογαριασμοι");
                        } else {
                            readOnlyDTOs.forEach(System.out::println);
                        }
                    }
                    case "6" -> {
                        System.out.println("Εξοδος...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Μη εγκυρη επιλογη. Προσπαθηστε ξανα.");
                }
            } catch (AccountNotFoundException e) {
                System.out.println("Ο λογαριασμος δεν βρεθηκε.");
            } catch (NumberFormatException e) {
                System.out.println("Μη εγκυρη μορφη αριθμου.");
            } catch (ValidationException e) {
                System.out.println("Λαθος επαληθευση: " + e.getMessage());;
            } catch (InsufficientBalanceException e) {
                System.out.println("Ανεπαρκες Υπολοιπο.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Υπηρεσια Bank app ===");
        System.out.println("1. Δημιουργια (ή ενημερωση) λογαριασμου");
        System.out.println("2. Καταθεση");
        System.out.println("3. Αναληψη");
        System.out.println("4. Ερωτηση Υπολοιπου");
        System.out.println("5. Εκτυπωση ολων των λογαριασμων");
        System.out.println("6. Εξοδος");
        System.out.println("Εισαγετε μια επιλογη");
    }
}
