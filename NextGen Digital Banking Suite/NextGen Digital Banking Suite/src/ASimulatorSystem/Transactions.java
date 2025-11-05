package nextgen.digital.banking.suite;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    Transactions(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 700, 700);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setBounds(145, 230, 700, 35);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l2.add(l1);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(120, 325, 140, 20);
        b1.addActionListener(this);
        l2.add(b1);

        b2 = new JButton("WITHDRAWL");
        b2.setBounds(265, 325, 140, 20);
        b2.addActionListener(this);
        l2.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(120, 350, 140, 20);
        b3.addActionListener(this);
        l2.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(265, 350, 140, 20);
        b4.addActionListener(this);
        l2.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(120, 375, 140, 20);
        b5.addActionListener(this);
        l2.add(b5);

        b6 = new JButton("CHECK BALANCE");
        b6.setBounds(265, 375, 140, 20);
        b6.addActionListener(this);
        l2.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(265, 400, 140, 20);
        b7.addActionListener(this);
        l2.add(b7);

        setSize(700, 700);
        setLocation(280, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == b4) {
            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == b5) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == b6) {
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == b7) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
