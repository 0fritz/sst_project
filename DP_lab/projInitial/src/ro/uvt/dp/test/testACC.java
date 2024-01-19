package ro.uvt.dp.test;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Accounts.AccountRON;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testACC {

    @Test
    public void testDepose() throws Exception {
        Account account = new AccountRON("123", 1000);
        account.depose(500);
        assertEquals(1500 + 1500 * 0.08, account.getTotalAmount(), 0.001);
    }

    @Test(expected = Exception.class)
    public void testDeposeNegativeAmount() throws Exception {
        Account account = new AccountRON("123", 1000);
        account.depose(-500); // Should throw an exception
    }

    @Test
    public void testRetrieve() throws Exception {
        Account account = new AccountRON("123", 1000);
        account.retrieve(500);
        assertEquals(500 + 500 * 0.08, account.getTotalAmount(), 0.001);
    }

    @Test(expected = Exception.class)
    public void testRetrieveNegativeAmount() throws Exception {
        Account account = new AccountRON("123", 1000);
        account.retrieve(-500); // Should throw an exception
    }

    @Test(expected = Exception.class)
    public void testRetrieveMoreThanBalance() throws Exception {
        Account account = new AccountRON("123", 1000);
        account.retrieve(1500); // Should throw an exception
    }

    @Test
    public void testGetTotalAmount() throws Exception {
        Account account = new AccountRON("123", 1000);
        double interest = account.getInterest();
        double expectedTotalAmount = 1000 + 1000 * interest;
        assertEquals(expectedTotalAmount, account.getTotalAmount(), 0.001);
    }

    @Test
    public void testAccountToString() throws Exception {
        Account account = new AccountRON("123", 1000);
        String expectedString = "Account RON [Account: code=123, amount=1000.0]";
        assertEquals(expectedString, account.toString());
    }
}
