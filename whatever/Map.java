
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
                          "There are three doors leading from the room, a left door, a right door, and a center door. There's also the big ol' door you entered the mansion through, but what's the point in leaving now?");
        map[0].addItem(new Key("It's a breaded, deep fried drumstick. How do they bread those things anyways? Is it actually just rolling it in bread crumbs, or is there some sort of extra process? And what kind of bread do you use?\n" +
                               "I just have so many questions about frying. Where do you buy that much oil? Like, do you have to get it wholesale, or can you just go to Costco? Actually, maybe Costco is wholesale? I don't know.", "drumstick"));
        map[0].getItem("drumstick").setEat("Why would you eat a drumstick? It's like, laminated wood, or something. Maybe acryllic. Not very edible, either way.");
        map[0].addItem(new Key("It's a bottle of Super Duper Super Glue, almost empty. Super duper.", "glue"));
        map[0].addItem(new Container("It's a pretty boring looking desk, the kind that's shaped in a big arc with a few chairs at it. There aren't any chairs, but if there were there would be multiple. It's that kind of desk.\n", "desk",
                                     "The only drawer on the desk with anything in it besides dust has", new String[]{"glue", "drumstick"}, new String[]{"some Super Duper Super Glue", "a fried drumstick. Why though"}));
        map[0].addItem(new Door(1, "It's a pretty normal wooden door, kinda boring.", "left door"));
        map[0].addItem(new Door(2, "It's a boring wooden door. It looks pretty much exactly the same as the other two doors.", "right door"));
        map[0].addItem(new Item("It's a cow", "cow"));
    }
}
