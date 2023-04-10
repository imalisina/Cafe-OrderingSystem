package classes;

public class Item 
{
    // attributes
    protected String name;
    protected double price;
    protected int rating;
    protected Category category;

    /*
     * Constructor Name : Item()
     * Parameters : name, price, rating
     * Description : Alternate constructor
     */
    public Item(String name, double price, int rating, Category category) 
    {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.category = category;
    }
    
    /*
     * Method Name : getName()
     * Parameters : none
     * Description : getter/accessor
     */
    public String getName() 
    {
        return name;
    }

    /*
     * Method Name : getPrice()
     * Parameters : none
     * Description : getter/accessor
     */    
    public double getPrice() 
    {
        return price;
    }

    /*
     * Method Name : getRating()
     * Parameters : none
     * Description : getter/accessor
     */
    public int getRating() 
    {
        return rating;
    }

    public Category getCategory() {
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
        return "Item: " + name + " has a price of: " + price + " and a rating of: " + rating;
    }
    
}
