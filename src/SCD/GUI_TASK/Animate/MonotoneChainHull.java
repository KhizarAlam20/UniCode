package SCD.GUI_TASK.Animate;


import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class MonotoneChainHull extends JPanel {

    private ArrayList<java.awt.Point> points;

    public MonotoneChainHull() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        points = new ArrayList<>(); // Initialize the points ArrayList

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                java.awt.Point p = new java.awt.Point(e.getX(), e.getY());
                points.add(p);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (points == null) {
            points = new ArrayList<>();
        }

        Graphics2D g2 = (Graphics2D) g;

        // Draw points
        for (java.awt.Point p : points) {
            g2.setColor(Color.BLUE);
            g2.fillOval(p.x - 2, p.y - 2, 4, 4);
        }

        // Draw hull
        if (points.size() > 2) {
            ArrayList<java.awt.Point> hull = monotoneChainHull(points);
            g2.setColor(Color.RED);
            for (int i = 0; i < hull.size(); i++) {
                java.awt.Point p1 = hull.get(i);
                java.awt.Point p2 = hull.get((i + 1) % hull.size());
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    private ArrayList<java.awt.Point> monotoneChainHull(ArrayList<java.awt.Point> points) {
        ArrayList<java.awt.Point> hull = new ArrayList<>();

        // Sort points by y-coordinate
        points.sort(Comparator.comparingInt((ToIntFunction<? super Point>) point1 -> (int) point1.getY()));

        // Find upper hull
        int m = 0;
        for (int i = 0; i < points.size(); i++) {
            while (m >= 2 && crossProduct(hull.get(m - 2), hull.get(m - 1), points.get(i)) > 0) {
                hull.remove(m - 1);
                m--;
            }
            hull.add(points.get(i));
            m++;
        }

        // Find lower hull
        m = 0;
        for (int i = points.size() - 1; i >= 0; i--) {
            while (m >= 2 && crossProduct(hull.get(m - 2), hull.get(m - 1), points.get(i)) < 0) {
                hull.remove(m - 1);
                m--;
            }
            hull.add(points.get(i));
            m++;
        }

        // Remove duplicates
        hull.sort(Comparator.comparingInt((ToIntFunction<? super Point>) point -> (int) point.getX()));
        for (int i = hull.size() - 1; i >= 1; i--) {
            if (hull.get(i).equals(hull.get(i - 1))) {
                hull.remove(i);
            }
        }

        return hull;
    }

    private int crossProduct(java.awt.Point p1, java.awt.Point p2, java.awt.Point p3) {
        return (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Monotone Chain Hull");
        frame.getContentPane().add(new MonotoneChainHull());
        frame.pack();
        frame.setVisible(true);
    }
}
