
/**
 * It's a FRIGGIN DOOR
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Item {
    //instance variables
    public int goToRoom;
    
    public Door(int room, String look, String name) {
        super(look, name);
        this.goToRoom = room;
    }
    
    public void Go(Player player) {
            player.location = goToRoom;
            if(go != null) {
                System.out.println(go);
            } else {
                System.out.println("You go through the door");
            }
    }
}
