package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    // variables

    // movement input verifiers
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    // methods

    //! keyTyped(e)
    @Override
    public void keyTyped(KeyEvent e) {
    }

    // check pressed key
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;

        } else if (code == KeyEvent.VK_A) {
            leftPressed = true;

        } else if (code == KeyEvent.VK_S) {
            downPressed = true;

        } else if (code == KeyEvent.VK_D) {
            rightPressed = true;

        }
    }

    // check released key
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;

        } else if (code == KeyEvent.VK_A) {
            leftPressed = false;

        } else if (code == KeyEvent.VK_S) {
            downPressed = false;

        } else if (code == KeyEvent.VK_D) {
            rightPressed = false;

        }
    }
    
}
