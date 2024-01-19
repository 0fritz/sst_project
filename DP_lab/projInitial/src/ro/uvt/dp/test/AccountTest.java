package ro.uvt.dp.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Accounts.AccountFactory;
import ro.uvt.dp.Accounts.AccountFactoryEUR;

public class AccountTest {
    @Test
    public void testAccountOperations() {
        try {
            AccountFactory eurFactory = new AccountFactoryEUR();
            Account eurAccount = Account.createAccount(eurFactory, "EUR123", 1000.0);

            eurAccount.depose(500.0);
            assertEquals(1530.0, eurAccount.getTotalAmount(), 0.001);

            eurAccount.retrieve(200.0);
            assertEquals(1326.0, eurAccount.getTotalAmount(), 0.001);
        } catch (Exception e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }
}
