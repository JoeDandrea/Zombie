import greenfoot.*;
import java.awt.Color;
public class Button extends Inanimate {
    
    GreenfootImage gfi = null;
    int minX , maxX , minY , maxY;
    public GreenfootImage rGFI = null;
    
    /**
     * Constructor that creates a text image to be displayed.
     */
    public Button (String s , int size){
        gfi = new GreenfootImage(s,size,Color.BLACK, Color.WHITE , Color.BLACK);
        rGFI = new GreenfootImage(s,size,Color.WHITE, Color.BLACK , Color.WHITE);
        setImage(gfi);
    }
    
    /**
     * Constructor for buttons with images in storage
     */
    public Button(String imageFile){
        setImage(new GreenfootImage(imageFile));
    }
    
    /**
     * Constructor for buttons with preset images.
     */
    public Button(){}
    
    /**
     * Checks if this object has been clicked
     */
    public boolean isClicked(){
        if(this.getWorld()==null) return false;
            MouseInfo m = Greenfoot.getMouseInfo();
            if(m== null) return false;
            if (Greenfoot.mouseClicked(this) == false) return false;
            return true;
        }
    
    /**
     * Checks if this button is overlapped by the mouse.
     */
    public boolean isHiglighted(){
        if(this.getWorld()==null) return false;
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m == null) return false;
        maxX = this.getX() + gfi.getWidth()/2;  // central x value + 1/2 width
        minX = this.getX() - gfi.getWidth()/2;  // central x value - 1/2 width
        maxY = this.getY() + gfi.getHeight()/2; // central y value + 1/2 height
        minY = this.getY() - gfi.getHeight()/2; // central y value - 1/2 height
        int x = m.getX(); // current x value of the mouse 
        int y = m.getY(); // current y location of the mosue 
        if((x < maxX && x > minX) && (y < maxY && y > minY  )){
            // if the mouse is within the bounds of the button
            return true;
        }
        else return false;
    } 




}