package classes.System;

public class Router {
    // An attribute for routing in switch statement
    private static int router;

    // An attribute for activating alternate constructor
    private static boolean activateRouter = false;

    /*
    * Method name: Router --> DEFAULT CONSTRUCTOR
    * Parameters: none
    * Description: ask user to select one option
    */
    public Router() {
        System.out.print("Please select one option : ");
    }

    /*
    * Method name: Router --> ALTERNATE CONSTRUCTOR
    * Parameters: boolean activateRouter
    * Description: validates the router option and
    *              execute other operations
    */
    public Router(boolean activateRouter){
        if (activateRouter) {
            // Validate option
            routerValidator();
        } else {
            System.exit(0);
        }
    }

    /*
     * Method name: routerValidator
     * Parameters: none
     * Description: validating entered menu option
     */
    public static void routerValidator () {
        if ((router != 1) && (router != 2) && (router != 3)) {
            System.out.println("Invalid option! Please try again.");
            System.exit(0);
        } else {
            activateRouter = true;
            System.out.println("Please wait for a second ....");
            System.out.println("----------------------");
        }
    }

    /*
    * Method name: getRouter
    * Parameters: none
    * Description: a Getter method(Accessor) for the router
    */
    public int getRouter () {
        return router;
    }

    /*
    * Method name: setRouter
    * Parameters: int router
    * Description: a Setter method(Mutator) for the router
    */
    public void setRouter (int router) {
        Router.router = router;
    }

    /*
    * Method name: getGateway
    * Parameters: none
    * Description: a Getter method(Accessor) for the activateRouter attribute
    */
    public boolean getActivateRouter () {
        return activateRouter;
    }
}