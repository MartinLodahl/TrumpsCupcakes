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
    List<Cupcakes> cupcakes;
    
    public Order (User user, List<Cupcakes> cupcakes){
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

    public <any> getCupcakes()
    {
        return cupcakes;
    }

    public void setCupcakes(<any> cupcakes)
    {
        this.cupcakes = cupcakes;
    }
    
    
    
}
