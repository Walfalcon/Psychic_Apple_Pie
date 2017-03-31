
/**
 * It's a FRIGGIN DOOR
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Item {
    //instance variables
    public boolean isLocked;
    public int room;
    
    public Door(int room, boolean isLocked, String look, String name) {
        canOpen = true;
        this.isLocked = isLocked;
        this.room = room;
        this.look = look;
        this.name = name;
        canTake = false;
        canEat = false;
        canWear = false;
        canUse = true;
        canGo = true;
    }
    
    public void use(Player player) {
        player.location = room;
        System.out.println("You go through the door");
    }
    
    public String toString() {
        return look;
    }
}
