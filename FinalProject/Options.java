import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends World
{
    private int WIDTH = 1280;
    private int HEIGHT = 720;

    public Options()
    {    
        super(1280, 720, 1, false);
        setPaintOrder(Slider.class, Button.class);
        Utils.SFX("open_door.mp3", Utils.OPEN_VOL);
        addObject(new Slider(WIDTH/2, HEIGHT, (WIDTH/4) * -1, HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), WIDTH/4, HEIGHT/2);
        addObject(new Slider(WIDTH/2, HEIGHT, WIDTH*5/4, HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionRight.png"), "Nothing", 0), WIDTH*3/4, HEIGHT/2);
        addObject(new Button("ToggleMusic", getHeight()/30, 2.8, "Music"), getWidth()/2 + 75, getHeight()*8/20);
        addObject(new Button("Music", getHeight()/13, 2.8, "Music"), getWidth()/2 - 50, getHeight()*8/20 - 3);
        addObject(new Button("ToggleSfx", getHeight()/30, 2.8, "Sfx"), getWidth()/2 + 75, getHeight()*10/20);
        addObject(new Button("Sfx", getHeight()/13, 2.8, "Sfx"), getWidth()/2 - 50, getHeight()*10/20 - 3);
        addObject(new Button("MainMenu", getHeight()/11, 6, "TitleScreen"), getWidth()/2, getHeight()*12/20);
        Button.notClickedBefore = true;
    }
}
