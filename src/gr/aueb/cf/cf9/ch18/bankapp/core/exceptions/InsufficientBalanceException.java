package gr.aueb.cf.cf9.ch18.bankapp.core.exceptions;

public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
