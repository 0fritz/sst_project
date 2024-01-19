package ro.uvt.dp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Client.Client;
import ro.uvt.dp.Client.ClientBuilderImpl;

public class testLab3 {
    @Test
    public void testClientBuilder() {
        try {
            ClientBuilderImpl clientBuilder = new ClientBuilderImpl();

            // Use the builder pattern to set properties
            clientBuilder.setName("John Doe")
                    .setAddress("123 Main St")
                    .setType(Account.TYPE.EUR)
                    .setAccountsNr("EUR123")
                    .setSum(1000.0);

            // Build the Client object
            Client client2 = clientBuilder.build();

            // Add assertions to test the client object
            assertEquals("John Doe", client2.getName());
            // Add more assertions as needed

            System.out.println(client2.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
