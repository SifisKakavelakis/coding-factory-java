package gr.aueb.cf.cf9.ch14.bank_app;

public class NegativeAmountException extends Exception {

    public NegativeAmountException(String message) {
        super(message);
    }
}
