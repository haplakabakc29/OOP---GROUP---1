/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Macy
 */

public class eWallet extends JFrame implements ActionListener {

    private JTextField txtNumber;
    private JButton btnPay;

    public eWallet() {

        setTitle("E-Wallet Payment");
        setSize(550,500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumber = new JLabel("Mobile Number:");
        lblNumber.setBounds(150,150,200,30);
        add(lblNumber);

        txtNumber = new JTextField();
        txtNumber.setBounds(250,150,150,30);
        add(txtNumber);

        btnPay = new JButton("Proceed to Summary");
        btnPay.setBounds(170,250,200,40);
        btnPay.addActionListener(this);
        add(btnPay);

        setVisible(true);
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
       
    String mobile = txtNumber.getText();

    
    if(mobile.isEmpty()){
        JOptionPane.showMessageDialog(this, "Mobile number is required.");
    }
   
    else if(!mobile.matches("\\d{10}")){
        JOptionPane.showMessageDialog(this, "Mobile number must be exactly 10 digits.");
    
    }else{
        orderDetails od = new orderDetails("E-Wallet");
        od.setVisible(true);
        dispose();
    }
}
        
}
