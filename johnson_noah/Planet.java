package johnson_noah;

/* Author: Noah Johnson
 * Description: Java OOP project, Nebula class
 */

public class Planet extends Spot {

    private ColorText.Color color = ColorText.Color.BLACK;
    private char symbol = '⦾';


    /* Description: constructor for the planet class. It sets the row, column, and color.
     * Parameter: color - the color for this planet
     *            row - the row for this planet
     *            col - the column for this planet
     * Return: none */
    Planet(ColorText.Color color, int row, int col) {
        this.row = row;
        this.col = col;
        this.color = color;
    }


    /* Description: accepts a visitor, then calls acceptPlanet in the visitor and passes itself in
     * Parameter: v the visitor that is visiting this planet
     * Return: void */
    public void acceptVisitor(Visitor v) {
        v.acceptPlanet(this);
    }


    /* Description: gets the color of this planet
     * Parameter: none
     * Return: the color of the planet */
    public ColorText.Color getColor() {
        return color;
    }


    /* Description: gets the symbol of this planet
     * Parameter: none
     * Return: the symbol for the planet */
    public char getSymbol() {
        return symbol;
    }


    /* Description: sets the color of this planet
     * Parameter: color - the color for this planet
     * Return: void */
    public void setColor(ColorText.Color newColor) {
        color = newColor;
    }


    /* Description: sets the symbol of this planet - only used as intermediate step to change spot type
     * Parameter: newSymbol - the symbol of the new type
     * Return: void */
    @Override
    void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }


    /* Description: helper function used when changing type, determines if the planet has the planet symbol
     * Parameter: none
     * Return: true if the planet has the planet symbol, false otherwise */
    @Override
    boolean typeMatchesSymbol() {
        return (symbol == '⦾');
    }
}
