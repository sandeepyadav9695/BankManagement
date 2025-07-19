package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
import java.util.Random;

@SuppressWarnings("serial")
public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField,dobTextField, emailTextField, stateTextField, pinTextField, cityTextField, addressTextField;
    JButton next;
    JRadioButton male, female, other, marries, unmarries;
//    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    SignUpOne() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        first = "" + random;

        JLabel formnoLabel = new JLabel("Application Form No. " + first);
        formnoLabel.setFont(new Font("Raleway", Font.BOLD, 30));
        formnoLabel.setBounds(240, 20, 600, 40);
        add(formnoLabel);

        JLabel personalDetail = new JLabel("Page 1: Personal Details");
        personalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetail.setBounds(290, 80, 400, 30);
        add(personalDetail);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

//        dateChooser = new JDateChooser();
//        dateChooser.setBounds(300, 240, 400, 30);
//        add(dateChooser);
        
        dobTextField = new JTextField();
        dobTextField.setBounds(300, 240, 400, 30);
        add(dobTextField);
       

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        male.setBounds(300, 290, 80, 30);
        female.setBounds(400, 290, 100, 30);
        other.setBounds(520, 290, 100, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        add(male); add(female); add(other);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        unmarries = new JRadioButton("Unmarried");
        marries = new JRadioButton("Married");

        unmarries.setBounds(300, 390, 120, 30);
        marries.setBounds(450, 390, 100, 30);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(unmarries);
        maritalGroup.add(marries);

        add(unmarries); add(marries);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setBounds(300, 540, 400, 30);
        add(pinTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 590, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300, 590, 400, 30);
        add(stateTextField);

        next = new JButton("Next");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dobTextField.getText();
//        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Other");
        String email = emailTextField.getText();
        String maritalStatus = marries.isSelected() ? "Married" : "Unmarried";
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pin = pinTextField.getText();
        String state = stateTextField.getText();

        try {
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Connect con = new Connect();
                String query = "INSERT INTO SignUpOne VALUES('" + first + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + maritalStatus + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                con.sat.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(first).setVisible(true);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpOne().setVisible(true);
    }
}

