package johnson_noah;

/*
 * Author: Noah Johnson
 * Description: Java OOP Project, BlackHole class
 */

public class BlackHole extends Spot {

    private ColorText.Color color = ColorText.Color.BLACK;

    private char symbol = '⯄';


    /* Description: Constructor for BlackHole, takes in color, row, and column and sets these private variables.
     * Parameter: color - the color for the new black hole
     *            row - the row to set the new black hole
     *            col - the column to set the new black hole
     * Return: none */
    BlackHole(ColorText.Color color, int row, int col) {
        this.row = row;
        this.col = col;
        this.color = color;
    }


    /* Description: accepts a visitor for this black hole and passes itself in
     * Parameter: v - the visitor that is visiting this black hole
     * Return: void */
    public void acceptVisitor(Visitor v) {
        v.acceptBlackHole(this);
    }


    /* Description: getColor - returns the color of this black hole
     * Parameter: none
     * Return: the color of the black hole */
    public ColorText.Color getColor() {
        return color;
    }


    /* Description: gets the symbol of this black hole
     * Parameter: none
     * Return: the symbol of the black hole */
    public char getSymbol() {
        return symbol;
    }


    /* Description: sets the color for this black hole based on the color passed in
     * Parameter: newColor - the color to set the black hole to
     * Return: void */
    public void setColor(ColorText.Color newColor) {
        color = newColor;
    }


    /* Description: sets a new symbol for this black hole (only happens if it's being changed to a new type)
     * Parameter: newSymbol - the symbol to set
     * Return: void */
    public void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }


    /* Description: checks if the type matches the symbol for this black hole
     * Parameter: none
     * Return: true if the black hole's actual symbol is the black hole symbol, false if otherwise*/
    public boolean typeMatchesSymbol() {
        return (this.getSymbol() == '⯄');
    }
}
