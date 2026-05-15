package paymentpart;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    private JLabel brandName;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel card;

    public LoginPage() {
        setTitle("Login / Sign Up");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(Color.BLACK, 2));
        card.setBounds(100, 50, 350, 360);
        add(card);

        brandName = new JLabel("Gadget Market", SwingConstants.CENTER);
        brandName.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 32));
        brandName.setBounds(25, 30, 300, 50);
        card.add(brandName);

        emailField = new JTextField();
        emailField.setBorder(new LineBorder(Color.BLACK, 1));
        emailField.setBounds(50, 110, 250, 40);
        card.add(emailField);

        passwordField = new JPasswordField();
        passwordField.setBorder(new LineBorder(Color.BLACK, 1));
        passwordField.setBounds(50, 170, 250, 40);
        card.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setBackground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(new LineBorder(Color.BLACK, 1));
        loginButton.setBounds(50, 240, 250, 40);
        card.add(loginButton);

        
        

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = emailField.getText();
                String password = new String(passwordField.getPassword()); 

                
                if (username.equals("user") && password.equals("123")) {
                    dispose(); 
                    browsePage browsePage = new browsePage(); 
                    browsePage.setVisible(true); 
                } else {
                  
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new LoginPage().setVisible(true);
    }
}