import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SprayTarget extends AttackPatterns
{
    private int counter = 0;
    private int duration;
    private int speed;
    
    public SprayTarget(int duration, int speed){
        this.duration = duration;
        this.speed = speed;
    }

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
                getWorld().addObject(new NormalBullet(actualX, actualY, 30, 30, tX + Greenfoot.getRandomNumber(300) - 150, tY + Greenfoot.getRandomNumber(300) - 150, 6, 1.0, 1.0, false, "bullet"), (int) actualX, (int) actualY);
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
