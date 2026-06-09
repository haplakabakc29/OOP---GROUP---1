package eCommerceSystem;
import eCommerceData.LoggedUserData;
import eCommerceData.OrderData;
import eCommerceData.OrderData.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewProfilePage extends JFrame implements ActionListener {

    private JButton btnLogout, btnBack, btnReceived, btnCancel;
    private JList<Order> orderList;
    private DefaultListModel<Order> orderListModel;
    private JLabel brandName, orderTitle, usernameLabel, memberLabel, picLabel, addrTitle;
    private JScrollPane scrollPane;
    private JPanel rightCard, leftCard;
    private JTextArea addressField;
    private BrowsePage mainBP;

    public ViewProfilePage(LoggedUserData user, BrowsePage main) {
        this.mainBP = main;

        setTitle("Profile");
        setSize(870, 560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        btnBack = new JButton("← Back");
        btnBack.setBounds(15, 12, 80, 27);
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(Color.DARK_GRAY);
        btnBack.setFont(new Font("Serif", Font.PLAIN, 13));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this);
        add(btnBack);

        // LEFT PANEL - profile card
        leftCard = new JPanel(null);
        leftCard.setBackground(Color.WHITE);
        leftCard.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        leftCard.setBounds(25, 55, 250, 455);
        add(leftCard);

        brandName  = new JLabel("Gadget Market", SwingConstants.CENTER);
        brandName.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 22));
        brandName.setForeground(Color.DARK_GRAY);
        brandName.setBounds(15, 22, 220, 35);
        leftCard.add(brandName);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(20, 62, 210, 1);
        sep1.setForeground(new Color(230, 230, 230));
        leftCard.add(sep1);

        java.net.URL profile = BrowsePage.class.getClassLoader().getResource("profile.jpg");
        ImageIcon profileRaw = new ImageIcon(profile);
        Image profileScale = profileRaw.getImage().getScaledInstance(140, 130, Image.SCALE_SMOOTH);
        ImageIcon profileIcon = new ImageIcon(profileScale);
            
            picLabel  = new JLabel(profileIcon, SwingConstants.CENTER);
            picLabel.setBounds(80, 80, 90, 90);
            leftCard.add(picLabel);
            
        usernameLabel = new JLabel(user.getUsername(), SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 20));
        usernameLabel.setForeground(Color.DARK_GRAY);
        usernameLabel.setBounds(20, 180, 210, 28);
        leftCard.add(usernameLabel);

        memberLabel = new JLabel(user.getMemberType(), SwingConstants.CENTER);
        memberLabel.setFont(new Font("Serif", Font.PLAIN, 13));
        memberLabel.setForeground(Color.LIGHT_GRAY);
        memberLabel.setBounds(20, 210, 210, 20);
        leftCard.add(memberLabel);

        addrTitle = new JLabel("Delivery Address:");
        addrTitle.setFont(new Font("Serif", Font.BOLD, 14));
        addrTitle.setForeground(Color.GRAY);
        addrTitle.setBounds(20, 260, 210, 20);
        leftCard.add(addrTitle);

        addressField = new JTextArea(user.getFullAddress());
        addressField.setFont(new Font("Serif", Font.PLAIN, 13));
        addressField.setForeground(Color.DARK_GRAY);
        addressField.setBorder(null);
        addressField.setBackground(Color.WHITE);
        addressField.setBounds(20, 285, 210, 60);
        leftCard.add(addressField);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(20, 248, 210, 1);
        sep2.setForeground(new Color(230, 230, 230));
        leftCard.add(sep2);

        btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Serif", Font.PLAIN, 15));
        btnLogout.setBackground(Color.DARK_GRAY);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBorderPainted(false);
        btnLogout.setBounds(30, 390, 190, 40);
        btnLogout.addActionListener(this);
        leftCard.add(btnLogout);

        // RIGHT PANEL - order history
        rightCard = new JPanel(null);
        rightCard.setBackground(Color.WHITE);
        rightCard.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        rightCard.setBounds(295, 55, 550, 455);
        add(rightCard);

        orderTitle = new JLabel("My Purchases");
        orderTitle.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 26));
        orderTitle.setForeground(Color.DARK_GRAY);
        orderTitle.setBounds(25, 20, 300, 38);
        rightCard.add(orderTitle);

        JSeparator sep3 = new JSeparator();
        sep3.setBounds(25, 62, 500, 1);
        sep3.setForeground(new Color(230, 230, 230));
        rightCard.add(sep3);

        orderListModel = new DefaultListModel<>();
        //refresh data
        orderListModel.clear();
        for (eCommerceData.OrderData.Order ref : eCommerceData.OrderData.getOrders()) {
            orderListModel.addElement(ref);
        }

        orderList = new JList<>(orderListModel);
        orderList.setFont(new Font("Serif", Font.PLAIN, 15));
        orderList.setForeground(Color.DARK_GRAY);
        orderList.setBackground(Color.WHITE);
        orderList.setFixedCellHeight(30);

        scrollPane = new JScrollPane(orderList);
        scrollPane.setBounds(25, 75, 500, 290);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        rightCard.add(scrollPane);

        JSeparator sep4 = new JSeparator();
        sep4.setBounds(25, 377, 500, 1);
        sep4.setForeground(new Color(230, 230, 230));
        rightCard.add(sep4);

        btnReceived = new JButton("✓  Mark as Received");
        btnReceived.setFont(new Font("Serif", Font.BOLD, 15));
        btnReceived.setBackground(Color.DARK_GRAY);
        btnReceived.setForeground(Color.WHITE);
        btnReceived.setBorderPainted(false);
        btnReceived.setBounds(25, 392, 235, 38);
        btnReceived.addActionListener(this);
        rightCard.add(btnReceived);
        
        btnCancel = new JButton("✕  Cancel Order");
        btnCancel.setFont(new Font("Serif", Font.BOLD, 15));
        btnCancel.setBackground(new Color(180, 60, 60));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBorderPainted(false);
        btnCancel.setBounds(290, 392, 235, 38);
        btnCancel.addActionListener(this);
        rightCard.add(btnCancel);
    }

        @Override
        public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnLogout) {
            
            int confirmLogout = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to log out?",
            "Log out",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

        if (confirmLogout == JOptionPane.YES_OPTION) {
            dispose();
            mainBP.dispose();
            new LoginPage().setVisible(true);
        }

            } else if (e.getSource() == btnBack) {
            dispose();

            } else if (e.getSource() == btnReceived) {
            Order order = orderList.getSelectedValue();
            
        if (order == null) {
            JOptionPane.showMessageDialog(
                    this, 
                    "Please select an order first", 
                    "No Selection", 
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (order.getStatus().equals("Received")) {
            JOptionPane.showMessageDialog(
                    this, 
                    "This order is already marked as order received", 
                    "Already Received", 
                    JOptionPane.INFORMATION_MESSAGE);
            
            } else {
            order.markReceived();
           
            orderListModel.clear();
            for (Order ord : OrderData.getOrders()) {
                orderListModel.addElement(ord);
            }
        }

            } else if (e.getSource() == btnCancel) {
                Order orders = orderList.getSelectedValue();
                
        int selectedIndex = orderList.getSelectedIndex();
        
        if (orders == null) {
            JOptionPane.showMessageDialog(
                    this, 
                    "Please select an order first", 
                    "No Selection", 
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (selectedIndex != -1) {
            String selectedItem = orderList.getSelectedValue().toString();
            
            if (selectedItem.contains("Order Received")) {
                    JOptionPane.showMessageDialog(
                        null, 
                        "You cannot cancel an order that has already been received!", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return; 
                }

            int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure? This cannot be undone",
            "Cancel Order",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            OrderData.removeOrder(orders);
            
            orderListModel.clear();
            for (Order order : OrderData.getOrders()) {
                orderListModel.addElement(order);
            }
        }
    }
}
}
}