import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class speed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends PowerUps{

    long startTime;
    
    public void act(){
        super.remove();
    }
  
    public void pUp(Zombie z){
       z.zSpeed += 5;
       z.sTimer = 400;
     }
}