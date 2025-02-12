package fr.tln.bank_management;

import fr.tln.bank_management.enums.AccountType;
import fr.tln.bank_management.repository.RepositoryActions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
            java.sql.Connection connection = DriverManager.getConnection(url, "root", "Bikar0001@");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String accountNumber = resultSet.getString("account_number");
                Enum<AccountType> accountType = Enum.valueOf(AccountType.class, resultSet.getString("account_type"));
                System.out.println("ID: " + id + " | Account Number: " + accountNumber + " | Account Type: " + accountType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }*/
        RepositoryActions x = new RepositoryActions();
        x.test(null);
    }
}
