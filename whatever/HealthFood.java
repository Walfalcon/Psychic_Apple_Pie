
/**
 * Write a description of class HealthFood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthFood extends Item{
    int healyPoints;
    public HealthFood(String look, String name, int heal) {
        super(look, name);
        healyPoints = heal;
    }
    
    public void Eat(Player player) {
        System.out.println("You eat the " + getName() + ".");
        
        int startHealth = (int)player.health;
        if(player.health >= player.maxHealth) {
            System.out.println("You already have full health!");
            return;
        }
        
        player.health += healyPoints;
        if(player.health > player.maxHealth) {
            player.health = player.maxHealth;
        }
        
        System.out.println("You gain " + ((int)player.health - startHealth) + "HP.");
        getRoom().takeItem(this);
    }
}
