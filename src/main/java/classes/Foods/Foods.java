package classes.Foods;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

import classes.Items;
import classes.Enums.Category;
import classes.System.Menu;


public class Foods implements Items
{
    // attributes
    // Hashmap data for all ingredients for each food item
    public HashMap<Integer, String> ingredients = new HashMap<Integer, String>();

    // LinkedList data for all the Food items
    private LinkedList<Food> allFoods = new LinkedList<Food>();
    private LinkedList<Food> allBreakfasts = new LinkedList<Food>();
    private LinkedList<Food> allLunches = new LinkedList<Food>();
    private LinkedList<Food> allFastFoods = new LinkedList<Food>();

    /*
     * Constructor Name : Foods()
     * Parameters : none
     * Description : default constructor
     */
    public Foods()
    {
        itemSeeder();
    }

    /*
     * Constructor Name : Foods()
     * Parameters : name
     * Description : Alternate constructor
     */
    public Foods(String name) 
    {
        new Menu(name);
        itemSeeder();
    }
    
    /*
     * Method Name : foodSeeder()
     * Parameters : none
     * Description : - create all food objects
     *               - create hashMap ingredients for each object
     */
    @Override
    public void itemSeeder()
    {
        // Create all Food Items
        allFoods.add(new Food("Milk Rice", 2.99, 4, Category.BREAKFAST));
        allFoods.add(new Food("Sholezad", 3.49, 4, Category.BREAKFAST));
        allFoods.add(new Food("Pap and Akara", 2.99, 3, Category.BREAKFAST));
        allFoods.add(new Food("Kalamata Olive Hummus", 4.99, 5, Category.BREAKFAST));
        allFoods.add(new Food("Bandari Sausage", 4.99, 3,Category.BREAKFAST));
        allFoods.add(new Food("Baghali polo", 4.49, 4, Category.LUNCH));
        allFoods.add(new Food("Fesenjan Stew", 2.99, 4, Category.LUNCH));
        allFoods.add(new Food("Döner",3.49, 4, Category.LUNCH));
        allFoods.add(new Food("Kabsa Biryani", 4.49, 5, Category.LUNCH));
        allFoods.add(new Food("Jollof Rice", 2.99, 5, Category.LUNCH));
        allFoods.add(new Food("Pide", 1.99, 4, Category.FASTFOOD));
        allFoods.add(new Food("Boerewors", 3.49, 3, Category.FASTFOOD));
        allFoods.add(new Food("Bunny Chow", 4.49, 5, Category.FASTFOOD));
        allFoods.add(new Food("Falafel", 6.99, 4, Category.FASTFOOD));
        allFoods.add(new Food("Shawarma", 5.99, 5, Category.FASTFOOD));
        
        
        // Create ingredients for each food item
        ingredients.put(1, "Rice, Milk, Vanilla Extract");
        ingredients.put(2, "chick peas, Lentils, Spinach, Sour cream");
        ingredients.put(3, "Bread, cheese, chicken meat");
        ingredients.put(4, "Olives, Hummus, variety of cardiments");
        ingredients.put(5, "chicken/beef meat, butter, special sauces");
        ingredients.put(6, "Beef sausage, corriander, vinegar, variety of spices");
        ingredients.put(7, "Rice, Lamb shops, fava beans, Dil weed");
        ingredients.put(8, "Beef/lamb/chicken, Pita bread, Lettuce, Tomatoes, Garlic sauce, Hot peppers");
        ingredients.put(9, "Rice, Beef/lamb/chicken, Tomatoes, variety of spices");
        ingredients.put(10, "Rice, tomato sauce, variety of spices");
        ingredients.put(11, "Ground Meat, cheese, egg, tomato");
        ingredients.put(12, "Ground Meat, special herbs, tomato");
        ingredients.put(13, "Bread, curry sauce, potatoes, tomatoes, fresh herbs");
        ingredients.put(14, "Beef/lamb/chicken, fresh herbs");
        ingredients.put(15, "Beef/lamb/chicken, special sauces, variety of vegetables");
    }

    /*
     * Method Name : filterBreakfastMeals()
     * Parameters : none
     * Description : Method to filter and extract only breakfast meals
     */
    public void filterBreakfastMeals() 
    {
        // Iterate over all meals in the allFood list
        for (Food breakfast : allFoods) 
        {
            // Check if the meal is a breakfast meal
            if (Category.BREAKFAST.equals(breakfast.getCategory())) 
            {
                // if it is breakfast, add it to the allBreakfasts list
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
        // Iterate over all meals in the allFood list
        for (Food lunch : allFoods) 
        {
            // Check if the meal is a lunch meal    
            if (Category.LUNCH.equals(lunch.getCategory())) 
            {
                // if it is lunch, add it to the allLunches list
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
        // Iterate over all meals in the allFood list
        for (Food fastfood : allFoods) 
        {
            // Check if the meal is a fastfood meal
            if (Category.FASTFOOD.equals(fastfood.getCategory())) 
            {
                // if it is fastfood, add it to the allFastFoods list
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
        // Iterator for the allBreakfasts List
        ListIterator<Food> breakfastListIterator = allBreakfasts.listIterator();
        // initialize counter 
        int i = 0;
        // iterate over each meal in the list 
        while (breakfastListIterator.hasNext()) 
        {
            // Get the next breakfast meal in the list
            Food breakfast = breakfastListIterator.next();
            // Display details of the meal
            System.out.println("[" + (i + 1) + "] " + breakfast.toString() + "\nIngredients : " + ingredients.get(i + 1));
            // Control the space in terminal
            if (i < allBreakfasts.size() - 1) {
                System.out.println("");
            }
            // increment counter
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
        // Iterator for the allLunches List
        ListIterator<Food> lunchListIterator = allLunches.listIterator();
        // initialize counter 
        int i = 0;
        // iterate over each meal in the list 
        while (lunchListIterator.hasNext()) 
        {
            // Get the next lunch meal in the list
            Food lunch = lunchListIterator.next();
            // Display details of the meal
            System.out.println("[" + (i + 1) + "] " + lunch.toString() + "\nIngredients : " + ingredients.get(i + 6));
            // Control the space in terminal
            if (i < allLunches.size() - 1) {
                System.out.println("");
            }
            // increment counter
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
        // Iterator for the allFastFoods List
        ListIterator<Food> fastfoodListIterator = allFastFoods.listIterator();
        // initialize counter
        int i = 0;
        // iterate over each meal in the list
        while (fastfoodListIterator.hasNext()) {
            // Get the next fast food meal in the list
            Food fastfood = fastfoodListIterator.next();
            // Display details of the meal
            System.out.println("[" + (i + 1) + "] " + fastfood.toString() + "\nIngredients : " + ingredients.get(i + 11));
            // Control the space in terminal
            if (i < allFastFoods.size() - 1) {
                System.out.println("");
            }
            // increment counter
            i++;
        }
    }
    
    /*
     * Method Name : find()
     * Parameters : category, id
     * Description : abstract Method to find item objects
     */
    @Override
    public Food find(String category, int id)
    {
        switch (category) 
        {
            case "Breakfast":
                return allBreakfasts.get(id - 1);
            case "Lunch":
                return allLunches.get(id - 1);
            case "Fast Food":
                return allFastFoods.get(id - 1);
        }
        System.out.println("[ERROR] meal not found !");
        System.exit(1);
        return null;
    }
}
