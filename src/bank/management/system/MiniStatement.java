package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1, b2;
    JLabel text;
    String pinnumber;
    MiniStatement(String pinnumber){
    	
    	
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        
        text = new JLabel();
        add(text);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel bal = new JLabel();
        bal.setBounds(20, 400, 300, 20);
        add(bal);
        
        try{
            Connect con = new Connect();
            ResultSet rs = con.sat.executeQuery("select * from login1 where pin = '3097'");
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        }catch(Exception e){
        	System.out.println(e);
        }
        	 
        try{
            int balance = 0;
            Connect con  = new Connect();
            ResultSet rs = con.sat.executeQuery("SELECT * FROM bank where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>" +rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br></html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            bal.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
        	System.out.println(e);
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);
        
        b1.addActionListener(this);
        
        text.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}