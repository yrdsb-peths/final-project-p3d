import greenfoot.*;

/**
 * Write a description of class SFX here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SFX  
{
    public SFX(GreenfootSound sfx)
    {
        if(TitleScreen.sfxOn){
            sfx.play();
        }
    }
}
