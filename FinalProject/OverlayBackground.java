import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class OverlayBackground extends Actor
{
    public OverlayBackground(GreenfootImage img, double height, double widthMulti){
        img.scale((int) (height*widthMulti), (int) height);
        setImage(img);
    }
}
