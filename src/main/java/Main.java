import java.security.NoSuchAlgorithmException;

import classes.Order;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException { 
        System.out.println("Hello World");
        Order order = new Order();
        order.placeOrder();
    }
}