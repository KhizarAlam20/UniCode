package SCD.GUI_TASK.Animate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class QuickHullApp extends JFrame {
    private List<Point> points = new ArrayList<>();

    public QuickHullApp() {
        setTitle("Quickhull Convex Hull Algorithm");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                points.add(new Point(e.getX(), e.getY()));
                drawOval(e.getX(), e.getY());
                repaint();
            }
        });


        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Point> convexHull = quickHull(points);
                drawConvexHull(convexHull);
            }
        });

        panel.add(startButton, BorderLayout.SOUTH);
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void drawOval(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(Color.BLUE); // Set the color of the ovals

        int ovalSize = 20; // You can adjust the size of the ovals as needed
        g.drawOval(x - ovalSize / 2, y - ovalSize / 2, ovalSize, ovalSize);
    }

    private List<Point> quickHull(List<Point> points) {
        if (points.size() < 3) {
            // Convex hull is not possible with less than 3 points
            return new ArrayList<>(points);
        }

        List<Point> convexHull = new ArrayList<>();

        // Find the points with minimum and maximum x coordinates
        Point min_x = points.get(0);
        Point max_x = points.get(0);
        for (Point point : points) {
            if (point.x < min_x.x) {
                min_x = point;
            } else if (point.x > max_x.x) {
                max_x = point;
            }
        }

        // Add the min and max points to the convex hull
        convexHull.add(min_x);
        convexHull.add(max_x);

        // Divide the points into two sets based on their position relative to the line
        List<Point> leftPoints = new ArrayList<>();
        List<Point> rightPoints = new ArrayList<>();
        for (Point point : points) {
            if (isLeftOfLine(point, min_x, max_x)) {
                leftPoints.add(point);
            } else if (isLeftOfLine(point, max_x, min_x)) {
                rightPoints.add(point);
            }
        }

        // Recursively compute the convex hulls of the two sets
        hullSet(min_x, max_x, rightPoints, convexHull);
        hullSet(max_x, min_x, leftPoints, convexHull);

        return convexHull;
    }

    private void hullSet(Point p1, Point p2, List<Point> set, List<Point> convexHull) {
        int insertPosition = convexHull.indexOf(p2);
        if (set.isEmpty()) {
            return;
        }
        if (set.size() == 1) {
            Point point = set.get(0);
            set.remove(point);
            convexHull.add(insertPosition, point);
            return;
        }

        int farthestIndex = -1;
        int maxDistance = 0;
        for (int i = 0; i < set.size(); i++) {
            Point point = set.get(i);
            int distance = distance(p1, p2, point);
            if (distance > maxDistance) {
                maxDistance = distance;
                farthestIndex = i;
            }
        }

        Point farthestPoint = set.remove(farthestIndex);
        convexHull.add(insertPosition, farthestPoint);

        // Build two sets of points for recursion
        List<Point> leftSet = new ArrayList<>();
        List<Point> rightSet = new ArrayList<>();
        for (Point point : set) {
            if (isLeftOfLine(point, p1, farthestPoint)) {
                leftSet.add(point);
            } else if (isLeftOfLine(point, farthestPoint, p2)) {
                rightSet.add(point);
            }
        }

        hullSet(p1, farthestPoint, leftSet, convexHull);
        hullSet(farthestPoint, p2, rightSet, convexHull);
    }

    private boolean isLeftOfLine(Point p, Point a, Point b) {
        return (b.x - a.x) * (p.y - a.y) - (b.y - a.y) * (p.x - a.x) > 0;
    }

    private int distance(Point a, Point b, Point c) {
        return Math.abs((b.x - a.x) * (a.y - c.y) - (a.x - c.x) * (b.y - a.y));
    }

    private void drawConvexHull(List<Point> convexHull) {
        Graphics g = getGraphics();
        g.setColor(Color.RED);

        int[] xPoints = convexHull.stream().mapToInt(p -> p.x).toArray();
        int[] yPoints = convexHull.stream().mapToInt(p -> p.y).toArray();

        g.drawPolygon(xPoints, yPoints, convexHull.size());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuickHullApp());
    }
}

