package classes.Users;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.ListIterator;

import classes.Enums.Roles;

public class Users {
    // Attributes
    // LinkedList data for all the Users
    public LinkedList<User> allUsers = new LinkedList<User>();
    private LinkedList<User> customers = new LinkedList<User>();

    /*
     * Constructor Name : Users()
     * Parameters : none
     * Description : Default constructor
     */
    public Users () throws NoSuchAlgorithmException {
        allUsers.add(new User("Admin", "cafe_admin", "admin@persinanights/.com", "admin", Roles.ADMIN, "12-04-2022 07:14:30"));
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
        ListIterator<User> customerListIterator = customers.listIterator();
        while (customerListIterator.hasNext()) {
            User customer = customerListIterator.next();
            System.out.println("--------------------------");
            System.out.println(customer.toString());
            System.out.println("--------------------------");
        }
    }
}



// TASKS -->
// CHANGE COMMENTS
// CREATE A TABLE FORMAT FOR CUSTOMER DETAILS
// IMPLEMENT LOGIN
// IMPLEMENT REGISTER
// PERFORM THE INHERITANCE OPERATION IN LOGIN AND REGISTER
// CHECK THE FILE I/O OPERATION TO STORE USERS' DETAILS AFTER REGISTRATION PROCESS
// CHECK THE FILE I/O OPERATION TO READ USERS' DETAILS FOR LOGIN PROCESS