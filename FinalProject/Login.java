import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Login here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Login extends World
{
    public static TextField user;
    private int WIDTH = 1280;
    private int HEIGHT = 720;
    
    public Login()
    {
        super(1280, 720, 1, false);
        setPaintOrder(Slider.class, Button.class, TextField.class, Image.class);
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, (Utils.SCREEN_WIDTH/4) * -1, Utils.SCREEN_HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), Utils.SCREEN_WIDTH/4, Utils.SCREEN_HEIGHT/2);
        addObject(new Slider(Utils.SCREEN_WIDTH/2, Utils.SCREEN_HEIGHT, Utils.SCREEN_WIDTH*5/4, Utils.SCREEN_HEIGHT/2, 1.0, 1.05, new GreenfootImage("TransitionRight.png"), "Nothing", 0), Utils.SCREEN_WIDTH*3/4, Utils.SCREEN_HEIGHT/2);
        setBackground(new GreenfootImage("MenuBackground.png"));
        user = new TextField(300, 40, Color.GRAY, Color.WHITE, "");
        addObject(new Image("Username: ", Color.GRAY), getWidth()/2 - 150, getHeight()/2);
        addObject(user, getWidth()/2 + 100, getHeight()/2 + 5);
        addObject(new Image("(10 character limit)", Color.GRAY), getWidth()/2, getHeight()/2 + 50);
        addObject(new Button("Play", getHeight()/11, 700.0/300.0, "Login"), getWidth()/2, getHeight()*14/20);
        Button.notClickedBefore = true;
    }
    
    public void act(){
        if(user.getText().length() > 10){
            user.setText(user.getText().substring(0,user.getText().length()-1));
        }
    }
    
    public void started(){
        Utils.setMusic("MenuBackgroundMusic.mp3");
        Utils.playMusic();
        Utils.changeMusicVolume(40);
    }
    
    public void stopped(){
        Utils.pauseMusic();
    }
}
