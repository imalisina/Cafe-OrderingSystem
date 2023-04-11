package classes.Auth;

import classes.Input;

public class Register {
    // Attributes
    private boolean isFullNameValidated = false;
    private boolean isUsernameValidated = false;
    private boolean isEmailValidated = false;
    private boolean isPasswordValidated = false;
    
    /*
     * Constructor Name : Register()
     * Parameters : fullName, username, email, password
     * Description : Alternate constrcutor
    */
    public Register () {
        System.out.print("your name :");
        String name = Input.nextLine();
        System.out.print("enter username :");
        String username = Input.nextLine();
        System.out.print("enter email :");
        String email = Input.nextLine();
        System.out.print("enter password :");
        String password = Input.nextLine();
        validationHandler(name, username, email, password);
    }

    /*
     * Method Name : validationHandler()
     * Parameters : enteredFullName, enteredUsername, enteredEmail, enteredPassword
     * Description : Method to handle input validation operation
    */
    public void validationHandler(String enteredFullName, String enteredUsername, String enteredEmail, String enteredPassword) {
        validateFullName(enteredFullName);

        if (isFullNameValidated && isUsernameValidated && isEmailValidated && isPasswordValidated) {
            System.out.println("account created");
        } else {
            System.out.println("error");
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
        
    }
}
