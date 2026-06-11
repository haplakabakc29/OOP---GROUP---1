package eCommerceSystem;
import eCommerceDB.DataBaseConnection;
import eCommerceData.LoggedUserData;
import eCommerceData.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {

    private JLabel brandName, lblEmail, lblPass, lblTagline, lblGroup1, lblImageLogo;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, createAccountButton;
    private JPanel card;
    private JSeparator sep, sep2;

    public LoginPage() {
        setTitle("Login / Sign Up");
        setSize(550, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.setBounds(100, 25, 350, 470);
        add(card);

        java.net.URL logo = BrowsePage.class.getClassLoader().getResource("logo.jpg");
        ImageIcon logoRaw = new ImageIcon(logo);
        Image logoScale = logoRaw.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH);
        ImageIcon logoIcon = new ImageIcon(logoScale);

        lblImageLogo = new JLabel(logoIcon);
        lblImageLogo.setBounds(145, 25, 50, 50);
        card.add(lblImageLogo);

        brandName = new JLabel("Gadget Market", SwingConstants.CENTER);
        brandName.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 34));
        brandName.setForeground(Color.DARK_GRAY);
        brandName.setBounds(25, 75, 300, 45);
        card.add(brandName);

        lblTagline = new JLabel("The Best Gadget Shop in PUP Biñan", SwingConstants.CENTER);
        lblTagline.setFont(new Font("Serif", Font.ITALIC, 13));
        lblTagline.setForeground(Color.LIGHT_GRAY);
        lblTagline.setBounds(25, 120, 300, 20);
        card.add(lblTagline);

        sep = new JSeparator();
        sep.setBounds(50, 147, 250, 1);
        sep.setForeground(new Color(220, 220, 220));
        card.add(sep);

        lblEmail = new JLabel("Username");
        lblEmail.setFont(new Font("Serif", Font.PLAIN, 13));
        lblEmail.setForeground(Color.LIGHT_GRAY);
        lblEmail.setBounds(50, 162, 250, 20);
        card.add(lblEmail);

        emailField = new JTextField();
        emailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        emailField.setFont(new Font("Serif", Font.PLAIN, 14));
        emailField.setForeground(Color.DARK_GRAY);
        emailField.setBounds(50, 185, 250, 40);
        card.add(emailField);

        lblPass = new JLabel("Password");
        lblPass.setFont(new Font("Serif", Font.PLAIN, 13));
        lblPass.setForeground(Color.LIGHT_GRAY);
        lblPass.setBounds(50, 235, 250, 20);
        card.add(lblPass);

        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        passwordField.setFont(new Font("Serif", Font.PLAIN, 14));
        passwordField.setForeground(Color.DARK_GRAY);
        passwordField.setBounds(50, 258, 250, 40);
        card.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Serif", Font.PLAIN, 16));
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setBounds(50, 320, 250, 45);
        loginButton.addActionListener(this);
        card.add(loginButton);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Serif", Font.PLAIN, 13));
        createAccountButton.setBackground(Color.WHITE);
        createAccountButton.setForeground(Color.DARK_GRAY);
        createAccountButton.setFocusPainted(false);
        createAccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createAccountButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        createAccountButton.setBounds(50, 375, 250, 35);
        createAccountButton.addActionListener(this);
        card.add(createAccountButton);

        sep2 = new JSeparator();
        sep2.setBounds(50, 420, 250, 1);
        sep2.setForeground(new Color(220, 220, 220));
        card.add(sep2);

        lblGroup1 = new JLabel("Made by: Group 1", SwingConstants.CENTER);
        lblGroup1.setFont(new Font("Serif", Font.PLAIN, 10));
        lblGroup1.setForeground(new Color(200, 200, 200));
        lblGroup1.setBounds(25, 430, 300, 20);
        card.add(lblGroup1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createAccountButton) {
            dispose();
            CreateAccountPage register = new CreateAccountPage();
            register.setVisible(true);
            
        } else if (e.getSource() == loginButton) {
            String inputUser = emailField.getText().trim();
            String inputPass = new String(passwordField.getPassword()).trim();

            if (inputUser.isEmpty() || inputPass.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, 
                        "Please enter your Username and Password.", 
                        "Login Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
                if (inputUser.length() < 3) {
                JOptionPane.showMessageDialog(
                        this, 
                        "Username must be at least 3 characters.", 
                        "Login Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (inputPass.length() < 6) {
                JOptionPane.showMessageDialog(
                        this, 
                        "Password must be at least 6 characters.", 
                        "Login Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            LoggedUserData user = null;
            boolean loginSuccess = false;
            boolean dbError = false;

            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, inputUser);
                pstmt.setString(2, inputPass);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String fetchedUser = rs.getString("username");
                        String fetchedPass = rs.getString("password");
                        String fetchedStreet = rs.getString("street");
                        String fetchedCity = rs.getString("city");
                        String fetchedProvince = rs.getString("province");

                        user = new LoggedUserData(fetchedUser, fetchedPass, fetchedStreet, fetchedCity, fetchedProvince);
                        loginSuccess = true;
                    }
                }

            } catch (Exception ex) {
                dbError = true;
                JOptionPane.showMessageDialog(
                        this,
                        "Database Connection Error: " + ex.getMessage(),
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }

            if (!dbError) {
                if (loginSuccess && user != null) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Welcome to Gadget Market!",
                            "Greetings",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    BrowsePage landingPage = new BrowsePage(user);
                    landingPage.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid username or password.",
                            "Login Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
       }
   }
}