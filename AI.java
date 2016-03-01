import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract class with basic movements.
 * @author (Miles) 
 * @version (2-26-16)
 */
public class AI extends Animate{ 
    
    public void act(){} 
    
    /**
     * Execute a random turn.
     */
    public void randomTurn(){
        if(Greenfoot.getRandomNumber(100)>90){
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }
    
    /**
     * Checks the surrondings. If the AI is at
     * at the edge of the map turn away.
     */
    public void checkWorld(){
        if(isAtEdge())turn(17);
    }
    
    /**
     * What to do prior to removing this AI
     * from the world.
     */
    public void remove(){}
}
