package classes.Users;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import classes.Encryptor;
import classes.Enums.Roles;

public class User extends Encryptor {
    // Attributes
    private String fullName, username, email, password;
    private Roles userRole = Roles.CUSTOMER;
    private LocalDateTime timestamps;
    private String formattedTimestamps;

    /*
     * Constructor Name : User()
     * Parameters : fullName, username, email, password
     * Description : Alternate constructor - used to create new customer
     */
    public User(String fullName, String username, String email, String password) throws NoSuchAlgorithmException {
        // Initialize the values
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = super.encryptionHandler(password);
        timestamps = LocalDateTime.now();
        
        // Store the formatted timestamps 
        formatTimestamps();
    }

    /*
     * Constructor Name : User()
     * Parameters : fullName, username, email, password, userRole
     * Description : Alternate constructor - used to add new admin
     */
    public User(String fullName, String username, String email, String password, Roles userRole, String formattedTimeStamps) throws NoSuchAlgorithmException {
        // Initialize the values
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = super.encryptionHandler(password);
        this.userRole = userRole;
        this.formattedTimestamps = formattedTimeStamps;
    }

    /*
     * Method Name : getFullName()
     * Parameters : none
     * Description : getter/accessor
     */
    public String getFullName() {
        return fullName;
    }

    /*
     * Method Name : getUsername()
     * Parameters : none
     * Description : getter/accessor
     */
    public String getUsername() {
        return username;
    }

    /*
     * Method Name : getEmail()
     * Parameters : none
     * Description : getter/accessor
     */
    public String getEmail() {
        return email;
    }

    /*
     * Method Name : getRole()
     * Parameters : none
     * Description : getter/accessor
     */
    public Roles getRole() {
        return userRole;
    }

    /*
     * Method Name : getEncryptedPassword()
     * Parameters : none
     * Description : getter/accessor
    */
    public String getEncryptedPassword () {
        return password;
    }

    /*
     * Method Name : formatTimestamps()
     * Parameters : none
     * Description : method to format the generated timestamps
     */
    private void formatTimestamps() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedTimestamps = timestamps.format(format);
    }

    /*
     * Method Name : toString()
     * Parameters : none
     * Description : display attributes of the User object
     */
    public String toString() {
        return "Full name: " + fullName + "\nUsername: " + username + "\nPassword: " + password + "\nEmail Address: " + email + "\nRole: "
                + userRole + "\nProfile created at " + formattedTimestamps;
    }
}
