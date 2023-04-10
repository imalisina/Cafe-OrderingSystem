package classes;

import java.util.LinkedList;

import classes.Drink.category;

public class Foods 
{
    private LinkedList<Food> allFoods = new LinkedList<Food>();

    public Foods() 
    {

    }
    
    private void setUpAllFoods()
    {
        allFoods.add(new Food("Milk Rice", 2.99, 4.0, category.BREAKFAST, ));
    }
    
}
