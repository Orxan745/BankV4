package org.example.strategy;

import org.example.enums.CardStatus;
import org.example.model.Card;
import org.example.model.Customer;
import org.example.model.Transaction;
import java.util.Scanner;
import static org.example.utils.StrategyUtil.*;
import static org.example.utils.BankUtil.*;

public class CardToCard implements MenuStrategy{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the sender number: ");
        String customerNoFrom = scanner.next();
        System.out.print("Please enter the card number: ");
        String cardNoFrom = scanner.next();
        System.out.print("Please enter the receiver number: ");
        String customerNoTo = scanner.next();
        System.out.print("Please enter the card number: ");
        String cardNoTo = scanner.next();
        Customer customerFrom = getCustomerByNo(customerNoFrom);
        Customer customerTo = getCustomerByNo(customerNoTo);
        Card cardFrom = getCardByNo(customerFrom, cardNoFrom);
        Card cardTo = getCardByNo(customerTo, cardNoTo);
        try {
            if (cardFrom.getStatus() != CardStatus.BLOCKED && cardTo.getStatus() != CardStatus.BLOCKED) {
                System.out.print("Please enter the amount of money: ");
                Double amount = scanner.nextDouble();
                Double transformedAmount = currencyTransformation(cardFrom, cardTo, amount);
                try {
                    if (amount <= cardFrom.getAmount()) {
                        cardFrom.setAmount(cardFrom.getAmount() - amount);
                        cardTo.setAmount(cardTo.getAmount() + transformedAmount);
                        System.out.println("Money sent successfully!");
                        Transaction transaction = new Transaction(getRandomNumber(9), customerNoFrom);
                        addTransaction(transaction);
                        System.out.println("Transaction number: " + transaction.getTransactionNo());
                        String transactionDetails = "Transaction number: " + transaction.getTransactionNo() + "\n" +
                                "Sender number: " + customerNoFrom + "\n" +
                                "Sender card: " + cardNoFrom + "\n" +
                                "Receiver number: " + customerNoTo + "\n" +
                                "Receiver card: " + cardNoTo + "\n" +
                                "Amount of money: " + amount + cardFrom.getCurrency().getDescription() + "\n" +
                                "Date and time of transaction: " + transaction.getTransactionTime();
                        transaction.setTransactionDetails(transactionDetails);

                    } else throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid amount of money: There is not enough money on the card!");
                }
            } else throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: One of the cards in transfer is blocked!");
        }
    }
}