import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class nextLetter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class nextLetter extends Actor
{
    //pviate static final int X_SPACE = 5;//
    //private static final int CAPACITY = 30;//
    //private NextLetter nextLetter;//
    //private Letter[] letters;//
    //private int numLetters;//
    /**
     * Act - do whatever the nextLetter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
    }
}
