package classes;

public class Snack extends Item 
{
    // attribute
    protected String size;
    protected int quantity;

    /*
     * Constructor Name : Snack()
     * Parameters : name, price, rating, size, quantity
     * Description : Alternate constructor
     */
    public Snack(String name, double price, Category category, int rating, String size, int quantity) 
    {
        super(name, price, rating, category);
        this.size = size;
        this.quantity = quantity;
    }

    /*
     * Method Name : getSize()
     * Parameters : none
     * Description : getter/accessor
     */
    public String getSize() 
    {
        return size;
    }

    /*
     * Method Name : getQuantity()
     * Parameters : none
     * Description : getter/accessor
     */
    public int getQuantity() 
    {
        return quantity;
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
        return "Name: " + name + ", Price: " + price + "\nDetails - Rating: " + rating + ", Category: " + category + ", Size: " + size + ", Quantity: " + quantity;
    }
}
