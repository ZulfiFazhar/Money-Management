package moneymanagement.Controller.Transaksi;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import moneymanagement.Model.Transaksi.TransaksiModel;
import moneymanagement.Model.User.UserSession;
import moneymanagement.View.Panel.TransaksiForm;

public class TransaksiController {
    private TransaksiModel transaksiModel;
    private TransaksiForm form = new TransaksiForm();

    public TransaksiController(TransaksiModel transaksiModel) {
        this.transaksiModel = transaksiModel;
    }

    public void insertTransaksi(String tanggal, String akun, String jenis, String kategori, double jumlah, String catatan, String jenisTransaksi) {
        String username = UserSession.getUsername();
        boolean success = false;

        try {
            if ("pemasukan".equals(jenisTransaksi)) {
                success = transaksiModel.insertPemasukan(username, tanggal, akun, jenis, kategori, jumlah, catatan);
            } else if ("pengeluaran".equals(jenisTransaksi)) {
                success = transaksiModel.insertPengeluaran(username, tanggal, akun, jenis, kategori, jumlah, catatan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (success) {
            JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Transaksi berhasil disimpan.");
        } else {
            JOptionPane.showMessageDialog(null, "Transaksi gagal disimpan.", "Gagal", JOptionPane.ERROR_MESSAGE);
            System.out.println("Transaksi gagal disimpan.");
        }
    }
}
