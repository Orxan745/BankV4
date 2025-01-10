package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.CardStatus;
import org.example.enums.Currency;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Card implements Serializable {

    private String cardNumber;

    private Currency currency;

    private Double amount;

    private CardStatus status;

    @Override
    public String toString() {
        return "Card number: " + cardNumber + "\n" +
                "Amount fo money: " + amount + "\n" +
                "Currency: " + currency.getDescription() + "\n" +
                "Card status: " + status.getDescription();
    }
}