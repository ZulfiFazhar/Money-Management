package moneymanagement.Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    private String username;
    private String email;
    private String password;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/money_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public UserModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    
    public String getEmail() {
        return email;
    }

    public boolean registerUser() {
        try {
            int rowsInserted;
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, password);
                    rowsInserted = preparedStatement.executeUpdate();
                }
            }

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception for debugging
            return false;
        }
    }

    public boolean checkLogin() {
        try {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            email = resultSet.getString("email"); // Ambil email dari hasil query
                            username = resultSet.getString("username");
                            return true; // Returns true if there's a match
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
