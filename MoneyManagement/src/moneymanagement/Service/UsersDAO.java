/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement.Service;
import moneymanagement.Entity.Users;
import moneymanagement.Exception.UsersException;

/**
 *
 * @author Kelompok 3
 */
public interface UsersDAO {
    public void insertUsers(Users users) throws UsersException;
}
