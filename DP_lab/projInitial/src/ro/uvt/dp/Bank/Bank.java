package ro.uvt.dp.Bank;

import java.util.ArrayList;
import java.util.List;

import ro.uvt.dp.Client.Client;

public class Bank {

//    private final static int MAX_CLIENTS_NUMBER = 100;
    private List<Client> clients;
    private String bankCode = null;

    public Bank(String bankCode) {
        this.bankCode = bankCode;
        clients = new ArrayList<>();
    }

    public void addClient(Client c) {
        clients.add(c);
    }

	public void deleteClient(Client x) {
		clients.remove(x);
	}

    public Client getClient(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    public String getCode(){
        return bankCode;
    }

    @Override
    public String toString() {
        return "Bank [code=" + bankCode + ", clients=" + clients + "]";
    }
}

