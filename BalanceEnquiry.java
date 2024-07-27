package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;
    public BalanceEnquiry(String pinNumber){ 

        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankManagementSystem/icons/atm.jpg"));           
        Image i2 = i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);                            
        ImageIcon i3 = new ImageIcon(i2);             
        JLabel image = new JLabel(i3);                            
        image.setBounds(00,00,700,600);                                                               
        add(image);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raiway" , Font.BOLD , 13));
        back.setBounds(300,346,105,20);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();                                                //mostly we do this thing in actionPerformrd but here we do in constructor because we want when the frame will open it show the balance .
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                }else{
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        } 
        
        JLabel text = new JLabel("Your Current Account Balance is Rs  " + balance);                        
        text.setFont(new Font("Osward",Font.BOLD,12));    
        text.setForeground(Color.WHITE);       
        text.setBounds(130,250,400,30);
        image.add(text);

        setSize(700,550);                                                                                
        setLocation(300,50);  
        setUndecorated(true);
        setVisible(true);  
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
        try {
            Thread.sleep(50);
            
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
