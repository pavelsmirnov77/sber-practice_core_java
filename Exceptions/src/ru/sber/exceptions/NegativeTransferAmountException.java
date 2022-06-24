package ru.sber.exceptions;

public class NegativeTransferAmountException extends BankOnlineException {
    public NegativeTransferAmountException(String message) {
        super(message);
    }
}
