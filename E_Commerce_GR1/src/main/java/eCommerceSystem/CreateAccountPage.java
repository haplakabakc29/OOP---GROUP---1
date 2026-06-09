package eCommerceSystem;

import eCommerceDB.DataBaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateAccountPage extends JFrame {

    private JTextField usernameField, streetField, cityField, provinceField;
    private JPasswordField passwordField, confirmPassField;
    private JButton registerButton, btnLogin;
    private JLabel lblLogo, brandName, tagline, tagline2, alreadyLbl, formTitle, 
            formSub, lblUsername, lblPass, lblConfirm, lblStreet, lblCity, lblProvince;

    public CreateAccountPage() {
        setTitle("Create Account");
        setSize(820, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
//      getContentPane().setBackground(Color.WHITE);

        // LEFT PANEL - back
        JPanel leftPanel = new JPanel(null);
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBounds(0, 0, 280, 520);
        add(leftPanel);

        java.net.URL logo = eCommerceSystem.BrowsePage.class.getClassLoader().getResource("logo.jpg");
        ImageIcon logoRaw = new ImageIcon(logo);
        Image logoScale = logoRaw.getImage().getScaledInstance(330, 320, Image.SCALE_SMOOTH);
        ImageIcon logoIcon = new ImageIcon(logoScale);

        lblLogo = new JLabel(logoIcon, SwingConstants.CENTER);
        lblLogo.setBounds(100, 110, 90, 85);
        leftPanel.add(lblLogo);

        brandName = new JLabel("Gadget Market", SwingConstants.CENTER);
        brandName.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        brandName.setForeground(Color.WHITE);
        brandName.setBounds(20, 190, 240, 35);
        leftPanel.add(brandName);

        tagline = new JLabel("The Best Gadget Shop", SwingConstants.CENTER);
        tagline.setFont(new Font("Serif", Font.ITALIC, 13));
        tagline.setForeground(new Color(180, 180, 180));
        tagline.setBounds(20, 225, 240, 20);
        leftPanel.add(tagline);

        tagline2 = new JLabel("in PUP Biñan", SwingConstants.CENTER);
        tagline2.setFont(new Font("Serif", Font.ITALIC, 13));
        tagline2.setForeground(new Color(180, 180, 180));
        tagline2.setBounds(20, 243, 240, 20);
        leftPanel.add(tagline2);

        JSeparator leftSep = new JSeparator();
        leftSep.setBounds(60, 283, 160, 1);
        leftSep.setForeground(new Color(90, 90, 90));
        leftPanel.add(leftSep);

        alreadyLbl = new JLabel("Already have an account?", SwingConstants.CENTER);
        alreadyLbl.setFont(new Font("Serif", Font.PLAIN, 12));
        alreadyLbl.setForeground(new Color(160, 160, 160));
        alreadyLbl.setBounds(20, 298, 240, 20);
        leftPanel.add(alreadyLbl);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Serif", Font.PLAIN, 13));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setForeground(Color.DARK_GRAY);
        btnLogin.setBounds(65, 325, 150, 33);
        leftPanel.add(btnLogin);


        // RIGHT PANEL - form
        JPanel rightPanel = new JPanel(null);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(280, 0, 540, 520);
        add(rightPanel);

        formTitle = new JLabel("Create Account");
        formTitle.setFont(new Font("Serif", Font.BOLD, 26));
        formTitle.setForeground(Color.DARK_GRAY);
        formTitle.setBounds(40, 35, 300, 35);
        rightPanel.add(formTitle);

        formSub = new JLabel("Fill in your details to get started.");
        formSub.setFont(new Font("Serif", Font.ITALIC, 13));
        formSub.setForeground(Color.LIGHT_GRAY);
        formSub.setBounds(40, 68, 300, 20);
        rightPanel.add(formSub);

        JSeparator topSep = new JSeparator();
        topSep.setBounds(40, 95, 460, 1);
        topSep.setForeground(new Color(230, 230, 230));
        rightPanel.add(topSep);

        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Serif", Font.PLAIN, 13));
        lblUsername.setForeground(Color.GRAY);
        lblUsername.setBounds(40, 108, 200, 20);
        rightPanel.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        usernameField.setFont(new Font("Serif", Font.PLAIN, 14));
        usernameField.setForeground(Color.DARK_GRAY);
        usernameField.setBounds(40, 130, 460, 36);
        rightPanel.add(usernameField);

        lblPass = new JLabel("Password");
        lblPass.setFont(new Font("Serif", Font.PLAIN, 13));
        lblPass.setForeground(Color.GRAY);
        lblPass.setBounds(40, 178, 200, 20);
        rightPanel.add(lblPass);

        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        passwordField.setFont(new Font("Serif", Font.PLAIN, 14));
        passwordField.setForeground(Color.DARK_GRAY);
        passwordField.setBounds(40, 200, 220, 36);
        rightPanel.add(passwordField);

        lblConfirm = new JLabel("Confirm Password");
        lblConfirm.setFont(new Font("Serif", Font.PLAIN, 13));
        lblConfirm.setForeground(Color.GRAY);
        lblConfirm.setBounds(280, 178, 200, 20);
        rightPanel.add(lblConfirm);

        confirmPassField = new JPasswordField();
        confirmPassField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        confirmPassField.setFont(new Font("Serif", Font.PLAIN, 14));
        confirmPassField.setForeground(Color.DARK_GRAY);
        confirmPassField.setBounds(280, 200, 220, 36);
        rightPanel.add(confirmPassField);

        lblStreet = new JLabel("Street, Subdivision, & Barangay");
        lblStreet.setFont(new Font("Serif", Font.PLAIN, 13));
        lblStreet.setForeground(Color.GRAY);
        lblStreet.setBounds(40, 248, 200, 20);
        rightPanel.add(lblStreet);

        streetField = new JTextField();
        streetField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        streetField.setFont(new Font("Serif", Font.PLAIN, 14));
        streetField.setForeground(Color.DARK_GRAY);
        streetField.setBounds(40, 270, 460, 36);
        rightPanel.add(streetField);

        lblCity = new JLabel("City");
        lblCity.setFont(new Font("Serif", Font.PLAIN, 13));
        lblCity.setForeground(Color.GRAY);
        lblCity.setBounds(40, 318, 200, 20);
        rightPanel.add(lblCity);

        cityField = new JTextField();
        cityField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        cityField.setFont(new Font("Serif", Font.PLAIN, 14));
        cityField.setForeground(Color.DARK_GRAY);
        cityField.setBounds(40, 340, 220, 36);
        rightPanel.add(cityField);

        lblProvince = new JLabel("Province");
        lblProvince.setFont(new Font("Serif", Font.PLAIN, 13));
        lblProvince.setForeground(Color.GRAY);
        lblProvince.setBounds(280, 318, 200, 20);
        rightPanel.add(lblProvince);

        provinceField = new JTextField();
        provinceField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        provinceField.setFont(new Font("Serif", Font.PLAIN, 14));
        provinceField.setForeground(Color.DARK_GRAY);
        provinceField.setBounds(280, 340, 220, 36);
        rightPanel.add(provinceField);

        registerButton = new JButton("Create Account");
        registerButton.setFont(new Font("Serif", Font.BOLD, 15));
        registerButton.setBackground(new Color(45, 45, 45));
        registerButton.setForeground(Color.WHITE);
        registerButton.setBorderPainted(false);
        registerButton.setBounds(40, 400, 460, 45);
        rightPanel.add(registerButton);


        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginPage login = new LoginPage();
                login.setVisible(true);
            }
        });

    registerButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String confirmPass = new String(confirmPassField.getPassword()).trim();
            String street = streetField.getText().trim();
            String city = cityField.getText().trim();
            String province = provinceField.getText().trim();

            if (
                    username.isEmpty() || 
                    password.isEmpty() || 
                    confirmPass.isEmpty() || 
                    street.isEmpty() || 
                    city.isEmpty() || 
                    province.isEmpty()
                    ) 
            {
                JOptionPane.showMessageDialog(
                        null, 
                        "Please fill in all fields", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (username.length() < 3) {
                JOptionPane.showMessageDialog(
                        null, 
                        "Username must be at least 3 characters", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (street.length() < 5) {
                JOptionPane.showMessageDialog(
                        null, 
                        "Please input your Street No. and Barangay/Subdivision", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
                }

                if (city.length() < 3) {
                JOptionPane.showMessageDialog(
                        null, 
                        "Please input your City", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
                }

                if (province.length() < 3) {
                JOptionPane.showMessageDialog(
                        null, 
                        "Please input your Province", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
                }

            if (password.length() < 6) {
                JOptionPane.showMessageDialog(
                        null, 
                        "Password must be at least 6 characters", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(confirmPass)) {
                JOptionPane.showMessageDialog(
                        null, 
                        "Passwords do not match!", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }


            String sql = "INSERT INTO users (username, password, street, city, province) VALUES (?, ?, ?, ?, ?)";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                if (conn != null) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    pstmt.setString(3, street);
                    pstmt.setString(4, city);
                    pstmt.setString(5, province);

                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(
                            null, 
                            "Account created successfully!\nYou can now log in.", 
                            "Success", 
                            JOptionPane.INFORMATION_MESSAGE);

                    dispose();
                    LoginPage login = new LoginPage();
                    login.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(
                            null, 
                            "Database Connection Error! Check your XAMPP Status.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null, 
                        "Database Error: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                
                ex.printStackTrace();
            }
            }
        });
    }
}