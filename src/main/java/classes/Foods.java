package classes;

import java.util.HashMap;
import java.util.LinkedList;


public class Foods 
{
    // attributes
    // Hashmap data for all ingredients for each food item
    protected HashMap<Integer, String> ingredients = new HashMap<Integer, String>();
    // LinkedList data for all the Food items
    private LinkedList<Food> allFoods = new LinkedList<Food>();

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
     * Method Name : displayBreakfastMenu()
     * Parameters : none
     * Description : display all meals that are in the BREAKFAST category
     */
    public void displayBreakfastMenu()
    {
        System.out.println("Breakfast Menu:\n");

        for (int i = 1; i < allFoods.size(); i++) {
            if (allFoods.get(i).category == Category.BREAKFAST)
                System.out.println("[" + ( i ) + "] " + allFoods.get(i).toString() + "\nIngredients: " + ingredients.get(i) + "\n");
        }
    }
    
    /*
     * Method Name : displayBreakfastMenu()
     * Parameters : none
     * Description : display all meals that are in the LUNCH category
     */
    public void displayLunchMenu()
    {
        System.out.println("Lunch Menu:\n");

        for (int i = 0; i < allFoods.size(); i++) {
            if (allFoods.get(i).category == Category.LUNCH)
                System.out.println("[" + ( i - 2 ) + "] " + allFoods.get(i).toString() + "\nIngredients: " + ingredients.get(i) + "\n");
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

        for (int i = 0; i < allFoods.size(); i++)
        {
            if (allFoods.get(i).category == Category.FASTFOOD)
                System.out.println("[" + ( i - 7 ) + "] " + allFoods.get(i).toString() + "\nIngredients: " + ingredients.get(i) + "\n");
        }
    }
    
}
