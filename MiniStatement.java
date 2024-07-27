package BankManagementSystem;

import javax.swing.*;
import java.sql.*; 
import java.awt.event.*;
import java.awt.*;

public class MiniStatement extends JFrame implements ActionListener{

    JButton back;
    String pinNumber;

    public MiniStatement(String pinNumber){

        this.pinNumber = pinNumber;

        setLayout(null);

        JLabel text = new JLabel("Indian  Bank");
        text.setBounds(160, 20, 200, 30);
        text.setFont(new Font("Osward" , Font.BOLD , 25));
        add(text);

        JLabel text1 = new JLabel("Mini  Statement");
        text1.setBounds(177, 50, 200, 20);
        text1.setFont(new Font("Osward" , Font.BOLD , 15));
        add(text1);

        JLabel cardNumber = new JLabel();                                                //we don't mention any text in this label because we use this label dynamically.
        cardNumber.setBounds(20, 100, 400, 20);
        cardNumber.setFont(new Font("Osward" , Font.BOLD , 15));
        add(cardNumber);

        JLabel details = new JLabel();
        details.setBounds(80, 130, 340, 300);
        details.setFont(new Font("Osward" , Font.BOLD , 15));
        add(details);

        JLabel details1 = new JLabel();
        details1.setBounds(420, 130, 60, 300);
        details1.setFont(new Font("Osward" , Font.BOLD , 15));
        add(details1);

        JLabel balance = new JLabel();
        balance.setBounds(20, 430, 500, 40);
        balance.setFont(new Font("Osward" , Font.BOLD , 20));
        add(balance);


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinNumber+"'");
            while(rs.next()){
                cardNumber.setText("Card Number :    " + rs.getString("card_number").substring(0,4) + "XXXXXXXX" + rs.getString("card_number").substring(12));                               //JLabel object (cardNumber).setText() this method set text in which we pass in round bracket on label (which object label we use). 
            }
            
        } catch (Exception e) {         
            System.out.println(e);       
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"' ORDER BY Date DESC LIMIT 5");                        //here we use "order by date decs limit 5" which create a group of last 5 transections for particular pinNumber according to date.  
            while(rs.next()){
                details.setText(details.getText() +  "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "<br><br><html>");                        //we can use use html tag("<html>"......"<html>") in java for give - space(&nbsp;) , break(<br><br>) the line and many other thing. //details.getText() retrieves the current text content of the details label.setText() overwrite the data but we want first  append the data so we use getText(). and after that setText(). 
                details1.setText(details1.getText() +  "<html>" + rs.getString("Amount")+ "<br><br><html>");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        int bal = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    bal = bal + Integer.parseInt(rs.getString("amount"));
                }else{
                    bal = bal - Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is Rs  " + bal);
        }catch(Exception e){
            System.out.println(e);
        } 
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("Railway" , Font.BOLD , 13));
        back.setBounds(390,570,100,20);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);                   
        setSize(500,600);                                       
        setLocation(350,35);
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
        new MiniStatement("");
    }
}
