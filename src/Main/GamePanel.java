package Main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This GamePanel class is an extension of the JPanel class (more method)
 */
public class GamePanel extends JPanel implements Runnable {
    
    // SCREEN SETTINGS
    final int ORIGINAL_TILE_SIZE = 16; // character tile size
    final int SCALE = 3; // scales characters to 48x48
    final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // displayed tile size
    final int MAX_SCREEN_COL = 16; // 4:3 resolution
    final int MAX_SCREEN_ROW = 12; // ^
    final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL; // 768px
    final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW; // 576px

    // KEY HANDLER
    KeyHandler key0 = new KeyHandler();

    // makes the game run
    Thread gameThread;

    // PLAYER DEFAULT POSITION
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    // FPS
    final int FPS = 60;

    // constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black); // bgcol
        this.setDoubleBuffered(true); // improves rendering performance
        this.addKeyListener(key0);
        this.setFocusable(true);
    }

    // methods

    // starts the game thread
    public void startGameThread() {
        gameThread = new Thread(this); // passing GamePanel into the Thread constructor
        gameThread.start(); // start!!
    }

    // gets called when gameThread is started
    // the game loop
    @Override
    public void run() {

        // Time restrictions (FPS LOCK)
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // FPS display
        long timer = 0;
        int drawCount = 0;

        // game loop
        while(gameThread != null) {
            //! System.out.println("Game is running...");

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval; // how much time has passed
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= 1) {
                update(); // #updated!
                repaint(); // calls paintComponent (weird)
                delta--;
                drawCount++;
            }     
            
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    // updates the information, but does not display it
    public void update() {
        if (key0.upPressed) {
            playerY -= playerSpeed;

        } else if (key0.downPressed) {
            playerY += playerSpeed;

        } else if (key0.leftPressed) {
            playerX -= playerSpeed;

        } else if (key0.rightPressed) {
            playerX += playerSpeed;

        }
    }

    // displays the update information
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D)g; // cast g to Graphics2D

        g2D.setColor(Color.white);
        g2D.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);
        g2D.dispose(); // saves memory
    }
}
