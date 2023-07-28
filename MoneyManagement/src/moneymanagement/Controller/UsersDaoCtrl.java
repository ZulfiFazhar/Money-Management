/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import moneymanagement.Entity.Users;
import moneymanagement.Exception.UsersException;
import moneymanagement.Service.UsersDAO;

/**
 *
 * @author Kelompok 3
 */
public class UsersDaoCtrl implements UsersDAO {
    private Connection connection;
    private final String insertUsers = "INSERT INTO users"
                                       + "(username,email,password) "
                                       + "VALUES(?,?,?)";

    public UsersDaoCtrl(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public void insertUsers(Users users) throws UsersException {
        PreparedStatement statement = null;
        
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertUsers);
            statement.setString(1, users.getUsername());
            statement.setString(2, users.getEmail());
            statement.setString(3, users.getPassword());
            statement.executeUpdate();
            
            connection.commit();
        }
        catch(SQLException ex){
            try{
                connection.rollback();
            } catch(SQLException e){
            }
            throw new UsersException(ex.getMessage());
        }
        finally{
            try{
                connection.setAutoCommit(true);
            } catch(SQLException e){
            }
            if(statement != null){
                try{
                    statement.close();
                } catch(SQLException ex){
                }
            }
        }
    }
    
    
}
