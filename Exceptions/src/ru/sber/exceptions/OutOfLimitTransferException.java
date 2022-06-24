package ru.sber.exceptions;

public class OutOfLimitTransferException extends BankOnlineException {
    public OutOfLimitTransferException(String message) {
        super(message);
    }
}
