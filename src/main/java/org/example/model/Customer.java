package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Customer implements Serializable {
    private String customerNo;

    private String name;

    private String surname;

    private Card [] cards = new Card[10];

    private Integer cardsCount = 0;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name: "+this.name+"\n" +
                "Surname: "+this.surname+"\n" +
                "Cards: "+cardsCount;
    }
}