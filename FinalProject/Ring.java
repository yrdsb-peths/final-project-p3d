import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ring here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ring extends AttackPatterns
{
    private int counter = 0;
    private int numOfRings;
    private int speed;
    public Ring(int numOfRings, int speed){
        this.numOfRings = numOfRings;
        this.speed = speed;
    }

    public void act()
    {
        if(Game.isPaused){
            return;
        }
        if(!getWorld().getObjects(Enemy.class).isEmpty()){
            if(counter >= speed){
                counter = 0;
                Enemy e = getWorld().getObjects(Enemy.class).get(0);
                double actualX = e.getGlobalX();
                double actualY = e.getGlobalY();
                int numOfProjectiles = 10 + Greenfoot.getRandomNumber(20-10);
                for(int i = 0; i < numOfProjectiles; i++) getWorld().addObject(new NormalBullet(actualX, actualY, 30, 30, Math.random() * 500.0 + (actualX - 250.0), Math.random() * 500.0 + (actualY - 250.0), 6, 1.0, 1.0, false, "bullet"), getGlobalX(), getGlobalY());
                numOfRings--;
            }
            counter++;
            if(numOfRings <= 0){
                getWorld().removeObject(this);
                return;
            }
        }
    }
}
