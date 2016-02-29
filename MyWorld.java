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
        super(1000, 600, 1); 
        setPaintOrder(Zombie.class, Fzombie.class, Boss1.class, Marine.class, ZMarine.class, Life.class, Dead.class, Bullet.class );
        prepare();
       
              
  }
   public void act(){
       spawn(); 
       level();
        
    }
   
  private void prepare()
    {
        Zombie zombie = new Zombie();
        addObject(zombie,getWidth()/2,getHeight()/2);
        Zombie.lives = 3;
        Zombie.level = 1;
        
        Stamina stamina = new Stamina();
        addObject(stamina,900,40);
        showText("Stamina",900,15);
        
        Marine marine = new Marine();
        addObject(marine,randomX(),randomY());
        
        Marine marine2 = new Marine();
        addObject(marine2,randomX(),randomY());
        
        Marine marine3 = new Marine();
        addObject(marine3,randomX(),randomY());
        
        Marine marine4 = new Marine();
        addObject(marine4,randomX(),randomY());
        
      
    }
    
    private void level(){
        
        if(getObjects(Marine.class).isEmpty() && getObjects(Boss1.class).isEmpty()){
        List remove = getObjects(ZMarine.class);
        List remove2 = getObjects(Dead.class);
          for (Object objects : remove){
            removeObject((ZMarine) objects);
          }
          for (Object objects : remove2){
            removeObject((Dead) objects);
          }
         
        ++Zombie.level;
          for (int l = 1; l <= Zombie.level *2; ++ l){
          Marine marine = new Marine();
           addObject(marine,randomX(),randomY());
          }
    }
   }
   
   public static int randomX(){
   return( 10 +  (int)(Math.random()*(1091)));
   // int Random = (min.value ) + (int)(Math.random()* ( Max - Min + 1));
   // Where min is the smallest value You want to be the smallest number possible to      
   // generate and Max is the biggest possible number to generate*/
   
}
    
    public static int randomY(){
      return( 10 +  (int)(Math.random()*(691)));
    }
    
    
    
    public void spawn(){
    if( Zombie.level == 2 && getObjects(Boss1.class).isEmpty())
        if(getObjects(Marine.class).isEmpty()){
        List remove = getObjects(ZMarine.class);
        List remove2 = getObjects(Dead.class);
          for (Object objects : remove){
            removeObject((ZMarine) objects);
          }
          for (Object objects : remove2){
           removeObject((Dead) objects);
          }
         
          
          Boss1 boss = new Boss1();
          addObject(boss,MyWorld.randomX(),MyWorld.randomY());
          ++Zombie.level;
       
    }
    
   }
}
