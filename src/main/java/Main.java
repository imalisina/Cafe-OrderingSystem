import classes.System.Input;
import classes.System.Menu;
import classes.System.Router;

public class Main {
    // Declare & initialize program name
    private static final String PROGRAM_NAME = "Persian Nights - Cafe Ordering System";
    private static final String DEVELOPER_NAME_ONE = "Alisina Br.";
    private static final String DEVELOPER_NAME_TWO = "Ifhaam Z";

    // New instance of Router class
    static Router newRouter;

    public static void main(String[] args) { 
        // Operations
        welcomeMessage();
        displayAuthMenu();

        // Send entered router option
        callRouter();

        // Using Router's alternate constructor
        System.out.println("[INFO] Option " + newRouter.getRouter() + " selected.");
        newRouter = new Router(true);

        switch(newRouter.getRouter()) {
            case 1:
                // ADD REGISTRATION OPERATION
                break;
            case 2:
                // ADD LOGIN OPERATION
                break;
        }
    }

    /*
     * Method Name : welcomeMessage()
     * Parameters : none
     * Description : display a welcome message in terminal window
    */
    public static void welcomeMessage() {
        System.out.println("----------------------");
        System.out.println("Welcome to " + PROGRAM_NAME);
        System.out.println("Code by " + DEVELOPER_NAME_ONE + " & " + DEVELOPER_NAME_TWO);
    }

    /*
     * Method Name : displayAuthMenu()
     * Parameters : none
     * Description : display the program's first menu
    */
    public static void displayAuthMenu() {
        Menu authMenu = new Menu("Authentication");
        String[] authMenuItems = {"Getting Started","Login"};
        authMenu.showMenu(authMenuItems);
    }

    /*
    * Method name: sendRouter
    * Parameters: none
    * Description: gets router input from users
    */
    public static void callRouter() {
        // Local router variable
        int router;
        // New instance of Router by default constructor
        newRouter = new Router();
        router = Input.nextInt();
        newRouter.setRouter(router);
    }
}