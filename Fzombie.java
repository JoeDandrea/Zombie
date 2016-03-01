import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fzombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fzombie extends AI{
    
    int imgIndex = 1;
    long anTime = 0;
    String image = "fasto_move_000";
    public boolean deleteMe = false;
    
    public void act(){
        move(2);
        randomTurn();
        zombieAnimate( image, 320 );
        checkWorld();
    }
    
    public void zombieAnimate( String img, int delay ){
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
    }
    
    public void remove(){
        if(deleteMe){
            getWorld().addObject(new Dead() , this.getX() , this.getY());
            getWorld().removeObject(this);
        }
    }
}
