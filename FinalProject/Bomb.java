import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends AttackPatterns
{
    private int delay = 100;
    
    private int x;
    private int y;
    
    private int projCount;
    
    public Bomb(int x, int y, int projCount){
        this.projCount = projCount;
        this.x = x;
        this.y = y;
        GreenfootImage img = new GreenfootImage("Bomb.png");
        img.scale(40,56);
        setImage(img);
    }

    public void act(){
        setGlobalLocation(x, y);
        if(Game.isPaused){
            return;
        }
        if(Game.hasEnded){
            getWorld().removeObject(this);
        }
        if(delay > 0){
            delay--;
            return;
        }else{
            double actualX = getGlobalX();
            double actualY = getGlobalY();
            for(int i = 0; i < projCount; i++){
                getWorld().addObject(new NormalBullet(actualX, actualY, 20, 20, Math.random() * 500.0 + (actualX - 250.0), Math.random() * 500.0 + (actualY - 250.0), 4 + Greenfoot.getRandomNumber(16-3), 0.96, 1.0, false, "bullet"), (int) actualX, (int) actualY);
            }
            getWorld().removeObject(this);
        }
    }
}
