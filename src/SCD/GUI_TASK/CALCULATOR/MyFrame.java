package SCD.GUI_TASK.CALCULATOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyFrame extends JFrame {
    private JTextArea p1;

    public MyFrame() {
        setTitle("Scrollable JTextArea Example");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(null);

        p1 = new JTextArea("X,Y");
        p1.setBounds(150, 150, 100, 200);
        p1.setBackground(new Color(0, 21, 24));
        p1.setFont(new Font("Arial", Font.BOLD, 15)); // Fixed the font name
        p1.setForeground(new Color(181, 255, 0));

        JScrollPane scrollPane = new JScrollPane(p1);
        scrollPane.setBounds(100, 150, 400, 200);

        JButton addButton = new JButton("Add");
        addButton.setBounds(250, 360, 100, 30);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = p1.getText();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
                    writer.write(text);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Text added to the file.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        p.add(scrollPane);
        p.add(addButton);

        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
        });
    }
}
