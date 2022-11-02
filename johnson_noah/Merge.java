package johnson_noah;

/*
 * Author: Noah Johnson
 * Description: Java OOP Project, Merge class
 */

public class Merge implements Visitor {

    private char mergeSymbol;


    /* Description: constructor for new merge, sets the mergeSymbol to the symbol passed in
     * Parameter: symbol - the symbol we want to merge nebulas to
     * Return: none */
    Merge(char symbol) {
        mergeSymbol = symbol;
    }


    /* Description: accepts a black hole, doesn't merge into mergeSymbol
     * Parameter: b - the black hole that was visited
     * Return: none */
    @Override
    public void acceptBlackHole(BlackHole b) {

    }


    /* Description: accepts an empty Spot, doesn't merge into mergeSymbol
     * Parameter: e - the visited Empty spot
     * Return: none */
    @Override
    public void acceptEmpty(Empty e) {

    }


    /* Description: accepts a nebula, merges into mergeSymbol
     * Parameter: n - the nebula to merge into mergeSymbol
     * Return: none */
    @Override
    public void acceptNebula(Nebula n) {
        n.setSymbol(mergeSymbol);
    }


    /* Description: accepts a star, doesn't merge into mergeSymbol
     * Parameter: e - the visited star
     * Return: none */
    @Override
    public void acceptStar(Star s) {

    }


    /* Description: accepts a planet, doesn't merge into mergeSymbol
     * Parameter: p - the planet that was visited
     * Return: none */
    @Override
    public void acceptPlanet(Planet p) {

    }
}
