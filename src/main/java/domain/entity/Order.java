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
public class Order
{
    User user;
    ArrayList<Cupcake> cupcakes;
    
    public Order (User user, ArrayList<Cupcake> cupcakes){
        this.user = user;
        this.cupcakes = cupcakes;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public ArrayList<Cupcake> getCupcakes()
    {
        return cupcakes;
    }

    public void setCupcakes(ArrayList<Cupcake> cupcake)
    {
        this.cupcakes = cupcakes;
    }
    
    
    
}
