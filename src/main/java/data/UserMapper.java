/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MartinLodahl
 */
public class UserMapper {

    Connection conn;

    public UserMapper() {
        this.conn = new DBLocal().getConnection();
    }

    public boolean createUser(User user) {
        //Returns true, if the user was created
        try {
            String sql = "SELECT * FROM user where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return false;
            }
            int hashPassword = user.getPassword().hashCode();
            String hashString = String.valueOf(hashPassword);
            sql = "INSERT INTO user (username, password, balance) values (?, ?, ?);";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, hashString);
            pstmt.setInt(3, user.getBalance());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public User checkLogin(User user) {
        try {
            int hashPassword = user.getPassword().hashCode();
            String hashString = String.valueOf(hashPassword);
            String sql = "SELECT * FROM user where username =? AND password = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, hashString);
            ResultSet rs = pstmt.executeQuery();
            int balance = 0;
            if (rs.next()) {
                balance = rs.getInt("balance");
                user.setBalance(balance);
                return user;
            }
            return new User("Bob", "123", 0);
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new User("Bob", "123", 0);
    }

    public static void main(String[] args) {
        UserMapper um = new UserMapper();
        User user = new User("Ali", "Dogan", 123);
        um.createUser(user);
        User user2 = um.checkLogin(user);
        user = new User("Peder", "1", user2.getBalance());
        um.createUser(user);
    }

}
