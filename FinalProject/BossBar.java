import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BossBar extends Actor
{
    private GreenfootImage image;
    private int maxLength;
    private int height;
    
    private int OGx;
    private int OGy;
    
    public BossBar(){
        this.maxLength = (int) (5.0*100.0*0.8);
        this.height = (int) (100.0/4.0);
        image = new  GreenfootImage(height, maxLength);
        image.setColor(Color.GREEN);
        image.fill();
        setImage(image);
    }
    
    protected void addedToWorld(World world){
        this.OGx = getX();
        this.OGy = getY();
    }
    
    public void act()
    {
        if(!getWorld().getObjects(Enemy.class).isEmpty()){
            Enemy e = getWorld().getObjects(Enemy.class).get(0);
            if(e.health == 0){
                getWorld().removeObject(this);
            }
            int length = (int) ((e.health/100.0)*maxLength)+1;
            image.scale(length, height);
            setLocation(OGx - ((maxLength - length)/2), OGy);
        }else{
            getWorld().removeObject(this);
        }
    }
}
