import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class PlayerBullet extends Bullet
{
    public PlayerBullet(double globalX, double globalY, double width, double height, double targetX, double targetY, double bulletSpeed, double acceleration, double damage, boolean isPlayer, String imgName){
        super(globalX, globalY, width, height, targetX, targetY, bulletSpeed, acceleration, damage, isPlayer, imgName);
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
            }
        }
    }
}
