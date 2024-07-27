package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;                                               //ResultSet
import java.text.SimpleDateFormat;
import java.util.Date;                                           //here we specificly metion 'Daate' because sql package also contain 'Date' class .

public class FastCash extends JFrame implements ActionListener {

    JButton withdraw1 , withdraw2 , withdraw3 , withdraw4 , withdraw5 , withdraw6 ,  back;
    String pinNumber;

    public FastCash(String pinNumber){

        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankManagementSystem/icons/atm.jpg"));           
        Image i2 = i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);                            
        ImageIcon i3 = new ImageIcon(i2);             
        JLabel image = new JLabel(i3);                            
        image.setBounds(00,00,700,600);                                                               
        add(image);
        
        JLabel text = new JLabel("SELECT  WITHDRAWL  AMOUNT");                        
        text.setFont(new Font("Osward",Font.BOLD,15));    
        text.setForeground(Color.WHITE);       
        text.setBounds(135,200,700,35);
        image.add(text);

        withdraw1 = new JButton("Rs 100");
        withdraw1.setBackground(Color.BLACK);
        withdraw1.setForeground(Color.WHITE);
        withdraw1.setFont(new Font("Raiway" , Font.BOLD , 13));
        withdraw1.setBounds(120,280,130,20);
        withdraw1.addActionListener(this);
        image.add(withdraw1);

        withdraw2 = new JButton("Rs 500");
        withdraw2.setBackground(Color.BLACK);
        withdraw2.setForeground(Color.WHITE);
        withdraw2.setFont(new Font("Raiway" , Font.BOLD ,13));
        withdraw2.setBounds(250,280,155,20);
        withdraw2.addActionListener(this);
        image.add(withdraw2);

        withdraw3 = new JButton("Rs 1000");
        withdraw3.setBackground(Color.BLACK);
        withdraw3.setForeground(Color.WHITE);
        withdraw3.setFont(new Font("Raiway" , Font.BOLD , 13));
        withdraw3.setBounds(120,302,130,20);
        withdraw3.addActionListener(this);
        image.add(withdraw3);

        withdraw4 = new JButton("Rs 2000");
        withdraw4.setBackground(Color.BLACK);
        withdraw4.setForeground(Color.WHITE);
        withdraw4.setFont(new Font("Raiway" , Font.BOLD , 13));
        withdraw4.setBounds(250,302,155,20);
        withdraw4.addActionListener(this);
        image.add(withdraw4);

        withdraw5 = new JButton("Rs 5000");
        withdraw5.setBackground(Color.BLACK);
        withdraw5.setForeground(Color.WHITE);
        withdraw5.setFont(new Font("Raiway" , Font.BOLD , 13));
        withdraw5.setBounds(120,324,130,20);
        withdraw5.addActionListener(this);
        image.add(withdraw5);

        withdraw6 = new JButton("Rs 10000");
        withdraw6.setBackground(Color.BLACK);
        withdraw6.setForeground(Color.WHITE);
        withdraw6.setFont(new Font("Raiway" , Font.BOLD , 13));
        withdraw6.setBounds(250,324,155,20);
        withdraw6.addActionListener(this);
        image.add(withdraw6);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raiway" , Font.BOLD , 13));
        back.setBounds(120,346,130,20);
        back.addActionListener(this);
        image.add(back);

        getContentPane().setBackground(Color.WHITE);                                          
        setSize(700,550);                                                                                
        setLocation(300,50);  
        setUndecorated(true);
        setVisible(true);  
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);               //ae.getSource() returns object so we do typecaste in JButton after this we use .getText() and here what we do is we taking value dynamically it mean instead of checking each button , we take the text of button and create a substring for that value because first three letter are not useful.  
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){                                                                      //rs.next() help to do loop each row of ResultSet.
                    if(rs.getString("type").equals("Deposit")){                   //here we create  a chcek that if  "type" column is equal to "Deposit" then execute the block. and we get the string value from table through .getString() method.
                        balance = balance + Integer.parseInt(rs.getString("amount"));      //amount return the value in String but we want integer so we do typecaste using  "Integer.ParseInt"
                    }else{
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                }
                Date currentDate = new Date();                                                         //here we create a object of date class through this class we can access the accurate date&time for the process which we do.
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     //SimpleDateFormat object dateFormat is created with a specific format pattern "yyyy-MM-dd HH:mm:ss". This pattern indicates the desired output format for the date.
                String date = dateFormat.format(currentDate);   
                String query = "insert into bank values('"+pinNumber+"' , '"+date+"' , 'Withdraw' , '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully" );  
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
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}