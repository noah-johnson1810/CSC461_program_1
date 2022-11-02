package johnson_noah;

/*
 * Author: Noah Johnson
 * Description: Java OOP Project, ColorVisit class
 */

public class ColorVisit implements Visitor {

    int areaType = 0;
    ColorText.Color newColor = ColorText.Color.MAGENTA;


    /* Description: constructor for the ColorVisit class, sets the areaType and switches colorSelection to the
     *              right color
     * Parameter: areaTypeSelection - which type of Spots to color
     *            colorSelection - which color to change the types to
     * Return: none */
    ColorVisit(int areaTypeSelection, int colorSelection) {
        areaType = areaTypeSelection;
        switch(colorSelection) {
            case 0 -> {
                newColor = ColorText.Color.RED;
            }
            case 1 -> {
                newColor = ColorText.Color.YELLOW;
            }
            case 2 -> {
                newColor = ColorText.Color.BLUE;
            }
            case 3 -> {
                newColor = ColorText.Color.GREEN;
            }
            case 4 -> {
                newColor = ColorText.Color.BLACK;
            }
        }

    }


    /* Description: accepts a black hole and sets the color
     * Parameter: e - the black hole to change the color of
     * Return: void */
    @Override
    public void acceptBlackHole(BlackHole b) {
        if(areaType == 2) {
            b.setColor(newColor);
        }
    }


    /* Description: accepts an Empty spot and sets the color
     * Parameter: e - the Empty spot to change the color of
     * Return: void */
    @Override
    public void acceptEmpty(Empty e) {
        if(areaType == 0) {
            e.setColor(newColor);
        }
    }


    /* Description: accepts a nebula and sets the color
     * Parameter: n - the nebula to change the color of
     * Return: void */
    @Override
    public void acceptNebula(Nebula n) {
        if(areaType == 1) {
            n.setColor(newColor);
        }
    }


    /* Description: accepts a planet and sets the color
     * Parameter: p - the planet to change the color of
     * Return: void */
    @Override
    public void acceptPlanet(Planet p) {
        if(areaType == 1) {
            p.setColor(newColor);
        }
    }


    /* Description: accepts a star and sets the color
     * Parameter: s - the star to change the color of
     * Return: void */
    @Override
    public void acceptStar(Star s) {
        if(areaType == 1) {
            s.setColor(newColor);
        }
    }
}
