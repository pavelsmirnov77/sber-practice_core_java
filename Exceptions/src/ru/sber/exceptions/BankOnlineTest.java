package ru.sber.exceptions;

public class BankOnlineTest {
    public static void main(String[] args) {
        BankOnline bankOnline = new BankOnline();

        String firstCardName = "1234 5678 9123 4567";
        String secondCardName = "4213 4342 3434";
        String thirdCardName = "5328 1923 0120 2391";
        String fourthCardName = "4832 3123 0430 3213";
        String blockedCardName = "1111 1111 1111 1111";

        bankOnline.send(firstCardName, 10_000.00);
        bankOnline.send(secondCardName, 1_000.00);
        bankOnline.send(thirdCardName, -1.00);
        bankOnline.send(fourthCardName, 60_000.00);
        bankOnline.send(blockedCardName, 500.00);
        bankOnline.send(null, 50.00);
    }

}
