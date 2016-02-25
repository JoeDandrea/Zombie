import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    /**
     * Act - do whatever the Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       boolean deleteMe = false;
       Actor zombie = getOneIntersectingObject(Zombie.class);
       
            if(zombie != null) 
            {
             ++Zombie.lives;
             deleteMe = true;
            }   
           
            if (deleteMe == true)
            {
                getWorld().removeObject(this);
            }   
       }
    }
