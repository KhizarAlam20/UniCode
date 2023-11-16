package SCD.GUI_TASK.Animate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JFrame {

    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 400;

    private int x1, y1, x2, y2;
    private int lineAlpha;

    public MyPanel() {
        // Set up the frame
        setTitle("Line Animation Example");
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up initial points and alpha value
        x1 = 50;
        y1 = 50;
        x2 = 350;
        y2 = 350;
        lineAlpha = 255; // Initial alpha value for line transparency

        // Create a timer for animation
        Timer timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update line transparency
                lineAlpha -= 5;
                if (lineAlpha < 0) {
                    lineAlpha = 0;
                    ((Timer) e.getSource()).stop(); // Stop the timer when the line disappears
                }
                repaint(); // Trigger paintComponent
            }
        });

        // Start the timer
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw the line with the current transparency
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0, 0, 0, lineAlpha));
        g2d.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyPanel example = new MyPanel();
                example.setVisible(true);
            }
        });
    }
}
