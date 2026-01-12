package gr.aueb.cf.cf9.ch18.bankapp.service;

import gr.aueb.cf.cf9.ch14.bank_app.InsufficientBalanceException;
import gr.aueb.cf.cf9.ch18.bankapp.core.exceptions.AccountNotFoundException;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountDepositDTO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountInsertDTO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountReadOnlyDTO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountWithdrawDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountService {
    AccountReadOnlyDTO createNewAccount(AccountInsertDTO insertDTO);
    void deposit(AccountDepositDTO depositDTO) throws AccountNotFoundException;
    void withdraw(AccountWithdrawDTO withdrawDTO) throws InsufficientBalanceException, AccountNotFoundException;
    BigDecimal getBalance(String iban) throws AccountNotFoundException;
    List<AccountReadOnlyDTO> getAllAccounts();
}