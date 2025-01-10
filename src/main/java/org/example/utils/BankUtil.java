package org.example.utils;

import org.example.model.Customer;
import org.example.model.Transaction;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import static org.example.model.Bank.*;
import static org.example.constants.FileConstants.*;
import static org.example.utils.FileUtils.readObjectFromFile;

public class BankUtil {

    public static void addTransaction(Transaction transaction) {
        int percentage = (transactionsLength / transactions.length ) * 100;
        if (percentage >= 80) {
            Transaction[] transactions1 = new Transaction[transactions.length*2];
            for (int i = 0; i < transactionsLength; i++) {
                transactions1[i] = transactions[i];
            }
            transactions = transactions1;
        }
        transactions[transactionsLength++] = transaction;
    }

    public static void initializeCustomerData() {
        try {
            Object object = readObjectFromFile(CUSTOMER_FILE_NAME);
            if (Objects.nonNull(object)) {
                customers = (Customer[]) object;
            }
        } catch (EOFException e) {
            System.out.println("Customer file is empty!");
        } catch (IOException | ClassNotFoundException _) {}

        int length = 0;
        for (Customer customer : customers) {
            if (Objects.nonNull(customer)) {
                length++;
            }
        }
        customersLength = length;
    }

    public static void initializeTransactionData() {
        try {
            Object object = readObjectFromFile(TRANSACTION_FILE_NAME);
            if (Objects.nonNull(object)) {
                transactions = (Transaction[]) object;
            }
        } catch (EOFException e) {
            System.out.println("Transaction file is empty!");
        } catch (IOException | ClassNotFoundException _) {}

        int length = 0;
        for (Transaction transaction : transactions) {
            if (Objects.nonNull(transaction)) {
                length++;
            }
        }
        transactionsLength = length;
    }

    public static void initializeAllData() {
        initializeCustomerData();
        initializeTransactionData();
    }
}