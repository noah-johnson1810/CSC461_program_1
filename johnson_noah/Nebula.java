package johnson_noah;

/* Author: Noah Johnson
 * Description: Java OOP project, Nebula class
 */

public class Nebula extends Spot {

    private ColorText.Color color = ColorText.Color.BLACK;
    private char symbol = '⛆';


    /* Description: constructor for Nebula, initializes the row, column, and color to what's passed in
     * Parameter: color - the color for this nebula
     *            row - the row for this nebula
     *            col - the column for this nebula
     * Return: none */
    Nebula(ColorText.Color color, int row, int col) {
        this.row = row;
        this.col = col;
        this.color = color;
    }


    /* Description: accepts a visitor and calls acceptNebula in the visitor, passing itself in
     * Parameter: v - the visitor that is visiting this nebula
     * Return: void */
    public void acceptVisitor(Visitor v) {
        v.acceptNebula(this);
    }


    /* Description: gets the color of this nebula
     * Parameter: none
     * Return: the color of the nebula */
    public ColorText.Color getColor() {
        return color;
    }


    /* Description: gets the symbol of this nebula
     * Parameter: none
     * Return: the symbol of the nebula */
    public char getSymbol() {
        return symbol;
    }


    /* Description: sets the color of this nebula
     * Parameter: color - the color for this nebula
     * Return: void */
    public void setColor(ColorText.Color newColor) {
        color = newColor;
    }


    /* Description: sets the symbol of the nebula (only an intermediate step to change the type)
     * Parameter: newSymbol - the symbol to change to
     * Return: void */
    public void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }


    /* Description: helper function to change the type, determines if the symbol matches the nebula symbol
     * Parameter: none
     * Return: true if the symbol is the nebula symbol, false if otherwise */
    @Override
    boolean typeMatchesSymbol() {
        return (symbol == '⛆');
    }
}
