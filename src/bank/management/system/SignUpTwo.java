
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SignUpTwo extends JFrame implements ActionListener {

    JTextField  panTextField, aadharTextField;
    long random;
    JRadioButton seniorYes, seniorNo, existingYes, existingNo;
    JButton next;
    JComboBox<String> religion1, category1, income1, education1, occupation1;
    String formno;

    SignUpTwo(String formno) {
    	this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2"); 

        JLabel additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetail.setBounds(290, 80, 400, 30);
        add(additionalDetail);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 200, 30);
        add(religion);
        
        String valreligion[]= {"Other","Hindu","Muslim","Sikh", "Christion"};
        religion1 = new JComboBox<>(valreligion);
        religion1.setFont(new Font("Arial", Font.BOLD, 14));
        religion1.setBackground(Color.WHITE);
        religion1.setBounds(300, 140, 400, 30);
        add(religion1);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String valCategory[]= {"General","OBC","SC","ST","OTHER"};
        category1 = new JComboBox<>(valCategory);
        category1.setFont(new Font("Arial", Font.BOLD, 14));
        category1.setBackground(Color.WHITE);
        category1.setBounds(300, 190, 400, 30);
        add(category1);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String valIncome[]= {"Null","less 1,50000","Less 2,50000","Less 5,00000","Less 10,00000"};
        income1 = new JComboBox<>(valIncome);
        income1.setFont(new Font("Arial", Font.BOLD, 14));
        income.setBackground(Color.WHITE);
        income1.setBounds(300, 240, 400, 30);
        add(income1);

        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);
        
        String valEducation[]= {"10th","12th","Graduate","PostGraduate","Doctors","OTHER"};
        education1 = new JComboBox<>(valEducation);
        education1.setFont(new Font("Arial", Font.BOLD, 14));
        education1.setBackground(Color.WHITE);
        education1.setBounds(300, 290, 400, 30);
        add(education1);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Simple", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);
        
        String valOccupation[]= {"Student","Salaried","Bussiness","Govermet","Retired","Other"};
        occupation1 = new JComboBox<>(valOccupation);
        occupation1.setFont(new Font("Arial", Font.BOLD, 14));
        occupation1.setBackground(Color.WHITE);
        occupation1.setBounds(300, 340, 400, 30);
        add(occupation1);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 390, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 440, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 490, 200, 30);
        add(senior);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBackground(Color.WHITE);
        seniorYes.setBounds(300, 490, 100, 30);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBackground(Color.WHITE);
        seniorNo.setBounds(400, 490, 100, 30);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 540, 200, 30);
        add(existing);

        existingYes = new JRadioButton("Yes");
        existingYes.setBackground(Color.WHITE);
        existingYes.setBounds(300, 540, 100, 30);
        add(existingYes);

        existingNo = new JRadioButton("No");
        existingNo.setBackground(Color.WHITE);
        existingNo.setBounds(400, 540, 100, 30);
        add(existingNo);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(existingYes);
        existingGroup.add(existingNo);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String religion = (String) religion1.getSelectedItem();
        String category = (String) category1.getSelectedItem();
        String income = (String) income1.getSelectedItem();
        String education =(String) education1.getSelectedItem();
        String occupation = (String) occupation1.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        String senior = seniorYes.isSelected() ? "Yes" : "No";
        String existing = existingYes.isSelected() ? "Yes" : "No";

        // Basic validation example:
        if (religion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Religion is required");
            return;
        }

        try {
            Connect con = new Connect();
            String query = "INSERT INTO signupTwo (religin, category, income, education, Occuption, panNumber, adharNumber, seniorCitizen, existingAccount) " +
                           "VALUES ('" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" + pan + "', '" + aadhar + "', '" + senior + "', '" + existing + "')";
            con.sat.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Details Saved Successfully!");
             setVisible(false);
             new SignUpThree(formno).setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred: " + ex.getMessage());
        }
    }

    

    public static void main(String[] args) {
        new SignUpTwo("").setVisible(true);
    }
}
