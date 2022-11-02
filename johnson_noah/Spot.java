package johnson_noah;

/*
 * Author: Noah Johnson
 * Description: Java OOP Project, Spot abstract class
 */

public abstract class Spot {

    int row;
    int col;

    // acceps visitor into the Spot
    abstract void acceptVisitor(Visitor v);

    // getter for the color member
    abstract ColorText.Color getColor();

    // getter for symbol member
    abstract char getSymbol();

    // setter for the color member
    abstract void setColor(ColorText.Color newColor);

    // setter for symbol member
    abstract void setSymbol(char newSymbol);

    // helper function used when changing types, to determine if the symbol doesn't match the type (meaning it should
    // be changed)
    abstract boolean typeMatchesSymbol();
}
