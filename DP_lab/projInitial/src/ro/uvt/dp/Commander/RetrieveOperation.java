package ro.uvt.dp.Commander;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Accounts.AccountOperation;

public class RetrieveOperation implements AccountOperation {
    private Account account;
    private double amount;

    public RetrieveOperation(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() throws Exception {
        account.retrieve(amount);
    }
}
