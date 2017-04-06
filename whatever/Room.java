
/**
 * A room
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Room
{
    public ArrayList<Item> stuff = new ArrayList<Item>();
    private String description;
    private String extraDescription;
    
    //creates a new empty room
    public Room(String description) {
        this.description = description;
        extraDescription = "";
    }
    
    //adds an item to the room
    public void addItem(Item newItem) {
        stuff.add(newItem);
    }
    
    //removes an item from the room
    public boolean takeItem(Item take) {
        return stuff.remove(take);
    }
    
    //iterates over the items in the room to find a specific one
    public Item getItem(String get) {
        String objName;
        for(int i = 0; i < stuff.size(); i++) {
            objName = stuff.get(i).getName();
            if(objName.equals(get)) {
                return (Item)stuff.get(i);
            }
        }
        System.out.println("There doesn't appear to be an object with that name.\n" +
                           "This is an extremely pedantic game, did you type everything exactly right?");
        return null;
    }
    
    public Item getItem(int get) {
        return stuff.get(get);
    }
    
    public String toString() {
        extraDescription = "";
        for(Item item: stuff) {
            extraDescription += "There's a " + item.getName() + ".\n";
        }
        
        return description + extraDescription;
    }
}
