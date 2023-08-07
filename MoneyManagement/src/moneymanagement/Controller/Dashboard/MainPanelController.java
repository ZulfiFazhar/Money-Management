package moneymanagement.Controller.Dashboard;

import moneymanagement.Model.Panel.PemasukanModel;
import moneymanagement.Model.Panel.PengeluaranModel;
import moneymanagement.Model.User.UserSession;
import moneymanagement.View.Dashboard;

public class MainPanelController {
    private Dashboard view;
    private PemasukanModel pemasukan;
    private PengeluaranModel pengeluaran;

    public MainPanelController(Dashboard view, PemasukanModel pemasukan, PengeluaranModel pengeluaran) {
        this.view = view;
        this.pemasukan = pemasukan;
        this.pengeluaran = pengeluaran;
    }

    public void updateSaldoLabels() {
        String username = UserSession.getUsername();
        int totalSaldo = pemasukan.getTotalSaldoByUsername(username)
                - pengeluaran.getTotalKeluarByUsername(username);
        int cashSaldo = pemasukan.getCashSaldoByUsername(username)
                - pengeluaran.getCashKeluarByUsername(username);
        int debitSaldo = pemasukan.getDebitSaldoByUsername(username)
                - pengeluaran.getDebitKeluarByUsername(username);
        int emoneySaldo = pemasukan.getEmoneySaldoByUsername(username)
                - pengeluaran.getEmoneyKeluarByUsername(username);

        view.updateSaldoMainView(totalSaldo, cashSaldo, debitSaldo, emoneySaldo);
    }
    
//    public void updatePieChartPemasukan(){
//        String username = UserSession.getUsername();
//        int totalPemasukan = (pemasukan.getKategoriBulananByUsername(username) / pemasukan.getTotalSaldoByUsername(username)) * 100;
//        
//        view.updatePieChartPemasukanView(totalPemasukan);
//    }
}
