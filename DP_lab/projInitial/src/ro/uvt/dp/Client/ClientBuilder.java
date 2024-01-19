package ro.uvt.dp.Client;

import ro.uvt.dp.Accounts.Account;

public interface ClientBuilder {
    ClientBuilder setName(String name);
    ClientBuilder setAddress(String address);
    ClientBuilder setType(Account.TYPE type);
    ClientBuilder setAccountsNr(String accNumber);
    ClientBuilder setSum(double sum);
    Client build() throws Exception;
}
