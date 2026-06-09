package eCommerceDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DataBaseSaver {
    
    public static void saveTransaction(String user, String items, int total, String cardNum, String expiry, String cvv) {
        String sql = "INSERT INTO listtransactions(username, itemnames, itemprices, cardnumber, cardexpiry, cardcvv) VALUES(?,?,?,?,?,?)";
        
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            
            pstmt.setString(1, user);
            pstmt.setString(2, items);
            pstmt.setInt(3, total);
            pstmt.setString(4, cardNum);
            pstmt.setString(5, expiry);
            pstmt.setString(6, cvv);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Success!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"FAILED TO PUSH THE TRANSACTION!", "INFORMATION", JOptionPane.WARNING_MESSAGE);
        }
    }
}