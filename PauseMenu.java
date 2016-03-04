import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class PauseMenu here.
 * 
 * @author (Miles) 
 * @version (2/29/16)
 */
public class PauseMenu extends World{
       
    World world = null; // saved world
    private int x = 1000;
    private int y = 600;
    
    public PauseMenu(World w){
        super( 1000 , 600 , 1); 
        world = w;
        prepare();
    }
    
    public void prepare(){
        WorldButton paused = new WorldButton("Paused" , 35 , world);
        this.addObject(paused , x/2 , y/3);
        
        WorldButton cont = new WorldButton("Continue" , 25 , world);
        this.addObject(cont , x/3 , y/2);
        
        WorldButton restart = new WorldButton("Restart" , 25 , new MyWorld());
        this.addObject(restart , x/2 , y/2);
        
        WorldButton quit = new WorldButton( "Quit" , 25 , new TitleScreen());
        this.addObject(quit,(666) , y/2);
        
        
    }
    
    public void act(){}
}

