import java.util.*;
import greenfoot.*;
import java.util.Random;

public class Particle extends ScrollActor
{
    private static double gravity;

    private Random rand =  new  Random();

    private int lifeSpan;

    private double x;
    private double y;
    private double dx;
    private double dy;

    private double width;
    private double height;
    private double growthFactor;
    private GreenfootImage img;

    private boolean removed = false;
    private boolean firstRun = true;

    //Create a new particle
    public Particle(double width, double height, double forceX, double forceY, double gravity, int lifeSpan, double growthFactor, GreenfootImage img)
    {
        this.gravity = gravity;
        this.lifeSpan = lifeSpan;
        this.width = width;
        this.height = height;
        this.growthFactor = growthFactor;
        img.scale((int) width, (int) height);
        dx = (double) rand.nextGaussian() * forceX;
        dy = (double) rand.nextGaussian() * forceY;
        setImage(img);
        this.img = img;
    }

    //Add to world
    public void addedToWorld(World world)
    {
        x = getX();
        y = getY();
        setLocation((int) x, (int) y);
    }

    //Move the particle
    public void act()
    {
        if(!Game.isPaused){
            if(firstRun){
                // Get global position
                x = x + getWorld().getCameraX() - (getWorld().getWidth()/2);
                y = y + getWorld().getCameraY() - (getWorld().getHeight()/2);
                firstRun = false;
            }
            if (y >= getWorld().getFullHeight() - height/2) {
                y = getWorld().getFullHeight() - height/2;
                dy = -1.0 * (dy * Math.random());
            }
            if (x >= getWorld().getFullWidth() - width/2) {
                x = getWorld().getFullWidth() - width/2;
                dx = -1.0 * (dx * Math.random());
            }
            x += dx;
            y += dy;
            width *= growthFactor;
            height *= growthFactor;
            if((int) width <= 5 || (int) height <= 5 || lifeSpan <= 0){
                getWorld().removeObject(this);
                removed = true;
                return;
            }
            img.scale((int) width, (int) height);
            setGlobalLocation((int) x, (int) y);
            dy = dy + gravity;
            lifeSpan = lifeSpan - 1;
        }
    }
}
