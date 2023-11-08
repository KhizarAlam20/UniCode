package SCD.GUI_TASK.Animate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCounter extends JFrame {
    private JLabel counterLabel;
    private int seconds = 0;
    private Timer timer;

    public SimpleCounter() {
        counterLabel = new JLabel("Seconds: 0");
        add(counterLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                counterLabel.setText("Seconds: " + seconds);
            }
        });

        timer.start();

        // Simulate your for loop here
        for (int i = 0; i < 10; i++) {
            // Replace this with your actual loop logic
            try {
                Thread.sleep(1000); // Simulate some work for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        timer.stop();
        counterLabel.setText("Seconds: " + seconds);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCounter frame = new SimpleCounter();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 100);
            frame.setVisible(true);
        });
    }
}
