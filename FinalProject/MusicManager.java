import greenfoot.*;

/**
 * Write a description of class MusicManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicManager  
{
    GreenfootSound music;
    
    public MusicManager(GreenfootSound music){
        this.music = music;
    }
    
    public void act(){
        
    }
    
    public void stopMusic(){
        this.music.pause();
    }
    
    public void startMusic(){
        this.music.playLoop();
    }
    
    public void setMusic(GreenfootSound music){
        this.music = music;
    }
}
