package eCommerceSystem;
import eCommerceData.LoggedUserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CheckoutPage extends JFrame implements ActionListener {

    private JPanel card;
    private JLabel title, totalLabel, receiptLabel, totalTitle;
    private JButton proceedButton, btnBack, rmvBTN, clearBTN;
    private JScrollPane scrollPane;

    private JList<String> receiptArea;
    private DefaultListModel<String> listModel;

    private int totalAmount = 0;
    private LoggedUserData userCO;

    private ArrayList<String> itemNames;
    private ArrayList<Integer> itemPrices;

    public static CheckoutPage coPage;
    
    public CheckoutPage(ArrayList<String> itemNames, ArrayList<Integer> itemPrices, LoggedUserData user) {
        this.userCO    = user;
        this.itemNames  = itemNames;
        this.itemPrices = itemPrices;
        coPage = this;

        setTitle("Shopping Cart");
        setSize(550, 590);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.setBounds(75, 40, 400, 490);
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

        receiptLabel = new JLabel("Order Items");
        receiptLabel.setFont(new Font("Serif", Font.BOLD, 13));
        receiptLabel.setForeground(Color.GRAY);
        receiptLabel.setBounds(30, 82, 250, 20);
        card.add(receiptLabel);

        listModel   = new DefaultListModel<>();
        receiptArea = new JList<>(listModel);
        receiptArea.setFont(new Font("Serif", Font.PLAIN, 15));
        receiptArea.setForeground(Color.DARK_GRAY);
        receiptArea.setBackground(Color.WHITE);
        receiptArea.setFixedCellHeight(27);

        scrollPane = new JScrollPane(receiptArea);
        scrollPane.setBounds(30, 108, 340, 200);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        card.add(scrollPane);

        for (int i = 0; i < itemNames.size(); i++) {
            listModel.addElement((i + 1) + ". " + itemNames.get(i) + " - ₱ " + itemPrices.get(i));
            totalAmount += itemPrices.get(i);
        }

        rmvBTN = new JButton("Remove");
        rmvBTN.setFont(new Font("Serif", Font.BOLD, 14));
        rmvBTN.setBackground(Color.DARK_GRAY);
        rmvBTN.setForeground(Color.WHITE);
        rmvBTN.setFocusPainted(false);
        rmvBTN.setBounds(30, 315, 160, 30);
        rmvBTN.addActionListener(this);
        card.add(rmvBTN);

        clearBTN = new JButton("Clear All");
        clearBTN.setFont(new Font("Serif", Font.BOLD, 14));
        clearBTN.setBackground(Color.DARK_GRAY);
        clearBTN.setForeground(Color.WHITE);
        clearBTN.setFocusPainted(false);
        clearBTN.setBounds(210, 315, 160, 30);
        clearBTN.addActionListener(this);
        card.add(clearBTN);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(30, 357, 340, 1);
        sep2.setForeground(new Color(220, 220, 220));
        card.add(sep2);

        totalTitle = new JLabel("Total to Pay");
        totalTitle.setFont(new Font("Serif", Font.BOLD, 19));
        totalTitle.setForeground(Color.DARK_GRAY);
        totalTitle.setBounds(30, 367, 180, 30);
        card.add(totalTitle);

        totalLabel = new JLabel("₱ " + totalAmount);
        totalLabel.setFont(new Font("Serif", Font.BOLD, 24));
        totalLabel.setForeground(Color.DARK_GRAY);
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        totalLabel.setBounds(190, 361, 180, 40);
        card.add(totalLabel);

        proceedButton = new JButton("Confirm & Pay");
        proceedButton.setFont(new Font("Serif", Font.BOLD, 16));
        proceedButton.setBackground(Color.DARK_GRAY);
        proceedButton.setForeground(Color.WHITE);
        proceedButton.setFocusPainted(false);
        proceedButton.setBounds(30, 415, 340, 45);
        card.add(proceedButton);

        proceedButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (totalAmount == 0) {
                JOptionPane.showMessageDialog(null, "Your cart is empty!", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                int count = itemNames.size();
                int total = totalAmount;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < itemNames.size(); i++) {
                    sb.append(itemNames.get(i));
                    if (i < itemNames.size() - 1) {
                        sb.append(", ");
                    }
                }
                String combinedItemsStr = sb.toString();
                dispose();
                new PaymentPage(userCO, count, total, combinedItemsStr).setVisible(true);
                }
            }
        });
    }
        public void clearCart() {
            itemNames.clear();
            itemPrices.clear();
            listModel.clear();
            totalAmount = 0;
            totalLabel.setText("₱ 0");
        }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            dispose();

        } else if (e.getSource() == rmvBTN) {
        int indx = receiptArea.getSelectedIndex();
        
        if (indx != -1) {
            int response = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to remove this item?",
                "Confirm Removal",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            if (response == JOptionPane.YES_OPTION) {
                totalAmount -= itemPrices.get(indx);
                totalLabel.setText("₱ " + totalAmount);
                itemNames.remove(indx);
                itemPrices.remove(indx);
                listModel.clear();
                for (int i = 0; i < itemNames.size(); i++) {
                    listModel.addElement((i + 1) + ". " + itemNames.get(i) + " - ₱ " + itemPrices.get(i));
                }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select an Item to Remove", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == clearBTN ) {
            if (itemNames.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Your cart is already empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                int response = JOptionPane.showConfirmDialog(
                    this,
                    "Remove all items from cart?",
                    "Clear Cart",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );
                
                if (response == JOptionPane.YES_OPTION) {
                    itemNames.clear();
                    itemPrices.clear();
                    listModel.clear();
                    totalAmount = 0;
                    totalLabel.setText("₱ 0");
                }
            }
        }
    }
}