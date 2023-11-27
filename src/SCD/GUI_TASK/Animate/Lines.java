package SCD.GUI_TASK.Animate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LinePanel extends JPanel {
    private int[] xPoints;
    private int[] yPoints;
    private int currentX, currentY;
    private int numPoints;
    private int currentPointIndex;
    private Timer timer;

    public LinePanel(int[] xPoints, int[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        numPoints = Math.min(xPoints.length, yPoints.length);
        currentPointIndex = 1; // Start connecting from the second point
        currentX = xPoints[0];
        currentY = yPoints[0];

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPointIndex < numPoints) {
                    if (currentX < xPoints[currentPointIndex]) {
                        currentX++;
                    } else if (currentY < yPoints[currentPointIndex]) {
                        currentY++;
                    } else {
                        currentPointIndex++;
                    }
                    repaint();
                } else {
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        // Draw circles at the specified points
        int circleSize = 10;
        for (int i = 0; i < numPoints; i++) {
            g.drawOval(xPoints[i] - circleSize / 2, yPoints[i] - circleSize / 2, circleSize, circleSize);
        }

        // Draw lines to connect the points
        for (int i = 1; i < currentPointIndex; i++) {
            g.drawLine(xPoints[i - 1], yPoints[i - 1], xPoints[i], yPoints[i]);
        }

        // Draw the current line being animated
        g.drawLine(xPoints[currentPointIndex - 1], yPoints[currentPointIndex - 1], currentX, currentY);
    }
}

public class Lines {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Polygon Animation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                int numPoints = 4;
                int[] xPoints = new int[numPoints];
                int[] yPoints = new int[numPoints];

                for (int i = 0; i < numPoints; i++) {
                    xPoints[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter x" + (i + 1) + ": "));
                    yPoints[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter y" + (i + 1) + ": "));
                }

                LinePanel linePanel = new LinePanel(xPoints, yPoints);
                frame.add(linePanel);

                frame.setSize(400, 400);
                frame.setVisible(true);
            }
        });
    }
}