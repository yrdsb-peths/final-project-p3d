import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Bullet extends ScrollActor
{
    public double width;
    public double height;

    public double x;
    public double y;
    public double targetX;
    public double targetY;
    public double speedX;
    public double speedY;
    public double acceleration;
    public double bulletSpeed;

    public double damage;

    public boolean isPlayer;
    public boolean removed;
    public boolean first;

    public String imgName;
    public GreenfootImage img;

    public Bullet(double globalX, double globalY, double width, double height, double targetX, double targetY, double bulletSpeed, double acceleration, double damage, boolean isPlayer, String imgName){
        this(globalX, globalY, width, height, Math.atan2(targetY - globalY, targetX - globalX), bulletSpeed, acceleration, damage, isPlayer, imgName);
    }

    public Bullet(double globalX, double globalY, double width, double height, double theta, double bulletSpeed, double acceleration, double damage, boolean isPlayer, String imgName){
        this.width = width;
        this.height = height;
        this.targetX = targetX;
        this.targetY = targetY;
        this.bulletSpeed = bulletSpeed;
        this.acceleration = acceleration;
        this.damage = damage;
        this.isPlayer = isPlayer;
        this.imgName = imgName;
        this.img = new GreenfootImage(imgName + "1" + ".png");
        this.x = globalX;
        this.y = globalY;
        Utils.SFX("shoot_bullet.wav", 75);
        img.scale((int) this.width, (int) this.height);
        turnTowardsGlobalLocation((int) targetX, (int) targetY);
        setImage(img);
        this.speedX = Math.cos(theta) * bulletSpeed;
        this.speedY = Math.sin(theta) * bulletSpeed;
    }
    
    public void handleEffects(double divider, double min, GreenfootImage image){
        int size = (int) ((Math.random()*((width/divider) - min)) + min);
        getWorld().addObject(new Particle(size, size, 0.2, 0.2, 0.0, 200, 0.98, image), (int) x, (int) y);
    }

    public void checkCollision(int x, int y){
        if(isTouching(Enemy.class) && isPlayer){
            ((Enemy) getOneIntersectingObject(Enemy.class)).health -= damage;
            Game.score += Game.scoreAdder;
            removeSelf();
        }else if(isTouching(Player.class) && !isPlayer){
            Player p = getWorld().getObjects(Player.class).get(0);
            if(p.invincTime == 0){
                Utils.SFX("hit.wav", 50);
                p.health -= damage;
                p.invincTime = 100;
                getWorld().removeObject(Game.healthImage);
                Game.healthImage = new Image("Hearts-" + p.health + ".png", 40, 2.3);
                getWorld().addObject(Game.healthImage, 100, 50);
                removeSelf();
            }
        }else if(x < Game.leftBoundary || x > Game.rightBoundary || y < Game.topBoundary || y > Game.bottomBoundary){
            removeSelf();
        }
    }

    public void removeSelf(){
        for(int i = 0; i < 20; i++){
            getWorld().addObject(new Particle(width/3, height/3, 1, 1, 0.0, (int) (Math.random() * 100.0), 0.98, new GreenfootImage("bullet-particle.png")), (int) getGlobalX(), (int) getGlobalY());
        }
        getWorld().removeObject(this);
        removed = true;
    }
}
