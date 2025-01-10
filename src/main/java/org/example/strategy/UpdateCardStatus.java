package org.example.strategy;

import org.example.enums.CardStatus;
import org.example.model.Card;
import org.example.model.Customer;
import java.util.Scanner;
import static org.example.utils.StrategyUtil.*;
import static org.example.utils.MenuUtil.*;

public class UpdateCardStatus implements MenuStrategy{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the customer number: ");
        String customerNo = scanner.next();
        Customer customer = getCustomerByNo(customerNo);
        System.out.print("Please enter the card number: ");
        String cardNo = scanner.next();
        Card card = getCardByNo(customer, cardNo);
        System.out.println("--------------------------------------------");
        System.out.println("Card status: " + card.getStatus());
        showCardStatuses();
        System.out.print("Please set the card status: ");
        int value = scanner.nextInt();
        CardStatus status = getCardStatusByValue(value);
        card.setStatus(status);
    }
}