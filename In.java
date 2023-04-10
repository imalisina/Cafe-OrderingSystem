// import the Scanner class from the java.util package 
import java.util.*;
public class In
{
    // Initilaise the scanner object "in" with the System.in stream 
    private static Scanner in = new Scanner(System.in);
    
    /*
     * Method name: nextLine
     * Parameters: none
     * Description: - Read the next line of text entered by the user
                    - Return the input as a String
     */
    public static String nextLine()
    {
        return in.nextLine();
    }

    /*
     * Method name: nextChar
     * Parameters: none
     * Description: - Read the next line of text entered by the user
                    - Return the first character of the input as a Char
     */
    public static char nextChar()
    {
        return in.nextLine().charAt(0);
    }
    
    /*
     * Method name: nextUpperChar
     * Parameters: none
     * Description: - Read the next line of text entered by the user
                    - Return the char at index zero as an uppercase Char
     */
    public static char nextUpperChar()
    {
        return in.nextLine().toUpperCase().charAt(0);
    }
    
    /*
     * Method name: nextInt
     * Parameters: none
     * Description: - Reads the integer entered by the user
                    - Assigns the input by the user to local variable i
                    - Returns the integer entered by the user
     *  Note: - When the user enters an integer and presses "Enter", a newline character (\n) is added to the input stream, which is not consumed by nextInt().
              - Consuming this newline character is important because it ensures that the next input operation starts on a new line, avoiding any potential errors or unexpected behavior.
     */       
    public static int nextInt()
    {
        int i = in.nextInt();
        in.nextLine();
        return i;
    }
    
    /*
     * Method name: nextDouble
     * Parameters: none
     * Description: - Reads the double entered by the user
                    - Assigns the input by the user to local variable d
                    - Returns the double entered by the user
     *  Note: - When the user enters an double and presses "Enter", a newline character (\n) is added to the input stream, which is not consumed by nextDouble().
              - Consuming this newline character is important because it ensures that the next input operation starts on a new line, avoiding any potential errors or unexpected behavior.
     */     
    public static double nextDouble()
    {
        double d = in.nextDouble();
        in.nextLine();
        return d;   
    }
}
