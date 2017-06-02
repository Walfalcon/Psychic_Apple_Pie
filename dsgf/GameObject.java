import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameObject
{
    public double xPos, yPos;
    public BufferedImage sprite;
    
    public GameObject(double xPos, double yPos, String spriteLoc) {
        this.xPos = xPos;
        this.yPos = yPos;
        try{
            sprite = ImageIO.read(new File(spriteLoc));
        } catch (IOException e) {
            System.out.println("hwoops");
        }
    }
    
    public void render(Graphics g, Camera c) {
        double dist = Math.sqrt((c.xPos - xPos)*(c.xPos - xPos) + (c.yPos - yPos)*(c.yPos - yPos));
        if(dist != 0) g.drawImage(sprite, 50, 50, (int)(sprite.getWidth()/dist), (int)(sprite.getHeight()/dist), null);
    }
}
