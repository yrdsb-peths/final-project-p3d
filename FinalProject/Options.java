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
        addObject(new Slider(WIDTH/2, HEIGHT, (WIDTH/4) * -1, HEIGHT/2, 1.0, 1.1, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), WIDTH/4, HEIGHT/2);
        addObject(new Slider(WIDTH/2, HEIGHT, WIDTH*5/4, HEIGHT/2, 1.0, 1.1, new GreenfootImage("TransitionRight.png"), "Nothing", 0), WIDTH*3/4, HEIGHT/2);
        addObject(new Button("MainMenu", getHeight()/15, 6, "TitleScreen"), getWidth()/2, getHeight()*16/20);
        addObject(new Button("Toggle", getHeight()/30, 2.8, "Music"), getWidth()/2 + 100, getHeight()*8/20);
        addObject(new Button("Music", getHeight()/30, 2.8, "Nothing"), getWidth()/2, getHeight()*8/20);
        addObject(new Button("Toggle", getHeight()/30, 2.8, "Sfx"), getWidth()/2, getHeight()*10/20);
        Button.notClickedBefore = true;
    }
}
