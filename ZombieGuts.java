import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZombieGuts here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieGuts extends Markers {
    
    String image = "splatter_1_000";
    int imgIndex = 1;
    long anTime = 0;
    long startTime = System.currentTimeMillis();
    
    public void act(){
        animateGore(image, 100);
    }
    
    public void animateGore(String img, int delay){
        if(imgIndex == 1 && anTime < System.currentTimeMillis() - delay){
            anTime = System.currentTimeMillis();
            this.setImage(img + imgIndex + ".png");
            imgIndex++;
        }
        if(imgIndex == 2 && anTime < System.currentTimeMillis() - delay){
            anTime = System.currentTimeMillis();
            this.setImage(img + imgIndex + ".png");
            imgIndex++;
        }
        if(imgIndex == 3 && anTime < System.currentTimeMillis() - delay) {
            anTime = System.currentTimeMillis();
            this.setImage(img + imgIndex + ".png");
            imgIndex++;
        }
        if(imgIndex == 4 &&  anTime < System.currentTimeMillis() - delay) {
            anTime = System.currentTimeMillis();
            this.setImage(img + imgIndex + ".png");
            imgIndex = 1;
        }
        if(startTime < System.currentTimeMillis() - 700){
            getWorld().removeObject(this);
        }
    }
}
