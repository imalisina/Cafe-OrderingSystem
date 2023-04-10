package classes;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;


public class Foods 
{
    private LinkedList<Food> allFoods = new LinkedList<Food>();

    // attribute
    protected HashMap<Integer, String> ingredients = new HashMap<Integer, String>();

    public Foods() 
    {

    }
    
    private void setUpAllFoods()
    {
        allFoods.add(new Food("Burger", 2, 5,Category.FASTFOOD));
        ingredients.put(1, "2x Cheese, 1 Salad, 2 Beef Meat");
    }
    
}
