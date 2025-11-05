package nextgen.digital.banking.suite;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 700, 700);
        add(l2);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setBounds(145, 230, 700, 35);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l2.add(l1);

        b1 = new JButton("Rs 100");
        b1.setBounds(125, 325, 135, 20);
        b1.addActionListener(this);
        l2.add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(265, 325, 135, 20);
        b2.addActionListener(this);
        l2.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(125, 350, 135, 20);
        b3.addActionListener(this);
        l2.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(265, 350, 135, 20);
        b4.addActionListener(this);
        l2.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(125, 375, 135, 20);
        b5.addActionListener(this);
        l2.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(265, 375, 135, 20);
        b6.addActionListener(this);
        l2.add(b6);

        b7 = new JButton("BACK");
        b7.setBounds(265, 400, 135, 20);
        b7.addActionListener(this);
        l2.add(b7);

        setSize(700, 700);
        setLocation(280, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b7) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdraw Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
