import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Hogan Wrixon 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private int start;
    private int end;
    private int index;
    
    private int userStart;
    private int userEnd;
    private int userIndex;
    
    private int lastFlower = 0;
    private int beeNumber = 0;
    
    private boolean testBees = false;
    private boolean nextBee = true;
    
    private Label forLabel = new Label("for (int i =", 30);
    private Label endLabel = new Label(", i <= ", 30);
    private Label indexLabel = new Label(", i = i + ", 30);
    private Label forEndLabel = new Label(" ) ", 30);
    
    private Textbox startText = new Textbox(40);
    private Textbox endText = new Textbox(40);
    private Textbox indexText = new Textbox(40);
    
    private Button goButton = new Button("Go");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        initialize();
        setup();
        Greenfoot.start();
    }
    
    public void initialize()
    {
        addObject(forLabel, 50, 100);
        addObject(endLabel, 250, 100);
        addObject(indexLabel, 400, 100);
        addObject(forEndLabel, 540, 100);
        
        addObject(startText, 190, 100);
        addObject(endText, 330, 100);
        addObject(indexText, 500, 100);
        
        addObject(goButton, 530, 370);
    }
    
    public void setup()
    {
        start = Greenfoot.getRandomNumber(3);
        end = Greenfoot.getRandomNumber(3) + 7;
        index = Greenfoot.getRandomNumber(3) + 1;
        
        int j;
        for (j=0; j<start; j++)
        {
            addObject(new Cactus(), j*55 + 50, 300);
        }

        for (int i=0; i<10-start; i++)
        {
            int offset = start;
            if ((i%(index) == 0) && (i<=end)){
                addObject(new Flower(), i*55 + ((start+1)*50), 300);
                lastFlower = i+start;
            }
            else{
                addObject(new Cactus(), i*55 + ((start+1)*50), 300);
            }
        }
        end = lastFlower;
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(goButton)) {
            checkEquation();
        }
        
        if (testBees) {
            if (nextBee) {
                addObject(new Bee(beeNumber), 10, 200);
                nextBee = false;
            }
            testBees = false;
        }
    }
    
    public void checkEquation()
    {
        userStart = Integer.parseInt(startText.getText());
        userEnd = Integer.parseInt(endText.getText());
        userIndex = Integer.parseInt(indexText.getText());
        
        beeNumber = userStart;
        
        testBees = true;
    }
    
    public void setNextBee()
    {
        beeNumber += userIndex;
        if (beeNumber <= userEnd) {
            
            nextBee = true;
            testBees = true;
        }
    }
}
