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
        double scale = Math.sqrt(dist);
        int drawHeight = (int)(sprite.getHeight()/scale);
        int drawWidth = (int)(sprite.getWidth()/scale);
        
        
        if(scale != 0 && 0 <= Math.abs((drawWidth + Game.screenWidth)/2)) g.drawImage(sprite, 50, Game.screenHeight/2 - drawHeight/2, drawWidth, drawHeight, null);
    }
}
