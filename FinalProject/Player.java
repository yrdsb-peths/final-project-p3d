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

    private double leftBoundary = 640;
    private double topBoundary = 360;
    private double rightBoundary = 1920;
    private double bottomBoundary = 2200;
    
    private double x;
    private double y;
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

    //Add to world
    public void addedToWorld(World world)
    {
        x = getX();
        y = getY();
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(health <= 0){
            //  System.out.println("you are bad");
            //  Set game is Paused, show a retry screen blah blah blah
            //Game.isPaused = true;
        }else if(!Game.isPaused){
            checkMovement();
            checkShot();
            checkDash();
        }
        
        //getWorld().addObject(new Particle(10, 10, 0.3, 0.3, 0.0, (int) (Math.random() * 40), new GreenfootImage("smoke.png")), (int) x, (int) y);
        //setLocation((int)x, (int)y);
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
        checkBounds();
        setGlobalLocation((int) x, (int) y);
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
                if(nextShot <= 0 && invincTime == 0){
                    double actualX = mouse.getX() + (getWorld().getCameraX() - (getWorld().getWidth()/2));
                    double actualY = mouse.getY() + (getWorld().getCameraY() - (getWorld().getHeight()/2));
                    for(int i = 0; i < bulletCount; i++) getWorld().addObject(new NormalBullet(getGlobalX(), getGlobalY(), 50, 10, actualX, actualY, 20, 1, damage, true, "bullet"), getGlobalX(), getGlobalY());
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
                dashCooldown = 50;
                isDashing = true;
                setImage(img_dashing);
            }else if(dashCooldown > 0){
                dashCooldown -= 1;
            }
            
        }else{
            invincTime -= 1;
            if(invincTime < 1){
                setImage(img);
                MAX_SPEED = 5;
                isDashing = false;
            }
        }
    }

    public void checkBounds(){
        if(x < leftBoundary){
            x = leftBoundary;
        }else if(x > rightBoundary){
            x = rightBoundary;
        }
        if(y < topBoundary){
            y = topBoundary;
        }else if(y > bottomBoundary){
            y = bottomBoundary;
        }
    }
}
