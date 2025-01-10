package org.example.strategy;

import org.example.model.Customer;
import java.util.Scanner;
import static org.example.utils.StrategyUtil.*;
import static org.example.model.Bank.*;

public class RemoveCustomer implements MenuStrategy {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the customer number: ");
        String customerNo = scanner.next();
        Customer customer = getCustomerByNo(customerNo);
        for (int i = 0; i < customersLength; i++) {
            if (customer == customers[i]) {
                customers[i] = null;
                for (int j = 0; j < customersLength; j++) {
                    customers[i+j] = customers[i+j+1];
                    customers[i+j+1] = null;
                }
                break;
            }
        }
        customersLength--;
        System.out.println("--------------------------------------------");
        System.out.println("Customer removed successfully!");
    }
}