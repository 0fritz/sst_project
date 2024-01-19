package ro.uvt.dp.Decorator;

import ro.uvt.dp.Accounts.Account;

public class EconomyAccountPromotion implements Promotion {
    private Account account;

    public EconomyAccountPromotion(Account account) {
        this.account = account;
        applyPromotion();
    }

    @Override
    public void applyPromotion() {
        System.out.println("Economy Account Promotion applied for the account: " + account.getAccountNumber());
    }
}
