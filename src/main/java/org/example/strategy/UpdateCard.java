package org.example.strategy;

import java.util.Scanner;
import org.example.enums.CardStatus;
import org.example.enums.Currency;
import org.example.model.Card;
import org.example.model.Customer;
import static org.example.utils.MenuUtil.*;
import static org.example.utils.StrategyUtil.*;

public class UpdateCard implements MenuStrategy{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the customer number: ");
        String customerNo = scanner.next();
        Customer customer = getCustomerByNo(customerNo);
        System.out.print("Please enter the card number: ");
        String cardNo = scanner.next();
        Card card = getCardByNo(customer, cardNo);
        try {
            if (card.getStatus() != CardStatus.BLOCKED) {
                showCurrencies();
                System.out.print("Please select the new currency: ");
                int value = scanner.nextInt();
                Currency currency = getCurrencyByValue(value);
                card.setCurrency(currency);
                System.out.print("Please enter the amount of money you want to add: ");
                Double amount = scanner.nextDouble();
                card.setAmount(card.getAmount() + amount);
                System.out.println("Card updated successfully!");
            } else throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Exception occurred: Your card is blocked!");
        }
    }
}