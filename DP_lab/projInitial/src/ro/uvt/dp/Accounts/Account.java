package ro.uvt.dp.Accounts;

import ro.uvt.dp.Decorator.Promotion;

public abstract class Account implements Operations, Promotion {

    protected String accountCode = null;
    protected double amount = 0;
    private Promotion accountPromotion;

    public static enum TYPE {
        EUR, RON
    };

    protected Account(String accNumber, double sum) throws Exception {
        this.accountCode = accNumber;
        depose(sum);
        applyPromotion();
    }

    public static Account createAccount(AccountFactory factory, String accNumber, double sum) throws Exception {
        return factory.createAccount(accNumber, sum);
    }

    @Override
    public double getTotalAmount() {
        return amount + amount * getInterest();
    }

    public void depose(double sum) throws Exception {
        if (sum <= 0)
            throw new Exception("Cannot depose 0 or negative numbers", null);
        this.amount += sum;
    }

    public void retrieve(double sum) throws Exception {
        if (sum >= this.amount)
            throw new Exception("Not enough credits", null);
        if (sum <= 0)
            throw new Exception("Cannot retrieve 0 or negative numbers", null);
        this.amount -= sum;
    }

    public String toString() {
        return "Account: code=" + accountCode + ", amount=" + amount;
    }

    public String getAccountNumber() {
        return accountCode;
    }

    @Override
    public void applyPromotion() {
        System.out.println("Account-level promotion applied for: " + accountCode);
        if (accountPromotion != null) {
            accountPromotion.applyPromotion();
        }
    }

    public void setAccountPromotion(Promotion promotion) {
        accountPromotion = promotion;
    }

    public Promotion getAccountPromotion() {
        return accountPromotion;
    }
}
