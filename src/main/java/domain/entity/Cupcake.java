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
public class Cupcake
{
    
    String top;
    String bot;
    int price;
    int quantity;

    public Cupcake(String top, String bot, int price, int quantity) {
        this.top = top;
        this.bot = bot;
        this.price = price;
        this.quantity = quantity;
    }

    public Cupcake(String top, String bot, int quantity) {
        this.top = top;
        this.bot = bot;
        this.quantity = quantity;
    }

    public String getTop()
    {
        return top;
    }

    public void setTop(String top)
    {
        this.top = top;
    }

    public String getBot()
    {
        return bot;
    }

    public void setBot(String bot)
    {
        this.bot = bot;
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
