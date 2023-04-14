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
    double totalPrice;
    String pairing;
    //Promotion discount;

    // global variable to store user choice
    int categoryChoiceId = 0;

    // constants
    final int BREAKFAST_MENU = 3;
    final int LUNCH_MENU = 5;
    final int FASTFOOD_MENU = 3;
    final int SNACK_MENU = 6;
    final int HOT_DRINK_MENU = 5;
    final int COLD_DRINK_MENU = 5;

    // Linked list to store collection of items per Order
    LinkedList<Food> foodOrder = new LinkedList<Food>();
    LinkedList<Drink> drinkOrder = new LinkedList<Drink>();
    LinkedList<Snack> snackOrder = new LinkedList<Snack>();

    // An instance of Finder class
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

    /*
     * Constructor Name : Order()
     * Parameters : none
     * Description : Default Constructor
     */
    public Order() 
    {

    }

    /*
     * Method Name : placeOrder()
     * Parameters : none
     * Description : call the relevant methods to complete the order from start to end 
     */
    public void placeOrder() 
    {
        displayMenu();
        displayOrderStyle();
        displayOrderSummary();
    }

    /*
     * Method Name : displayMenu()
     * Parameters : none
     * Description : display the selected categories in the menu 
     */
    public void displayMenu() 
    {
        // Loop through the code to allow the user to view different categories
        do {
            // display the Menu categories
            displayCategoryMenu("Select a category to view from the Menu\n(ENTER 0 to Proceed to place your Order)");
            // Invoke the meal menu as per the selection
            displayMealMenu(categoryChoiceId);
        } while (categoryChoiceId != 0);
    }

    /*
     * Method Name : displayMealMenu()
     * Parameters : prompt
     * Description : display the different categories in the menu
     */
    public void displayCategoryMenu(String prompt)
    {
        // Define all available menu options
        String[] categoryOptions = { "Breakfast", "Lunch", "Fast Food", "Snack", "Hot Drink", "Cold Drink"};

        // An instance of Menu object
        Menu categoryMenu = new Menu("MENU");

        // Display a list of available categories
        categoryMenu.showMenu(categoryOptions);

        // display the prompt and ask user for input
        System.out.print("\n" + prompt + ": ");
        categoryChoiceId = Input.nextInt();
        // Make sure the user enters a valid input
        while (categoryChoiceId < 0 || categoryChoiceId > 6)
        {
            System.out.print("\nPlease select a value between 1 and 6: ");
            categoryChoiceId = Input.nextInt();
        }
    }

    /*
     * Method Name : displayMealMenu()
     * Parameters : categoryId
     * Description : display the menu based on the selected category
     */
    public void displayMealMenu(int categoryId) {
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

    /*
     * Method Name : displayOrderStyle()
     * Parameters : none
     * Description : display the options to place an order from the menu 
     */
    public void displayOrderStyle() 
    {
        categoryChoiceId = 0;
        // Define all available menu options
        String[] options = { "Auto-Generate Meal", "Select Meal" };

        // An instance of Menu object
        Menu orderStyleMenu = new Menu("ORDER STYLE");

        // Display a list of available options
        orderStyleMenu.showMenu(options);

        // Ask user how they want to select their meal
        System.out.print("\nHow would you like to place your order: ");
        categoryChoiceId = Input.nextInt();

        // Invoke the meal menu as per the selection
        displayOrderStyleMenu(categoryChoiceId);
    }

    /*
     * Method Name : displayOrderStyleMenu()
     * Parameters : styleId
     * Description : - Allow the user to choose the way they place their order
     *               - they can either manually do this or autoGenerate their meals
     */
    public void displayOrderStyleMenu(int styleId) 
    {
        // Switch case to specify order style
        switch (styleId) {
            case 1:
                //auto-generate the meal;
                autoGenerateMeal();
                break;
            case 2:
                // manually select the meal
                selectMeal();
                break;
        }
    }

    /*
     * Method Name : selectMeal()
     * Parameters : none
     * Description : - allow the user to randomly generate their meals
     */
    public void autoGenerateMeal()
    {
         // As the user to select the category
         displayCategoryMenu("Select a category to choose a meal from");
        do 
        {
            // Switch case to specify the order 
            switch (categoryChoiceId) {
                case 1:
                    Food breakfast = finder.findBreakfast(generateMealId(BREAKFAST_MENU));
                    System.out.println("\n" + breakfast.toString());
                    foodOrder.add(breakfast);
                    break;
                case 2:
                    Food lunch = finder.findLunch(generateMealId(LUNCH_MENU));
                    System.out.println("\n" + lunch.toString());
                    foodOrder.add(lunch);
                    break;
                case 3:
                    Food fastfood = finder.findFastFood(generateMealId(FASTFOOD_MENU));
                    System.out.println("\n" + fastfood.toString());
                    foodOrder.add(fastfood);
                    break;
                case 4:
                    Snack snack = finder.findSnack(generateMealId(SNACK_MENU));
                    System.out.println("\n" + snack.toString());
                    snackOrder.add(snack);
                    break;
                case 5:
                    Drink hot = finder.findHotDrink(generateMealId(HOT_DRINK_MENU));
                    System.out.println("\n" + hot.toString());
                    drinkOrder.add(hot);
                    break;
                case 6:
                    Drink cold = finder.findColdDrink(generateMealId(COLD_DRINK_MENU));
                    System.out.println("\n" + cold.toString());
                    drinkOrder.add(cold);
                    break;
            }
            // Ask the user if they want to add another meal or Proceed to order summary
            displayCategoryMenu("\nSelect the category to choose your next meal from\n(ENTER 0 to proceed with your order)");
        } while (categoryChoiceId != 0);
    }

    /*
     * Method Name : selectMeal()
     * Parameters : none
     * Description : - allow the user to manually choose their meals
     */
    public void selectMeal() 
    {
         // As the user to select the category
        displayCategoryMenu("Select a category to choose a meal from");
        do 
        {
            // Switch case to specify the order 
            switch (categoryChoiceId) {
                case 1:
                    displayMealMenu(categoryChoiceId);
                    Food breakfast = finder.findBreakfast(askMealId());
                    System.out.println("\n" + breakfast.toString());
                    foodOrder.add(breakfast);
                    break;
                case 2:
                    displayMealMenu(categoryChoiceId);
                    Food lunch = finder.findLunch(askMealId());
                    System.out.println("\n" + lunch.toString());
                    foodOrder.add(lunch);
                    break;
                case 3:
                    displayMealMenu(categoryChoiceId);
                    Food fastfood = finder.findFastFood(askMealId());
                    System.out.println("\n" + fastfood.toString());
                    foodOrder.add(fastfood);
                    break;
                case 4:
                    displayMealMenu(categoryChoiceId);
                    Snack snack = finder.findSnack(askMealId());
                    System.out.println("\n" + snack.toString());
                    snackOrder.add(snack);
                    break;
                case 5:
                    displayMealMenu(categoryChoiceId);
                    Drink hot = finder.findHotDrink(askMealId());
                    System.out.println("\n" + hot.toString());
                    drinkOrder.add(hot);
                    break;
                case 6:
                    displayMealMenu(categoryChoiceId);
                    Drink cold = finder.findColdDrink(askMealId());
                    System.out.println("\n" + cold.toString());
                    drinkOrder.add(cold);
                    break;
            }
            // Ask the user if they want to add another meal or Proceed to order summary
            displayCategoryMenu("\nSelect the category to choose your next meal from\n(ENTER 0 to proceed with your order)");
        } while (categoryChoiceId != 0);
    }

    /*
     * Method Name : displayOrderSummary()
     * Parameters : none
     * Description : display a summary of the users order and display total
     */
    public void displayOrderSummary() 
    {
        // initialise 'total' variable
        totalPrice = 0;
        System.out.println("\n----------- ORDER SUMMARY -----------\n");
        // If the user ordered fro the Food Category, display each Item
        if (foodOrder.size() != 0) {
            // Loop through the food list
            for (Food food : foodOrder) {
                System.out.println(food.toString());
                // Calculate new total
                totalPrice += food.price;
            }
        }
        if (drinkOrder.size() != 0) {
            // Loop through the drink list
            for (Drink drink : drinkOrder) {
                System.out.println(drink.toString());
                // Calculate new total
                totalPrice += drink.price;
            }
        }
        if (snackOrder.size() != 0) {
            // Loop through the snack list
            for (Snack snack : snackOrder) {
                System.out.println(snack.toString());
                // Calculate new total
                totalPrice += snack.price;
            }
        }
        // Display total cost of order
        System.out.println("\nTOTAL : $" + totalPrice);

    }

    /*
     * Method Name : askMealId()
     * Parameters : none
     * Description : ask the user to enter the mealId for the item they choose
     */
    public int askMealId() 
    {
        System.out.print("\nEnter the meal Id: ");
        int mealId = Input.nextInt();
        return mealId;
    }

    /*
     * Method Name : generateMealId()
     * Parameters : sizeOfCategory
     * Description : generate random meal Id
     */
    public int generateMealId(int sizeOfCategory)
    {
        return (int) Math.round(Math.random() * sizeOfCategory);
    }

    /*
     * Method Name : displayBreakfastMenu()
     * Parameters : none
     * Description : display all the brekafast items
     */
    public void displayBreakfastMenu() {
        Foods breakfast = new Foods("BREAKFAST MENU");
        breakfast.filterBreakfastMeals();
        breakfast.displayBreakfastMenu();
    }

    /*
     * Method Name : displayLunchMenu()
     * Parameters : none
     * Description : display all the lunch items
     */
    public void displayLunchMenu() {
        Foods lunch = new Foods("LUNCH MENU");
        lunch.filterLunchMeals();
        lunch.displayLunchMenu();
    }

    /*
     * Method Name : displayFastFoodMenu()
     * Parameters : none
     * Description : display all the fast food items
     */
    public void displayFastFoodMenu() {
        Foods fastfood = new Foods("FAST FOOD MENU");
        fastfood.filterFastFoodMeals();
        fastfood.displayFastFoodMenu();
    }

    /*
     * Method Name : displaySnacksMenu()
     * Parameters : none
     * Description : display all the snack items
     */
    public void displaySnacksMenu() {
        Snacks snack = new Snacks("SNACKS MENU");
        snack.displayAllSnacks();
    }

    /*
     * Method Name : displayHotDrinksMenu()
     * Parameters : none
     * Description : display all the hot drink items
     */
    public void displayHotDrinksMenu() {
        Drinks hot = new Drinks("HOT DRINKS");
        hot.filterHotDrinks();
        hot.displayHotDrinks();
    }

    /*
     * Method Name : displayColdDrinksMenu()
     * Parameters : none
     * Description : display all the cold drink items
     */
    public void displayColdDrinksMenu() {
        Drinks cold = new Drinks("COLD DRINKS");
        cold.filterColdDrinks();
        cold.displayColdDrinks();
    }
}

           
