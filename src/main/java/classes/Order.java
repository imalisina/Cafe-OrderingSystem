package classes;

import classes.Drinks.Drinks;
import classes.Foods.Foods;
import classes.Snacks.Snacks;
import classes.System.Input;
import classes.System.Menu;

public class Order {
    // attributes
    String title;
    double price;
    String pairing;
    //Promotion discount;

    // An instance of Menu class


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
    }

    public void displayMenu() 
    {
        // Define temporary variable to store user's choice
        int choiceId = 0;
        // Define all available menu options
        String[] categoryOptions = { "Breakfast", "Lunch", "Fast Food", "Snack", "Hot Drink", "Cold Drink" };

        // An instance of Menu object
        Menu categoryMenu = new Menu("Menu");

        // Display a list of available categories
        categoryMenu.showMenu(categoryOptions);

        // Asking question to enter the category
        System.out.print("\nEnter the category you would like to select: ");
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
        switch (categoryId) {
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
        }
    }
    
    public void displayOrderStyle() 
    {
        // Define temporary variable to store user's choice
        int choiceId = 0;
        // Define all available menu options
        String[] options = { "Auto-Generate Meal", "Select Meal" };

        // An instance of Menu object
        Menu orderStyleMenu = new Menu("Order Style");

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
                //selectMeal();
                System.out.println("Select");
                break;
        }
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

           
