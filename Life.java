import greenfoot.*;
import java.util.Random;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends PowerUps{
    
    public Life(){
        int x = (int) Math.ceil(Math.random()*100);
        if(x <= 15){
            getWorld().addObject( this , randomX() , randomY() );
        }
    } 
    
    public void act(){
        Zombie z = (Zombie)getOneIntersectingObject(Zombie.class);
        if(z != null){
            ++z.lives;
            getWorld().removeObject(this);
        }      
    }
    
   public int randomX(){
   return( 10 +  (int)(Math.random()*(getWorld().getWidth())));
  
   
}
    
    public int randomY(){
      return( 10 +  (int)(Math.random()*(getWorld().getHeight())));
    }
    
    }
