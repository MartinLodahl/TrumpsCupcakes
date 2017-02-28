/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

/**
 *
 * @author Pravien
 */
public class Bot
{
    String taste;
    int price;

    public Bot(String taste, int price)
    {
        this.taste = taste;
        this.price = price;
    }

    public String getTaste()
    {
        return taste;
    }

    public void setTaste(String taste)
    {
        this.taste = taste;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }
    
    
    
}
