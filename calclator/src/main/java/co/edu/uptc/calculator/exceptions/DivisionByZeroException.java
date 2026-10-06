package co.edu.uptc.calculator.exceptions;

public class DivisionByZeroException extends RuntimeException {

    public DivisionByZeroException(String message) {
        super(message);
    }
}