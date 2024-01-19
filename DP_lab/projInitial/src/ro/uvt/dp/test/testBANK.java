package ro.uvt.dp.test;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Bank.Bank;
import ro.uvt.dp.Client.Client;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

//not sure if this test is necessary because it seems trivial
public class testBANK {

    @Test
    public void testAddClientGetClient() throws Exception {
        Bank bank = new Bank("0");
        Client x = new Client("Sef","Pandurilor", Account.TYPE.RON, "202", 100);
        bank.addClient(x);
        assertEquals("DONE", x, bank.getClient("Sef"));
    }

    @Test
    public void testGetClient() throws Exception {
        Bank bank = new Bank("ABC");
        Client client = new Client("Sef","Pandurilor", Account.TYPE.RON, "202", 100);

        bank.addClient(client);

        assertEquals(client, bank.getClient("Sef"));
    }

    @Test
    public void testGetCode() {
        Bank bank = new Bank("ABC");

        assertEquals("ABC", bank.getCode());
    }

    @Test
    public void testToString() throws Exception {
        Bank bank = new Bank("ABC");
        Client client1 = new Client("Sef","Pandurilor", Account.TYPE.RON, "202", 100);
        Client client2 = new Client("Bro","Pandurilor", Account.TYPE.RON, "203", 100);

        bank.addClient(client1);
        bank.addClient(client2);

        String expected = "Bank [code=ABC, clients=[" + client1.toString() + ", " + client2.toString() + "]]";

        assertEquals(expected, bank.toString());
    }
}
