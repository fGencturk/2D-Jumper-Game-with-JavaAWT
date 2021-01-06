package demogame;
import demogame.enemy.*;
import demogame.enemyspawner.DefaultEnemySpawner;
import gameengine.*;
import gameengine.renderer.CircleRenderer2D;
import gameengine.renderer.RectangleRenderer2D;
import gameengine.renderer.Renderer2D;
import unityengine.MonoBehavior;
import unityengine.PerformanceLogger;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameManager extends JFrame
{

    public static ArrayList<GameObject> gameObjects, spawnedGameObjects, removedGameObjects;
    public final static int WIDTH = 720;
    public final static int HEIGHT = 480;
    public final static int HEADER_HEIGHT = 20;
    public final static int FRAMEPERSECOND = 30;
    public GameManager()
    {
        super("Custom 2D Game Engine Demo");
        gameObjects = new ArrayList<GameObject>();
        spawnedGameObjects = new ArrayList<GameObject>();
        removedGameObjects = new ArrayList<GameObject>();

        KeyboardInput keyboardInput = KeyboardInput.GetInstance();
        addKeyListener(keyboardInput);

        // Create player object
        Renderer2D playerRenderer = new RectangleRenderer2D(new Vector2(20, 100));
        playerRenderer.color = Color.green;
        GameObject player = new GameObject(new Vector2(100, HEIGHT / 2), playerRenderer );
        PlayerMovementBehavior playerMovementBehavior = new PlayerMovementBehavior();
        Behavior colorChanger = new ColorChangerBehavior();
        player.AddBehavior(playerMovementBehavior);
        player.AddBehavior(colorChanger);
        gameObjects.add(player);

        // Create PerformanceLogger Object with MonoBehaviorAdapter
        MonoBehavior logger = new PerformanceLogger();
        Behavior behavior = new MonoBehaviorAdapter(logger);
        GameObject loggerGameObject = new GameObject(new Vector2(0,0), null);
        loggerGameObject.AddBehavior(behavior);
        gameObjects.add(loggerGameObject);

        // Create Enemies
        Enemy.playerMovementBehavior = playerMovementBehavior;


        Behavior difficultyController = new DifficultyControllerBehavior();
        GameObject go = new GameObject(new Vector2(0, 0), null);
        go.AddBehavior(difficultyController);
        gameObjects.add(go);

        setSize( WIDTH, HEIGHT );
        Start();

        JOptionPane.showMessageDialog(this, "It is a simple demo for 2D GameEngine \nwith only rendering and custom behavior functionalities.\nUse W and S keys to move paddle.\nTo start the game press E for easy, H for hard mode.");
    }


    public void Start() {
        show();

        // Call Start functions of behaviors
        for (GameObject gameObject : gameObjects) {
            Iterator<Behavior> iterator = gameObject.CreateIterator();
            while(iterator.hasNext()) {
                Behavior b = iterator.next();
                b.Start();
            }
        }
        // Set timer
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        int period = (int) (1000 / FRAMEPERSECOND);
        executor.scheduleAtFixedRate(new UpdateRunnable(this), 0, period, TimeUnit.MILLISECONDS);
    }
    public void Update(){
        // Call Update functions of behaviors
        for (GameObject gameObject : gameObjects) {
            gameObject.Update();
        }
        for (GameObject gameObject: spawnedGameObjects) {
            gameObject.Start();
        }
        gameObjects.addAll(spawnedGameObjects);
        gameObjects.removeAll(removedGameObjects);
        spawnedGameObjects.clear();
        repaint();
        KeyboardInput.GetInstance().EndGameLoop();
    }

    public void paint( Graphics g )
    {
        super.paint(g);
        // create 2D by casting g to Graphics2D
        Graphics2D g2d = ( Graphics2D ) g;
        // Call Display functions of behaviors
        for (GameObject gameObject : gameObjects) {
            gameObject.Display(g2d);
        }
    }

    public static void main( String args[] )
    {
        GameManager app = new GameManager();

        app.addWindowListener( new WindowAdapter()
        {
            public void windowClosing( WindowEvent e )
            {
                System.exit( 0 );
            }
        });
    }
}
