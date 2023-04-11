package classes;

import java.util.LinkedList;

public class Snacks 
{
    private LinkedList<Snack> allSnacks = new LinkedList<Snack>();

    public Snacks() 
    {
        setUpAllSnacks();
    }
    
    private void setUpAllSnacks()
    {
        allSnacks.add(new Snack("Falafel", 6.99, Category.SNACK,4, "Small", 4));
        allSnacks.add(new Snack("Bandari Sausage", 4.99, Category.SNACK,3, "Medium", 2));
        allSnacks.add(new Snack("Çig Köfte", 3.49, Category.SNACK, 4, "Large", 1));
        allSnacks.add(new Snack("Kalamata Olive Hummus", 4.99, Category.SNACK, 5, "Medium", 1));
        allSnacks.add(new Snack("Biltong", 2.99, Category.SNACK, 4, "Small", 3));
        allSnacks.add(new Snack("Brik", 1.99, Category.SNACK, 4, "Small", 3));
    }

    public void displayAllSnacks()
    {
        System.out.println("Snacks Menu:\n");

        for (int i = 0; i < allSnacks.size(); i++)
        {
            System.out.println("[" + (i + 1) + "] " + allSnacks.get(i).toString() + "\n");
        }
    }    
}
