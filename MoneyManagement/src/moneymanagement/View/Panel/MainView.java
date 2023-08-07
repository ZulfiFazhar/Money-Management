package moneymanagement.View.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;
import moneymanagement.Model.Panel.PemasukanModel;
import moneymanagement.Model.Panel.PengeluaranModel;
import moneymanagement.Model.User.UserSession;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public final class MainView extends javax.swing.JPanel {
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        dt();
        time();
        
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
        
        bulananTotal.setText(Integer.toString((int) pemasukanBulanan));
        bonusTotal.setText(Integer.toString((int) pemasukanBonus));
        thrTotal.setText(Integer.toString((int) pemasukanThr));
        bulananPersen.setText(" "+Integer.toString((int) bulanan)+"% ");
        bonusPersen.setText(" "+Integer.toString((int) bonus)+"% ");
        thrPersen.setText(" "+Integer.toString((int) thr)+"% ");
        
        makanTotal.setText(Integer.toString((int) pengeluaranMakan));
        transTotal.setText(Integer.toString((int) pengeluaranTransportasi));
        interTotal.setText(Integer.toString((int) pengeluaranInternet));
        makanPersen.setText(" "+Integer.toString((int) makan)+"% ");
        transPersen.setText(" "+Integer.toString((int) transportasi)+"% ");
        interPersen.setText(" "+Integer.toString((int) internet)+"% ");
    }

    public JLabel getCashSaldoDashboard() {
        return cashSaldoDashboard;
    }

    public void setCashSaldoDashboard(JLabel cashSaldoDashboard) {
        this.cashSaldoDashboard = cashSaldoDashboard;
    }

    public JLabel getDebitSaldoDashboard() {
        return debitSaldoDashboard;
    }

    public void setDebitSaldoDashboard(JLabel debitSaldoDashboard) {
        this.debitSaldoDashboard = debitSaldoDashboard;
    }

    public JLabel getEmoneySaldoDashboard() {
        return emoneySaldoDashboard;
    }

    public void setEmoneySaldoDashboard(JLabel emoneySaldoDashboard) {
        this.emoneySaldoDashboard = emoneySaldoDashboard;
    }

    public JLabel getTotalSaldoDashboard() {
        return totalSaldoDashboard;
    }

    public void setTotalSaldoDashboard(JLabel totalSaldoDashboard) {
        this.totalSaldoDashboard = totalSaldoDashboard;
    }
    
    public void setSaldoLabels(int totalSaldo, int cashSaldo, int debitSaldo, int emoneySaldo) {
        totalSaldoDashboard.setText(Integer.toString(totalSaldo));
        cashSaldoDashboard.setText(Integer.toString(cashSaldo));
        debitSaldoDashboard.setText(Integer.toString(debitSaldo));
        emoneySaldoDashboard.setText(Integer.toString(emoneySaldo));
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
    
    public void dt(){
        
        Date d = new Date();
        
        SimpleDateFormat sdf = new  SimpleDateFormat("dd-MM-yyyy");
        
        String dd = sdf.format(d);
        l_date.setText(dd);
    }
    
    Timer t;
    SimpleDateFormat st;
    
    public void time(){
        
        t =  new Timer(0, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                   
                Date dt = new Date();
                st = new SimpleDateFormat("HH:mm:ss");
                
                String tt  = st.format(dt);
                l_time.setText(tt);
                
                }
        
        });
        
        t.start();
    
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
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalSaldoDashboard = new javax.swing.JLabel();
        debitSaldoDashboard = new javax.swing.JLabel();
        cashSaldoDashboard = new javax.swing.JLabel();
        emoneySaldoDashboard = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        GraphPengeluaran = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        transPersen = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        transTotal = new javax.swing.JLabel();
        interPersen = new javax.swing.JLabel();
        interTotal = new javax.swing.JLabel();
        makanTotal = new javax.swing.JLabel();
        makanPersen = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        GraphPemasukan = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        thrPersen = new javax.swing.JLabel();
        bulananPersen = new javax.swing.JLabel();
        bonusPersen = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        thrTotal = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        bulananTotal = new javax.swing.JLabel();
        bonusTotal = new javax.swing.JLabel();
        clock = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        l_time = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moneymanagement/Assets/Icon/dashboard-title.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 194, 178)));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 270));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(58, 194, 178));
        jPanel6.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(58, 194, 178));
        jPanel7.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 114, 104));
        jLabel2.setText("Saldoku");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(53, 157, 145));
        jLabel5.setText("Total");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(53, 157, 145));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 98, 230, -1));

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(53, 157, 145));
        jLabel6.setText("Cash");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(53, 157, 145));
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 230, -1));

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(53, 157, 145));
        jLabel7.setText("E-Money");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(53, 157, 145));
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 200, -1));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(53, 157, 145));
        jLabel9.setText("Debit");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(53, 157, 145));
        jPanel5.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 230, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 15)); // NOI18N
        jLabel3.setText("Rp");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 15)); // NOI18N
        jLabel4.setText("Rp");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Book", 0, 15)); // NOI18N
        jLabel10.setText("Rp");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Book", 0, 15)); // NOI18N
        jLabel11.setText("Rp");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        totalSaldoDashboard.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 15)); // NOI18N
        totalSaldoDashboard.setText("0");
        totalSaldoDashboard.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel5.add(totalSaldoDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 90, -1));

        debitSaldoDashboard.setFont(new java.awt.Font("Franklin Gothic Book", 0, 15)); // NOI18N
        debitSaldoDashboard.setText("0");
        jPanel5.add(debitSaldoDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        cashSaldoDashboard.setFont(new java.awt.Font("Franklin Gothic Book", 0, 15)); // NOI18N
        cashSaldoDashboard.setText("0");
        jPanel5.add(cashSaldoDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        emoneySaldoDashboard.setFont(new java.awt.Font("Franklin Gothic Book", 0, 15)); // NOI18N
        emoneySaldoDashboard.setText("0");
        jPanel5.add(emoneySaldoDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 310, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 194, 178)));
        jPanel8.setPreferredSize(new java.awt.Dimension(540, 270));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(58, 194, 178));
        jPanel9.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        jPanel10.setBackground(new java.awt.Color(58, 194, 178));
        jPanel10.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, -1, -1));

        jPanel11.setBackground(new java.awt.Color(58, 194, 178));
        jPanel11.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        GraphPengeluaran.setBackground(new java.awt.Color(255, 255, 255));
        GraphPengeluaran.setLayout(new java.awt.BorderLayout());
        jPanel8.add(GraphPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 250, 160));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(37, 114, 104));
        jLabel12.setText("Pengeluaran");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel31.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel31.setText("Makan");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel30.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel30.setText("Transportasi");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        transPersen.setBackground(new java.awt.Color(255, 151, 80));
        transPersen.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        transPersen.setForeground(new java.awt.Color(255, 255, 255));
        transPersen.setText(" 99% ");
        transPersen.setOpaque(true);
        jPanel8.add(transPersen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel29.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel29.setText("Rp");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        transTotal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        transTotal.setText("99");
        jPanel8.add(transTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 70, -1));

        interPersen.setBackground(new java.awt.Color(255, 208, 66));
        interPersen.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        interPersen.setForeground(new java.awt.Color(255, 255, 255));
        interPersen.setText(" 99% ");
        interPersen.setOpaque(true);
        jPanel8.add(interPersen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, -1));

        interTotal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        interTotal.setText("99");
        jPanel8.add(interTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 70, -1));

        makanTotal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        makanTotal.setText("99");
        jPanel8.add(makanTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 70, -1));

        makanPersen.setBackground(new java.awt.Color(253, 111, 99));
        makanPersen.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        makanPersen.setForeground(new java.awt.Color(255, 255, 255));
        makanPersen.setText(" 99% ");
        makanPersen.setOpaque(true);
        jPanel8.add(makanPersen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        jLabel34.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel34.setText("Rp");
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 20, -1));

        jLabel28.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel28.setText("Internet");
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        jLabel33.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel33.setText("Rp");
        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 194, 178)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(58, 194, 178));
        jPanel13.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        jPanel14.setBackground(new java.awt.Color(58, 194, 178));
        jPanel14.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, -1, -1));

        jPanel15.setBackground(new java.awt.Color(58, 194, 178));
        jPanel15.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        GraphPemasukan.setBackground(new java.awt.Color(255, 255, 255));
        GraphPemasukan.setLayout(new java.awt.BorderLayout());
        jPanel12.add(GraphPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 250, 160));

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(37, 114, 104));
        jLabel8.setText("Pemasukan");
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        thrPersen.setBackground(new java.awt.Color(255, 208, 66));
        thrPersen.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        thrPersen.setForeground(new java.awt.Color(255, 255, 255));
        thrPersen.setText(" 99% ");
        thrPersen.setOpaque(true);
        jPanel12.add(thrPersen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        bulananPersen.setBackground(new java.awt.Color(253, 111, 99));
        bulananPersen.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        bulananPersen.setForeground(new java.awt.Color(255, 255, 255));
        bulananPersen.setText(" 99% ");
        bulananPersen.setOpaque(true);
        jPanel12.add(bulananPersen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        bonusPersen.setBackground(new java.awt.Color(255, 151, 80));
        bonusPersen.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        bonusPersen.setForeground(new java.awt.Color(255, 255, 255));
        bonusPersen.setText(" 99% ");
        bonusPersen.setOpaque(true);
        jPanel12.add(bonusPersen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel16.setText("THR");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jLabel17.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel17.setText("Rp");
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        jLabel18.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel18.setText("Bonus");
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel19.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel19.setText("Bulanan");
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        thrTotal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        thrTotal.setText("99");
        jPanel12.add(thrTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 70, -1));

        jLabel21.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel21.setText("Rp");
        jPanel12.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jLabel22.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jLabel22.setText("Rp");
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        bulananTotal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        bulananTotal.setText("99");
        jPanel12.add(bulananTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 70, -1));

        bonusTotal.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        bonusTotal.setText("99");
        jPanel12.add(bonusTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 70, -1));

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        clock.setBackground(new java.awt.Color(255, 255, 255));
        clock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 194, 178)));
        clock.setPreferredSize(new java.awt.Dimension(300, 270));
        clock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(58, 194, 178));
        jPanel19.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        clock.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        jPanel20.setBackground(new java.awt.Color(58, 194, 178));
        jPanel20.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        clock.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(37, 114, 104));
        jLabel13.setText("Clock");
        clock.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        l_time.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        l_time.setForeground(new java.awt.Color(37, 114, 104));
        l_time.setText("0");
        clock.add(l_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(37, 114, 104));
        jLabel23.setText("Date");
        clock.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        l_date.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        l_date.setForeground(new java.awt.Color(37, 114, 104));
        l_date.setText("0");
        clock.add(l_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, -1));

        add(clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 310, 260));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GraphPemasukan;
    private javax.swing.JPanel GraphPengeluaran;
    private javax.swing.JLabel bonusPersen;
    private javax.swing.JLabel bonusTotal;
    private javax.swing.JLabel bulananPersen;
    private javax.swing.JLabel bulananTotal;
    private javax.swing.JLabel cashSaldoDashboard;
    private javax.swing.JPanel clock;
    private javax.swing.JLabel debitSaldoDashboard;
    private javax.swing.JLabel emoneySaldoDashboard;
    private javax.swing.JLabel interPersen;
    private javax.swing.JLabel interTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_time;
    private javax.swing.JLabel makanPersen;
    private javax.swing.JLabel makanTotal;
    private javax.swing.JLabel thrPersen;
    private javax.swing.JLabel thrTotal;
    private javax.swing.JLabel totalSaldoDashboard;
    private javax.swing.JLabel transPersen;
    private javax.swing.JLabel transTotal;
    // End of variables declaration//GEN-END:variables
}
