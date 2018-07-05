import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * TextBox defines a box to type in a line of text that can be retrieved by another method. 
 * Modified from code created by DanPost.
 * 
 * @author Hogan Wrixon
 * @version 4/22/2017
 */
public class Textbox extends Actor
{
    private static Textbox focusOn;
    
    private int boxWidth;
    private int boxHeight = 30;
    
    private String text = "";
    private String promptText;
    private GreenfootImage image;
    //private boolean firstTimeThrough = false;
    
    private Color backgroundColor = Color.WHITE;
    private Color borderColor = Color.BLACK;
    private Color textColor = Color.BLACK;
    
    private String font = "Arial";
    private int fontStyle = 0;
    private int fontSize = 18;
    
    public Textbox(int inWidth)
    {
        text = "";
        boxWidth = inWidth;
        updateImage();
    }
    
    public Textbox(int inWidth, String inText)
    {
        text = inText;
        promptText = inText;
        boxWidth = inWidth;
        updateImage();
    }
      
    public Textbox(int inWidth, int inHeight, String inText)
    {
        text = inText;
        promptText = inText;
        boxWidth = inWidth;
        boxHeight = inHeight;
        updateImage();
    }
    
     /**
     * updates the text area image setting up the background rectangle, the border and the textbox.
     * this is called after any changes are made to the text area.
     */
    private void updateImage()
    {
        // draw the border of the text box.
        image = new GreenfootImage(boxWidth, boxHeight);
        image.setColor(backgroundColor);
        image.fillRect(0,0,boxWidth - 1, 29);
        
        image.setColor(borderColor);
        image.drawRect(0,0,boxWidth - 1, 29);
        
        //if (text.length() == 0) {
        //    firstTimeThrough = true;
        //    text = promptText;
        //}
        
        // Show the text being typed in the text box.
        image.setFont(new Font(font, fontSize));
        //image.setColor(textColor);

        /*
        if (firstTimeThrough) {
            image.setColor(new Color(200, 200, 200));
        }
        else {
            image.setColor(textColor);
        }
        */
        image.drawString(text,5, 22);
        
        setImage(image);
    }
  
     /**
     * take the characters typed into the keyboard and put them into the String text when the texbox
     * is clicked on and the focus is on this object.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            while(Greenfoot.getKey() != null);
            focusOn = this;
            /*
            if (firstTimeThrough) {
                firstTimeThrough = false;
                text = "";
            }
            */
        }
        if (focusOn == this)
        {
            if (Greenfoot.mouseClicked(null) && !Greenfoot.mouseClicked(this))
            {
                focusOn = null;
                return;
            }
            String key = Greenfoot.getKey();
            if (key == null) 
                return;
            if ("enter".equals(key) && text.length() > 0) 
                return;
            if ("backspace".equals(key) && text.length() > 0) 
                text = text.substring(0, text.length() - 1);
            if ("escape".equals(key)) 
                text = "";
            if ("space".equals(key)) 
                key = " ";
            if (key.length() == 1 && text.length() < boxWidth/8) 
                text += key;
            updateImage();
        }
    }
    
    /**
     * sets the background color to newBackgroundColor
     * @param newBackgroundColor the new color for the background.
     */
    public void setBackgroundColor(Color newBackgroundColor)
    {
        backgroundColor = newBackgroundColor;
        updateImage();
    }
     
    /**
     * sets the border color to newBorderColor
     * @param newBorderColor the new color for the border of the TextBox.
     */
    public void setBorderColor(Color newBorderColor)
    {
        borderColor = newBorderColor;
        updateImage();
    }
    
    /**
     * sets the font color to newFontColor.
     * @param newFontColor sets the font of the TextBox to the new font Color.
     */
    public void setTextColor(Color newFontColor)
    {
        textColor = newFontColor;
        updateImage();
    }
    
    /**
     * sets the new font, font style, and fontSize for the TextBox.
     * @param font new font family
     * @param fontStyle new font style regular, bold, italics
     * @param fontSize new font size.
     */
    public void setTextFont(String newFont, int newFontStyle, int newFontSize)
    {
        font = newFont;
        fontStyle = newFontStyle;
        fontSize = newFontSize;
        
        updateImage();
    }
    
    /**
     * sets the width of the TextBox
     * @param newWidth the new width for the TextBox.
     */
    public void setWidth(int newWidth)
    {
        boxWidth = newWidth;
        updateImage();
    }
    
    /**
     * sets the Height of the TextBox
     * @param newHeight the new height for the TextBox
     */
    public void setHeight(int newHeight)
    {
        boxHeight = newHeight;
        updateImage();
    }
    
    /**
     * returns the text typed into the TextBox
     * @return text returns the text typed into the TextBox
     */
    public String getText()
    {
        return text;
    }
    
    public void setText(String newText)
    {
        text = newText;
        updateImage();
    }
}
