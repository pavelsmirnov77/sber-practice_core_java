package ru.sber.exceptions;

public class BlockedCardException extends BankOnlineException {
    public BlockedCardException(String message) {
        super(message);
    }
}
