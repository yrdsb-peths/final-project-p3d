import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class creates the buttons that the players interact with
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private double baseHeight, currHeight, maxHeight, widthMulti;
    private String imgPath, link;
    private boolean isHovered;
    public static boolean notClickedBefore = true;

    public Button(String imgPath, double height, double widthMulti, String link){
        this.baseHeight = height;
        this.currHeight = baseHeight;
        this.maxHeight = baseHeight*1.1;
        this.widthMulti = widthMulti;
        this.link = link;
        this.imgPath = imgPath;
        GreenfootImage img = getGreenfootImage(false);
        img.scale((int) (baseHeight*widthMulti), (int) baseHeight);
        setImage(img);
    }

    public void act(){
        checkHover();
        checkClicked();
    }

    // Checks if the button is hovered. If so, make the button grow. If not, shrink back to base size
    private void checkHover(){
        if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this) && currHeight > baseHeight){
            GreenfootImage image = getGreenfootImage(false);
            currHeight /= 1.05;
            if(currHeight < baseHeight) currHeight = baseHeight;
            image.scale((int) (currHeight*widthMulti), (int) currHeight);
            setImage(image);
            isHovered = false;
        }else if((Greenfoot.mouseMoved(this) || isHovered )){
            if(!isHovered) Utils.SFX("button_hover.wav", 80);
            GreenfootImage image = getGreenfootImage(true);
            currHeight *= 1.05;
            if(currHeight > maxHeight) currHeight = maxHeight;
            image.scale((int) (currHeight*widthMulti), (int) currHeight);
            setImage(image);
            isHovered = true;
        } 
    }
    
    private GreenfootImage getGreenfootImage(boolean isBeingHovered){
        if(imgPath.equals("ToggleMusic")){
            return new GreenfootImage("Toggle-"+(Utils.musicOn ? "On" : "Off")+".png");
        }else if(imgPath.equals("ToggleSfx")){
            return new GreenfootImage("Toggle-"+(Utils.sfxOn ? "On" : "Off")+".png");
        }
        return isBeingHovered ? new GreenfootImage(imgPath + "-S" + ".png") : new GreenfootImage(imgPath + "-U" + ".png");
    }
    // Checks if the button has been clicked
    private void checkClicked(){
        if(Greenfoot.mouseClicked(this) && notClickedBefore){
            int WIDTH = getWorld().getWidth();
            int HEIGHT = getWorld().getHeight();
            // when clicked, exit or transition to next scene with sliders
            GreenfootImage image;
            switch(link){
                case "Music":
                    Utils.musicOn = !Utils.musicOn;
                    Utils.pauseMusic();
                    Utils.playMusic();
                    
                    break;
                case "Sfx":
                    Utils.sfxOn = !Utils.sfxOn;
                    break;
                case "Unpause":
                    Game.isPaused = false;
                    getWorld().removeObjects(Game.pauseScreen);
                    break;
                case "Exit":
                    Greenfoot.stop();
                    break;
                case "Nothing":
                    break;
                case "Login":
                    if(Login.user.getText().contains("~") || Login.user.getText().length() == 0 || Login.user.getText().length() > 10){
                        Utils.SFX("button_error.wav");
                        break;
                    }
                    link = "TitleScreen";
                default:
                    notClickedBefore = false;
                    Utils.SFX("button_clicked.wav", 90);
                    getWorld().addObject(new Slider(WIDTH/2, HEIGHT, WIDTH/4, HEIGHT/2, 1.0, 1.1, new GreenfootImage("TransitionLeft.png"), link, 100), (WIDTH/4) * -1, HEIGHT/2);
                    getWorld().addObject(new Slider(WIDTH/2, HEIGHT, WIDTH*3/4, HEIGHT/2, 1.0, 1.1, new GreenfootImage("TransitionRight.png"), "Nothing", 100), WIDTH*5/4, HEIGHT/2);
                    break;
            }

        }else{
            GreenfootImage image;
            switch(imgPath){
                case "ToggleMusic":
                    image = getGreenfootImage(false);
                    image.scale((int) (currHeight*widthMulti), (int) currHeight);
                    setImage(image);
                    break;
                case "ToggleSfx":
                    image = getGreenfootImage(false);
                    image.scale((int) (currHeight*widthMulti), (int) currHeight);
                    setImage(image);
                    break;
            }
        }
    }
}
