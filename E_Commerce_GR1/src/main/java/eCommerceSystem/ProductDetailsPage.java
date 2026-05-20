package eCommerceSystem;
import eCommerceData.LoggedUserData;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ProductDetailsPage extends JFrame implements ActionListener {

    private JButton btnBack, btnCart, btnProfile, btnBuyNow, btnInc, btnDec, btnAddToCart;
    private JLabel lblImage, lblProductName, lblProductPrice, lblDesc, lblStars, lblReview, lblQty;
    private JSeparator navLine, line1, line2, line3;
    private JTextArea lblProductDesc;
    
    private LoggedUserData userPD;
    private BrowsePage mainPage;
    private String currentName;
    private int currentPrice;
    private ImageIcon productIcon;

    // Fixed: Added 'public' to constructor so browsePage can instantiate it in short nag loloko nung una
    public ProductDetailsPage(String name, int price, String description, BrowsePage main, LoggedUserData user, ImageIcon icon) {
        this.mainPage = main;
        this.currentName = name;
        this.currentPrice = price;
        this.userPD = user;
        this.productIcon = icon;
            
        setLayout(null);
        setSize(550, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Online Shopping System");
        setLocationRelativeTo(null);

        btnBack = new JButton("← Back");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(Color.DARK_GRAY);
        btnBack.setFont(new Font("Serif", Font.PLAIN, 14));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnBack.addActionListener(this);
        add(btnBack);

//        btnProfile = new JButton("👤");
//        btnProfile.setBounds(425, 10, 45, 30);
//        btnProfile.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
//        btnProfile.setBackground(Color.WHITE);
//        btnProfile.setForeground(Color.DARK_GRAY);
//        btnProfile.setFont(new Font("Serif", Font.PLAIN, 14));
//        btnProfile.addActionListener(this);
//        add(btnProfile);
//
//        btnCart = new JButton("🛒");
//        btnCart.setBounds(480, 10, 45, 30);
//        btnCart.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
//        btnCart.setBackground(Color.WHITE);
//        btnCart.setForeground(Color.DARK_GRAY);
//        btnCart.setFont(new Font("Serif", Font.PLAIN, 14));
//        btnCart.addActionListener(this);
//        add(btnCart);

        navLine = new JSeparator();
        navLine.setBounds(0, 50, 550, 2);
        navLine.setForeground(new Color(200, 200, 200));
        add(navLine);

        lblImage = new JLabel(icon);
        lblImage.setBounds(20, 70, 180, 180);
        lblImage.setBackground(new Color(245, 245, 245));
        lblImage.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(lblImage);

        lblProductName = new JLabel(name);
        lblProductName.setBounds(220, 70, 290, 25);
        lblProductName.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 28));
        lblProductName.setForeground(Color.DARK_GRAY);
        add(lblProductName);

        line1 = new JSeparator();
        line1.setBounds(220, 100, 290, 2);
        line1.setForeground(new Color(200, 200, 200));
        add(line1);

        lblProductPrice = new JLabel("₱ " + price);
        lblProductPrice.setBounds(220, 110, 290, 25);
        lblProductPrice.setFont(new Font("Serif", Font.PLAIN, 20));
        lblProductPrice.setForeground(Color.DARK_GRAY);
        add(lblProductPrice);

        line2 = new JSeparator();
        line2.setBounds(220, 140, 290, 2);
        line2.setForeground(new Color(200, 200, 200));
        add(line2);

        lblDesc = new JLabel("Description:");
        lblDesc.setBounds(220, 145, 290, 25);
        lblDesc.setFont(new Font("Serif", Font.PLAIN, 16));
        lblDesc.setForeground(Color.DARK_GRAY);
        add(lblDesc);

        lblProductDesc = new JTextArea(description);
        lblProductDesc.setBounds(220, 170, 290, 55);
        lblProductDesc.setFont(new Font("Serif", Font.ITALIC, 14));
        lblProductDesc.setForeground(Color.DARK_GRAY);
        lblProductDesc.setBackground(Color.WHITE);
        lblProductDesc.setEditable(false);
        add(lblProductDesc);

        line3 = new JSeparator();
        line3.setBounds(220, 225, 290, 2);
        line3.setForeground(new Color(200, 200, 200));
        add(line3);

        lblStars = new JLabel("★★★★☆");
        lblStars.setBounds(220, 230, 150, 25);
        lblStars.setFont(new Font("Serif", Font.ITALIC, 16));
        lblStars.setForeground(Color.DARK_GRAY);
        add(lblStars);

        lblReview = new JLabel("(5 reviews)");
        lblReview.setBounds(295, 230, 150, 25);
        lblReview.setFont(new Font("Serif", Font.PLAIN, 15));
        lblReview.setForeground(Color.DARK_GRAY);
        add(lblReview);

        btnDec = new JButton("-");
        btnDec.setBounds(220, 280, 45, 30);
        btnDec.setBackground(Color.WHITE);
        btnDec.setForeground(Color.BLACK);
        btnDec.setFont(new Font("Serif", Font.BOLD, 15));
        btnDec.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnDec.addActionListener(this);
        add(btnDec);

        lblQty = new JLabel("1");
        lblQty.setBounds(270, 280, 40, 30);
        lblQty.setFont(new Font("Serif", Font.BOLD, 15));
        lblQty.setForeground(Color.DARK_GRAY);
        lblQty.setHorizontalAlignment(JLabel.CENTER);
        lblQty.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(lblQty);

        btnInc = new JButton("+");
        btnInc.setBounds(315, 280, 45, 30);
        btnInc.setBackground(Color.WHITE);
        btnInc.setForeground(Color.BLACK);
        btnInc.setFont(new Font("Serif", Font.BOLD, 15));
        btnInc.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnInc.addActionListener(this);
        add(btnInc);

        btnBuyNow = new JButton("Buy Now");
        btnBuyNow.setBounds(365, 280, 145, 30);
        btnBuyNow.setBackground(Color.DARK_GRAY);
        btnBuyNow.setForeground(Color.WHITE);
        btnBuyNow.setFont(new Font("Serif", Font.BOLD, 14));
        btnBuyNow.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnBuyNow.addActionListener(this);
        add(btnBuyNow);

        btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.setBounds(220, 320, 290, 35);
        btnAddToCart.setBackground(Color.DARK_GRAY);
        btnAddToCart.setForeground(Color.WHITE);
        btnAddToCart.setFont(new Font("Serif", Font.BOLD, 14));
        btnAddToCart.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnAddToCart.addActionListener(this);
        add(btnAddToCart);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int QTY = Integer.parseInt(lblQty.getText().trim());
        
        if (e.getSource() == btnInc) {
            lblQty.setText(String.valueOf(QTY + 1));
            
        } else if (e.getSource() == btnDec) {
            if (QTY > 1) lblQty.setText(String.valueOf(QTY - 1));
            
        } else if (e.getSource() == btnBack) {
            dispose();
            
//        } else if (e.getSource() == btnCart) {
//            dispose();
//            new CheckoutPage(mainPage.cartItems, mainPage.cartPrices).setVisible(true);
            
        } else if (e.getSource() == btnAddToCart) {
            dispose();
            mainPage.addToCart(currentName, currentPrice, QTY);
            
        } else if (e.getSource() == btnBuyNow) {
            dispose();
            PaymentPage payment = new PaymentPage(userPD);
            payment.setVisible(true);
        }
//        } else if (e.getSource() == btnProfile) {
//            dispose();
//            ViewProfile vProfile = new ViewProfile(userPD);
//            vProfile.setVisible(true);
//        }
    }
}
