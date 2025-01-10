package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class Transaction implements Serializable {

    private String transactionNo;

    private LocalDateTime transactionTime = LocalDateTime.now();

    private String senderNumber;

    private String transactionDetails;

    public Transaction(String transactionNo, String senderNumber) {
        this.transactionNo = transactionNo;
        this.senderNumber = senderNumber;
    }

    @Override
    public String toString() {
        return transactionDetails;
    }
}