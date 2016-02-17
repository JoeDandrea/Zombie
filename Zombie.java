import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.util.List;
import java.util.Set;



/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    private int marinesEaten;
    public static int lives = 3;
    long ct = System.currentTimeMillis(); //update time
    
    public Zombie()  //Initializes Zombie
    {
        marinesEaten = 0;
    }
    
    public void act() 
    {
        ct = System.currentTimeMillis(); //update time
        checkKeyPress();
        lookforMarines();
        checkWorld();
        walking();
    }
    
    public void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("a"))
        {
            turn(-4);
        }
        if (Greenfoot.isKeyDown("d"))
        {
            turn(4);
        } 
        
        if (Greenfoot.isKeyDown("w"))
        {
          
            long t = System.currentTimeMillis();
            long
            
            move(2);
        } 

        if (Greenfoot.isKeyDown("s"))
        {
            
            
            move(-2);
        } 
    }
    
    public void lookforMarines()
    {
        Marine marine = (Marine) getOneIntersectingObject(Marine.class);
        if (marine != null) {       
        removeTouching(Marine.class);
        marinesEaten = marinesEaten + 1;
        Greenfoot.playSound("slurp.wav");
    }
        getWorld().showText("Marines Eaten:" + marinesEaten,100,30);
        getWorld().showText("Lives:" + lives,60,15);
    
    }
    
    public void checkWorld()
    {
        if(isAtEdge())
        {
           if(this.getX() == getWorld().getWidth())
           {
           getWorld().addObject(this,0,this.getY());
           getWorld().removeObject(this);
           }
            if(this.getY() == getWorld().getHeight())
           {
           getWorld().addObject(this,this.getX(),0);
           getWorld().removeObject(this);
           }
    }
}
   public void walking(){
       int walk = 0;
       
       this.setImage("zombie_walk1.png");
      
       this.setImage("zombie_walk2.png");
       
       
       
    }

}
