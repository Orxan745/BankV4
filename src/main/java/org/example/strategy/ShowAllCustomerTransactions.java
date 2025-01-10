package org.example.strategy;

import org.example.model.Transaction;
import java.util.Scanner;
import static org.example.model.Bank.*;

public class ShowAllCustomerTransactions implements MenuStrategy{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the customer number: ");
        String customerNo = scanner.next();
        for (int i = 0; i < transactionsLength; i++) {
            Transaction transaction = transactions[i];
            if (transaction.getSenderNumber().equals(customerNo)) {
                System.out.println();
                System.out.println(transaction);
            }
        }
    }
}