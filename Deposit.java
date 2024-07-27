package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;                                     //SimpleDateFormat class, which helps in formatting dates. is come inside the "import java.text.SimpleDateFormat;" taht package. 
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit , back;
    String pinNumber;

    public Deposit(String pinNumber){

        this.pinNumber = pinNumber;

        setLayout(null);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankManagementSystem/icons/atm.jpg"));           
        Image i2 = i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);                            
        ImageIcon i3 = new ImageIcon(i2);             
        JLabel image = new JLabel(i3);                            
        image.setBounds(00,00,700,600);                                                               
        add(image);
    
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");                        
        text.setFont(new Font("Osward",Font.BOLD,13));    
        text.setForeground(Color.WHITE);       
        text.setBounds(130,200,300,35);
        image.add(text);
    
        amount = new JTextField();
        amount.setFont(new Font("Raiway" ,Font.BOLD , 15));
        amount.setBounds(137, 250, 250, 20);
        image.add(amount);
    
        deposit = new JButton("Deposit");
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Raiway" , Font.BOLD , 13));
        deposit.setBounds(250,324,155,20);
        deposit.addActionListener(this);
        image.add(deposit);
    
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raiway" , Font.BOLD , 13));
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
        if(ae.getSource() == deposit){
            String amountFigure = amount.getText();
            Date currentDate = new Date();                                                         //here we create a object of date class through this class we can access the accurate date&time for the process which we do.
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     //SimpleDateFormat object dateFormat is created with a specific format pattern "yyyy-MM-dd HH:mm:ss". This pattern indicates the desired output format for the date.
            String date = dateFormat.format(currentDate);                                          //The dateFormat.format() method is called with the currentDate to format the Date according to the specified pattern. The formatted date is then stored in the date variable.
            if(amountFigure.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else{
                Conn c = new Conn();
                String query = "Insert into bank values('"+pinNumber+"' , '"+date+"' , 'Deposit' , '"+amountFigure+"')";
                try {
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null , "Rs " + amountFigure +" Deposited Successfully");
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
        new Deposit("");
    }
    
}
