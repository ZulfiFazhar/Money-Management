/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement.Service;
import java.sql.SQLException;
import moneymanagement.Entity.Users;
import moneymanagement.Exception.UsersException;
import moneymanagement.View.Dashboard;

/**
 *
 * @author Kelompok 3
 */
public interface UsersDAO {
    public void insertUsers(Users users) throws UsersException;
    Users getUserByUsername(String username) throws SQLException, UsersException;
    Dashboard getNameByUsername(String username) throws SQLException, UsersException;
}
