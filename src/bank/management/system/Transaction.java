package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Transaction extends JFrame implements ActionListener {

    JButton depositBtn, withdrawBtn, fastCashBtn, miniStatementBtn, pinChangeBtn, balanceEnquiryBtn, exitBtn;
    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setFont(new Font("System", Font.BOLD, 17));
        text.setForeground(Color.WHITE);
        text.setBounds(235, 300, 700, 35);
        image.add(text);

        depositBtn = new JButton("Deposit");
        depositBtn.setFont(new Font("System", Font.BOLD, 13));
        depositBtn.setBounds(160, 415, 130, 30);
        depositBtn.addActionListener(this);
        image.add(depositBtn);

        withdrawBtn = new JButton("Cash Withdraw");
        withdrawBtn.setFont(new Font("System", Font.BOLD, 13));
        withdrawBtn.setBounds(370, 415, 130, 30);
        withdrawBtn.addActionListener(this);
        image.add(withdrawBtn);

        fastCashBtn = new JButton("Fast Cash");
        fastCashBtn.setFont(new Font("System", Font.BOLD, 13));
        fastCashBtn.setBounds(160, 450, 130, 30);
        fastCashBtn.addActionListener(this);
        image.add(fastCashBtn);

        miniStatementBtn = new JButton("Mini Statement");
        miniStatementBtn.setFont(new Font("System", Font.BOLD, 13));
        miniStatementBtn.setBounds(370, 450, 130, 30);
        miniStatementBtn.addActionListener(this);
        image.add(miniStatementBtn);

        pinChangeBtn = new JButton("Pin Change");
        pinChangeBtn.setFont(new Font("System", Font.BOLD, 13));
        pinChangeBtn.setBounds(160, 485, 130, 30);
        pinChangeBtn.addActionListener(this);
        image.add(pinChangeBtn);

        balanceEnquiryBtn = new JButton("Balance Enquiry");
        balanceEnquiryBtn.setFont(new Font("System", Font.BOLD, 13));
        balanceEnquiryBtn.setBounds(370, 485, 130, 30);
        balanceEnquiryBtn.addActionListener(this);
        image.add(balanceEnquiryBtn);

        exitBtn = new JButton("Exit");
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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositBtn) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawBtn) {
            setVisible(false);
            new  withdrawBtn(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastCashBtn) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == miniStatementBtn) {
            new MiniStatement(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinChangeBtn) {
            setVisible(false);
            new ChangePin(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiryBtn) {
            setVisible(false);
            new BalanceEnquery(pinnumber).setVisible(true);
        } else if (ae.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transaction("").setVisible(true);
    }
}
