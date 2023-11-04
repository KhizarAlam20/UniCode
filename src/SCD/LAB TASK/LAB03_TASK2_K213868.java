package SCD;//package SCD;
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//import static sun.swing.SwingUtilities2.submit;

public class LAB03_TASK2_K213868 extends JFrame {

    JButton submit;
    JTextField userNAME, AGE_field, email_field;
    JLabel error;

    LAB03_TASK2_K213868() {

        setSize(530, 300);
        setLocation(350, 200);
        setTitle("TASK 2 K213868");
        setLayout(null);


        //panel
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(252, 246, 245));
        p1.setBounds(0, 0, 530, 400);

        p1.setLayout(null);
        add(p1);


        //////////////////////////////////////////////////////////////////////////////////


        //tag
        JLabel TAG = new JLabel("STUDENT REGISTER FORM :");
        TAG.setBounds(135, 20, 500, 100);
        TAG.setFont(new Font("OSWALD", Font.BOLD, 25));
        p1.add(TAG);


        //adding email
        JLabel userName = new JLabel("NAME :");
        userName.setBounds(135, 50, 500, 100);
        userName.setFont(new Font("OSWALD", Font.BOLD, 13));
        p1.add(userName);

        userNAME = new JTextField("here");
        userNAME.setBounds(215, 90, 145, 22);
        userNAME.setFont(new Font("SAN SERIF", Font.BOLD, 12));
        p1.add(userNAME);

        //adding passwordField
        JLabel email = new JLabel("EMAIL :");
        email.setBounds(135, 80, 500, 100);
        email.setForeground(new Color(0, 98, 105));
        email.setFont(new Font("OSWALD", Font.BOLD, 13));
        p1.add(email);

        email_field = new JTextField("here");
        email_field.setBounds(215, 120, 145, 22);
        p1.add(email_field);

        //AGE
        JLabel AGE = new JLabel("AGE :");
        AGE.setBounds(135, 110, 500, 100);
        AGE.setForeground(new Color(0, 98, 105));
        AGE.setFont(new Font("OSWALD", Font.BOLD, 13));
        p1.add(AGE);

        AGE_field = new JTextField("here");
        AGE_field.setBounds(215, 150, 145, 22);
        p1.add(AGE_field);

        submit = new JButton("submit");
        submit.setBounds(260, 180, 100, 19);
        submit.setBackground(new Color(153, 0, 17));
        submit.setForeground(Color.white);
        submit.setFont(new Font("SAN SERIF", Font.BOLD, 11));
        submit.addActionListener(e -> submit());
        p1.add(submit);


        //key listners
        userNAME.addKeyListener(new InputValidator(userNAME, userName));
        email_field.addKeyListener(new InputValidator(email_field, email));
        AGE_field.addKeyListener(new InputValidator(AGE_field, AGE));


        //panel-3
        JPanel p3 = new JPanel();
        p3.setBounds(0, 0, 15, 400);
        p3.setBackground(new Color(153, 0, 17));
        p1.add(p3);

        setVisible(true);
    }

    private void submit() {
        if (AGE_field.getText().isEmpty() || email_field.equals("") || userNAME.equals("")) {
            JOptionPane.showMessageDialog(this, "Form Can't be Submitted");

        } else {
            JOptionPane.showMessageDialog(this, "Form Successfully Submitted");
        }
    }


    class InputValidator extends KeyAdapter {


        private JTextField textField;
        private JLabel label;

        public InputValidator(JTextField textField, JLabel label) {
            this.textField = textField;
            this.label = label;
        }


        public void keyReleased(KeyEvent e) {
            System.out.println("hello");
            validateField();
        }

       
        private void validateField() {

            if (textField.getText().equals("")) {
                System.out.println("in if");

                label.setForeground(Color.RED);
                submit.setEnabled(false);
            } else {
                System.out.println("In else");
//                error.setText("CORRECT!!");
//                error.setForeground(Color.GREEN);
                label.setForeground(Color.GREEN);
                submit.setEnabled(true);
            }


        }

    }

    public static void main(String[] args) {
        new LAB03_TASK2_K213868();
    }
}
