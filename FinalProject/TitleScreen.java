import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class Temp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private int WIDTH = 1280;
    private int HEIGHT = 720;
    private GreenfootSound bg = new GreenfootSound("MenuBackgroundMusic.mp3");
    
    public TitleScreen(){
        super(1280, 720, 1, false);
        bg.playLoop();
        bg.pause();
        bg.setVolume(40);
        setPaintOrder(Slider.class, Button.class);
        addObject(new Slider(WIDTH/2, HEIGHT, (WIDTH/4) * -1, HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), WIDTH/4, HEIGHT/2);
        addObject(new Slider(WIDTH/2, HEIGHT, WIDTH*5/4, HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionRight.png"), "Nothing", 0), WIDTH*3/4, HEIGHT/2);
        setBackground(new GreenfootImage("MenuBackground-1.png"));
        double buttonHeight = getHeight()/15;
        //Button playButton = new Button(new GreenfootImage("e.png"), getHeight()/8, 4);
        addObject(new Button("Play", buttonHeight, 700.0/300.0, "Game"), getWidth()/2, getHeight()*10/20);
        addObject(new Button("Leaderboards", buttonHeight, 1350.0/300.0, "Leaderboards"), getWidth()/2, getHeight()*12/20);
        //addObject(new Button("EnemyHandbook", buttonHeight, 1600.0/300.0, "Enemy Handbook"), getWidth()/2, getHeight()*14/20);
        addObject(new Button("Options", buttonHeight, 900.0/300.0, "Options"), getWidth()/2, getHeight()*14/20);
        addObject(new Button("Exit", buttonHeight, 700.0/300.0, "Exit"), getWidth()/2, getHeight()*16/20);
        //addObject(new Button(new GreenfootImage("e.png"), getHeight()/8, 4), getWidth()/2, getHeight()/4); 
        //addObject(new Bullet(1280, 720, 5, new GreenfootImage("e.png")), 0, 0);
    }
    
    public void act(){
        
    }
    
    public void stopped()
    {
        bg.pause();
    }
     
    public void started()
    {
        bg.playLoop();
    }
}
