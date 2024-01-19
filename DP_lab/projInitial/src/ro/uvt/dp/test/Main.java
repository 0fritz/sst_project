package ro.uvt.dp.test;

import ro.uvt.dp.Accounts.*;
import ro.uvt.dp.Commander.AccountCommander;
import ro.uvt.dp.Commander.DeposeOperation;
import ro.uvt.dp.Commander.RetrieveOperation;

public class Main {
    public static void main(String[] args) {
        try {
            Account account = new AccountEUR("123", 1000.0); // Replace with the actual account type

            AccountCommander commander = new AccountCommander();

            // Perform operations using the Command pattern
            commander.setOperation(new DeposeOperation(account, 500.0));
            commander.executeOperation();

            commander.setOperation(new RetrieveOperation(account, 200.0));
            commander.executeOperation();

            System.out.println(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

