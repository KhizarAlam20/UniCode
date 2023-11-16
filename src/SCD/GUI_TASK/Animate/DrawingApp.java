package SCD.GUI_TASK.Animate;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingApp extends JFrame {
    private JPanel drawingPanel;
    private JButton startButton;
    public ArrayList<Integer> xPoints;
    public ArrayList<Integer> yPoints;

    public DrawingApp() {
        xPoints = new ArrayList<>();
        yPoints = new ArrayList<>();

        setTitle("Drawing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw points as circles
                for (int i = 0; i < xPoints.size(); i++) {
                    int x = xPoints.get(i);
                    int y = yPoints.get(i);
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 5, 5); // Adjust the size of the circle as needed

                    // Draw lines between consecutive points
                    if (i > 0) {
                        int prevX = xPoints.get(i - 1);
                        int prevY = yPoints.get(i - 1);
                        g.drawLine(xPoints.get(0),yPoints.get(0), xPoints.get(1), yPoints.get(1));
                    }
                }
            }
        };
        drawingPanel.setPreferredSize(new Dimension(400, 400));
        drawingPanel.addMouseListener(new MyMouseListener());
        add(drawingPanel, BorderLayout.CENTER);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.repaint(); // Redraw the panel to show lines
                printPoints();
            }
        });
        add(startButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            int x = e.getX();
            int y = e.getY();
            xPoints.add(x);
            yPoints.add(y);
            drawingPanel.repaint(); // Repaint the panel to visually show the points and lines
        }
    }

    private void printPoints() {
        System.out.println("Stored Points:");
        for (int i = 0; i < xPoints.size(); i++) {
            System.out.println("(" + xPoints.get(i) + ", " + yPoints.get(i) + ")");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawingApp().setVisible(true);
            }
        });
    }
}


