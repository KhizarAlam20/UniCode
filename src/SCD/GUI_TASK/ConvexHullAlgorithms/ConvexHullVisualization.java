package SCD.GUI_TASK.ConvexHullAlgorithms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ConvexHullVisualization extends JFrame {
    private ArrayList<Point> dataPoints;
    private int animationStep = 0;
    JLabel l, seconds, milliseconds;
    private long startTime;
    private Timer animationTimer;

    public ConvexHullVisualization() {
        this.dataPoints = new ArrayList<>();

        setTitle("Convex Hull Visualization");
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

        JPanel graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < dataPoints.size(); i++) {
                    int x = dataPoints.get(i).x;
                    int y = dataPoints.get(i).y;
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 8, 8);
                }
                drawConvexHull(g);
            }
        };

        graphPanel.setLayout(null);
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
        graphPanel.add(l);
        graphPanel.add(milli);
        graphPanel.add(back);
        graphPanel.add(milliseconds);
        graphPanel.add(seconds);
        graphPanel.add(sec);
        graphPanel.add(t);
        add(graphPanel);
        setVisible(true);
        startTime = System.currentTimeMillis();
    }

    private void drawConvexHull(Graphics g) {
        int numPointsToInclude = Math.min(animationStep, dataPoints.size());

        Graphics2D g2d = (Graphics2D) g;

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

                        g2d.setColor(new Color(255, 0, 0, 60));

                        // Draw only if it's within the animation step
                        if (k < animationStep) {
                            g.drawLine(p1.x, p1.y, p2.x, p2.y);
                        }

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

                if ((isOnLeft && !isOnRight) || (!isOnLeft && isOnRight)) {
                    g2d.setColor(new Color(231, 255, 0, 255));

                    // Draw only if it's within the animation step
                    if (j < animationStep) {
                        g.drawLine(p1.x, p1.y, p2.x, p2.y);
                    }
                }
            }
        }

        boolean convexHullCompleted = (numPointsToInclude == dataPoints.size());
    }


    private void startConvexHullAlgorithm() {
        if (dataPoints.size() < 3) {
            JOptionPane.showMessageDialog(null, "At least 3 points are required to form a convex hull.");
            return;
        }

        startTime = System.currentTimeMillis();

        animationTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animationStep++;
                if (animationStep <= dataPoints.size()) {
                    repaint();
                } else {
                    animationTimer.stop();
                    long endTime = System.currentTimeMillis();  // Record the end time
                    long elapsedTime = endTime - startTime;
                    System.out.println("Convex Hull Computation Time: " + elapsedTime + " milliseconds or " + (elapsedTime) / 1000 + " Seconds ");
                    milliseconds.setText(String.valueOf(elapsedTime) + "  milliseconds");
                    seconds.setText(String.valueOf((elapsedTime) / 1000) + "  seconds");
                }
            }
        });

        animationTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConvexHullVisualization::new);
    }
}
