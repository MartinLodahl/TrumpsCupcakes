/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Cupcake;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author MartinLodahl
 */
public class OrderMapper {
      Connection conn;

    public OrderMapper() {
        this.conn = new DBLocal().getConnection();
    }

    public void createOrder(ArrayList<Cupcake> arrayList) {
        int i = arrayList.size();
        
    }

    
    
    
}
