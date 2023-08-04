/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement.Controller.Dashboard;

import moneymanagement.View.Dashboard;
import moneymanagement.View.DashboardPanel.DashboardView;
import moneymanagement.View.DashboardPanel.SaldoView;

/**
 *
 * @author zulfi
 */
public class DashboardController {
    private DashboardView dashboardView;
    private SaldoView saldoView;

    public void setDashboardView(DashboardView dashboardView) {
        this.dashboardView = dashboardView;
    }
    public void setSaldoView(SaldoView saldoView) {
        this.saldoView = saldoView;
    }
    
    public void tampilDashboardView(Dashboard dashboard){
        if (dashboardView != null && dashboard.getMainPanel() != null){
            dashboard.getMainPanel().removeAll();
            dashboard.getMainPanel().repaint();
            dashboard.getMainPanel().revalidate();

            dashboard.getMainPanel().add(dashboardView.getDashboardPanel);
            dashboard.getMainPanel().repaint();
            dashboard.getMainPanel().revalidate();
        }
    }
    
    public void tampilSaldoView(Dashboard dashboard){
        if (dashboardView != null && dashboard.getMainPanel() != null){
            dashboard.getMainPanel().removeAll();
            dashboard.getMainPanel().repaint();
            dashboard.getMainPanel().revalidate();

            dashboard.getMainPanel().add(saldoView.getSaldoPanel);
            dashboard.getMainPanel().repaint();
            dashboard.getMainPanel().revalidate();
        }
    }
}
