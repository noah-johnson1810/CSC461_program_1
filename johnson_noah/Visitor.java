package johnson_noah;

/* Author: Noah Johnson
 * Description: Java OOP Project, Visitor interface
 */

public interface Visitor {

    // called by an Empty spot passing itself in
    void acceptEmpty(Empty e);

    // called by a Star passing itself in
    void acceptStar(Star s);

    // called by a Nebula passing itself in
    void acceptNebula(Nebula n);

    // called by a Black Hole passing itself in
    void acceptBlackHole(BlackHole b);

    // called by a Planet passing itself in
    void acceptPlanet(Planet p);
}
