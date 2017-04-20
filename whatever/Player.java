
/**
 * All the information on the Playerr
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Player
{
    public float maxHealth;
    public float health;
    private Item[] inventory;
    public int location;
    
    public Player() {
        maxHealth = 25f;
        health = 10f;
        inventory = new Item[10];
        location = 0;
    }
    
    public String toString() {
        return "You are in room " + location + ".\nYou have " + health + " health.";
    }
    
    //Tries to add item to inventory, then returns if it succeeded.
    public boolean addItem(Item newItem) {
        for(int i = 0; i < inventory.length; i++) {
            if(inventory[i] == null) {
                inventory[i] = newItem;
                return true;
            }
        }
        return false;
    }
}
