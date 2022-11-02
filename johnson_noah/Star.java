package johnson_noah;

/* Author: Noah Johnson
 * Description: Java OOP Project, Star class
 */

public class Star extends Spot{

    private char symbol = '★';
    private ColorText.Color color = ColorText.Color.BLACK;


    /* Description: constructor for the Star class, sets the color, row, and column
     * Parameter: color - the color for this Star
     *            row - the row for this Star
     *            col - the column for this Star
     * Return: none */
    Star(ColorText.Color color, int row, int col) {
        this.row = row;
        this.col = col;
        this.color = color;
    }


    /* Description: accepts a visitor into the Star, then calls acceptStar on the visitor, passing itself in
     * Parameter: v - the visitor that is visiting this Star
     * Return: void */
    public void acceptVisitor(Visitor v) {
        v.acceptStar(this);
    }


    /* Description: gets the color of this Star
     * Parameter: none
     * Return: the color of this Star */
    public ColorText.Color getColor() {
        return color;
    }


    /* Description: gets the symbol of this Star
     * Parameter: none
     * Return: the symbol of this Star */
    public char getSymbol() {
        return symbol;
    }


    /* Description: sets the color of this Star
     * Parameter: newColor - the color for this Star
     * Return: void */
    public void setColor(ColorText.Color newColor) {
        color = newColor;
    }


    /* Description: sets the symbol of this Star
     * Parameter: newSymbol - the symbol for this Star
     * Return: void */
    @Override
    void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }


    /* Description: helper function used when changing types, determines if the symbol matches the star symbol
     * Parameter: none
     * Return: true if the symbol is the star symbol, false otherwise */
    @Override
    boolean typeMatchesSymbol() {
        return (symbol == '★');
    }
}

