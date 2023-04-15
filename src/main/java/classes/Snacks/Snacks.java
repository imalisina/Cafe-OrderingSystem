package classes.Snacks;

import java.util.LinkedList;

import classes.Items;
import classes.Enums.Category;
import classes.System.Menu;

public class Snacks implements Items
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
        itemSeeder();
    }

    /*
     * Constructor Name : Snacks()
     * Parameters : name
     * Description : Alternate constructor
     */
    public Snacks(String name) 
    {
        new Menu(name);
        itemSeeder();
    }
    
    /*
     * Method Name : drinkSeeder()
     * Parameters : none
     * Description : - create all snack objects
     */
    @Override
    public void itemSeeder()
    {
        // Create snack objects
        allSnacks.add(new Snack("French Fries", 2.99, 5,Category.SNACK,  "Large", 1));
        allSnacks.add(new Snack("Çig Köfte", 3.49, 4,Category.SNACK,  "Large", 1));
        allSnacks.add(new Snack("Biltong", 2.99, 4,Category.SNACK,  "Small", 3));
        allSnacks.add(new Snack("Sponge Cake", 3.99, 4,Category.SNACK,  "Medium", 2));
        allSnacks.add(new Snack("Pizza Cup", 5.99, 5,Category.SNACK,  "Small", 3));
    }

    /*
     * Method Name : displayAllSnacks()
     * Parameters : none
     * Description : display all the items that are in the SNACK drinks category
     */
    public void displayAllSnacks()
    {
        // Iterate over each snack in the list
        for (int i = 0; i < getSize(); i++) 
        {
            // Display snack details
            System.out.println("[" + (i + 1) + "] " + allSnacks.get(i).toString());
            // Control the space in terminal
            if (i < getSize() - 1) 
            {
                System.out.println("");
            }
        }
    }
    
    /*
     * Method Name : findSnack()
     * Parameters : id
     * Description : return the snack at the given index
     */
    public Snack findSnack(int id)
    {
        return allSnacks.get(id - 1);
    }

    /*
     * Method Name : getSize()
     * Parameters : none
     * Description : - Overide the getSize() in items 
     *               - return the size of the snack list
     */
    public int getSize() 
    {
        return allSnacks.size();
    }
}
