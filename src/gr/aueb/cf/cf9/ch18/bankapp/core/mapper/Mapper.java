package gr.aueb.cf.cf9.ch18.bankapp.core.mapper;

import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountInsertDTO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountReadOnlyDTO;
import gr.aueb.cf.cf9.ch18.bankapp.model.Account;

public class Mapper {

    /**
     * No instances of this class should be available.
     */
    private Mapper() {
    }

    public static Account mapToModelEntity(AccountInsertDTO dto) {
        return new Account(dto.iban(), dto.balance());
    }

    public static AccountReadOnlyDTO mapToReadOnlyDTO(Account account) {
        return new AccountReadOnlyDTO(account.getIban(), account.getBalance());
    }
}