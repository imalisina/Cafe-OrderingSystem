package classes.Auth;

import java.security.NoSuchAlgorithmException;

import classes.Encryptor;
import classes.FileHandler;
import classes.Menu;

public class Login extends Menu {
    // Attributes
    private boolean isUsernameValidated, isPasswordValidated = false;
    // Store extracted username and password 
    private String extractedUsername, extractedPassword = "";

    // An instance of FileHanlder object
    FileHandler fileReader = new FileHandler();

    /*
     * Constructor Name : Login()
     * Parameters : none
     * Description : Default constrcutor
    */
    public Login () {
        super("Login");
    }

    /*
     * Method Name : validationHandler()
     * Parameters : enteredUsername, enteredPassword
     * Description : Method to handle input validation operation
    */
    public boolean validationHandler(String enteredUsername, String enteredPassword) throws NoSuchAlgorithmException {
        // Invoke a method to extract the stored username and password
        checkUserSession();

        // Invoke methods to validate the login details of the user
        validateUsername(enteredUsername);
        Encryptor encryptor = new Encryptor();
        validatePassowrd(encryptor.encryptionHandler(enteredPassword));

        // Condition to check whether fields are verified or not
        if (isUsernameValidated && isPasswordValidated) {
            System.out.println("[SUCCESS] Logged-in to the account.");
            return true;
        } else {
            System.out.println("[ERROR] An error occured, try again !");
            return false;
        }
    }

        /*
     * Method Name : checkUserSession()
     * Parameters : none
     * Description : Method to check the existance of entered username and password in login operation
    */
    public void checkUserSession() {
        extractedUsername = fileReader.readFromFile("UsernameData");
        extractedPassword = fileReader.readFromFile("PasswordData");
    }

    /*
     * Method Name : validateUsername()
     * Parameters : enteredUsername
     * Description : Method to validate username of user
    */
    public void validateUsername(String enteredUsername) {
        if (enteredUsername.equals(extractedUsername)) {
            isUsernameValidated = true;
        } else {
            isUsernameValidated = false;
        }
    }

    /*
     * Method Name : validatePassword()
     * Parameters : enteredPassword
     * Description : Method to validate password of user
    */
    public void validatePassowrd(String enteredPassword) {
        if (enteredPassword.equals(extractedPassword)) {
            isPasswordValidated = true;
        } else {
            isPasswordValidated = false;
        }
    }
}
