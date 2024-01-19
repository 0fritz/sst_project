package ro.uvt.dp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data {

    public static void main(String[] args) {
        // Create a database connection
        try (Connection connection = DriverManager.getConnection(Databaseconfig.JDBC_URL, Databaseconfig.USERNAME, Databaseconfig.PASSWORD)) {
            System.out.println("Connected to the database!");

            deleteData(connection);
            insertData(connection);
            printData(connection);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Connection connection) {
        // Insert data into the "bank" table
        String insertBankSQL = "INSERT INTO bank (codeBank) VALUES (?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertBankSQL)) {
            // Insert sample data
            preparedStatement.setString(1, "Banca Transilvania");
            preparedStatement.execute();

            preparedStatement.setString(1, "ING");
            preparedStatement.execute();

            System.out.println("Bank data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Insert data into the "client" table
        String insertClientSQL = "INSERT INTO client (name, address, codeBank) VALUES (?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertClientSQL)) {
            // Insert sample data
            preparedStatement.setString(1, "Lucian Galan");
            preparedStatement.setString(2, "Str.Ciorilor nr.10");
            preparedStatement.setString(3, "ING");
            preparedStatement.execute();

            System.out.println("Client data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Insert data into the "account" table
        String insertAccountSQL = "INSERT INTO account (accCode, amount, clientName) VALUES (?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountSQL)) {
            // Insert sample data
            preparedStatement.setString(1, "EUR");
            preparedStatement.setString(2, "20000");
            preparedStatement.setString(3, "Lucian Galan");
            preparedStatement.execute();

            preparedStatement.setString(1, "RON");
            preparedStatement.setString(2, "10000");
            preparedStatement.setString(3, "Lucian Galan");
            preparedStatement.execute();

            System.out.println("Account data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printData(Connection connection) {
        // Query to retrieve data from the "client" and "account" tables
        String selectDataSQL = "SELECT c.*, a.accCode, a.amount FROM client c LEFT JOIN account a ON c.name = a.clientName;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectDataSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Print the retrieved data
            System.out.println("Client and Account Data:");

            String currentClient = null;

            while (resultSet.next()) {
                String clientName = resultSet.getString("name");
                String address = resultSet.getString("address");
                String codeBank = resultSet.getString("codeBank");
                String accCode = resultSet.getString("accCode");
                String amount = resultSet.getString("amount");

                if (!clientName.equals(currentClient)) {
                    // New client, print client information
                    System.out.println("Client: " + clientName + ", Address: " + address + ", CodeBank: " + codeBank);
                    currentClient = clientName;
                }

                // Print account information
                System.out.println("   Account: " + accCode + ", Amount: " + amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteData(Connection connection) {
        // Delete all records from the "bank" table
        String deleteBankSQL = "DELETE FROM bank;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteBankSQL)) {
            preparedStatement.executeUpdate();
            System.out.println("All records deleted from the 'bank' table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Delete all records from the "client" table
        String deleteClientSQL = "DELETE FROM client;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteClientSQL)) {
            preparedStatement.executeUpdate();
            System.out.println("All records deleted from the 'client' table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Delete all records from the "account" table
        String deleteAccountSQL = "DELETE FROM account;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteAccountSQL)) {
            preparedStatement.executeUpdate();
            System.out.println("All records deleted from the 'account' table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
