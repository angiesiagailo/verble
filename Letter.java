import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Letter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Letter extends Actor{
    private GreenfootImage image;
    private String letter = "";
    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Letter(char c, String color){
        setImage(color+"_"+c+".png");
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 50, image.getHeight() - 100);
        setImage(image);
        }
    public void setLetter(char c){
        letter = "" + c;
        GreenfootImage image = new GreenfootImage(letter);
        setImage(image);
    }
    public void setGreen(){
        setImage(new GreenfootImage("green_h.png"));
    }
    public void setYellow(){
        setImage(new GreenfootImage("yellow_h.png"));
    }
    public void setGrey(){
        setImage(new GreenfootImage("grey_h.png"));
        
    }  
    }
