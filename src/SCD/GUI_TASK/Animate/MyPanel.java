package SCD.GUI_TASK.Animate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {

    // Panel dimensions
    final int PANEL_WIDTH = 420;
    final int PANEL_HEIGHT = 420;

    // Image
    ImageIcon enemy;
    Image backgroundImage;

    // Speed
    int xVelocity = 1;
    int yVelocity = 1;

    // Location
    int x = 0;
    int y = 0;

    // Timer
    Timer timer;

    public MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(new Color(252, 243, 126));


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("devil.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
       enemy = new ImageIcon(i2);

        // Create a timer to repaint the panel periodically
        timer = new Timer(1, this); // 10 milliseconds
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(enemy.getImage(), x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Move the image

        if(x>=PANEL_WIDTH-enemy.getIconWidth() || x<0){
          xVelocity *= -1;
        }
        if(y>=PANEL_HEIGHT-enemy.getIconHeight() || x<0){
            yVelocity *= -1;
        }
        x += xVelocity;
        y += yVelocity;


        // Repaint the panel to update the image's position
        repaint();
    }
}