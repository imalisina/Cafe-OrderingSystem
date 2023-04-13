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
     * 
     */
    public Food findBreakfast(int id)
    {
        Foods breakfast = new Foods();
        breakfast.filterBreakfastMeals();
        return breakfast.findBreakfast(id);
    }

    public Food findLunch(int id)
    {
        Foods lunch = new Foods();
        lunch.filterLunchMeals();
        return lunch.findLunch(id);
    }

    public Food findFastFood(int id)
    {
        Foods fastfood = new Foods();
        fastfood.filterFastFoodMeals();
        return fastfood.findFastFood(id);
    }

    public Snack findSnack(int id)
    {
        Snacks snack = new Snacks();
        return snack.findSnack(id);
    }

    public Drink findHotDrink(int id)
    {
        Drinks hot = new Drinks();
        hot.filterHotDrinks();
        return hot.findHotDrink(id);
    }

    public Drink findColdDrink(int id)
    {
        Drinks cold = new Drinks();
        cold.filterColdDrinks();
        return cold.findColdDrink(id);
    }
}
