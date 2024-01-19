package ro.uvt.dp.Decorator;

import ro.uvt.dp.Accounts.Account;

public class ChildrenAccountPromotion implements Promotion {
    private Account account;

    public ChildrenAccountPromotion(Account account) {
        this.account = account;
        applyPromotion();
    }

    @Override
    public void applyPromotion() {
        System.out.println("Children Account Promotion applied for the account: " + account.getAccountNumber());
    }
}
