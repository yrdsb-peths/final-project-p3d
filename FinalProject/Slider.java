import greenfoot.*;

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
        if(startX - targetX != 0) x += speedX;
        if(startY - targetY != 0) y += speedY;
        speedX *= acceleration;
        speedY *= acceleration;
        checkLocation();
        if(x == targetX && y == targetY && count >= delay){
            getWorld().removeObject(this);
            switch(link){
                case "Normal":
                    Utils.setDiffMod(0.75);
                    Greenfoot.setWorld(new Game());
                    break;
                case "Hard":
                    Utils.setDiffMod(1.0);
                    Greenfoot.setWorld(new Game());
                    break;
                case "Chaos":
                    Utils.setDiffMod(1.5);
                    Greenfoot.setWorld(new Game());
                    break;
                case "DiffSelect":
                    Greenfoot.setWorld(new DifficultySelectionScreen());
                    break;
                case "Leaderboards":
                    Greenfoot.setWorld(new Leaderboards());
                    break;
                case "Instructions":
                    Greenfoot.setWorld(new Instructions());
                    break;
                case "Options":
                    Greenfoot.setWorld(new Options());
                    break;
                case "TitleScreen":
                    Greenfoot.setWorld(new TitleScreen());
                    break;
                case "ChangeUser":
                    Greenfoot.setWorld(new Login(true));
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
