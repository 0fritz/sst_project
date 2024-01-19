package ro.uvt.dp.Accounts;

public class AccountRON extends Account implements Transfer {

    public AccountRON(String accNumber, double sum) throws Exception {
        super(accNumber, sum);
    }

    protected Account createAccount(String accNumber, double sum) throws Exception {
        return new AccountRON(accNumber, sum);
    }

    @Override
    public double getInterest() {
        if (amount < 500)
            return 0.03;
        else
            return 0.08;
    }

    @Override
    public String toString() {
        return "Account RON [" + super.toString() + "]";
    }

    @Override
    public void transfer(Account c, double s) {
        try {
            retrieve(s); // Use the retrieve method from the updated Account class
            c.depose(s); // Use the depose method from the updated Account class
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }
}
