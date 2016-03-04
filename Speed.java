import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class speed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends PowerUps
{
    /**
     * Act - do whatever the speed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    long startTime;
    public void act()
    {
       Zombie zombie = (Zombie) getOneIntersectingObject(Zombie.class);
       if(zombie != null) 
           {
            zombie.zSpeed += 5;
            getWorld().removeObject(this);
        }          
  }
}