package org.example.strategy;

import org.example.model.Customer;
import java.util.Scanner;
import static org.example.utils.StrategyUtil.*;

public class UpdateCustomer implements MenuStrategy {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the customer number: ");
        String customerNo = scanner.next();
        Customer customer = getCustomerByNo(customerNo);
        System.out.print("Please enter the new name: ");
        String name = scanner.next();
        System.out.print("Please enter the new surname: ");
        String surname = scanner.next();
        customer.setName(name);
        customer.setSurname(surname);
        System.out.println("--------------------------------------------");
        System.out.println("Customer updated successfully!");
    }
}
