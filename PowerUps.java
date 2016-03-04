import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUps extends Inanimate{
    
    public void remove(){
        Zombie z = (Zombie)getOneIntersectingObject(Zombie.class);
        if(z != null  && Greenfoot.isKeyDown("e")){
            pUp(z);
            getWorld().removeObject(this);
        }      
    }
    
    public void pUp( Zombie z ){
    
    }
}

