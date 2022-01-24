import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class NormalBullet extends Bullet
{
    private int frameDelay = 5;
    private int frameCounter = 0;
    private int currentFrame = 1;
    private int numOfFrames = 4;
    private List<GreenfootImage> images = new ArrayList<GreenfootImage>();

    public NormalBullet(double globalX, double globalY, double width, double height, double targetX, double targetY, double bulletSpeed, double acceleration, double damage, boolean isPlayer, String imgName){
        this(globalX, globalY, width, height, Math.atan2(targetY - globalY, targetX - globalX), bulletSpeed, acceleration, damage, isPlayer, imgName);
    }
    
    public NormalBullet(double globalX, double globalY, double width, double height, double theta, double bulletSpeed, double acceleration, double damage, boolean isPlayer, String imgName){
        super(globalX, globalY, width, height, theta, bulletSpeed, acceleration, damage, isPlayer, imgName);
        for(int i = 1; i <= numOfFrames; i++){
            GreenfootImage img = new GreenfootImage(imgName + i + ".png");
            img.scale((int) width, (int) height);
            images.add(img);
        }
    }

    public void act()
    {
        if(!Game.isPaused){
            checkCollision((int) x, (int) y);
            if(!removed){
                x += speedX;
                y += speedY;
                turnTowardsGlobalLocation((int) (x+speedX*1000), (int) (y+speedY*1000));
                setGlobalLocation((int)x, (int)y);
                speedX *= acceleration;
                speedY *= acceleration;
                if(Math.abs(speedX) + Math.abs(speedY) < 0.2){
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
