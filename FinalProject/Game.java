import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Temp2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends ScrollWorld
{
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static int FULL_WIDTH;
    public static int FULL_HEIGHT;
    
    public static double leftBoundary;
    public static double topBoundary;
    public static double rightBoundary;
    public static double bottomBoundary;
    
    private int wave = 1;
    
    public static int scoreAdder = 1;
    public static int score = 0;
    
    public static boolean hasWon;
    public static boolean isPaused;
    public static List<Actor> pauseScreen = new ArrayList<Actor>();
    public static List<Actor> winScreen = new ArrayList<Actor>();
    
    public Game()
    {   
        super(1280, 720, 1, 2560, 2000);
        hasWon = false;
        isPaused = false;
        SCREEN_WIDTH = 1280;
        SCREEN_HEIGHT = 720;
        FULL_WIDTH = 2560;
        FULL_HEIGHT = 2000;
        leftBoundary = SCREEN_WIDTH/2 + 10;
        rightBoundary = FULL_WIDTH-leftBoundary;
        topBoundary = SCREEN_HEIGHT/2 + 10;
        bottomBoundary = FULL_HEIGHT-topBoundary;
        
        setPaintOrder(Slider.class, Button.class, Text.class, OverlayBackground.class, Bullet.class, Particle.class, Player.class, Enemy.class, Background.class);
        addObject(new Background(new GreenfootImage("GameBackground.png")), FULL_WIDTH/2, FULL_HEIGHT/2);
        //setBackground(new GreenfootImage("GameBackground.png"));
        addObject(new Slider(SCREEN_WIDTH/2, SCREEN_HEIGHT, (SCREEN_WIDTH/4) * -1, SCREEN_HEIGHT/2, 0.1, 1.5, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), SCREEN_WIDTH/4, SCREEN_HEIGHT/2);
        addObject(new Slider(SCREEN_WIDTH/2, SCREEN_HEIGHT, SCREEN_WIDTH*5/4, SCREEN_HEIGHT/2, 0.1, 1.5, new GreenfootImage("TransitionRight.png"), "Nothing", 0), SCREEN_WIDTH*3/4, SCREEN_HEIGHT/2);
        addObject(new Player(new GreenfootImage("e.png")), 1280, 400);
        addObject(new Enemy(2, 1, 5), FULL_WIDTH/2, FULL_HEIGHT/2);
        
        pauseScreen.add(new OverlayBackground(new GreenfootImage("OptionsBackground.png"), 600, 0.81));
        pauseScreen.add(new Button("ToggleMusic", getHeight()/30, 2.8, "Music"));
        pauseScreen.add(new Button("Music", getHeight()/13, 2.8, "Music"));
        pauseScreen.add(new Button("ToggleSfx", getHeight()/30, 2.8, "Sfx"));
        pauseScreen.add(new Button("Sfx", getHeight()/13, 2.8, "Sfx"));
        pauseScreen.add(new Button("MainMenu", getHeight()/11, 5.5, "TitleScreen"));
        pauseScreen.add(new Button("ReturnToGame", getHeight()/11, 5.5, "Unpause"));
        
        winScreen.add(new OverlayBackground(new GreenfootImage("WinBackground.png"), 720, 1.777));
        winScreen.add(new Button("MainMenu", getHeight()/11, 5.5, "TitleScreen"));
    }
    
    //if get objct enemy.class .size() == 0, spawn new wave with 1 more enemy
    // After every few waves (1-5?), pick an upgrade?
    public void act(){
        if(Greenfoot.isKeyDown("Q")){
            if(!isPaused){
                addObject(pauseScreen.get(0), getWidth()/2, getHeight()/2);
                addObject(pauseScreen.get(1), getWidth()/2 + 75, getHeight()*8/20);
                addObject(pauseScreen.get(2), getWidth()/2 - 50, getHeight()*8/20 - 3);
                addObject(pauseScreen.get(3), getWidth()/2 + 75, getHeight()*10/20);
                addObject(pauseScreen.get(4), getWidth()/2 - 50, getHeight()*10/20 - 3);
                addObject(pauseScreen.get(5), getWidth()/2, getHeight()*12/20);
                addObject(pauseScreen.get(6), getWidth()/2, getHeight()*14/20);
                Button.notClickedBefore = true;
                isPaused = true;
            }
        }
        if(hasWon){
            isPaused = true;
            winScreen.add(new Text("Score: " + score, Color.WHITE));
            addObject(winScreen.get(0), getWidth()/2, getHeight()/2);
            addObject(winScreen.get(2), getWidth()/2, getHeight()/2);
            addObject(winScreen.get(1), getWidth()/2, getHeight()*14/20);
            Button.notClickedBefore = true;
        }
        if(isPaused){
            ifPaused();
        }
    }
    private void ifPaused(){
        
    }
    
    
}
