package johnson_noah;

/* Author: Noah Johnson
 * Description: Java OOP Project, Gravity class
 */

import java.util.ArrayList;

public class Gravity implements Visitor {
    private Grid grid;


    /* Description: constructor for the Gravity class
     * Parameter: originalGrid - the original grid when the visitor is created
     * Return: none */
    Gravity(Grid originalGrid) {
        grid = new Grid();
        grid.setSpaceGrid(originalGrid.getSpaceGrid());
    }


    /* Description: accepts black hole, to perform gravity operation on
     * Parameter: b - the black hole to perform the gravity operation on
     * Return: void */
    @Override
    public void acceptBlackHole(BlackHole b) {
        // create new isPullable visitor
        IsPullable isPullable = new IsPullable();
        ArrayList<Integer> rowFrom = new ArrayList<Integer>();
        ArrayList<Integer> colFrom = new ArrayList<Integer>();
        ArrayList<Integer> rowTo = new ArrayList<Integer>();
        ArrayList<Integer> colTo = new ArrayList<Integer>();
        ArrayList<Character> replaceSymbol = new ArrayList<Character>();
        ArrayList<ColorText.Color> replaceColor = new ArrayList();

        // loop through each Spot of the space grid
        for (Spot s : grid.getSpaceGrid()) {
            // if the spot is adjacent to a black hole and pullable, replace it with empty spot
            if (Math.abs(s.row - b.row) <= 1 && Math.abs(s.col - b.col) <= 1) {
                s.acceptVisitor(isPullable);
                if (isPullable.getValue())
                    s.setSymbol('▩');
            }
        }
        grid.refreshTypes();
        // loop through each Spot of the space grid again
        for (Spot s : grid.getSpaceGrid()) {
            // GRADING: NESTED
                s.acceptVisitor(isPullable);

            // if it is a pullable object within a pullable range, replace it with empty space and move its location
            if (isPullable.getValue()) {
                int oldRow = s.row;
                int oldCol = s.col;
                int newRow = -1;
                int newCol = -1;

                // two rows below
                if (s.row == b.row + 2) {
                    newRow = s.row - 1;
                    // two rows below and two columns ahead
                    if (s.col == b.col + 2)
                        newCol = s.col - 1;
                        //two rows below and two columns behind
                    else if (s.col == b.col - 2)
                        newCol = s.col + 1;
                        // two rows below and on the same column
                    else if (s.col == b.col) {
                        newCol = s.col;
                    }
                }

                // on the same row
                else if (s.row == b.row) {
                    newRow = s.row;
                    // on the same row and two columns ahead
                    if (s.col == b.col + 2)
                        newCol = s.col - 1;
                        // on the same row and two columns behind
                    else if (s.col == b.col - 2)
                        newCol = s.col + 1;
                }

                // two rows above
                else if (s.row == b.row - 2) {
                    newRow = s.row + 1;
                    // two rows above and two columns ahead
                    if (s.col == b.col + 2)
                        newCol = s.col - 1;
                        // two rows above and two columns behind
                    else if (s.col == b.col - 2)
                        newCol = s.col + 1;
                        // two rows above and on the same column
                    else if (s.col == b.col) {
                        newCol = s.col;
                    }
                }
                // prepare to do the replacements if newRow and newCol have both been set
                if (newRow != -1 && newCol != -1) {
                    rowFrom.add(oldRow);
                    colFrom.add(oldCol);
                    rowTo.add(newRow);
                    colTo.add(newCol);
                    replaceSymbol.add(s.getSymbol());
                    replaceColor.add(s.getColor());
                }
            }
        }
        // do the replacements outside the for loop
        for (int i = 0; i < rowTo.size(); i++) {
            grid.replaceSpot(rowFrom.get(i), colFrom.get(i), '▩');
            grid.replaceSpot(rowTo.get(i), colTo.get(i), replaceSymbol.get(i), replaceColor.get(i));
        }
    }


    /* Description: accepts empty space, doesn't perform gravity operation from it
     * Parameter: e - the empty space that was visited
     * Return: void */
    @Override
    public void acceptEmpty(Empty e) {

    }


    /* Description: accepts nebula, doesn't perform gravity operation from it
     * Parameter: n - the nebula that was visited
     * Return: void */
    @Override
    public void acceptNebula(Nebula n) {

    }


    /* Description: accepts planet, doesn't perform gravity operation from it
     * Parameter: p - the planet that was visited
     * Return: void */
    @Override
    public void acceptPlanet(Planet p) {

    }


    /* Description: accepts star, doesn't perform gravity operation from it
     * Parameter: s - the star that was visited
     * Return: void */
    @Override
    public void acceptStar(Star s) {

    }
}
