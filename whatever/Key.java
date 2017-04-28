
/**
 * A key is an object that you carry with you that triggers another object when you use them together.
 */
public class Key extends Item
{
    public Key(String look, String name)
    {
        super(look, name);
    }
    
    public void use(Player player, Item otherItem)
    {
        otherItem.doAction(player, "use", this);
    }
}
