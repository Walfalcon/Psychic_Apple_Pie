
/**
 * creates the map for
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map
{
    // instance variables - replace the example below with your own
    public Room[] map;
    
    public Map() {
        map = new Room[9];
        
        map[0] = new Room("You are in a rather large entryway. It's realy big. Wow. There's a reception desk looking thing in the center of the room, but otherwise there isn't much else.\n" +
                          "There are three doors leading from the room, a left door, a right door, and a center door. There's also the big ol' door you entered the building through, but what's the point in leaving now?");
        map[0].addItem(new Item("It's a pretty boring looking desk, the kind that's shaped in a big arc with a few chairs at it. There aren't any chairs, but if there were there would be multiple. It's that kind of desk.", "reception desk"));
    }
}
