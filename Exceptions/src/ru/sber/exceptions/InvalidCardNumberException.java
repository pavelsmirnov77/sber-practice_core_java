package ru.sber.exceptions;

public class InvalidCardNumberException extends BankOnlineException {
    public InvalidCardNumberException(String message) {
        super(message);
    }
}
