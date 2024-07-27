package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw , back;
    String pinNumber;

    public Withdrawl(String pinNumber){

        this.pinNumber = pinNumber;

        setLayout(null);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankManagementSystem/icons/atm.jpg"));           
        Image i2 = i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);                            
        ImageIcon i3 = new ImageIcon(i2);             
        JLabel image = new JLabel(i3);                            
        image.setBounds(00,00,700,600);                                                               
        add(image);
    
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");                        
        text.setFont(new Font("Osward",Font.BOLD,13));    
        text.setForeground(Color.WHITE);       
        text.setBounds(120,200,300,35);
        image.add(text);
    
        amount = new JTextField();
        amount.setFont(new Font("Railway" ,Font.BOLD , 15));
        amount.setBounds(137, 250, 250, 20);
        image.add(amount);
    
        withdraw = new JButton("Withdraw");
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("Railway" , Font.BOLD , 13));
        withdraw.setBounds(250,324,155,20);
        withdraw.addActionListener(this);
        image.add(withdraw);
    
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Railway" , Font.BOLD , 13));
        back.setBounds(250,346,155,20);
        back.addActionListener(this);
        image.add(back);
    
        getContentPane().setBackground(Color.WHITE);                                          
        setSize(700,550);                                                                                
        setLocation(300,50);  
        setUndecorated(true);
        setVisible(true);  

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String amountFigure = amount.getText();
            Date currentDate = new Date();                                                         //here we create a object of date class through this class we can access the accurate date&time for the process which we do.
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     //SimpleDateFormat object dateFormat is created with a specific format pattern "yyyy-MM-dd HH:mm:ss". This pattern indicates the desired output format for the date.
            String date = dateFormat.format(currentDate);   
            if(amountFigure.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }else{
                Conn c = new Conn();
                try {
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){                            //here we create  a chcek that if  "type" column is equal to "Deposit" then execute the block.
                            balance = balance + Integer.parseInt(rs.getString("amount"));               //amount return the value in String but we want integer so we do typecaste using  "Integer.ParseInt"
                        }else{
                            balance = balance - Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(ae.getSource() != back && balance < Integer.parseInt(amountFigure)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    String query = "Insert into bank values('"+pinNumber+"' , '"+date+"' , 'Withdraw' , '"+amountFigure+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null , "Rs " + amountFigure + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                    try {
                        Thread.sleep(50);
                        
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
            try {
                Thread.sleep(50);
                
            } catch (Exception e) {
            }
        }
    }
    public static void main(String[] args) {
        new Withdrawl("null");
    }
    
}
