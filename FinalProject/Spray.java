import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spray extends AttackPatterns
{
    private int counter = 0;
    private int duration;
    private int speed;
    public Spray(int duration, int speed){
        this.duration = duration;
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
                getWorld().addObject(new NormalBullet(actualX, actualY, 30, 30, Math.random() * 500.0 + (actualX - 250.0), Math.random() * 500.0 + (actualY - 250.0), 6, 1.0, 1.0, false, "bullet"), (int) actualX, (int) actualY);
            }
            counter++;
            duration--;
            if(duration <= 0){
                getWorld().removeObject(this);
                return;
            }
        }
    }
}
