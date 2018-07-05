import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;
//import java.awt.Font;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private GreenfootImage button;
    
    private int textSize = 20;
    private String font = "Arial";
    private int fontStyle = 0;
    
    private int buttonWidth = 100;
    private int buttonHeight = 30;
    
    private Color buttonColor = new Color(180, 20, 20);
    private Color textColor = Color.WHITE;
    private Color borderColor = new Color(255, 255, 255, 0);
    
    private String text = "Button";
    
    public Button(String newText)
    {
        text = newText;
       
        updateButton();
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void updateButton()
    {
        button = new GreenfootImage(buttonWidth, buttonHeight);
        
        button.setColor(buttonColor);
        button.fillRect(0,0,buttonWidth, buttonHeight);
        
        button.setColor(borderColor);
        button.drawRect(0,0,buttonWidth-1, buttonHeight-1);
        
        button.setColor(textColor);
        button.setFont(new Font(font, textSize));
        button.drawString(text, (buttonWidth/2)-(text.length()*textSize/4), (buttonHeight/2)+(textSize/3));
        
        setImage(button);
    }
    
    public void setBackgroundColor(Color newColor)
    {
        buttonColor = newColor;
        updateButton();
    }
    
    public void setTextColor(Color newColor)
    {
        textColor = newColor;
        updateButton();
    }
    
    public void setTextFont(String newFont, int newFontStyle, int newFontSize)
    {
        font = newFont;
        fontStyle = newFontStyle;
        textSize = newFontSize;
        updateButton();
    }
    
    public void setBorderColor(Color newColor)
    {
        borderColor = newColor;
        updateButton();
    }
    
    public void setButtonWidth(int width)
    {
        buttonWidth = width;
        updateButton();
    }
    
    public void setButtonHeight(int height)
    {
        buttonHeight = height;
        updateButton();
    }
    
}
