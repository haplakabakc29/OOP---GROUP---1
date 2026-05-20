package eCommerceSystem;
import eCommerceData.LoggedUserData;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class BrowsePage extends JFrame implements ActionListener {

    private JButton btnProfile, btnViewCart;
    private JButton btnView1, btnView2, btnView3, btnView4, btnView5, btnView6;
    private JButton btnAdd1, btnAdd2, btnAdd3, btnAdd4, btnAdd5, btnAdd6;
    private JLabel lblHeader;
    private JLabel lblName1, lblName2, lblName3, lblName4, lblName5, lblName6;
    private JLabel lblPrice1, lblPrice2, lblPrice3, lblPrice4, lblPrice5, lblPrice6;
    private JLabel lblImageLogo, lblImage1, lblImage2, lblImage3, lblImage4, lblImage5, lblImage6;
    private JPanel productPanel1, productPanel2, productPanel3, productPanel4, productPanel5, productPanel6;
    private JSeparator navLine;

    private ImageIcon earbuds2Icon, watch2Icon, stand2Icon, charger2Icon, usb2Icon, lamp2Icon;

    private LoggedUserData userBP;

    ArrayList<String> cartItems = new ArrayList<>();
    ArrayList<Integer> cartPrices = new ArrayList<>();

    public BrowsePage(LoggedUserData user) {
        this.userBP = user;

        setLayout(null);
        setSize(1050, 770);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Browse Gadget Market");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        java.net.URL logo = BrowsePage.class.getClassLoader().getResource("logo.jpg");
        
        ImageIcon logoRaw = new ImageIcon(logo);
        Image logoScale = logoRaw.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH);
        ImageIcon logoIcon = new ImageIcon(logoScale);
    
        lblImageLogo = new JLabel(logoIcon);
        lblImageLogo.setBounds(30, 10, 40, 30);
        add(lblImageLogo);

        lblHeader = new JLabel("Gadget Market");
        lblHeader.setBounds(75, 12, 220, 30);
        lblHeader.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 23));
        lblHeader.setForeground(Color.BLACK);
        add(lblHeader);

        btnProfile = new JButton("👤");
        btnProfile.setBounds(909, 9, 45, 30);
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

        java.net.URL earbuds1 = BrowsePage.class.getClassLoader().getResource("earbuds1.jpg");
        ImageIcon earbuds1Raw = new ImageIcon(earbuds1);
        Image earbuds1Scale = earbuds1Raw.getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH);
        ImageIcon earbuds1Icon = new ImageIcon(earbuds1Scale);

        lblImage1 = new JLabel(earbuds1Icon);
        lblImage1.setBounds(55, 20, 170, 160);
        lblImage1.setBackground(new Color(245, 245, 245));
        lblImage1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel1.add(lblImage1);

        lblName1 = new JLabel("Wireless Earbuds");
        lblName1.setBounds(15, 193, 240, 25);
        lblName1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName1.setForeground(Color.DARK_GRAY);
        productPanel1.add(lblName1);

        lblPrice1 = new JLabel("₱ 1,299");
        lblPrice1.setBounds(15, 220, 240, 25);
        lblPrice1.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice1.setForeground(Color.DARK_GRAY);
        productPanel1.add(lblPrice1);

        btnView1 = new JButton("View Details");
        btnView1.setBounds(15, 255, 115, 30);
        btnView1.setBackground(Color.DARK_GRAY);
        btnView1.setForeground(Color.WHITE);
        btnView1.setFont(new Font("Serif", Font.BOLD, 14));
        btnView1.setBorderPainted(false);
        btnView1.addActionListener(this);
        productPanel1.add(btnView1);

        btnAdd1 = new JButton("Add to Cart");
        btnAdd1.setBounds(140, 255, 115, 30);
        btnAdd1.setBackground(Color.DARK_GRAY);
        btnAdd1.setForeground(Color.WHITE);
        btnAdd1.setFont(new Font("Serif", Font.BOLD, 14));
        btnAdd1.setBorderPainted(false);
        btnAdd1.addActionListener(this);
        productPanel1.add(btnAdd1);
        add(productPanel1);

        productPanel2 = new JPanel(null);
        productPanel2.setBounds(360, 85, 270, 300);
        productPanel2.setBackground(Color.WHITE);
        productPanel2.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        java.net.URL watch1 = BrowsePage.class.getClassLoader().getResource("watch1.jpg");
        ImageIcon watch1Raw = new ImageIcon(watch1);
        Image watch1Scale = watch1Raw.getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH);
        ImageIcon watch1Icon = new ImageIcon(watch1Scale);

        lblImage2 = new JLabel(watch1Icon);
        lblImage2.setBounds(55, 20, 170, 160);
        lblImage2.setBackground(new Color(245, 245, 245));
        lblImage2.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel2.add(lblImage2);

        lblName2 = new JLabel("Smart Watch");
        lblName2.setBounds(15, 193, 240, 25);
        lblName2.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName2.setForeground(Color.DARK_GRAY);
        productPanel2.add(lblName2);

        lblPrice2 = new JLabel("₱ 2,499");
        lblPrice2.setBounds(15, 220, 240, 25);
        lblPrice2.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice2.setForeground(Color.DARK_GRAY);
        productPanel2.add(lblPrice2);

        btnView2 = new JButton("View Details");
        btnView2.setBounds(15, 255, 115, 30);
        btnView2.setBackground(Color.DARK_GRAY);
        btnView2.setForeground(Color.WHITE);
        btnView2.setFont(new Font("Serif", Font.BOLD, 14));
        btnView2.setBorderPainted(false);
        btnView2.addActionListener(this);
        productPanel2.add(btnView2);

        btnAdd2 = new JButton("Add to Cart");
        btnAdd2.setBounds(140, 255, 115, 30);
        btnAdd2.setBackground(Color.DARK_GRAY);
        btnAdd2.setForeground(Color.WHITE);
        btnAdd2.setFont(new Font("Serif", Font.BOLD, 14));
        btnAdd2.setBorderPainted(false);
        btnAdd2.addActionListener(this);
        productPanel2.add(btnAdd2);
        add(productPanel2);

        productPanel3 = new JPanel(null);
        productPanel3.setBounds(660, 85, 270, 300);
        productPanel3.setBackground(Color.WHITE);
        productPanel3.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        java.net.URL stand1 = BrowsePage.class.getClassLoader().getResource("stand1.jpg");
        ImageIcon stand1Raw = new ImageIcon(stand1);
        Image stand1Scale = stand1Raw.getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH);
        ImageIcon stand1Icon = new ImageIcon(stand1Scale);

        lblImage3 = new JLabel(stand1Icon);
        lblImage3.setBounds(55, 20, 170, 160);
        lblImage3.setBackground(new Color(245, 245, 245));
        lblImage3.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel3.add(lblImage3);

        lblName3 = new JLabel("Phone Stand");
        lblName3.setBounds(15, 193, 240, 25);
        lblName3.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName3.setForeground(Color.DARK_GRAY);
        productPanel3.add(lblName3);

        lblPrice3 = new JLabel("₱ 349");
        lblPrice3.setBounds(15, 220, 240, 25);
        lblPrice3.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice3.setForeground(Color.DARK_GRAY);
        productPanel3.add(lblPrice3);

        btnView3 = new JButton("View Details");
        btnView3.setBounds(15, 255, 115, 30);
        btnView3.setBackground(Color.DARK_GRAY);
        btnView3.setForeground(Color.WHITE);
        btnView3.setFont(new Font("Serif", Font.BOLD, 14));
        btnView3.setBorderPainted(false);
        btnView3.addActionListener(this);
        productPanel3.add(btnView3);

        btnAdd3 = new JButton("Add to Cart");
        btnAdd3.setBounds(140, 255, 115, 30);
        btnAdd3.setBackground(Color.DARK_GRAY);
        btnAdd3.setForeground(Color.WHITE);
        btnAdd3.setFont(new Font("Serif", Font.BOLD, 14));
        btnAdd3.setBorderPainted(false);
        btnAdd3.addActionListener(this);
        productPanel3.add(btnAdd3);
        add(productPanel3);

        productPanel4 = new JPanel(null);
        productPanel4.setBounds(60, 415, 270, 300);
        productPanel4.setBackground(Color.WHITE);
        productPanel4.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        java.net.URL charger1 = BrowsePage.class.getClassLoader().getResource("charger1.jpg");
        ImageIcon charger1Raw = new ImageIcon(charger1);
        Image charger1Scale = charger1Raw.getImage().getScaledInstance(170, 155, Image.SCALE_SMOOTH);
        ImageIcon charger1Icon = new ImageIcon(charger1Scale);

        lblImage4 = new JLabel(charger1Icon);
        lblImage4.setBounds(55, 20, 170, 160);
        lblImage4.setHorizontalAlignment(JLabel.CENTER);
        lblImage4.setBackground(new Color(245, 245, 245));
        lblImage4.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel4.add(lblImage4);

        lblName4 = new JLabel("Portable Charger");
        lblName4.setBounds(15, 193, 240, 25);
        lblName4.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName4.setForeground(Color.DARK_GRAY);
        productPanel4.add(lblName4);

        lblPrice4 = new JLabel("₱ 899");
        lblPrice4.setBounds(15, 220, 240, 25);
        lblPrice4.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice4.setForeground(Color.DARK_GRAY);
        productPanel4.add(lblPrice4);

        btnView4 = new JButton("View Details");
        btnView4.setBounds(15, 255, 115, 30);
        btnView4.setBackground(Color.DARK_GRAY);
        btnView4.setForeground(Color.WHITE);
        btnView4.setFont(new Font("Serif", Font.BOLD, 14));
        btnView4.setBorderPainted(false);
        btnView4.addActionListener(this);
        productPanel4.add(btnView4);

        btnAdd4 = new JButton("Add to Cart");
        btnAdd4.setBounds(140, 255, 115, 30);
        btnAdd4.setBackground(Color.DARK_GRAY);
        btnAdd4.setForeground(Color.WHITE);
        btnAdd4.setFont(new Font("Serif", Font.BOLD, 14));
        btnAdd4.setBorderPainted(false);
        btnAdd4.addActionListener(this);
        productPanel4.add(btnAdd4);
        add(productPanel4);

        productPanel5 = new JPanel(null);
        productPanel5.setBounds(360, 415, 270, 300);
        productPanel5.setBackground(Color.WHITE);
        productPanel5.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        java.net.URL usb1 = BrowsePage.class.getClassLoader().getResource("usb1.jpg");
        ImageIcon usb1Raw = new ImageIcon(usb1);
        Image usb1Scale = usb1Raw.getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH);
        ImageIcon usb1Icon = new ImageIcon(usb1Scale);

        lblImage5 = new JLabel(usb1Icon);
        lblImage5.setBounds(55, 20, 170, 160);
        lblImage5.setBackground(new Color(245, 245, 245));
        lblImage5.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel5.add(lblImage5);

        lblName5 = new JLabel("USB Hub");
        lblName5.setBounds(15, 193, 240, 25);
        lblName5.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName5.setForeground(Color.DARK_GRAY);
        productPanel5.add(lblName5);

        lblPrice5 = new JLabel("₱ 599");
        lblPrice5.setBounds(15, 220, 240, 25);
        lblPrice5.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice5.setForeground(Color.DARK_GRAY);
        productPanel5.add(lblPrice5);

        btnView5 = new JButton("View Details");
        btnView5.setBounds(15, 255, 115, 30);
        btnView5.setBackground(Color.DARK_GRAY);
        btnView5.setForeground(Color.WHITE);
        btnView5.setFont(new Font("Serif", Font.BOLD, 14));
        btnView5.setBorderPainted(false);
        btnView5.addActionListener(this);
        productPanel5.add(btnView5);

        btnAdd5 = new JButton("Add to Cart");
        btnAdd5.setBounds(140, 255, 115, 30);
        btnAdd5.setBackground(Color.DARK_GRAY);
        btnAdd5.setForeground(Color.WHITE);
        btnAdd5.setFont(new Font("Serif", Font.BOLD, 14));
        btnAdd5.setBorderPainted(false);
        btnAdd5.addActionListener(this);
        productPanel5.add(btnAdd5);
        add(productPanel5);

        productPanel6 = new JPanel(null);
        productPanel6.setBounds(660, 415, 270, 300);
        productPanel6.setBackground(Color.WHITE);
        productPanel6.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        java.net.URL lamp1 = BrowsePage.class.getClassLoader().getResource("lamp1.jpg");
        ImageIcon lamp1Raw = new ImageIcon(lamp1);
        Image lamp1Scale = lamp1Raw.getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH);
        ImageIcon lamp1Icon = new ImageIcon(lamp1Scale);

        lblImage6 = new JLabel(lamp1Icon);
        lblImage6.setBounds(55, 20, 170, 160);
        lblImage6.setBackground(new Color(245, 245, 245));
        lblImage6.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        productPanel6.add(lblImage6);

        lblName6 = new JLabel("LED Desk Lamp");
        lblName6.setBounds(15, 193, 240, 25);
        lblName6.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 21));
        lblName6.setForeground(Color.DARK_GRAY);
        productPanel6.add(lblName6);

        lblPrice6 = new JLabel("₱ 749");
        lblPrice6.setBounds(15, 220, 240, 25);
        lblPrice6.setFont(new Font("Serif", Font.PLAIN, 17));
        lblPrice6.setForeground(Color.DARK_GRAY);
        productPanel6.add(lblPrice6);

        btnView6 = new JButton("View Details");
        btnView6.setBounds(15, 255, 115, 30);
        btnView6.setBackground(Color.DARK_GRAY);
        btnView6.setForeground(Color.WHITE);
        btnView6.setFont(new Font("Serif", Font.BOLD, 14));
        btnView6.setBorderPainted(false);
        btnView6.addActionListener(this);
        productPanel6.add(btnView6);

        btnAdd6 = new JButton("Add to Cart");
        btnAdd6.setBounds(140, 255, 115, 30);
        btnAdd6.setBackground(Color.DARK_GRAY);
        btnAdd6.setForeground(Color.WHITE);
        btnAdd6.setFont(new Font("Serif", Font.BOLD, 14));
        btnAdd6.setBorderPainted(false);
        btnAdd6.addActionListener(this);
        productPanel6.add(btnAdd6);
        add(productPanel6);

        java.net.URL earbuds2 = BrowsePage.class.getClassLoader().getResource("earbuds2.jpg");
        earbuds2Icon = new ImageIcon(new ImageIcon(earbuds2).getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH));

        java.net.URL watch2 = BrowsePage.class.getClassLoader().getResource("watch2.jpg");
        watch2Icon = new ImageIcon(new ImageIcon(watch2).getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH));

        java.net.URL stand2 = BrowsePage.class.getClassLoader().getResource("stand2.jpg");
        stand2Icon = new ImageIcon(new ImageIcon(stand2).getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH));

        java.net.URL charger2 = BrowsePage.class.getClassLoader().getResource("charger2.jpg");
        charger2Icon = new ImageIcon(new ImageIcon(charger2).getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH));

        java.net.URL usb2 = BrowsePage.class.getClassLoader().getResource("usb2.jpg");
        usb2Icon = new ImageIcon(new ImageIcon(usb2).getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH));

        java.net.URL lamp2 = BrowsePage.class.getClassLoader().getResource("lamp2.jpg");
        lamp2Icon = new ImageIcon(new ImageIcon(lamp2).getImage().getScaledInstance(170, 160, Image.SCALE_SMOOTH));

        setVisible(true);
    }

    public void addToCart(String name, int price, int quantity) {
        for (int i = 0; i < quantity; i++) {
            cartItems.add(name);
            cartPrices.add(price);
        }
        JOptionPane.showMessageDialog(this, quantity + "x " + name + " added to cart!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnViewCart) {
            new CheckoutPage(cartItems, cartPrices, userBP).setVisible(true);
        } else if (e.getSource() == btnView1) {
            new ProductDetailsPage("Wireless Earbuds", 1299, "Compact earbuds with clear sound and long \nbattery life", this, userBP, earbuds2Icon).setVisible(true);
        } else if (e.getSource() == btnView2) {
            new ProductDetailsPage("Smart Watch", 2499, "Tracks your steps, heart rate, and notifications \non your wrist", this, userBP, watch2Icon).setVisible(true);
        } else if (e.getSource() == btnView3) {
            new ProductDetailsPage("Phone Stand", 349, "Adjustable desk stand compatible with any \nsmartphone", this, userBP, stand2Icon).setVisible(true);
        } else if (e.getSource() == btnView4) {
            new ProductDetailsPage("Portable Charger", 899, "10,000mAh power bank that charges \nyour devices on the go", this, userBP, charger2Icon).setVisible(true);
        } else if (e.getSource() == btnView5) {
            new ProductDetailsPage("USB Hub", 599, "4-port USB hub to connect multiple devices \nat once", this, userBP, usb2Icon).setVisible(true);
        } else if (e.getSource() == btnView6) {
            new ProductDetailsPage("LED Desk Lamp", 749, "Touch-controlled lamp with adjustable brightness \nlevels", this, userBP, lamp2Icon).setVisible(true);
        }

        if (e.getSource() == btnAdd1) addToCart("Wireless Earbuds", 1299, 1);
        if (e.getSource() == btnAdd2) addToCart("Smart Watch", 2499, 1);
        if (e.getSource() == btnAdd3) addToCart("Phone Stand", 349, 1);
        if (e.getSource() == btnAdd4) addToCart("Portable Charger", 899, 1);
        if (e.getSource() == btnAdd5) addToCart("USB Hub", 599, 1);
        if (e.getSource() == btnAdd6) addToCart("LED Desk Lamp", 749, 1);

        if (e.getSource() == btnProfile) {
            ViewProfilePage vp = new ViewProfilePage(userBP, this);
            vp.setVisible(true);
        }
    }
}