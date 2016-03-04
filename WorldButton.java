import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldButton extends Button{
    
    private World world = null;
    
    public WorldButton(String s , int size , World w){
        super( s , size );
        world = w;
    }
    
    public void act() {
        if(isHiglighted()){
            setImage(rGFI);
        }
        else{
            setImage(gfi);
        }
        
        if(isClicked() && world != null){
           Greenfoot.setWorld(world);
        }
    }    
}
