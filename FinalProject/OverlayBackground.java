import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OverlayBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OverlayBackground extends Actor
{
    public OverlayBackground(GreenfootImage img, double height, double widthMulti){
        img.scale((int) (height*widthMulti), (int) height);
        setImage(img);
    }
}
