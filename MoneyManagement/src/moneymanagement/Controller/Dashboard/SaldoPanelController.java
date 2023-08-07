package moneymanagement.Controller.Dashboard;

import moneymanagement.Model.Panel.PemasukanModel;
import moneymanagement.Model.Panel.PengeluaranModel;
import moneymanagement.Model.User.UserSession;
import moneymanagement.View.Dashboard;

public class SaldoPanelController {
    private Dashboard view;
    private PemasukanModel pemasukanModel;
    private PengeluaranModel pengeluaranModel;

    public SaldoPanelController(Dashboard view,PemasukanModel pemasukanModel, PengeluaranModel pengeluaranModel) {
        this.view = view;
        this.pemasukanModel = pemasukanModel;
        this.pengeluaranModel = pengeluaranModel;
    }
    
    public void updateTotalSaldoLabels() {
        String username = UserSession.getUsername();
        int totalSaldo = pemasukanModel.getTotalSaldoByUsername(username) - pengeluaranModel.getTotalKeluarByUsername(username);

        view.updateTotalSaldoView(totalSaldo);
    }
    public void updatePemasukanSaldoLabels() {
        String username = UserSession.getUsername();
        int pemasukanSaldo = pemasukanModel.getTotalSaldoByUsername(username);

        view.updatePemasukanSaldoView(pemasukanSaldo);
    }
    public void updatePengeluaranSaldoLabels() {
        String username = UserSession.getUsername();
        int pengeluaranSaldo = pengeluaranModel.getTotalKeluarByUsername(username);

        view.updatePengeluaranSaldoView(pengeluaranSaldo);
    }
    public void updateCashSaldoLabels() {
        String username = UserSession.getUsername();
        int cashSaldo = pemasukanModel.getCashSaldoByUsername(username)
                - pengeluaranModel.getCashKeluarByUsername(username);

        view.updateCashSaldoView(cashSaldo);
    }
    public void updateGopaySaldoLabels() {
        String username = UserSession.getUsername();
        int gopaySaldo = pemasukanModel.getEmoneyGopayByUsername(username)
                - pengeluaranModel.getGopayKeluarByUsername(username);

        view.updateGopaySaldoView(gopaySaldo);
    }
    public void updateOvoSaldoLabels() {
        String username = UserSession.getUsername();
        int ovoSaldo = pemasukanModel.getEmoneyOvoByUsername(username)
                - pengeluaranModel.getOvoKeluarByUsername(username);

        view.updateOvoSaldoView(ovoSaldo);
    }
    public void updateSpaySaldoLabels() {
        String username = UserSession.getUsername();
        int spaySaldo = pemasukanModel.getEmoneySpayByUsername(username)
                - pengeluaranModel.getSpayKeluarByUsername(username);

        view.updateSpaySaldoView(spaySaldo);
    }
    
    public void updateDebitBriLabels() {
        String username = UserSession.getUsername();
        int debitBri = pemasukanModel.getDebitBriByUsername(username)
                - pengeluaranModel.getDebitBriKeluarByUsername(username);

        view.updateDebitBriView(debitBri);
    }
    public void updateDebitBcaLabels() {
        String username = UserSession.getUsername();
        int debitBca = pemasukanModel.getDebitBcaByUsername(username)
                - pengeluaranModel.getDebitBcaKeluarByUsername(username);

        view.updateDebitBcaView(debitBca);
    }
}
