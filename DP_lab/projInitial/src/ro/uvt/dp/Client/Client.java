package ro.uvt.dp.Client;

import java.util.LinkedList;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Accounts.AccountEUR;
import ro.uvt.dp.Accounts.AccountRON;
import ro.uvt.dp.Accounts.Account.TYPE;
import ro.uvt.dp.Decorator.Promotion;


public class Client implements Promotion {
	public static final int NUMAR_MAX_CONTURI = 5;

	private String name;
	private String address;
	private LinkedList<Account> accounts;
	private LinkedList<Promotion> clientPromotions;


	public Client(String name, String address, TYPE type, String accNumber, double sum) throws Exception {
		this.name = name;
		this.address = address;
		accounts = new LinkedList<Account>();
		addAccount(type, accNumber, sum);
		clientPromotions = new LinkedList<>();
        applyPromotion();
	}

	public void addAccount(TYPE type, String accNumber, double sum) throws Exception {
		Account account = null;
        if (type == Account.TYPE.EUR)
            account = new AccountEUR(accNumber, sum);
        else if (type == Account.TYPE.RON)
            account = new AccountRON(accNumber, sum);

        if (account != null && accounts.size() < NUMAR_MAX_CONTURI) {
            accounts.add(account);
        } else {
            throw new Exception("Cannot add more accounts.");
        }
	}

	public Account getAccount(String accountCode) {
		for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountCode)) {
                return account;
            }
        }
		return null;
	}

	@Override
	public String toString() {
		return "\n\tClient [name=" + name + ", address=" + address + ", acounts=" + accounts.toString() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public void applyPromotion() {
        System.out.println("Client-level promotion applied for: " + name);
        clientPromotions.forEach(Promotion::applyPromotion);
    }

    public void addClientPromotion(Promotion promotion) {
        clientPromotions.add(promotion);
    }

    public LinkedList<Promotion> getClientPromotions() {
        return clientPromotions;
    }


}
