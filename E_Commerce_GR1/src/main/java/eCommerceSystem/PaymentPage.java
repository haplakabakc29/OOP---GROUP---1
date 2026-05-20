package eCommerceSystem;
import eCommerceData.LoggedUserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPage extends JFrame implements ActionListener {
    
    private JLabel mainTitle, methodLabel, cardNumberLabel, expiryLabel, cvvLabel;
    private JPanel card;
    private JRadioButton cardInfoRadio;
    private JTextField cardNumberField, expiryField, cvvField;
    private JButton confirmButton, btnBack;
    private String cardNumber, cvv, expiry;
    
    private LoggedUserData userPP;
    
    public PaymentPage(LoggedUserData user) {
        this.userPP = user;

        setTitle("Payment Page");
        setSize(550, 560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);

        btnBack = new JButton("← Back");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(Color.DARK_GRAY);
        btnBack.setFont(new Font("Serif", Font.PLAIN, 14));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this);
        add(btnBack);

        mainTitle = new JLabel("Payment Page", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 22));
        mainTitle.setForeground(Color.DARK_GRAY);
        mainTitle.setBounds(100, 15, 350, 30);
        add(mainTitle);
        
        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.setBounds(80, 60, 380, 430);
        add(card);
        
        methodLabel = new JLabel("Select Payment Method");
        methodLabel.setFont(new Font("Serif", Font.BOLD, 15));
        methodLabel.setForeground(Color.DARK_GRAY);
        methodLabel.setBounds(25, 20, 250, 25);
        card.add(methodLabel);
        
        cardInfoRadio = new JRadioButton("Card Info");
        cardInfoRadio.setBackground(Color.WHITE);
        cardInfoRadio.setForeground(Color.DARK_GRAY);
        cardInfoRadio.setFont(new Font("Serif", Font.PLAIN, 14));
        cardInfoRadio.setSelected(true);
        cardInfoRadio.setFocusPainted(false);
        cardInfoRadio.setBounds(25, 55, 100, 25);
        card.add(cardInfoRadio);

        cardNumberLabel = new JLabel("Card Number (16 digits)");
        cardNumberLabel.setFont(new Font("Serif", Font.PLAIN, 13));
        cardNumberLabel.setForeground(Color.DARK_GRAY);
        cardNumberLabel.setBounds(25, 90, 300, 20);
        card.add(cardNumberLabel);
        
        cardNumberField = new JTextField();
        cardNumberField.setBounds(25, 113, 330, 38);
        cardNumberField.setFont(new Font("Serif", Font.PLAIN, 14));
        cardNumberField.setForeground(Color.DARK_GRAY);
        cardNumberField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.add(cardNumberField);
        
        expiryLabel = new JLabel("Expiry Date (MM/YY)");
        expiryLabel.setFont(new Font("Serif", Font.PLAIN, 13));
        expiryLabel.setForeground(Color.DARK_GRAY);
        expiryLabel.setBounds(25, 163, 150, 20);
        card.add(expiryLabel);
        
        expiryField = new JTextField();
        expiryField.setBounds(25, 186, 155, 38);
        expiryField.setFont(new Font("Serif", Font.PLAIN, 14));
        expiryField.setForeground(Color.DARK_GRAY);
        expiryField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.add(expiryField);
        
        cvvLabel = new JLabel("CVV (3-4 digits)");
        cvvLabel.setFont(new Font("Serif", Font.PLAIN, 13));
        cvvLabel.setForeground(Color.DARK_GRAY);
        cvvLabel.setBounds(200, 163, 130, 20);
        card.add(cvvLabel);
        
        cvvField = new JTextField();
        cvvField.setBounds(200, 186, 155, 38);
        cvvField.setFont(new Font("Serif", Font.PLAIN, 14));
        cvvField.setForeground(Color.DARK_GRAY);
        cvvField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.add(cvvField);
        
        confirmButton = new JButton("Confirm Payment");
        confirmButton.setBounds(25, 270, 330, 40);
        confirmButton.setBackground(Color.DARK_GRAY);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("Serif", Font.PLAIN, 14));
        confirmButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(this);
        card.add(confirmButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnBack) {
            dispose();
            
        } else if (e.getSource() == confirmButton) {
          
            cardNumber = cardNumberField.getText().trim();
            expiry = expiryField.getText().trim();
            cvv = cvvField.getText().trim();

            if (cardNumber.length() != 16) {
                JOptionPane.showMessageDialog(null, "Card number must be 16 digits!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (expiry.length() != 5) {
                JOptionPane.showMessageDialog(null, "Expiry must be in MM/YY format!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (cvv.length() < 3 || cvv.length() > 4) {
                JOptionPane.showMessageDialog(null, "CVV must be 3 or 4 digits!", "Error", JOptionPane.ERROR_MESSAGE);
           } else {
    System.out.println("Opening confirmation...");
    System.out.println("User: " + userPP);
    dispose();
    OrderConfirmationPage successScreen = new OrderConfirmationPage(userPP);
    successScreen.setVisible(true);
}
        }
    }
}