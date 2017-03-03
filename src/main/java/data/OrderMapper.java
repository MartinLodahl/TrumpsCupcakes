/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Cupcake;
import domain.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MartinLodahl
 */
public class OrderMapper {

    Connection conn;

    public OrderMapper() {
        this.conn = new DB().getConnection();
    }

    public boolean checkMoney(ArrayList<Cupcake> arrayList, User user) {
        try {
            int j = arrayList.size();
            int totalPrice = 0;
            for (int i = 0; i < j; i++) {
                int priceBot = 0;
                int priceTop = 0;
                String sql = "SELECT * FROM bot where taste =?;";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, arrayList.get(i).getBot());
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    priceBot = rs.getInt("price");
                    totalPrice += (priceBot * arrayList.get(i).getQuantity());
                }
                sql = "SELECT * FROM top where taste =?;";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, arrayList.get(i).getTop());
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    priceTop = rs.getInt("price");
                    totalPrice += (priceTop * arrayList.get(i).getQuantity());
                }
                Cupcake arrayI = arrayList.get(i);
                arrayI.setPrice((priceTop + priceBot) * arrayList.get(i).getQuantity());
                arrayList.set(i, arrayI);
            }
            if (user.getBalance() < totalPrice) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public int createOrder(ArrayList<Cupcake> arrayList, User userOn) {
        int i = arrayList.size();
        int totalPrice = 0;
        for (int j = 0; j < i; j++) {
            try {
                totalPrice+=arrayList.get(j).getPrice();
                
                String sql = "INSERT INTO orders (FKcupcakeTop, FKcupcakeBot, quantity, price, FKuserName) values (?,?,?,?,?);";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, arrayList.get(j).getTop());
                pstmt.setString(2, arrayList.get(j).getBot());
                pstmt.setInt(3, arrayList.get(j).getQuantity());
                pstmt.setInt(4, arrayList.get(j).getPrice());
                pstmt.setString(5, userOn.getUsername());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return totalPrice;
    }
}
