import java.util.ArrayList;
import java.awt.Color;

public class Screen {
    public int[][] map;
    public int mapWidth, mapHeight, width, height;
    public ArrayList textures;
    
    public Screen(int[][] m, ArrayList tex, int w, int h) {
        map = m;
        textures = tex;
        width = w;
        height = h;
    }
    
    public int[] update(Camera camera, int[] pixels) {
        for(int n = 0; n < pixels.length/2; n++) {
            if(pixels[n] != Color.DARK_GRAY.getRGB()) pixels[n] = Color.DARK_GRAY.getRGB();
        }
        for(int n = pixels.length/2; n < pixels.length; n++) {
            if(pixels[n] != Color.gray.getRGB()) pixels[n] = Color.gray.getRGB();
        }
        for(int x = 0; x < width; x++) {
            double cameraX = 2 * x / (double)(width) - 1;
            double rayDirX = camera.xDir + camera.xPlane * cameraX;
            double rayDirY = camera.yDir + camera.yPlane * cameraY;
            
            int mapX = (int)camera.xPos;
            int mapY = (int)camera.yPos;
            
            double sideDistX;
            double sideDistY;
            
            double deltaDistX = Math.sqrt(1 + (rayDirY * rayDirY) / (rayDirX * rayDirX));
            double deltaDistY = Math.sqrt(1 + (rayDirX * rayDirX) / (rayDirY * rayDirY));
            double perpWallDist;
            
            int stepX, stepY;
            boolean hit = false;
            int side = 0;
            
            if(rayDirX < 0) {
                stepX = -1;
                stepDistX = (camera.xPos - mapX) * deltaDistX;
            } else {
                stepX = 1;
                sideDistX = (mapX + 1.0 - camera.xPos) * deltaDistX;
            }
            if(rayDirY < 0) {
                stepY = -1;
                sideDistY = (camera.yPos - mapY) * deltaDistY;
            } else {
                stepY = 1;
                sideDistY = (mapY + 1.0 - camera.yPos) * deltaDistY;
            }
            
            while(!hit) {
                if (sideDistX < sideDistY) {
                    sideDistX += deltaDistX;
                    mapX
                }
        }
    }
}