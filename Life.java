import greenfoot.*;
import java.util.Random;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends PowerUps{
    
    public void act(){
        super.remove();
    }
    
   public void pUp(Zombie z){
       z.hpBar.add(10);
    }
    
}
