import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class leaderboardText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    public Text(String str, Color c){
        setImage(new GreenfootImage(str, 50, c, null));
    }
}
