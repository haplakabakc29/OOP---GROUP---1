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

public class paymentSelection extends JFrame implements ActionListener {

    private JRadioButton rbCOD, rbCard, rbEWallet;
    private JButton btnProceed;

    public paymentSelection() {

        setTitle("Payment Method");
        setSize(550,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Select Payment Method");
        lblTitle.setBounds(210,80,250,30);
        add(lblTitle);

        rbCOD = new JRadioButton("Cash on Delivery");
        rbCOD.setBounds(200,150,200,30);

        rbCard = new JRadioButton("Credit/Debit Card");
        rbCard.setBounds(200,190,200,30);

        rbEWallet = new JRadioButton("E-Wallet");
        rbEWallet.setBounds(200,230,200,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbCOD);
        bg.add(rbCard);
        bg.add(rbEWallet);

        add(rbCOD);
        add(rbCard);
        add(rbEWallet);

        btnProceed = new JButton("Proceed");
        btnProceed.setBounds(200,300,150,40);
        btnProceed.addActionListener(this);
        add(btnProceed);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(rbCOD.isSelected()){
            cod cod = new cod();
            cod.setVisible(true);
            dispose();
        }
        else if(rbCard.isSelected()){
            card cd = new card();
            cd.setVisible(true);
            dispose();
        }
        else if(rbEWallet.isSelected()){
            eWallet ew = new eWallet();
            ew.setVisible(true);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Please select a payment method.");
        }
    }
}
    
