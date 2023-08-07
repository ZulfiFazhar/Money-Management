package moneymanagement.Model.Panel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PengeluaranModel {
    private Connection connection;

    public PengeluaranModel() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/money_management", "root", "");
        } catch (SQLException e) {
        }
    }
    
    public int getTotalKeluarByUsername(String username) {
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

    public int getCashKeluarByUsername(String username) {
        int cashKeluar = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND akun = 'cash'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cashKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cashKeluar;
    }
    
    public int getDebitBriKeluarByUsername(String username){
        int debitBriKeluar = 0;
        
        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND akun = 'debit' AND jenis = 'bri'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                debitBriKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return debitBriKeluar;
    }
    
    public int getDebitBcaKeluarByUsername(String username){
        int debitBcaKeluar = 0;
        
        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND akun = 'debit' AND jenis = 'bca'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                debitBcaKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return debitBcaKeluar;
    }

    public int getDebitKeluarByUsername(String username) {
        int debitKeluar = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND akun = 'debit'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                debitKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return debitKeluar;
    }

    public int getEmoneyKeluarByUsername(String username) {
        int emoneyKeluar = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND akun = 'emoney'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                emoneyKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emoneyKeluar;
    }
    
    public int getGopayKeluarByUsername(String username) {
        int gopayKeluar = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND akun = 'emoney' AND jenis = 'gopay'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                gopayKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gopayKeluar;
    }
    
    public int getOvoKeluarByUsername(String username) {
        int ovoKeluar = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND akun = 'emoney' AND jenis = 'ovo'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ovoKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ovoKeluar;
    }
    
    public int getSpayKeluarByUsername(String username) {
        int spayKeluar = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND akun = 'emoney' AND jenis = 'shopeepay'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                spayKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spayKeluar;
    }
    
    public int getKategoriMakanByUsername(String username) {
        int makanKeluar = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND kategori = 'makan'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                makanKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return makanKeluar;
    }
    public int getKategoriTransportasiByUsername(String username) {
        int transportasiKeluar = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND kategori = 'transportasi'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                transportasiKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transportasiKeluar;
    }
    public int getKategoriInternetByUsername(String username) {
        int internetKeluar = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND kategori = 'internet'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                internetKeluar = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return internetKeluar;
    }

    public int getTanggalCashByUsername(String username, String tanggal) {
        int cash = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND tanggal = ? AND akun = 'cash'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, tanggal);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cash = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cash;
    }
    
    public int getTanggalDebitByUsername(String username, String tanggal) {
        int debit = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND tanggal = ? AND akun = 'debit'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, tanggal);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                debit = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return debit;
    }
    
    public int getTanggalEmoneyByUsername(String username, String tanggal) {
        int emoney1 = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pengeluaran WHERE username = ? AND tanggal = ? AND akun = 'emoney'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, tanggal);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                emoney1 = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emoney1;
    }
}

    

