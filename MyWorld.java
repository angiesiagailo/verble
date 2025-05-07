import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World { 
    private String actualWord;
    
    private ArrayList <String> verbs = new ArrayList<>();
    private static final int ROWS = 6;
    private static final int COLUMNS = 5;
    private Letter[][] grid = new Letter[ROWS][COLUMNS];
    //insert whatever winSound below//
    private GreenfootSound winSound = new GreenfootSound("");
    private int currentCol=0;
    private int currentRow=0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() throws FileNotFoundException {    
        // Create a new world with 600x900 cells with a cell size of 1x1 pixels.
        super(800, 1200, 1); 
        setBackground(new GreenfootImage("VERBLE.jpg"));
        Letter a = new Letter('p',"grey");
        int i = Greenfoot.getRandomNumber(1001);
        beginGrid();
        insertVerbs();
        actualWord = getRandomVerb();
    }
    private void insertVerbs() throws FileNotFoundException {
        Scanner in = new Scanner (new FileReader ("verbs-with-5-letters.txt"));
        while (in.hasNext()){
            String v = in.next();  
            System.out.println(v);
            verbs.add(v);
        }
        System.out.println(verbs);
        in.close();
    }
    private String getRandomVerb(){
        return verbs.get(Greenfoot.getRandomNumber(verbs.size()));
    }
    //beginGrid is to initialize the grid//
    private void beginGrid(){
        for (int row = 0; row < ROWS; row++){
            for (int col = 0; col < COLUMNS; col++){
                grid[row][col] = new Letter('p',"grey");
                addObject(grid[row][col], 200 + col * 100, 270 + row * 100);
            }
        }
    }
    public void act(){
        if(Greenfoot.isKeyDown("enter")) {
            correctWord();
        } else {
            checkTyping();
        }
    }
    private void checkTyping(){
        String key = Greenfoot.getKey();
        if (key != null && key.length() == 1 && Character.isLetter (key.charAt(0))){
            if (currentCol < COLUMNS){
                grid[currentRow][currentCol].setLetter(key.toUpperCase().charAt(0));
                currentCol++;
            } 
        } else if (Greenfoot.isKeyDown("backspace") && currentCol > 0){
            currentCol--;
            grid[currentRow][currentCol].setLetter(' ');
        }
    }
    //check if it's the right word://
    private void correctWord(){
        String guessWord = "";
        for (int i = 0; i < COLUMNS; i++){
            if(guessWord.charAt(i)==actualWord.charAt(i)){
                grid[currentRow][i].setGreen();
            } else if (actualWord.contains(guessWord.charAt(i) + "")){
                grid[currentRow][i].setYellow();
            } else {
                grid[currentRow][i].setGrey();
            }
        }
    }
    private void winLoss(){
        String guessWord = "";
        if (guessWord.equals(actualWord)){
            winSound.play();
            Greenfoot.stop();
        }  else if (++currentRow==ROWS){
            Greenfoot.stop();
        } else {
            currentCol = 0;
        }
        }
    }