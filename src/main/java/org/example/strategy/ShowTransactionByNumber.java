package org.example.strategy;

import org.example.model.Transaction;
import java.util.Scanner;
import static org.example.utils.StrategyUtil.*;

public class ShowTransactionByNumber implements MenuStrategy{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the transaction number: ");
        String transactionNo = scanner.next();
        Transaction transaction = getTransactionByNo(transactionNo);
        System.out.println("--------------------------------------------");
        System.out.println(transaction.getTransactionDetails());
    }
}