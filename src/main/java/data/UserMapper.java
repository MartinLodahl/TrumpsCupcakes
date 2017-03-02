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
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUser(String userName) {
        try {
           
           
            String sql = "SELECT * FROM user where username =?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            int balance = 0;
            if (rs.next()) {
                User user = new User();
                balance = rs.getInt("balance");
                user.setBalance(balance);
                user.setUsername(userName);
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}