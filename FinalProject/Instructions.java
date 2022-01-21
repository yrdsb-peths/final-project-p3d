import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{

    private Button exitInstButton = new Button("BackToMenu", getHeight()/15, 3.8, "BackToMenu");

    public Instructions()
    {    
        //display instructions and back to menu button 
        super(1280, 720, 1, false);
        addObject(new OverlayBackground(new GreenfootImage("Instructions.png"), 720, 1.78), getWidth()/2, getHeight()/2);
        addObject(exitInstButton, 2*getWidth()/3-50, getHeight()*9/10);
        Button.notClickedBefore = true;

    }
    
    public void act(){
        //exit to menu button functionality
    
        if (Greenfoot.mouseClicked(exitInstButton)){
            Greenfoot.setWorld(new TitleScreen());
        }
        
    }
}
