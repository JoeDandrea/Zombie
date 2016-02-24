import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int pSpeed = setSpeed(4);
    int rotation = this.getRotation();
    long spTime = System.currentTimeMillis();
    long currTime = 0;
    long lcTime = 0;
    long lastFB = 0;
    int walkIndex = 0;
    int batCount = 0;
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null && mouse.getButton() == 1){
            if(batCount > 0 && System.currentTimeMillis() > lastFB + 500){
                shootAnimation();
                World world;
                world = getWorld();
                
                Fireball fb = new Fireball();
                fb.setRotation(getRotation() + 20);
                world.addObject(fb, getX(), getY());
                
                Fireball fb1 = new Fireball();
                fb1.setRotation(getRotation() + 40);
                world.addObject(fb1, getX(), getY());
                
                Fireball fb2 = new Fireball();
                fb2.setRotation(getRotation() + 60);
                world.addObject(fb2, getX(), getY());
                
                Fireball fb3 = new Fireball();
                fb3.setRotation(getRotation() + 80);
                world.addObject(fb3, getX(), getY());
                
                Fireball fb4 = new Fireball();
                fb4.setRotation(getRotation() - 20);
                world.addObject(fb4, getX(), getY());
                
                Fireball fb5 = new Fireball();
                fb5.setRotation(getRotation() - 40);
                world.addObject(fb5, getX(), getY());
                
                Fireball fb6 = new Fireball();
                fb6.setRotation(getRotation() - 60);
                world.addObject(fb6, getX(), getY());
                
                Fireball fb7 = new Fireball();
                fb7.setRotation(getRotation() - 80);
                world.addObject(fb7, getX(), getY());
                
                Fireball fb8 = new Fireball();
                fb8.setRotation(getRotation());
                world.addObject(fb8, getX(), getY());
                
                batCount--;
                lastFB = System.currentTimeMillis();
            }
            else if( System.currentTimeMillis() > lastFB + 500 ){
                shootAnimation();
                World world;
                world = getWorld();
                Fireball fb = new Fireball();
                fb.setRotation(getRotation());
                world.addObject(fb, getX(), getY());
                lastFB = System.currentTimeMillis();
            }
        }
        if(Greenfoot.isKeyDown("up") == false && System.currentTimeMillis() > lastFB + 300){
            this.setImage("pyro_stand_0001.png");
        }
        if(Greenfoot.isKeyDown("up")){
            move(pSpeed);
            walkAnimation();
        }
        if(Greenfoot.isKeyDown("left")  ){
            turn(-5);
        }
        if(Greenfoot.isKeyDown("right") ){
            turn(5);
        }
        if(Greenfoot.isKeyDown("down")  ){
            move(-pSpeed);
        }
        Actor battery;
        battery = getOneObjectAtOffset(0, 0, Battery.class);
        if(battery != null){
        World world;
        batCount += 5;
        world = getWorld();
        world.removeObject(battery);
        }
    }     
    public int setSpeed(int ss){
        int currentSpeed = ss;
        return currentSpeed;
    }
    public void walkAnimation(){
        if(System.currentTimeMillis() > lastFB + 300){
        if(walkIndex == 0   && lcTime < System.currentTimeMillis() - 175){
            lcTime = System.currentTimeMillis();
            this.setImage("pyro_move_0001.png");
            walkIndex++;
        }
        if(walkIndex == 1 && lcTime < System.currentTimeMillis() - 175){
            lcTime = System.currentTimeMillis();
            this.setImage("pyro_move_0002.png");
            walkIndex++;
        }
        if(walkIndex == 2 && lcTime < System.currentTimeMillis() - 175) {
            lcTime = System.currentTimeMillis();
            this.setImage("pyro_move_0003.png");
            walkIndex++;
        }
        if(walkIndex == 3 &&  lcTime < System.currentTimeMillis() - 175) {
            lcTime = System.currentTimeMillis();
            this.setImage("pyro_move_0004.png");
            walkIndex = 0;
        }
        }
    }
    public void shootAnimation(){
        this.setImage("pyro_attack_0001.png");
    }
    public int playerRotation(){
        return this.getRotation();
    }
}


