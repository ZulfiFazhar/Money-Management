/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author zulfi
 */
public class Koneksi {
    public Connection getConnection() {
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/money_management";
    String user = "root";
    String password = "";

    try {
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Koneksi ke database berhasil.");
    } catch (SQLException e) {
        System.err.println("Error saat terhubung ke database: " + e.getMessage());
    }
    
    return conn;
}
    
    public void executeQuery(String sql) {
    Connection conn = getConnection();
    Statement stmt = null;

    try {
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        System.out.println("Query berhasil dijalankan.");
    } catch (SQLException e) {
        System.err.println("Error saat menjalankan query: " + e.getMessage());
    } finally {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Error saat menutup koneksi: " + e.getMessage());
        }
    }
}

}
