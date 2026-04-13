package Proj_OOP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class browsePage extends JFrame implements ActionListener {

    private JButton btnProfile, btnViewCart;
    private JButton btnView1, btnView2, btnView3, btnView4, btnView5, btnView6;
    private JButton btnAdd1, btnAdd2, btnAdd3, btnAdd4, btnAdd5, btnAdd6;
    private JLabel lblHeader;
    private JLabel lblName1, lblName2, lblName3, lblName4, lblName5, lblName6;
    private JLabel lblPrice1, lblPrice2, lblPrice3, lblPrice4, lblPrice5, lblPrice6;
    private JLabel lblImage1, lblImage2, lblImage3, lblImage4, lblImage5, lblImage6;
    private JPanel productPanel1, productPanel2, productPanel3, productPanel4, productPanel5, productPanel6;
    private JSeparator navLine;

    browsePage() {

        setLayout(null);
        setSize(1050, 770);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Online Shopping System");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        lblHeader = new JLabel("Gadget Market");
        lblHeader.setBounds(30, 13, 250, 30);
        lblHeader.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 23));
        lblHeader.setForeground(Color.DARK_GRAY);
        add(lblHeader);

        btnProfile = new JButton("👤");
        btnProfile.setBounds( 909, 9, 45, 30);
        btnProfile.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnProfile.setBackground(Color.WHITE);
        btnProfile.setForeground(Color.DARK_GRAY);
        btnProfile.setFont(new Font("Serif", Font.PLAIN, 14));
        btnProfile.addActionListener(this);
        add(btnProfile);

        btnViewCart = new JButton("🛒");
        btnViewCart.setBounds(970, 9, 45, 30);
        btnViewCart.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnViewCart.setBackground(Color.WHITE);
        btnViewCart.setForeground(Color.DARK_GRAY);
        btnViewCart.setFont(new Font("Serif", Font.PLAIN, 14));
        btnViewCart.addActionListener(this);
        add(btnViewCart);

        navLine = new JSeparator();
        navLine.setBounds(0, 50, 1050, 2);
        navLine.setForeground(new Color(200, 200, 200));
        add(navLine);

        productPanel1 = new JPanel(null);
        productPanel1.setBounds(60, 85, 270, 300);
        productPanel1.setBackground(Color.WHITE);
        productPanel1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        lblImage1 = new JLabel(" ");
        lblImage1.setBounds(55, 20, 170, 160);
        lblImage1.setBackground(new Color(245, 245, 245));
        lblImage1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel1.add(lblImage1);

        lblName1 = new JLabel("Wireless Earbuds");
        lblName1.setBounds(15, 193, 240, 25);
        lblName1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName1.setForeground(Color.DARK_GRAY);
        productPanel1.add(lblName1);

        lblPrice1 = new JLabel("₱ 50");
        lblPrice1.setBounds(15, 220, 240, 25);
        lblPrice1.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice1.setForeground(Color.DARK_GRAY);
        productPanel1.add(lblPrice1);

        btnView1 = new JButton("View Details");
        btnView1.setBounds(15, 255, 115, 30);
        btnView1.setBackground(Color.WHITE);
        btnView1.setForeground(Color.DARK_GRAY);
        btnView1.setFont(new Font("Serif", Font.PLAIN, 14));
        btnView1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnView1.addActionListener(this);
        productPanel1.add(btnView1);

        btnAdd1 = new JButton("Add to Cart");
        btnAdd1.setBounds(140, 255, 115, 30);
        btnAdd1.setBackground(Color.WHITE);
        btnAdd1.setForeground(Color.DARK_GRAY);
        btnAdd1.setFont(new Font("Serif", Font.PLAIN, 14));
        btnAdd1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnAdd1.addActionListener(this);
        productPanel1.add(btnAdd1);
        add(productPanel1);

        productPanel2 = new JPanel(null);
        productPanel2.setBounds(360, 85, 270, 300);
        productPanel2.setBackground(Color.WHITE);
        productPanel2.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        lblImage2 = new JLabel(" ");
        lblImage2.setBounds(55, 20, 170, 160);
        lblImage2.setBackground(new Color(245, 245, 245));
        lblImage2.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel2.add(lblImage2);

        lblName2 = new JLabel("Smart Watch");
        lblName2.setBounds(15, 193, 240, 25);
        lblName2.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName2.setForeground(Color.DARK_GRAY);
        productPanel2.add(lblName2);

        lblPrice2 = new JLabel("₱ 50");
        lblPrice2.setBounds(15, 220, 240, 25);
        lblPrice2.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice2.setForeground(Color.DARK_GRAY);
        productPanel2.add(lblPrice2);

        btnView2 = new JButton("View Details");
        btnView2.setBounds(15, 255, 115, 30);
        btnView2.setBackground(Color.WHITE);
        btnView2.setForeground(Color.DARK_GRAY);
        btnView2.setFont(new Font("Serif", Font.PLAIN, 14));
        btnView2.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnView2.addActionListener(this);
        productPanel2.add(btnView2);

        btnAdd2 = new JButton("Add to Cart");
        btnAdd2.setBounds(140, 255, 115, 30);
        btnAdd2.setBackground(Color.WHITE);
        btnAdd2.setForeground(Color.DARK_GRAY);
        btnAdd2.setFont(new Font("Serif", Font.PLAIN, 14));
        btnAdd2.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnAdd2.addActionListener(this);
        productPanel2.add(btnAdd2);
        add(productPanel2);

        productPanel3 = new JPanel(null);
        productPanel3.setBounds(660, 85, 270, 300);
        productPanel3.setBackground(Color.WHITE);
        productPanel3.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        lblImage3 = new JLabel(" ");
        lblImage3.setBounds(55, 20, 170, 160);
        lblImage3.setBackground(new Color(245, 245, 245));
        lblImage3.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel3.add(lblImage3);

        lblName3 = new JLabel("Phone Stand");
        lblName3.setBounds(15, 193, 240, 25);
        lblName3.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName3.setForeground(Color.DARK_GRAY);
        productPanel3.add(lblName3);

        lblPrice3 = new JLabel("₱ 50");
        lblPrice3.setBounds(15, 220, 240, 25);
        lblPrice3.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice3.setForeground(Color.DARK_GRAY);
        productPanel3.add(lblPrice3);

        btnView3 = new JButton("View Details");
        btnView3.setBounds(15, 255, 115, 30);
        btnView3.setBackground(Color.WHITE);
        btnView3.setForeground(Color.DARK_GRAY);
        btnView3.setFont(new Font("Serif", Font.PLAIN, 14));
        btnView3.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnView3.addActionListener(this);
        productPanel3.add(btnView3);

        btnAdd3 = new JButton("Add to Cart");
        btnAdd3.setBounds(140, 255, 115, 30);
        btnAdd3.setBackground(Color.WHITE);
        btnAdd3.setForeground(Color.DARK_GRAY);
        btnAdd3.setFont(new Font("Serif", Font.PLAIN, 14));
        btnAdd3.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnAdd3.addActionListener(this);
        productPanel3.add(btnAdd3);
        add(productPanel3);

        productPanel4 = new JPanel(null);
        productPanel4.setBounds(60, 415, 270, 300);
        productPanel4.setBackground(Color.WHITE);
        productPanel4.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        lblImage4 = new JLabel(" ");
        lblImage4.setBounds(55, 20, 170, 160);
        lblImage4.setBackground(new Color(245, 245, 245));
        lblImage4.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel4.add(lblImage4);

        lblName4 = new JLabel("Portable Charger");
        lblName4.setBounds(15, 193, 240, 25);
        lblName4.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName4.setForeground(Color.DARK_GRAY);
        productPanel4.add(lblName4);

        lblPrice4 = new JLabel("₱ 50");
        lblPrice4.setBounds(15, 220, 240, 25);
        lblPrice4.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice4.setForeground(Color.DARK_GRAY);
        productPanel4.add(lblPrice4);

        btnView4 = new JButton("View Details");
        btnView4.setBounds(15, 255, 115, 30);
        btnView4.setBackground(Color.WHITE);
        btnView4.setForeground(Color.DARK_GRAY);
        btnView4.setFont(new Font("Serif", Font.PLAIN, 14));
        btnView4.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnView4.addActionListener(this);
        productPanel4.add(btnView4);

        btnAdd4 = new JButton("Add to Cart");
        btnAdd4.setBounds(140, 255, 115, 30);
        btnAdd4.setBackground(Color.WHITE);
        btnAdd4.setForeground(Color.DARK_GRAY);
        btnAdd4.setFont(new Font("Serif", Font.PLAIN, 14));
        btnAdd4.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnAdd4.addActionListener(this);
        productPanel4.add(btnAdd4);
        add(productPanel4);

        productPanel5 = new JPanel(null);
        productPanel5.setBounds(360, 415, 270, 300);
        productPanel5.setBackground(Color.WHITE);
        productPanel5.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        lblImage5 = new JLabel(" ");
        lblImage5.setBounds(55, 20, 170, 160);
        lblImage5.setBackground(new Color(245, 245, 245));
        lblImage5.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel5.add(lblImage5);

        lblName5 = new JLabel("USB Hub");
        lblName5.setBounds(15, 193, 240, 25);
        lblName5.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName5.setForeground(Color.DARK_GRAY);
        productPanel5.add(lblName5);

        lblPrice5 = new JLabel("₱ 50");
        lblPrice5.setBounds(15, 220, 240, 25);
        lblPrice5.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice5.setForeground(Color.DARK_GRAY);
        productPanel5.add(lblPrice5);

        btnView5 = new JButton("View Details");
        btnView5.setBounds(15, 255, 115, 30);
        btnView5.setBackground(Color.WHITE);
        btnView5.setForeground(Color.DARK_GRAY);
        btnView5.setFont(new Font("Serif", Font.PLAIN, 14));
        btnView5.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnView5.addActionListener(this);
        productPanel5.add(btnView5);

        btnAdd5 = new JButton("Add to Cart");
        btnAdd5.setBounds(140, 255, 115, 30);
        btnAdd5.setBackground(Color.WHITE);
        btnAdd5.setForeground(Color.DARK_GRAY);
        btnAdd5.setFont(new Font("Serif", Font.PLAIN, 14));
        btnAdd5.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnAdd5.addActionListener(this);
        productPanel5.add(btnAdd5);
        add(productPanel5);

        productPanel6 = new JPanel(null);
        productPanel6.setBounds(660, 415, 270, 300);
        productPanel6.setBackground(Color.WHITE);
        productPanel6.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        lblImage6 = new JLabel(" ");
        lblImage6.setBounds(55, 20, 170, 160);
        lblImage6.setBackground(new Color(245, 245, 245));
        lblImage6.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel6.add(lblImage6);

        lblName6 = new JLabel("LED Desk Lamp");
        lblName6.setBounds(15, 193, 240, 25);
        lblName6.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName6.setForeground(Color.DARK_GRAY);
        productPanel6.add(lblName6);

        lblPrice6 = new JLabel("₱ 50");
        lblPrice6.setBounds(15, 220, 240, 25);
        lblPrice6.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice6.setForeground(Color.DARK_GRAY);
        productPanel6.add(lblPrice6);

        btnView6 = new JButton("View Details");
        btnView6.setBounds(15, 255, 115, 30);
        btnView6.setBackground(Color.WHITE);
        btnView6.setForeground(Color.DARK_GRAY);
        btnView6.setFont(new Font("Serif", Font.PLAIN, 14));
        btnView6.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnView6.addActionListener(this);
        productPanel6.add(btnView6);

        btnAdd6 = new JButton("Add to Cart");
        btnAdd6.setBounds(140, 255, 115, 30);
        btnAdd6.setBackground(Color.WHITE);
        btnAdd6.setForeground(Color.DARK_GRAY);
        btnAdd6.setFont(new Font("Serif", Font.PLAIN, 14));
        btnAdd6.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnAdd6.addActionListener(this);
        productPanel6.add(btnAdd6);
        add(productPanel6);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnView1) {
        new productDetails("Wireless Earbuds", " 1,299", "Compact earbuds with clear sound and long \nbattery life")
                .setVisible(true);
        
        } else if (e.getSource() == btnView2) {
        new productDetails("Smart Watch", " 2,499", "Tracks your steps, heart rate, and notifications \non your wrist")
                .setVisible(true);
        
        } else if (e.getSource() == btnView3) {
        new productDetails("Phone Stand", "349", "Adjustable desk stand compatible with any \nsmartphone")
                .setVisible(true);

        } else if (e.getSource() == btnView4) {
        new productDetails("Portable Charge", "899", "10,000mAh power bank that charges \nyour devices on the go")
                .setVisible(true);

        } else if (e.getSource() == btnView5) {
        new productDetails("USB Hub", "599", "4-port USB hub to connect multiple devices \nat once")
                .setVisible(true);

        } else if (e.getSource() == btnView6) {
        new productDetails("LED Desk Lamp", "749", "Touch-controlled lamp with adjustable brightness \nlevels")
                .setVisible(true);

        }
    }
}