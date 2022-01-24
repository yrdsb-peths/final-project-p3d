import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instructions extends World
{
    public Instructions()
    {
        super(1280, 720, 1, false);
        setPaintOrder(Slider.class, Button.class);
        setBackground(new GreenfootImage("Instructions.png"));
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, (Utils.SCREEN_WIDTH/4) * -1, Utils.SCREEN_HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), Utils.SCREEN_WIDTH/4, Utils.SCREEN_HEIGHT/2);
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, Utils.SCREEN_WIDTH*5/4, Utils.SCREEN_HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionRight.png"), "Nothing", 0), Utils.SCREEN_WIDTH*3/4, Utils.SCREEN_HEIGHT/2);
        addObject(new Button("BackToMenu", getHeight()/15, 5, "TitleScreen"), 2*getWidth()/3-50, getHeight()*9/10);
        Button.notClickedBefore = true;
    }
}
