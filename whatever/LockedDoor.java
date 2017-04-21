/**
 * This is the class for locked doors.
 * Make a key pls
 * 
 */
public class LockedDoor extends Door
{
    boolean locked;
    Item key;
    
    public LockedDoor(int room, String look, String name, Item key)
    {
        super(room, look, name);
        this.key = key;
        locked = true;
    }
    
    public void use(Player player, Item key)
    {
        if(this.key == key) {
            System.out.println("You unlock the " + name + " with the " + key + ". Yay.");
            locked = false;
        } else {
            System.out.println("That's the wrong key for this door!");
        }
    }
}
