package ro.uvt.dp.Accounts;

// Abstract Factory interface
public interface AccountFactory {
    Account createAccount(String accNumber, double sum) throws Exception;
}

