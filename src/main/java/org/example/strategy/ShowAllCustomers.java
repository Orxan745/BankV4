package org.example.strategy;

import static org.example.model.Bank.*;

public class ShowAllCustomers implements MenuStrategy {
    @Override
    public void execute() {
        System.out.println("--------------------------------------------");
        for (int i = 0; i < customersLength; i++) {
            System.out.println((i+1) + ". " + customers[i]);
            System.out.println();
        }
    }
}