package org.example.strategy;

import java.util.Scanner;
import org.example.model.Customer;
import static org.example.utils.StrategyUtil.*;

public class ShowAllCards implements MenuStrategy{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the customer number: ");
        String customerNo = scanner.next();
        Customer customer = getCustomerByNo(customerNo);
        System.out.println("--------------------------------------------");
        for (int i = 0; i < customer.getCardsCount(); i++) {
            System.out.println((i+1)+"."+customer.getCards()[i]);
            System.out.println();
        }
    }
}