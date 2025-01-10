package org.example.strategy;

import static org.example.utils.FileUtils.*;
import static org.example.constants.FileConstants.*;
import static org.example.model.Bank.*;

public class Exit implements MenuStrategy{
    @Override
    public void execute() {
        writeObjectToFile(CUSTOMER_FILE_NAME, customers);
        writeObjectToFile(TRANSACTION_FILE_NAME, transactions);
        System.exit(0);
    }
}
