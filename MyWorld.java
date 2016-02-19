import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(560, 560, 1); 
        setPaintOrder(Zombie.class, Marine.class);
        prepare();
        level();
        
  }
   
  private void prepare()
    {
        Zombie zombie = new Zombie();
        addObject(zombie,273,337);
        Zombie.lives = 3;
        
        Marine marine = new Marine();
        addObject(marine,215,406);
        
        Marine marine2 = new Marine();
        addObject(marine2,115,406);
        
        Marine marine3 = new Marine();
        addObject(marine3,175,3406);
        
        Marine marine4 = new Marine();
        addObject(marine4,15,06);
        
        Marine marine5 = new Marine();
        addObject(marine5,115,406);
        
        Marine marine6 = new Marine();
        addObject(marine6,75,306);
    }
    
    private void level(){
        
        if(getWorld().Marine == null){
            Marine marine = new Marine();
        addObject(marine,215,406);
        
        Marine marine2 = new Marine();
        addObject(marine2,115,406);
        
        Marine marine3 = new Marine();
        addObject(marine3,175,3406);
        
        Marine marine4 = new Marine();
        addObject(marine4,15,06);
        
        Marine marine5 = new Marine();
        addObject(marine5,115,406);
        
        Marine marine6 = new Marine();
        addObject(marine6,75,306); 
    }
   }
}
