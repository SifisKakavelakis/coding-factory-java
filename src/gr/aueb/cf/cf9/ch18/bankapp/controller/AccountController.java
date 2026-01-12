package gr.aueb.cf.cf9.ch18.bankapp.controller;

import gr.aueb.cf.cf9.ch18.bankapp.core.exceptions.AccountNotFoundException;
import gr.aueb.cf.cf9.ch18.bankapp.core.exceptions.InsufficientBalanceException;
import gr.aueb.cf.cf9.ch18.bankapp.core.exceptions.ValidationException;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountDepositDTO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountInsertDTO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountReadOnlyDTO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountWithdrawDTO;
import gr.aueb.cf.cf9.ch18.bankapp.model.Account;
import gr.aueb.cf.cf9.ch18.bankapp.service.IAccountService;
import gr.aueb.cf.cf9.ch18.bankapp.validation.Validator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class AccountController {

    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    public AccountReadOnlyDTO createNewAccount(String iban, BigDecimal balance)
            throws ValidationException {
        AccountReadOnlyDTO readOnlyDTO;
        AccountInsertDTO insertDTO = new AccountInsertDTO(iban, balance);

        // Validation
        Map<String, String> errors;
        errors = Validator.validateInsertDTO(insertDTO);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }

        // Proceed to service layer
        readOnlyDTO = accountService.createNewAccount(insertDTO);
        return readOnlyDTO;
    }

    public void deposit(String iban, BigDecimal amount)
            throws AccountNotFoundException, ValidationException {

        AccountDepositDTO depositDTO = new AccountDepositDTO(iban, amount);

        // Validation
        Map<String, String> errors;
        errors = Validator.validateDepositDTO(depositDTO);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }

        accountService.deposit(depositDTO);
    }

    public void withdraw(String iban, BigDecimal amount)
            throws AccountNotFoundException, ValidationException, InsufficientBalanceException {

        AccountWithdrawDTO withdrawDTO = new AccountWithdrawDTO(iban, amount);

        // Validation
        Map<String, String> errors;
        errors = Validator.validateWithdrawDTO(withdrawDTO);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }

        accountService.withdraw(withdrawDTO);
    }

    public BigDecimal getBalance(String iban)
            throws AccountNotFoundException, ValidationException {

        // Validation
        Map<String, String> errors;
        errors = Validator.validateIban(iban);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }

        return accountService.getBalance(iban);
    }

    public List<AccountReadOnlyDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
