package bank.management.system;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Deposit extends JFrame implements ActionListener {
	
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
	
    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter Amount You Want to Deposit");
        text.setFont(new Font("System", Font.BOLD, 17));
        text.setForeground(Color.WHITE);
        text.setBounds(200, 300, 400, 35);
        image.add(text);

        amount = new JTextField();  // ✅ fixed here
        amount.setBounds(195, 350, 290, 25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("System", Font.BOLD, 17));
        deposit.setForeground(Color.GREEN);
        deposit.setBounds(370, 480, 130, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 17));
        back.setForeground(Color.RED);
        back.setBounds(370, 520, 130, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String amountText = amount.getText();
           
            if (amountText.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount ");
            }
            else {
                try {
                	java.util.Date date = new java.util.Date();
                    String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                    
                	Connect con = new Connect();
                	String query = "insert into bank values('"+pinnumber+"','"+formattedDate+"','Deposit','"+amountText+"')";
                	con.sat.executeUpdate(query);
                	
                	JOptionPane.showMessageDialog(null, "Rs "+amountText+"Deposited Successfully");
                	setVisible(false);
                	new Transaction(pinnumber).setVisible(true);
                }catch(Exception ea) {
                	System.out.println(ea);
                }
            
            }
        }else if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
