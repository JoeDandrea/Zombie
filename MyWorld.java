import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World{
    
    private static int numEnemies = 6;
    Zombie zombie;
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        setPaintOrder(Zombie.class, Fzombie.class, Boss1.class, Marine.class, ZMarine.class, Life.class, Dead.class, Bullet.class );
        prepare();
       
              
    }
    
    public void act(){
       spawn(); 
       level();    
    }
    
    private void prepare(){
        zombie = new Zombie(0);
        addObject(zombie,getWidth()/2,getHeight()/2);
        zombie.lives = 3;
        zombie.level = 1;
        
        Marine[] marine = new Marine[numEnemies];
        for(byte i = 0; i < numEnemies; ++i){
            marine[i] = new Marine();
            addObject(marine[i] , randomX() , randomY() );
        }
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
         
            ++zombie.level;
            for (int l = 1; l <= zombie.level *2; ++ l){
                Marine marine = new Marine();
                addObject(marine,randomX(),randomY());
            }
       }
     }
    
     public void spawn(){
        if( zombie.level == 2 && getObjects(Boss1.class).isEmpty()){
            if(getObjects(Marine.class).isEmpty()){
                List remove = getObjects(ZMarine.class);
                List remove2 = getObjects(Dead.class);
                for (Object objects : remove){
                    removeObject((ZMarine) objects);
                }
                
                for (Object objects : remove2){
                    removeObject((Dead) objects);
                }
                
                Boss1 b = new Boss1();
                addObject( b, randomX() , randomY() );
                ++zombie.level;
            }
        }
     }
     
     /**
      * Generates Y value using loc()
      */
     public int randomX(){
        return loc(this.getWidth()  , zombie.getX() );
     }
     
     /**
      * Generates Y value using loc()
      */
     public int randomY(){
        return loc(this.getHeight()  , zombie.getY() );
     }
    
     /**
      * @param lim : the upper bound of the random number
      * @param z : the current location of the zombie 
      * @return ret : a random number smaller than lim and not
      * within 30 units of z
      */
     public static int loc (int lim , int z){
          Random r = new Random(); // random number object
          int ret;  // value to be returned
          do{ 
              ret = r.nextInt(lim) + 25;//int smaller than lim and larger than 25
          }while(( ret > z && ret < z + 30) || (ret < z && ret > z - 30));
          
          return ret;
      }
}
