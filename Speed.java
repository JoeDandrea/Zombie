import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class speed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends Actor
{
    /**
     * Act - do whatever the speed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int zSpeed = 2;
    long startTime;
    public void act()
    {
       Actor zombie = getOneIntersectingObject(Zombie.class);
       if(zombie != null) 
           {
            zSpeed += 5;
            getWorld().removeObject(this);
        }          
  }
}