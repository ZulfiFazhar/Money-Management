package moneymanagement.Model.Transaksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import moneymanagement.Model.User.UserSession;



public class TransaksiModel {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/money_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public boolean insertPemasukan(String username, String tanggal, String akun, String jenis, String kategori, double jumlah, String catatan)
            throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO pemasukan (username, tanggal, akun, jenis, kategori, jumlah, catatan) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, tanggal);
                preparedStatement.setString(3, akun);
                preparedStatement.setString(4, jenis);
                preparedStatement.setString(5, kategori);
                preparedStatement.setDouble(6, jumlah);
                preparedStatement.setString(7, catatan);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        }
    }

    public boolean insertPengeluaran(String username, String tanggal, String akun, String jenis, String kategori, double jumlah, String catatan)
            throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO pengeluaran (username, tanggal, akun, jenis, kategori, jumlah, catatan) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, tanggal);
                preparedStatement.setString(3, akun);
                preparedStatement.setString(4, jenis);
                preparedStatement.setString(5, kategori);
                preparedStatement.setDouble(6, jumlah);
                preparedStatement.setString(7, catatan);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        }
    }

}
