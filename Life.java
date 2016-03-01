import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends PowerUps{
    
    public Life(MyWorld w){
        int x = (int) Math.ceil(Math.random()*100);
        if(x <= 15){
            w.addObject( this , w.randomX() , w.randomY() );
        }
    } 
    
    public void act(){
        Zombie z = (Zombie)getOneIntersectingObject(Zombie.class);
        if(z != null){
            ++z.lives;
            getWorld().removeObject(this);
        }      
    }
    }
