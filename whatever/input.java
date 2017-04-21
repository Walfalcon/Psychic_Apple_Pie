/**
 * It's the input. That's what it is.
 */
import java.util.Scanner;

public class Input
{
    static Scanner key = new Scanner(System.in);
    
    //These are the different actions the player can perform
    private static String[][] actions = new String[][]{
        {"look", "search", "examine", "check", "observe", "read"},
        {"eat", "consume", "imbibe", "drink", "chug", "gobble", "devour"},
        {"open"},
        {"close"},
        {"wear", "put on", "enrobe"},
        {"use", "utilize", "operate", "move", "activate", "push", "pull", "press", "twist"},
        {"place", "set", "put", "remove", "drop"},
        {"go ", "move", "walk", "enter", "run", "saunter", "skip", "roll", "leave"},
        {"take", "get", "grab", "clasp", "obtain", "pick up"},
        {"unlock"}
    };
    
    //The input method that is called every time the player is prompted for an action
    public static void input(Map map, Player player) {
        System.out.println("\n");
        String rawIn = key.nextLine().toLowerCase();
        System.out.print("\n");
        
        String action = action(rawIn);
        Item object1 = object(rawIn, map, player);
        
        if(object1 != null) {
            rawIn.replaceFirst(rawIn, object1.getName());
            Item object2 = object(rawIn, map, player);
            if(object2 == null) {
                object1.use(player, action);
            } else {
                object1.use(player, action, object2);
            }
        } else if (action.equals("look")){
            System.out.println(map.map[player.location]);
        } else {
            System.out.println("There doesn't appear to be an object with that name.\n" +
            "This is an extremely pedantic game, did you type everything exactly right?");
        }
    }
    
   //gets the action to be performed from the string.
    public static String action(String rawIn) {
        for(String[] action: actions) {
            if(checkArr(action, rawIn)) return action[0];
        }
        return "";
    }
    
    //gets the object to perform an action with
    public static Item object(String rawIn, Map map, Player player) {
        String objName;
        
        for(int i = 0; i < player.inventory.stuff.size(); i++) {
            objName = player.inventory.stuff.get(i).getName().toLowerCase();
            if(checkStr(objName, rawIn)) {
                return player.inventory.stuff.get(i);
            }
        }
        
        for(int i = 0; i < map.map[player.location].stuff.size(); i++) {
            objName = map.map[player.location].getItem(i).getName().toLowerCase();
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
