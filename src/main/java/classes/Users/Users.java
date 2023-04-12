package classes.Users;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.ListIterator;

import classes.FileHandler;
import classes.Input;
import classes.Menu;
import classes.Auth.Login;
import classes.Auth.Register;
import classes.Enums.Roles;

public class Users extends FileHandler {
    // Attributes
    // An boolen to store new user's authorization status
    boolean isAuthorized = false;
    // LinkedList data for all the Users
    public LinkedList<User> allUsers = new LinkedList<User>();
    private LinkedList<User> customers = new LinkedList<User>(); 

    // An instance of Register class
    Register createAccount;

    // An instance of Login class
    Login loginToAccount;

    // An instance of Input class
    Input input = new Input();

    /*
     * Constructor Name : Users()
     * Parameters : none
     * Description : Default constructor - create an admin for the system
    */
    public Users () throws NoSuchAlgorithmException {
        allUsers.add(new User("Admin", "cafe_admin", "admin@persinanights.com", "admin", Roles.ADMIN, "12-04-2022 07:14:30"));
    }

    /*
     * Method Name : registerOperation()
     * Parameters : none
     * Description : Method to activate registration operation
    */
    public void registerOperation () throws NoSuchAlgorithmException {
        // Activte Register object
        createAccount = new Register();

        // Define temporary variables to store entered values
        String enteredFullName, enteredUsername, enteredEmail, enteredPassword = "";
        
        // Asking questions for registration process
        // Asking for full name
        System.out.print("Enter your full name : ");
        enteredFullName = Input.nextLine();
        // Asking for username
        System.out.print("Enter your username : ");
        enteredUsername = Input.nextLine();
        // Asking for email
        System.out.print("Enter your email address : ");
        enteredEmail = Input.nextLine();
        // Asking for password
        System.out.print("Enter a new password : ");
        enteredPassword = Input.nextLine();

        // Store the validation result
        boolean validationResult = createAccount.validationHandler(enteredFullName, enteredUsername, enteredEmail, enteredPassword);
        
        // Check the final validation result
        if (!validationResult) {
            // Terminate from the program
            System.exit(1);
        }

        // Create new user based on the validated details
        allUsers.add(new User(enteredFullName, enteredUsername, enteredEmail, enteredPassword));

        // Change user's authorization status
        isAuthorized = true;

        // Create a session for the user
        createUserSession(allUsers.getLast().getUsername(), allUsers.getLast().getEncryptedPassword());
    }

    /*
     * Method Name : loginOperation()
     * Parameters : none
     * Description : Method to activate login operation
    */
    public void loginOperation() throws NoSuchAlgorithmException {
        // Activate Login object
        loginToAccount = new Login();
        
        // Define temporary variables to store entered values
        String enteredUsername, enteredPassword = "";

        // Asking questions for login process
        // Asking for username
        System.out.print("Enter your username : ");
        enteredUsername = Input.nextLine();
        // Asking for password
        System.out.print("Enter a new password : ");
        enteredPassword = Input.nextLine();

        // Store the validation result
        boolean validationResult = loginToAccount.validationHandler(enteredUsername, enteredPassword);
        
        // Check the final validation result
        if (!validationResult) {
            // Terminate from the program
            System.exit(1);
        }

        // Change user's authorization status
        isAuthorized = true;
    }

    /*
     * Method Name : createUserSession()
     * Parameters : validatedUsername, validatedPassword 
     * Description : Method to create a session for user that will be used in further Login requests
    */
    public void createUserSession(String validatedUsername, String validatedPassword) {
        super.writeOnFile(validatedUsername, validatedPassword);
    }

    /*
     * Method Name : editProfileHandler()
     * Parameters : none
     * Description : Method to activate edit profile handler
    */
    public void editProfileHandler() throws NoSuchAlgorithmException {
        // Define temporary variable to store user's choice
        int choiceId = 0;
        // Define all available menu options
        String[] settingOptions = {"Change Full name" , "Change Username" , "Change Email" , "Reset Password" , "Delete Account"};

        // An instance of Menu object
        Menu settingMenu = new Menu("Settings");
        
        // Define a temporary boolean variable to check whether user wants to change other details
        boolean editAgain = true;
        do {
        // Display a list of available options to the user for edit profile
        settingMenu.showMenu(settingOptions);

        // Asking question for edit profile process
        System.out.print("Enter the ID of the data you want to update: ");
        choiceId = Input.nextInt();

            // Invoke the profile detail field extractor
            profileDetailExtractor(choiceId);

            // Ask whether user wants to edit other fields or not
            System.out.println("Do you want to update other fields ? [y/n]: ");
            String response = Input.nextLine();
            // Check the response
            if (response.equalsIgnoreCase("y")) {
                editAgain = true;
            } else if (response.equalsIgnoreCase("n")) {
                editAgain = false;
            }
        } while (editAgain);
    }

    /*
     * Method Name : profileDetailExtractor()
     * Parameters : none
     * Description : Method to extract selected profile detail
     */
    public void profileDetailExtractor(int profileDetailID) throws NoSuchAlgorithmException {
        // Define a temporary string variable to store new entered value
        String temp = "";
        // Switch case to find the correct profile detail field
        switch (profileDetailID) {
            case 1:
                temp = inputOutputHandler("Enter a new full name: ");
                allUsers.get(1).updateFullName(temp);
                break;
            case 2: 
                temp = inputOutputHandler("Enter a new username: ");
                allUsers.get(1).updateUsername(temp);
                super.writeOnFile(allUsers.get(1).getUsername());
                break;
            case 3:
                temp = inputOutputHandler("Enter a new email address: ");
                allUsers.get(1).updateEmail(temp);
                break;
            case 4: 
                // Check whether user is authorized or not
                if (isAuthorized) {
                    temp = inputOutputHandler("Enter a new secure password: ");
                    allUsers.get(1).resetPassword(temp);
                    super.writeOnFile(allUsers.get(1).getEncryptedPassword());
                } else {
                    System.out.println("[ERROR] you are not authorized !");
                    System.exit(1);
                }
                break;
            case 5: 
                allUsers.remove(1);
                System.out.println("[INFO] Account has been removed form system.");
                // Terminate the program
                System.exit(0);
        }
    }

     /*
     * Method Name : inputOutputHandler()
     * Parameters : question
     * Description : Method to handle the input/output process for settings
     */
    public String inputOutputHandler (String question) {
        // Display the sent message
        System.out.print(question);
        // Store in a temp file
        String answer = Input.nextLine();
        return answer;
    }

    /*
     * Method Name : filterCustomers()
     * Parameters : none
     * Description : Method to filter and extract only customers
     */
    public void filterCustomers() {
        for (User customer : allUsers) {
            if (Roles.CUSTOMER.equals(customer.getRole())) {
                customers.add(customer);
            }
        }
    }


    /*
     * Method Name : displayAllCustomers()
     * Parameters : none
     * Description : Method to display all of the customers in the cafe
     */
    public void displayAllCustomers() {
        // Define a list iterator for customers class
        ListIterator<User> customerListIterator = customers.listIterator();
        while (customerListIterator.hasNext()) {
            User customer = customerListIterator.next();
            System.out.println("---------------------------");
            System.out.println(customer.toString());
        }
    }
}