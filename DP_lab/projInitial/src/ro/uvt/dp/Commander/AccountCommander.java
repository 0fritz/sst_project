package ro.uvt.dp.Commander;

import ro.uvt.dp.Accounts.AccountOperation;

public class AccountCommander {
    private AccountOperation operation;

    public void setOperation(AccountOperation operation) {
        this.operation = operation;
    }

    public void executeOperation() throws Exception {
        if (operation != null) {
            operation.execute();
        }
    }
}
