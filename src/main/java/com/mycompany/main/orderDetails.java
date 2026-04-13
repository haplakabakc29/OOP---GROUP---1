/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Macy
 */

public class orderDetails extends JFrame implements ActionListener {

    private JButton btnFinish;

    public orderDetails(String paymentMethod) {

        setTitle("Order Summary");
        setSize(550,500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblOrder = new JLabel("Order Summary");
        lblOrder.setBounds(240,80,250,30);
        add(lblOrder);

        JLabel lblDetails = new JLabel("Payment Method: " + paymentMethod);
        lblDetails.setBounds(180,150,200,30);
        add(lblDetails);

        JLabel lblTotal = new JLabel("Total Amount: ₱ 0");
        lblTotal.setBounds(180,190,200,30);
        add(lblTotal);

        btnFinish = new JButton("Confirm Payment");
        btnFinish.setBounds(180,270,200,40);
        btnFinish.addActionListener(this);
        add(btnFinish);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this,"Payment Successful!");
        System.exit(0);
    }
}
    
    

