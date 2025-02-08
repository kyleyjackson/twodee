package Main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

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
    final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL; // 768x576 pixels
    final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW; // ^

    Thread gameThread; // keeps me game runnin

    // constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black); // bgcol
        this.setDoubleBuffered(true); // improves rendering performance
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

    }
}
