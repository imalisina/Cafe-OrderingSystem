package classes;

import classes.Drinks.Drink;
import classes.Drinks.Drinks;
import classes.Foods.Food;
import classes.Foods.Foods;
import classes.Snacks.Snack;
import classes.Snacks.Snacks;

public class Finder 
{
    /*
     * Constructor Name : Finder()
     * parameters : none
     * Description : Defailt constructor
     */
    public Finder()
    {

    }
    /*
     * Method Name : findBreakfast()
     * parameters : id
     * Description : Find the breakfast Meal at the given index 
     *               and return the meal as a Food object
     */
    public Food findBreakfast(int id)
    {
        Foods breakfast = new Foods();
        breakfast.filterBreakfastMeals();
        return breakfast.findBreakfast(id);
    }

    /*
     * Method Name : findLunch()
     * parameters : id
     * Description : Find the lunch Meal at the given index 
     *               and return the meal as a Food object
     */
    public Food findLunch(int id)
    {
        Foods lunch = new Foods();
        lunch.filterLunchMeals();
        return lunch.findLunch(id);
    }

    /*
     * Method Name : findFastFood()
     * parameters : id
     * Description : Find the fastfood Meal at the given index 
     *               and return the meal as a Food object
     */
    public Food findFastFood(int id)
    {
        Foods fastfood = new Foods();
        fastfood.filterFastFoodMeals();
        return fastfood.findFastFood(id);
    }

    /*
     * Method Name : findSnack()
     * parameters : id
     * Description : Find the snack at the given index 
     *               and return the meal as a Snack object
     */
    public Snack findSnack(int id)
    {
        Snacks snack = new Snacks();
        return snack.findSnack(id);
    }

    /*
     * Method Name : findHotDrink()
     * parameters : id
     * Description : Find the hot drink at the given index 
     *               and return the meal as a Drink object
     */
    public Drink findHotDrink(int id)
    {
        Drinks hot = new Drinks();
        hot.filterHotDrinks();
        return hot.findHotDrink(id);
    }

    /*
     * Method Name : findColdDrink()
     * parameters : id
     * Description : Find the cold drink at the given index 
     *               and return the meal as a Drink object
     */
    public Drink findColdDrink(int id)
    {
        Drinks cold = new Drinks();
        cold.filterColdDrinks();
        return cold.findColdDrink(id);
    }
}
