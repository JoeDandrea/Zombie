import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss1 extends Actor{
   double time =0;
    public void act() 
    {
        move(2);
        turnAtEdge();
        randomTurn();
        
        if (time % 60 ==0 )
        {
          getWorld().addObject(new Bullet(getRotation()),getX() ,getY() );    
          getWorld().addObject(new Bullet(getRotation()+10),getX() ,getY() );    
          getWorld().addObject(new Bullet(getRotation()-10),getX() ,getY() );    
        }
        time = time + 1;
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
    
    
}