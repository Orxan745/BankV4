package org.example.enums;

import lombok.Getter;
import org.example.strategy.*;

@Getter
public enum MenuElements {
    CREATE_CUSTOMER(1, "Create customer", new CreateCustomer()),
    UPDATE_CUSTOMER(2, "Update customer", new UpdateCustomer()),
    REMOVE_CUSTOMER(3, "Remove customer", new RemoveCustomer()),
    CREATE_CARD(4, "Create card", new CreateCard()),
    UPDATE_CARD(5, "Update card", new UpdateCard()),
    UPDATE_CARD_STATUS(6, "Update card status", new UpdateCardStatus()),
    CARD_TO_CARD(7, "Money transfer", new CardToCard()),
    SHOW_ALL_CUSTOMERS(8, "Show all customers", new ShowAllCustomers()),
    SHOW_ALL_CUSTOMER_CARDS(9, "Show all customer cards", new ShowAllCards()),
    SHOW_TRANSACTION_BY_NUMBER(10, "Show transaction by number", new ShowTransactionByNumber()),
    SHOW_ALL_CUSTOMER_TRANSACTIONS(11, "Show all customer transactions", new ShowAllCustomerTransactions()),
    EXIT(12, "Exit", new Exit());
    private final int value;
    private final String description;
    private final MenuStrategy strategy;

    MenuElements(int value, String description, MenuStrategy strategy) {
        this.value = value;
        this.description = description;
        this.strategy = strategy;
    }
}