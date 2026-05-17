package com.mycompany.viewprofile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ViewProfile extends JFrame {
    
    private JLabel brandName, profilePicLabel, usernameLabel, userRoleLabel;
    private JButton logoutButton;
    private JPanel card;
    private String loggedInUser;
    
 
    public ViewProfile (String username) {
        this.loggedInUser = username;
 
        setTitle("Profile");
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
        brandName.setBounds(25, 20, 300, 50);
        card.add(brandName);
 
      
        JSeparator sep = new JSeparator();
        sep.setBounds(30, 72, 290, 2);
        sep.setForeground(new Color(220, 220, 220));
        card.add(sep);
 
      
        profilePicLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
             
                g2d.setColor(new Color(220, 220, 220));
                g2d.fillOval(0, 0, 90, 90);
 
               
                g2d.setColor(new Color(180, 180, 180));
                g2d.fillOval(27, 15, 36, 36);
 
                
                g2d.fillRoundRect(15, 57, 60, 33, 30, 30);
            }
        };
        profilePicLabel.setBounds(130, 90, 90, 90);
        card.add(profilePicLabel);
        
      
        usernameLabel = new JLabel(loggedInUser, SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 20));
        usernameLabel.setForeground(Color.DARK_GRAY);
        usernameLabel.setBounds(50, 195, 250, 30);
        card.add(usernameLabel);
 
     
        userRoleLabel = new JLabel("Member", SwingConstants.CENTER);
        userRoleLabel.setFont(new Font("Serif", Font.PLAIN, 13));
        userRoleLabel.setForeground(Color.LIGHT_GRAY);
        userRoleLabel.setBounds(50, 225, 250, 20);
        card.add(userRoleLabel);
 
       
        JSeparator sep2 = new JSeparator();
        sep2.setBounds(30, 265, 290, 2);
        sep2.setForeground(new Color(220, 220, 220));
        card.add(sep2);
 
     
        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Serif", Font.PLAIN, 16));
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setForeground(Color.DARK_GRAY);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        logoutButton.setBounds(50, 310, 250, 40);
        card.add(logoutButton);
 
  
        logoutButton.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginPage login = new LoginPage();
                login.setVisible(true);
            }
        });
    }
}