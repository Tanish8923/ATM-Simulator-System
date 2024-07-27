package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit , withdrawl , fastCash , miniStatement , pinChange , balanceEnquiry ,  exit;
    String pinNumber;

    public Transactions(String pinNumber){

        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankManagementSystem/icons/atm.jpg"));           
        Image i2 = i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);                            
        ImageIcon i3 = new ImageIcon(i2);             
        JLabel image = new JLabel(i3);                            
        image.setBounds(00,00,700,600);                                                               
        add(image);
        
        JLabel text = new JLabel("Please select your Treansactions");                        
        text.setFont(new Font("Osward",Font.BOLD,15));    
        text.setForeground(Color.WHITE);       
        text.setBounds(135,200,700,35);
        image.add(text);                                                                       //here we write image.add(text) instead of add(text) because we  want to add text on image instead of frame. 

        deposit = new JButton("Deposit");
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Railway" , Font.BOLD , 13));
        deposit.setBounds(120,280,130,20);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBackground(Color.BLACK);
        withdrawl.setForeground(Color.WHITE);
        withdrawl.setFont(new Font("Railway" , Font.BOLD ,13));
        withdrawl.setBounds(250,280,155,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Fast Cash");
        fastCash.setBackground(Color.BLACK);
        fastCash.setForeground(Color.WHITE);
        fastCash.setFont(new Font("Railway" , Font.BOLD , 13));
        fastCash.setBounds(120,302,130,20);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBackground(Color.BLACK);
        miniStatement.setForeground(Color.WHITE);
        miniStatement.setFont(new Font("Railway" , Font.BOLD , 13));
        miniStatement.setBounds(250,302,155,20);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("PIN Change");
        pinChange.setBackground(Color.BLACK);
        pinChange.setForeground(Color.WHITE);
        pinChange.setFont(new Font("Railway" , Font.BOLD , 13));
        pinChange.setBounds(120,324,130,20);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBackground(Color.BLACK);
        balanceEnquiry.setForeground(Color.WHITE);
        balanceEnquiry.setFont(new Font("Railway" , Font.BOLD , 13));
        balanceEnquiry.setBounds(250,324,155,20);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("EXIT");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Railway" , Font.BOLD , 13));
        exit.setBounds(120,346,130,20);
        exit.addActionListener(this);
        image.add(exit);

        getContentPane().setBackground(Color.WHITE);                                          
        setSize(700,550);                                                                                
        setLocation(300,50);  
        setUndecorated(true);                                //when we do setUndecorated(true) then extra components on frame are clear.
        setVisible(true);  
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);                                       //The System.exit(0) statement in Java is used to terminate the Java Virtual Machine (JVM) and exit the program.
            //setVisible(false);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
            try {
                Thread.sleep(50);
                
            } catch (Exception e) {
            }
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
            try {
                Thread.sleep(50);
                
            } catch (Exception e) {
            }
        }else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
            try {
                Thread.sleep(50);
                
            } catch (Exception e) {
            }
        }else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
            try {
                Thread.sleep(50);
                
            } catch (Exception e) {
            }
        }else if(ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
            try {
                Thread.sleep(50);
                
            } catch (Exception e) {
            }
        }else if(ae.getSource() == miniStatement){
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
            try {
                Thread.sleep(50);
                
            } catch (Exception e) {
            }
        }        
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
