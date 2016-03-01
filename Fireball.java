import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Projectiles
{
    long anTime = 0;
    int imgIndex = 1;
    long spTime = System.currentTimeMillis();
    int x = 0;
    String image = "ffireball_000";
    public void act() 
    {
        if(getWorld() == null){
            return;
        }
        fireAnimation(image, 25);
        while( x < 15){
            pathFix();
            x++;
        }
        eat();
        move(7);
        checkBounds();
    }
    public void fireAnimation( String img, int delay )
    {
            if(imgIndex == 1 && anTime < System.currentTimeMillis() - delay){
                anTime = System.currentTimeMillis();
                this.setImage("ffireball_000" + imgIndex + ".png");
                imgIndex++;
            }
            if(imgIndex == 2 && anTime < System.currentTimeMillis() - delay){
                anTime = System.currentTimeMillis();
                this.setImage("ffireball_000" + imgIndex + ".png");
                imgIndex++;
            }
            if(imgIndex == 3 && anTime < System.currentTimeMillis() - delay) {
                anTime = System.currentTimeMillis();
                this.setImage("ffireball_000" + imgIndex + ".png");
                imgIndex++;
            }
            if(imgIndex == 4 &&  anTime < System.currentTimeMillis() - delay) {
                anTime = System.currentTimeMillis();
                this.setImage("ffireball_000" + imgIndex + ".png");
                imgIndex++;
            }
            if(imgIndex == 5 &&  anTime < System.currentTimeMillis() - delay) {
                anTime = System.currentTimeMillis();
                this.setImage("ffireball_000" + imgIndex + ".png");
                imgIndex++;
            }
            if(imgIndex == 5 &&  anTime < System.currentTimeMillis() - delay) {
                anTime = System.currentTimeMillis();
                this.setImage("ffireball_000" + imgIndex + ".png");
                imgIndex = 1;
            }
    }
    public void checkBounds(){
        if(getX() >= 559){
            getWorld().removeObject(this);
            return;
        }
        if(getY() >= 559){
            getWorld().removeObject(this);
            return;
        }
        if(getY() <= 1){
            getWorld().removeObject(this);
            return;
        }
        if(getX() <= 1){
            getWorld().removeObject(this);
            return;
        }
    }
    public void pathFix(){
        //while(System.currentTimeMillis() > spTime + 125){
        double r = (90 - (this.getRotation())) * (Math.PI/180);
        double x = getX();
        double y = getY();
        double xPrime = 0;
        double yPrime = 0;
        for(int z = 0; z < 4; z++){
            xPrime = x + ( 5 * Math.sin(r));
            yPrime = y + ( 5 * Math.cos(r));
            /*double xPrime = (x + Math.sin(r));
            double yPrime = (y + Math.cos(r));*/
            this.setLocation((int)xPrime, (int)yPrime);
            //
        }
    }
    public void eat(){
        Actor zombie;
        zombie = getOneObjectAtOffset(0, 0, Zombie.class);
        if(zombie != null){
            int x = zombie.getX();
            int y = zombie.getY();
            //world.removeObject(zombie);
            ZombieGuts zg1 = new ZombieGuts();
            getWorld().addObject( zg1 ,x, y);
            
            getWorld().removeObject(zombie);
        }
    }
}
