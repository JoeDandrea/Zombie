import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class PauseMenu here.
 * 
 * @author (Miles) 
 * @version (2/29/16)
 */
public class TitleScreen extends World{
       
    World world = null; // saved world
    private int x = 1000;
    private int y = 600;
    
    public TitleScreen(){
        super( 1000 , 600 , 1); 
        prepare();
    }
    
    public void prepare(){
        WorldButton title = new WorldButton("(Insert Title Here)" , 50 , world);
        this.addObject(title , x/2 , y/3);
        
        WorldButton game = new WorldButton("New Campaign Game" , 25 , new MyWorld());
        this.addObject(game , x/3 , y/2);
        
        WorldButton game1 = new WorldButton("New Versus Game" , 25 , new MyWorld());
        this.addObject(game1 , 666 , y/2);
        
    }
    
    public void act(){}
}

