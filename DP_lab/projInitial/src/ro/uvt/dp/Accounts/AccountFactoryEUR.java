package ro.uvt.dp.Accounts;

public class AccountFactoryEUR implements AccountFactory {
    @Override
    public Account createAccount(String accNumber, double sum) throws Exception {
        return new AccountEUR(accNumber, sum);
    }
}
