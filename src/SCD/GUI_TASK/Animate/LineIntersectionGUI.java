package SCD.GUI_TASK.Animate;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class LineIntersectionGUI extends JFrame {

    private int[][] lines;

    public LineIntersectionGUI(int[][] lines) {
        this.lines = lines;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Line Intersection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw lines and highlight based on intersection
                for (int i = 0; i < lines.length; i++) {
                    if (hasIntersection(lines, i)) {
                        g2d.setColor(Color.RED);
                    } else {
                        g2d.setColor(Color.GREEN);
                    }
                    g2d.setStroke(new BasicStroke(3));
                    drawLine(g2d, lines[i][0], lines[i][1], lines[i][2], lines[i][3]);
                }
            }
        };

        add(panel);

        setVisible(true);
    }

    private void drawLine(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.draw(new Line2D.Double(x1, y1, x2, y2));
    }

    private boolean hasIntersection(int[][] lines, int currentIndex) {
        for (int i = 0; i < lines.length; i++) {
            if (i != currentIndex && doIntersect(lines[currentIndex], lines[i])) {
                return true; // Lines intersect
            }

        }
        return false; // Lines do not intersect
    }

    private boolean doIntersect(int[] line1, int[] line2) {
        Line2D l1 = new Line2D.Double(line1[0], line1[1], line1[2], line1[3]);
        Line2D l2 = new Line2D.Double(line2[0], line2[1], line2[2], line2[3]);
        return l1.intersectsLine(l2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int[][] lines = {
                    // Intersecting lines
                    {50, 50, 200, 200},
                    {550, 200, 600, 150},
                    {700, 300, 750, 350},
                    {700, 350, 750, 300},

// Non-intersecting lines
                    {250, 50, 400, 200},
                    {250, 200, 400, 50},
                    {350, 100, 500, 250},
                    {750, 200, 800, 150},
                    {900, 300, 950, 350},
                    {900, 350, 950, 300},
                    {250, 400, 400, 550},
                    {250, 550, 400, 400},
                    {350, 500, 500, 650},
                    {750, 550, 800, 500}
            };

            new LineIntersectionGUI(lines);
        });
    }
}
