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

public class cod extends JFrame implements ActionListener {

    private JButton btnConfirm;

    public cod() {

        setTitle("Cash on Delivery");
        setSize(550,500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblInfo = new JLabel("You chose Cash on Delivery.");
        lblInfo.setBounds(190,150,250,30);
        add(lblInfo);

        btnConfirm = new JButton("Confirm Order");
        btnConfirm.setBounds(200,200,150,40);
        btnConfirm.addActionListener(this);
        add(btnConfirm);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        orderDetails od = new orderDetails("Cash on Delivery");
        od.setVisible(true);
        dispose();
    }
}

