/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement.Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import moneymanagement.Entity.Users;
import moneymanagement.Exception.UsersException;
import moneymanagement.Model.Koneksi;
import moneymanagement.Service.UsersDAO;
import moneymanagement.View.Register;

/**
 *
 * @author Kelompok 3
 */
public class UsersController {
    public void tambahUser(Register register) throws SQLException, UsersException{
        Koneksi.getConnection();
        
        UsersDAO dao = Koneksi.getUsers();
        Users users = new Users();
        
        users.setUsername(register.getRegisterUsername().getText());
        users.setEmail(register.getRegisterEmail().getText());
        users.setPassword(register.getRegisterPassword().getText());
        
        if(users.getUsername().trim().equals("")){
            JOptionPane.showMessageDialog(register, "username tidak boleh kosong");
        } else if(users.getEmail().trim().equals("")){
            JOptionPane.showMessageDialog(register, "email tidak boleh kosong");
        } else if(users.getPassword().trim().equals("")){
            JOptionPane.showMessageDialog(register, "password tidak boleh kosong");
        } else {
            dao.insertUsers(users);
            JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
        }
    }
}
