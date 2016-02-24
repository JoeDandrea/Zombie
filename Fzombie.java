import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fzombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fzombie extends Actor
{
    int imgIndex = 1;
    long anTime = 0;
    String image = "fasto_move_000";
    public void act() 
    {
        move(2);
        if(Greenfoot.getRandomNumber(200) < 10){
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        zombieAnimate( image, 320 );
        checkBounds();
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
    public void checkBounds(){
        if(getX() >= 559){
            turn(180);
        }
        if(getY() >= 559){
            turn(180);
        }
        if(getY() <= 1){
            turn(180);
        }
        if(getX() <= 1){
            turn(180);
        }
    }
}
