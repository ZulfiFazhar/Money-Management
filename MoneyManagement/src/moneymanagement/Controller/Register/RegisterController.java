package moneymanagement.Controller.Register;

import javax.swing.JOptionPane;
import moneymanagement.Model.User.UserModel;
import moneymanagement.View.Register;

public class RegisterController {
    private Register view;
    private String username, email, password;

    public RegisterController(Register view) {
        this.view = view;
        initView();
    }

    private void initView() {
        view.getRegisterButton().addActionListener(e -> registerButtonActionPerformed());
    }

    private void registerButtonActionPerformed() {
        username = view.getRegisterUsername().getText();
        email = view.getRegisterEmail().getText();
        password = view.getRegisterPassword().getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        UserModel userModel = new UserModel(username, email, password);
        boolean success = userModel.registerUser();

        if (success) {
            JOptionPane.showMessageDialog(view, "Registrasi Berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Registrasi Berhasil!");
        } else {
            JOptionPane.showMessageDialog(view, "Registrasi Gagal.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Registrasi Gagal.");
        }
    }

    public void showView() {
        view.setVisible(true);
    }
}
