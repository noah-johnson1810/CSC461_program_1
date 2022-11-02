package johnson_noah;

/*
 * Author: Noah Johnson
 * Description: Java OOP Project, Empty class
 */

public class Empty extends Spot {


    private ColorText.Color color = ColorText.Color.BLACK;
    private char symbol = '▩';



    /* Description: constructor for Empty class, sets row, column, and color
     * Parameter: color - the color to set this empty spot to
     *            row - the row to place this spot in
     *            col - the column to place this spot in
     * Return: none */
    Empty(ColorText.Color color, int row, int col) {
        this.row = row;
        this.col = col;
        this.color = color;
    }


    /* Description: accepts a visitor and calls acceptEmpty in the visitor, passing itself in
     * Parameter: v - the visitor to call acceptEmpty in
     * Return: void */
    public void acceptVisitor(Visitor v) {
        v.acceptEmpty(this);
    }


    /* Description: gets the color of the Empty space
     * Parameter: none
     * Return: the color of the empty space */
    public ColorText.Color getColor() {
        return color;
    }


    /* Description: gets the symbol of the Empty space
     * Parameter: none
     * Return: the symbol of the empty space */
    public char getSymbol() {
        return symbol;
    }


    /* Description: sets the color of the Empty space
     * Parameter: newColor - the new color for the Empty space
     * Return: void */
    public void setColor(ColorText.Color newColor) {
        color = newColor;
    }


    /* Description: sets the symbol of the Empty space (only used as an intermediate step when changing this to a
     *              different type of spot)
     * Parameter: newSymbol - the new symbol for this space
     * Return: void */
    public void setSymbol(char newSymbol) { symbol = newSymbol; }


    /* Description: helper function to determine if the symbol is actually Empty
     * Parameter: none
     * Return: true if the symbol is the empty symbol */
    public boolean typeMatchesSymbol() {
        return(symbol == '▩');
    }
}
