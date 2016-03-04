import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss1 extends AI{
    
   double time =0;
   public boolean deleteMe = false;
   
    public void act(){
        move(2);
        checkWorld();
        randomTurn();
        shoot();
        remove();
    }
    
    public void shoot(){
        if (time % 60 ==0 ){
          getWorld().addObject(new Bullet(getRotation()),getX() ,getY() );    
          getWorld().addObject(new Bullet(getRotation()+10),getX() ,getY() );    
          getWorld().addObject(new Bullet(getRotation()-10),getX() ,getY() );    
        }
        time++;
    }
    
    public void remove(){
        if(deleteMe){
            //getWorld().addObject(new Dead() , this.getX() , this.getY());
            getWorld().addObject(new Fzombie() , this.getX() , this.getY());
            getWorld().removeObject(this);
        }
    }
}