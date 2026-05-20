package eCommerceSystem;
import eCommerceData.LoggedUserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CheckoutPage extends JFrame implements ActionListener {
    private JPanel card;
    private JLabel title, totalLabel;
    private JButton proceedButton, btnBack;
    private JTextArea receiptArea;
    private int totalAmount = 0;
    
    private LoggedUserData userCO;
    
    public CheckoutPage(ArrayList<String> itemNames, ArrayList<Integer> itemPrices,LoggedUserData user) {
        this.userCO = user;
        
        setTitle("Shopping Cart");
        setSize(550, 560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.setBounds(75, 40, 400, 460);
        add(card);

        btnBack = new JButton("← Back");
        btnBack.setBounds(10, 10, 70, 25);
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(Color.DARK_GRAY);
        btnBack.setFont(new Font("Serif", Font.PLAIN, 14));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this);
        add(btnBack);
        
        title = new JLabel("Shopping Cart", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 34));
        title.setForeground(Color.DARK_GRAY);
        title.setBounds(50, 20, 300, 50);
        card.add(title);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(30, 72, 340, 1);
        sep1.setForeground(new Color(220, 220, 220));
        card.add(sep1);

        JLabel receiptLabel = new JLabel("Order Items");
        receiptLabel.setFont(new Font("Serif", Font.BOLD, 13));
        receiptLabel.setForeground(Color.GRAY);
        receiptLabel.setBounds(30, 82, 250, 20);
        card.add(receiptLabel);

        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Serif", Font.PLAIN, 15));
        receiptArea.setForeground(Color.DARK_GRAY);
        receiptArea.setBackground(Color.WHITE);
        receiptArea.setMargin(new Insets(8, 10, 8, 10));
        receiptArea.setLineWrap(true);
        receiptArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(receiptArea);
        scrollPane.setBounds(30, 108, 340, 200);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        card.add(scrollPane);

        for (int i = 0; i < itemNames.size(); i++) {
            receiptArea.append((i + 1) + ". " + itemNames.get(i) + " - P " + itemPrices.get(i) + "\n");
            totalAmount += itemPrices.get(i);
        }

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(30, 322, 340, 1);
        sep2.setForeground(new Color(220, 220, 220));
        card.add(sep2);

        JLabel totalTitle = new JLabel("Total to Pay");
        totalTitle.setFont(new Font("Serif", Font.BOLD, 19));
        totalTitle.setForeground(Color.DARK_GRAY);
        totalTitle.setBounds(30, 332, 180, 30);
        card.add(totalTitle);

        totalLabel = new JLabel("P " + totalAmount);
        totalLabel.setFont(new Font("Serif", Font.BOLD, 24));
        totalLabel.setForeground(Color.DARK_GRAY);
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        totalLabel.setBounds(190, 326, 180, 40);
        card.add(totalLabel);

        proceedButton = new JButton("Confirm & Pay");
        proceedButton.setFont(new Font("Serif", Font.BOLD, 16));
        proceedButton.setBackground(Color.DARK_GRAY);
        proceedButton.setForeground(Color.WHITE);
        proceedButton.setFocusPainted(false);
        proceedButton.setBounds(30, 385, 340, 45);
        card.add(proceedButton);

        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (totalAmount == 0) {
                    JOptionPane.showMessageDialog(null, "Your cart is empty!", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    dispose();
                    new PaymentPage(userCO).setVisible(true);
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            dispose();
    }
  }
}