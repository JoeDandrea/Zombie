import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

/**
 * Write a description of class Marine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZMarine extends AI{
    
    public boolean deleteMe = false;
    
    /**
     * Act - do whatever the Marine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(1);
        checkWorld();
        randomTurn();
        lookforMarines();
        remove();
    }    
    
    public void lookforMarines(){
        Marine m = (Marine) getOneIntersectingObject(Marine.class);
        if (m != null) {       
            m.deleteMe = true;
            Greenfoot.playSound("slurp.wav"); //https://freesound.org/people/Sirderf/sounds/333132/
        }
    }
    
    public void remove(){
        if(deleteMe){
            getWorld().removeObject(this);
        }
    }
}   
