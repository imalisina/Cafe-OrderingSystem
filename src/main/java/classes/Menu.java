package classes;

public class Menu {
    /*
     * Constructor Name : Menu()
     * Parameters : String menuTitle
     * Description : Alternate Constructor
    */
    public Menu(String menuTitle) {
        System.out.println("----------- "+ menuTitle +" ------------");
    }

    /*
     * Method Name : showMenu()
     * Parameters : menuItems
     * Description : Method to display available options as a structured menu
    */
    public void showMenu(String[] menuItems) {
        // Define a temporary counter
        int loopCounter = 0;
        // Display the menu options with a foreach loop
        for (String menuItem : menuItems) {
            System.out.println("[" + (loopCounter + 1) + "] " + menuItem);
            loopCounter++;
        }
    }
}