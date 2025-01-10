package org.example.strategy;

import org.example.model.Customer;
import java.util.Scanner;
import static org.example.model.Bank.*;
import static org.example.utils.StrategyUtil.*;

public class CreateCustomer implements MenuStrategy {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the customer: ");
        String name = scanner.next();
        System.out.print("Please enter the surname of the customer: ");
        String surname = scanner.next();
        Customer customer = new Customer(name, surname);
        customer.setCustomerNo(getRandomNumber(7));
        int percentage = (customersLength / customers.length) * 100;
        if (percentage >= 80) {
            Customer[] customers1 = new Customer[customers.length*2];
            for (int i = 0; i < customers.length; i++) {
                customers1[i] = customers[i];
            }
            customers = customers1;
        }
        customers[customersLength++] = customer;
        System.out.println("Customer number: " + customer.getCustomerNo());
    }
}