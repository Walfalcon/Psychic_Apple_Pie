/**
 * This is the class for locked doors.
 * 
 */
public class LockedDoor extends Door
{
    private boolean locked;
    private Item key;
    private String unlock, goLocked;
    
    /**
     * This is the constructor. It probably doesn't need another constructor.
     */
    public LockedDoor(int room, String look, String name, Item key)
    {
        super(room, look, name);
        this.key = key;
        locked = true;
    }
    
    /**
     * When you use a key on the door, it unlocks the door. Amazing.
     */
    public void use(Player player, Item key)
    {
        if(this.key == key) {
            System.out.println("You unlock the " + name + " with the " + key + ". Yay.");
            locked = false;
        } else {
            System.out.println("That's the wrong key for this door!");
        }
    }
    
    /**
     * Call this to make the player go through the door.
     */
    public void go(Player player)
    {
        if(locked) {
            if(goLocked != null) {
                System.out.println(goLocked);
            } else {
                System.out.println("It's locked.");
            }
        } else {
            super.go(player);
        }
    }
    
    /**
     * Call this to change what it says when you unlock the door.
     */
    public void setUnlock(String newUnlock)
    {
        unlock = newUnlock;
    }
    
    /**
     * Call this to change what it says when you try to enter the locked door
     */
    public void setGoLocked(String newGoLocked)
    {
        goLocked = newGoLocked;
    }
}
