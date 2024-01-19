package ro.uvt.dp.Commander;

import ro.uvt.dp.Accounts.Account;
import ro.uvt.dp.Accounts.AccountOperation;

public class DeposeOperation implements AccountOperation {
    private Account account;
    private double amount;

    public DeposeOperation(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() throws Exception {
        account.depose(amount);
    }
}
