package classes;


public class Food extends Item 
{   
    /*
     * Constructor Name : Food()
     * Parameters : name, price, rating, ingredients
     * Description : Alternate constructor
     */
    public Food(String name, double price, int rating, Category category) 
    {
        super(name, price, rating, category);
        // this.ingredients = ingredients;
    }

    /*
     * Method Name : getIngredients()
     * Parameters : none
     * Description : getter/accessor
     */
    // public HashMap<Integer, String> getIngredients() 
    // {
        // return ingredients;
    // }

    /*
     * Method Name : toString()
     * Parameters : none
     * Description : display attributes of the Food objects
     */
    @Override
    public String toString() 
    {
        return super.toString() + ". The ingredients are: "; //ingredients;
    }
}
