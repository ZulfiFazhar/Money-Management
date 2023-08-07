
package moneymanagement.Model.Panel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatistikModel {
    private Connection connection;

    public StatistikModel() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/money_management", "root", "");
        } catch (SQLException e) {
        }
    }
    
    public int getTanggalCashByUsername(String username) {
        int totalPengeluaran = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalPengeluaran = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalPengeluaran;
    }
}
