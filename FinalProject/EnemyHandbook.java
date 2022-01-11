import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyHandbook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyHandbook extends World
{
    private int WIDTH = 1280;
    private int HEIGHT = 720;

    public EnemyHandbook()
    {
        super(1280, 720, 1, false);
        setPaintOrder(Slider.class, Button.class);
        addObject(new Slider(WIDTH/2, HEIGHT, (WIDTH/4) * -1, HEIGHT/2, 1.0, 1.1, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), WIDTH/4, HEIGHT/2);
        addObject(new Slider(WIDTH/2, HEIGHT, WIDTH*5/4, HEIGHT/2, 1.0, 1.1, new GreenfootImage("TransitionRight.png"), "Nothing", 0), WIDTH*3/4, HEIGHT/2);
        addObject(new Button("Exit", getHeight()/15, 700.0/300.0, "TitleScreen"), getWidth()/2, getHeight()*18/20);
    }
}
