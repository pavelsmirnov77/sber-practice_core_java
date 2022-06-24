package ru.sber.exceptions;

public class NullParameterException extends BankOnlineException {
    public NullParameterException(String message) {
        super(message);
    }
}
