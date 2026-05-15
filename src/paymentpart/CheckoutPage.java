package paymentpart;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class CheckoutPage extends JFrame {

    private JPanel card;
    private JLabel title, totalLabel;
    private JButton proceedButton;
    private JTextArea receiptArea;
    private int totalAmount = 0;

    public CheckoutPage(String[] itemNames, int[] itemPrices) {
        setTitle("Order Summary");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(null);

        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(Color.BLACK, 2));
        card.setBounds(100, 40, 350, 380);
        add(card);

        title = new JLabel("Checkout", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 28));
        title.setBounds(25, 20, 300, 40);
        card.add(title);

        receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        receiptArea.setBounds(40, 80, 270, 150);
        receiptArea.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        card.add(receiptArea);
        
        for (int i = 0; i < itemNames.length; i++) {
            if (itemNames[i] != null) {
                receiptArea.append((i + 1) + ". " + itemNames[i] + " - P " + itemPrices[i] + "\n");
                totalAmount += itemPrices[i]; 
            }
        } 

        totalLabel = new JLabel("Total to Pay: P " + totalAmount);
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        totalLabel.setBounds(40, 260, 270, 30);
        card.add(totalLabel);

        proceedButton = new JButton("Confirm & Pay");
        proceedButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        proceedButton.setBackground(Color.WHITE);
        proceedButton.setBorder(new LineBorder(Color.BLACK, 1));
        proceedButton.setBounds(40, 310, 270, 40);
        card.add(proceedButton);

        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PaymentPart().setVisible(true); 
            }
        });
    }

    public static void main(String[] args) {
        new CheckoutPage(new String[10], new int[10]).setVisible(true);
    }
}