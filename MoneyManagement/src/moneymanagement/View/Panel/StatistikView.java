/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement.View.Panel;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import moneymanagement.Model.Panel.PemasukanModel;
import moneymanagement.Model.Panel.PengeluaranModel;
import moneymanagement.Model.User.UserSession;

public class StatistikView extends javax.swing.JPanel {
    
    public StatistikView() {
        initComponents();
        this.setPreferredSize(new Dimension(920, 720));
        this.setBackground(Color.white);
        refresh();
    }
    
    private int[] masukCash = new int[9];
    private int[] masukDebit = new int[9];
    private int[] masukEmoney = new int[9];
    
    private int[] keluarCash = new int[9];
    private int[] keluarDebit = new int[9];
    private int[] keluarEmoney = new int[9];
    
    public void refresh(){
        String username = UserSession.getUsername();
        PemasukanModel pemasukan = new PemasukanModel();
        PengeluaranModel pengeluaran = new PengeluaranModel();

        for (int i = 0; i < 9; i++) {
            String day = (i + 7) < 10 ? "0" + (i + 7) : String.valueOf(i + 7);
            String tanggal = day + "/08/2023";

            masukCash[i] = pemasukan.getTanggalCashByUsername(username, tanggal);
            masukDebit[i] = pemasukan.getTanggalDebitByUsername(username, tanggal);
            masukEmoney[i] = pemasukan.getTanggalEmoneyByUsername(username, tanggal);

            keluarCash[i] = pengeluaran.getTanggalCashByUsername(username, tanggal);
            keluarDebit[i] = pengeluaran.getTanggalDebitByUsername(username, tanggal);
            keluarEmoney[i] = pengeluaran.getTanggalEmoneyByUsername(username, tanggal);
        }
        
        valueCash = new int[]{masukCash[0],masukCash[1],masukCash[2],masukCash[3],masukCash[4],masukCash[5],masukCash[6]};
        valueDebit = new int[]{masukDebit[0],masukDebit[1],masukDebit[2],masukDebit[3],masukDebit[4],masukDebit[5],masukDebit[6]};
        valueEMoney = new int[]{masukEmoney[0],masukEmoney[1],masukEmoney[2],masukEmoney[3],masukEmoney[4],masukEmoney[5],masukEmoney[6]};
        
        valueCash1 = new int[]{keluarCash[0],keluarCash[1],keluarCash[2],keluarCash[3],keluarCash[4],keluarCash[5],keluarCash[6]};
        valueDebit1 = new int[]{keluarDebit[0],keluarDebit[1],keluarDebit[2],keluarDebit[3],keluarDebit[4],keluarDebit[5],keluarDebit[6]};
        valueEMoney1 = new int[]{keluarEmoney[0],keluarEmoney[1],keluarEmoney[2],keluarEmoney[3],keluarEmoney[4],keluarEmoney[5],keluarEmoney[6]};
        
    }
    
    private String[] categories = { "Cash", "Debit", "eMoney" };

    private String[] tanggal ={"07/08/2023","08/08/2023","09/08/2023","09/08/2023","10/08/2023","11/08/2023","12/08/2023","13/08/2023","14/08/2023"} ;
    private int[] valueCash;
    private int[] valueDebit;
    private int[] valueEMoney;

    private String[] tanggal1 ={"07/08/2023","08/08/2023","09/08/2023","09/08/2023","10/08/2023","11/08/2023","12/08/2023","13/08/2023","14/08/2023"} ;
    private int[] valueCash1;
    private int[] valueDebit1;
    private int[] valueEMoney1;
    
    private int nilaiMaxData = 10000000;
    
//  Warna 
    private Color getColorForIndex(int index) {
        switch (index % 3) {
            case 0:
                return new Color(243, 188, 224);
            case 1:
                return new Color(181, 231, 231);
            case 2:
                return new Color(174, 184, 219);
            default:
                return Color.black;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        GeneralPath cv = new GeneralPath(GeneralPath.WIND_NON_ZERO);

    // GRAFIK 1 
    // Menggambar garis vertikal
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(211, 211, 211));
        
        // Garis horizontal atas GRAFIK 1
        cv.moveTo(45, 100);
        cv.lineTo(895, 100);
        
        // Garis horizontal atas
        cv.moveTo(45, 400);
        cv.lineTo(895, 400);
        
        // Garis horizontal bawah GRAFIK 1
        cv.moveTo(45, 330);
        cv.lineTo(895, 330);
        
        // Garis horizontal bawah
        cv.moveTo(45, 620);
        cv.lineTo(895, 620);
        
        // Garis samping vertikal kiri kanan GRAFIK 1
        cv.moveTo(45, 100);
        cv.lineTo(45, 330);
        cv.moveTo(895, 100);
        cv.lineTo(895, 330);
        
        // Garis samping vertikal kiri kanan 
        cv.moveTo(45, 400);
        cv.lineTo(45, 620);
        cv.moveTo(895, 400);
        cv.lineTo(895, 620);
       
        // Garis-garis horizontal di tengah GRAFIK 1
        for (int i = 0; i < 6; i++) {
            int y = 150 + i * 30;
            cv.moveTo(60, y);
            cv.lineTo(875, y);
        }
        
        // Garis-garis horizontal di tengah
        for (int i = 0; i < 6; i++) {
            int y = 440 + i * 30;
            cv.moveTo(60, y);
            cv.lineTo(875, y);
        }
        
        
        
        cv.closePath();
        g2d.draw(cv);
        
        // Menambahkan No Skala  
        String[] scaleValues = { "10","8", "6", "4", "2", "0" };
        for (int i = 0; i < scaleValues.length; i++) {
            g2d.drawString(scaleValues[i], 46, 145 + i * 30);  // GRAFIK 1
            //2
            g2d.drawString(scaleValues[i], 46, 440 + i * 30);  //  GRAFIK 2
        }
        

       // Variabel Pembantu
        int xJarakIcon = 700;
        int xBatangCash = 70;
        int xBatangDebit = 90;
        int xBatangEMoney = 110;
        int y = 300;
        int lebarBatang = 20;
        int xTangggal = 63;
        
        // Variabel Pembantu 2 
        int xJarakIcon2 = 700;
        int xBatangCash2 = 70;
        int xBatangDebit2 = 90;
        int xBatangEMoney2 = 110;
        int y2 = 590;
        int lebarBatang2 = 20;
        int xTangggal2 = 63;
        
        //  Kategori // GRAFIK 1
        for (int i = 0; i < categories.length; i++) {
            Rectangle2D.Double bar = new Rectangle2D.Double(xJarakIcon +(i * 55), 120, 15, 15);
            g2d.setColor(Color.black);
             
            g2d.drawString(categories[i], xJarakIcon + 19 +(i * 55), 133);
            g2d.setColor(getColorForIndex(i));
            g2d.fill(bar);
        }
        //  Kategori 
        for (int i = 0; i < categories.length; i++) {
            Rectangle2D.Double bar = new Rectangle2D.Double(xJarakIcon +(i * 55), 415, 15, 15);
            g2d.setColor(Color.black);
             
            g2d.drawString(categories[i], xJarakIcon + 19 +(i * 55), 428);
            g2d.setColor(getColorForIndex(i));
            g2d.fill(bar);
        }
        //value Cash // GRAFIK 1
        for (int i = 0; i < valueCash.length; i++) {
            int barHeight = (int) (((double) valueCash[i] / nilaiMaxData) * 150);
            Rectangle2D.Double bar = new Rectangle2D.Double(xBatangCash * 1, y - barHeight, lebarBatang, barHeight);
            g2d.setColor(new Color(243, 188, 224));
            g2d.fill(bar);
            xBatangCash = xBatangCash + 90;
        }
        //value Cash2
        for (int i = 0; i < valueCash1.length; i++) {
            int barHeight = (int) (((double) valueCash1[i] / nilaiMaxData) * 150);
            Rectangle2D.Double bar = new Rectangle2D.Double(xBatangCash2 * 1, y2 - barHeight, lebarBatang, barHeight);
            g2d.setColor(new Color(243, 188, 224));
            g2d.fill(bar);
            xBatangCash2 = xBatangCash2 + 90;
        }
//        valueDebit // GRAFIK 1
        for (int i = 0; i < valueDebit.length; i++) {          
            int barHeight = (int) (((double) valueDebit[i] / nilaiMaxData) * 150);
            
            Rectangle2D.Double bar = new Rectangle2D.Double(xBatangDebit * 1, y - barHeight, lebarBatang , barHeight);
            g2d.setColor(new Color(181, 231, 231));
            g2d.fill(bar);
            xBatangDebit = xBatangDebit + 90;
        }
        //valueDebit2
        for (int i = 0; i < valueDebit1.length; i++) {          
            int barHeight = (int) (((double) valueDebit1[i] / nilaiMaxData) * 150);
            
            Rectangle2D.Double bar = new Rectangle2D.Double(xBatangDebit2 * 1, y2 - barHeight, lebarBatang , barHeight);
            g2d.setColor(new Color(181, 231, 231));
            g2d.fill(bar);
            xBatangDebit2 = xBatangDebit2 + 90;
        }
//        valueMoney// GRAFIK 1
        for (int i = 0; i < valueEMoney.length; i++) {          
            int barHeight = (int) (((double) valueEMoney[i] / nilaiMaxData) * 150);
            Rectangle2D.Double bar = new Rectangle2D.Double(xBatangEMoney  * 1, y - barHeight, lebarBatang , barHeight);
            g2d.setColor(new Color(174, 184, 219));
            g2d.fill(bar);
            xBatangEMoney = xBatangEMoney + 90;
        }
        //        valueMoney
        for (int i = 0; i < valueEMoney1.length; i++) {          
            int barHeight = (int) (((double) valueEMoney1[i] / nilaiMaxData) * 150);
            Rectangle2D.Double bar = new Rectangle2D.Double(xBatangEMoney2  * 1, y2 - barHeight, lebarBatang , barHeight);
            g2d.setColor(new Color(174, 184, 219));
            g2d.fill(bar);
            xBatangEMoney2 = xBatangEMoney2 + 90;
        }
        
        // tanggal // GRAFIK 1
        g2d.setFont(new Font("inter", Font.PLAIN, 15));
        for (int i = 0; i < tanggal.length; i++) {
            g2d.setColor(new Color(0, 0, 0));
            g2d.drawString(tanggal[i], xTangggal+ (i * 90), y + 22);
    
        }
        // tanggal
        g2d.setFont(new Font("inter", Font.PLAIN, 15));
        for (int i = 0; i < tanggal1.length; i++) {
            g2d.setColor(new Color(0, 0, 0));
            g2d.drawString(tanggal1[i], xTangggal+ (i * 90), y2 + 22);
    
        }
        
        // GRAFIK END ----------------------------------------------------------
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moneymanagement/Assets/Icon/statistik-title.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(53, 157, 145));
        jLabel2.setText("Pemasukan");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(53, 157, 145));
        jLabel3.setText("Pengeluaran");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
