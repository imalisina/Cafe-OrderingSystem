package classes.Auth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import classes.Encryptor;

public class Login extends Encryptor {
    // Attributes
    private boolean isUsernameValidated, isPasswordValidated = false;
    // Store extracted username and password 
    private String extractedUsername, extractedPassword = "";

    /*
     * Constructor Name : Login()
     * Parameters : none
     * Description : Default constrcutor
    */
    public Login () {
        System.out.println("----------- Login ------------");
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
        validatePassowrd(super.encryptionHandler(enteredPassword));

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
        // Implement a try catch to handle errors during the "File Reading" process
        try {
            // Create buffer reader to perform file reading
            // Specify the file with relative path
            BufferedReader usernameReader = new BufferedReader(new FileReader("UsernameData.txt"));
            BufferedReader passwordReader = new BufferedReader(new FileReader("PasswordData.txt"));
            // Extract user's username and password
            // Then, close the buffer to store the extracted data
            extractedUsername = usernameReader.readLine();
            usernameReader.close();
            extractedPassword = passwordReader.readLine();
            passwordReader.close();
        } catch (IOException e) {
            // throw an I/O exception - if any
            e.printStackTrace();
        }
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
