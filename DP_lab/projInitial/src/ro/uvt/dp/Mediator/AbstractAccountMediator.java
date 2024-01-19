package ro.uvt.dp.Mediator;

import ro.uvt.dp.Client.Client;

public interface AbstractAccountMediator {
    void sendMessage(Client sender, String message);
}
