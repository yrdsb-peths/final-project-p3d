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
    
    public Login()
    {
        super(1280, 720, 1, false);
        setPaintOrder(Slider.class, Button.class, TextField.class, Text.class);
        setBackground(new GreenfootImage("MenuBackground.png"));
        user = new TextField(300, 40, Color.GRAY, Color.WHITE, "");
        addObject(new Text("Username: ", Color.GRAY), getWidth()/2 - 150, getHeight()/2);
        addObject(user, getWidth()/2 + 100, getHeight()/2 + 5);
        addObject(new Text("(10 character limit)", Color.GRAY), getWidth()/2, getHeight()/2 + 50);
        addObject(new Button("Play", getHeight()/11, 700.0/300.0, "Login"), getWidth()/2, getHeight()*14/20);
    }
    
    public void act(){
        if(user.getText().length() > 10){
            user.setText(user.getText().substring(0,user.getText().length()-1));
        }
    }
}
