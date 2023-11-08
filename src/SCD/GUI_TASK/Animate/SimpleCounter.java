package SCD.GUI_TASK.Animate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCounter {
    private JFrame frame;
    private JLabel counterLabel;
    private JButton startButton;
    private int count = 0;
    private boolean counting = false;

    public SimpleCounter() {
        frame = new JFrame("Counter App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        counterLabel = new JLabel("0 seconds");
        frame.add(counterLabel);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCounting();
            }
        });
        frame.add(startButton);

        frame.pack();
        frame.setVisible(true);
    }

    public void startCounting() {
        if (counting) {
            return; // Already counting
        }

        counting = true;
        startButton.setEnabled(false);

        Thread countThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();

                // Simulate a time-consuming operation, replace this with your actual loop
                for (int i = 0; i < 10000000; i++) {
                    // Your loop logic here
                }

                long endTime = System.currentTimeMillis();
                final long totalTime = endTime - startTime;

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        counterLabel.setText(totalTime / 1000 + " seconds");
                        counting = false;
                        startButton.setEnabled(true);
                    }
                });
            }
        });
        countThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCounter();
            }
        });
    }
}
