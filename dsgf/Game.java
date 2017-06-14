import java.awt.Color;
import java.awt.Graphics;
import javafx.embed.swing.JFXPanel;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import javax.swing.JFrame;
import javafx.scene.media.Media;
import java.io.File;
import javafx.util.Duration;
import javafx.scene.media.MediaPlayer;

public class Game extends JFrame implements Runnable{   
    private static final long serialVersionUID = 1L;
    public int mapWidth = 15;
    public int mapHeight = 15;
    public static int screenWidth = 640;//640
    public static int screenHeight = 480;//480
    private Thread thread;
    private boolean running;
    private BufferedImage image;
    public int[] pixels;
    private MediaPlayer audio;
    public Camera camera;
    public Screen screen;
    public ArrayList<Texture> textures;
    public GameObject[] rawr;
    public static int[][] map = 
        {
            {1,1,1,1,1,1,1,1,2,2,2,2,2,2,2},
            {1,0,0,0,0,0,0,0,2,0,0,0,0,0,2},
            {1,0,3,3,3,3,3,0,0,0,0,0,0,0,2},
            {1,0,3,0,0,0,3,0,2,0,0,0,0,0,2},
            {1,0,3,0,0,0,3,0,2,2,2,0,2,2,2},
            {1,0,3,0,0,0,3,0,2,0,0,0,0,0,2},
            {1,0,3,3,0,3,3,0,2,0,0,0,0,0,2},
            {1,0,0,0,0,0,0,0,2,0,0,0,0,0,2},
            {1,1,1,1,1,1,1,1,4,4,4,0,4,4,4},
            {1,0,0,0,0,0,1,4,0,0,0,0,0,0,4},
            {1,0,0,0,0,0,1,4,0,0,0,0,0,0,4},
            {1,0,0,2,0,0,1,4,0,3,3,3,3,0,4},
            {1,0,0,0,0,0,1,4,0,3,3,3,3,0,4},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,4},
            {1,1,1,1,1,1,1,4,4,4,4,4,4,4,4}
        };

public Game() {
        thread = new Thread(this);
        rawr = new GameObject[]{new GameObject(5, 6.01, "res/rawr.png")};
        image = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        setSize(screenWidth, screenHeight);
        setResizable(true);
        setTitle("3D Engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLocationRelativeTo(null);
        setVisible(true);
        camera = new Camera(4.5, 4.5, 1, 0, 0, -.66);
        addKeyListener(camera);
        textures = new ArrayList<Texture>();
        textures.add(Texture.wood);
        textures.add(Texture.brick);
        textures.add(Texture.bluestone);
        textures.add(Texture.stone);
        screen = new Screen(map, textures, screenWidth, screenHeight);
        final JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        audio = new MediaPlayer(new Media(new File("res/audio.mp3").toURI().toString()));
        audio.setOnEndOfMedia(new Runnable() {
            public void run() {
                audio.seek(Duration.ZERO);
              }
            });
        start();
    }

private synchronized void start() {
    running = true;
    audio.play();
    thread.start();
}
public synchronized void stop() {
    running = false;
    try {
        thread.join();
    } catch(InterruptedException e) {
        e.printStackTrace();
    }
}

public void render() {
    BufferStrategy bs = getBufferStrategy();
    if(bs == null) {
        createBufferStrategy(3);
        return;
    }
    Graphics g = bs.getDrawGraphics();
    g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    bs.show();
}

public void run() {
    long lastTime = System.nanoTime();
    final double ns = 1000000000.0 / 60.0;//60 times per second
    double delta = 0;
    requestFocus();
    while(running) {
        long now = System.nanoTime();
        delta = delta + ((now-lastTime) / ns);
        lastTime = now;
        while (delta >= 1)//Make sure update is only happening 60 times a second
        {
            //handles all of the logic restricted time
            camera.update(map);
            screen.update(camera, pixels, rawr, this);
            delta--;
        }
        render();//displays to the screen unrestricted time
    }
}

public static void main(String [] args) {
    Game game = new Game();
}

}