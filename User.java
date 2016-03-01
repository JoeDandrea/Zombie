import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User extends Animate{
    
    public String UP , DOWN , LEFT , RIGHT;
    
    public User(int controls){
        setControls(controls);
    }
    
    public void act(){}
    
    public void setControls(int controls){
        if (controls == 0){ // WASD
            UP = "w"; DOWN = "s"; LEFT = "a"; RIGHT = "d";
        }
        else { // arrow keys
            UP = "up"; DOWN = "down"; LEFT = "left"; RIGHT = "right";
        }
    }
    
    public void checkKeyPress(){
        if (Greenfoot.isKeyDown(LEFT)){
            turn(-4);
        }
        
        if (Greenfoot.isKeyDown(RIGHT)){
            turn(4);
        } 
        
        if (Greenfoot.isKeyDown(UP)){
          forwardMovement();
          
        } 
        
        if (!Greenfoot.isKeyDown(UP) && !Greenfoot.isKeyDown(DOWN)){     
           stationaryAnimation();
        }
        
        if (Greenfoot.isKeyDown(DOWN)){
           backwardsMovement();
        } 
        
        if (Greenfoot.isKeyDown("space")){ // add stamina bar
           move(6);
        } 
        
    }
    
    /** User Defined */
    public void forwardMovement(){}
    
    /** User Defined */
    public void stationaryAnimation(){}
    
    /** User Defined */
    public void backwardsMovement(){}
    
    public void checkWorld(){
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
