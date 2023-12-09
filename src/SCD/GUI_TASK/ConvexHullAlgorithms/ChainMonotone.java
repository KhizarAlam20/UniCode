package SCD.GUI_TASK.ConvexHullAlgorithms;

//monotone

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ChainMonotone extends JFrame {

    private ArrayList<Point2D.Double> points;
    JLabel l, seconds, milliseconds,tc;
    public long startTime;
    private ArrayList<Point2D.Double> convexHull;
    private int animationIndex;

    public ChainMonotone() {
        points = new ArrayList<>();
        convexHull = new ArrayList<>();
        animationIndex = 0;

        setTitle("CHAIN MONOTONE K213868");
        setSize(600, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton generateButton = new JButton("Generate Convex Hull");
        generateButton.addActionListener(e -> {
            tc.setText("0");
            generateRandomPoints(20);
            computeConvexHull();
            animationIndex = 0; // Reset animation index
            startAnimation();
        });


        JLabel l = new JLabel("0");
        l.setBounds(300, 0, 200, 80);
        l.setFont(new Font("AERIAL", Font.BOLD, 25));
        l.setForeground(new Color(181, 255, 0));

        JLabel t = new JLabel("Total Time ");
        t.setBounds(50, 400, 200, 80);
        t.setFont(new Font("AERIAL", Font.BOLD, 18));
        t.setForeground(new Color(181, 255, 0));

        JLabel milli = new JLabel("Milliseconds : ");
        milli.setBounds(50, 425, 200, 80);
        milli.setFont(new Font("AERIAL", Font.BOLD, 14));
        milli.setForeground(new Color(181, 255, 0));

        milliseconds = new JLabel("0");
        milliseconds.setBounds(170, 425, 200, 80);
        milliseconds.setFont(new Font("AERIAL", Font.BOLD, 14));
        milliseconds.setForeground(new Color(181, 255, 0));

        JLabel sec = new JLabel("Seconds : ");
        sec.setBounds(50, 445, 200, 80);
        sec.setFont(new Font("AERIAL", Font.BOLD, 14));
        sec.setForeground(new Color(181, 255, 0));


        seconds = new JLabel("0");
        seconds.setBounds(170, 445, 200, 80);
        seconds.setFont(new Font("AERIAL", Font.BOLD, 14));
        seconds.setForeground(new Color(181, 255, 0));

        tc = new JLabel("0");
        tc.setBounds(280, 395, 200, 80);
        tc.setFont(new Font("AERIAL", Font.BOLD, 14));
        tc.setForeground(new Color(181, 255, 0));


        JButton back = new JButton("Back");
        back.setBounds(400, 520, 90, 25);
        back.setFocusable(false);
        back.setBackground(new Color(0, 19, 23));
        back.setFont(new Font("AERIAL", Font.BOLD, 15));
        back.setForeground(new Color(181, 255, 0));
        back.setBorderPainted(false);
        back.addActionListener(e -> new HomeScreen());


        // Button settings
        generateButton.setFocusable(false);
        generateButton.setBackground(new Color(0, 19, 23));
        generateButton.setFont(new Font("Arial", Font.BOLD, 15));
        generateButton.setForeground(new Color(181, 255, 0));
        generateButton.setBorderPainted(false);

        // Set layout to null
        setLayout(null);

        // Set button bounds
        generateButton.setBounds(10, 520, 200, 30);

        // Panel color
        getContentPane().setBackground(new Color(0, 19, 23));

        // Add button to the frame
        add(milli);
        add(back);
        add(milliseconds);
        add(tc);
//        add(seconds);
//        add(sec);
        add(t);
        add(generateButton);

        setVisible(true);
        startTime = System.currentTimeMillis();
    }


    private void generateRandomPoints(int numPoints) {
        points.clear();
        convexHull.clear();

        int minX = 50;
        int maxX = 450;
        int minY = 50;
        int maxY = 450;

        for (int i = 0; i < numPoints+10; i++) {
            double x = minX + Math.random() * (maxX - minX);
            double y = minY + Math.random() * (maxY - minY);
            points.add(new Point2D.Double(x, y));
        }

        // Sort points by x-coordinate
        Collections.sort(points, Comparator.comparingDouble(Point2D.Double::getX));
    }

    private void computeConvexHull() {
        convexHull.clear();

        // Construct upper hull
        for (Point2D.Double point : points) {
            while (convexHull.size() >= 2 &&  crossProduct(convexHull.get(convexHull.size() - 2), convexHull.get(convexHull.size() - 1), point) <= 0) {
                convexHull.remove(convexHull.size() - 1);
            }
            convexHull.add(point);
        }

        // Construct lower hull
        int lowerHullSize = convexHull.size();
        for (int i = points.size() - 2; i >= 0; i--) {
            Point2D.Double point = points.get(i);
            while (convexHull.size() > lowerHullSize &&
                    crossProduct(convexHull.get(convexHull.size() - 2), convexHull.get(convexHull.size() - 1), point) <= 0) {
                convexHull.remove(convexHull.size() - 1);
            }
            convexHull.add(point);
        }

        // Remove the last point, which is a duplicate of the first point in the upper hull
        convexHull.remove(convexHull.size() - 1);
    }

    private double crossProduct(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
    }

    private void startAnimation() {
        Timer timer = new Timer(400, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (animationIndex < convexHull.size()) {
                    repaint();
                    animationIndex++;
                } else {
                    ((Timer) e.getSource()).stop(); // Stop the timer when animation is complete
                    long endTime = System.currentTimeMillis();  // Record the end time
                    long elapsedTime = endTime - startTime;
                    System.out.println("Convex Hull Computation Time: " + elapsedTime + " milliseconds or " + (elapsedTime) / 1000 + " Seconds ");
                    milliseconds.setText(String.valueOf(elapsedTime) + "  milliseconds");
                    seconds.setText(String.valueOf((elapsedTime) / 1000) + "  seconds");
                    tc.setText(String.valueOf("O(n.log.n)"));
                }
            }
        });

        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw points
        g2d.setColor(Color.RED);  // Circle color
        for (Point2D.Double point : points) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            g2d.fillOval(x - 5, y - 5, 10, 10);
        }

        // Draw convex hull (only up to the current animation index)
        g2d.setColor(new Color(181, 255, 0));  // Line color
        int[] xPoints = new int[animationIndex];
        int[] yPoints = new int[animationIndex];
        for (int i = 0; i < animationIndex; i++) {
            xPoints[i] = (int) convexHull.get(i).getX();
            yPoints[i] = (int) convexHull.get(i).getY();
        }
        g2d.drawPolygon(xPoints, yPoints, animationIndex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChainMonotone());
    }
}
