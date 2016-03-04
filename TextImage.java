import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class TextImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextImage extends Markers
{
    public TextImage(String s , int size ){
        setImage(new GreenfootImage(s,size,Color.BLACK, Color.WHITE , Color.BLACK));
    }
    
    public void act(){}    
}
