
/**
 * Purely aesthetic. Use for boxes and stuff.
 */
public class Container extends Item
{
    //contents is an array of the items in the container
    private String[] contents;
    //descriptions is an array of the descriptions of the items in the container.
    private String[] descriptions;
    //What to say to start describing the contents
    private String contentIntro;
    
    public Container(String look, String name, String intro, String[] stuff, String[] descriptions)
    {
        super(look, name);
        contents = stuff;
        this.descriptions = descriptions;
        contentIntro = intro;
        
        for(String thing: contents) {
            System.out.println(thing);
            Room room = this.getRoom();
            System.out.println(room);
            Item item = room.getItem(thing);
            item.setContainer(this);
        }
    }
    
    /**
     * remove an item from the container.
     * called when the item is taken from the room.
     */
    public void removeItem(String name)
    {
        for(int i = 0; i < contents.length; i++) {
            if(contents[i].equals(name)) {
                descriptions[i] = null;
                contents[i] = null;
                break;
            }
        }
    }
    
    public String toString()
    {
        String out = super.toString();
        if(numThings() != 0) {
            System.out.print("\n" + contentIntro + " ");
            System.out.print(descriptions[0]);
            if(numThings() > 1)  {
                for(int i = 1; i < contents.length - 1; i++) {
                    System.out.print(", " + descriptions[i]);
                }
                System.out.print(" and " + descriptions[contents.length - 1] + ".");
            }
        }
        
        return out;
    }
    
    /**
     * counts how many things are in the container
     */
    public int numThings()
    {
        int count = 0;
        for(String thing: contents) {
            if(thing != null) {
                count++;
            }
        }
        return count;
    }
}
