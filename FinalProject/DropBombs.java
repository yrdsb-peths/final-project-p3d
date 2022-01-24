import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dropBombs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DropBombs extends AttackPatterns
{
    private int leftBoundary = Utils.SCREEN_WIDTH/2 + 10;
    private int rightBoundary = Utils.FULL_WIDTH-leftBoundary;
    private int topBoundary = Utils.SCREEN_HEIGHT/2 + 10;
    private int bottomBoundary = Utils.FULL_HEIGHT-topBoundary;

    private int bombCount;

    public DropBombs(int bombCount){
        this.bombCount = (int) (bombCount*Utils.diffMod);
    }

    public void act(){
        if(Game.isPaused){
            return;
        }
        if(Game.hasEnded){
            getWorld().removeObject(this);
        }else if(bombCount >= 0){
            int x = leftBoundary + Greenfoot.getRandomNumber(rightBoundary - leftBoundary + 1);
            int y = topBoundary + Greenfoot.getRandomNumber(bottomBoundary - topBoundary + 1);

            getWorld().addObject(new Bomb(x, y, 5 + Greenfoot.getRandomNumber(10 - 5)), (int) x, (int) y);
            bombCount--;
        }else{
            getWorld().removeObject(this);
        }
    }
}
