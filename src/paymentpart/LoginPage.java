package paymentpart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    
    private JLabel brandName, lblEmail, lblPass;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, createAccountButton;
    private JPanel card;
    
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
        card.setBounds(100, 50, 350, 380);
        add(card);
        
        brandName = new JLabel("Gadget Market", SwingConstants.CENTER);
        brandName.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 34));
        brandName.setForeground(Color.DARK_GRAY);
        brandName.setBounds(25, 30, 300, 50);
        card.add(brandName);
        
        lblEmail = new JLabel("Username: ");
        lblEmail.setFont(new Font("Serif", Font.PLAIN, 13));
        lblEmail.setForeground(Color.LIGHT_GRAY);
        lblEmail.setBounds(50, 95, 250, 20);
        card.add(lblEmail);
        
        emailField = new JTextField();
        emailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        emailField.setFont(new Font("Serif", Font.PLAIN, 14));
        emailField.setForeground(Color.DARK_GRAY);
        emailField.setBounds(50, 118, 250, 40);
        card.add(emailField);
        
        lblPass = new JLabel("Password: ");
        lblPass.setFont(new Font("Serif", Font.PLAIN, 13));
        lblPass.setForeground(Color.LIGHT_GRAY);
        lblPass.setBounds(50, 168, 250, 20);
        card.add(lblPass);
        
        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        passwordField.setFont(new Font("Serif", Font.PLAIN, 14));
        passwordField.setForeground(Color.DARK_GRAY);
        passwordField.setBounds(50, 191, 250, 40);
        card.add(passwordField);
        
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Serif", Font.PLAIN, 16));
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.DARK_GRAY);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        loginButton.setBounds(50, 255, 250, 40);
        card.add(loginButton);
        
        createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Serif", Font.PLAIN, 14));
        createAccountButton.setBackground(Color.WHITE);
        createAccountButton.setForeground(Color.DARK_GRAY);
        createAccountButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        createAccountButton.setBounds(50, 310, 250, 35);
        card.add(createAccountButton);
        
        loginButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String username = emailField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                
                if (username.equals("user") && password.equals("123")) {
                    dispose();
                    browsePage br = new browsePage();
                    br.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}