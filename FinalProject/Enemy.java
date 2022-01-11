import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends ScrollActor
{
    private double x;
    private double y;
    
    public double health;
    private double damage;
    
    private int firerate = 200;
    private int firerateRandomFactor = 200;
    private int bulletCount = 16;
    private int nextShot = (int) (Math.random()*firerate);
    
    public Enemy(double health, double damage){
        this.health = health;
        this.damage = damage;
        GreenfootImage image = new  GreenfootImage(100, 100);
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
        nextShot = (int) (Math.random()*firerate);
    }
    
    //Add to world
    public void addedToWorld(World world)
    {
        x = getX();
        y = getY();
        globalX = (int) x;
        globalY = (int) y;
    }
    
    public void act(){
        if(!Game.isPaused){
            if(health <= 0){
                removeSelf();
                return;
            }else if(nextShot <= 0){
                //double actualX = x - (getWorld().getCameraX() - (getWorld().getWidth()/2.0));
                //double actualY = y - (getWorld().getCameraY() - (getWorld().getHeight()/2.0));
                double actualX = getGlobalX();
                double actualY = getGlobalY();
                for(int i = 0; i < bulletCount; i++) getWorld().addObject(new NormalBullet(actualX, actualY, 50, 50, Math.random() * 500.0 + (actualX - 250.0), Math.random() * 500.0 + (actualY - 250.0), 2, 1.0, 1.0, false, "bullet"), (int) actualX, (int) actualY);
                nextShot = (int) (Math.random()*firerateRandomFactor) + firerate;
            }else{
                nextShot--;
            }
        }
    }
    
    private void removeSelf(){
        for(int i = 0; i < 10; i++){
            getWorld().addObject(new Particle(3, 3, 2.0, 2.0, 0.0, (int) (Math.random() * 100), 0.95, new GreenfootImage("bullet-particle.png")), (int) x, (int) y);
        }
        getWorld().removeObject(this);
    }
    
}
