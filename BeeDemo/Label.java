import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;
//import java.awt.Font;
/**
 * Label creates a label of with inputs for text, and font size. The label's color is black, but may be changed
 * with the setColor method.
 * 
 * @author Hogan Wrixon 
 * @version 4/22/2017
 */
public class Label extends Actor
{
    private GreenfootImage label;
    private String labelText = "";
    private int labelTextSize;
    private int labelTextStyle = 0;
    private String labelTextFont = "Arial";
    private Color labelColor = Color.BLACK;
    private Font labelFont = new Font(labelTextFont, labelTextSize);
    /**
     * Label returns a String and size.
     * @param text is a String displayed by the label.
     * @param textSize the font size for the text.
     */
    public Label(String text, int textSize)
    {
        labelText = text;
        labelTextSize = textSize;
        
        updateLabel();
    }
    
    /**
     * Act - do whatever the Lable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * sets the color of the label's text
     * @param color is of type color Color(int red, int green, int blue).
     */
    public void setTextColor(Color color)
    {
        label.clear();
        labelColor = color;
        updateLabel();
    }
    
    /**
     * sets the font and style.
     * @param style is the font and style for the label Font(String fontName, boolean bold, boolean italicize, int size).
     */
    public void setTextFont(String font, int fontStyle, int fontSize)
    {
        labelTextSize = fontSize;
        labelTextStyle = fontStyle;
        labelTextFont = font;
        label.clear();
        label.setFont(new Font(labelTextFont, labelTextSize));
        updateLabel();
    }
    
    public String toString()
    {
        return labelText;
    }
    
    public void setText(String text)
    {
        label.clear();
        labelText = text;
        updateLabel();
    }
    
    public void updateLabel()
    {
        
        label = new GreenfootImage((labelText.length()+1)*labelTextSize, labelTextSize + (labelTextSize/4));
       
        label.setFont(new Font(labelTextFont, labelTextSize));
        label.setColor(labelColor);
        label.drawString(labelText,labelText.length()*(labelTextSize/2), labelTextSize);
        
        setImage(label);
    }
}
