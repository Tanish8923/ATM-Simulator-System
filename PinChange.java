package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinTextField , repinTextField ;
    JButton back , change;
    String pinNumber;

    public PinChange(String pinNumber){

        this.pinNumber = pinNumber;

        setLayout(null);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankManagementSystem/icons/atm.jpg"));           
        Image i2 = i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);                            
        ImageIcon i3 = new ImageIcon(i2);             
        JLabel image = new JLabel(i3);                            
        image.setBounds(00,00,700,600);                                                               
        add(image);
    
        JLabel text = new JLabel("CHANGE YOUR PIN");                        
        text.setFont(new Font("Osward",Font.BOLD,16));    
        text.setForeground(Color.WHITE);       
        text.setBounds(180,185,300,20);
        image.add(text);

        JLabel pintext = new JLabel("New PIN");                        
        pintext.setFont(new Font("Osward",Font.BOLD,14));    
        pintext.setForeground(Color.WHITE);       
        pintext.setBounds(120,225,120,25);
        image.add(pintext);

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Osward" ,Font.BOLD , 14));
        pinTextField.setBounds(245, 228, 150, 20);
        image.add(pinTextField);

        JLabel repintext = new JLabel("Re-Enter New PIN");                        
        repintext.setFont(new Font("Osward",Font.BOLD,14));    
        repintext.setForeground(Color.WHITE);       
        repintext.setBounds(120,255,120,25);
        image.add(repintext);

        repinTextField = new JPasswordField();
        repinTextField.setFont(new Font("Osward" ,Font.BOLD , 14));
        repinTextField.setBounds(245, 258, 150, 20);
        image.add(repinTextField);

        change = new JButton("Change");
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.setFont(new Font("Railway" , Font.BOLD , 13));
        change.setBounds(250,324,155,20);
        change.addActionListener(this);
        image.add(change);
    
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Railway" , Font.BOLD , 13));
        back.setBounds(250,346,155,20);
        back.addActionListener(this);
        image.add(back);

        setSize(700,550);                                                                                
        setLocation(300,50);  
        setUndecorated(true);
        setVisible(true);  

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try {
                @SuppressWarnings("deprecation")
                String npin = pinTextField.getText();
                @SuppressWarnings("deprecation")
                String rpin = repinTextField.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null , "Entered PIN does not match" );
                    return;
                }if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter New PIN");
                    return;
                }if(npin.length() < 4){
                    JOptionPane.showMessageDialog(null, "Please enter 4-Digit PIN");
                    return;
                }if(npin.length() > 4){
                    JOptionPane.showMessageDialog(null, "Please enter 4-Digit PIN");
                    return;
                }
                Conn c = new Conn();
                String quer1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                String quer2 = "update login set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                String quer3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                c.s.executeUpdate(quer1);
                c.s.executeUpdate(quer2);
                c.s.executeUpdate(quer3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(npin).setVisible(true);                                //here we pass newPin because old pinNumber is not exist Know.
                try { 
                    Thread.sleep(50);
                    
                } catch (Exception e) {
                }
            } catch (Exception e) {
                System.out.println(e);
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
        new PinChange("");
    }
}
