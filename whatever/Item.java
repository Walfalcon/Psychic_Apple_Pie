
/**
 * This is where all the things you can interact with will be
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    public boolean canTake;
    public boolean canOpen;
    public boolean canEat;
    public boolean canWear;
    public boolean canUse;
    public boolean canGo;
    public String look;
    public String name;
    
    public Item() {
        canTake = false;
        canOpen = false;
        canEat = false;
        canWear = false;
        canUse = false;
        canGo = false;
        look = "";
        name = "";
    }
    
    public Item(boolean canTake, boolean canOpen, boolean canEat, boolean canWear, boolean canUse, String look, String name) {
        this.canTake = canTake;
        this.canOpen = canOpen;
        this.canEat = canEat;
        this.canWear = canWear;
        this.canUse = canUse;
        canGo = false;
        this.look = look;
        this.name = name;
    }
    
    public Item(String look, String name) {
        this(false, false, false, false, false, look, name);
    }
    
    public Item(String name) {
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
            case "use":
                return canUse;
            case "go":
                return canGo;
            default:
                return false;
        }
    }
    
    public String getLook() {
        return look;
    }
    
    public void use(Player player) {
        
    }
    
    public void setLook(String newLook) {
        look = newLook;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public String toString() {
        return name;
    }
}
