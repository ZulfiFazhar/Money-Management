package moneymanagement.View.Panel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import moneymanagement.Model.Panel.PemasukanModel;
import moneymanagement.Model.User.UserSession;

public class testing {

    public static void main(String[] args) {
        String username = UserSession.getUsername();
        PemasukanModel pemasukan = new PemasukanModel();

        int totalSaldo = getTotalSaldoByUsername(username);

        System.out.println("Bulanan " + username + " : " + totalSaldo);
    }

    public static int getTotalSaldoByUsername(String username) {
        int totalSaldo = 0;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/money_management", "root", "")) {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        totalSaldo = resultSet.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Bulanan " + username + " : " + totalSaldo);

        return totalSaldo;
    }
}
