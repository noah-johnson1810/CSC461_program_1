package johnson_noah;

/*
 * Author: Noah Johnson
 * Description: Java OOP Project, Grid class
 */

import java.util.ArrayList;

public class Grid {

    /* Author: Noah Johnson
     * Description: Java OOP Project, Grid class
     */

    private ArrayList<Spot> spaceGrid = new ArrayList<>();
    private final int COL_SIZE = 7;


    /* Description: Grid constructor with no parameters, sets grid size to 35 and initializes to empty Spots
     * Parameter: none
     * Return: none */
    Grid() {
        int GRID_SIZE = 35;
        for (int i = 0; i < GRID_SIZE; i++) {
            Spot newEmptySpot = new Empty(ColorText.Color.BLACK, i / COL_SIZE, i % COL_SIZE);
            spaceGrid.add((newEmptySpot));
        }
    }


    /* Description: accepts a visitor into the grid, and iterates over every spot in the grid accepting the visitor
     * Parameter: v - the visitor to pass into the grid
     * Return: void */
    public void acceptVisitor(Visitor v) {
        int GRID_SIZE = 35;
        // iterate through each Spot and pass in the visitor
        for(int i = 0; i < GRID_SIZE; i++) {
            spaceGrid.get(i).acceptVisitor(v);
        }
    }


    /* Description: prints out the grid to the console, putting a new line after the column has finished printing
     * Parameter:
     * Return:  */
    public void displayGrid() {
        print("\n");

        // print each Spot, putting a new line at the end of each column
        for (Spot s : spaceGrid) {
            print(ColorText.colorString(s.getSymbol(), s.getColor()));
            if (s.col == COL_SIZE - 1) {
                print("\n");
            }
        }
        print("\n");
    }


    /* Description: getter for the grid, used in the black hole gravity functionality
     * Parameter: none
     * Return: spaceGrid - the ArrayList of spots */
    ArrayList<Spot> getSpaceGrid() {
        return spaceGrid;
    }


    /* Description: helper function to make syntax a bit more readable, prints the text passed in
     * Parameter: text - the text to print
     * Return: void */
    public void print(String text) {
        System.out.print(text);
    }


    /* Description: refreshes the types in the grid, checking to see if any symbols don't match their types. If it finds
                    any, it replaces it with the correct type.
     * Parameter: none
     * Return: void */
    public void refreshTypes() {

        // initialize new lists for storing values to put in outside the for loop
        ArrayList<Integer> rowToReplace = new ArrayList<Integer>();
        ArrayList<Integer> colToReplace = new ArrayList<Integer>();
        ArrayList<Character> typeToReplace = new ArrayList<Character>();

        // fill the arrays inside the for loop
        for (Spot s : spaceGrid) {
            // if the type doesn't match the symbol, we need to change the type
            if (!s.typeMatchesSymbol()) {
                rowToReplace.add(s.row);
                colToReplace.add(s.col);
                typeToReplace.add(s.getSymbol());
            }
        }

        // actually do the mutating outside the for loop to avoid concurrent modification exception
        for (int i : rowToReplace) {
            int index = rowToReplace.indexOf(i);
            this.replaceSpot(rowToReplace.get(index), colToReplace.get(index), typeToReplace.get(index));
        }

    }


    /* Description: replaces one spot in the grid with a new spot based on the parameters
     * Parameter: row - the row to place the new spot
     *            col - the column to place the new spot
     *            symbol - what type to place the new spot
     * Return: void */
    public void replaceSpot(int row, int col, char symbol) {
        replaceSpot(row, col, symbol, ColorText.Color.BLACK);
    }


    public void replaceSpot(int row, int col, char symbol, ColorText.Color color) {

        // remove the old spot
        spaceGrid.remove(row * COL_SIZE + col);

        // put in the new one based on the passed in symbol
        switch (symbol) {
            case '⯄' -> {
                spaceGrid.add((row * COL_SIZE + col), new BlackHole(color, row, col));
            }
            case '▩' -> {
                spaceGrid.add((row * COL_SIZE + col), new Empty(color, row, col));
            }
            case '⛆' -> {
                spaceGrid.add((row * COL_SIZE + col), new Nebula(color, row, col));
            }
            case '⦾' -> {
                spaceGrid.add((row * COL_SIZE + col), new Planet(color, row, col));
            }
            case '★' -> {
                spaceGrid.add((row * COL_SIZE + col), new Star(color, row, col));
            }
        }
        refreshTypes();
    }


    /* Description: resets the grid to the default layout, specified in the Java OOP assignment document
     * Parameter: none
     * Return:  void */
    public void resetToDefault() {

        // set row 0
        this.replaceSpot(0, 0, '★');
        this.replaceSpot(0, 1, '▩');
        this.replaceSpot(0, 2, '⛆');
        this.replaceSpot(0, 3, '⦾');
        this.replaceSpot(0, 4, '▩');
        this.replaceSpot(0, 5, '▩');
        this.replaceSpot(0, 6, '▩');

        // set row 1
        this.replaceSpot(1, 0, '▩');
        this.replaceSpot(1, 1, '⛆');
        this.replaceSpot(1, 2, '★');
        this.replaceSpot(1, 3, '⦾');
        this.replaceSpot(1, 4, '★');
        this.replaceSpot(1, 5, '▩');
        this.replaceSpot(1, 6, '★');

        // set row 2
        this.replaceSpot(2, 0, '⦾');
        this.replaceSpot(2, 1, '▩');
        this.replaceSpot(2, 2, '⯄');
        this.replaceSpot(2, 3, '★');
        this.replaceSpot(2, 4, '⦾');
        this.replaceSpot(2, 5, '▩');
        this.replaceSpot(2, 6, '⯄');

        // set row 3
        this.replaceSpot(3, 0, '⦾');
        this.replaceSpot(3, 1, '★');
        this.replaceSpot(3, 2, '⛆');
        this.replaceSpot(3, 3, '★');
        this.replaceSpot(3, 4, '⛆');
        this.replaceSpot(3, 5, '▩');
        this.replaceSpot(3, 6, '⯄');

        // set row 4
        this.replaceSpot(4, 0, '⯄');
        this.replaceSpot(4, 1, '★');
        this.replaceSpot(4, 2, '⛆');
        this.replaceSpot(4, 3, '▩');
        this.replaceSpot(4, 4, '★');
        this.replaceSpot(4, 5, '▩');
        this.replaceSpot(4, 6, '▩');
    }


    /* Description: sets the grid to a new ArrayList of spots
     * Parameter: newGrid - the new ArrayList to set
     * Return: void */
    void setSpaceGrid(ArrayList<Spot> newGrid) {
        spaceGrid = newGrid;
    }
}