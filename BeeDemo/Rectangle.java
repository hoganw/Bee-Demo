import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;
/**
 * Write a description of class Rectangle here.
 * 
 * @author Hogan Wrixon 
 * @version 9/15/17
 */
public class Rectangle extends Actor
{
    private Color color = new Color(0,0,0);
    private Color borderColor = new Color(0,0,0);
    private int width = 10;
    private int height = 10;
    GreenfootImage rectangle;
    public Rectangle(int newWidth, int newHeight, Color newColor)
    {
        color = newColor;
        width = newWidth;
        height = newHeight;
        update();
    }
    
    public void update()
    {
        rectangle = new GreenfootImage(width+1, height+1);
        rectangle.setColor(color);
        rectangle.fillRect(0,0,width,height);
        
        rectangle.setColor(borderColor);
        rectangle.drawRect(0,0,width,height);
        
        setImage(rectangle);
    }
    
    public void setColor(Color newColor)
    {
        color = newColor;
        update();
    }
    
    public void setBorderColor(Color newColor)
    {
        borderColor = newColor;
        update();
    }
    
    /**
     * Act - do whatever the Rectangle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
