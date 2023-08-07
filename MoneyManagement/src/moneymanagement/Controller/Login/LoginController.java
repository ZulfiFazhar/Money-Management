package moneymanagement.Controller.Login;

import javax.swing.JOptionPane;
import moneymanagement.Model.User.UserModel;
import moneymanagement.Model.User.UserSession;
import moneymanagement.View.Dashboard;
import moneymanagement.View.Login;

public class LoginController {
    private Login view;

    public LoginController(Login view) {
        this.view = view;
        initView();
    }

    private void initView() {
        view.getLoginButton().addActionListener(e -> loginButtonActionPerformed());
    }

    private void loginButtonActionPerformed() {
        String username = view.getLoginUsername().getText();
        String password = view.getLoginPassword().getText();

        UserModel userModel = new UserModel(username, password);
        boolean success = userModel.checkLogin(); // Pass the input to checkLogin

        if (success) {
            UserSession.setUsername(username);
            UserSession.setEmail(userModel.getEmail());
            view.dispose();
            // Redirect to Dashboard (You need to create Dashboard class)
            Dashboard dashboard = new Dashboard();
            dashboard.setUserInfo(UserSession.getUsername(), UserSession.getEmail());
            dashboard.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Username atau Password Salah.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Login Gagal.");
            // Show error message to user if needed
        }
    }

    public void showView() {
        view.setVisible(true);
    }
}
