package SCD.GUI_TASK.ConvexHullAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class QuickHullApp extends JFrame {
    private List<Point2D.Double> points;
    private List<Point2D.Double> convexHull;
    JLabel l, seconds, milliseconds;
    private long startTime;
    private boolean showConvexHull;

    public QuickHullApp() {
        points = new ArrayList<>();
        convexHull = new ArrayList<>();
        showConvexHull = false;

        setTitle("Quick Elimination");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel l = new JLabel("0");
        l.setBounds(300, 0, 200, 80);
        l.setFont(new Font("AERIAL", Font.BOLD, 25));
        l.setForeground(new Color(181, 255, 0));

        JLabel t = new JLabel("Total Time ");
        t.setBounds(50, 355, 200, 80);
        t.setFont(new Font("AERIAL", Font.BOLD, 18));
        t.setForeground(new Color(181, 255, 0));

        JLabel milli = new JLabel("Milliseconds : ");
        milli.setBounds(50, 375, 200, 80);
        milli.setFont(new Font("AERIAL", Font.BOLD, 14));
        milli.setForeground(new Color(181, 255, 0));

        milliseconds = new JLabel("0");
        milliseconds.setBounds(170, 375, 200, 80);
        milliseconds.setFont(new Font("AERIAL", Font.BOLD, 14));
        milliseconds.setForeground(new Color(181, 255, 0));

        JLabel sec = new JLabel("Seconds : ");
        sec.setBounds(50, 395, 200, 80);
        sec.setFont(new Font("AERIAL", Font.BOLD, 14));
        sec.setForeground(new Color(181, 255, 0));


        seconds = new JLabel("0");
        seconds.setBounds(170, 395, 200, 80);
        seconds.setFont(new Font("AERIAL", Font.BOLD, 14));
        seconds.setForeground(new Color(181, 255, 0));

        JButton back = new JButton("Back");
        back.setBounds(400, 395, 90, 25);
        back.setFocusable(false);
        back.setBackground(new Color(0, 19, 23));
        back.setFont(new Font("AERIAL", Font.BOLD, 15));
        back.setForeground(new Color(181, 255, 0));
        back.setBorderPainted(false);
        back.addActionListener(e -> new HomeScreen());


        MyPanel panel = new MyPanel();
        panel.addMouseListener(new MyMouseListener());
        add(panel);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showConvexHull = true;
                convexHull = quickHull(points);
                repaint();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(l);
        buttonPanel.add(milli);
        buttonPanel.add(back);
        buttonPanel.add(milliseconds);
        buttonPanel.add(seconds);
        buttonPanel.add(sec);
        buttonPanel.add(t);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Set panel background color
            setBackground(new Color(0, 19, 23));

            // Draw points
            g2d.setColor(Color.BLACK);
            for (Point2D.Double point : points) {
                int x = (int) point.getX();
                int y = (int) point.getY();
                g2d.fillOval(x - 5, y - 5, 10, 10);
            }

            // Draw convex hull if requested
            if (showConvexHull) {
                // Set line color
                g2d.setColor(new Color(181, 255, 0));

                int n = convexHull.size();
                for (int i = 0; i < n; i++) {
                    int next = (i + 1) % n;
                    int x1 = (int) convexHull.get(i).getX();
                    int y1 = (int) convexHull.get(i).getY();
                    int x2 = (int) convexHull.get(next).getX();
                    int y2 = (int) convexHull.get(next).getY();
                    g2d.drawLine(x1, y1, x2, y2);
                }
            }
        }
    }


    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            points.add(new Point2D.Double(e.getX(), e.getY()));
            repaint();
        }
    }

    private List<Point2D.Double> quickHull(List<Point2D.Double> inputPoints) {
        return QuickHullAlgorithm.quickHull(inputPoints);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuickHullApp());
    }
}

class QuickHullAlgorithm {

    public static List<Point2D.Double> quickHull(List<Point2D.Double> inputPoints) {
        if (inputPoints.size() < 3) {
            // Convex hull is not possible with less than 3 points
            return new ArrayList<>(inputPoints);
        }

        List<Point2D.Double> convexHull = new ArrayList<>();

        // Find the points with minimum and maximum x-coordinates
        Point2D.Double minX = inputPoints.get(0);
        Point2D.Double maxX = inputPoints.get(0);
        for (Point2D.Double point : inputPoints) {
            if (point.getX() < minX.getX()) {
                minX = point;
            }
            if (point.getX() > maxX.getX()) {
                maxX = point;
            }
        }

        convexHull.add(minX);
        convexHull.add(maxX);

        // Divide the points into two sets based on their position relative to the line formed by minX and maxX
        List<Point2D.Double> pointsAboveLine = new ArrayList<>();
        List<Point2D.Double> pointsBelowLine = new ArrayList<>();

        for (Point2D.Double point : inputPoints) {
            if (point != minX && point != maxX) {
                double position = positionRelativeToLine(minX, maxX, point);
                if (position > 0) {
                    pointsAboveLine.add(point);
                } else if (position < 0) {
                    pointsBelowLine.add(point);
                }
            }
        }

        findHull(pointsAboveLine, minX, maxX, convexHull);
        findHull(pointsBelowLine, maxX, minX, convexHull);

        return convexHull;
    }

    private static double positionRelativeToLine(Point2D.Double a, Point2D.Double b, Point2D.Double p) {
        return (b.getX() - a.getX()) * (p.getY() - a.getY()) - (b.getY() - a.getY()) * (p.getX() - a.getX());
    }

    private static void findHull(List<Point2D.Double> points, Point2D.Double p1, Point2D.Double p2, List<Point2D.Double> convexHull) {
        int insertPosition = convexHull.indexOf(p2);

        if (points.isEmpty()) {
            return;
        }

        if (points.size() == 1) {
            Point2D.Double point = points.get(0);
            convexHull.add(insertPosition, point);
            return;
        }

        double maxDistance = -1;
        Point2D.Double farthestPoint = null;

        for (Point2D.Double point : points) {
            double distance = pointDistance(p1, p2, point);
            if (distance > maxDistance) {
                maxDistance = distance;
                farthestPoint = point;
            }
        }

        convexHull.add(insertPosition, farthestPoint);

        List<Point2D.Double> leftSet = new ArrayList<>();
        List<Point2D.Double> rightSet = new ArrayList<>();

        for (Point2D.Double point : points) {
            if (point != farthestPoint) {
                if (positionRelativeToLine(p1, farthestPoint, point) > 0) {
                    leftSet.add(point);
                } else if (positionRelativeToLine(farthestPoint, p2, point) > 0) {
                    rightSet.add(point);
                }
            }
        }

        findHull(leftSet, p1, farthestPoint, convexHull);
        findHull(rightSet, farthestPoint, p2, convexHull);
    }

    private static double pointDistance(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
        return Math.abs((c.getX() - a.getX()) * (b.getY() - a.getY()) - (b.getX() - a.getX()) * (c.getY() - a.getY()))
                / Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
}
