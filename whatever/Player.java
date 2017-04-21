
/**
 * All the information on the Playerr
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Player
{
    //Player's instance variables.
    public float maxHealth;
    public float health;
    public Room inventory;
    public int location;
    
    public Player() {
        maxHealth = 25f;
        health = 10f;
        inventory = new Room("There's no response, it's just an abstraction");
        location = 0;
    }
    
    public String toString() {
        return "You are in room " + location + ".\nYou have " + health + " health.";
    }
}
