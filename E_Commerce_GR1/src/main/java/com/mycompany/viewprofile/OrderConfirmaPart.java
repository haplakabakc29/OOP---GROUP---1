package com.mycompany.viewprofile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderConfirmaPart extends JFrame implements ActionListener {
    
    private JLabel mainTitle, checkIcon, statusLabel, idLabel;
    private JButton trackButton, continueButton;
    private JPanel card;
    
    private loggedUser userOC;
    
    public OrderConfirmaPart(loggedUser user) {
        this.userOC = user;

        
        setTitle("Order Confirmation Screen");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        mainTitle = new JLabel("Order Confirmation", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Serif", Font.ITALIC, 22));
        mainTitle.setForeground(Color.DARK_GRAY);
        mainTitle.setBounds(100, 30, 350, 30);
        add(mainTitle);
        
        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.setBounds(100, 70, 350, 340);
        add(card);
        
        checkIcon = new JLabel("✓", SwingConstants.CENTER);
        checkIcon.setFont(new Font("Monospaced", Font.BOLD, 50));
        checkIcon.setForeground(Color.DARK_GRAY);
        checkIcon.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        checkIcon.setBounds(135, 30, 80, 80);
        card.add(checkIcon);
        
        statusLabel = new JLabel("Order Placed!", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 28));
        statusLabel.setForeground(Color.DARK_GRAY);
        statusLabel.setBounds(25, 130, 300, 40);
        card.add(statusLabel);
        
        idLabel = new JLabel("Order ID: #12345", SwingConstants.CENTER);
        idLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        idLabel.setForeground(Color.DARK_GRAY);
        idLabel.setBounds(25, 175, 300, 30);
        card.add(idLabel);
        
        trackButton = new JButton(user.getConfDisplayInfo());
        trackButton.setFont(new Font("Serif", Font.PLAIN, 14));
        trackButton.setBackground(Color.WHITE);
        trackButton.setForeground(Color.DARK_GRAY);
        trackButton.setFocusPainted(false);
        trackButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        trackButton.setBounds(25, 230, 300, 38);
        card.add(trackButton);
        
        continueButton = new JButton("Continue Browsing");
        continueButton.setFont(new Font("Serif", Font.PLAIN, 12));
        continueButton.setBackground(Color.WHITE);
        continueButton.setForeground(Color.GRAY);
        continueButton.setBorderPainted(false);
        continueButton.setBounds(100, 278, 150, 25);
        continueButton.addActionListener(this);
        card.add(continueButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueButton) {
            dispose();
        }
    }
}