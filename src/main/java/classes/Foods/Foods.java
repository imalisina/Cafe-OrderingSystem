package classes.Foods;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import classes.Enums.Category;


public class Foods 
{
    // attributes
    // Hashmap data for all ingredients for each food item
    protected HashMap<Integer, String> ingredients = new HashMap<Integer, String>();
    // LinkedList data for all the Food items
    private LinkedList<Food> allFoods = new LinkedList<Food>();
    private LinkedList<Food> allBreakfasts = new LinkedList<Food>();
    private LinkedList<Food> allLunches = new LinkedList<Food>();
    private LinkedList<Food> allFastFoods = new LinkedList<Food>();

    /*
     * Constructor Name : Foods()
     * Parameters : none
     * Description : Default constructor
     */
    public Foods() 
    {
        foodSeeder();
    }
    
    /*
     * Method Name : foodSeeder()
     * Parameters : none
     * Description : - create all food objects
     *               - create hashMap ingredients for each object
     */
    private void foodSeeder()
    {
        // Create all Food Items
        allFoods.add(new Food("Milk Rice", 2.99, 4, Category.BREAKFAST));
        allFoods.add(new Food("Sholezad", 3.49, 4, Category.BREAKFAST));
        allFoods.add(new Food("Pap and Akara", 2.99, 3, Category.BREAKFAST));
        allFoods.add(new Food("Baghali polo", 4.49, 4, Category.LUNCH));
        allFoods.add(new Food("Fesenjan Stew", 2.99, 4, Category.LUNCH));
        allFoods.add(new Food("Döner",3.49, 4, Category.LUNCH));
        allFoods.add(new Food("Kabsa Biryani", 4.49, 5, Category.LUNCH));
        allFoods.add(new Food("Jollof Rice", 2.99, 5, Category.LUNCH));
        allFoods.add(new Food("Pide", 1.99, 4, Category.FASTFOOD));
        allFoods.add(new Food("Boerewors", 3.49, 3, Category.FASTFOOD));
        allFoods.add(new Food("Bunny Chow", 4.49, 5, Category.FASTFOOD));
        
        // Create ingredients for each food item
        ingredients.put(1, "Rice, Milk, Vanilla Extract");
        ingredients.put(2, "chick peas, Lentils, Spinach, Sour cream");
        ingredients.put(3, "Bread, cheese, chicken meat");
        ingredients.put(4, "Corn, butter, milk");
        ingredients.put(5, "Beef sausage, corriander, vinegar, variety of spices");
        ingredients.put(6, "Rice, Lamb shops, fava beans, Dil weed");
        ingredients.put(7, "Chicken/Duck, Walnuts, Pomegranate juice");
        ingredients.put(8, "Beef/lamb/chicken, Pita bread, Lettuce, Tomatoes, Garlic sauce, Hot peppers");
        ingredients.put(9, "Rice, Beef/lamb/chicken, Tomatoes, variety of spices");
        ingredients.put(10, "Bread, curry sauce, potatoes, tomatoes, fresh herbs");
        ingredients.put(11, "Rice, tomttoe sauce, variety of spices");
    }

    /*
     * Method Name : filterBreakfastMeals()
     * Parameters : none
     * Description : Method to filter and extract only breakfast meals
     */
    public void filterBreakfastMeals() 
    {
        for (Food breakfast : allFoods) {
            if (Category.BREAKFAST.equals(breakfast.getCategory())) {
                allBreakfasts.add(breakfast);
            }
        }
    }

    /*
     * Method Name : filterLunchMeals()
     * Parameters : none
     * Description : Method to filter and extract only lunch meals
     */
    public void filterLunchMeals() 
    {
        for (Food lunch : allFoods) {
            if (Category.LUNCH.equals(lunch.getCategory())) {
                allLunches.add(lunch);
            }
        }
    }

    /*
     * Method Name : filterFastFoodMeals()
     * Parameters : none
     * Description : Method to filter and extract only fastfood meals
     */
    public void filterFastFoodMeals() 
    {
        for (Food fastfood : allFoods) {
            if (Category.FASTFOOD.equals(fastfood.getCategory())) {
                allFastFoods.add(fastfood);
            }
        }
    }
    
    /*
     * Method Name : displayBreakfastMenu()
     * Parameters : none
     * Description : display all meals that are in the BREAKFAST category
     */
    public void displayBreakfastMenu() 
    {
        System.out.println("Breakfast Menu:\n");

        ListIterator<Food> breakfastListIterator = allBreakfasts.listIterator();
        int i = 0;
        while (breakfastListIterator.hasNext()) {
            Food breakfast = breakfastListIterator.next();
            System.out.println("[" + (i + 1) + "] " + breakfast.toString() + "\n");
            i++;
        }
    }

    /*
     * Method Name : displayLunchMenu()
     * Parameters : none
     * Description : display all meals that are in the LUNCH category
     */
    public void displayLunchMenu() 
    {
        System.out.println("Lunch Menu:\n");

        ListIterator<Food> lunchListIterator = allLunches.listIterator();
        int i = 0;
        while (lunchListIterator.hasNext()) {
            Food lunch = lunchListIterator.next();
            System.out.println("[" + (i + 1) + "] " + lunch.toString() + "\n");
            i++;
        }
    }

    /*
     * Method Name : displayFastFoodMenu()
     * Parameters : none
     * Description : display all meals that are in the FASTFOOD category
     */
    public void displayFastFoodMenu() 
    {
        System.out.println("Fastfood Menu:\n");

        ListIterator<Food> fastfoodListIterator = allFastFoods.listIterator();
        int i = 0;
        while (fastfoodListIterator.hasNext()) {
            Food fastfood = fastfoodListIterator.next();
            System.out.println("[" + (i + 1) + "] " + fastfood.toString() + "\n");
            i++;
        }
    }
    
}
