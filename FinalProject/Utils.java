import greenfoot.*;

/**
 * Write a description of class Utils here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utils extends Actor 
{
    public static GreenfootSound music;
    public static boolean musicOn = true;
    public static boolean sfxOn = true;
    public static int SCREEN_WIDTH = 1280;
    public static int SCREEN_HEIGHT = 720;
    public static int FULL_WIDTH = 2560;
    public static int FULL_HEIGHT = 2000;
    
    public static void pauseMusic(){
        music.pause();
    }
    
    public static void playMusic(){
        if(musicOn){
            music.playLoop();
        }
    }
    
    public static void setMusic(String newMusic){
        music = new GreenfootSound(newMusic);
    }
    
    public static void changeMusicVolume(int vol){
        music.setVolume(vol);
    }
    
    public static void SFX(String sfx){
        if(sfxOn){
            GreenfootSound s = new GreenfootSound(sfx);
            s.play();
        }
    }
    
    public static void SFX(String sfx, int volume){
        if(sfxOn){
            GreenfootSound s = new GreenfootSound(sfx);
            s.setVolume(volume);
            s.play();
        }
    }
    
}
