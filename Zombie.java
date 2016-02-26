import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.util.List;
import java.util.Set;



/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    private int marinesEaten;
    public static int lives = 3;
    public static int level = 1;
    
    boolean rFoot = true;
    boolean mFoot = true;
    
    double wTime = 0;  // Walking animation timer
    
    public Zombie()  //Initializes Zombie
    {
        marinesEaten = 0;
    }
    
    public void act() 
    {
        checkKeyPress();
        lookforMarines();
        lookforBoss();
        checkWorld();
        checkSpeed();
        wTime = wTime + 1;
    }
    
    public void checkKeyPress() //Basic Movement  Falling?
    {
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            turn(-4);
        }
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))
        {
            turn(4);
        } 
        
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up"))
        {
           if(wTime % 15 == 0 && mFoot == true)
           {
            this.setImage("zombie_walk3.png");
            
            mFoot = false;
            if (rFoot == false){
                rFoot = true;
                }
            else if (rFoot == true){
                rFoot = false;
            }
           }
            else if (wTime % 15 == 0 && rFoot == true){
            this.setImage("zombie_walk1.png");
            mFoot = true;
            }
            else if (wTime % 15 == 0 && rFoot == false){
                this.setImage("zombie_walk2.png");
                mFoot = true;
             }
          move(Speed.zSpeed);
        } 
        
        if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("up") && !Greenfoot.isKeyDown("down") )
        {     
           if( rFoot = true)
           {
            this.setImage("zombie_walk3.png");
           }
           
        } 
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down") )
        {
            if( rFoot == true && wTime % 15 == 0)
           {
            this.setImage("zombie_walk2.png");
            rFoot = false;
           }
           else if(wTime % 15 == 0){
            this.setImage("zombie_walk1.png");
            rFoot = true;
            }
           move(-Speed.zSpeed);
        } 
        
           if (Greenfoot.isKeyDown("space")) // need stamina bar
        {
           move(6);
        } 
        
    }
    
    public void lookforMarines()  //Remove Marines and add to score
    {
        Marine marine = (Marine) getOneIntersectingObject(Marine.class);
        ZMarine zmarine = new ZMarine();
        Dead dead = new Dead();
        if (marine != null) {       
        removeTouching(Marine.class);
        getWorld().addObject(zmarine,getX(),getY());
        getWorld().addObject(dead,getX(),getY());
        marinesEaten = marinesEaten + 1;
        Greenfoot.playSound("slurp.wav");
        
        Life life = new Life(); //Extra Life Powerup
        int x= (int) Math.ceil(Math.random()*100);
        if(x <= 15){
         getWorld().addObject(life,MyWorld.randomX(),MyWorld.randomY());
         }
         
         
        }
        
        getWorld().showText("Marines Eaten:" + marinesEaten,100,40); //Score
        getWorld().showText("Lives:" + lives,60,15);
        getWorld().showText("Level:" + level,140,15);
       
        Actor player;
        player = getOneObjectAtOffset(0, 0, Player.class);
        if(player != null){
            int x = player.getX();
            int y = player.getY();
          
            //getWorld().removeObject(zombie);
            //ZombieGuts zg1 = new ZombieGuts();
            //getWorld().addObject( zg1 ,x, y);
            
            getWorld().removeObject(player);

        
       }
      }
      
      public void lookforBoss() //Find and remove Bosses
      {
        Fzombie fzombie = (Fzombie) getOneIntersectingObject(Fzombie.class);
         if (fzombie != null) {       
          removeTouching(Fzombie.class);
           }
       
        Boss1 boss = (Boss1) getOneIntersectingObject(Boss1.class);
         if (boss != null) {       
          removeTouching(Boss1.class);
           } 
           
       }
        
       public void checkSpeed(){
        if(Speed.zSpeed > 2){
            if(wTime % 400 == 0){
            Speed.zSpeed = 2;
           }
        }
    }
       
       
       
       
       
       
       
    public void checkWorld()
    {
        if(isAtEdge()){
           if(this.getX() >= getWorld().getWidth()-1){
               this.setLocation( 0 , this.getY() );
           }
           else if(this.getX() <= 0 ){
               this.setLocation( getWorld().getWidth() , this.getY());
            }
            if(this.getY() <= 0){
               this.setLocation( this.getX() , getWorld().getHeight());
           }
           else if (this.getY() >= getWorld().getHeight()-1){
               this.setLocation( this.getX() , 0 );
            }
        }
    }
}
