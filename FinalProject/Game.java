import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;

/**
 * Write a description of class Temp2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends ScrollWorld
{


    public static double leftBoundary;
    public static double topBoundary;
    public static double rightBoundary;
    public static double bottomBoundary;

    private int wave = 1;

    public static int scoreAdder = 1;
    public static int score;

    public static boolean hasEnded;
    public static boolean won;
    public static boolean lost;
    public static boolean isPaused;
    public static Image healthImage;
    public static List<Actor> pauseScreen = new ArrayList<Actor>();

    public Game()
    {   
        super(1280, 720, 1, 2560, 2000);
        this.hasEnded = false;
        this.won = false;
        this.lost = false;
        this.isPaused = false;
        leftBoundary = Utils.SCREEN_WIDTH/2 + 10;
        rightBoundary = Utils.FULL_WIDTH-leftBoundary;
        topBoundary = Utils.SCREEN_HEIGHT/2 + 10;
        bottomBoundary = Utils.FULL_HEIGHT-topBoundary;
        score = 0;
        
        Utils.pauseMusic();
        Utils.setMusic("GameBackgroundMusic.mp3");
        Utils.playMusic();
        
        setPaintOrder(Slider.class, Button.class, Image.class, OverlayBackground.class, Bullet.class, Particle.class, Player.class, Enemy.class, Background.class);
        addObject(new Background(new GreenfootImage("GameBackground.png")), Utils.FULL_WIDTH/2, Utils.FULL_HEIGHT/2);
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, (Utils.SCREEN_WIDTH/4) * -1, Utils.SCREEN_HEIGHT/2, 0.1, 1.05, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), Utils.SCREEN_WIDTH/4, Utils.SCREEN_HEIGHT/2);
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, Utils.SCREEN_WIDTH*5/4, Utils.SCREEN_HEIGHT/2, 0.1, 1.05, new GreenfootImage("TransitionRight.png"), "Nothing", 0), Utils.SCREEN_WIDTH*3/4, Utils.SCREEN_HEIGHT/2);
        addObject(new Player(new GreenfootImage("e.png")), 1280, 400);
        addObject(new Enemy(50, 1, 5), Utils.FULL_WIDTH/2, Utils.FULL_HEIGHT/2);
        
        Player p = getObjects(Player.class).get(0);
        healthImage = new Image("Hearts-" + p.health + ".png", 40, 2.3);
        addObject(healthImage, 100, 50);
        
        pauseScreen.add(new OverlayBackground(new GreenfootImage("OptionsBackground.png"), 600, 0.81));
        pauseScreen.add(new Button("ToggleMusic", getHeight()/30, 2.8, "Music"));
        pauseScreen.add(new Button("Music", getHeight()/13, 2.8, "Music"));
        pauseScreen.add(new Button("ToggleSfx", getHeight()/30, 2.8, "Sfx"));
        pauseScreen.add(new Button("Sfx", getHeight()/13, 2.8, "Sfx"));
        pauseScreen.add(new Button("MainMenu", getHeight()/11, 5.5, "TitleScreen"));
        pauseScreen.add(new Button("ReturnToGame", getHeight()/11, 5.5, "Unpause"));
    }

    //if get objct enemy.class .size() == 0, spawn new wave with 1 more enemy
    // After every few waves (1-5?), pick an upgrade?
    public void act(){
        
        if(hasEnded && !isPaused){
            isPaused = true;
            if(won) addObject(new OverlayBackground(new GreenfootImage("WinBackground.png"), 720, 1.777), getWidth()/2, getHeight()/2);
            else addObject(new OverlayBackground(new GreenfootImage("LoseBackground.png"), 720, 1.777), getWidth()/2, getHeight()/2);
            addObject(new Image("Score: " + score, Color.WHITE), getWidth()/2, getHeight()/2);
            addObject(new Button("MainMenu", getHeight()/11, 5.5, "TitleScreen"), getWidth()/2, getHeight()*14/20);
            //storeScore();
            Button.notClickedBefore = true;
        }else if(Greenfoot.isKeyDown("Q") && !isPaused){
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
    
    public void storeScore(){
        try{
            BufferedWriter printWriter = new BufferedWriter(new FileWriter("scores.txt", true));
            printWriter.write(Login.user.getText() + "~" + score);
            printWriter.newLine();
            printWriter.close();
        }catch(IOException e){

        }
    }

}
