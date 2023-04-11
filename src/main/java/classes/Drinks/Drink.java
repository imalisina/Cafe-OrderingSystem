package classes.Drinks;

import classes.*;
import classes.Enums.Category;

public class Drink extends Item 
{
    // attributes
    protected String pairing;
    
    /*
     * Constructor Name : Drink()
     * Parameters : name, price, rating, pairing
     * Description : Alternate constructor
     */
    public Drink(String name, double price, int rating, Category category,String pairing) 
    {
        super(name, price, rating, category);
        this.pairing = pairing;
    }

    /*
     * Method Name : getPairing()
     * Parameters : none
     * Description : getter/accessor
     */
    public String getPairing() 
    {
        return pairing;
    }

    /*
     * Method Name : getName()
     * Parameters : none
     * Description : getter/accessor
     */
    @Override
    public String getName() 
    {
        return name;
    }

    /*
     * Method Name : getPrice()
     * Parameters : none
     * Description : getter/accessor
     */    
    @Override
    public double getPrice() 
    {
        return price;
    }

    /*
     * Method Name : getRating()
     * Parameters : none
     * Description : getter/accessor
     */
    @Override
    public int getRating() 
    {
        return rating;
    }

    /*
     * Method Name : getCategory()
     * Parameters : none
     * Description : getter/accessor
     */
    @Override
    public Category getCategory() 
    {
        return category;
    }

    /*
     * Method Name : toString()
     * Parameters : none
     * Description : display attributes of the Item objects
     */
    @Override
    public String toString() 
    {
        return "Name: " + name + ", Price: " + price + "\nDetails - Rating: " + rating + ", Category: " + category + "\nPairing: " + pairing;
    }
}
