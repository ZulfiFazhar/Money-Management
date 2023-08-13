package moneymanagement.Model.Panel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PemasukanModel {
    private Connection connection;

    public PemasukanModel() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/money_management", "root", "");
        } catch (SQLException e) {
        }
    }
    
    public int getTotalSaldoByUsername(String username) {
        int totalSaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalSaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalSaldo;
    }

    public int getCashSaldoByUsername(String username) {
        int cashSaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND akun = 'cash'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cashSaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cashSaldo;
    }

    public int getDebitSaldoByUsername(String username) {
        int debitSaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND akun = 'debit'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                debitSaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return debitSaldo;
    }
    
    public int getDebitBriByUsername(String username){
        int debitBri = 0;
        
        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND akun = 'debit' AND jenis = 'bri'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                debitBri = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return debitBri;
    }
    
    public int getDebitBcaByUsername(String username){
        int debitBca = 0;
        
        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND akun = 'debit' AND jenis = 'bca'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                debitBca = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return debitBca;
    }

    public int getEmoneySaldoByUsername(String username) {
        int emoneySaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND akun = 'emoney'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                emoneySaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emoneySaldo;
    }
    
    public int getEmoneyGopayByUsername(String username) {
        int gopaySaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND akun = 'emoney' AND jenis = 'gopay'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                gopaySaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gopaySaldo;
    }
    
    public int getEmoneyOvoByUsername(String username) {
        int ovoSaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND akun = 'emoney' AND jenis = 'ovo'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ovoSaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ovoSaldo;
    }
    
    public int getEmoneySpayByUsername(String username) {
        int spaySaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND akun = 'emoney' AND jenis = 'shopeepay'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                spaySaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spaySaldo;
    }
    
    public int getKategoriBulananByUsername(String username) {
        int bulananSaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND kategori = 'bulanan'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bulananSaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bulananSaldo;
    }
    
    public int getKategoriBonusByUsername(String username) {
        int bonusSaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND kategori = 'bonus'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bonusSaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bonusSaldo;
    }
    
    public int getKategoriThrByUsername(String username) {
        int thrSaldo = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND kategori = 'thr'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                thrSaldo = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return thrSaldo;
    }
    
    public int getTanggalCashByUsername(String username, String tanggal) {
        int cash = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND tanggal = ? AND akun = 'cash'";
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
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND tanggal = ? AND akun = 'debit'";
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
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND tanggal = ? AND akun = 'emoney'";
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
    
    public int getMinggu1ByUsername(String username) {
        int totalMinggu1 = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND tanggal BETWEEN '30/07/2023' AND '05/08/2023'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalMinggu1 = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalMinggu1;
    }
    
    public int getMinggu2ByUsername(String username) {
        int totalMinggu2 = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND tanggal BETWEEN '06/08/2023' AND '12/08/2023'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalMinggu2 = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalMinggu2;
    }
    
    public int getMinggu3ByUsername(String username) {
        int totalMinggu3 = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND tanggal BETWEEN '13/08/2023' AND '19/08/2023'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalMinggu3 = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalMinggu3;
    }
    
    public int getMinggu4ByUsername(String username) {
        int totalMinggu4 = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND tanggal BETWEEN '20/08/2023' AND '26/08/2023'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalMinggu4 = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalMinggu4;
    }
    
    public int getMinggu5ByUsername(String username) {
        int totalMinggu5 = 0;

        try {
            String query = "SELECT SUM(jumlah) FROM pemasukan WHERE username = ? AND tanggal BETWEEN '27/08/2023' AND '02/09/2023'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalMinggu5 = resultSet.getInt(1);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalMinggu5;
    }
    
    
}
