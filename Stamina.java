import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stamina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stamina extends Actor
{
    /**
     * Act - do whatever the Stamina wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int timer = 0 ;
    
    public void act() 
    {
        cooldown();
        if(timer <= 60){++timer;}
    }    

    public void cooldown(){
       if( timer ==15) // need stamina bar
         {
           this.setImage("25.png");
         }
        else  if( timer ==30) // need stamina bar
         {
           this.setImage("50.png");
         } 
       else if( timer ==45) // need stamina bar
         {
           this.setImage("75.png");
         }
       else if( timer ==60) // need stamina bar
         {
           this.setImage("100.png");
         }
        if (Greenfoot.isKeyDown("space") && timer >=60)
            {
                timer = 0; 
                this.setImage("0.png");
            }
     }
}

