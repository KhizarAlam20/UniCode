package SCD;//package SCD;
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//import static sun.swing.SwingUtilities2.submit;

public class LAB03_TASK1_K213868 extends JFrame implements ActionListener {

    JButton add,edit,find;
    JTextField userNAME, PHONE_field, ADDRESS_field;
    JLabel error;
    int i =0;

    String name[] = new String[10];
    int phone[] = new int[10];
    String address[] = new String[10];


    LAB03_TASK1_K213868() {

        setSize(530, 300);
        setLocation(350, 200);
        setTitle("TASK 1 K213868");
        setLayout(null);


        //panel
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(250, 250, 169));
        p1.setBounds(0, 0, 530, 400);

        p1.setLayout(null);
        add(p1);


        //////////////////////////////////////////////////////////////////////////////////


        //tag
        JLabel TAG = new JLabel("ADDRESS BOOK :");
        TAG.setBounds(115, 5, 500, 100);
        TAG.setFont(new Font("OSWALD", Font.BOLD, 25));
        p1.add(TAG);


        //adding email
        JLabel userName = new JLabel("NAME :");
        userName.setBounds(115, 50, 500, 100);
        userName.setFont(new Font("OSWALD", Font.BOLD, 13));
        p1.add(userName);

        userNAME = new JTextField("here");
        userNAME.setBounds(215, 90, 145, 22);
        userNAME.setFont(new Font("SAN SERIF", Font.BOLD, 12));
        p1.add(userNAME);

        //adding passwordField
        JLabel phone = new JLabel("PHONE NUMBER :");
        phone.setBounds(115, 80, 500, 100);
        phone.setForeground(new Color(0, 98, 105));
        phone.setFont(new Font("OSWALD", Font.BOLD, 13));
        p1.add(phone);

        PHONE_field = new JTextField("here");
        PHONE_field.setBounds(215, 120, 145, 22);
        p1.add(PHONE_field);

        //AGE
        JLabel address = new JLabel("ADDRESS :");
        address.setBounds(115, 110, 500, 100);
        address.setForeground(new Color(0, 98, 105));
        address.setFont(new Font("OSWALD", Font.BOLD, 13));
        p1.add(address);

        ADDRESS_field = new JTextField("here");
        ADDRESS_field.setBounds(215, 150, 145, 22);
        p1.add(ADDRESS_field);

        add = new JButton("ADD");
        add.setBounds(300, 200, 60, 19);
        add.setBackground(new Color(159, 142, 28));
        add.setForeground(Color.BLACK);
        add.setFont(new Font("SAN SERIF", Font.BOLD, 9));
        add.addActionListener(this);
        p1.add(add);

        edit = new JButton("EDIT");
        edit.setBounds(115, 200, 60, 19);
        edit.setBackground(new Color(159, 142, 28));
        edit.setForeground(Color.BLACK);
        edit.setFont(new Font("SAN SERIF", Font.BOLD, 9));
//        submit.addActionListener(e -> submit());
        edit.addActionListener(this);
        p1.add(edit);


        find = new JButton("FIND");
        find.setBounds(210, 200, 60, 19);
        find.setBackground(new Color(159, 142, 28));
        find.setForeground(Color.BLACK);
        find.setFont(new Font("SAN SERIF", Font.BOLD, 9));
//        submit.addActionListener(e -> submit());
        find.addActionListener(this);
        p1.add(find);


        //panel-3
        JPanel p3 = new JPanel();
        p3.setBounds(0, 0, 15, 400);
        p3.setBackground(new Color(159, 142, 28));
        p1.add(p3);

        setVisible(true);
    }


    public static void main(String[] args) {
        new LAB03_TASK1_K213868();
    }

    int find_flag=0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
//            JOptionPane.showMessageDialog(this,"Please fill the info first");
                if(userNAME.getText().equals("") || ADDRESS_field.getText().equals("") ||PHONE_field.getText().equals("")){
                    JOptionPane.showMessageDialog(this,"Please fill the info first");
                }else{
                        name[i]=userNAME.getText();
                        phone[i]= Integer.parseInt(PHONE_field.getText());
                        address[i]= ADDRESS_field.getText();


                    System.out.println(phone[i]);
                    System.out.println(address[i]);
                    System.out.println(name[i]);
                        i++;


                        userNAME.setText("");
                        PHONE_field.setText("");
                        ADDRESS_field.setText("");


                }

        }else if(e.getSource()==find){

            String number = JOptionPane.showInputDialog("Enter number");
            int num = Integer.parseInt(number);

            for (int j = 0; j <10 ; j++) {
                System.out.println("phone = "+phone[i]+ "   flag = "+find_flag + "   j = "+j+"   num = "+num);
                        if(num == phone[j]){
                            find_flag=1;
                            System.out.println("i found, now placing flag");
                        }
            }


            if(find_flag == 1){
                System.out.println("flag 1");
                JOptionPane.showMessageDialog(this,"found");
            }else{
                System.out.println("flag 0");
                JOptionPane.showMessageDialog(this,"Not found");
            }


//                new find();
        }else if(e.getSource()==edit){
            int find_flag =0;
            int getIndexValue=0;

            String number = JOptionPane.showInputDialog("Enter Number");
            int num = Integer.parseInt(number);

            for (int j = 0; j <10 ; j++) {
                System.out.println("phone = "+phone[i]+ "   flag = "+find_flag + "   j = "+j+"   num = "+num);
                if(num == phone[j]){
                    find_flag=1;
                    getIndexValue=j;
                    System.out.println("i found, now placing flag");
                }
            }

            String Name = JOptionPane.showInputDialog("Enter Updated Name");
            String Address = JOptionPane.showInputDialog("Enter Updated address");

            name[getIndexValue]= Name;
            address[getIndexValue]= Address;

            JOptionPane.showMessageDialog(this,"Updated...");
        }


    }
}
