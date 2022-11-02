package johnson_noah;

/*
 * Author: Noah Johnson
 * Description: Java OOP Project, IsPullable class
 */

public class IsPullable implements Visitor {
    private boolean isPullable;

    /* Description: constructor for IsPullable, initializes the boolean value isPullable to false
     * Parameter: none
     * Return: none */
    IsPullable() {
        isPullable = false;
    }


    /* Description: sets isPullable to false after visiting a black hole
     * Parameter: b - the black hole that was visited
     * Return: void */
    @Override
    public void acceptBlackHole(BlackHole b) {
        isPullable = false;
    }


    /* Description: sets isPullable to false after visiting an Empty spot
     * Parameter: e - the empty space that was visited
     * Return: void */
    @Override
    public void acceptEmpty(Empty e) {
        isPullable = false;
    }


    /* Description: sets isPullable to true after visiting a nebula
     * Parameter: s - the nebula that was visited
     * Return: void */
    @Override
    public void acceptNebula(Nebula n) {
        isPullable = true;
    }


    /* Description: sets isPullable to true after visiting a planet
     * Parameter: p - the planet that was visited
     * Return: void */
    @Override
    public void acceptPlanet(Planet p) {
        isPullable = true;
    }


    /* Description: sets isPullable to true after visiting a star
     * Parameter: s - the star that was visited
     * Return: void */
    @Override
    public void acceptStar(Star s) {
        isPullable = true;
    }


    /* Description: gets the value of the private boolean member isPullable
     * Parameter: none
     * Return: isPullable - boolean to tell if the last visited object is pullable or not */
    boolean getValue() {
        return isPullable;
    }
}
