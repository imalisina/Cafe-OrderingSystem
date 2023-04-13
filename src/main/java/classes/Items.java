package classes;

import java.util.LinkedList;

public abstract class Items 
{
    protected LinkedList<Item> allItems = new LinkedList<Item>();
    /*
     * Constructor Name : Items()
     * Parameters : none
     * Description : Default constructor
     */
    public Items() 
    {
        itemSeeder();
    }
    
    /*
     * Method Name : itemSeeder()
     * Parameters : none
     * Description : abstract Method to create item objects
     */
    public abstract void itemSeeder();

    /*
     * Method Name : getSize()
     * Parameters : none
     * Description : return the size of the items list
     */
    public int getSize()
    {
        return allItems.size();
    }
}
