package classes.Snacks;

import java.util.LinkedList;
import classes.*;

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
    public Snacks() 
    {
        snackSeeder();
    }
    
    /*
     * Method Name : drinkSeeder()
     * Parameters : none
     * Description : - create all snack objects
     */
    private void snackSeeder()
    {
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
        System.out.println("Snacks Menu:\n");

        for (int i = 0; i < allSnacks.size(); i++)
        {
            System.out.println("[" + (i + 1) + "] " + allSnacks.get(i).toString() + "\n");
        }
    }    
}
