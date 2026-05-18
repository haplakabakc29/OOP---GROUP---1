package com.mycompany.viewprofile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    private JLabel brandName, lblEmail, lblPass, lbltagline, lblGroup1;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel card;
    private JSeparator sep, sep2;
    
    private loggedUser userLP;

    public LoginPage() {
        setTitle("Login / Sign Up");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.setBounds(100, 50, 350, 390);
        add(card);

        brandName = new JLabel("Gadget Market", SwingConstants.CENTER);
        brandName.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 34));
        brandName.setForeground(Color.DARK_GRAY);
        brandName.setBounds(25, 25, 300, 45);
        card.add(brandName);

        lbltagline = new JLabel("The Best Gadget Shop in PUP Biñan", SwingConstants.CENTER);
        lbltagline.setFont(new Font("Serif", Font.ITALIC, 13));
        lbltagline.setForeground(Color.LIGHT_GRAY);
        lbltagline.setBounds(25, 70, 300, 20);
        card.add(lbltagline);

        sep = new JSeparator();
        sep.setBounds(50, 97, 250, 1);
        sep.setForeground(new Color(220, 220, 220));
        card.add(sep);

        lblEmail = new JLabel("Full Name");
        lblEmail.setFont(new Font("Serif", Font.PLAIN, 13));
        lblEmail.setForeground(Color.LIGHT_GRAY);
        lblEmail.setBounds(50, 112, 250, 20);
        card.add(lblEmail);

        emailField = new JTextField();
        emailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        emailField.setFont(new Font("Serif", Font.PLAIN, 14));
        emailField.setForeground(Color.DARK_GRAY);
        emailField.setBounds(50, 135, 250, 40);
        card.add(emailField);

        lblPass = new JLabel("Password");
        lblPass.setFont(new Font("Serif", Font.PLAIN, 13));
        lblPass.setForeground(Color.LIGHT_GRAY);
        lblPass.setBounds(50, 185, 250, 20);
        card.add(lblPass);

        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        passwordField.setFont(new Font("Serif", Font.PLAIN, 14));
        passwordField.setForeground(Color.DARK_GRAY);
        passwordField.setBounds(50, 208, 250, 40);
        card.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Serif", Font.PLAIN, 16));
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setBounds(50, 285, 250, 45);
        card.add(loginButton);
        
        sep2 = new JSeparator();
        sep2.setBounds(50, 348, 250, 1);
        sep2.setForeground(new Color(220, 220, 220));
        card.add(sep2);

        lblGroup1 = new JLabel("Made by: Group 1", SwingConstants.CENTER);
        lblGroup1.setFont(new Font("Serif", Font.PLAIN, 10));
        lblGroup1.setForeground(new Color(200, 200, 200));
        lblGroup1.setBounds(25, 358, 300, 20);
        card.add(lblGroup1);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = emailField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

            if (!username.isEmpty() && !password.isEmpty()) {
                loggedUser loggedUSER = new loggedUser(username, password);
                
                dispose();
                browsePage br = new browsePage(loggedUSER);
                br.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter yout Fullname and Password.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
            }
        });
    }
}