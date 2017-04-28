
/**
 * Purely aesthetic. Use for boxes and stuff.
 */
public class Container extends Item
{
    //contents is an array of the items in the container
    private Item[] contents;
    //descriptions is an array of the descriptions of the items in the container.
    private String[] descriptions;
    
    public Container(String look, String name, Item[] stuff)
    {
        super(look, name);
        contents = stuff;
        descriptions = new String[contents.length];
    }
    
    public void addDescription(String name, String description)
    {
        for(int i = 0; i < contents.length; i++) {
            if(contents[i].getName().equals(name)) {
                descriptions[i] = description;
                break;
            }
        }
    }
    
    public void removeItem(String name)
    {
        for(int i = 0; i < contents.length; i++) {
            if(contents[i].getName().equals(name)) {
                descriptions[i] = null;
                contents[i] = null;
                break;
            }
        }
    }
    
    public String toString()
    {
        String out = super.toString();
        if(!isEmpty()) {
            
        }
        
        return out;
    }
    
    public boolean isEmpty()
    {
        for(Item thing: contents) {
            if(thing != null) {
                return false;
            }
        }
        return true;
    }
}
