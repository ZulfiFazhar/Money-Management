/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement;
import java.sql.SQLException;
import moneymanagement.Entity.Users;
import moneymanagement.Exception.UsersException;
import moneymanagement.View.Login;
import moneymanagement.Model.Koneksi;
import moneymanagement.Service.UsersDAO;

/**
 *
 * @author Kelompok 3
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws moneymanagement.Exception.UsersException
     */
    public static void main(String[] args) throws SQLException, UsersException {
        Koneksi.getConnection();
        
//        UsersDAO dao = Koneksi.getUsers();
//        Users users = new Users();
//        
//        users.setUsername("admin3");
//        users.setEmail("admin3@gmail.com");
//        users.setPassword("admin3");
//        
//        dao.insertUsers(users);
        
        Login login = new Login();
        login.setVisible(true);
    }
    
}
