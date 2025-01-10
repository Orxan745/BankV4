package org.example.utils;

import org.example.enums.CardStatus;
import org.example.enums.Currency;
import org.example.enums.MenuElements;

public class MenuUtil {

    public static void showMenuItems() {
        System.out.println("--------------------------------------------");
        for (MenuElements element : MenuElements.values()) {
            System.out.println(element.getValue() + "." + element.getDescription());
        }
        System.out.println("--------------------------------------------");
    }

    public static void showCurrencies() {
        System.out.println("--------------------------------------------");
        for (Currency currency : Currency.values()) {
            System.out.println(currency.getValue() + "." + currency.getDescription());
        }
    }

    public static void showCardStatuses() {
        System.out.println("--------------------------------------------");
        System.out.println("1.Activate" + "\n" +
                "2.Block");
    }

    public static MenuElements getElementByValue(int value) {
        try {
            for (MenuElements element : MenuElements.values()) {
                if (element.getValue() == value) {
                    return element;
                }
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid option: " + value);
            System.out.println("Try again!");
        }
        throw new RuntimeException();
    }

    public static Currency getCurrencyByValue(int value) {
        try {
            for (Currency currency : Currency.values()) {
                if (currency.getValue() == value) {
                    return currency;
                }
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument: Wrong currency!");
        }
        throw new RuntimeException();
    }

    public static CardStatus getCardStatusByValue(int value) {
        try {
            for (CardStatus status : CardStatus.values()) {
                if (status.getValue() == value) {
                    return status;
                }
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument: Wrong status!");
        }
        throw new RuntimeException();
    }
}