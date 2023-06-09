package classes.System;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    /*
     * Constructor Name : FileHandler()
     * Parameters : none
     * Description : Default Constructor
    */
    public FileHandler () {}

    /*
     * Method Name : writeOnFile()
     * Parameters : username, password 
     * Description : Method to store username and password in the specified files
    */
    public void writeOnFile (String username, String password) {
        // Implement a try catch to handle errors during the "File Writing" process
        try {
            // Create buffer writer to perform file writing
            // Specify the file with relative path
            BufferedWriter usernameWriter = new BufferedWriter(new FileWriter("UsernameData.txt"));
            BufferedWriter passwordWriter = new BufferedWriter(new FileWriter("PasswordData.txt"));
            // Store user's username and password
            // Then, close the buffer to store the written data
            usernameWriter.write(username);
            usernameWriter.close();
            passwordWriter.write(password);
            passwordWriter.close();
            System.out.println("[INFO] Session has been added.");
        } catch (IOException e) {
            // throw an I/O exception - if any
            e.printStackTrace();
        }
    }

    /*
     * Method Name : writeOnFile()
     * Parameters : updatedData 
     * Description : Method to store single updated data in the specified files
    */
    public void writeOnFile (String updatedData) {
        // Define a temporary string variable to specify the file name
        String filename = fileNameFinder(updatedData);
        // Implement a try catch to handle errors during the "File Writing" process
        try {
            // Create buffer writer to perform file writing
            // Specify the file with relative path
            BufferedWriter updatedDataWriter = new BufferedWriter(new FileWriter(filename + ".txt"));
            // Store user's updated value
            // Then, close the buffer to store the written data
            updatedDataWriter.write(updatedData);
            updatedDataWriter.close();
        } catch (IOException e) {
            // throw an I/O exception - if any
            e.printStackTrace();
        }
    }

    /*
     * Method Name : readFromFile()
     * Parameters : none
     * Description : Method to check the existance of entered data on specified file
    */
    public String readFromFile (String filename) {
        // Defin a temporary string varible to store extracted value
        String extractedData = "";
        // Implement a try catch to handle errors during the "File Reading" process
        try {
            // Create buffer reader to perform file reading
            // Specify the file with relative path
            BufferedReader usernameReader = new BufferedReader(new FileReader(filename + ".txt"));
            // Extract user's data
            // Then, close the buffer to store the extracted data
            extractedData = usernameReader.readLine();
            usernameReader.close();
        } catch (IOException e) {
            // throw an I/O exception - if any
            e.printStackTrace();
        }

        return extractedData;
    }

    /*
     * Method Name : fileNameFinder()
     * Parameters : none
     * Description : Method to check the existance of entered data on specified file
    */
    private String fileNameFinder(String fileContent) {
        String filename = "";
        if (fileContent.length() <= 20) {
            filename = "UsernameData";
        } else {
            filename = "PasswordData";
        }
        return filename;
    }
}
