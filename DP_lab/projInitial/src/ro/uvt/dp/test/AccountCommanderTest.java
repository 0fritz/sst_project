package ro.uvt.dp.test;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Accounts.AccountEUR;
import ro.uvt.dp.Commander.AccountCommander;
import ro.uvt.dp.Commander.DeposeOperation;
import ro.uvt.dp.Commander.RetrieveOperation;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountCommanderTest {

    @Test
    public void testDeposeOperation() {
        try {
            // Create an account
            Account account = new AccountEUR("123", 1000.0);

            // Create an AccountCommander
            AccountCommander commander = new AccountCommander();

            // Perform deposing operation
            commander.setOperation(new DeposeOperation(account, 500.0));
            commander.executeOperation();

            // Verify the result
            assertEquals(1530.0, account.getTotalAmount(), 0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRetrieveOperation() {
        try {
            // Create an account
            Account account = new AccountEUR("123", 1000.0);

            // Create an AccountCommander
            AccountCommander commander = new AccountCommander();

            // Perform retrieving operation
            commander.setOperation(new RetrieveOperation(account, 200.0));
            commander.executeOperation();

            // Verify the result
            assertEquals(816.0, account.getTotalAmount(), 0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMultipleOperations() {
        try {
            // Create an account
            Account account = new AccountEUR("123", 1000.0);

            // Create an AccountCommander
            AccountCommander commander = new AccountCommander();

            // Perform deposing operation
            commander.setOperation(new DeposeOperation(account, 500.0));
            commander.executeOperation();

            // Perform retrieving operation
            commander.setOperation(new RetrieveOperation(account, 200.0));
            commander.executeOperation();

            // Perform another deposing operation
            commander.setOperation(new DeposeOperation(account, 300.0));
            commander.executeOperation();

            // Verify the final result
            assertEquals(1632.0, account.getTotalAmount(), 0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

