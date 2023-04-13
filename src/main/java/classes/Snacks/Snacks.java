package classes.Snacks;

import java.util.LinkedList;

import classes.Enums.Category;
import classes.System.Menu;

public class Snacks 
{
    // attributes
    // LinkedList data for all the Snack items
    private LinkedList<Snack> allSnacks = new LinkedList<Snack>();

    /*
     * Constructor Name : Snacks()
     * Parameters : none
     * Description : Default constructor
     */
    public Snacks(String name) 
    {
        new Menu(name);
        snackSeeder();
    }
    
    /*
     * Method Name : drinkSeeder()
     * Parameters : none
     * Description : - create all snack objects
     */
    private void snackSeeder()
    {
        // Create snack objects
        allSnacks.add(new Snack("Falafel", 6.99, Category.SNACK, 4, "Small", 4));
        allSnacks.add(new Snack("Bandari Sausage", 4.99, Category.SNACK, 3, "Medium", 2));
        allSnacks.add(new Snack("Çig Köfte", 3.49, Category.SNACK, 4, "Large", 1));
        allSnacks.add(new Snack("Kalamata Olive Hummus", 4.99, Category.SNACK, 5, "Medium", 1));
        allSnacks.add(new Snack("Biltong", 2.99, Category.SNACK, 4, "Small", 3));
        allSnacks.add(new Snack("Brik", 1.99, Category.SNACK, 4, "Small", 3));
    }

    /*
     * Method Name : displayAllSnacks()
     * Parameters : none
     * Description : display all the items that are in the SNACK drinks category
     */
    public void displayAllSnacks()
    {
        // Iterate over each snack in the list
        for (int i = 0; i < allSnacks.size(); i++)
        {
            // Display snack details
            System.out.println("[" + (i + 1) + "] " + allSnacks.get(i).toString());
            // Control the space in terminal
            if (i < allSnacks.size() - 1) {
                System.out.println("");
            }
        }
    }    
}
