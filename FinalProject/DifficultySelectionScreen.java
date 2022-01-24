import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DifficultySelectionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifficultySelectionScreen extends World
{
    public DifficultySelectionScreen(){
        super(1280, 720, 1, false);
        setPaintOrder(Slider.class, Button.class);
        Utils.SFX("open_door.mp3", Utils.OPEN_VOL);
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, (Utils.SCREEN_WIDTH/4) * -1, Utils.SCREEN_HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), Utils.SCREEN_WIDTH/4, Utils.SCREEN_HEIGHT/2);
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, Utils.SCREEN_WIDTH*5/4, Utils.SCREEN_HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionRight.png"), "Nothing", 0), Utils.SCREEN_WIDTH*3/4, Utils.SCREEN_HEIGHT/2);
        setBackground(new GreenfootImage("MenuBackground.png"));
        double buttonHeight = getHeight()/15;
        addObject(new Button("Skull", buttonHeight, 700.0/300.0, "Normal"), getWidth()/2, getHeight()/2);
        addObject(new Button("Skull2", buttonHeight, 1350.0/300.0, "Hard"), getWidth()/2, getHeight()/2);
        addObject(new Button("Skull3", buttonHeight, 1350.0/300.0, "Chaos"), getWidth()/2, getHeight()/2);
        addObject(new Button("BackToMenu", getHeight()/15, 5, "TitleScreen"), getWidth()/2, getHeight()*18/20);
        Button.notClickedBefore = true;
    }
}
