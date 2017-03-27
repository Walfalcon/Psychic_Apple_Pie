
/**
 * This is where all the things you can interact with will be
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objects
{
    private boolean canTake;
    private boolean canOpen;
    private boolean canEat;
    private boolean canWear;
    String look;
    String name;
    
    public Objects() {
        canTake = false;
        canOpen = false;
        canEat = false;
        canWear = false;
        look = "";
        name = "";
    }
    
    public Objects(boolean canTake, boolean canOpen, boolean canEat, boolean canWear, String look, String name) {
        this.canTake = canTake;
        this.canOpen = canOpen;
        this.canEat = canEat;
        this.canWear = canWear;
        this.look = look;
        this.name = name;
    }
    
    public Objects(String look, String name) {
        this(false, false, false, false, look, name);
    }
    
    public Objects(String name) {
        this("It's a " + name, name);
    }
    
    public boolean can(String thing) {
        switch (thing){
            case "take":
                return canTake;
            case "open":
                return canOpen;
            case "eat":
                return canEat;
            case "wear":
                return canWear;
            default:
                return false;
        }
    }
    
    public String toString() {
        return name;
    }
}
