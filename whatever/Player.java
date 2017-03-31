
/**
 * All the information on the Playerr
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Player
{
    
    public float health;
    private Item[] inventory;
    public int location;
    
    public Player() {
        health = 25.0f;
        inventory = new Item[10];
        location = 0;
    }
    
    public String toString() {
        return "You are in room " + location + ".\nYou have " + health + " health.";
    }
}
