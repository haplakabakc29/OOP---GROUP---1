package Proj_OOP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class productDetails extends JFrame implements ActionListener {

    private JButton btnBack, btnCart, btnProfile, btnBuyNow, btnInc, btnDec, btnAddToCart;
    private JLabel lblImage, lblProductName, lblProductPrice,lblDesc, lblStars, lblReview, lblQty;
    private JSeparator navLine, line1, line2, line3;
    private JTextArea lblProductDesc;
    
    productDetails() {
        
        setLayout(null);
        setSize(550, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Online Shopping System");
        setLocationRelativeTo(null);

        
        btnBack = new JButton("←  Back");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.setBackground(Color.WHITE);
        add(btnBack);

        btnCart = new JButton("🛒");
        btnCart.setBounds(470, 10, 50, 30);
        btnCart.setBorder(null);
        btnCart.setBackground(Color.WHITE);
        add(btnCart);
        
        btnProfile = new JButton("👤");
        btnProfile.setBounds(430, 10, 50, 30);
        btnProfile.setBorder(null);
        btnProfile.setBackground(Color.WHITE);
        add(btnProfile);

        navLine = new JSeparator();
        navLine.setBounds(0, 50, 550, 2);
        navLine.setForeground(Color.DARK_GRAY);
        add(navLine);

        lblImage = new JLabel(" ");
        lblImage.setBounds(20, 70, 180, 180);
        lblImage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(lblImage);

        lblProductName = new JLabel("Who Knows");
        lblProductName.setBounds(220, 70, 290, 25);
        lblProductName.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 28));
        lblProductName.setForeground(Color.DARK_GRAY);
        add(lblProductName);

        line1 = new JSeparator();
        line1.setBounds(220, 100, 290, 2);
        line1.setForeground(Color.DARK_GRAY);
        add(line1);

        lblProductPrice = new JLabel("₱ 100,000");
        lblProductPrice.setBounds(220, 110, 290, 25);
        lblProductPrice.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lblProductPrice);

        line2 = new JSeparator();
        line2.setBounds(220, 140, 290, 2);
        line2.setForeground(Color.DARK_GRAY);
        add(line2);
        
        lblDesc = new JLabel("Description: ");
        lblDesc.setBounds(220, 145, 290, 25);
        lblDesc.setFont(new Font("Serif", Font.PLAIN, 13));
        add(lblDesc);
        
        lblProductDesc = new JTextArea("a song about not knowing; not knowing if you're \n"
                + "enough, and not knowing what love really means.");
        lblProductDesc.setBounds(220, 170, 290, 55);
        lblProductDesc.setFont(new Font("Serif", Font.ITALIC, 14));
        lblProductDesc.setForeground(Color.BLACK);
        add(lblProductDesc);

        line3 = new JSeparator();
        line3.setBounds(220, 225, 290, 2);
        line3.setForeground(Color.DARK_GRAY);
        add(line3);

        lblStars = new JLabel("★★★★☆");
        lblStars.setBounds(220, 230, 150, 25);
        lblStars.setFont(new Font("Serif", Font.ITALIC, 16));
        add(lblStars);
        
        lblReview = new JLabel ("(5 reviews)");
        lblReview.setBounds(295,230, 150, 25);
        lblReview.setFont(new Font("Serif", Font.PLAIN, 15));
        add(lblReview);

        lblQty = new JLabel("1");
        lblQty.setBounds(270, 280, 40, 30);
        lblQty.setFont(new Font("Serif", Font.BOLD, 15));
        lblQty.setHorizontalAlignment(JLabel.CENTER);
        lblQty.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(lblQty);

        btnDec = new JButton("-");
        btnDec.setBounds(220, 280, 45, 30);
        btnDec.setBackground(Color.WHITE);
        btnDec.setFont(new Font("Sefif", Font.BOLD, 15));
        btnDec.addActionListener(this);
        add(btnDec);

        btnInc = new JButton("+");
        btnInc.setBounds(315, 280, 45, 30);
        btnInc.setBackground(Color.WHITE);
        btnInc.setFont(new Font("Sefif", Font.BOLD, 14));
        btnInc.addActionListener(this);
        add(btnInc);

        btnBuyNow = new JButton("Buy Now");
        btnBuyNow.setBounds(365, 280, 145, 30);
        btnBuyNow.setBackground(Color.WHITE);
        btnBuyNow.addActionListener(this);
        add(btnBuyNow);

        btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.setBounds(220, 320, 290, 35);
        btnAddToCart.setBackground(Color.WHITE);
        btnAddToCart.addActionListener(this);
        add(btnAddToCart);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        int QTY = Integer.parseInt(lblQty.getText().trim());
        if (e.getSource() == btnInc){
            QTY += 1;
        } else if (e.getSource() == btnDec ){
            if (QTY > 1){
            QTY -= 1;
            }
        }
        
        lblQty.setText(String.valueOf(QTY));
        
    }
}