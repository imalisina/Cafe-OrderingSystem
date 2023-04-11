package classes.Drinks;

import classes.Enums.Category;

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
    public Drinks() 
    {
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
        for (Drink hotDrink : allDrinks) {
            if (Category.HOT.equals(hotDrink.getCategory())) {
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
        for (Drink coldDrink : allDrinks) {
            if (Category.HOT.equals(coldDrink.getCategory())) {
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
        System.out.println("Hot Drinks Menu:\n");

        ListIterator<Drink> hotDrinkListIterator = hotDrinks.listIterator();
        int i = 0;
        while (hotDrinkListIterator.hasNext()) {
            Drink hotDrink = hotDrinkListIterator.next();
            System.out.println("[" + (i + 1) + "] " + hotDrink.toString() + "\n");
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
        System.out.println("Cold Drinks Menu:\n");

        ListIterator<Drink> coldDrinkListIterator = coldDrinks.listIterator();
        int i = 0;
        while (coldDrinkListIterator.hasNext()) {
            Drink coldDrink = coldDrinkListIterator.next();
            System.out.println("[" + (i + 1) + "] " + coldDrink.toString() + "\n");
            i++;
        }
    }
}
