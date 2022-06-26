package ru.sber.exceptions;

public class BankOnlineTest {
    public static void main(String[] args) {

        try {
            BankOnline bankOnline = new BankOnline();
            bankOnline.send("1234 5678 9123 4567", 10_000.00);
            bankOnline.send("4728 9329 9320", 10_200.00);
            //bankOnline.send("1111 1111 1111 1111", 1_500.00);
            //bankOnline.send("1234 3123 3354 6854", 60_000.00);
            //bankOnline.send(null, 10_000.00);
            //bankOnline.send("4838 3293 4942 0948", -1.00);

        } catch (NullParameterException exceptionNullParameter) {
            System.out.println(exceptionNullParameter.getMessage());
            exceptionNullParameter.printStackTrace();
        } catch (InvalidCardNumberException exceptionInvalidCardNumber) {
            System.out.println(exceptionInvalidCardNumber.getMessage());
            exceptionInvalidCardNumber.printStackTrace();
        } catch (BlockedCardException exceptionBlockedCard) {
            System.out.println(exceptionBlockedCard.getMessage());
            exceptionBlockedCard.printStackTrace();
        } catch (OutOfLimitTransferException exceptionOutOfLimitTransfer) {
            System.out.println(exceptionOutOfLimitTransfer.getMessage());
            exceptionOutOfLimitTransfer.printStackTrace();
        } catch (NegativeTransferAmountException exceptionNegativeTransferAmount) {
            System.out.println(exceptionNegativeTransferAmount.getMessage());
            exceptionNegativeTransferAmount.printStackTrace();
        }
    }
}

