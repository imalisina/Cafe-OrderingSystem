package classes.Auth;

import classes.Input;

public class Register {
    // Attributes
    private boolean isFullNameValidated, isUsernameValidated, isEmailValidated, isPasswordValidated = false;
    
    /*
     * Constructor Name : Register()
     * Parameters : fullName, username, email, password
     * Description : Alternate constrcutor
    */
    public Register () {
        // Define temporary variables to store entered values
        String enteredFullName, enteredUsername, enteredEmail, enteredPassword = "";
        // Asking questions for registration process
        // Asking for full name
        System.out.print("Enter your full name : ");
        enteredFullName = Input.nextLine();
        // Asking for 
    }

    /*
     * Method Name : validationHandler()
     * Parameters : enteredFullName, enteredUsername, enteredEmail, enteredPassword
     * Description : Method to handle input validation operation
    */
    public void validationHandler(String enteredFullName, String enteredUsername, String enteredEmail, String enteredPassword) {
        // Invoke validator methods to validate each input field one by one
        validateFullName(enteredFullName);
        validateUsername(enteredUsername);
        validateEmail(enteredEmail);
        validatePassowrd(enteredPassword);
        
        // Condition to check whether fields are verified are not
        if (isFullNameValidated && isUsernameValidated && isEmailValidated && isPasswordValidated) {
            System.out.println("[SUCCESS] Account created.");
        } else {
            System.out.println("[ERROR] An error occured, try again !");
            // Terminate the program
            System.exit(1);
        }
    }

    /*
     * Method Name : validateFullName()
     * Parameters : enteredFullName
     * Description : Method to validate full name of user
    */
    public void validateFullName(String enteredFullName) {
        if (enteredFullName.isEmpty() || enteredFullName.equalsIgnoreCase("Admin")) {
            isFullNameValidated = false;
        } else {
            isFullNameValidated = true;
        }
    }

    /*
     * Method Name : validateUsername()
     * Parameters : enteredUsername
     * Description : Method to validate username of user
    */
    public void validateUsername(String enteredUsername) {
        if (enteredUsername.isEmpty() || enteredUsername.equalsIgnoreCase("cafe_admin")) {
            isUsernameValidated = false;
        } else {
            isUsernameValidated = true;
        }
    }

    /*
     * Method Name : validateEmail()
     * Parameters : enteredEmail
     * Description : Method to validate email of user
    */
    public void validateEmail(String enteredEmail) {
        if (enteredEmail.isEmpty() || enteredEmail.equalsIgnoreCase("admin@persinanights/.com")) {
            isEmailValidated = false;
        } else {
            isEmailValidated = true;
        }
    } 

    /*
     * Method Name : validatePassword()
     * Parameters : enteredPassword
     * Description : Method to validate password of user
    */
    public void validatePassowrd(String enteredPassword) {
        if (enteredPassword.isEmpty() || enteredPassword.length() <= 7) {
            isPasswordValidated = false;
        } else {
            isPasswordValidated = true;
        } 
    }
}