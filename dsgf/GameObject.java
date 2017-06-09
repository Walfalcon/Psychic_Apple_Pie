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
        if(dist == 0) return;
        double scale = Math.sqrt(dist);
        int drawHeight = (int)(sprite.getHeight()/scale);
        int drawWidth = (int)(sprite.getWidth()/scale);

        double crossProduct = (xPos - c.xPos) * c.xDir + (yPos - c.yPos) * c.yDir;
        if(crossProduct / dist <= 0) return;
        double relCameraAngleX = ((xPos - c.xPos) * c.yDir - (yPos - c.yPos) * c.xDir)/dist;
        
        if(0 <= Math.abs((drawWidth + Game.screenWidth)/2)) g.drawImage(sprite, (int)(relCameraAngleX * Game.screenWidth + Game.screenWidth/2 - drawWidth/2), Game.screenHeight/2 - drawHeight/2, drawWidth, drawHeight, null);
    }
}
