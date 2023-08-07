package moneymanagement.Main;

import moneymanagement.Controller.Register.RegisterController;
import moneymanagement.View.Register;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Register registerView = new Register();
            RegisterController registerController = new RegisterController(registerView);
            registerController.showView();
        });
    }
    
}
