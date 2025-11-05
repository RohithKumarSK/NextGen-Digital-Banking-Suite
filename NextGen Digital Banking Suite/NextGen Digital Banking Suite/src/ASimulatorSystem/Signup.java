package nextgen.digital.banking.suite;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Signup extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JRadioButton r1, r2, r3, r4, r5;
    JButton b;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    Signup() {

        setTitle("NEW ACCOUNT APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(100, 0, 100, 100);
        add(l11);

        l1 = new JLabel("APPLICATION FORM NO. " + first);
        l1.setFont(new Font("Raleway", Font.BOLD, 25));

        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 16));

        l4 = new JLabel("Father's Name:");
        l4.setFont(new Font("Raleway", Font.BOLD, 16));

        l5 = new JLabel("Date of Birth:");
        l5.setFont(new Font("Raleway", Font.BOLD, 16));

        l6 = new JLabel("Gender:");
        l6.setFont(new Font("Raleway", Font.BOLD, 16));

        l7 = new JLabel("Email Address:");
        l7.setFont(new Font("Raleway", Font.BOLD, 16));

        l8 = new JLabel("Marital Status:");
        l8.setFont(new Font("Raleway", Font.BOLD, 16));

        l9 = new JLabel("Address:");
        l9.setFont(new Font("Raleway", Font.BOLD, 16));

        l10 = new JLabel("City:");
        l10.setFont(new Font("Raleway", Font.BOLD, 16));

        l11 = new JLabel("Pin Code:");
        l11.setFont(new Font("Raleway", Font.BOLD, 16));

        l12 = new JLabel("State:");
        l12.setFont(new Font("Raleway", Font.BOLD, 16));

        l13 = new JLabel("Date");
        l13.setFont(new Font("Raleway", Font.BOLD, 12));

        l14 = new JLabel("Month");
        l14.setFont(new Font("Raleway", Font.BOLD, 12));

        l15 = new JLabel("Year");
        l15.setFont(new Font("Raleway", Font.BOLD, 12));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 12));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 12));

        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 12));

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 12));

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 12));

        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 12));

        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 12));

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLUE);
        b.setForeground(Color.WHITE);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 12));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 12));
        r2.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 12));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 12));
        r4.setBackground(Color.WHITE);

        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 12));
        r5.setBackground(Color.WHITE);

        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);

        dateChooser = new JDateChooser();
        //dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(137, 337, 200, 29);
        add(dateChooser);

        setLayout(null);
        l1.setBounds(250, 20, 600, 40);
        add(l1);

        l2.setBounds(290, 80, 600, 30);
        add(l2);

        l3.setBounds(100, 140, 100, 20);
        add(l3);

        t1.setBounds(300, 140, 400, 20);
        add(t1);

        l4.setBounds(100, 170, 200, 20);
        add(l4);

        t2.setBounds(300, 170, 400, 20);
        add(t2);

        l5.setBounds(100, 200, 200, 20);
        add(l5);

        dateChooser.setBounds(300, 200, 400, 20);

        l6.setBounds(100, 230, 200, 20);
        add(l6);

        r1.setBounds(300, 230, 60, 20);
        add(r1);

        r2.setBounds(450, 230, 90, 20);
        add(r2);

        l7.setBounds(100, 260, 200, 20);
        add(l7);

        t3.setBounds(300, 260, 400, 20);
        add(t3);

        l8.setBounds(100, 290, 200, 20);
        add(l8);

        r3.setBounds(300, 290, 100, 20);
        add(r3);

        r4.setBounds(450, 290, 100, 20);
        add(r4);

        r5.setBounds(635, 290, 100, 20);
        add(r5);

        l9.setBounds(100, 320, 200, 20);
        add(l9);

        t4.setBounds(300, 320, 400, 20);
        add(t4);

        l10.setBounds(100, 350, 200, 20);
        add(l10);

        t5.setBounds(300, 350, 400, 20);
        add(t5);

        l11.setBounds(100, 380, 200, 20);
        add(l11);

        t6.setBounds(300, 380, 400, 20);
        add(t6);

        l12.setBounds(100, 410, 200, 20);
        add(l12);

        t7.setBounds(300, 410, 400, 20);
        add(t7);

        b.setBounds(620, 440, 80, 30);
        add(b);

        b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 600);
        setLocation(210, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String formno = first;
        String name = t1.getText();
        String fname = t2.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }

        String email = t3.getText();
        String marital = null;
        if (r3.isSelected()) {
            marital = "Married";
        } else if (r4.isSelected()) {
            marital = "Unmarried";
        } else if (r5.isSelected()) {
            marital = "Other";
        }

        String address = t4.getText();
        String city = t5.getText();
        String pincode = t6.getText();
        String state = t7.getText();

        try {

            if (t6.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Conn c1 = new Conn();
                String q1 = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                c1.s.executeUpdate(q1);

                new Signup2(first).setVisible(true);
                setVisible(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
