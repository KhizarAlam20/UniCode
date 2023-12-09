package SCD.GUI_TASK.ConvexHullAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class GrahamScan extends JFrame {
    private ArrayList<Point> dataPoints;
    private long startTime;
    JLabel l, seconds, milliseconds,tc;
    private int animationStep = 0;
    private Timer animationTimer;

    public GrahamScan() {
        this.dataPoints = new ArrayList<>();

        setTitle("GRAHAM SCAN K213868");
        setSize(600, 500);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel l = new JLabel("0");
        l.setBounds(300, 0, 200, 80);
        l.setFont(new Font("AERIAL", Font.BOLD, 25));
        l.setForeground(new Color(1, 28, 35));

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

        tc = new JLabel("0");
        tc.setBounds(280, 395, 200, 80);
        tc.setFont(new Font("AERIAL", Font.BOLD, 14));
        tc.setForeground(new Color(181, 255, 0));

        JLabel sec = new JLabel("Seconds : ");
        sec.setBounds(50, 395, 200, 80);
        sec.setFont(new Font("AERIAL", Font.BOLD, 14));
        sec.setForeground(new Color(181, 255, 0));


        seconds = new JLabel("0");
        seconds.setBounds(170, 395, 200, 80);
        seconds.setFont(new Font("AERIAL", Font.BOLD, 14));
        seconds.setForeground(new Color(181, 255, 0));



        JPanel graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawPoints(g);
                drawConvexHull(g);
                drawReferenceLine(g);
            }
        };

        graphPanel.setLayout(null);
        graphPanel.add(l);
        graphPanel.add(milli);
        graphPanel.add(milliseconds);
        graphPanel.add(seconds);
        graphPanel.add(sec);
        graphPanel.add(t);
        graphPanel.add(tc);

        startTime = System.currentTimeMillis();
        graphPanel.setBackground(new Color(1, 28, 35));

        graphPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dataPoints.add(new Point(e.getX(), e.getY()));
                repaint();
            }
        });

        JButton runButton = new JButton("Run Convex Hull");
        runButton.setBounds(400, 395, 150, 25);
        runButton.setFocusable(false);
        runButton.setBackground(new Color(0, 19, 23));
        runButton.setFont(new Font("Arial", Font.BOLD, 15));
        runButton.setForeground(new Color(181, 255, 0));
        runButton.setBorderPainted(false);
        runButton.addActionListener(e -> startConvexHullAlgorithm());

        graphPanel.add(runButton);
        add(graphPanel);
        setVisible(true);
    }

    private void drawPoints(Graphics g) {
        for (int i = 0; i < dataPoints.size(); i++) {
            int x = dataPoints.get(i).x;
            int y = dataPoints.get(i).y;

            if (i < animationStep) {
                g.setColor(Color.GREEN); // Highlight the points that have been processed
            } else {
                g.setColor(Color.RED);
            }

            g.fillOval(x, y, 8, 8);
        }
    }

    private void drawConvexHull(Graphics g) {
        int numPointsToInclude = Math.min(animationStep, dataPoints.size());

        Graphics2D g2d = (Graphics2D) g;
        if (numPointsToInclude < 3) {
            return;
        }

        ArrayList<Point> convexHull = computeConvexHull();

        // Draw the convex hull
        g2d.setColor(new Color(231, 255, 0, 255));
        for (int i = 0; i < convexHull.size() - 1; i++) {
            Point p1 = convexHull.get(i);
            Point p2 = convexHull.get(i + 1);

            g2d.setStroke(new BasicStroke(2));

            if (i == animationStep - 2) {
                g2d.setColor(Color.YELLOW); // Highlight the current line
            } else if (i < animationStep - 2) {
                g2d.setColor(Color.GREEN); // Highlight the lines that have been processed
            } else {
                g2d.setColor(new Color(231, 255, 0, 255));
            }

            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        // Draw the last line connecting the last and first points
        Point firstPoint = convexHull.get(0);
        Point lastPoint = convexHull.get(convexHull.size() - 1);

        if (animationStep == convexHull.size() + 2) {
            g2d.setColor(Color.YELLOW); // Highlight the final line
        } else {
            g2d.setColor(new Color(231, 255, 0, 255));
        }

        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(lastPoint.x, lastPoint.y, firstPoint.x, firstPoint.y);
    }

    private ArrayList<Point> computeConvexHull() {
        int numPointsToInclude = Math.min(animationStep, dataPoints.size());

        if (numPointsToInclude < 3) {
            return new ArrayList<>();
        }

        Point anchorPoint = dataPoints.stream()
                .min(Comparator.comparing(Point::getY).thenComparing(Point::getX))
                .orElseThrow();

        Collections.sort(dataPoints, Comparator.comparing(Point::getY));

        final Point finalAnchorPoint = anchorPoint;
        Collections.sort(dataPoints.subList(1, numPointsToInclude),
                Comparator.comparingDouble(p -> Math.atan2(p.y - finalAnchorPoint.y, p.x - finalAnchorPoint.x)));

        Stack<Point> convexHullStack = new Stack<>();
        convexHullStack.push(dataPoints.get(0));
        convexHullStack.push(dataPoints.get(1));

        for (int i = 2; i < numPointsToInclude; i++) {
            while (convexHullStack.size() > 1 &&
                    orientation(convexHullStack.get(convexHullStack.size() - 2),
                            convexHullStack.peek(), dataPoints.get(i)) != -1) {
                convexHullStack.pop();
            }
            convexHullStack.push(dataPoints.get(i));
        }

        return new ArrayList<>(convexHullStack);
    }

    private void drawReferenceLine(Graphics g) {
        if (!dataPoints.isEmpty()) {
            Point lowestYPoint = dataPoints.stream().min(Comparator.comparing(Point::getY).thenComparing(Point::getX)).orElseThrow();
            g.setColor(Color.BLUE);
            g.drawLine(lowestYPoint.x, lowestYPoint.y, getWidth(), lowestYPoint.y);
        }
    }

    private int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0; // Collinear
        return Integer.compare(val, 0); // Clockwise or counterclockwise
    }

    private void startConvexHullAlgorithm() {
        if (dataPoints.size() < 3) {
            JOptionPane.showMessageDialog(null, "At least 3 points are required to form a convex hull.");
            return;
        }

        startTime = System.currentTimeMillis();

        animationTimer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animationStep++;
                if (animationStep <= dataPoints.size() + 2) {
                    repaint();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    animationTimer.stop();
                    long endTime = System.currentTimeMillis();  // Record the end time
                    long elapsedTime = endTime - startTime;

                    System.out.println("Convex Hull Computation Time: " + elapsedTime + " milliseconds or " + (elapsedTime) / 1000 + " Seconds ");
                    milliseconds.setText(String.valueOf(elapsedTime) + "  milliseconds");
                    seconds.setText(String.valueOf((elapsedTime) / 1000) + "  seconds");
                    tc.setText("O(n.log.n)");

                }
            }
        });

        animationTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GrahamScan::new);
    }
}
