package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ChangePin extends JFrame implements ActionListener{
	JButton b1,back;
	JLabel pin,newPin1;
	String pinnumber;
	JPasswordField newPin, reNewPin;
	ChangePin(String pinnumber){
		
		this.pinnumber=pinnumber;
		
       setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
		Image i2 =i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		JLabel text = new JLabel("Change Your Pin");
		text.setFont(new Font("System",Font. BOLD,17));
		text.setForeground(Color.WHITE);
		text.setBounds(250,300,300,35);
		image.add(text);
		
		
		pin = new JLabel("New Pin : ");
		pin.setFont(new Font("System",Font.BOLD,12));
		pin.setForeground(Color.WHITE);
		pin.setBounds(170,350,100,35);
		image.add(pin);
		
		newPin = new JPasswordField();
		newPin.setBounds(355,350,150,25);
		image.add(newPin);
		
		newPin1 = new JLabel("Re-Enter New Pin : ");
		newPin1.setFont(new Font("System",Font.BOLD,12));
		newPin1.setForeground(Color.WHITE);
		newPin1.setBounds(170,400,150,35);
		image.add(newPin1);
		
		reNewPin = new JPasswordField();
		reNewPin.setBounds(355,400,150,25);
		image.add(reNewPin);
		
		b1 = new JButton("Change");
		b1.setFont(new Font("System",Font.BOLD,17));
		b1.setForeground(Color.GREEN);
		b1.addActionListener(this);
		b1.setBounds(370,480,130,30);
		image.add(b1);
		
		back = new JButton("Back");
		back.setFont(new Font("System",Font.BOLD,17));
		back.setForeground(Color.RED);
		back.addActionListener(this);
		back.setBounds(370,520,130,30);
		image.add(back);
		
		
		
		setSize(900,900);
        setLocation(300,0);
        
//        setUndecorated(true);
        setVisible(true);
        setLayout(null);

	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String npin = pin.getText();
				String repin1 = newPin1.getText();
				
				if(!npin.equals(repin1)) {
					JOptionPane.showMessageDialog(null, "Enter Pin does not match");
					return;
				}
				else if(repin1.equals("")) {
					JOptionPane.showMessageDialog(null, "Please ReEnter NewPin");
					return;
				}
				
				Connect conn = new Connect();
				String query1 = "update bank set pinnumber = '"+repin1+"' where pinnumber = '"+pinnumber+",";
				String query2 = "update Login1 set pin = '"+repin1+"' where pin = '"+pinnumber+",";
				String query3 = "update SignUpThree set pinnumber = '"+repin1+"' where pinumber = '"+pinnumber+",";
				
				conn.sat.execute(query1);
				conn.sat.execute(query2);
				conn.sat.execute(query3);
				
				JOptionPane.showMessageDialog(null, "Pin Changed Successfully.");
				
				setVisible(false);
				new Transaction(repin1).setVisible(true);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}else {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangePin("");

	}

}
