package eCommerceSystem;
import eCommerceData.LoggedUserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ViewProfilePage extends JFrame implements ActionListener  {
    
    private JLabel brandName, profilePicLabel, usernameLabel, userMemberLabel;
    private JButton logoutButton, btnBack;
    private JPanel card;
    
    private LoggedUserData userVP;
    private BrowsePage mainBP;

    public ViewProfilePage(LoggedUserData user, BrowsePage main) {
        
        this.userVP = user;
        this.mainBP = main;
        
        setTitle("Profile");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
 
       
        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.setBounds(100, 50, 350, 390);
        add(card);
        
        btnBack = new JButton("← Back");
        btnBack.setBounds(15, 12, 80, 25);
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(Color.DARK_GRAY);
        btnBack.setFont(new Font("Serif", Font.PLAIN, 14));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this);
        add(btnBack);
        
        brandName = new JLabel("Gadget Market", SwingConstants.CENTER);
        brandName.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 34));
        brandName.setForeground(Color.DARK_GRAY);
        brandName.setBounds(25, 20, 300, 50);
        card.add(brandName);
 
      
        JSeparator sep = new JSeparator();
        sep.setBounds(30, 72, 290, 2);
        sep.setForeground(new Color(220, 220, 220));
        card.add(sep);
 
      
        profilePicLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
             
                g2d.setColor(new Color(220, 220, 220));
                g2d.fillOval(0, 0, 90, 90);
 
               
                g2d.setColor(new Color(180, 180, 180));
                g2d.fillOval(27, 15, 36, 36);
 
                
                g2d.fillRoundRect(15, 57, 60, 33, 30, 30);
            }
        };
        profilePicLabel.setBounds(130, 90, 90, 90);
        card.add(profilePicLabel);
        
      
        usernameLabel = new JLabel(user.getUsername(), SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 20));
        usernameLabel.setForeground(Color.DARK_GRAY);
        usernameLabel.setBounds(50, 195, 250, 30);
        card.add(usernameLabel);
 
     
        userMemberLabel = new JLabel(user.getMemberType(), SwingConstants.CENTER);
        userMemberLabel.setFont(new Font("Serif", Font.PLAIN, 13));
        userMemberLabel.setForeground(Color.LIGHT_GRAY);
        userMemberLabel.setBounds(50, 225, 250, 20);
        card.add(userMemberLabel);
 
       
        JSeparator sep2 = new JSeparator();
        sep2.setBounds(30, 265, 290, 2);
        sep2.setForeground(new Color(220, 220, 220));
        card.add(sep2);
 
     
        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Serif", Font.PLAIN, 16));
        logoutButton.setBackground(Color.DARK_GRAY);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        logoutButton.setBounds(50, 310, 250, 40);
        logoutButton.addActionListener(this);
        card.add(logoutButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            dispose();
            mainBP.dispose();
            LoginPage login = new LoginPage();
            login.setVisible(true);
            
        } else if (e.getSource() == btnBack) {
            dispose();
        }
    }
}
