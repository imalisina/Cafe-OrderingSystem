package classes.Users;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.ListIterator;

import classes.Input;
import classes.Auth.Register;
import classes.Enums.Roles;

public class Users {
    // Attributes
    // LinkedList data for all the Users
    public LinkedList<User> allUsers = new LinkedList<User>();
    private LinkedList<User> customers = new LinkedList<User>(); 

    // An instance of Register class
    Register createAccount = new Register();

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

        // Create a session for the user
        createUserSession(enteredUsername, enteredPassword);
    }

    /*
     * Method Name : createUserSession()
     * Parameters : validatedUsername, validatedPassword 
     * Description : Method to create a session for user that will be used in further Login requests
    */
    public void createUserSession(String validatedUsername, String validatePassword) {
        // Implement a try catch to handle errors during the "File Writing" process
        try {
            // Create buffer writer to perform file writing
            // Specify the file with relative path
            BufferedWriter writer = new BufferedWriter(new FileWriter("UserSession.txt"));
            // Store user's username and password
            writer.write(validatedUsername);
            writer.write("\n"+validatePassword);
            writer.write("\n------------------");
            // Close the buffer to store the written data
            writer.close();
            System.out.println("[INFO] Session has been added.");
        } catch (IOException e) {
            // throw an I/O exception - if any
            e.printStackTrace();
        }
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