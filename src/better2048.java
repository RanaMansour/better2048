/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author elmar0022
 * lll
 */


// make sure you rename this class if you are doing a copy/paste
public class better2048 extends JComponent implements KeyListener, Runnable{

    boolean Win = false;
    boolean Lose = false;
    boolean set = false;
    
    boolean needAddTile = false;
    boolean isFull = false;
    private int value;
    
    //background variables
    int BGXS = 0;
    int BGXE = 345;
    int BGYS = 0;
    int BGYE = 393;
    int TileWidth = 65;
    int TileHeight = 65;
    int TileSpeed = 10;
    int text = value;
    private Font Arial;

    
    int[][] b = new int [4][4];
    
    int Score = 0;
    boolean lose = false;        


    

    
    
    
    //Tile characteristics
    public static class Tile {
            int x;
            int y;
            int value;
            
        public Tile(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
            
            
            
        }
    }
    
    // Height and Width of our game
    static final int WIDTH = 310;
    static final int HEIGHT = 393;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;

    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing

    Color for2 = new Color(243, 196, 245);
    Color for4 = new Color(201, 245, 154);
    Color for8 = new Color(188, 247, 244);
    Color for16 = new Color(245, 122, 131);
    Color for32 = new Color(211, 154, 237);
    Color for64 = new Color(245, 245, 135);
    Color for128 = new Color(255, 23, 23);

    Color mypink = new Color(153, 57, 108);
    Font font = new Font("Arial", Font.PLAIN, 30);
    int TileGap = 10;
    
    
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        


        g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.setFont(font);
        //score
        g.setColor(Color.BLACK);
        g.drawString("Score:" + Score , 140, 350);
        //game name

        g.fillRoundRect(20, 310, 100, 70, 10, 10);
        g.setColor(Color.GRAY);
        g.drawString("2048", 38, 352);
        
        
        //empty tiles
        g.setColor(Color.LIGHT_GRAY);
        //first row of tiles
        g.fillRoundRect(10, 10, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(85, 10, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(160, 10, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(235, 10, TileWidth, TileHeight, 10, 10);
        //second row of tiles
        g.fillRoundRect(10, 85, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(85, 85, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(160, 85, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(235, 85, TileWidth, TileHeight, 10, 10);
        //third row of tiles
        g.fillRoundRect(10, 160, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(85, 160, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(160, 160, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(235, 160, TileWidth, TileHeight, 10, 10);
        //fourth row of tiles
        g.fillRoundRect(10, 235, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(85, 235, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(160, 235, TileWidth, TileHeight, 10, 10);
        g.fillRoundRect(235, 235, TileWidth, TileHeight, 10, 10);

        //2D array setup
        
        b[0][0] = 2;
        for(int j = 0; j < b.length; j++)
            for(int i = 0; i <b[j].length; i++){
//                g.setColor(Color.BLUE);
                int x = TileGap + (TileGap + TileWidth) * i;
                int y = TileGap + (TileGap + TileHeight) * j;                
//                g.fillRect(TileGap + (TileGap + TileWidth) * i, TileGap + (TileGap + TileHeight) * j, TileWidth, TileHeight);
                
                
                if(b[j][i] == 2){
                    //tile
                    double power = Math.log(b[j][i])/Math.log(2);
                    g.setColor(for2);
//                    g.fillRect(i, i, i, text);
                    //number
                    g.setColor(Color.BLACK);
                    
                    g.drawString(""+b[j][i], x+23 , y+43);
                }
                if(b[j][i] == 4){
                    //tile
                    double power = Math.log(b[j][i])/Math.log(4);
                    g.setColor(for4);
                    g.fillRect(i, i, i, text);
                    //the number in the tile
                    g.setColor(Color.BLACK);
                    g.drawString(""+b[j][i], x, y);
                }
                if(b[j][i] == 8){
                    //tile
                    double power = Math.log(b[j][i])/Math.log(8);
                    g.setColor(for8);
                    g.fillRect(i, i, i, text);
                    //the number in the tile
                    g.setColor(Color.BLACK);
                    g.drawString(""+b[j][i], x, y);
                }
                
                if(b[j][i] == 16){
                    //tile
                    double power = Math.log(b[j][i])/Math.log(16);
                    g.setColor(for16);
                    g.fillRect(i, i, i, text);
                    //the number in the tile
                    g.setColor(Color.BLACK);
                    g.drawString(""+b[j][i], x, y);
                }
            }        


        
        // GAME DRAWING ENDS HERE
    }
    
    
    // The main game loop
    // In here is where all the logic for my game will go

        public void run()
    {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            


            // GAME LOGIC ENDS HERE 

            
            
            // update the drawing (calls paintComponent)
            repaint();
            
            
            
            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if(deltaTime > desiredTime)
            {
                //took too much time, don't wait
            }else
            {
                try
                {
                    Thread.sleep(desiredTime - deltaTime);
                }catch(Exception e){};
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");
       
        // instance of my game
        better2048 game = new better2048();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        // adds the game to the window
        frame.add(game);
        
        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        frame.addKeyListener(game);
        
        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        for(int i = 0; 1 < 4; i++){
//            if(i == 0)
//                }
//    }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
