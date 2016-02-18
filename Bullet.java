import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int direction, speed;
    public Bullet(int dir)
    {
        direction = dir;
        speed = 5;
    }
 
    public void act()
    {
        setRotation(direction);
        move(speed);
        removeBullet();
    }
    
      public void removeBullet()
    {
       boolean deleteMe = false;
       Actor zombie = getOneIntersectingObject(Zombie.class);
           
        if(isAtEdge())
        {  
         deleteMe = true; 
       }
      
       if(zombie != null) 
           {
           --Zombie.lives;
           deleteMe = true;
           if(Zombie.lives <= 0){
             getWorld().showText("Lives:" + 0,60,15);
             getWorld().removeObject(zombie); 
             Greenfoot.stop();
             }
       }
                 
       if (deleteMe == true){
          getWorld().removeObject(this);
        }
  }
}
    


