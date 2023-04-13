package classes.Users;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import classes.Enums.Roles;
import classes.System.Encryptor;

public class User {
    // Attributes
    private String fullName, username, email, password;
    private Roles userRole = Roles.CUSTOMER;
    private LocalDateTime timestamps;
    private String formattedTimestamps;

    // An instance of Encryptor class
    Encryptor encryptor = new Encryptor();

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
        this.password = encryptor.encryptionHandler(password);
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
        this.password = encryptor.encryptionHandler(password);
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
     * Method Name : updateFullName()
     * Parameters : newFullName
     * Description : setter/mutator
    */
    protected void updateFullName(String newFullName) {
        fullName = newFullName;
        // Store the formatted timestamps 
        updateTimestamps();
    }

    /*
     * Method Name : updateUsername()
     * Parameters : newUsername
     * Description : setter/mutator
    */
    protected void updateUsername(String newUsername) {
        username = newUsername;
        // Store the formatted timestamps 
        updateTimestamps();
    }

    /*
     * Method Name : updateEmail()
     * Parameters : newEmail
     * Description : setter/mutator
    */
    protected void updateEmail (String newEmail) {
        email = newEmail;
        // Store the formatted timestamps 
        updateTimestamps();
    }

    /*
     * Method Name : resetPassword()
     * Parameters : newPassword
     * Description : setter/mutator
    */
    protected void resetPassword (String newPassword) throws NoSuchAlgorithmException {
        this.password = encryptor.encryptionHandler(newPassword);
        // Store the formatted timestamps 
        updateTimestamps();
    }

    /*
     * Method Name : updateTimestamps()
     * Parameters : none
     * Description : Method to update the timestamps automatically for every changes in the profile
    */
    private void updateTimestamps() {
        timestamps = LocalDateTime.now();
        // Store the formatted timestamps 
        formatTimestamps();
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
