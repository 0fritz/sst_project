package ro.uvt.dp.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataTest {

    @Test
    public void testAddClientToUnexistingBank() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String insertClientSQL = "INSERT INTO client (name, address, codeBank) VALUES (?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertClientSQL)) {
                preparedStatement.setString(1, "John Doe");
                preparedStatement.setString(2, "123 Main St");
                preparedStatement.setString(3, "NonExistingBank");
                preparedStatement.execute();
                System.out.println("Client added successfully to an unexisting bank (this should not happen).");
            } catch (SQLException e) {
                System.err.println("Error adding client to an unexisting bank: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAccessUnexistingClient() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String selectClientSQL = "SELECT * FROM client WHERE name = 'NonExistingClient';";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectClientSQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    System.out.println("Client 'NonExistingClient' does not exist (as expected).");
                }
            } catch (SQLException e) {
                System.err.println("Error accessing an unexisting client: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddClient() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String insertClientSQL = "INSERT INTO client (name, address, codeBank) VALUES (?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertClientSQL)) {
                preparedStatement.setString(1, "John Doe");
                preparedStatement.setString(2, "123 Main St");
                preparedStatement.setString(3, "ExistingBank");
                preparedStatement.execute();
                System.out.println("Client 'John Doe' added successfully to 'ExistingBank'.");
            } catch (SQLException e) {
                System.err.println("Error adding client: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetClient() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String selectClientSQL = "SELECT * FROM client WHERE name = 'John Doe';";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectClientSQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    String codeBank = resultSet.getString("codeBank");
                    System.out.println("Client retrieved successfully: " + name + ", " + address + ", " + codeBank);
                } else {
                    System.out.println("Client 'John Doe' not found.");
                }
            } catch (SQLException e) {
                System.err.println("Error retrieving client: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddMultipleClients() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String insertClientSQL = "INSERT INTO client (name, address, codeBank) VALUES (?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertClientSQL)) {
                preparedStatement.setString(1, "Alice");
                preparedStatement.setString(2, "456 Oak St");
                preparedStatement.setString(3, "ExistingBank");
                preparedStatement.execute();

                preparedStatement.setString(1, "Bob");
                preparedStatement.setString(2, "789 Elm St");
                preparedStatement.setString(3, "ExistingBank");
                preparedStatement.execute();

                System.out.println("Multiple clients added successfully.");
            } catch (SQLException e) {
                System.err.println("Error adding multiple clients: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllClients() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String selectClientsSQL = "SELECT * FROM client;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectClientsSQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("All Clients:");

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    String codeBank = resultSet.getString("codeBank");
                    System.out.println("Client: " + name + ", Address: " + address + ", CodeBank: " + codeBank);
                }
            } catch (SQLException e) {
                System.err.println("Error retrieving all clients: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteClient() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String deleteClientSQL = "DELETE FROM client WHERE name = 'John Doe';";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteClientSQL)) {
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Client 'John Doe' deleted successfully.");
                } else {
                    System.out.println("Client 'John Doe' not found for deletion.");
                }
            } catch (SQLException e) {
                System.err.println("Error deleting client: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddAccount() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String insertAccountSQL = "INSERT INTO account (accCode, amount, clientName) VALUES (?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountSQL)) {
                preparedStatement.setString(1, "USD");
                preparedStatement.setString(2, "5000");
                preparedStatement.setString(3, "Alice");
                preparedStatement.execute();
                System.out.println("Account 'USD' added successfully for 'Alice'.");
            } catch (SQLException e) {
                System.err.println("Error adding account: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAccountBalance() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String selectBalanceSQL = "SELECT amount FROM account WHERE accCode = 'USD' AND clientName = 'Alice';";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectBalanceSQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    double balance = resultSet.getDouble("amount");
                    System.out.println("Account balance for 'USD' and 'Alice': " + balance);
                } else {
                    System.out.println("Account 'USD' not found for 'Alice'.");
                }
            } catch (SQLException e) {
                System.err.println("Error retrieving account balance: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTransferAmountBetweenAccounts() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            // Assuming Alice has USD and Bob has EUR accounts
            String updateAliceAccountSQL = "UPDATE account SET amount = amount - 100 WHERE accCode = 'USD' AND clientName = 'Alice';";
            String updateBobAccountSQL = "UPDATE account SET amount = amount + 100 WHERE accCode = 'EUR' AND clientName = 'Bob';";

            try (PreparedStatement preparedStatement1 = connection.prepareStatement(updateAliceAccountSQL);
                 PreparedStatement preparedStatement2 = connection.prepareStatement(updateBobAccountSQL)) {
                connection.setAutoCommit(false);

                preparedStatement1.executeUpdate();
                preparedStatement2.executeUpdate();

                connection.commit();

                System.out.println("Amount transferred successfully from 'Alice' (USD) to 'Bob' (EUR).");
            } catch (SQLException e) {
                connection.rollback();
                System.err.println("Error transferring amount between accounts: " + e.getMessage());
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteAccount() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String deleteAccountSQL = "DELETE FROM account WHERE accCode = 'USD' AND clientName = 'Alice';";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteAccountSQL)) {
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Account 'USD' deleted successfully for 'Alice'.");
                } else {
                    System.out.println("Account 'USD' not found for 'Alice' for deletion.");
                }
            } catch (SQLException e) {
                System.err.println("Error deleting account: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateClientAddress() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String updateAddressSQL = "UPDATE client SET address = 'New Address' WHERE name = 'Bob';";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateAddressSQL)) {
                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Address updated successfully for 'Bob'.");
                } else {
                    System.out.println("Client 'Bob' not found for updating address.");
                }
            } catch (SQLException e) {
                System.err.println("Error updating client address: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllAccounts() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String selectAccountsSQL = "SELECT * FROM account;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectAccountsSQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("All Accounts:");

                while (resultSet.next()) {
                    String accCode = resultSet.getString("accCode");
                    double amount = resultSet.getDouble("amount");
                    String clientName = resultSet.getString("clientName");
                    System.out.println("Account: " + accCode + ", Amount: " + amount + ", Client: " + clientName);
                }
            } catch (SQLException e) {
                System.err.println("Error retrieving all accounts: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddClientToExistingBank() {
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            String insertClientSQL = "INSERT INTO client (name, address, codeBank) VALUES (?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertClientSQL)) {
                preparedStatement.setString(1, "Eve");
                preparedStatement.setString(2, "789 Pine St");
                preparedStatement.setString(3, "ExistingBank");
                preparedStatement.execute();
                System.out.println("Client 'Eve' added successfully to 'ExistingBank'.");
            } catch (SQLException e) {
                System.err.println("Error adding client to an existing bank: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

