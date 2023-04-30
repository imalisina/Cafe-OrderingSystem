import java.security.NoSuchAlgorithmException;

import classes.Order;
import classes.System.Input;
import classes.System.Menu;
import classes.System.Router;
import classes.Users.Users;

public class Main {

    // Declare & initialize program name
    private static final String PROGRAM_NAME = "Persian Nights - Cafe Ordering System";
    private static final String DEVELOPER_NAME_ONE = "Alisina Br.";
    private static final String DEVELOPER_NAME_TWO = "Ifhaam Z";

    // New instance of Router class
    static Router newRouter;

    // New instance of Users group class
    static Users customers;

    // New instance of Order class
    static Order customerOrder = new Order();

    public static void main(String[] args) throws NoSuchAlgorithmException { 
        // Operations
        welcomeMessage();
        displayAuthMenu();

        // Send entered router option
        callRouter();

        // Using Router's alternate constructor
        System.out.println("[INFO] Option " + newRouter.getRouter() + " selected.");
        newRouter = new Router(true);

        customers = new Users();

        switch(newRouter.getRouter()) {
            case 1:
                customers.registerOperation();
                handleMainActions();
                break;
            case 2:
                customers.loginOperation();
                handleMainActions();
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
     * Method Name : displayActionMenu()
     * Parameters : none
     * Description : display the program's action menu
    */
    public static void displayActionMenu() {
        Menu actionMenu = new Menu("Features");
        String[] actionMenuItems = {"Get Account Details", "Place an Order", "Settings"};
        actionMenu.showMenu(actionMenuItems);
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

    /*
    * Method name: handleMainActions
    * Parameters: none
    * Description: handle main features of the program
    */
    public static void handleMainActions() throws NoSuchAlgorithmException {
        // Call the method to display main action menu
        displayActionMenu();
        // Activate the router processes
        callRouter();
        // Display an info message in terminal
        System.out.println("[INFO] Option " + newRouter.getRouter() + " selected.");
        newRouter = new Router(true);
        
        // Check the cases and redirect user to the correct action
        switch (newRouter.getRouter()) {
            case 1:
                System.out.println(customers.allUsers.get(1));
                break;
            case 2:
                customerOrder.placeOrder();
                break;
            case 3:
                customers.editProfileHandler();           
                break;
        }
}