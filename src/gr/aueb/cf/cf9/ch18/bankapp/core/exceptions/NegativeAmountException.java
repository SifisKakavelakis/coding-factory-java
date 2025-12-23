package gr.aueb.cf.cf9.ch18.bankapp.core.exceptions;

public class NegativeAmountException extends Exception{

    public NegativeAmountException(String message) {
        super(message);
    }
}
