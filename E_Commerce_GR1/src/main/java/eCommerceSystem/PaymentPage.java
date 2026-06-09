package eCommerceSystem;
import eCommerceData.LoggedUserData;
import eCommerceData.OrderData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPage extends JFrame implements ActionListener {

    private JLabel mainTitle, methodLabel, lbNum, lbCODTxt, lbCOD, lbGcash, lbCVV, lbExp ;
    private JPanel card, cardPanel, gcashPanel, codPanel;
    private JRadioButton rbCard, rbGcash, rbCOD;
    private JTextField cardNumberField, expiryField, cvvField, gcashField;
    private JButton confirmButton, btnBack;

    private LoggedUserData userPP;
    private int finalCount, finalTotal;

    public PaymentPage(LoggedUserData user, int count, int total) {
        this.userPP     = user;
        this.finalCount = count;
        this.finalTotal = total;
        PaymentPageUI();
    }

    private void PaymentPageUI() {
        setTitle("Payment Page");
        setSize(560, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
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
        mainTitle.setBounds(110, 12, 310, 28);
        add(mainTitle);

        card = new JPanel(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.setBounds(30, 55, 490, 415);
        add(card);

        methodLabel = new JLabel("Select Payment Method");
        methodLabel.setFont(new Font("Serif", Font.BOLD, 15));
        methodLabel.setForeground(Color.DARK_GRAY);
        methodLabel.setBounds(20, 18, 260, 25);
        card.add(methodLabel);

        ButtonGroup bg = new ButtonGroup();

        rbCard = new JRadioButton("Credit / Debit Card");
        rbCard.setBackground(Color.WHITE);
        rbCard.setFont(new Font("Serif", Font.PLAIN, 14));
        rbCard.setSelected(true);
        rbCard.setBounds(20, 48, 170, 25);
        bg.add(rbCard);
        card.add(rbCard);

        rbGcash = new JRadioButton("GCash");
        rbGcash.setBackground(Color.WHITE);
        rbGcash.setFont(new Font("Serif", Font.PLAIN, 14));
        rbGcash.setBounds(200, 48, 90, 25);
        bg.add(rbGcash);
        card.add(rbGcash);

        rbCOD = new JRadioButton("Cash on Delivery");
        rbCOD.setBackground(Color.WHITE);
        rbCOD.setFont(new Font("Serif", Font.PLAIN, 14));
        rbCOD.setBounds(300, 48, 170, 25);
        bg.add(rbCOD);
        card.add(rbCOD);

        JSeparator sep = new JSeparator();
        sep.setBounds(20, 80, 450, 1);
        sep.setForeground(new Color(220, 220, 220));
        card.add(sep);

        cardPanel = new JPanel(null);
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBounds(20, 88, 450, 190);
        card.add(cardPanel);

        lbNum = new JLabel("Card Number (16 digits)");
        lbNum.setFont(new Font("Serif", Font.PLAIN, 13));
        lbNum.setForeground(Color.DARK_GRAY);
        lbNum.setBounds(0, 0, 260, 20);
        cardPanel.add(lbNum);

        cardNumberField = new JTextField();
        cardNumberField.setBounds(0, 22, 450, 38);
        cardNumberField.setFont(new Font("Serif", Font.PLAIN, 14));
        cardNumberField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        cardPanel.add(cardNumberField);

        lbExp = new JLabel("Expiry Date (MM/YY)");
        lbExp.setFont(new Font("Serif", Font.PLAIN, 13));
        lbExp.setForeground(Color.DARK_GRAY);
        lbExp.setBounds(0, 72, 160, 20);
        cardPanel.add(lbExp);

        expiryField = new JTextField();
        expiryField.setBounds(0, 94, 215, 38);
        expiryField.setFont(new Font("Serif", Font.PLAIN, 14));
        expiryField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        cardPanel.add(expiryField);

        lbCVV = new JLabel("CVV (3-4 digits)");
        lbCVV.setFont(new Font("Serif", Font.PLAIN, 13));
        lbCVV.setForeground(Color.DARK_GRAY);
        lbCVV.setBounds(235, 72, 140, 20);
        cardPanel.add(lbCVV);

        cvvField = new JTextField();
        cvvField.setBounds(235, 94, 215, 38);
        cvvField.setFont(new Font("Serif", Font.PLAIN, 14));
        cvvField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        cardPanel.add(cvvField);

        gcashPanel = new JPanel(null);
        gcashPanel.setBackground(Color.WHITE);
        gcashPanel.setBounds(20, 88, 450, 100);
        gcashPanel.setVisible(false);
        card.add(gcashPanel);

        lbGcash = new JLabel("GCash Number (11 digits, starts with 09)");
        lbGcash.setFont(new Font("Serif", Font.PLAIN, 13));
        lbGcash.setForeground(Color.DARK_GRAY);
        lbGcash.setBounds(0, 0, 340, 20);
        gcashPanel.add(lbGcash);

        gcashField = new JTextField();
        gcashField.setBounds(0, 22, 450, 38);
        gcashField.setFont(new Font("Serif", Font.PLAIN, 14));
        gcashField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gcashPanel.add(gcashField);

        codPanel = new JPanel(null);
        codPanel.setBackground(Color.WHITE);
        codPanel.setBounds(20, 88, 450, 100);
        codPanel.setVisible(false);
        card.add(codPanel);

        lbCOD = new JLabel("Pay when your order arrives.", SwingConstants.CENTER);
        lbCOD.setFont(new Font("Serif", Font.ITALIC, 15));
        lbCOD.setForeground(Color.GRAY);
        lbCOD.setBounds(0, 20, 450, 30);
        codPanel.add(lbCOD);

        lbCODTxt = new JLabel("No payment info needed.", SwingConstants.CENTER);
        lbCODTxt.setFont(new Font("Serif", Font.ITALIC, 13));
        lbCODTxt.setForeground(Color.LIGHT_GRAY);
        lbCODTxt.setBounds(0, 48, 450, 25);
        codPanel.add(lbCODTxt);

        // swap swap panel
        rbCard.addActionListener(e -> {
            cardPanel.setVisible(true);
            gcashPanel.setVisible(false);
            codPanel.setVisible(false);
        });
        rbGcash.addActionListener(e -> {
            cardPanel.setVisible(false);
            gcashPanel.setVisible(true);
            codPanel.setVisible(false);
        });
        rbCOD.addActionListener(e -> {
            cardPanel.setVisible(false);
            gcashPanel.setVisible(false);
            codPanel.setVisible(true);
        });

        confirmButton = new JButton("Confirm Payment");
        confirmButton.setBounds(20, 355, 450, 45);
        confirmButton.setBackground(Color.DARK_GRAY);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("Serif", Font.PLAIN, 15));
        confirmButton.setBorderPainted(false);
        confirmButton.addActionListener(this);
        card.add(confirmButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnBack) {
            dispose();
            LoginPage login = new LoginPage();
            login.setVisible(true);

        } else if (e.getSource() == confirmButton) {

            if (rbCard.isSelected()) {
                String cardNumber = cardNumberField.getText().trim();
                String expiry = expiryField.getText().trim();
                String cvv = cvvField.getText().trim();

                if (!cardNumber.matches("\\d{16}")) {
                    JOptionPane.showMessageDialog(null, "Card number must be exactly 16 digits!", "Error", JOptionPane.ERROR_MESSAGE); return;
                }
                if (!expiry.matches("\\d{2}/\\d{2}")) {
                    JOptionPane.showMessageDialog(null, "Expiry must be in MM/YY format! (e.g. 07/27)", "Error", JOptionPane.ERROR_MESSAGE); return;
                }
                if (!cvv.matches("\\d{3,4}")) {
                    JOptionPane.showMessageDialog(null, "CVV must be 3 or 4 digits!", "Error", JOptionPane.ERROR_MESSAGE); return;
                }

            } else if (rbGcash.isSelected()) {
                String gcashNum = gcashField.getText().trim();
                if (!gcashNum.matches("09\\d{9}")) {
                    JOptionPane.showMessageDialog(null, "GCash number must be 11 digits starting with 09!", "Error", JOptionPane.ERROR_MESSAGE); return;
                }
            }


            OrderData.addOrder(finalCount, finalTotal);
            dispose();
            new OrderConfirmationPage(userPP).setVisible(true);
        }
    }
}