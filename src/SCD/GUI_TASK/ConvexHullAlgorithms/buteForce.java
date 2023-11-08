package SCD.GUI_TASK.ConvexHullAlgorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class buteForce extends JFrame {
    JLabel l;
    private ArrayList<Integer> xArray;
    private ArrayList<Integer> yArray;
    private ArrayList<Point> dataPoints;
    private int animationStep = 0;
    private Timer animationTimer;

    public buteForce(ArrayList<Integer> xArray, ArrayList<Integer> yArray) {
        this.xArray = xArray;
        this.yArray = yArray;
        this.dataPoints = new ArrayList<>();

        for (int i = 0; i < xArray.size(); i++) {
            dataPoints.add(new Point(xArray.get(i), yArray.get(i)));
        }

        setTitle("CONVEX HULL K213868");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel l = new JLabel("0");
        l.setBounds(0,430,200,80);
        l.setFont(new Font("AERIAL", Font.BOLD, 25));
        l.setForeground(new Color(181, 255, 0));


        JPanel graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawConvexHull(g);
            }
        };


        graphPanel.add(l);
        graphPanel.setBackground(new Color(1, 28, 35));
        add(graphPanel);
        setVisible(true);


        animationTimer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animationStep++;
                l.setText(String.valueOf(animationStep));

                if (animationStep <= dataPoints.size()) {
                    repaint();
                } else {
                    animationTimer.stop();
                }
            }
        });

        animationTimer.start();
    }

    private void drawConvexHull(Graphics g) {


        int n = dataPoints.size();

        // Draw x-axis
        g.drawLine(50, 350, 550, 350);
        for (int x = 0; x <= 100; x += 5) {
            int xCoord = 50 + x * 5;
            g.setColor(new Color(181, 255, 0));
            g.drawLine(xCoord, 345, xCoord, 355);
            g.drawString(Integer.toString(x), xCoord - 8, 370);
        }

        // Draw y-axis
        g.drawLine(50, 50, 50, 350);
        for (int y = 0; y <= 100; y += 5) {
            int yCoord = 350 - y * 3;
            g.setColor(new Color(181, 255, 0));
            g.drawLine(45, yCoord, 55, yCoord);
            g.drawString(Integer.toString(y), 15, yCoord + 5);
        }

        int numPointsToInclude = Math.min(animationStep, dataPoints.size());

        for (int i = 0; i < dataPoints.size(); i++) {
            int x = 50 + dataPoints.get(i).x * 5;
            int y = 350 - dataPoints.get(i).y * 3;
            g.setColor(new Color(0, 153, 192));
            g.fillOval(x - 3, y - 3, 6, 6);
        }

        // Brute-force approach to finding the convex hull (use only the points up to the animation step)
        for (int i = 0; i < numPointsToInclude; i++) {
            for (int j = i + 1; j < numPointsToInclude; j++) {
                Point p1 = dataPoints.get(i);
                Point p2 = dataPoints.get(j);
                boolean isOnLeft = true;
                boolean isOnRight = true;


                for (int k = 0; k < numPointsToInclude; k++) {
                    if (k != i && k != j) {
                        Point p3 = dataPoints.get(k);
                        int crossProduct = (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);

                        g.setColor(Color.RED);
                        g.drawLine(50 + p1.x * 5, 350 - p1.y * 3, 50 + p2.x * 5, 350 - p2.y * 3);
                        if (crossProduct > 0) {
                            isOnRight = false;
                        } else if (crossProduct < 0) {
                            isOnLeft = false;
                        }

                        if (!isOnLeft && !isOnRight) {
                            break;
                        }
                    }
                }

                if (isOnLeft || isOnRight) {
                    g.setColor(Color.GREEN);
                    g.drawLine(50 + p1.x * 5, 350 - p1.y * 3, 50 + p2.x * 5, 350 - p2.y * 3);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("X") && !line.contains("Y")) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        int x = Integer.parseInt(parts[0]);
                        int y = Integer.parseInt(parts[1]);
                        xValues.add(x);
                        yValues.add(y);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading the file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingUtilities.invokeLater(() -> new buteForce(xValues, yValues));
    }
}
