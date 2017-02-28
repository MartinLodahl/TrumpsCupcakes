/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Bot;
import domain.entity.Top;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pravien
 */
public class TopBottomMapper
{

    Connection conn;

    public TopBottomMapper()
    {
        this.conn = new DBLocal().getConnection();
    }

    public ArrayList<Bot> getBot() throws SQLException
    {
        ArrayList<Bot> bot = new ArrayList();
        Bot newBot;
        String sql = "SELECT * FROM bot;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next())
        {
            String taste = rs.getString("taste");
            int price = rs.getInt("price");
            newBot = new Bot(taste,price);
            bot.add(newBot);
        }
        return bot;
    }
    
    
    public ArrayList<Top> getTop() throws SQLException
    {
        ArrayList<Top> top = new ArrayList();
        Top newTop;
        String sql = "SELECT * FROM top;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next())
        {
            String taste = rs.getString("taste");
            int price = rs.getInt("price");
            newTop = new Top(taste,price);
            top.add(newTop);
        }
        return top;
    }
}