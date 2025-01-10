package org.example.utils;

import org.example.model.Card;
import org.example.model.Customer;
import org.example.model.Transaction;
import java.util.Random;
import static org.example.model.Bank.*;

public class StrategyUtil {

    public static String getRandomNumber(int numberLength) {
        Random random = new Random();
        int a;
        char b;
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < numberLength; i++) {
            a = random.nextInt(48, 58);
            b = (char) a;
            number.append(b);
        }
        return number.toString();
    }

    public static Customer getCustomerByNo(String customerNo) {
        try {
            for (int i = 0; i < customersLength; i++) {
                if (customers[i].getCustomerNo().equals(customerNo)) {
                    return customers[i];
                }
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid customer number: " + customerNo);
        }
        throw new RuntimeException();
    }

    public static Card getCardByNo(Customer customer, String cardNo) {
        try {
            for (Card card : customer.getCards()) {
                if (card.getCardNumber().equals(cardNo)) {
                    return card;
                }
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid card number: " + cardNo);
        }
        throw new RuntimeException();
    }

    public static Transaction getTransactionByNo(String transactionNo) {
        try {
            for (Transaction transaction : transactions) {
                if (transaction.getTransactionNo().equals(transactionNo)) {
                    return transaction;
                }
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid transaction number: " + transactionNo);
        }
        throw new RuntimeException();
    }

    public static Double currencyTransformation(Card sender, Card receiver, Double amount) {
        Double transformedAmount = amount * sender.getCurrency().getDollarAmount();
        transformedAmount = transformedAmount / receiver.getCurrency().getDollarAmount();
        return transformedAmount;
    }
}