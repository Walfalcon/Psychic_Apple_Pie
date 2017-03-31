
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
        map[0] = new Room("You are in a large antechamber with cool stuff on the walls.\nOh man it's so freaking cool.\nYou spend a few minutes marvelling at how cool it is.\nSo cool.\n");
        map[1] = new Room("It's a really boring room, compared to the antechamber. Like, wow, this is boring.\nReally boring.\n");
        map[2] = new Room("There's nothing. There are four walls, a ceiling and a floor. It's like a room in Wolfenstein 3D.\n");
        map[3] = new Room("OH MY GOD TECHNO DANCE PARTYYYYYYY!!!!! WOOOO0000000OOO00O0OO!!!!!!!!!\n");
        map[0].addItem(new Door(8, false, "There's no response. It's just a door.\n", "boring wood door"));
    }
    
    public String toString() {
        return "It's a map.";
    }
}
