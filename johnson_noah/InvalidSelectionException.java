package johnson_noah;

/*
 * Author: Noah Johnson
 * Description: Java OOP Project, Custom exception
 */

public class InvalidSelectionException extends Exception {
    // define exception with a custom error message
    public InvalidSelectionException(String errorMessage) {
        super(errorMessage);
    }
}
