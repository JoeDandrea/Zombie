import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pyro extends User{
    private int    pSpeed    = setSpeed(4);
    private int    rotation  = this.getRotation();
    private long   spTime    = System.currentTimeMillis();
    private long   currTime  = 0;
    private long   lcTime    = 0;
    private long   lastFB    = 0;
    private int    walkIndex = 0;
    public int     batCount  = 0;
    public boolean deleteMe  = false;
    
    public Pyro(int controls){
        super(controls);
    }
    
    public void act() {
        shoot();
        checkKeyPress();
        remove();
    }
    
    public void shoot(){
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
    }
    
    public int setSpeed(int ss){
        int currentSpeed = ss;
        return currentSpeed;
    }
    
    public void forwardMovement(){
        move(pSpeed);
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
    
    public void backwardsMovement(){
        move(-5);
    }
    
    public void shootAnimation(){
        this.setImage("pyro_attack_0001.png");
    }
    
    public int playerRotation(){
        return this.getRotation();
    }
    
    public void remove(){
        if(deleteMe){
            int x = this.getX();
            int y = this.getY();
            //getWorld().removeObject(zombie);
            //ZombieGuts zg1 = new ZombieGuts();
            //getWorld().addObject( zg1 ,x, y);b
            getWorld().removeObject(this);
        }
    }
}


