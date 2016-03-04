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
public class Zombie extends User{
 
    public static int marinesEaten = 0;
    public Bar hpBar , spBar;
    private boolean rFoot = true , mFoot = true;
    private int     wTime = 0 , sTimer =0;
    final static int DEFAULT_SPEED = 2;
    public static int zSpeed = DEFAULT_SPEED;
    
    /**
     * Constructs a Zombie. 
     * @param The set of controls being used. 0 for 
     * WASD. 1 for Arrow keys.
     */
    public Zombie(int controls){
        super(controls);
        hpBar = new Bar("Zombie","Points", 100, 100);
    }
    
    public void act(){
        getWorld().addObject(hpBar , 30 , 30);
        checkKeyPress();
        lookforEnemies();
        checkSpeed();
        checkWorld();
        wTime++;
        remove();
    }
    
    public void lookforEnemies(){
        lookforMarines();
        lookforPyro();
        lookforBoss();
    }
    
    public void lookforMarines(){//Remove Marines and add to score
        Marine m = (Marine) getOneIntersectingObject(Marine.class);
        if (m != null) {
            m.deleteMe = true;
            marinesEaten++;
            Greenfoot.playSound("slurp.wav");
        }
      }
      
    public void lookforBoss(){
        Boss1 boss = (Boss1) getOneIntersectingObject(Boss1.class);
        if (boss != null) {       
          boss.deleteMe = true;
          Greenfoot.playSound("slurp.wav");
         }
           
       }
       
    public void lookforPyro(){
           Pyro p = (Pyro)getOneObjectAtOffset(0, 0, Pyro.class);
           if(p != null){
               p.deleteMe = true;
            }
        }
        
       public void checkSpeed(){
        if(zSpeed > DEFAULT_SPEED &&  sTimer ==0){
            zSpeed = DEFAULT_SPEED;
        }
    }
       
     public void remove(){
        if(getWorld() instanceof MyWorld){
            if(hpBar.getValue() == hpBar.getMinimumValue()){
                Greenfoot.playSound("Pain.wav");
                getWorld().removeObject(this);
                Greenfoot.setWorld(new LoseScreen(((MyWorld)getWorld()).level , marinesEaten));
                marinesEaten = 0;
            }
        }
    }
    
    public void forwardMovement(){
        if(wTime % 15 == 0 && mFoot == true){
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
        move(zSpeed);
    }
    
    public void stationaryAnimation(){
        if( rFoot = true){
            this.setImage("zombie_walk3.png");
        }
    }
    
    public void backwardsMovement(){
        if( rFoot == true && wTime % 15 == 0){
            this.setImage("zombie_walk2.png");
            rFoot = false;
        }
        else if(wTime % 15 == 0){
            this.setImage("zombie_walk1.png");
            rFoot = true;
        }
        move(-zSpeed);
    }
}