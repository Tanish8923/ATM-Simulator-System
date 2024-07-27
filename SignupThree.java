package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingAccount , currentAccoount , fixedDepositAccount , recurringDeposiytAccount;
    JCheckBox atmCard , internetBanking , mobileBanking , emailSmsAlert , chequeBook , eStatement , condition; 
    JButton submit , cancel;
    String formno;

    public SignupThree(String formno){

        this.formno = formno;

        setLayout(null);

        JLabel accountDetails = new JLabel("Page 3 : Account Details");
        accountDetails.setBounds(250,20,400,40);
        accountDetails.setFont(new Font("Osward",Font.BOLD,30));
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type");
        accountType.setBounds(100,90,400,40);
        accountType.setFont(new Font("Osward",Font.BOLD,25));
        add(accountType);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setBounds(100,135 , 300, 25);
        savingAccount.setFont(new Font("Osward",Font.PLAIN,15));
        savingAccount.setBackground(Color.WHITE);
        add(savingAccount);

        currentAccoount = new JRadioButton("Current Account");
        currentAccoount.setBounds(400,135 , 400, 25);
        currentAccoount.setFont(new Font("Osward",Font.PLAIN,15));
        currentAccoount.setBackground(Color.WHITE);
        add(currentAccoount);

        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setBounds(100,165 , 300, 25);
        fixedDepositAccount.setFont(new Font("Osward",Font.PLAIN,15));
        fixedDepositAccount.setBackground(Color.WHITE);
        add(fixedDepositAccount);

        recurringDeposiytAccount = new JRadioButton("Recurring Deposit Account");
        recurringDeposiytAccount.setBounds(400,165 , 300, 25);
        recurringDeposiytAccount.setFont(new Font("Osward",Font.PLAIN,15));
        recurringDeposiytAccount.setBackground(Color.WHITE);
        add(recurringDeposiytAccount);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(savingAccount);
        accountgroup.add(currentAccoount);
        accountgroup.add(fixedDepositAccount);
        accountgroup.add(recurringDeposiytAccount);

        JLabel cardNumber = new JLabel("Card Number");
        cardNumber.setBounds(100,210,300 ,40);
        cardNumber.setFont(new Font("Osward",Font.BOLD,25));
        add(cardNumber);

        JLabel cardNumberinfo = new JLabel("Your 16 Digit Card Number");
        cardNumberinfo.setBounds(105,245,300 ,15);
        cardNumberinfo.setFont(new Font("Osward",Font.PLAIN,10));
        add(cardNumberinfo);

        JLabel Number = new JLabel("XXXX-XXXX-XXXX-2436");
        Number.setBounds(400,215,600 ,40);
        Number.setFont(new Font("Osward",Font.BOLD,25));
        add(Number);

        JLabel pinNumber = new JLabel("PIN");
        pinNumber.setBounds(100,280,300 ,40);
        pinNumber.setFont(new Font("Osward",Font.BOLD,25));
        add(pinNumber);

        JLabel pinNumberinfo = new JLabel("Your 4 Digit Password");
        pinNumberinfo.setBounds(105,315,300 ,15);
        pinNumberinfo.setFont(new Font("Osward",Font.PLAIN,10));
        add(pinNumberinfo);

        JLabel pNumber = new JLabel("XXXX");
        pNumber.setBounds(400,285,300 ,40);
        pNumber.setFont(new Font("Osward",Font.BOLD,25));
        add(pNumber);

        JLabel serviceRequired = new JLabel("Service Required");
        serviceRequired.setBounds(100,350,400,40);
        serviceRequired.setFont(new Font("Osward",Font.BOLD,25));
        add(serviceRequired);

        atmCard = new JCheckBox("ATM Card");                                 //here we create a object of JCheckBox(text) . JCheckBox create checkBox(tick markBox).
        atmCard.setBounds(100, 395, 300, 20);
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Osward",Font.PLAIN,15));
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBounds(400, 395, 300, 20);
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Osward",Font.PLAIN,15));
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(100, 420, 300, 20);
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Osward",Font.PLAIN,15));
        add(mobileBanking);

        emailSmsAlert = new JCheckBox("EMAIL & SMS Alert");
        emailSmsAlert.setBounds(400, 420, 300, 20);
        emailSmsAlert.setBackground(Color.WHITE);
        emailSmsAlert.setFont(new Font("Osward",Font.PLAIN,15));
        add(emailSmsAlert);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(100, 445, 300, 20);
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Osward",Font.PLAIN,15));
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBounds(400, 445, 300, 20);
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Osward",Font.PLAIN,15));
        add(eStatement);

        condition = new JCheckBox("I here by declares that the above entered details are correct to the best of my knowledge.");
        condition.setBounds(100, 495, 800, 20);
        condition.setBackground(Color.WHITE);
        condition.setFont(new Font("Osward",Font.PLAIN,15));
        add(condition);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Railway" , Font.BOLD , 18));
        submit.setBounds(300,540,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Railway" , Font.BOLD , 18));
        cancel.setBounds(420,540,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);                   
        setSize(800,600);                                       
        setLocation(250,25);
        setUndecorated(true);
        setVisible(true);  
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){                                      //ActionEvent object.geetSouce() is a function which button tells that ? 

            String accountType = null;

            if(savingAccount.isSelected()){
                accountType = "Saving Account";
            }else if(currentAccoount.isSelected()){
                accountType = "Current Account";
            }else if(fixedDepositAccount.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(recurringDeposiytAccount.isSelected()){
                accountType = "Recurring Deposit Account";
            }else{
                JOptionPane.showMessageDialog(null, "Account type is Required");
                return;
            }

            Random ran = new Random();
            String cardNumber = "" + Math.abs((ran.nextLong() % 90000000L) + 5040936000000000L);

            String pinNumber = "" + Math.abs((ran.nextLong() % 9000L) + 1009L);

            String facility = "  ";
            if(atmCard.isSelected()){
                facility = facility + "  " + "ATM Card";
            }if(internetBanking.isSelected()){
                facility = facility + "  " + "Internet Banking";
            }if(mobileBanking.isSelected()){
                facility = facility + "  " + "Mobile Banking";
            }if(chequeBook.isSelected()){
                facility = facility + "  " + "Cheque Book";
            }if(eStatement.isSelected()){
                facility = facility + "  " + "E-Statement";
            }if(emailSmsAlert.isSelected()){
                facility = facility + "  " + "EMAIL & SMS Alert";
            }

            try {
                if(!condition.isSelected()){
                    JOptionPane.showMessageDialog(null, "Declaration is Required");
                }
                else{
                    Conn c = new Conn();
                    String query = "insert into signupthree values('"+formno+"' , '"+accountType+"' , '"+cardNumber+"' , '"+pinNumber+"' , '"+facility+"')";
                    c.s.executeUpdate(query);
                    String query2 = "insert into login values('"+formno+"' , '"+cardNumber+"' , '"+pinNumber+"')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pinNumber );
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                    try {
                        Thread.sleep(50);
                        
                    } catch (Exception e) {
                    }
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
            try {
                Thread.sleep(50);
                
            } catch (Exception e) {
            }
        }

    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
