import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Battery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battery extends PowerUps{
    
    public void act(){
        checkforPyro();
    }    
    
    public void checkforPyro(){
        Pyro p = (Pyro)getOneIntersectingObject(Pyro.class);
        if(p != null){
            p.batCount += 5;
            getWorld().removeObject(this);
        }
    }
}
