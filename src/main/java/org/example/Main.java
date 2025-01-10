package org.example;

import org.example.enums.MenuElements;
import java.util.Scanner;
import static org.example.utils.MenuUtil.*;
import static org.example.utils.BankUtil.*;

public class Main {
    public static void main(String[] args) {
        initializeAllData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                showMenuItems();
                System.out.print("Please select an option: ");
                int option = scanner.nextInt();
                MenuElements menu = getElementByValue(option);
                menu.getStrategy().execute();
            } catch (RuntimeException _) {}
        }
    }
}