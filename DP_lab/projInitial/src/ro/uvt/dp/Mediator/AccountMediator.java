package ro.uvt.dp.Mediator;

import java.util.List;

import ro.uvt.dp.Client.Client;

public class AccountMediator implements AbstractAccountMediator {
    private List<String> messages;


    @Override
    public void sendMessage(Client sender, String message) {
        if (sender instanceof Client) {
            Client account = (Client) sender;
            System.out.println("Account " + account.getName() + " sending message: " + message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }
}

