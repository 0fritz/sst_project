package ro.uvt.dp.Client;

import ro.uvt.dp.Accounts.Account;

public class ClientBuilderImpl implements ClientBuilder {
        private String name;
        private String address;
        private Account.TYPE type;
        private String accNumber;
        private double sum;

        public ClientBuilderImpl setName(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilderImpl setAddress(String address) {
            this.address = address;
            return this;
        }

        public ClientBuilderImpl setType(Account.TYPE type) {
            this.type = type;
            return this;
        }

        public ClientBuilderImpl setAccountsNr(String accNumber) {
            this.accNumber = accNumber;
            return this;
        }

        public ClientBuilderImpl setSum(double sum) {
            this.sum = sum;
            return this;
        }

        public Client build() throws Exception {
            Client client = new Client(name,address, type, accNumber, sum);
            return client;
        }
    }
