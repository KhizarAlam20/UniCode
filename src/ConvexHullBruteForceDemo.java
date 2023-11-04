//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConvexHullBruteForceDemo extends JFrame {
//    private List<Point> points = new ArrayList<>();
//    private List<Line> convexHullLines = new ArrayList<>();
//    private int currentPointIndex = 0;
//
//    public ConvexHullBruteForceDemo() {
//        setTitle("Convex Hull Brute Force Demo");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800, 600);
//        setLocationRelativeTo(null);
//
//        JPanel canvas = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                drawPoints(g);
//                drawConvexHullLines(g);
//            }
//        };
//
//        canvas.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                points.add(new Point(e.getX(), e.getY()));
//                repaint();
//            }
//        });
//
//        JButton computeButton = new JButton("Compute Convex Hull");
//        computeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                animateConvexHull();
//            }
//        });
//
//        setLayout(new BorderLayout());
//        add(canvas, BorderLayout.CENTER);
//        add(computeButton, BorderLayout.SOUTH);
//    }
//
//    private void drawPoints(Graphics g) {
//        g.setColor(Color.BLUE);
//        for (Point point : points) {
//            g.fillOval(point.x - 3, point.y - 3, 6, 6);
//        }
//    }
//
//    private void drawConvexHullLines(Graphics g) {
//        g.setColor(Color.RED);
//        for (int i = 0; i < convexHullLines.size(); i++) {
//            Line line = convexHullLines.get(i);
//            g.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
//        }
//    }
//
//    private void animateConvexHull() {
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (currentPointIndex < points.size()) {
//                    computeConvexHullStepByStep();
//                    currentPointIndex++;
//                    repaint();
//                }
//            }
//        });
//        timer.start();
//    }
//
//    private void computeConvexHullStepByStep() {
//        if (currentPointIndex < 3) {
//            // Need at least 3 points for a convex hull.
//            return;
//        }
//
//        List<Point> hull = new ArrayList<>();
//        hull.add(points.get(0));
//        hull.add(points.get(1));
//
//        for (int i = 2; i <= currentPointIndex; i++) {
//            Point p = points.get(i);
//            while (hull.size() > 1 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p) <= 0) {
//                hull.remove(hull.size() - 1);
//            }
//            hull.add(p);
//        }
//
//        convexHullLines.clear();
//        for (int i = 0; i < hull.size() - 1; i++) {
//            convexHullLines.add(new Line(hull.get(i), hull.get(i + 1)));
//        }
//    }
//
//    private int orientation(Point p, Point q, Point r) {
//        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
//        if (val == 0) return 0;
//        return (val > 0) ? 1 : 2;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            ConvexHullBruteForceDemo demo = new ConvexHullBruteForceDemo();
//            demo.setVisible(true);
//        });
//    }
//
//    class Point {
//        int x, y;
//
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    class Line {
//        Point start, end;
//
//        Line(Point start, Point end) {
//            this.start = start;
//            this.end = end;
//        }
//    }
//}
