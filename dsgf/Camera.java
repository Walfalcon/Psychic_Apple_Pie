import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Camera implements KeyListener {    
    public double xPos, yPos, xDir, yDir, xPlane, yPlane;
    public boolean tLeft, tRight, forward, back, sLeft, sRight;
    public final double MOVE_SPEED = .05;   //speed of a moving player
    public final double ROTATION_SPEED = .03;  //speed of a turning player
    public final double WALL_DISTANCE = 0.05;  //minimum distance between player and wall
    
    public Camera(double x, double y, double xd, double yd, double xp, double yp)
    {
        xPos = x;
        yPos = y;
        xDir = xd;
        yDir = yd;
        xPlane = xp;
        yPlane = yp;
    }
    
    public void keyTyped(KeyEvent key){}
    
    public void keyPressed(KeyEvent key) {
        if(key.getKeyCode() == KeyEvent.VK_LEFT || key.getKeyCode() == KeyEvent.VK_4) tLeft = true;
        if(key.getKeyCode() == KeyEvent.VK_RIGHT || key.getKeyCode() == KeyEvent.VK_6) tRight = true;
        if(key.getKeyCode() == KeyEvent.VK_UP || key.getKeyCode() == KeyEvent.VK_8) forward = true;
        if(key.getKeyCode() == KeyEvent.VK_DOWN || key.getKeyCode() == KeyEvent.VK_2) back = true;
        if(key.getKeyCode() == KeyEvent.VK_7) sLeft = true;
        if(key.getKeyCode() == KeyEvent.VK_9) sRight = true;
    }
    
    public void keyReleased(KeyEvent key) {
        if(key.getKeyCode() == KeyEvent.VK_LEFT || key.getKeyCode() == KeyEvent.VK_4) tLeft = false;
        if(key.getKeyCode() == KeyEvent.VK_RIGHT || key.getKeyCode() == KeyEvent.VK_6) tRight = false;
        if(key.getKeyCode() == KeyEvent.VK_UP || key.getKeyCode() == KeyEvent.VK_8) forward = false;
        if(key.getKeyCode() == KeyEvent.VK_DOWN || key.getKeyCode() == KeyEvent.VK_2) back = false;
        if(key.getKeyCode() == KeyEvent.VK_7) sLeft = false;
        if(key.getKeyCode() == KeyEvent.VK_9) sRight = false;
    }
    
    public void update(int[][] map) {
        if(forward) {
            if((int)(xPos + xDir * MOVE_SPEED + WALL_DISTANCE * (xDir / Math.abs(xDir))) > 0 && map[(int)(xPos + xDir * MOVE_SPEED + WALL_DISTANCE * (xDir / Math.abs(xDir)))][(int)yPos] == 0) {
                xPos += xDir*MOVE_SPEED;
            }
            if((int)(yPos + yDir * MOVE_SPEED + WALL_DISTANCE * (yDir / Math.abs(yDir))) > 0 && map[(int)xPos][(int)(yPos + yDir * MOVE_SPEED + WALL_DISTANCE * (yDir / Math.abs(yDir)))] == 0) {
                yPos += yDir * MOVE_SPEED;
            }
        }
        if(back) {
            if((int)(xPos - xDir * MOVE_SPEED - WALL_DISTANCE * (xDir / Math.abs(xDir))) > 0 && map[(int)(xPos - xDir * MOVE_SPEED - WALL_DISTANCE * (xDir / Math.abs(xDir)))][(int)yPos] == 0) {
                xPos -= xDir*MOVE_SPEED;
            }
            if((int)(yPos - yDir * MOVE_SPEED - WALL_DISTANCE * (yDir / Math.abs(yDir))) > 0 && map[(int)xPos][(int)(yPos - yDir * MOVE_SPEED - WALL_DISTANCE * (yDir / Math.abs(yDir)))] == 0) {
                yPos -= yDir * MOVE_SPEED;
            }
        }
        
        if(sLeft) {
            if((int)(xPos - yDir * MOVE_SPEED - WALL_DISTANCE * (yDir / Math.abs(yDir))) > 0 && map[(int)(xPos - yDir * MOVE_SPEED - WALL_DISTANCE * (yDir / Math.abs(yDir)))][(int)yPos] == 0) {
                xPos -= yDir*MOVE_SPEED;
            }
            if((int)(yPos - xDir * MOVE_SPEED - WALL_DISTANCE * (xDir / Math.abs(xDir))) > 0 && map[(int)xPos][(int)(yPos - xDir * MOVE_SPEED - WALL_DISTANCE * (xDir / Math.abs(xDir)))] == 0) {
                yPos += xDir*MOVE_SPEED;
            }
        }
        if(sRight) {
            if((int)(xPos + yDir * MOVE_SPEED + WALL_DISTANCE * (yDir / Math.abs(xDir))) > 0 && map[(int)(xPos - xDir * MOVE_SPEED - WALL_DISTANCE * (xDir / Math.abs(xDir)))][(int)yPos] == 0) {
                xPos += yDir*MOVE_SPEED;
            }
            if((int)(yPos - yDir * MOVE_SPEED - WALL_DISTANCE * (yDir / Math.abs(yDir))) > 0 && map[(int)xPos][(int)(yPos - yDir * MOVE_SPEED - WALL_DISTANCE * (yDir / Math.abs(yDir)))] == 0) {
                yPos -= xDir * MOVE_SPEED;
            }
        }
        
        if(tRight) {
            double oldxDir = xDir;
            xDir = xDir * Math.cos(-ROTATION_SPEED) - yDir * Math.sin(-ROTATION_SPEED);
            yDir = oldxDir * Math.sin(-ROTATION_SPEED) + yDir * Math.cos(-ROTATION_SPEED);
            double oldxPlane = xPlane;
            xPlane = xPlane * Math.cos(-ROTATION_SPEED) - yPlane * Math.sin(-ROTATION_SPEED);
            yPlane = oldxPlane * Math.sin(-ROTATION_SPEED) + yPlane * Math.cos(-ROTATION_SPEED);
        }
        if(tLeft) {
            double oldxDir = xDir;
            xDir = xDir * Math.cos(ROTATION_SPEED) - yDir * Math.sin(ROTATION_SPEED);
            yDir = oldxDir * Math.sin(ROTATION_SPEED) + yDir * Math.cos(ROTATION_SPEED);
            double oldxPlane = xPlane;
            xPlane = xPlane * Math.cos(ROTATION_SPEED) - yPlane * Math.sin(ROTATION_SPEED);
            yPlane = oldxPlane * Math.sin(ROTATION_SPEED) + yPlane * Math.cos(ROTATION_SPEED);
        }
    }
}
