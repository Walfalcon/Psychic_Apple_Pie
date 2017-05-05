
/**
 * A door that changes where it leads when you use an item on it
 */
public class TrickyDoor extends Door
{
    private Item key;
    
    public TrickyDoor(int room, String look, String name, Item key) {
        super(room, look, name);
        this.key = key;
    }
}
