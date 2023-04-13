package classes;

import java.util.LinkedList;

import classes.Drinks.Drink;
import classes.Drinks.Drinks;
import classes.Foods.Food;
import classes.Foods.Foods;
import classes.Snacks.Snack;
import classes.Snacks.Snacks;
import classes.System.Input;
import classes.System.Menu;

public class Order {
    // attributes
    String title;
    double price;
    String pairing;
    //Promotion discount;

    LinkedList<Food> foodOrder = new LinkedList<Food>();
    LinkedList<Drink> drinkOrder = new LinkedList<Drink>();
    LinkedList<Snack> snackOrder = new LinkedList<Snack>();
    Finder finder = new Finder();

    /*
     * Constructor Name : Order()
     * Parameters : title, price, pairing, discount
     * Description : Alternate Constructor
     */
    // public Order(String title, double price, String pairing) 
    // {
    //     this.title = title;
    //     this.price = price;
    //     this.pairing = pairing;
    // }

    public Order()
    {
        
    }
    
    public void placeOrder()
    {
        displayMenu();
        displayOrderStyle();
        displayOrderSummary();
    }

    public void displayMenu() 
    {
        // Define temporary variable to store user's choice
        int choiceId = 0;
        // Define all available menu options
        String[] categoryOptions = { "Breakfast", "Lunch", "Fast Food", "Snack", "Hot Drink", "Cold Drink", "Full Menu" };

        // An instance of Menu object
        Menu categoryMenu = new Menu("MENU");

        // Display a list of available categories
        categoryMenu.showMenu(categoryOptions);

        // Asking question to enter the category
        System.out.print("\nEnter the category you would like to view: ");
        choiceId = Input.nextInt();

        // Invoke the meal menu as per the selection
        displayMealMenu(choiceId);
    }

    /*
     * Method Name : displayMealMenu()
     * Parameters : category
     * Description : display the menu based on the selected category
     */
    public void displayMealMenu(int categoryId) 
    {
        // Switch case to find the correct category field
        switch (categoryId) 
        {
            case 1:
                displayBreakfastMenu();
                break;
            case 2:
                displayLunchMenu();
                break;
            case 3:
                displayFastFoodMenu();
                break;
            case 4:
                displaySnacksMenu();
                break;
            case 5:
                displayHotDrinksMenu();
                break;
            case 6:
                displayColdDrinksMenu();
                break;
            case 7:
                displayBreakfastMenu();
                displayLunchMenu();
                displayFastFoodMenu();
                displaySnacksMenu();
                displayHotDrinksMenu();
                displayColdDrinksMenu();
        }
    }
    
    public void displayOrderStyle() 
    {
        // Define temporary variable to store user's choice
        int choiceId = 0;
        // Define all available menu options
        String[] options = { "Auto-Generate Meal", "Select Meal" };

        // An instance of Menu object
        Menu orderStyleMenu = new Menu("ORDER STYLE");

        // Display a list of available categories
        orderStyleMenu.showMenu(options);

        // Asking question to enter the category
        System.out.print("\nEnter the order style: ");
        choiceId = Input.nextInt();

        // Invoke the meal menu as per the selection
        displayOrderStyleMenu(choiceId);
    }
    
    public void displayOrderStyleMenu(int styleId) 
    {
        // Switch case to find the correct category field
        switch (styleId) {
            case 1:
                //autoGenerateMeal();
                System.out.println("Auto");
                break;
            case 2:
                selectMeal();
                break;
        }
    }

    public void selectMeal()
    {
        System.out.println("Select the category to choose your meal from:");
        int choiceId = Input.nextInt();
        do
        {
            switch (choiceId) {
                case 1:
                    Food breakfast = finder.findBreakfast(askMealId());
                    System.out.println("\n" + breakfast.toString());
                    foodOrder.add(breakfast);
                    break;
                case 2:
                    Food lunch = finder.findLunch(askMealId());
                    System.out.println("\n" + lunch.toString());
                    foodOrder.add(lunch);
                    break;
                case 3:
                    Food fastfood = finder.findFastFood(askMealId());
                    System.out.println("\n" + fastfood.toString());
                    foodOrder.add(fastfood);
                    break;
                case 4:
                    Snack snack = finder.findSnack(askMealId());
                    System.out.println("\n" + snack.toString());
                    snackOrder.add(snack);
                    break;
                case 5:
                    Drink hot = finder.findHotDrink(askMealId());
                    System.out.println("\n" + hot.toString());
                    drinkOrder.add(hot);
                    break;
                case 6:
                    Drink cold = finder.findColdDrink(askMealId());
                    System.out.println("\n" + cold.toString());
                    drinkOrder.add(cold);
                    break;
            }
            System.out.println("\nSelect the category to choose your next meal from:");
            System.out.println("---- NOTE: If that is all you wish to order, ENTER 0 ----");
            choiceId = Input.nextInt();
        } while(choiceId != 0);
    }
    
    public void displayOrderSummary()
    {
        double total = 0;
        System.out.println("\n----------- ORDER SUMMARY -----------\n");
        if(foodOrder.size() != 0)
        {
            for (Food food : foodOrder) {
                System.out.println(food.toString());
                total += food.price;
            }
        }
        if(drinkOrder.size() != 0)
        {
            for (Drink drink : drinkOrder) {
                System.out.println(drink.toString());
                total += drink.price;
            }
        }
        if(snackOrder.size() != 0)
        {
            for (Snack snack : snackOrder) {
                System.out.println(snack.toString());
                total += snack.price;
            }
        }
        System.out.println("\nTOTAL : $ " + total);
        
    }
    
    public int askMealId()
    {
        System.out.print("\nEnter the meal Id: ");
        int mealId = Input.nextInt();
        return mealId;
    }

    public void displayBreakfastMenu()
    {
        Foods breakfast = new Foods("BREAKFAST MENU");
        breakfast.filterBreakfastMeals();
        breakfast.displayBreakfastMenu();
    }

    public void displayLunchMenu()
    {
        Foods lunch = new Foods("LUNCH MENU");
        lunch.filterLunchMeals();
        lunch.displayLunchMenu();
    }

    public void displayFastFoodMenu()
    {
        Foods fastfood = new Foods("FAST FOOD MENU");
        fastfood.filterFastFoodMeals();
        fastfood.displayFastFoodMenu();
    }

    public void displaySnacksMenu()
    {
        Snacks snack = new Snacks("SNACKS MENU");
        snack.displayAllSnacks();
    }

    public void displayHotDrinksMenu()
    {
        Drinks hot = new Drinks("HOT DRINKS");
        hot.filterHotDrinks();
        hot.displayHotDrinks();
    }

    public void displayColdDrinksMenu()
    {
        Drinks cold = new Drinks("COLD DRINKS");
        cold.filterColdDrinks();
        cold.displayColdDrinks();
    }
}

           
