package fr.tln.bank_management.repository;

import fr.tln.bank_management.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RepositoryActions {
    public static void test(List<Account> updateAccountDtoList){
        String query1 = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String query2 = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        Connection connection = null;
        try {
            connection = SingletonConnection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setDouble(1, 10000); // کاهش ۱۰,۰۰۰
            preparedStatement1.setInt(2, 1); // حساب اول
            preparedStatement1.executeUpdate();
            //System.exit(0);

            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setDouble(1, 10000); // افزایش ۱۰,۰۰۰
            preparedStatement2.setInt(2, 2); // حساب دوم
            preparedStatement2.executeUpdate();

            connection.commit();

        }catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // اگر خطایی رخ دهد، تراکنش را بازگردانیم
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw new RuntimeException("Transaction failed", e);
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // ریست AutoCommit
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}