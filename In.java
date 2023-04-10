// import the Scanner class from the java.util package 
import java.util.*;
public class In
{
    // initilaise the scanner object "in" with the System.in stream
    // this allows the Scanner to read input from the terminal
    private static Scanner in = new Scanner(System.in);
    
    // Read the next line of text entered by the user 
    public static String nextLine()
    {
        // return the input as a String
        return in.nextLine();
    }

    // Read the next line of text entered by the user
    public static char nextChar()
    {
        // return the first character of the input as a Char
        return in.nextLine().charAt(0);
    }
    
    // Read the next line of text entered by the user
    public static char nextUpperChar()
    {
        // returns the char at index zero as an uppercase Char
        return in.nextLine().toUpperCase().charAt(0);
    }
    
    // Reads the integer entered by the user 
    public static int nextInt()
    {
        // assigns the input by the user to local variable i
        int i = in.nextInt();
        // consumes the new line character that is left behind the input stream
        /*
         * When the user enters an integer and presses "Enter", a newline character (\n) is added to the input stream, which is not consumed by nextInt(). 
         * Consuming this newline character is important because it ensures that the next input operation starts on a new line, avoiding any potential errors or unexpected behavior.
         */
        in.nextLine();
        // returns the integer entered by the user
        return i;
    }
    
    // Reads the double entered by the user  
    public static double nextDouble()
    {
        // assigns the input by the user to local variable d
        double d = in.nextDouble();
        // consumes the new line character that is left behind the input stream
        /*
         * When the user enters a double and presses "Enter", a newline character (\n) is added to the input stream, which is not consumed by nextDouble(). 
         * Consuming this newline character is important because it ensures that the next input operation starts on a new line, avoiding any potential errors or unexpected behavior.
         */
        in.nextLine();
        // returns the double entered by the user
        return d;   
    }
}
