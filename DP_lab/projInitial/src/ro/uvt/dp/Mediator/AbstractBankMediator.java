package ro.uvt.dp.Mediator;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Bank.Bank;
import ro.uvt.dp.Client.Client;

public interface AbstractBankMediator {
    void sendMessage(Bank sender, String message);
    void addAccount(Account account);
    void removeClient(Client client);
    void addClient(Client client);
}


