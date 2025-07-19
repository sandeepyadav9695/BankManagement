package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

@SuppressWarnings("serial")
class BalanceEnquery extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;
    String pinnumber;

    BalanceEnquery(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 960, 1080);
        add(background);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190, 350, 400, 35);
        background.add(l1);

        b1 = new JButton("BACK");
        b1.setBounds(390, 633, 150, 35);
        background.add(b1);
        b1.addActionListener(this);

        int balance = 0;
        Connect con = new Connect();
        try {
            ResultSet rs = con.sat.executeQuery("SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) { 
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        l1.setText("Your Current Account Balance is Rs " + balance);

        setLayout(null);
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquery("").setVisible(true);
    }
}
