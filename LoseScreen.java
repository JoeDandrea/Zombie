import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseScreen extends World{

    int x = 1000;
    int y = 600;
    int level = 0 , marinesEaten = 0;
    
    /**
     * Constructor for objects of class LoseScreen.
     */
    public LoseScreen(int level , int me){
        super(1000, 600, 1); 
        this.level = level;
        this.marinesEaten = Zombie.marinesEaten;
        prepare();
    }
    
    public void prepare(){
        TextImage title = new TextImage("You died .. loser" , 50 );
        this.addObject(title , x/2 , y/3);
        
        TextImage leve = new TextImage( Integer.toString(level), 50 );
        this.addObject(leve , 450 , y/2);
        
        TextImage marine = new TextImage(Integer.toString(marinesEaten) , 50 );
        this.addObject(marine , 550 , y/2);
        
        WorldButton restart = new WorldButton("Restart" , 25 , new MyWorld());
        this.addObject(restart , 300 , y/2);
        
        WorldButton quit = new WorldButton("Quit" , 25 , new TitleScreen());
        this.addObject(quit , 700 , y/2);
        
    }
}
