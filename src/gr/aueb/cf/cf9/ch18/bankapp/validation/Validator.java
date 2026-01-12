package gr.aueb.cf.cf9.ch18.bankapp.validation;

import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountDepositDTO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountInsertDTO;
import gr.aueb.cf.cf9.ch18.bankapp.dto.AccountWithdrawDTO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Validator {

    /**
     * No instances of this class should be available.
     */
    private Validator() {

    }

    public static Map<String, String> validateInsertDTO(AccountInsertDTO insertDto) {
        Map<String, String> errors = new HashMap<>();

        if (insertDto.iban() == null || !insertDto.iban().trim().matches("GR\\d{3,25}")) {
            errors.put("iban", "Το iban πρεπει να ξεκιναει με GR και να ακολουθειται απο 3-25 ψηφια.");
        }

        if (insertDto.balance() == null || insertDto.balance().compareTo(BigDecimal.ZERO) < 0) {
            errors.put("balance", "To υπολοιπο δεν μπορει να ειναι αρνητικο.");
        }
        return errors;
    }

    public static Map<String, String> validateDepositDTO(AccountDepositDTO depositDTO) {
        Map<String, String> errors = new HashMap<>();

        if (depositDTO.iban() == null || !depositDTO.iban().trim().matches("GR\\d{3,25}")) {
            errors.put("iban", "Το iban πρεπει να ξεκιναει με GR και να ακολουθειται απο 3-25 ψηφια.");
        }

        if (depositDTO.amount() == null || depositDTO.amount().compareTo(BigDecimal.ZERO) < 0) {
            errors.put("amount", "To ποσο καταθεσης δεν μπορει να ειναι αρνητικο.");
        }
        return errors;
    }

    public static Map<String, String> validateWithdrawDTO(AccountWithdrawDTO withdrawDTO) {
        Map<String, String> errors = new HashMap<>();

        if (withdrawDTO.iban() == null || !withdrawDTO.iban().trim().matches("GR\\d{3,25}")) {
            errors.put("iban", "Το iban πρεπει να ξεκιναει με GR και να ακολουθειται απο 3-25 ψηφια.");
        }

        if (withdrawDTO.amount() == null || withdrawDTO.amount().compareTo(BigDecimal.ZERO) < 0) {
            errors.put("amount", "To ποσο αναληψης δεν μπορει να ειναι αρνητικο.");
        }
        return errors;
    }

    public static Map<String, String> validateIban(String iban) {
        Map<String, String> errors = new HashMap<>();

        if (iban == null || iban.trim().matches("GR\\d{3,25}")) {
            errors.put("iban", "Το iban πρεπει να ξεκιναει με GR και να ακολουθειται απο 3-25 ψηφια.");
        }
        return errors;
    }

}
