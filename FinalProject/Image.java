import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Image extends Actor
{
    private double height;
    private double widthMulti;
    
    public Image(String img, double height, double widthMulti){
        this.height = height;
        this.widthMulti = widthMulti;
        GreenfootImage image = new GreenfootImage(img);
        image.scale((int) (height*widthMulti), (int) height);
        setImage(image);
    }
    
    public Image(String str, Color c){
        setImage(new GreenfootImage(str, 50, c, null));
    }
    
    private void changeImage(String img){
        GreenfootImage image = new GreenfootImage(img);
        image.scale((int) (height*widthMulti), (int) height);
        setImage(image);
    }
    
}
