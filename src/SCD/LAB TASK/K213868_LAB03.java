package SCD;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

public class K213868_LAB03 extends JFrame {
    JTextArea t;
    int PLUS_FLAG = 0, MINUS_FLAG = 0, DIVIDE_FLAG = 0, MUL_FLAG = 0;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    JButton b9;
    JButton b0;
    JButton b_plus;
    JButton b_minus;
    JButton b_multiply;
    JButton b_divide;
    JButton b_decimal;
    JButton b_equals;
    JButton b_clear;

    K213868_LAB03() {
        setSize(330, 460);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel TEXT_AREA_PANEL = new JPanel();
        TEXT_AREA_PANEL.setSize(320, 150);
        TEXT_AREA_PANEL.setBackground(Color.red);
        TEXT_AREA_PANEL.setLayout(new GridLayout(1, 1, 10, 10));
        add(TEXT_AREA_PANEL);

        t = new JTextArea("");
        t.setFont(new Font("AERIAL", Font.BOLD, 58));
        t.setLineWrap(true);
        t.setBackground(new Color(253, 246, 155));
        TEXT_AREA_PANEL.add(t);


        JPanel BUTTONS_PANEL = new JPanel();
        BUTTONS_PANEL.setBounds(0, 150, 315, 270);
        BUTTONS_PANEL.setBackground(new Color(253, 246, 155));
        BUTTONS_PANEL.setLayout(new GridLayout(5, 4, 20, 10));
        add(BUTTONS_PANEL);

        setTitle("K213868 Task 01");

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        b_plus = new JButton("+");
        b_minus = new JButton("-");
        b_multiply = new JButton("*");
        b_divide = new JButton("/");
        b_decimal = new JButton(".");
        b_equals = new JButton("=");
        b_clear = new JButton("C");


        b1.setBackground(new Color(241, 233, 118));
        b2.setBackground(new Color(241, 233, 118));
        b3.setBackground(new Color(241, 233, 118));
        b4.setBackground(new Color(241, 233, 118));
        b5.setBackground(new Color(241, 233, 118));
        b6.setBackground(new Color(241, 233, 118));
        b7.setBackground(new Color(241, 233, 118));
        b8.setBackground(new Color(241, 233, 118));
        b9.setBackground(new Color(241, 233, 118));
        b0.setBackground(new Color(241, 233, 118));
        b_plus.setBackground(new Color(241, 233, 118));
        b_minus.setBackground(new Color(241, 233, 118));
        b_multiply.setBackground(new Color(241, 233, 118));
        b_divide.setBackground(new Color(241, 233, 118));
        b_equals.setBackground(new Color(241, 233, 118));
        b_decimal.setBackground(new Color(241, 233, 118));
        b_clear.setBackground(new Color(241, 233, 118));


        b1.setFont(new Font("AERIAL", Font.BOLD, 18));
        b2.setFont(new Font("AERIAL", Font.BOLD, 18));
        b3.setFont(new Font("AERIAL", Font.BOLD, 18));
        b4.setFont(new Font("AERIAL", Font.BOLD, 18));
        b5.setFont(new Font("AERIAL", Font.BOLD, 18));
        b6.setFont(new Font("AERIAL", Font.BOLD, 18));
        b7.setFont(new Font("AERIAL", Font.BOLD, 18));
        b8.setFont(new Font("AERIAL", Font.BOLD, 18));
        b9.setFont(new Font("AERIAL", Font.BOLD, 18));
        b0.setFont(new Font("AERIAL", Font.BOLD, 18));
        b_plus.setFont(new Font("AERIAL", Font.BOLD, 18));
        b_minus.setFont(new Font("AERIAL", Font.BOLD, 18));
        b_multiply.setFont(new Font("AERIAL", Font.BOLD, 18));
        b_divide.setFont(new Font("AERIAL", Font.BOLD, 18));
        b_equals.setFont(new Font("AERIAL", Font.BOLD, 18));
        b_decimal.setFont(new Font("AERIAL", Font.BOLD, 18));
        b_clear.setFont(new Font("AERIAL", Font.BOLD, 18));


        b1.setBorderPainted(false);
        b2.setBorderPainted(false);
        b3.setBorderPainted(false);
        b4.setBorderPainted(false);
        b5.setBorderPainted(false);
        b6.setBorderPainted(false);
        b7.setBorderPainted(false);
        b8.setBorderPainted(false);
        b9.setBorderPainted(false);
        b0.setBorderPainted(false);
        b_plus.setBorderPainted(false);
        b_minus.setBorderPainted(false);
        b_multiply.setBorderPainted(false);
        b_divide.setBorderPainted(false);
        b_equals.setBorderPainted(false);
        b_decimal.setBorderPainted(false);
        b_clear.setBorderPainted(false);


        b1.addActionListener(e -> setText("1"));
        b2.addActionListener(e -> setText("2"));
        b3.addActionListener(e -> setText("3"));
        b4.addActionListener(e -> setText("4"));
        b5.addActionListener(e -> setText("5"));
        b6.addActionListener(e -> setText("6"));
        b7.addActionListener(e -> setText("7"));
        b8.addActionListener(e -> setText("8"));
        b9.addActionListener(e -> setText("9"));
        b0.addActionListener(e -> setText("0"));
        b_plus.addActionListener(e -> setText("+"));
        b_minus.addActionListener(e -> setText("-"));
        b_multiply.addActionListener(e -> setText("*"));
        b_divide.addActionListener(e -> setText("/"));
        b_equals.addActionListener(e -> setText("="));
        b_decimal.addActionListener(e -> setText("."));
        b_clear.addActionListener(e -> setClear());


        BUTTONS_PANEL.add(b1);
        BUTTONS_PANEL.add(b2);
        BUTTONS_PANEL.add(b3);
        BUTTONS_PANEL.add(b4);
        BUTTONS_PANEL.add(b5);
        BUTTONS_PANEL.add(b6);
        BUTTONS_PANEL.add(b7);
        BUTTONS_PANEL.add(b8);
        BUTTONS_PANEL.add(b9);
        BUTTONS_PANEL.add(b0);
        BUTTONS_PANEL.add(b_plus);
        BUTTONS_PANEL.add(b_divide);
        BUTTONS_PANEL.add(b_minus);
        BUTTONS_PANEL.add(b_multiply);
        BUTTONS_PANEL.add(b_decimal);
        BUTTONS_PANEL.add(b_decimal);
        BUTTONS_PANEL.add(b_equals);
        BUTTONS_PANEL.add(b_clear);


        setVisible(true);
    }

    String OPERATOR;

    void setText(String num) {
        if (num.equals("+") || num.equals("/") || num.equals("*") || num.equals("-")) {
            b_plus.setEnabled(false);
            b_divide.setEnabled(false);
            b_multiply.setEnabled(false);
            b_minus.setEnabled(false);
        }
        if (num.equals("+")) {
            OPERATOR = "\\+";
        } else if (num.equals("-")) {
            OPERATOR = "\\-";
        } else if (num.equals("*")) {
            OPERATOR = "\\*";
        } else if (num.equals("/")) {
            OPERATOR = "\\/";
        }


        String FETCHED_STRING_FROM_TEXT_AREA = t.getText();

        if (FETCHED_STRING_FROM_TEXT_AREA.equals("0") && Character.isDigit(num.charAt(0))) {
            t.setText(num);
        } else if (num.equals("=")) {
            setEquals();
        } else {
            t.append(num);
        }
    }


    void setClear() {
        t.setText("");

        PLUS_FLAG = 0;
        b_plus.setEnabled(true);

        MINUS_FLAG = 0;
        b_multiply.setEnabled(true);

        MUL_FLAG = 0;
        b_divide.setEnabled(true);

        DIVIDE_FLAG = 0;
        b_minus.setEnabled(true);
    }


    void setEquals() {
        String string = t.getText();


        String[] numbers = string.split(OPERATOR);



        double num1 = Double.parseDouble(numbers[0]);
        double num2 = Double.parseDouble(numbers[1]);


        double sum ;
        if(OPERATOR.contains("+")){
            sum = num1 + num2;
            t.setText(String.valueOf(sum));
        }else if(OPERATOR.contains("-")){
            sum = num1 - num2;
            t.setText(String.valueOf(sum));
        }else if(OPERATOR.contains("*")){
            sum = num1 * num2;
            t.setText(String.valueOf(sum));
        }else if(OPERATOR.contains("/")){
            sum = num1 / num2;
            t.setText(String.valueOf(sum));
        }

    }

    public static void main(String[] args) {
        new K213868_LAB03();
    }
}
