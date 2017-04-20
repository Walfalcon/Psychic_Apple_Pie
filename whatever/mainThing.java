
/**
 * I guess this is like, the base thing for this thing. Like, the main bit
 * of code, where everything starts and stuff. Or something.
 * 
 * @author Lucas
 * @version 3/24/2017
 */

public class MainThing
{

    public static void main(String[] args) {
        Player player = new Player();
        Map dungeon = new Map();
        System.out.println("Welcome to a mystical adventure of magical wonder! Or something. Whatever.");
        while(player.location != 8) {
            Input.input(dungeon, player);
        }
        
    }
    
    public static int RandomNum(int num1, int num2) {
        return (int)(Math.random() * (num2 - num1)) + num1;
    }
}