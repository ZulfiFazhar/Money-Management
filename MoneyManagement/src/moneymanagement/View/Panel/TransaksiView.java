package moneymanagement.View.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import moneymanagement.Model.Panel.PemasukanModel;
import moneymanagement.Model.Panel.PengeluaranModel;
import moneymanagement.Model.User.UserSession;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class TransaksiView extends javax.swing.JPanel {

    /**
     * Creates new form TransaksiView
     */
    public TransaksiView() {
        initComponents();
        
        String username = UserSession.getUsername();
        PemasukanModel pemasukan = new PemasukanModel();
        
        double totalPemasukan = pemasukan.getTotalSaldoByUsername(username);
        double pemasukanBulanan = pemasukan.getKategoriBulananByUsername(username);
        double pemasukanBonus = pemasukan.getKategoriBonusByUsername(username);
        double pemasukanThr = pemasukan.getKategoriThrByUsername(username);
        double bulanan = (pemasukanBulanan / totalPemasukan)*100;
        double bonus = (pemasukanBonus / totalPemasukan)*100;
        double thr = (pemasukanThr / totalPemasukan)*100;
        showPieChart(bulanan,bonus,thr);
        
        PengeluaranModel pengeluaran = new PengeluaranModel();
        
        double totalPengeluaran = pengeluaran.getTotalKeluarByUsername(username);
        double pengeluaranMakan = pengeluaran.getKategoriMakanByUsername(username);
        double pengeluaranTransportasi = pengeluaran.getKategoriTransportasiByUsername(username);
        double pengeluaranInternet = pengeluaran.getKategoriInternetByUsername(username);
        double makan = (pengeluaranMakan / totalPengeluaran)*100;
        double transportasi = (pengeluaranTransportasi / totalPengeluaran)*100;
        double internet = (pengeluaranInternet / totalPengeluaran)*100;
        showPieChart2(makan,transportasi,internet);
        
        
        
        IncomeTotal.setText(Integer.toString((int) totalPemasukan));
        OutcomeTotal.setText(Integer.toString((int) totalPengeluaran));
        
        masukMinggu1.setText(Integer.toString((int) pemasukan.getMinggu1ByUsername(username)));
        masukMinggu2.setText(Integer.toString((int) pemasukan.getMinggu2ByUsername(username)));
        masukMinggu3.setText(Integer.toString((int) pemasukan.getMinggu3ByUsername(username)));
        masukMinggu4.setText(Integer.toString((int) pemasukan.getMinggu4ByUsername(username)));
        masukMinggu5.setText(Integer.toString((int) pemasukan.getMinggu5ByUsername(username)));
       
        keluarMinggu1.setText(Integer.toString((int) pengeluaran.getMinggu1ByUsername(username)));
        keluarMinggu2.setText(Integer.toString((int) pengeluaran.getMinggu2ByUsername(username)));
        keluarMinggu3.setText(Integer.toString((int) pengeluaran.getMinggu3ByUsername(username)));
        keluarMinggu4.setText(Integer.toString((int) pengeluaran.getMinggu4ByUsername(username)));
        keluarMinggu5.setText(Integer.toString((int) pengeluaran.getMinggu5ByUsername(username)));
    }
    
    public void showPieChart(double bulanan, double bonus, double thr){
        DefaultPieDataset barDataset = new DefaultPieDataset( );
        barDataset.setValue( "Bulanan" , new Double( bulanan ) );   
        barDataset.setValue( "Bonus" , new Double( bonus ) );  
        barDataset.setValue( "THR" , new Double( thr ) );

        JFreeChart piechart = ChartFactory.createPieChart("",barDataset, false,true,false);
        PiePlot piePlot =(PiePlot) piechart.getPlot();

        piePlot.setSectionPaint("Bulanan", new Color(253, 111, 99));
        piePlot.setSectionPaint("Bonus", new Color(255, 151, 80));
        piePlot.setSectionPaint("THR", new Color(255, 208, 66));
       
        piePlot.setBackgroundPaint(Color.white);

        ChartPanel barChartPanel = new ChartPanel(piechart);
        GraphPemasukan.removeAll();
        GraphPemasukan.add(barChartPanel, BorderLayout.CENTER);
        GraphPemasukan.validate();
    }
     
    public void showPieChart2(double makan, double transportasi, double internet){

        DefaultPieDataset barDataset = new DefaultPieDataset( );
        barDataset.setValue( "Makan" , new Double( makan ) );  
        barDataset.setValue( "Transportasi" , new Double( transportasi ) );   
        barDataset.setValue( "Internet" , new Double( internet ) );

        JFreeChart piechart = ChartFactory.createPieChart("",barDataset, false,true,false);//explain

        PiePlot piePlot =(PiePlot) piechart.getPlot();

        piePlot.setSectionPaint("Makan", new Color(253, 111, 99));
        piePlot.setSectionPaint("Transportasi", new Color(255, 151, 80));
        piePlot.setSectionPaint("Internet", new Color(255, 208, 66));
      
       
        piePlot.setBackgroundPaint(Color.white);

        ChartPanel barChartPanel = new ChartPanel(piechart);
        GraphPengeluaran.removeAll();
        GraphPengeluaran.add(barChartPanel, BorderLayout.CENTER);
        GraphPengeluaran.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pPemasukan = new javax.swing.JPanel();
        GraphPemasukan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Garis3 = new javax.swing.JLabel();
        Garis8 = new javax.swing.JLabel();
        Garis9 = new javax.swing.JLabel();
        Garis10 = new javax.swing.JLabel();
        Garis11 = new javax.swing.JLabel();
        Garis12 = new javax.swing.JLabel();
        Garis13 = new javax.swing.JLabel();
        Garis4 = new javax.swing.JLabel();
        JenisTransaksi1 = new javax.swing.JLabel();
        JenisTransaksi2 = new javax.swing.JLabel();
        JenisTransaksi3 = new javax.swing.JLabel();
        JenisTransaksi4 = new javax.swing.JLabel();
        JenisTransaksi5 = new javax.swing.JLabel();
        JenisTransaksi6 = new javax.swing.JLabel();
        PemasukanGraph1 = new javax.swing.JLabel();
        PemasukanGraph2 = new javax.swing.JLabel();
        PemasukanGraph3 = new javax.swing.JLabel();
        PemasukanGraph4 = new javax.swing.JLabel();
        PemasukanGraph5 = new javax.swing.JLabel();
        PemasukanGraph6 = new javax.swing.JLabel();
        JenisPendapatan1 = new javax.swing.JLabel();
        JenisPendapatan2 = new javax.swing.JLabel();
        JenisPendapatan3 = new javax.swing.JLabel();
        JenisPendapatan4 = new javax.swing.JLabel();
        JenisPendapatan5 = new javax.swing.JLabel();
        JenisPendapatan6 = new javax.swing.JLabel();
        Rp_Pemasukan = new javax.swing.JLabel();
        Rp_Pemasukan1 = new javax.swing.JLabel();
        Rp_Pemasukan2 = new javax.swing.JLabel();
        Rp_Pemasukan3 = new javax.swing.JLabel();
        Rp_Pemasukan4 = new javax.swing.JLabel();
        Rp_Pemasukan5 = new javax.swing.JLabel();
        Date1 = new javax.swing.JLabel();
        Date2 = new javax.swing.JLabel();
        Date3 = new javax.swing.JLabel();
        Date4 = new javax.swing.JLabel();
        Date5 = new javax.swing.JLabel();
        Date6 = new javax.swing.JLabel();
        Payment = new javax.swing.JLabel();
        Payment1 = new javax.swing.JLabel();
        Payment2 = new javax.swing.JLabel();
        Payment3 = new javax.swing.JLabel();
        Payment4 = new javax.swing.JLabel();
        Payment5 = new javax.swing.JLabel();
        pPengeluaran = new javax.swing.JPanel();
        GraphPengeluaran = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Garis1 = new javax.swing.JLabel();
        Garis2 = new javax.swing.JLabel();
        Garis14 = new javax.swing.JLabel();
        Garis15 = new javax.swing.JLabel();
        Garis16 = new javax.swing.JLabel();
        Garis17 = new javax.swing.JLabel();
        Garis18 = new javax.swing.JLabel();
        Garis19 = new javax.swing.JLabel();
        Date13 = new javax.swing.JLabel();
        Date8 = new javax.swing.JLabel();
        Date9 = new javax.swing.JLabel();
        Date10 = new javax.swing.JLabel();
        Date11 = new javax.swing.JLabel();
        Date12 = new javax.swing.JLabel();
        Payment6 = new javax.swing.JLabel();
        Payment7 = new javax.swing.JLabel();
        Payment8 = new javax.swing.JLabel();
        Payment9 = new javax.swing.JLabel();
        Payment10 = new javax.swing.JLabel();
        Payment11 = new javax.swing.JLabel();
        Penggunaan1 = new javax.swing.JLabel();
        Penggunaan2 = new javax.swing.JLabel();
        Penggunaan3 = new javax.swing.JLabel();
        Penggunaan4 = new javax.swing.JLabel();
        Penggunaan5 = new javax.swing.JLabel();
        Penggunaan6 = new javax.swing.JLabel();
        Rp_Pengeluaran2 = new javax.swing.JLabel();
        Rp_Pengeluaran3 = new javax.swing.JLabel();
        Rp_Pengeluaran4 = new javax.swing.JLabel();
        Rp_Pengeluaran5 = new javax.swing.JLabel();
        Rp_Pengeluaran6 = new javax.swing.JLabel();
        PengeluaranGraph1 = new javax.swing.JLabel();
        PengeluaranGraph2 = new javax.swing.JLabel();
        PengeluaranGraph3 = new javax.swing.JLabel();
        PengeluaranGraph4 = new javax.swing.JLabel();
        PengeluaranGraph5 = new javax.swing.JLabel();
        PengeluaranGraph6 = new javax.swing.JLabel();
        JenisPemakaian1 = new javax.swing.JLabel();
        JenisPemakaian2 = new javax.swing.JLabel();
        JenisPemakaian3 = new javax.swing.JLabel();
        JenisPemakaian4 = new javax.swing.JLabel();
        JenisPemakaian5 = new javax.swing.JLabel();
        JenisPemakaian6 = new javax.swing.JLabel();
        Rp_Pengeluaran1 = new javax.swing.JLabel();
        Pemasukan_Pengeluaran = new javax.swing.JPanel();
        PilihanBulan = new com.toedter.calendar.JMonthChooser();
        Garis5 = new javax.swing.JLabel();
        Garis6 = new javax.swing.JLabel();
        Income_Text = new javax.swing.JLabel();
        Outcome_Text = new javax.swing.JLabel();
        Rp_Income_Total = new javax.swing.JLabel();
        Rp_Outcome_Total = new javax.swing.JLabel();
        OutcomeTotal = new javax.swing.JLabel();
        MonthPengeluaran = new javax.swing.JPanel();
        Rp_Outcome1 = new javax.swing.JLabel();
        Rp_Outcome2 = new javax.swing.JLabel();
        Rp_Outcome3 = new javax.swing.JLabel();
        Rp_Outcome4 = new javax.swing.JLabel();
        Rp_Outcome5 = new javax.swing.JLabel();
        keluarMinggu1 = new javax.swing.JLabel();
        keluarMinggu2 = new javax.swing.JLabel();
        keluarMinggu3 = new javax.swing.JLabel();
        keluarMinggu4 = new javax.swing.JLabel();
        keluarMinggu5 = new javax.swing.JLabel();
        MonthPemasukan = new javax.swing.JPanel();
        Rp_Income1 = new javax.swing.JLabel();
        Rp_Income2 = new javax.swing.JLabel();
        Rp_Income3 = new javax.swing.JLabel();
        Rp_Income4 = new javax.swing.JLabel();
        Rp_Income5 = new javax.swing.JLabel();
        masukMinggu1 = new javax.swing.JLabel();
        masukMinggu2 = new javax.swing.JLabel();
        masukMinggu3 = new javax.swing.JLabel();
        masukMinggu4 = new javax.swing.JLabel();
        masukMinggu5 = new javax.swing.JLabel();
        IncomeTotal = new javax.swing.JLabel();
        Garis7 = new javax.swing.JLabel();
        DatePemasukan3 = new javax.swing.JLabel();
        DatePemasukan4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DatePemasukan5 = new javax.swing.JLabel();
        DatePemasukan6 = new javax.swing.JLabel();
        DatePemasukan7 = new javax.swing.JLabel();
        DatePemasukan8 = new javax.swing.JLabel();
        DatePemasukan9 = new javax.swing.JLabel();
        DatePemasukan10 = new javax.swing.JLabel();
        DatePemasukan11 = new javax.swing.JLabel();
        DatePemasukan12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Kalender = new com.toedter.calendar.JCalendar();
        inputTransaksi = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(970, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(66, 157, 145));
        jPanel1.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(66, 157, 145));
        jPanel2.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(66, 157, 145));
        jPanel3.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, -1, -1));

        jPanel4.setBackground(new java.awt.Color(66, 157, 145));
        jPanel4.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 690, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moneymanagement/Assets/Icon/transaksi-title.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        pPemasukan.setBackground(new java.awt.Color(255, 255, 255));
        pPemasukan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(58, 194, 178), new java.awt.Color(58, 194, 178), new java.awt.Color(58, 194, 178), new java.awt.Color(58, 194, 178)));
        pPemasukan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GraphPemasukan.setBackground(new java.awt.Color(255, 255, 255));
        GraphPemasukan.setLayout(new java.awt.BorderLayout());
        pPemasukan.add(GraphPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 63, 250, 160));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(53, 157, 145));
        jLabel3.setText("Pemasukan");
        pPemasukan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Garis3.setForeground(new java.awt.Color(53, 157, 145));
        Garis3.setText("__________________________________");
        pPemasukan.add(Garis3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 240, -1));

        Garis8.setForeground(new java.awt.Color(53, 157, 145));
        Garis8.setText("__________________________________");
        pPemasukan.add(Garis8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 240, 20));

        Garis9.setForeground(new java.awt.Color(53, 157, 145));
        Garis9.setText("__________________________________");
        pPemasukan.add(Garis9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 240, 20));

        Garis10.setForeground(new java.awt.Color(53, 157, 145));
        Garis10.setText("__________________________________");
        pPemasukan.add(Garis10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 240, 20));

        Garis11.setForeground(new java.awt.Color(53, 157, 145));
        Garis11.setText("__________________________________");
        pPemasukan.add(Garis11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 240, 20));

        Garis12.setForeground(new java.awt.Color(53, 157, 145));
        Garis12.setText("__________________________________");
        pPemasukan.add(Garis12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 240, 20));

        Garis13.setForeground(new java.awt.Color(53, 157, 145));
        Garis13.setText("__________________________________");
        pPemasukan.add(Garis13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 240, 20));

        Garis4.setForeground(new java.awt.Color(53, 157, 145));
        Garis4.setText("__________________________________");
        pPemasukan.add(Garis4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 240, 20));

        JenisTransaksi1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisTransaksi1.setText("-");
        pPemasukan.add(JenisTransaksi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 10, -1));

        JenisTransaksi2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisTransaksi2.setText("BCA");
        pPemasukan.add(JenisTransaksi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 20, -1));

        JenisTransaksi3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisTransaksi3.setText("Gopay");
        pPemasukan.add(JenisTransaksi3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        JenisTransaksi4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisTransaksi4.setText("OVO");
        pPemasukan.add(JenisTransaksi4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        JenisTransaksi5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisTransaksi5.setText("BRI");
        pPemasukan.add(JenisTransaksi5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        JenisTransaksi6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisTransaksi6.setText("-");
        pPemasukan.add(JenisTransaksi6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 523, 20, 10));

        PemasukanGraph1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PemasukanGraph1.setText("100000");
        pPemasukan.add(PemasukanGraph1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 262, 70, 20));

        PemasukanGraph2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PemasukanGraph2.setText("900000");
        pPemasukan.add(PemasukanGraph2, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 312, 70, 20));

        PemasukanGraph3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PemasukanGraph3.setText("20000");
        pPemasukan.add(PemasukanGraph3, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 362, 70, 20));

        PemasukanGraph4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PemasukanGraph4.setText("50000");
        pPemasukan.add(PemasukanGraph4, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 412, 70, 20));

        PemasukanGraph5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PemasukanGraph5.setText("1000000");
        pPemasukan.add(PemasukanGraph5, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 462, 70, 20));

        PemasukanGraph6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PemasukanGraph6.setText("250000");
        pPemasukan.add(PemasukanGraph6, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 512, 70, 20));

        JenisPendapatan1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        JenisPendapatan1.setText("Bonus");
        pPemasukan.add(JenisPendapatan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 265, -1, -1));

        JenisPendapatan2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        JenisPendapatan2.setText("Transfer");
        pPemasukan.add(JenisPendapatan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 315, -1, -1));

        JenisPendapatan3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        JenisPendapatan3.setText("Cashback");
        pPemasukan.add(JenisPendapatan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 365, -1, -1));

        JenisPendapatan4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        JenisPendapatan4.setText("GameCash");
        pPemasukan.add(JenisPendapatan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 415, -1, -1));

        JenisPendapatan5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        JenisPendapatan5.setText("Gaji");
        pPemasukan.add(JenisPendapatan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 465, -1, -1));

        JenisPendapatan6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        JenisPendapatan6.setText("THR");
        pPemasukan.add(JenisPendapatan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 515, -1, -1));

        Rp_Pemasukan.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pemasukan.setText("Rp");
        pPemasukan.add(Rp_Pemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 307, -1, 30));

        Rp_Pemasukan1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pemasukan1.setText("Rp");
        pPemasukan.add(Rp_Pemasukan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 257, -1, 30));

        Rp_Pemasukan2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pemasukan2.setText("Rp");
        pPemasukan.add(Rp_Pemasukan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 357, -1, 30));

        Rp_Pemasukan3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pemasukan3.setText("Rp");
        pPemasukan.add(Rp_Pemasukan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 407, -1, 30));

        Rp_Pemasukan4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pemasukan4.setText("Rp");
        pPemasukan.add(Rp_Pemasukan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 457, -1, 30));

        Rp_Pemasukan5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pemasukan5.setText("Rp");
        pPemasukan.add(Rp_Pemasukan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 507, -1, 30));

        Date1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date1.setText("24/07/2023");
        pPemasukan.add(Date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        Date2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date2.setText("29/07/2023");
        pPemasukan.add(Date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        Date3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date3.setText("28/07/2023");
        pPemasukan.add(Date3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        Date4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date4.setText("27/07/2023");
        pPemasukan.add(Date4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        Date5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date5.setText("26/07/2023");
        pPemasukan.add(Date5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        Date6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date6.setText("25/07/2023");
        pPemasukan.add(Date6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        Payment.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment.setText("Cash");
        pPemasukan.add(Payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 503, -1, 20));

        Payment1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment1.setText("Debit");
        pPemasukan.add(Payment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 303, -1, 20));

        Payment2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment2.setText("Cash");
        pPemasukan.add(Payment2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 253, -1, 20));

        Payment3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment3.setText("E-Money");
        pPemasukan.add(Payment3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 353, -1, 20));

        Payment4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment4.setText("E-Money");
        pPemasukan.add(Payment4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 403, -1, 20));

        Payment5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment5.setText("Debit");
        pPemasukan.add(Payment5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 453, -1, 20));

        add(pPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 260, 560));

        pPengeluaran.setBackground(new java.awt.Color(255, 255, 255));
        pPengeluaran.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(58, 194, 178), new java.awt.Color(58, 194, 178), new java.awt.Color(58, 194, 178), new java.awt.Color(58, 194, 178)));
        pPengeluaran.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GraphPengeluaran.setBackground(new java.awt.Color(255, 255, 255));
        GraphPengeluaran.setLayout(new java.awt.BorderLayout());
        pPengeluaran.add(GraphPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 63, 250, 160));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(53, 157, 145));
        jLabel2.setText("Pengeluaran");
        pPengeluaran.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Garis1.setForeground(new java.awt.Color(53, 157, 145));
        Garis1.setText("__________________________________");
        pPengeluaran.add(Garis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 240, -1));

        Garis2.setForeground(new java.awt.Color(53, 157, 145));
        Garis2.setText("__________________________________");
        pPengeluaran.add(Garis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 240, 20));

        Garis14.setForeground(new java.awt.Color(53, 157, 145));
        Garis14.setText("__________________________________");
        pPengeluaran.add(Garis14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 240, 20));

        Garis15.setForeground(new java.awt.Color(53, 157, 145));
        Garis15.setText("__________________________________");
        pPengeluaran.add(Garis15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 240, 20));

        Garis16.setForeground(new java.awt.Color(53, 157, 145));
        Garis16.setText("__________________________________");
        pPengeluaran.add(Garis16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 240, 20));

        Garis17.setForeground(new java.awt.Color(53, 157, 145));
        Garis17.setText("__________________________________");
        pPengeluaran.add(Garis17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 240, 20));

        Garis18.setForeground(new java.awt.Color(53, 157, 145));
        Garis18.setText("__________________________________");
        pPengeluaran.add(Garis18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 240, 20));

        Garis19.setForeground(new java.awt.Color(53, 157, 145));
        Garis19.setText("__________________________________");
        pPengeluaran.add(Garis19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 240, 20));

        Date13.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date13.setText("29/07/2023");
        pPengeluaran.add(Date13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        Date8.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date8.setText("28/07/2023");
        pPengeluaran.add(Date8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        Date9.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date9.setText("27/07/2023");
        pPengeluaran.add(Date9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        Date10.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date10.setText("26/07/2023");
        pPengeluaran.add(Date10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        Date11.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date11.setText("25/07/2023");
        pPengeluaran.add(Date11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        Date12.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Date12.setText("24/07/2023");
        pPengeluaran.add(Date12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        Payment6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment6.setText("Cash");
        pPengeluaran.add(Payment6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 253, -1, 20));

        Payment7.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment7.setText("E-Money");
        pPengeluaran.add(Payment7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 303, -1, 20));

        Payment8.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment8.setText("Debit");
        pPengeluaran.add(Payment8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 353, -1, 20));

        Payment9.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment9.setText("E-Money");
        pPengeluaran.add(Payment9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 403, -1, 20));

        Payment10.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment10.setText("Cash");
        pPengeluaran.add(Payment10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 453, -1, 20));

        Payment11.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        Payment11.setText("Debit");
        pPengeluaran.add(Payment11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 503, -1, 20));

        Penggunaan1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        Penggunaan1.setText("Nasi Goreng");
        pPengeluaran.add(Penggunaan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 265, -1, -1));

        Penggunaan2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        Penggunaan2.setText("Gojek");
        pPengeluaran.add(Penggunaan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 315, -1, -1));

        Penggunaan3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        Penggunaan3.setText("Paket");
        pPengeluaran.add(Penggunaan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 365, -1, -1));

        Penggunaan4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        Penggunaan4.setText("Voucher");
        pPengeluaran.add(Penggunaan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 415, -1, -1));

        Penggunaan5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        Penggunaan5.setText("Cardigan");
        pPengeluaran.add(Penggunaan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 465, -1, -1));

        Penggunaan6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        Penggunaan6.setText("Burger King");
        pPengeluaran.add(Penggunaan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 515, -1, -1));

        Rp_Pengeluaran2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pengeluaran2.setText("Rp");
        pPengeluaran.add(Rp_Pengeluaran2, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 307, -1, 30));

        Rp_Pengeluaran3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pengeluaran3.setText("Rp");
        pPengeluaran.add(Rp_Pengeluaran3, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 357, -1, 30));

        Rp_Pengeluaran4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pengeluaran4.setText("Rp");
        pPengeluaran.add(Rp_Pengeluaran4, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 407, -1, 30));

        Rp_Pengeluaran5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pengeluaran5.setText("Rp");
        pPengeluaran.add(Rp_Pengeluaran5, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 457, -1, 30));

        Rp_Pengeluaran6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pengeluaran6.setText("Rp");
        pPengeluaran.add(Rp_Pengeluaran6, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 507, -1, 30));

        PengeluaranGraph1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PengeluaranGraph1.setText("10000");
        pPengeluaran.add(PengeluaranGraph1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 262, 70, 20));

        PengeluaranGraph2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PengeluaranGraph2.setText("17000");
        pPengeluaran.add(PengeluaranGraph2, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 312, 70, 20));

        PengeluaranGraph3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PengeluaranGraph3.setText("57000");
        pPengeluaran.add(PengeluaranGraph3, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 362, 70, 20));

        PengeluaranGraph4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PengeluaranGraph4.setText("52000");
        pPengeluaran.add(PengeluaranGraph4, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 412, 70, 20));

        PengeluaranGraph5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PengeluaranGraph5.setText("120000");
        pPengeluaran.add(PengeluaranGraph5, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 462, 70, 20));

        PengeluaranGraph6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        PengeluaranGraph6.setText("90000");
        pPengeluaran.add(PengeluaranGraph6, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 512, 70, 20));

        JenisPemakaian1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisPemakaian1.setText("Makanan");
        pPengeluaran.add(JenisPemakaian1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        JenisPemakaian2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisPemakaian2.setText("Transportasi");
        pPengeluaran.add(JenisPemakaian2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        JenisPemakaian3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisPemakaian3.setText("Lainnya");
        pPengeluaran.add(JenisPemakaian3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        JenisPemakaian4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisPemakaian4.setText("Lainnya");
        pPengeluaran.add(JenisPemakaian4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        JenisPemakaian5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisPemakaian5.setText("Pakaian");
        pPengeluaran.add(JenisPemakaian5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        JenisPemakaian6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        JenisPemakaian6.setText("Makanan");
        pPengeluaran.add(JenisPemakaian6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        Rp_Pengeluaran1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Pengeluaran1.setText("Rp");
        pPengeluaran.add(Rp_Pengeluaran1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 257, -1, 30));

        add(pPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 260, 560));

        Pemasukan_Pengeluaran.setBackground(new java.awt.Color(255, 255, 255));
        Pemasukan_Pengeluaran.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(58, 194, 178), new java.awt.Color(58, 194, 178), new java.awt.Color(58, 194, 178), new java.awt.Color(58, 194, 178)));
        Pemasukan_Pengeluaran.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Pemasukan_Pengeluaran.add(PilihanBulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        Garis5.setForeground(new java.awt.Color(53, 157, 145));
        Garis5.setText("____________");
        Pemasukan_Pengeluaran.add(Garis5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 20));

        Garis6.setForeground(new java.awt.Color(53, 157, 145));
        Garis6.setText("____________");
        Pemasukan_Pengeluaran.add(Garis6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 20));

        Income_Text.setFont(new java.awt.Font("Franklin Gothic Book", 1, 13)); // NOI18N
        Income_Text.setText("Pemasukan");
        Pemasukan_Pengeluaran.add(Income_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        Outcome_Text.setFont(new java.awt.Font("Franklin Gothic Book", 1, 13)); // NOI18N
        Outcome_Text.setText("Pengeluaran");
        Pemasukan_Pengeluaran.add(Outcome_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        Rp_Income_Total.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        Rp_Income_Total.setText("Rp");
        Pemasukan_Pengeluaran.add(Rp_Income_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        Rp_Outcome_Total.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        Rp_Outcome_Total.setText("Rp");
        Pemasukan_Pengeluaran.add(Rp_Outcome_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        OutcomeTotal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        OutcomeTotal.setText("99");
        Pemasukan_Pengeluaran.add(OutcomeTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 70, -1));

        MonthPengeluaran.setBackground(new java.awt.Color(248, 233, 233));
        MonthPengeluaran.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rp_Outcome1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Outcome1.setText(" Rp");
        MonthPengeluaran.add(Rp_Outcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 20));

        Rp_Outcome2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Outcome2.setText(" Rp");
        MonthPengeluaran.add(Rp_Outcome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 20));

        Rp_Outcome3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Outcome3.setText(" Rp");
        MonthPengeluaran.add(Rp_Outcome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 20));

        Rp_Outcome4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Outcome4.setText(" Rp");
        MonthPengeluaran.add(Rp_Outcome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 20));

        Rp_Outcome5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Outcome5.setText(" Rp");
        MonthPengeluaran.add(Rp_Outcome5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 20));

        keluarMinggu1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        keluarMinggu1.setText("99");
        MonthPengeluaran.add(keluarMinggu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, 20));

        keluarMinggu2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        keluarMinggu2.setText("99");
        MonthPengeluaran.add(keluarMinggu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 20));

        keluarMinggu3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        keluarMinggu3.setText("99");
        MonthPengeluaran.add(keluarMinggu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 20));

        keluarMinggu4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        keluarMinggu4.setText("99");
        MonthPengeluaran.add(keluarMinggu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 20));

        keluarMinggu5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        keluarMinggu5.setText("99");
        MonthPengeluaran.add(keluarMinggu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 70, 20));

        Pemasukan_Pengeluaran.add(MonthPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 110, 150));

        MonthPemasukan.setBackground(new java.awt.Color(233, 248, 246));
        MonthPemasukan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rp_Income1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Income1.setText(" Rp");
        MonthPemasukan.add(Rp_Income1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 20));

        Rp_Income2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Income2.setText(" Rp");
        MonthPemasukan.add(Rp_Income2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 20, 20));

        Rp_Income3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Income3.setText(" Rp");
        MonthPemasukan.add(Rp_Income3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 20, 20));

        Rp_Income4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Income4.setText(" Rp");
        MonthPemasukan.add(Rp_Income4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 20, 20));

        Rp_Income5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Rp_Income5.setText(" Rp");
        MonthPemasukan.add(Rp_Income5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 20, 20));

        masukMinggu1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        masukMinggu1.setText("99");
        MonthPemasukan.add(masukMinggu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, 20));

        masukMinggu2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        masukMinggu2.setText("99");
        MonthPemasukan.add(masukMinggu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 20));

        masukMinggu3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        masukMinggu3.setText("99");
        MonthPemasukan.add(masukMinggu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 20));

        masukMinggu4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        masukMinggu4.setText("99");
        MonthPemasukan.add(masukMinggu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 20));

        masukMinggu5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        masukMinggu5.setText("99");
        MonthPemasukan.add(masukMinggu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 70, 20));

        Pemasukan_Pengeluaran.add(MonthPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 110, 150));

        IncomeTotal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 13)); // NOI18N
        IncomeTotal.setText("99");
        Pemasukan_Pengeluaran.add(IncomeTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 70, -1));

        Garis7.setForeground(new java.awt.Color(53, 157, 145));
        Garis7.setText("_______________________________________________");
        Pemasukan_Pengeluaran.add(Garis7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 330, -1));

        DatePemasukan3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan3.setText("30/07");
        Pemasukan_Pengeluaran.add(DatePemasukan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, -1, -1));

        DatePemasukan4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan4.setText("05/08");
        Pemasukan_Pengeluaran.add(DatePemasukan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 55, -1, -1));

        jLabel5.setText("-");
        Pemasukan_Pengeluaran.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 55, -1, -1));

        DatePemasukan5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan5.setText("12/08");
        Pemasukan_Pengeluaran.add(DatePemasukan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 85, -1, -1));

        DatePemasukan6.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan6.setText("19/08");
        Pemasukan_Pengeluaran.add(DatePemasukan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 115, -1, -1));

        DatePemasukan7.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan7.setText("26/08");
        Pemasukan_Pengeluaran.add(DatePemasukan7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 145, -1, -1));

        DatePemasukan8.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan8.setText("02/09");
        Pemasukan_Pengeluaran.add(DatePemasukan8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 175, -1, -1));

        DatePemasukan9.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan9.setText("06/08");
        Pemasukan_Pengeluaran.add(DatePemasukan9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, -1, -1));

        DatePemasukan10.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan10.setText("13/08");
        Pemasukan_Pengeluaran.add(DatePemasukan10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        DatePemasukan11.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan11.setText("20/08");
        Pemasukan_Pengeluaran.add(DatePemasukan11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 145, -1, -1));

        DatePemasukan12.setFont(new java.awt.Font("Franklin Gothic Book", 0, 12)); // NOI18N
        DatePemasukan12.setText("27/08");
        Pemasukan_Pengeluaran.add(DatePemasukan12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 175, -1, -1));

        jLabel6.setText("-");
        Pemasukan_Pengeluaran.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 85, -1, -1));

        jLabel8.setText("-");
        Pemasukan_Pengeluaran.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 115, -1, -1));

        jLabel11.setText("-");
        Pemasukan_Pengeluaran.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 145, -1, -1));

        jLabel12.setText("-");
        Pemasukan_Pengeluaran.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 175, -1, -1));

        add(Pemasukan_Pengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 350, 210));
        add(Kalender, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 350, 240));

        inputTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        inputTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputTransaksiMouseClicked(evt);
            }
        });
        inputTransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moneymanagement/Assets/Icon/input.png"))); // NOI18N
        inputTransaksi.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        add(inputTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 590, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void inputTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputTransaksiMouseClicked
        // Buat instance dari JDialog
        JDialog transaksiDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Transaksi Form", true);

        // Set konten dari JDialog dengan TransaksiForm
        TransaksiForm transaksiForm = new TransaksiForm();
        transaksiDialog.getContentPane().add(transaksiForm);
        transaksiDialog.pack();
        transaksiDialog.setVisible(true);
    }//GEN-LAST:event_inputTransaksiMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date1;
    private javax.swing.JLabel Date10;
    private javax.swing.JLabel Date11;
    private javax.swing.JLabel Date12;
    private javax.swing.JLabel Date13;
    private javax.swing.JLabel Date2;
    private javax.swing.JLabel Date3;
    private javax.swing.JLabel Date4;
    private javax.swing.JLabel Date5;
    private javax.swing.JLabel Date6;
    private javax.swing.JLabel Date8;
    private javax.swing.JLabel Date9;
    private javax.swing.JLabel DatePemasukan10;
    private javax.swing.JLabel DatePemasukan11;
    private javax.swing.JLabel DatePemasukan12;
    private javax.swing.JLabel DatePemasukan3;
    private javax.swing.JLabel DatePemasukan4;
    private javax.swing.JLabel DatePemasukan5;
    private javax.swing.JLabel DatePemasukan6;
    private javax.swing.JLabel DatePemasukan7;
    private javax.swing.JLabel DatePemasukan8;
    private javax.swing.JLabel DatePemasukan9;
    private javax.swing.JLabel Garis1;
    private javax.swing.JLabel Garis10;
    private javax.swing.JLabel Garis11;
    private javax.swing.JLabel Garis12;
    private javax.swing.JLabel Garis13;
    private javax.swing.JLabel Garis14;
    private javax.swing.JLabel Garis15;
    private javax.swing.JLabel Garis16;
    private javax.swing.JLabel Garis17;
    private javax.swing.JLabel Garis18;
    private javax.swing.JLabel Garis19;
    private javax.swing.JLabel Garis2;
    private javax.swing.JLabel Garis3;
    private javax.swing.JLabel Garis4;
    private javax.swing.JLabel Garis5;
    private javax.swing.JLabel Garis6;
    private javax.swing.JLabel Garis7;
    private javax.swing.JLabel Garis8;
    private javax.swing.JLabel Garis9;
    private javax.swing.JPanel GraphPemasukan;
    private javax.swing.JPanel GraphPengeluaran;
    private javax.swing.JLabel IncomeTotal;
    private javax.swing.JLabel Income_Text;
    private javax.swing.JLabel JenisPemakaian1;
    private javax.swing.JLabel JenisPemakaian2;
    private javax.swing.JLabel JenisPemakaian3;
    private javax.swing.JLabel JenisPemakaian4;
    private javax.swing.JLabel JenisPemakaian5;
    private javax.swing.JLabel JenisPemakaian6;
    private javax.swing.JLabel JenisPendapatan1;
    private javax.swing.JLabel JenisPendapatan2;
    private javax.swing.JLabel JenisPendapatan3;
    private javax.swing.JLabel JenisPendapatan4;
    private javax.swing.JLabel JenisPendapatan5;
    private javax.swing.JLabel JenisPendapatan6;
    private javax.swing.JLabel JenisTransaksi1;
    private javax.swing.JLabel JenisTransaksi2;
    private javax.swing.JLabel JenisTransaksi3;
    private javax.swing.JLabel JenisTransaksi4;
    private javax.swing.JLabel JenisTransaksi5;
    private javax.swing.JLabel JenisTransaksi6;
    private com.toedter.calendar.JCalendar Kalender;
    private javax.swing.JPanel MonthPemasukan;
    private javax.swing.JPanel MonthPengeluaran;
    private javax.swing.JLabel OutcomeTotal;
    private javax.swing.JLabel Outcome_Text;
    private javax.swing.JLabel Payment;
    private javax.swing.JLabel Payment1;
    private javax.swing.JLabel Payment10;
    private javax.swing.JLabel Payment11;
    private javax.swing.JLabel Payment2;
    private javax.swing.JLabel Payment3;
    private javax.swing.JLabel Payment4;
    private javax.swing.JLabel Payment5;
    private javax.swing.JLabel Payment6;
    private javax.swing.JLabel Payment7;
    private javax.swing.JLabel Payment8;
    private javax.swing.JLabel Payment9;
    private javax.swing.JLabel PemasukanGraph1;
    private javax.swing.JLabel PemasukanGraph2;
    private javax.swing.JLabel PemasukanGraph3;
    private javax.swing.JLabel PemasukanGraph4;
    private javax.swing.JLabel PemasukanGraph5;
    private javax.swing.JLabel PemasukanGraph6;
    private javax.swing.JPanel Pemasukan_Pengeluaran;
    private javax.swing.JLabel PengeluaranGraph1;
    private javax.swing.JLabel PengeluaranGraph2;
    private javax.swing.JLabel PengeluaranGraph3;
    private javax.swing.JLabel PengeluaranGraph4;
    private javax.swing.JLabel PengeluaranGraph5;
    private javax.swing.JLabel PengeluaranGraph6;
    private javax.swing.JLabel Penggunaan1;
    private javax.swing.JLabel Penggunaan2;
    private javax.swing.JLabel Penggunaan3;
    private javax.swing.JLabel Penggunaan4;
    private javax.swing.JLabel Penggunaan5;
    private javax.swing.JLabel Penggunaan6;
    private com.toedter.calendar.JMonthChooser PilihanBulan;
    private javax.swing.JLabel Rp_Income1;
    private javax.swing.JLabel Rp_Income2;
    private javax.swing.JLabel Rp_Income3;
    private javax.swing.JLabel Rp_Income4;
    private javax.swing.JLabel Rp_Income5;
    private javax.swing.JLabel Rp_Income_Total;
    private javax.swing.JLabel Rp_Outcome1;
    private javax.swing.JLabel Rp_Outcome2;
    private javax.swing.JLabel Rp_Outcome3;
    private javax.swing.JLabel Rp_Outcome4;
    private javax.swing.JLabel Rp_Outcome5;
    private javax.swing.JLabel Rp_Outcome_Total;
    private javax.swing.JLabel Rp_Pemasukan;
    private javax.swing.JLabel Rp_Pemasukan1;
    private javax.swing.JLabel Rp_Pemasukan2;
    private javax.swing.JLabel Rp_Pemasukan3;
    private javax.swing.JLabel Rp_Pemasukan4;
    private javax.swing.JLabel Rp_Pemasukan5;
    private javax.swing.JLabel Rp_Pengeluaran1;
    private javax.swing.JLabel Rp_Pengeluaran2;
    private javax.swing.JLabel Rp_Pengeluaran3;
    private javax.swing.JLabel Rp_Pengeluaran4;
    private javax.swing.JLabel Rp_Pengeluaran5;
    private javax.swing.JLabel Rp_Pengeluaran6;
    private javax.swing.JPanel inputTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel keluarMinggu1;
    private javax.swing.JLabel keluarMinggu2;
    private javax.swing.JLabel keluarMinggu3;
    private javax.swing.JLabel keluarMinggu4;
    private javax.swing.JLabel keluarMinggu5;
    private javax.swing.JLabel masukMinggu1;
    private javax.swing.JLabel masukMinggu2;
    private javax.swing.JLabel masukMinggu3;
    private javax.swing.JLabel masukMinggu4;
    private javax.swing.JLabel masukMinggu5;
    private javax.swing.JPanel pPemasukan;
    private javax.swing.JPanel pPengeluaran;
    // End of variables declaration//GEN-END:variables
}
