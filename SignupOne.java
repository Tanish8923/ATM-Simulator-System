package BankManagementSystem;

//here we import a jar file which name is jcalender because JDateChooser class is belong to that jar file and we also need to import com.toedter.calendar.JDateChooser; for that.
//we import jar file in 'Referenced Libraries'.

import java.awt.*;
import javax.swing.*;
import java.util.*;                                              //used classes - Random  , Date(Deposit class) 
import com.toedter.calendar.JDateChooser;                        //used classes -  JDateChooser
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
        JTextField nameTextField , fnameTextField , emailTextField , addressTextField , cityTextField , stateTextField , pincodeTextField ;    
        long random;
        JRadioButton married , unmarried , male , female;
        JButton next;
        JDateChooser datechooser ;
    SignupOne(){

        setLayout(null);

        Random ran = new Random();                                                 // Random class belongs to util package here we create a object of Random class.
        random = Math.abs (ran.nextLong() % 9000L) + 1000L;                        //Math.abs ensure that each value will positive and through Random object ran.nextLong() we create long number and after that we do % 9000L and after this we add 1000L  for geting 4 digits each time and after all this we store the value in random variable which data type is long.

        JLabel formno = new JLabel("APPLICATION FORM NO. "  + random);
        formno.setBounds(150,20,700,40);
        formno.setFont(new Font("Osward",Font.BOLD,30));
        add(formno);

        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setBounds(220,80,400,30);
        personDetails.setFont(new Font("Osward",Font.BOLD,25));
        add(personDetails);

        JLabel name = new JLabel("Name:");
        name.setBounds(120,150,300,20);
        name.setFont(new Font("Osward",Font.BOLD,20));
        add(name);

        nameTextField = new JTextField();                                                 
        nameTextField.setBounds(400,145,230,25);
        nameTextField.setFont(new Font("Arial" , Font.PLAIN , 20));
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(120,190,300,20);
        fname.setFont(new Font("Osward",Font.BOLD,20));
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(400,185,230,25);
        fnameTextField.setFont(new Font("Arial" , Font.PLAIN , 20));
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(120,230,300,20);
        dob.setFont(new Font("Osward",Font.BOLD,20));
        add(dob);

        datechooser = new JDateChooser();                                                 //JDateChooser() is a class which is use to craete a calender here we create a object (datechooser)of that class.
        datechooser.setBounds(400,225,230,25);
        add(datechooser);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(120,270,300,20);
        gender.setFont(new Font("Osward",Font.BOLD,20));
        add(gender);

        male = new JRadioButton("Male");                                             //JRadioButton() is a class through this class we create radio button.
        male.setBounds(400,265 , 115, 25);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(515,265,115,25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();                                      //ButtonGroup() is a class which is used to group radio buttons so we can choose one option at a time .
        gendergroup.add(female);                                                          //ButtonGroup() object (gendergroup).add(JRadioButton object); we can add any number of radion buttons for grouping using this sysntex.
        gendergroup.add(male);

        JLabel email = new JLabel("Email Address:");
        email.setBounds(120,310,300,20);
        email.setFont(new Font("Osward",Font.BOLD,20));
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(400,305,230,25);
        emailTextField.setFont(new Font("Arial" , Font.PLAIN , 20));
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(120,350,300,20);
        marital.setFont(new Font("Osward",Font.BOLD,20));
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(400,345 , 115, 25);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(515,345,115,25);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JLabel address = new JLabel("Address:");
        address.setBounds(120,390,300,20);
        address.setFont(new Font("Osward",Font.BOLD,20));
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(400,385,230,25);
        addressTextField.setFont(new Font("Arial" , Font.PLAIN , 20));
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setBounds(120,430,300,20);
        city.setFont(new Font("Osward",Font.BOLD,20));
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(400,425,230,25);
        cityTextField.setFont(new Font("Arial" , Font.PLAIN , 20));
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setBounds(120,470,300,20);
        state.setFont(new Font("Osward",Font.BOLD,20));
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(400,465,230,25);
        stateTextField.setFont(new Font("Arial" , Font.PLAIN , 20));
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setBounds(120,510,300,20);
        pincode.setFont(new Font("Osward",Font.BOLD,20));
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(400,505,230,25);
        pincodeTextField.setFont(new Font("Arial" , Font.PLAIN , 20));
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway" , Font.BOLD , 18));
        next.setBounds(650,550,80,30);
        next.addActionListener(this);
        add(next);

       
        getContentPane().setBackground(Color.WHITE);                   
        setSize(800,600);                                      
        setLocation(250,25);
        setUndecorated(true);
        setVisible(true);   
    }
    public void  actionPerformed(ActionEvent ae){
        String formno = "" + random;                            //here we convert the long number into string with the help of ("" + variable) . we can also convert any number into string with this syntex.
        String name = nameTextField.getText();                  //here we extract the value from nameTextField which is JTextField with the help of getText() method and this method return the value in String.
        String fname = fnameTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();              //datechooser is class inside this class .getDateEditor() is method inside this method .getUiComponent() it return a textField so we typr caste it in JTextField and now we have the access of textField so we use .getText()
        String gender = null ;                                  //here we extract the value from radio button
        if(male.isSelected()){                                  //through .isSelected() we can check the selection.
            gender = "Male";
        }else if(female.isSelected()){
            gender = "female";
        }else{
            JOptionPane.showMessageDialog(null, "Gender is Required");
            return;
        }
        String email = emailTextField.getText();

        String marital = null ;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else{
            JOptionPane.showMessageDialog(null, "Marital Status is Required");
            return;
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        try {                                                       //now we intrect with datebase which is externel entity so error(Runtime error) chances is high , so u need to use try and catch for exception handling.
            if(name.equals("")){                           //here we make a validation(check)
                JOptionPane.showMessageDialog(null, "Name is required");                        //JOptionPane is class inside this class .showMessageDialog(rootPane null , "message you want to show") is method which is using to create pop up.
            }else{
                Conn c = new Conn();                                //here we create a object of conn class which is responsible for stablish the connection with mysql.
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";     //here we write a query(DML command) //"String'"+variable+"'String"
                c.s.executeUpdate(query);                           //Conn class object 'c.s' (which is in Conn class and object of Statement class) after this .executeUpdate(query) is method which is use to run DML command. 
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                try {                                               //Thread class can give error(runtime error) which we need to handle by try and catch block.
                    Thread.sleep(50);                        //.sleep is a method in thread class which is use to stop the execution for some milli second .
                    
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }       
    public static void main(String[] args) {
        new SignupOne();
    }
}
