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
public class card extends JFrame implements ActionListener {

    private JTextField txtCardNumber, txtName;
    private JButton btnPay;

    public card() {

        setTitle("Card Payment");
        setSize(550,500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblName = new JLabel("Card Holder Name:");
        lblName.setBounds(130,150,200,30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(250,150,150,30);
        add(txtName);

        JLabel lblCard = new JLabel("Card Number:");
        lblCard.setBounds(130,200,150,30);
        add(lblCard);

        txtCardNumber = new JTextField();
        txtCardNumber.setBounds(250,200,150,30);
        add(txtCardNumber);

        btnPay = new JButton("Proceed to Summary");
        btnPay.setBounds(180,300,200,40);
        btnPay.addActionListener(this);
        add(btnPay);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    String name = txtName.getText();
    String cardNum = txtCardNumber.getText();

       if(name.isEmpty()){
           JOptionPane.showMessageDialog(this, "Card holder name is required.");
       }
       else if(cardNum.isEmpty()){
           JOptionPane.showMessageDialog(this, "Card number is required.");
       }
      
       else if(!cardNum.matches("\\d{16}")){
           JOptionPane.showMessageDialog(this, "Card number must be exactly 16 digits.");
       
       }else{
            orderDetails od = new orderDetails("Credit/Debit Card");
            od.setVisible(true);
            dispose();    
        
       }
          
    }
}