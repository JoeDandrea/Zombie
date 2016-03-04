import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InGameButton here.
 * 
 * @author (Miles) 
 * @version (3/1/2016)
 */
public class InGameButton extends Button{
    public void act(){
        if(this.getWorld() != null){
            if(isClicked()){
                Greenfoot.setWorld(new PauseMenu(this.getWorld()));
            }
        }    
    }
}
