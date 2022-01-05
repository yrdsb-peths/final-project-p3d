import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Temp2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends ScrollWorld
{
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;
    private int FULL_WIDTH;
    private int FULL_HEIGHT;
    
    private int wave = 10;
    
    public static boolean isPaused;
        
    public Game()
    {   
        super(1280, 720, 1, 2560, 2560);
        isPaused = false;
        SCREEN_WIDTH = 1280;
        SCREEN_HEIGHT = 720;
        FULL_WIDTH = 2560;
        FULL_HEIGHT = 2560;
        
        setPaintOrder(Slider.class, Button.class, Bullet.class);
        //setBackground(new GreenfootImage("GameBackground.png"));
        addObject(new Slider(SCREEN_WIDTH/2, SCREEN_HEIGHT, (SCREEN_WIDTH/4) * -1, SCREEN_HEIGHT/2, 0.1, 1.5, new GreenfootImage("b.png"), "Nothing", 0), SCREEN_WIDTH/4, SCREEN_HEIGHT/2);
        addObject(new Slider(SCREEN_WIDTH/2, SCREEN_HEIGHT, SCREEN_WIDTH*5/4, SCREEN_HEIGHT/2, 0.1, 1.5, new GreenfootImage("c.png"), "Nothing", 0), SCREEN_WIDTH*3/4, SCREEN_HEIGHT/2);
        addObject(new Player(new GreenfootImage("e.png")), 1280, 720);
        
    }
    
    //if get objct enemy.class .size() == 0, spawn new wave with 1 more enemy
    // After every few waves (1-5?), pick an upgrade?
    public void act(){
        if(getObjects(Enemy.class).size() == 0){
            for(int i = 0; i < wave; i++){
                int camXOrigin = (int) (getCameraX() - (SCREEN_WIDTH/2.0));
                int camYOrigin = (int) (getCameraY() - (SCREEN_HEIGHT/2.0));
                int randX = (int) ((Math.random() * (FULL_WIDTH-SCREEN_WIDTH)) + (SCREEN_WIDTH/2.0));
                int randY = (int) ((Math.random() * (FULL_HEIGHT-SCREEN_HEIGHT)) + (SCREEN_HEIGHT/2.0));
                // randX and randY are their global positions
                // 1000, 1000 is its global position!!!
                addObject(new Enemy(1, 1), randX, randY);
            }
            wave++;
        }
    }
}
