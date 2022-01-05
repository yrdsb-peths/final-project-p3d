import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class NormalBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalBullet extends Bullet
{
    private int particleDelay = 3;
    private int particleDelayCounter = 0;

    private int frameDelay = 5;
    private int frameCounter = 0;
    private int currentFrame = 1;
    private int numOfFrames = 4;
    private List<GreenfootImage> images = new ArrayList<GreenfootImage>();

    public NormalBullet(double globalX, double globalY, double width, double height, double targetX, double targetY, double bulletSpeed, double acceleration, double damage, boolean isPlayer, String imgName){
        super(globalX, globalY, width, height, targetX, targetY, bulletSpeed, acceleration, damage, isPlayer, imgName);
        for(int i = 1; i <= numOfFrames; i++){
            GreenfootImage img = new GreenfootImage(imgName + i + ".png");
            img.scale((int) width, (int) height);
            images.add(img);
        }
    }

    public void act()
    {
        if(!Game.isPaused){
            checkCollision();
            if(!removed){
                if(particleDelayCounter >= particleDelay){
                    handleEffects(1.5, 5, new GreenfootImage("bullet-particle.png"));
                    particleDelayCounter = 0;
                }else{
                    particleDelayCounter++;
                }
                x += speedX;
                y += speedY;
                turnTowardsGlobalLocation((int) (x+speedX*1000), (int) (y+speedY*1000));
                setGlobalLocation((int)x, (int)y);
                speedX *= acceleration;
                speedY *= acceleration;
                if(Math.abs(speedX) + Math.abs(speedY) < 0.01){
                    removeSelf();
                }
                if(frameCounter > frameDelay){
                    frameCounter = 0;
                    currentFrame++;
                    if(currentFrame > numOfFrames){
                        currentFrame = 1;
                    }
                    setImage(images.get(currentFrame-1));
                }
                frameCounter++;
            }
        }
    }
}
