import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Projectiles{
    
    private int direction, speed;
    
    public Bullet(int dir){
        direction = dir;
        speed = 5;
    }
 
    public void act(){
        if(getWorld()!= null){
            setRotation(direction);
            move(speed);           // move
            remove();              // check if bullet has hit anything
        }
    }
    
    public void remove(){
          boolean deleteMe = false;
          Zombie z = (Zombie)getOneIntersectingObject(Zombie.class);
          ZMarine zm = (ZMarine)getOneIntersectingObject(ZMarine.class);
            // when bullet hits edge of map
          if(isAtEdge()){  
              deleteMe = true; 
          }   
              
            // when a zombie gets shot
          if(z != null){
              z.hpBar.subtract(20);
              deleteMe = true;
          }
          
          // when a ZMarine gets shot 
          if(zm != null){
              zm.deleteMe = true; 
              deleteMe = true;
          }
          
          if (deleteMe == true){
              getWorld().removeObject(this);
          }
    }
}