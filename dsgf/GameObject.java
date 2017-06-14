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
<<<<<<< HEAD
        double dist = Math.sqrt((c.xPos - xPos)*(c.xPos - xPos) + (c.yPos - yPos)*(c.yPos - yPos));
        if(dist != 0) {
            double scale = Math.sqrt(dist);
            int drawHeight = (int)(sprite.getHeight()/scale);
            int drawWidth = (int)(sprite.getWidth()/scale);
            
            double relCameraAngleY = ((xPos - c.xPos)*c.xDir + (yPos - c.yPos)*c.yDir) / dist;
            if(relCameraAngleY <= 0) return;
            
            double relCameraAngleX = Math.sqrt(dist * dist - relCameraAngleY * relCameraAngleY);
            int screenPosX;
            
            int screenX = (int)
            if(0 <= Math.abs((drawWidth + Game.screenWidth)/2)) g.drawImage(sprite, 50, Game.screenHeight/2 - drawHeight/2, drawWidth, drawHeight, null);
        }
=======
        double xDist = xPos - c.xPos;
        double yDist = yPos - c.yPos;
        double dist = xDist * c.xDir + yDist * c.yDir;
        if(dist == 0) return;
        int xDirFromCam = (int)Math.signum(xDist);
        double tempY = yPos;
        double tempX = xPos;
        while(xDirFromCam == Math.signum(tempX - c.xPos)) {
            if(Game.map[(int)tempX][(int)tempY] != 0) return;
            tempX -= xDist/(dist*10);
            tempY -= yDist/(dist*10);
        }
        double scale = Math.abs(dist);
        int drawHeight = (int)(Game.screenHeight / scale);
        int drawWidth = (int)(drawHeight * sprite.getWidth() / sprite.getHeight());

        double crossProduct = xDist * c.xDir + yDist * c.yDir;
        if(crossProduct / dist <= 0) return;
        double relCameraAngleX = (xDist * c.yDir - yDist * c.xDir)/dist;
        
        if(0 <= Math.abs((drawWidth + Game.screenWidth)/2)) g.drawImage(sprite, (int)(relCameraAngleX * Game.screenWidth * 5/6 + Game.screenWidth/2 - drawWidth/2), Game.screenHeight/2 - drawHeight/2, drawWidth, drawHeight, null);
>>>>>>> origin/master
    }
}
