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
import java.util.Random;

/**
 *
 * @author elmar0022
 */


// make sure you rename this class if you are doing a copy/paste
public class better2048 extends JPanel{

    private Tile[] myTiles;
    boolean Win = false;
    boolean Lose = false;
    int Score = 0;
    
    
    boolean needAddTile = false;
    boolean Full = false;
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
        for(int y = 0; y < 4; y++){
            for(int x = 0; x < 4; x++){
                drawTile(g, myTiles[x + y * 4], x, y);
            }
        }
        
    }
    
    private void drawTile(Graphics g2, Tile tile, int x, int y){
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROEK_NORMALIZE);
        
        int value = tile.value;
        int xOffset = offsetCoors(x);
        int yOffset = offsetCoors(y);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(xOffset, yOffset, 65, 65, 14, 14);
        
        g.setColor(Color.BLACK);
        
    
    
    
    }
        
        
        g.setFont(font);
        //score
        g.setColor(Color.BLACK);
        g.drawString("Score:" + Score , 140, 350);
        //game name

        g.fillRoundRect(20, 310, 100, 70, 10, 10);
        g.setColor(Color.GRAY);
        g.drawString("2048", 38, 352);
        
        
        //empty tiles
//        g.setColor(Color.LIGHT_GRAY);
        //first row of tiles
//        g.fillRoundRect(10, 10, TileWidth, TileHeight, 10, 10);
//        g.fillRoundRect(85, 10, TileWidth, TileHeight, 10, 10);
//        g.fillRoundRect(160, 10, TileWidth, TileHeight, 10, 10);
 //       g.fillRoundRect(235, 10, TileWidth, TileHeight, 10, 10);
        //second row of tiles
  //      g.fillRoundRect(10, 85, TileWidth, TileHeight, 10, 10);
 //       g.fillRoundRect(85, 85, TileWidth, TileHeight, 10, 10);
//        g.fillRoundRect(160, 85, TileWidth, TileHeight, 10, 10);
//        g.fillRoundRect(235, 85, TileWidth, TileHeight, 10, 10);
        //third row of tiles
//        g.fillRoundRect(10, 160, TileWidth, TileHeight, 10, 10);
//        g.fillRoundRect(85, 160, TileWidth, TileHeight, 10, 10);
//        g.fillRoundRect(160, 160, TileWidth, TileHeight, 10, 10);
//        g.fillRoundRect(235, 160, TileWidth, TileHeight, 10, 10);
        //fourth row of tiles
//        g.fillRoundRect(10, 235, TileWidth, TileHeight, 10, 10);
 //       g.fillRoundRect(85, 235, TileWidth, TileHeight, 10, 10);
//        g.fillRoundRect(160, 235, TileWidth, TileHeight, 10, 10);
//        g.fillRoundRect(235, 235, TileWidth, TileHeight, 10, 10);

        //2D array setup
        
//        b[0][0] = 2;
//        for(int j = 0; j < b.length; j++)
//            for(int i = 0; i <b[j].length; i++){
//                g.setColor(Color.BLUE);
//                int x = TileGap + (TileGap + TileWidth) * i;
//               int y = TileGap + (TileGap + TileHeight) * j;                
//                g.fillRect(TileGap + (TileGap + TileWidth) * i, TileGap + (TileGap + TileHeight) * j, TileWidth, TileHeight);
                
                
//                if(b[j][i] == 2){
                    //tile
//                    double power = Math.log(b[j][i])/Math.log(2);
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
            public static void Tile(String[] args)
            {
                //the tile spots array
                xs = new ArrayList<Integer>();
                ys = new ArrayLost<Integer>();
                
                //when spots are empty
                for(int j 0; j < b.length; j++)
                for(int i = 0; i < b[j].length; i++)
                
                //if sports are empty, add them to the array 
                if(b[j][i] == 0)
                {
                    xs.add(i);
                    ys.add(j);
                }
                
                //int [][] grid = new int [xs][ys]; 
                
                //generate a random number
                Random rndm = new Random();
                int rndm = (int)random(0, xs.size())
                y = ys.get(rndm);
                x = xs.get(rndm);
                
                //make sure the generated number is only either 2 or 4
                b[y][x] = random(0, 1) < 0.9 ? 2 : 4;

                
                
                //fill the tiles
                
                
                
                
                int 
               
                
                
            }
            
            
            


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

//COMMENT HERE AND DOWN
    private void moveTiles(Direction dir){
        boolean canMove = false;
        int horisontalDirection = 0;
        int verticalDirection = 0;
        
        if(dir == Direction.LEFT){
            horizontalDirection = -1;
            for(int i = 0; 0 < xs.size; i++)
            {
                for(int j = 0; j < ys.size; j++){
                    if(!canMove){
                        canMove = move(xs, ys, horizontalDirection, verticalDirection, dir);
                    }
                    else{
                        move(xs, ys, horizontalDirection, verticalDirection, dir);
                    }
                }
            }
        }
        if(dir == Direction.RIGHT){
            horizontalDirection = 1;
            for(int i = 0; 0 < xs.size; i++)
            {
                for(int j = ys - 1; j >= 0; j--){
                    if(!canMove){
                        canMove = move(xs, ys, horizontalDirection, verticalDirection, dir);
                    }
                    else{
                        move(xs, ys, horizontalDirection, verticalDirection, dir);
                    }
                }
            }
        }
        if(dir == Direction.DOWN){
            verticalDirection = 1;
            for(int i = 0; 0 < xs.size; i++)
            {
                for(int j = 0; j < ys.size; j++){
                    if(!canMove){
                        canMove = move(xs, ys, horizontalDirection, verticalDirection, dir);
                    }
                    else{
                        move(xs, ys, horizontalDirection, verticalDirection, dir);
                    }
                }
            }
        }
        if(dir == Direction.UP){
            verticalDirection = -1;
            for(int i = 0; 0 < xs.size; i++)
            {
                for(int j = 0; j < ys.size; j++){
                    if(!canMove){
                        canMove = move(xs, ys, horizontalDirection, verticalDirection, dir);
                    }
                    else{
                        move(xs, ys, horizontalDirection, verticalDirection, dir);
                    }
                }
            }
        }
    }
    //COMMENT HERE AND UP
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        if(Keyboard.typed(KeyEvent.VK_LEFT)){
            moveTiles(Direction.LEFT);
        }
        if(Keyboard.typed(KeyEvent.VK_RIGHT)){
            moveTiles(Direction.RIGHT);
        }
        if(Keyboard.typed(KeyEvent.VK_DOWN)){
            moveTiles(Direction.DOWN);
        }
        if(Keyboard.typed(KeyEvent.VK_UP)){
            moveTiles(Direction.UP);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        //resetting the game
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            resetGame;
        }
        //losing the game
        if(!canMove()){
            Lose = true;
        }
        
        //while the game is going on, activate the left right up and down buttons to move the tiles
        if(!Win && !Lose){
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_LEFT:
                    left();
                case KeyEvent.VK_RIGHT:
                    right();
                case KeyEvent.VK_UP:
                    up();
                case KeyEvent.VK_DOWN:
                    down();
            }
    }
    //if player cant make any more moves, they lose
    if(!Win && !canMove())
    {
        Lose = true;
        resetGame;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    //when tresetGame happens, turn everything back to original positions and values
    public void resetGame(){
        Score = 0;
        Win = false;
        Lose = false;
        myTiles = new Tile[4][4];
        //OR myTiles = new Tile[4 * 4]
        
        for(int i = 0; i < myTiles.length; i++){
            myTiles[i] = new Tile();
        }
        addTile();
        addTile();
        
        
    }
    //when left key is pressed 
    public void left(){
        boolean needAddTile = false;
        for(int i = 0; i < 4; i++){
            Tile[] line = getLine(i);
            Tile[] merged = mergeLine(moveLine(line));
            setLine(i, merged);
            
            if(!needAddTile && !compare(line, merged)){
                needAddTile = true;
            }
        }
        
        if(needAddTile){
            addTile();
        }
    }
    //if moving right, just do left actions but rotating to make a right dirrection effect
    public void right(){
        myTiles = rotate(180);
        left();
        myTiles = rotate(180);
    }
    
    public void up(){
        myTiles = rotate(270);
        left;
        myTiles = rotate(90);
    }
    
    public void down(){
        myTiles = rotate(90);
        left();
        myTiles = rotate(270);
    }
    
    //positioning the tile places on the game board
    private Tile tileposition(int x, int y){
        return myTiles[x + y * 4];
    }
    
    //adding tiles only in empty spaces
    private void addTile(){
        List<Tile> list = availableSpace();
        if(!availableSpace().isEmpty()){
            int index = (int) (Math.random() * list.size()) % list.size();
            Tile emptyTime = list.get(index);
            emptyTime.value = Math.random() < 0.9 ? 2 : 4;
        }
    }
    
    //initializing availablespace
    private List<Tile> availableSpace(){
        final List<Tile> list = new ArrayList<Tile>(16);
        
        for(Tile t : myTiles){
            if((t.isEmpty()){
                list.add(t);
            }
    }
    return list;
    }
    
    //saying that being full is having no available space
    private boolean Full(){
        return availableSpace().size() == 0;
    }
    
    //being able to move -- when where and how
    boolean canMove(){
        if(!Full()){
            return true;
        }
        
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 4; y++){
                Tile t = tileposition(x, y);
                
                if((x < 3 && t.value == tileposition(x + 1, y).value)
                || ((y < 3) && t.value == tileposition(x, y + 1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean compare(Tile[] line1, Tile[] line2){
        if(line1 == line2){
            return true;
        }else if(line1.length != line2.length){
            return false;
        }
        
        for(int i = 0; i < line1.length; i++){
            if(line1[i].value != line2[i].value){
                return false;
            }
        }
        return true;
    }
    
    
    private Tile[] rotate(int angle){
        Tile[] newTiles = new Tile[4 * 4];
        int offsetX = 3;
        int offsetY = 3;
        if(angle == 90){
            offsetY = 0;
        }else if(angle == 270){
            offsetX = 0;
        }
        
        double rad = Math.toRadians(angle);
        int cos = (int) Math.cos(rad);
        int sin = (int) Math.sin(rad);
        
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 4; y++){
                int newX = (x * cos) - (y * sin) + offsetX;
                int newY = (x * sin) + (y * cos) + offsetY;
                newTiles[(newX) + (newY) * 4] = tileposition(x, y);
            }
        }
        return newTiles;
    }
    
    private Tile[] moveLine(Tile[] oldLine){
        LinkedList<Tile> 1 = new LinkedList<Tile>();
        for(int i = 0; i < 4; i++){
            if(!oldLine[i].isEmpty())
            1.addLast(oldLine[i]);
        }
        if(1.size() == 0){
            return oldLine;
        }else{
            Tile[] newLine = new Tile[4];
            ensureSize(1, 4);
            for(int i = 0; i < 4; i++){
                newLine[i] = 1.removeFirst();
            }
            return newLine;
        }
    }
    
    private Tile[] mergeLine(Tile[] old Line){
        LinkedList<Tile> list = new LihnkedList<Tile>();
        for(int i = 0; i < 4 && !oldLine[i].isEmpty(); i++){
            int num = oldLine[i].value;
            if(i < 3 && oldLine[i].value == oldLine[i + 1].value){
                num*= 2;
                Score += num;
                int Target = 2048;
                if(num == Target){
                    Win = true;
                }
                i++
            }
            list.add(new Tile(num));
        }
        if(list.size() == 0){
            return oldLine;
        }else {
            ensureSize(list, 4);
            return list.toArray(newTile[4]);
        }
    }
    
    
    private static void ensureSize(java.util.List<Tile> 1, int s){
        while(1.size() != s){
            1.add(new Tile());
        }
    }
    
    
    private Tile[] getLine(int index){
        Tile[] result = new Tile[4];
        for(int i = 0; i < 4; i++){
            reslut[i] = tileposition(i, index);
        }
        return result
    }
    
    
    private void setLine(int index, Tile[] re){
        System.arraycopy(re, 0, myTiles, index * 4, 4);
    }
    
    
    
    
    


}
