package org.example.strategy;

import org.example.enums.CardStatus;
import org.example.enums.Currency;
import org.example.model.Card;
import org.example.model.Customer;
import static org.example.utils.StrategyUtil.*;
import static org.example.utils.MenuUtil.*;
import java.util.Scanner;

public class CreateCard implements MenuStrategy {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the customer number: ");
        String customerNo = scanner.next();
        Customer customer = getCustomerByNo(customerNo);
        showCurrencies();
        System.out.print("Please select a currency: ");
        int value = scanner.nextInt();
        Currency currency = getCurrencyByValue(value);
        Card card = new Card(getRandomNumber(16), currency,0D, CardStatus.ACTIVE);
        int percentage = (customer.getCardsCount() / customer.getCards().length) * 100;
        if (percentage >= 80) {
            Card[] cards1 = new Card[customer.getCards().length*2];
            for (int i = 0; i < customer.getCardsCount(); i++) {
                cards1[i] = customer.getCards()[i];
            }
            customer.setCards(cards1);
        }
        customer.getCards()[customer.getCardsCount()] = card;
        customer.setCardsCount(customer.getCardsCount()+1);
        System.out.println("Card number: "+ card.getCardNumber());
    }
}