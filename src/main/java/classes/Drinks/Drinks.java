package classes.Drinks;

import classes.Enums.Category;
import classes.System.Menu;

import java.util.LinkedList;
import java.util.ListIterator;

public class Drinks
{
    // attributes
    // LinkedList data for all the Drink items
    private LinkedList<Drink> allDrinks = new LinkedList<Drink>();
    private LinkedList<Drink> hotDrinks = new LinkedList<Drink>();
    private LinkedList<Drink> coldDrinks = new LinkedList<Drink>();

    /*
     * Constructor Name : Drinks()
     * Parameters : none
     * Description : Default constructor
     */
    public Drinks(String name) 
    {
        new Menu(name);
        drinkSeeder();
    }
    
    /*
     * Method Name : drinkSeeder()
     * Parameters : none
     * Description : - create all drink objects
     */
    private void drinkSeeder()
    {
        allDrinks.add(new Drink("Saffron Tea", 3.99, 4, Category.HOT, "Bread"));
        allDrinks.add(new Drink("Sahlab", 4.99, 3, Category.HOT, "Ginger Biscuit"));
        allDrinks.add(new Drink("Borage flower decoction", 5.49, 4, Category.HOT, "Bread"));
        allDrinks.add(new Drink("Saffron Milk", 2.49, 4, Category.HOT, "Vanilla Biscuits"));
        allDrinks.add(new Drink("African Coffee", 4.99, 5, Category.HOT, "Chocolate Muffins"));
        allDrinks.add(new Drink("Sacjanbein syrup", 6.99, 4, Category.COLD, "Bread"));
        allDrinks.add(new Drink("Khakshir syrup", 6.99, 4, Category.COLD, "Pancakes"));
        allDrinks.add(new Drink("Maghrebi Mint Tea", 3.49, 4, Category.COLD, "Dark Chocolate"));
        allDrinks.add(new Drink("Zobo Drink", 2.99, 4, Category.COLD, "Pineapple-Ginger juice"));
        allDrinks.add(new Drink("Pomegranate juice", 1.99, 4, Category.COLD, "Blueberries"));

    }

    /*
     * Method Name : filterHotDrinks()
     * Parameters : none
     * Description : Method to filter and extract only hot drinks
     */
    public void filterHotDrinks() 
    {
        // Iterate over all drinks in the allDrinks list
        for (Drink hotDrink : allDrinks) 
        {
            // Check if the drink is a hot drink        
            if (Category.HOT.equals(hotDrink.getCategory())) 
            {
                // If the drink is hot, add it to the hotDrinks List
                hotDrinks.add(hotDrink);
            }
        }
    }

    /*
     * Method Name : filterColdDrinks()
     * Parameters : none
     * Description : Method to filter and extract only cold drinks
     */
    public void filterColdDrinks() 
    {
        // Iterate over all drinks in the allDrinks list    
        for (Drink coldDrink : allDrinks) 
        {
            // Check if the drink is a cold drink            
            if (Category.HOT.equals(coldDrink.getCategory())) 
            {
                // If the drink is cold, add it to the coldDrinks List
                coldDrinks.add(coldDrink);
            }
        }
    }

    /*
     * Method Name : displayHotDrinks()
     * Parameters : none
     * Description : display all drinks that are in the HOT drinks category
    */
    public void displayHotDrinks() 
    {
        // Iterator for the hotDrinks List
        ListIterator<Drink> hotDrinkListIterator = hotDrinks.listIterator();
        // initialize counter 
        int i = 0;
        // iterate over each drink in the list 
        while (hotDrinkListIterator.hasNext()) 
        {
            // Get the next hot drink in the list
            Drink hotDrink = hotDrinkListIterator.next();
            // Display details of the drink
            System.out.println("[" + (i + 1) + "] " + hotDrink.toString());
            // Control the space in terminal
            if (i < hotDrinks.size() - 1) {
                System.out.println("");
            }
            // increment counter
            i++;
        }
    }
    
    /*
     * Method Name : displayColdDrinks()
     * Parameters : none
     * Description : display all drinks that are in the COLD drinks category
     */
    public void displayColdDrinks() 
    {
        // Iterator for the hotDrinks List
        ListIterator<Drink> coldDrinkListIterator = coldDrinks.listIterator();
        // initialize counter
        int i = 0;
        // iterate over each drink in the list 
        while (coldDrinkListIterator.hasNext()) 
        {
            // Get the next cold drink in the list
            Drink coldDrink = coldDrinkListIterator.next();
            // Display details of the drink
            System.out.println("[" + (i + 1) + "] " + coldDrink.toString());
            // Control the space in terminal
            if (i < coldDrinks.size() - 1) {
                System.out.println("");
            }
            // increment counter
            i++;
        }
    }
}
