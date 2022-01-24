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
    public TitleScreen(){
        super(1280, 720, 1, false);
        setPaintOrder(Slider.class, Button.class);
        Utils.SFX("open_door.mp3", Utils.OPEN_VOL);
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, (Utils.SCREEN_WIDTH/4) * -1, Utils.SCREEN_HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), Utils.SCREEN_WIDTH/4, Utils.SCREEN_HEIGHT/2);
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, Utils.SCREEN_WIDTH*5/4, Utils.SCREEN_HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionRight.png"), "Nothing", 0), Utils.SCREEN_WIDTH*3/4, Utils.SCREEN_HEIGHT/2);
        setBackground(new GreenfootImage("MenuBackground.png"));
        double buttonHeight = getHeight()/15;
        addObject(new Button("Play", buttonHeight, 700.0/300.0, "DiffSelect"), getWidth()/2, getHeight()*21/40);
        addObject(new Button("Leaderboards", buttonHeight, 1350.0/300.0, "Leaderboards"), getWidth()/2, getHeight()*24/40);
        addObject(new Button("Instructions", buttonHeight, 1350.0/300.0, "Instructions"), getWidth()/2, getHeight()*27/40);
        addObject(new Button("Options", buttonHeight, 900.0/300.0, "Options"), getWidth()/2, getHeight()*30/40);
        addObject(new Button("ChangeUsername", buttonHeight, 1500.0/300.0, "ChangeUser"), getWidth()/2, getHeight()*33/40);
        addObject(new Button("Exit", buttonHeight, 700.0/300.0, "Exit"), getWidth()/2, getHeight()*36/40);
        Button.notClickedBefore = true;
    }
}
