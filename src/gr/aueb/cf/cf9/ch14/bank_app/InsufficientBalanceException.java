package gr.aueb.cf.cf9.ch14.bank_app;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
