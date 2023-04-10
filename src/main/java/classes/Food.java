package classes;

// import the HashMap class
import java.util.HashMap;

public class Food extends Item 
{
    // attribute
    protected HashMap<Integer, String> ingredients = new HashMap<Integer, String>();
    
    /*
     * Constructor Name : Food()
     * Parameters : name, price, rating, ingredients
     * Description : Alternate constructor
     */
    public Food(String name, double price, int rating, Category category, HashMap<Integer, String> ingredients) 
    {
        super(name, price, rating, category);
        this.ingredients = ingredients;
    }

    /*
     * Method Name : getIngredients()
     * Parameters : none
     * Description : getter/accessor
     */
    public HashMap<Integer, String> getIngredients() 
    {
        return ingredients;
    }

    /*
     * Method Name : toString()
     * Parameters : none
     * Description : display attributes of the Food objects
     */
    @Override
    public String toString() 
    {
        return super.toString() + ". The ingredients are: " + ingredients;
    }
}
