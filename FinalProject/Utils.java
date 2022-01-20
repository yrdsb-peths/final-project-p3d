import greenfoot.*;

/**
 * Write a description of class Utils here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utils  
{
    public static GreenfootSound music = new GreenfootSound("MenuBackgroundMusic.mp3");    
    public static boolean musicOn = true;
    public static boolean sfxOn = true;
    
    public static void pauseMusic(){
        music.pause();
    }
    
    public static void playMusic(){
        if(musicOn){
            music.playLoop();
        }
    }
    
    public static void changeMusic(String newMusic){
        music = new GreenfootSound(newMusic);
    }
    
    public static void SFX(String sfx){
        if(sfxOn){
            GreenfootSound s = new GreenfootSound(sfx);
            s.play();
        }
    }
}
