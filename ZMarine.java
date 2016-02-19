import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

/**
 * Write a description of class Marine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZMarine extends Actor
{
    /**
     * Act - do whatever the Marine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        move(1);
        turnAtEdge();
        randomTurn();
        lookforMarines();
        
    }    
    
    public void randomTurn()
    {
        if(Greenfoot.getRandomNumber(100)>90)
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }
    
    
    public void turnAtEdge()
    {
        if(isAtEdge())
        {
            turn(17);
        }
    }
    
    public void lookforMarines()
    {
        Marine marine = (Marine) getOneIntersectingObject(Marine.class);
        ZMarine zmarine = new ZMarine();
        if (marine != null) {       
        removeTouching(Marine.class);
        Greenfoot.playSound("slurp.wav"); //https://freesound.org/people/Sirderf/sounds/333132/
        }
        
      
    }
    
}
