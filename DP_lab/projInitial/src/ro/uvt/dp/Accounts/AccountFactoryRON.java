package ro.uvt.dp.Accounts;

public class AccountFactoryRON implements AccountFactory{
    @Override
    public Account createAccount(String accNumber, double sum) throws Exception {
        return new AccountRON(accNumber, sum);
    }
}
