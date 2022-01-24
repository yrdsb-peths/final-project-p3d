import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ScrollActor
{

    private int width = 25;
    private int height = 25;
    
    public static double x;
    public static double y;
    private double speedX = 0;
    private double speedY = 0;
    private double MAX_SPEED = 7;
    
    private GreenfootImage img;
    private GreenfootImage img_dashing = new GreenfootImage("e_hover.png");

    private boolean keyIsPressedX = false;
    private boolean keyIsPressedY = false;

    public int invincTime = 0;
    private int dashCooldown = 0;
    private boolean isDashing = false;
    private boolean mousePressed = false;
    
    public int health = 3;
    private double damage = 1;
    
    private int firerate = 30;
    private int nextShot = 0;
    private double spread = 0;
    private double bulletCount = 1;
    
    
    public Player(GreenfootImage img){
        img.scale(width, height);
        img_dashing.scale(width, height);
        this.img = img;
        setImage(img);
    }

    public void addedToWorld(World world)
    {
        x = getX();
        y = getY();
    }

    public void act()
    {
        if(health <= 0){
            Game.hasEnded = true;
        }
        if(!Game.isPaused){
            checkDash();
            checkMovement();
            checkShot();
            checkBounds();
            setGlobalLocation((int) x, (int) y);
        }
        moveCamera();
    }

    public void checkMovement(){
        if(Greenfoot.isKeyDown("W")){
            speedY = MAX_SPEED*(-1);
            keyIsPressedY = true;
        }
        if(Greenfoot.isKeyDown("S")){
            speedY = MAX_SPEED;
            keyIsPressedY = true;
        }        
        if(Greenfoot.isKeyDown("A")){
            speedX = MAX_SPEED*(-1);
            keyIsPressedX = true;
        }
        if(Greenfoot.isKeyDown("D")){
            speedX = MAX_SPEED;
            keyIsPressedX = true;
        }

        if(!keyIsPressedX) speedX *= 0;
        if(!keyIsPressedY) speedY *= 0;

        keyIsPressedX = false;
        keyIsPressedY = false;

        x = x + speedX;
        y = y + speedY;
    }
    
    private void moveCamera(){
        double camX = getWorld().getCameraX();
        double camY = getWorld().getCameraY();
        camX = camX + (x - camX) * 0.05;
        camY = camY + (y - camY) * 0.05;
        getWorld().setCameraLocation((int) camX, (int) camY);
    }

    public void checkShot(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            int buttonNumber = mouse.getButton();
            if (buttonNumber == 1 && Greenfoot.mousePressed(null) || mousePressed && !Greenfoot.mouseClicked(null)){
                if(nextShot <= 0 && !isDashing){
                    double actualX = mouse.getX() + (getWorld().getCameraX() - (getWorld().getWidth()/2));
                    double actualY = mouse.getY() + (getWorld().getCameraY() - (getWorld().getHeight()/2));
                    for(int i = 0; i < bulletCount; i++) getWorld().addObject(new PlayerBullet(getGlobalX(), getGlobalY(), 25, 25, actualX, actualY, 20, 1, damage, true, "playerBullet"), getGlobalX() - getWorld().getCameraX(), getGlobalY() - getWorld().getCameraY());
                    nextShot = firerate;
                }
                mousePressed = true;
            }else if(mousePressed){
                mousePressed = false;
            }
            if(nextShot >= 0) nextShot--;
        }
    }

    public void checkDash(){
        if(!isDashing){
            if(Greenfoot.isKeyDown("space") && dashCooldown == 0){
                MAX_SPEED = 15;
                invincTime = 15;
                dashCooldown = 25;
                isDashing = true;
                setImage(img_dashing);
            }else if(dashCooldown > 0){
                dashCooldown -= 1;
            }
            
        }
        if(invincTime < 2){
            setImage(img);
            MAX_SPEED = 5;
            isDashing = false;
        }
        if(invincTime > 0){
            invincTime -= 1;
            setImage(img_dashing);
        }
    }

    public void checkBounds(){
        if(x < Game.leftBoundary + 2){
            x = Game.leftBoundary + 2;
        }else if(x > Game.rightBoundary - 2){
            x = Game.rightBoundary - 2;
        }
        if(y < Game.topBoundary + 2){
            y = Game.topBoundary + 2;
        }else if(y > Game.bottomBoundary - 2){
            y = Game.bottomBoundary - 2;
        }
    }
}
