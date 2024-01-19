package ro.uvt.dp.Mediator;

import java.util.ArrayList;
import java.util.List;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Bank.Bank;
import ro.uvt.dp.Client.Client;

public class BankMediator implements AbstractBankMediator {
    private List<Client> clients;
    private List<Account> accounts;
    private List<String> messages;

    public BankMediator() {
        this.clients = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    @Override
    public void sendMessage(Bank sender, String message) {
        
        System.out.println(sender.getCode() + "sent a message.");
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<String> getMessages() {
        return messages;
    }
}

