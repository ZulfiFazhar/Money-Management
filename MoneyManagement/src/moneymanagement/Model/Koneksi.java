/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement.Model;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import moneymanagement.Controller.UsersController;
import moneymanagement.Controller.UsersDaoCtrl;
import moneymanagement.Entity.Users;
import moneymanagement.Exception.UsersException;
import moneymanagement.Service.UsersDAO;
/**
 *
 * @author Kelompok 3
 */
public class Koneksi {
    private static Connection connection;
    private static UsersDAO usersDAO;
    
    public static Connection getConnection() throws SQLException{
        
        if(connection == null){
            MysqlDataSource dataSource = new MysqlDataSource();
        
            dataSource.setURL("jdbc:mysql://localhost:3306/money_management");
            dataSource.setUser("root");
            dataSource.setPassword("");
            
            connection = dataSource.getConnection();
        }
        return connection;
    }
    
    public static UsersDAO getUsers() throws SQLException{
        if(usersDAO == null){
            usersDAO = new UsersDaoCtrl(getConnection());
        }
        return usersDAO;
    }

}
