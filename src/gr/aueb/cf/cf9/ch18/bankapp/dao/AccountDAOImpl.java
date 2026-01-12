package gr.aueb.cf.cf9.ch18.bankapp.dao;

import gr.aueb.cf.cf9.ch18.bankapp.model.Account;

import java.util.*;

public class AccountDAOImpl implements IAccountDAO {
    private final List<Account> accounts = new ArrayList<>();

    @Override
    public Account saveOrUpdate(Account account) {
        int index = accounts.indexOf(account);  // override equals

        if (index == -1) {                      // Αν δεν υπάρχει στη λίστα
            accounts.add(account);              // τότε κάνε insert
            return account;
        }

        // Αν υπάρχει ήδη το Account
        accounts.set(index, account);           // τότε κάνε update
        return accounts.get(index);
    }

    @Override
    public void remove(String iban) {
        accounts.removeIf(account -> account.getIban().equals(iban));
    }

    @Override
    public Optional<Account> findByIban(String iban) {
        return accounts.stream()
                .filter(account -> account.getIban().equals(iban))
                .findFirst();
    }

    @Override
    public List<Account> getAllAccounts() {
        // return accounts;
        // return new ArrayList<>(accounts);
        return Collections.unmodifiableList(accounts);
        // return List.copyOf(accounts);
    }

    @Override
    public boolean isAccountExists(String iban) {
        return accounts.stream()
                .anyMatch(account -> account.getIban().equals(iban));
    }

    public long count() {
        return accounts.size();
    }
}