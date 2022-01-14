import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slider extends Actor
{
    private double x;
    private double y;
    private double startX;
    private double startY;
    private double targetX;
    private double targetY;
    private double speedX;
    private double speedY;
    private double sliderSpeed;
    private double acceleration;
    
    private double width;
    private double height;
    
    private int delay;
    private int count = 0;
    
    private String link;
    
    private GreenfootImage img;

    //Add to world
    public void addedToWorld(World world)
    {
        x = this.getX();
        y = this.getY();
        this.startX = x;
        this.startY = y;
        double dx = targetX - x;
        double dy = targetY - y;
        double theta = Math.atan2(dy, dx);
        setLocation((int) x, (int) y);
        img.scale((int) width, (int) height);
        setImage(img);
        this.speedX = Math.cos(theta) * sliderSpeed;
        this.speedY = Math.sin(theta) * sliderSpeed;
    }
    
    public Slider(double width, double height, double targetX, double targetY, double sliderSpeed, double acceleration, GreenfootImage img, String link, int delay){
        this.targetX = targetX;
        this.targetY = targetY;
        this.sliderSpeed = sliderSpeed;
        this.acceleration = acceleration;
        this.link = link;
        this.width = width;
        this.height = height;
        this.img = img;
        this.delay = delay;
    }
    
    
    public void act()
    {
        // Add your action code here.
        if(startX - targetX != 0) x += speedX;
        //x = Math.round(x * 100.0) / 100.0;
        if(startY - targetY != 0) y += speedY;
        speedX *= acceleration;
        speedY *= acceleration;
        checkLocation();
        if(x == targetX && y == targetY && count >= delay){
            getWorld().removeObject(this);
            switch(link){
                case "Game":
                    Greenfoot.setWorld(new Game());
                    break;
                case "Leaderboards":
                    Greenfoot.setWorld(new Leaderboards());
                    break;
                case "Options":
                    Greenfoot.setWorld(new Options());
                    break;
                case "TitleScreen":
                    Greenfoot.setWorld(new TitleScreen());
                    break;
                case "Nothing":
                    break;
            }
        }else{
            count++;
        }
        setLocation((int)x, (int)y);
    }
    
    public void checkLocation(){
        if(startX - targetX < 0){
            if(x > targetX){
                x = targetX;
            }
        }else if(startX - targetX > 0){
            if(x < targetX){
                x = targetX;
            }
        }
        if(startY - targetY < 0){
            if(y > targetY){
                y = targetY;
            }
        }else if(startY - targetY > 0){
            if(y < targetY){
                y = targetY;
            }
        }
    }
}
