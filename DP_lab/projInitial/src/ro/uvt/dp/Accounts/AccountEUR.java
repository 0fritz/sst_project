package ro.uvt.dp.Accounts;

public class AccountEUR extends Account {

    public AccountEUR(String accNumber, double sum) throws Exception {
        super(accNumber, sum);
    }

    @Override
    public double getInterest() {
        return 0.02; // EUR accounts have a 2% interest rate
    }

    // Implement the depose(double) method from Operations interface
    @Override
    public void depose(double sum) throws Exception {
        if (sum <= 0)
            throw new Exception("Cannot depose 0 or negative numbers", null);
        this.amount += sum;
    }
}
