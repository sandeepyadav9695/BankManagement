package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

@SuppressWarnings("serial")
public class FastCash extends JFrame implements ActionListener {

    JButton depositBtn, withdrawBtn, fastCashBtn, miniStatementBtn, pinChangeBtn, balanceEnquiryBtn, exitBtn;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please Select Your Withdraw Amount");
        text.setFont(new Font("System", Font.BOLD, 17));
        text.setForeground(Color.WHITE);
        text.setBounds(190, 310, 700, 35);
        image.add(text);

        depositBtn = new JButton("500");
        depositBtn.setFont(new Font("System", Font.BOLD, 13));
        depositBtn.setBounds(160, 415, 130, 30);
        depositBtn.addActionListener(this);
        image.add(depositBtn);

        withdrawBtn = new JButton("1000");
        withdrawBtn.setFont(new Font("System", Font.BOLD, 13));
        withdrawBtn.setBounds(370, 415, 130, 30);
        withdrawBtn.addActionListener(this);
        image.add(withdrawBtn);

        fastCashBtn = new JButton("1500");
        fastCashBtn.setFont(new Font("System", Font.BOLD, 13));
        fastCashBtn.setBounds(160, 450, 130, 30);
        fastCashBtn.addActionListener(this);
        image.add(fastCashBtn);

        miniStatementBtn = new JButton("2000");
        miniStatementBtn.setFont(new Font("System", Font.BOLD, 13));
        miniStatementBtn.setBounds(370, 450, 130, 30);
        miniStatementBtn.addActionListener(this);
        image.add(miniStatementBtn);

        pinChangeBtn = new JButton("5000");
        pinChangeBtn.setFont(new Font("System", Font.BOLD, 13));
        pinChangeBtn.setBounds(160, 485, 130, 30);
        pinChangeBtn.addActionListener(this);
        image.add(pinChangeBtn);

        balanceEnquiryBtn = new JButton("10000");
        balanceEnquiryBtn.setFont(new Font("System", Font.BOLD, 13));
        balanceEnquiryBtn.setBounds(370, 485, 130, 30);
        balanceEnquiryBtn.addActionListener(this);
        image.add(balanceEnquiryBtn);

        exitBtn = new JButton("Back");
        exitBtn.setFont(new Font("System", Font.BOLD, 17));
        exitBtn.setBounds(370, 520, 130, 30);
        exitBtn.addActionListener(this);
        image.add(exitBtn);

        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

//    public void actionPerformed(ActionEvent ae) {
//            String amount = ((JButton)ae.getSource()).getText().substring(3);
//            Connect con = new Connect();
//            try {
//            ResultSet rs = con.sat.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
//            int balance = 0;
//            while (rs.next()) {
//                if (rs.getString("type").equals("Deposit")) {
//                    balance += Integer.parseInt(rs.getString("amount"));
//                } else {
//                    balance -= Integer.parseInt(rs.getString("amount"));
//                }
//            }
//            String num = "17";
//            if (ae.getSource() != exitBtn && balance < Integer.parseInt(amount)) {
//                JOptionPane.showMessageDialog(null, "Insuffient Balance");
//                return;
//            }
//
//            if (ae.getSource() == exitBtn) {
//                this.setVisible(false);
//                new Transaction(pinNumber).setVisible(true);
//            }else{
//                Date date = new Date();
//                con.sat.executeUpdate("insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
//                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
//                    
//                setVisible(false);
//                new Transaction(pinNumber).setVisible(true);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitBtn) {
            this.setVisible(false);
            new Transaction(pinnumber).setVisible(true);
            return;
        }

        String amount = ((JButton) ae.getSource()).getText();
        Connect con = new Connect();

        try {
            ResultSet rs = con.sat.executeQuery("select * from bank where pinnumber = '" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equalsIgnoreCase("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            java.util.Date date = new java.util.Date();
            String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            con.sat.executeUpdate("insert into bank values('" + pinnumber + "', '" + formattedDate + "', 'Withdraw', '" + amount + "')");
            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
