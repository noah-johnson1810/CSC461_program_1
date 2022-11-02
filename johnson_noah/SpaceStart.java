package johnson_noah;

/*
 *  Author: Noah Johnson
 *  Class: CSC 461 - Fall 2022
 *  Description: Java OOP Project for Programming Languages (CSC 461) - Space System. This is a basic console-driven
 *  space simulator. It displays a 7 x 5 grid with each spot having one of five types of space objects: empty, planet,
 *  star, nebula, or black hole. The system allows the user to set a specific type of space at any coordinate in the
 *  grid, and does error checking to not crash on a bad input, and give appropriate error messages to the user. It can
 *  count the number of each type of space object. It also allows the user to change the color of pullable ojects, empty
 *  areas, or black holes. It can also change stars into nebulas, and perform a gravitational pull by the black holes in
 *  the grid it does all this with the visitor pattern.
 *  Last tier passed: 9
 *
 * Checklist:
 * Grading tags in for all lines marked with *       X
 *
 * The visitor pattern is used:                      X
 * Handles bad input with 1 try-catch:               X
 * Tier 1: running and menu working 			     X
 * Tier 2: set any object at 0, 0 			    	 X
 * Tier 3: handles bad input at this point		     X
 * Tier 4: set and unset at x, y				     X
 * Tier 5: default grid displays properly 		     X
 * Tier 6: count types * 					         X
 * Tier 7: coloring and menus completed*             X
 * Colors all object correctly *			         X
 * All input errors handled 	  			         X
 * Tier 8: merge *						             X
 *
 * Tier 9: Gravity*                                  X
 *
 * Any adjacent object removed	  		             X
 * All adjacent pullable objects removed		     X
 * At least one pullable objects are pulled inwards	 X
 * All pullable objects are pulled inwards		     X
 * Colors still correct				                 X
 * Black holes and empty space ignored		         X
 * Uses a second visitor, not anything else*		 X
 *
 */

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SpaceStart {

    static Scanner cin;
    static final int COL_SIZE = 7;
    private static char[] symbols = {'▩', '⦾', '★', '⛆', '⯄'};


    /* Description: The main (entry) function for the space program. It displays the menu, initializes appropriate class
     * instances, error checks input, and calls the right functions.
     * Parameter: args - command line arguments to run this program.
     * Return: 0 - successful run */
    public static void main(String[] args) {

        System.out.println();

        // initialize grid and scanner, declare menu
        Grid grid = new Grid();
        cin = new Scanner(System.in);
        String menu = """
                1) Set Area
                2) Make Default Grid
                3) Count Types
                4) Set Type Color
                5) Merge Nebula into Star
                6) Blackhole Gravitational Pull
                0) Quit
                """;

        // get user input until the user selects "0" to exit the program
        int input = -1;
        while (input != 0) {

            // enter the one try/catch block for this program
            try {

                //display the grid
                grid.displayGrid();

                //display the menu and prompt for input
                System.out.println(menu);
                System.out.print("Choice:> ");

                //get user input
                input = cin.nextInt();
                while (input < 0 || input > COL_SIZE - 1) {
                    System.out.print("Unknown menu option");
                    grid.displayGrid();
                    System.out.println(menu);
                    System.out.print("Choice:> ");
                    input = cin.nextInt();
                }

                // use a switch statement to perform the correct menu operation
                switch (input) {

                    // change area type
                    case 1:

                        // prompt for and accept user input for type of change
                        System.out.print("Input area type 0) Empty 1) Planet 2) Star 3) Nebula 4) Black Hole:> ");
                        int symbolSelection = cin.nextInt();

                        //check for error
                        if (symbolSelection < 0 || symbolSelection > 4) {
                            throw new InvalidSelectionException("Invalid selection option");
                        }

                        //prompt for and accept user input for location of change
                        System.out.print("Input location (x y):> ");
                        int changeCol = cin.nextInt();
                        int changeRow = cin.nextInt();

                        //check for error
                        if (changeRow > 4 || changeCol > 6 || changeRow < 0 || changeCol < 0) {
                            throw new InvalidSelectionException("Location is out of range");
                        }

                        // replace the spot in the grid with the new spot type
                        grid.replaceSpot(changeRow, changeCol, symbols[symbolSelection]);
                        break;

                    // reset the grid to the default layout
                    case 2:
                        // call method to reset grid to default layout
                        grid.resetToDefault();
                        break;

                    // count types of objects in the grid
                    case 3:

                        // initialize new Count Visitor instance, pass to the grid
                        Count count = new Count();
                        // GRADING: COUNT
                        grid.acceptVisitor(count);

                        // display calculated count values
                        System.out.print("Empty: " + count.getCount().get("Empty") + "\n");
                        System.out.print("Planets: " + count.getCount().get("Planet") + "\n");
                        System.out.print("Stars: " + count.getCount().get("Star") + "\n");
                        System.out.print("Nebulas: " + count.getCount().get("Nebula") + "\n");
                        System.out.print("Black Holes: " + count.getCount().get("Blackhole") + "\n");
                        break;

                    // change color of type
                    case 4:

                        // prompt for and accept user input for type to color
                        System.out.print("Input area type 0) empty 1) pullable 2) black hole:> ");
                        int areaTypeSelection = cin.nextInt();

                        // error check
                        if (areaTypeSelection < 0 || areaTypeSelection > 2) {
                            throw new InvalidSelectionException("Invalid selection option");
                        }

                        // prompt for and accept user input for new color to change to
                        System.out.print("Input color 0) red 1) yellow 2) blue 3) green 4) black:> ");
                        int colorSelection = cin.nextInt();

                        // check for error
                        if (colorSelection < 0 || colorSelection > 4) {
                            throw new InvalidSelectionException("Invalid selection option");
                        }

                        // initialize new Color visitor instance, pass to the grid
                        ColorVisit colorVisitor = new ColorVisit(areaTypeSelection, colorSelection);
                        // GRADING: COLOR
                        grid.acceptVisitor(colorVisitor);

                        break;

                    // merge nebulas into stars
                    case 5:

                        //declare new merge instance with star type selected, pass to the grid
                        Merge merge = new Merge('★');
                        // GRADING: MERGE
                        grid.acceptVisitor(merge);

                        // refresh types
                        grid.refreshTypes();
                        grid.refreshTypes();

                        break;

                    // perform gravitational pull from black holes
                    case 6:
                        Gravity gravity = new Gravity(grid);
                        grid.acceptVisitor(gravity);
                        break;
                    // exit program
                    case 0:
                        break;

                }

            } catch (InvalidSelectionException ex) {
                System.out.print(ex.getMessage());
                cin.nextLine();
                input = -1;
            } catch (InputMismatchException ex) {
                System.out.print("Please input an integer");
                cin.nextLine();
                input = -1;
            } catch (Exception ex) {
                input = -1;
            }
        }

    }

}
