import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RingSpray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RingSpray extends AttackPatterns
{
    private int counter = 0;
    private int speed = 3;
    private int bulletsLeft = 60;
    private int angle = 0;
    public void act(){
        if(Game.isPaused){
            return;
        }
        if(!getWorld().getObjects(Enemy.class).isEmpty()){
            if(counter >= speed){
                counter = 0;
                Enemy e = getWorld().getObjects(Enemy.class).get(0);
                double actualX = e.getGlobalX();
                double actualY = e.getGlobalY();
                Player p = getWorld().getObjects(Player.class).get(0);
                int tX = (int) p.x;
                int tY = (int) p.y;
                double inRadians = angle * Math.PI / 180;
                getWorld().addObject(new NormalBullet(actualX, actualY, 30, 30, inRadians, 6, 1.0, 1.0, false, "bullet"), (int) actualX, (int) actualY);
                angle += 10;
                bulletsLeft--;
            }
            counter++; 
            if(bulletsLeft <= 0){
                getWorld().removeObject(this);
                return;
            }
        }
    }
}
