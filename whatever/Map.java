
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
        map[0].addItem(new Item("It's a pretty boring looking desk, the kind that's shaped in a big arc with a few chairs at it. There aren't any chairs, but if there were there would be multiple. It's that kind of desk.\n" +
                                "The only drawer on the desk with anything in it besides dust has a fried drumstick and some Super Duper Super Glue. Why, though.", "desk"));
        map[0].addItem(new Key("It's a breaded, deep fried drumstick. How do they bread those things anyways? Is it actually just rolling it in bread crumbs, or is there some sort of extra process? And what kind of bread do you use?\n" +
                               "I just have so many questions about frying. Where do you buy that much oil? Like, do you have to get it wholesale, or can you just go to Costco? Actgually, maybe Costco is wholesale? I don't know.", "drumstick"));
        map[0].getItem("drumstick").setEat("Why would you eat a drumstick? It's like, laminated wood, or something. Maybe acryllic. Not very edible, either way.");
    }
}
