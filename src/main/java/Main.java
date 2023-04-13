import java.security.NoSuchAlgorithmException;

import classes.Users.Users;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException { 
        System.out.println("Hello World");
        Users full = new Users();
        full.registerOperation();
        full.loginOperation();
        full.editProfileHandler();
        System.out.println(full.allUsers.get(1));
    }
}