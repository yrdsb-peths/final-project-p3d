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
    private int delay = 100;

    public double health;
    private double damage;
    private double movementSpeed = 2;

    private int firerate = (int) (50.0/Utils.diffMod);
    private int firerateRandomFactor = 20;
    private int nextShot = (int) (Math.random()*firerate);

    private GreenfootImage image;

    public Enemy(double health, double damage, double speed){
        this.health = health;
        this.damage = damage;
        image = new  GreenfootImage(100, 100);
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
        this.image = image;
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
        if(delay >= 0){
            delay--;
            return;
        }else if(!Game.isPaused){
            if(health <= 0){
                removeSelf();
                Game.hasEnded = true;
                Game.won = true;
                return;
            }else if(nextShot <= 0){
                //double actualX = getGlobalX();
                //double actualY = getGlobalY();
                //for(int i = 0; i < bulletCount; i++) getWorld().addObject(new NormalBullet(actualX, actualY, 30, 30, Math.random() * 500.0 + (actualX - 250.0), Math.random() * 500.0 + (actualY - 250.0), 7, 1.0, 1.0, false, "bullet"), getGlobalX(), getGlobalY() );
                getNextAttack();
                nextShot = (int) (Math.random()*firerateRandomFactor) + firerate;
            }else{
                nextShot--;
            }
            move();
            checkCollision();
        }
    }

    private void move(){
        double dx = Player.x - x;
        double dy = Player.y - y;
        double theta = Math.atan2(dy, dx);
        turnTowardsGlobalLocation((int) Player.x, (int) Player.y);
        x += Math.cos(theta) * movementSpeed;
        y += Math.sin(theta) * movementSpeed;
        setGlobalLocation((int) x, (int) y);
        this.movementSpeed = 2;
    }

    private void checkCollision(){
        if(isTouching(Player.class)){
            Player p = getWorld().getObjects(Player.class).get(0);
            if(p.invincTime == 0){
                Utils.SFX("hit.wav");
                p.health -= damage;
                p.invincTime = 100;
            }
        }
    }

    private void removeSelf(){

        for(int i = 0; i < 10; i++){
            getWorld().addObject(new Particle(20, 20, 2.0, 2.0, 0.0, (int) (Math.random() * 100), 1, new GreenfootImage("bullet-particle.png")), (int) x, (int) y);
        }
        getWorld().removeObject(this);
    }

    private void getNextAttack(){
        int r = Greenfoot.getRandomNumber(6);
        double actualX = getGlobalX();
        double actualY = getGlobalY();
        Player p = getWorld().getObjects(Player.class).get(0);
        switch(r){
            case 0:
                getWorld().addObject(new Ring(1+Greenfoot.getRandomNumber(3-1), 5+Greenfoot.getRandomNumber(20-5)), getGlobalX(), getGlobalY());
                image.setColor(Color.PINK);
                image.fill();
                break;
            case 1:
                getWorld().addObject(new Spray(20+Greenfoot.getRandomNumber(50-20), 1+Greenfoot.getRandomNumber(3-1)), getGlobalX(), getGlobalY());
                image.setColor(Color.BLUE);
                image.fill();
                break;
            case 2:
                getWorld().addObject(new DropBombs(2+Greenfoot.getRandomNumber(5-2)), getGlobalX(), getGlobalY());
                image.setColor(Color.GREEN);
                image.fill();
                break;
            case 3:
                getWorld().addObject(new SprayTarget(10+Greenfoot.getRandomNumber(30-10), 1+Greenfoot.getRandomNumber(3-1)), getGlobalX(), getGlobalY());
                image.setColor(Color.GRAY);
                image.fill();
                break;
            case 4:
                this.movementSpeed = (int) (100.0*Utils.diffMod);
                image.setColor(Color.YELLOW);
                image.fill();
                break;
            case 5:
                getWorld().addObject(new RingSpray(), getGlobalX(), getGlobalY());
                image.setColor(Color.CYAN);
                image.fill();
                break;

        }
    }
}
