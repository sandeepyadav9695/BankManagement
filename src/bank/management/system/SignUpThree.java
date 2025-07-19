package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SignUpThree extends JFrame implements ActionListener {
	
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton cancel,submit;
	String formno;

    SignUpThree(String formno) {
    	this.formno=formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setBounds(250, 50, 400, 30);
        l1.setFont(new Font("Raleway",Font.BOLD,25));
        l1.setBackground(Color.WHITE);
        add(l1);
        
        JLabel acc = new JLabel("Account Type");
        acc.setBounds(100,120,150,30);
        acc.setBackground(Color.WHITE);
        acc.setFont(new Font("Raleway",Font.BOLD,20));
        add(acc);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100,160,150,20);
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit");
        r2.setBounds(350,160,150,20);
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(100,210,150,20);
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,210,250,20);
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup groupacc = new ButtonGroup();
        groupacc.add(r1);
        groupacc.add(r2);
        groupacc.add(r3);
        groupacc.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Ralewat",Font.BOLD,20));
        card.setBounds(100,270,150,30);
        card.setBackground(Color.WHITE);
        add(card);
        
        JLabel carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("Ralewat",Font.BOLD,10));
        carddetails.setBounds(100,300,250,30);
        carddetails.setBackground(Color.WHITE);
        add(carddetails);
        
        JLabel valcard = new JLabel("XXXX-XXXX-XXXX-5089");
        valcard.setFont(new Font("Ralewat",Font.BOLD,20));
        valcard.setBounds(350,265,250,30);
        valcard.setBackground(Color.WHITE);
        add(valcard);
        
        JLabel pin = new JLabel("PIN Number");
        pin.setFont(new Font("Ralewat",Font.BOLD,20));
        pin.setBounds(100,330,150,30);
        pin.setBackground(Color.WHITE);
        add(pin);
        
        JLabel pindetails = new JLabel("Your 4 Digit Password");
        pindetails.setFont(new Font("Ralewat",Font.BOLD,10));
        pindetails.setBounds(100,355,150,30);
        pindetails.setBackground(Color.WHITE);
        add(pindetails);
        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Ralewat",Font.BOLD,20));
        pinnumber.setBounds(350,330,150,30);
        pinnumber.setBackground(Color.WHITE);
        add(pinnumber);
        
        JLabel service = new JLabel("Service Required");
        service.setFont(new Font("Ralewat",Font.BOLD,20));
        service.setBounds(100,400,250,30);
        service.setBackground(Color.WHITE);
        add(service);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBounds(100,430,150,20);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        c2.setBounds(350,430,150,20);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        c3.setBounds(100,470,150,20);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        c4.setBounds(350,470,200,20);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,14));
        c5.setBounds(100,520,150,20);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,14));
        c6.setBounds(350,520,150,20);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7 = new JCheckBox("I have declear that the above entered details are correct to the best of my knowledge ");
        c7.setFont(new Font("Raleway",Font.BOLD,10));
        c7.setBounds(100,560,500,20);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBackground(Color.BLUE);
        submit.setBounds(200,600,100,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
        cancel.setBackground(Color.RED);
        cancel.setBounds(400,600,100,30);
        add(cancel);
        cancel.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
       

       
       
        setSize(750, 750);
        setVisible(true); 
    }
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==submit) {
    		String accountType = null;
    		if(r1.isSelected()) {
    	    	accountType = "Saving Account";
    	    	}
    		else if(r2.isSelected()) {
    			accountType="Fixed Deposit";
    		}
    		else if(r3.isSelected()) {
    			accountType = "Curent Account";
    		}
    		else if(r4.isSelected()) {
    			accountType = "Recurring Deposit Account";
    		}
    		Random random = new Random();
    		String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 9080706000000000L);
    		
    		String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
    		
    		String facility = "";
    		if(c1.isSelected()) {
    			facility = facility+"ATM Card";
    		}
    		else if(c2.isSelected()) {
    			facility = facility +"Internet Banking";
    		}
    		else if(c3.isSelected()) {
    			facility = facility +"Mobile Bnaking";
    		}
    		else if(c4.isSelected()) {
    			facility = facility +"Emai & SMS Alert";
    		}
    		else if(c5.isSelected()) {
    			facility = facility +"Cheque Book";
    		}
    		else if(c6.isSelected()) {
    			facility = facility +"E- Statement";
    		}
    		
    		
    		try {
    			if(accountType.equals("")) {
    				JOptionPane.showMessageDialog(null, "Account Type is Required");
    			}else if(!c7.isSelected()) {
    				JOptionPane.showMessageDialog(null,"please conform this declearate");
    			}else {
    				Connect conn = new Connect();
                    String query = "INSERT INTO SignUpThree VALUES('" + formno + "','" + accountType + "','" + cardNumber + "','" + pinNumber + "','" + facility + "')";
                    conn.sat.executeUpdate(query);
    				
                    String query1 = "INSERT INTO Login1 VALUES('" + formno + "','" + cardNumber + "','" + pinNumber + "')";
                    conn.sat.executeUpdate(query1);
                    
                    new Deposit(pinNumber).setVisible(true);
                    setVisible(false);
    			}
    			
    		}catch(Exception e) {
    			System.out.println(e);
    		}	
    		
    	}
    	else if(ae.getSource()==cancel) {
    		setVisible(false);
    		new Login().setVisible(true);
    	}
    	
    }

    public static void main(String[] args) {
        new SignUpThree("").setVisible(true);
    }
}
