//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.BasicStroke;
//
//class LinePanel extends JPanel {
//    private int[] xPoints;
//    private int[] yPoints;
//    private int currentX, currentY;
//    private int numPoints;
//    private int currentPointIndex;
//    private Timer timer;
//
//    public LinePanel(int[] xPoints, int[] yPoints) {
//        this.xPoints = xPoints;
//        this.yPoints = yPoints;
//        numPoints = Math.min(xPoints.length, yPoints.length);
//        currentPointIndex = 1; // Start connecting from the second point
//        currentX = xPoints[0];
//        currentY = yPoints[0];
//
//        timer = new Timer(10, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (currentPointIndex < numPoints) {
//                    if (currentX < xPoints[currentPointIndex]) {
//                        currentX++;
//                    } else if (currentY < yPoints[currentPointIndex]) {
//                        currentY++;
//                    } else {
//                        currentPointIndex++;
//                    }
//                    repaint();
//                } else {
//                    timer.stop();
//                }
//            }
//        });
//        timer.start();
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(Color.BLACK);
//
//        // Set a thicker line
//        float thickness = 3.0f; // You can adjust this value for the desired line thickness
//        g2d.setStroke(new BasicStroke(thickness));
//
//        // Draw circles at the specified points
//        int circleSize = 10;
//        for (int i = 0; i < numPoints; i++) {
//            g2d.drawOval(xPoints[i] - circleSize / 2, yPoints[i] - circleSize / 2, circleSize, circleSize);
//        }
//
//        // Draw lines to connect the points
//        for (int i = 1; i < currentPointIndex; i++) {
//            g2d.drawLine(xPoints[i - 1], yPoints[i - 1], xPoints[i], yPoints[i]);
//        }
//
//        // Draw the current line being animated
//        g2d.drawLine(xPoints[currentPointIndex - 1], yPoints[currentPointIndex - 1], currentX, currentY);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                JFrame frame = new JFrame("Polygon Animation");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                int numPoints = 4;
//                int[] xPoints = new int[numPoints];
//                int[] yPoints = new int[numPoints];
//
//                for (int i = 0; i < numPoints; i++) {
//                    xPoints[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter x" + (i + 1) + ": "));
//                    yPoints[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter y" + (i + 1) + ": "));
//                }
//
//                LinePanel linePanel = new LinePanel(xPoints, yPoints);
//                frame.add(linePanel);
//
//                frame.setSize(400, 400);
//                frame.setVisible(true);
//            }
//        });
//    }
//}
