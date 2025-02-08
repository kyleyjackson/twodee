package Main;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Main {
        public static void main(String[] args) {
            JFrame window = new JFrame(); // create application window

            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false); // cant change window size (like windowed LoL)
            window.setTitle("twoodee"); // window title

            ImageIcon img = new ImageIcon("C:\\Users\\kyley\\Documents\\twodee\\src\\assets\\game_icon.png");
            window.setIconImage(img.getImage()); // set window icon

            GamePanel gamePanel = new GamePanel();
            window.add(gamePanel);

            window.pack();

            window.setLocationRelativeTo(null);
            window.setVisible(true);
        }
}
