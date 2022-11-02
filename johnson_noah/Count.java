package johnson_noah;

/*
 * Author: Noah Johnson
 * Description: Java OOP Project, Count class
 */

import java.util.HashMap;

public class Count implements Visitor {


    private HashMap<String, Integer> count = new HashMap<String, Integer>();


    /* Description: constructor for Count class, initializes the count hashmap to all 0's
     * Parameter: none
     * Return: none */
    Count() {
        count.put("Empty", 0);
        count.put("Planet", 0);
        count.put("Star", 0);
        count.put("Nebula", 0);
        count.put("Blackhole", 0);
    }


    /* Description: accepts a black hole and increments the counter for that type
     * Parameter: b - the black hole to signify an increment in the counter
     * Return: void */
    public void acceptBlackHole(BlackHole b) {
        int currentValue = 0;
        if(count.get("Blackhole") != null){
            currentValue = count.get("Blackhole");
        }
        count.put("Blackhole", currentValue + 1);
    }



    /* Description: accepts an Empty spot and increments the counter for that type
     * Parameter: e - the Empty spot to signify an increment in the counter
     * Return: void */
    public void acceptEmpty(Empty e) {
        int currentValue = 0;
        if(count.get("Empty") != null){
            currentValue = count.get("Empty");
        }
        count.put("Empty", currentValue + 1);
    }



    /* Description: accepts a nebula and increments the counter for that type
     * Parameter: n - the nebula to signify an increment in the counter
     * Return: void */
    public void acceptNebula(Nebula n) {
        int currentValue = 0;
        if(count.get("Nebula") != null){
            currentValue = count.get("Nebula");
        }
        count.put("Nebula", currentValue + 1);
    }




    /* Description: accepts a planet and increments the counter for that type
     * Parameter: p - the planet to signify an increment in the counter
     * Return: void */
    public void acceptPlanet(Planet p) {
        int currentValue = 0;
        if(count.get("Planet") != null){
            currentValue = count.get("Planet");
        }
        count.put("Planet", currentValue + 1);
    }


    /* Description: accepts a star and increments the counter for that type
     * Parameter: s - the star to signify an increment in the counter
     * Return: void */
    public void acceptStar(Star s) {
        int currentValue = 0;
        if(count.get("Star") != null){
            currentValue = count.get("Star");
        }
        count.put("Star", currentValue + 1);
    }


    /* Description: gets the value of count
     * Parameter: none
     * Return: the value of count */
    public HashMap<String, Integer> getCount() {
        return count;
    }

}