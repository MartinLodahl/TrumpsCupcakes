/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Pravien
 */
public class BotMapper
{
    
    Connection conn;

    public UserMapper() {
        this.conn = new DBLocal().getConnection();
    }
    
    public ArrayList<Bot> getBot (){
            String sql = "SELECT * FROM bot;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                
            }
    }
    
}
