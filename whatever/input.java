
/**
 * It's the input. That's what it is.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class input
{
    static Scanner key = new Scanner(System.in);
    private static String[] look = new String[] {"look", "search", "examine", "check", "observe", "read"};
    private static String[] eat = new String[] {"eat", "consume", "imbibe", "drink", "chug", "gobble", "devour"};
    private static String[] open = new String[] {"open"};
    private static String[] close = new String[] {"close"};
    private static String[] wear = new String[] {"wear", "put on", "enrobe"};
    private static String[] use = new String[] {"use", "utilize", "operate", "move", "activate", "push", "pull", "press", "twist"};
    private static String[] place = new String[] {"place", "set", "put", "remove", "drop"};
    private static String[] go = new String[] {"go", "move", "walk", "enter", "run", "saunter", "skip", "roll", "leave"};
    
    
    public static String action(String rawIn) {
        
        if(check(look, rawIn)) {
            return "look";
        } else if(check(eat, rawIn)) {
            return "eat";
        } else if(check(open, rawIn)) {
            return "open";
        } else if(check(close, rawIn)) {
            return "close";
        } else if(check(wear, rawIn)) {
            return "wear";
        } else if(check(use, rawIn)) {
            return "use";
        } else if(check(place, rawIn)) {
            return "place";
        } else if(check(go, rawIn)) {
            return "go";
        } else {
            return null;
        }
    }
    
    public static boolean check(String[] toCheck, String input) {
        for(String term: toCheck) {
            if(input.indexOf(term) != -1) {
                return true;
            }
        }
        
        return false;
    }
}
