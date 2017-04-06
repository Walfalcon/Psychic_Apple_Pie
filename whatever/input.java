
/**
 * It's the input. That's what it is.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Input
{
    static Scanner key = new Scanner(System.in);
    private static String[] look = new String[] {"look", "search", "examine", "check", "observe", "read"};
    private static String[] eat = new String[] {"eat", "consume", "imbibe", "drink", "chug", "gobble", "devour"};
    private static String[] open = new String[] {"open"};
    private static String[] close = new String[] {"close"};
    private static String[] wear = new String[] {"wear", "put on", "enrobe"};
    private static String[] use = new String[] {"use", "utilize", "operate", "move", "activate", "push", "pull", "press", "twist"};
    private static String[] place = new String[] {"place", "set", "put", "remove", "drop"};
    private static String[] go = new String[] {"go ", "move", "walk", "enter", "run", "saunter", "skip", "roll", "leave"};
    private static String[] take = new String[] {"take", "get", "grab", "clasp", "obtain", "pick up"};
    
    public static void input(Map map, Player player) {
        String rawIn = key.nextLine();
        
        String action = action(rawIn);
        Item object = object(rawIn, map, player);
        
        if(object != null) {
            object.use(player, action);
        } else if (action.equals("look")){
            System.out.println(map.map[player.location]);
        } else {
            System.out.println("There doesn't appear to be an object with that name.\n" +
            "This is an extremely pedantic game, did you type everything exactly right?");
        }
    }
    
   //gets the action to be performed from the string.
    public static String action(String rawIn) {
        
        if(checkArr(look, rawIn)) {
            return "look";
        } else if(checkArr(eat, rawIn)) {
            return "eat";
        } else if(checkArr(open, rawIn)) {
            return "open";
        } else if(checkArr(close, rawIn)) {
            return "close";
        } else if(checkArr(wear, rawIn)) {
            return "wear";
        } else if(checkArr(use, rawIn)) {
            return "use";
        } else if(checkArr(place, rawIn)) {
            return "place";
        } else if(checkArr(go, rawIn)) {
            return "go";
        } else if(checkArr(take, rawIn)) {
            return "take";
        } else {
            return "";
        }
    }
    
    //gets the object to perform an action on
    public static Item object(String rawIn, Map map, Player player) {
        String objName;
        for(int i = 0; i < map.map[player.location].stuff.size(); i++) {
            objName = map.map[player.location].getItem(i).getName();
            if(checkStr(objName, rawIn)) {
                return map.map[player.location].getItem(i);
            }
        }
        
        return null;
    }
    
    //checks whether an input is in an array, for use when converting raw input into readable syntax
    public static boolean checkArr(String[] toCheck, String input) {
        for(String term: toCheck) {
            if(input.indexOf(term) != -1) {
                return true;
            }
        }
        
        return false;
    }
    
    //checks if an item is in a string, for use when finding the items referred to in the input
    public static boolean checkStr(String toCheck, String input) {
        if(input.indexOf(toCheck) != -1) {
            return true;
        }
        return false;
    }
}
