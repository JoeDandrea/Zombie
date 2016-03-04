import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
  
    private static int numEnemies = 6;
    public static int level = 1;
    Zombie zombie;
    
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld(){    
        super(1000, 600, 1); 
        setPaintOrder(Zombie.class, Fzombie.class, Boss1.class, Marine.class, ZMarine.class, Life.class, Dead.class, Bullet.class );
        prepare();
    }
    
    public void act(){
       level();
       showStats();
    }
    
    private void prepare(){
        level = 1;
     
        InGameButton igb = new InGameButton();
        addObject(igb , getWidth() - 15 , 15);
        
        zombie = new Zombie(0);
        addObject(zombie,getWidth()/2,getHeight()/2);
        
        for(byte i = 0; i < numEnemies; ++i){
            Marine marine= new Marine();
            addObject(marine , randomX() , randomY() );
        }
    }
    
     private void level(){
        if(isClear()){ // if all marines and bosses have been killed
            removeActors(); // remove the remaining actors
            ++level; // increment level
                // if the level is an even number
            if((level % 2 == 0)){ 
                    // spawn level/2 bosses
                for (int i = 1; i <= level/2; i ++){
                    Boss1 b = new Boss1();
                    addObject( b, randomX() , randomY() );
                }
            }
            else{
                    // spawn level*2 marines
                for (int i = 1; i <= level *2; ++i){
                    Marine marine = new Marine();
                    addObject( marine, randomX() , randomY() );
                }
            }
       }
     }
     
    /**
      * Removes all non enemy actors from this world.
      */
     public void removeActors(){
         List remove = getObjects(ZMarine.class);
         List remove2 =getObjects(Dead.class);
         for (Object objects : remove){
             removeObject((Actor)objects);
         }
         
         for (Object objects : remove2){
             removeObject((Actor)objects);
         }
     }
     
     /**
       * Checks if all marines and bosses have been removed
       * from this world.
       */
     public boolean isClear(){
         if(getObjects(Marine.class).isEmpty() && getObjects(Boss1.class).isEmpty()){
            return true;
         }
         return false;
     }
     
     /**
      * Show the stats of the game. 
      */
     public void showStats(){
        showText("Marines Eaten:" + Zombie.marinesEaten,100,40);
        showText("Level:" + level,150,15);
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
