import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    private int position = 3;
    private boolean toFlower = true;
    private boolean moveDown = false;
    private boolean checkFlower = false;
    private boolean die = false;
    private boolean done = false;
    
    public Bee(int pos)
    {
        getImage().scale(40, 25);
        position = pos + 1;
    }
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!done) {
            if (toFlower && getX() < position * 54) {
                move(position);
            }
            else if (toFlower && getX() >= position * 54) {
                setRotation(90);
                toFlower = false;
                moveDown = true;
            }
            if (moveDown && getY() < 300) {
                move(position);
            }
            else if (getY() >= 300) {
                checkFlower = true;
                moveDown = false;
            }
            if (checkFlower) {
                if (isTouching(Cactus.class)){
                    die = true;
                    setRotation(180);
                }
                else if (isTouching(Flower.class)){
                    done = true;
                    setRotation(0);
                    getWorldOfType(MyWorld.class).setNextBee();
                }
                checkFlower = false;
                
            }
            if (die && getY()<390) {
                setLocation(getX(), getY()+2);
            }
            else if (getY() >= 390){
                die = false;
                done = true;
                getWorldOfType(MyWorld.class).setNextBee();
            }
        }
    }    
}
