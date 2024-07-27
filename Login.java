package BankManagementSystem;


import java.awt.*;                                                                //used classes - Image , Color                                
import java.awt.event.*;                                                          //used classes - ActionEvent , ActionListener
import java.sql.*;                                                                //used classes - ResultSet
import javax.swing.*;                                                             //used classes - JFrame ,JLabel , JButton , JRadioButton , JTextField , JPasswordField , ImageIcon , JOptionPane ,JCheckBox ,JComboBox<>   //here we import all packages of swing  

public class Login extends JFrame implements ActionListener{                      //Inheritate JFrame and implement ActionListener (so u need to overwrite the abstract methhod(actionPerformed(ActionEvent ae)) which is abstract method of ActionListener interface)
    JButton login , clear , signup , exit;                                        //here we define globaly JButton so know we can use these button in any method of that class. 
    JTextField cardTextField ;                                                    //here we define globaly JTextField so know we can use these Textfield in any method of that class. 
    JPasswordField pinTextField;                                                  //here we define globaly JPasswordField so know we can use these passwordfield in any method of that class. 
    Login(){
        setLayout(null);                                                                                           //u need to make null setLayout for creating custom layout by using setBounds().

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankManagementSystem/icons/logo.jpg"));           //ImageIcon is a class which is used to set the image on your frame . ClassLoader is a class which is used to pick the image from your system and getSystemResource is static method of ClassLoader class we pass the path of image in getSystemResource.
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);                              //for scale(resize) the image we use Image class . through getImage() we pick the image with the help of object of ImageIcon class after that we use getScaledInstance(width,height,Image.SCALE_DEFAULT) through this function we can resize the image.
        ImageIcon i3 = new ImageIcon(i2);                                                                                  // u can't put the object of Image class in JLabel so here we convert Image object into ImageIcon object.
        JLabel label = new JLabel(i3);                                                                                     //u cant't place the icon on frame directly so u need to use JLabel and pass the ImageIcon object in JLabel.         
        label.setBounds(70,10,100,100);                                                                   //setBounds(Distance from leftHandSide on frame , Distance from upperSide on frame, width of component , height of component) is use to set the location of component which you pass in JLabel so for that we use object of JLabel.
        add(label);                                                                                                        //add function is used to add the components on frame.

        JLabel text = new JLabel("Welcome to ATM");                         //Majorly JLabel is used to write any text on frame like that.
        text.setFont(new Font("Osward",Font.BOLD,38));                 //setFont() is function which is use to do changes in your textComponent(text) after that 'new Font( Font family , Font type , Font size)' here we create a object of 'Font' class through this we take a font for our text.
        text.setBounds(200,10,400,100);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raiway",Font.BOLD,28));
        cardno.setBounds(120,120,150,40);
        add(cardno);

        cardTextField = new JTextField();                                        //JTextField() is a class here we create a object (cardTextField) of that class through this class we can create a text field for take input from user. and we define JTextFild globally with his object cardTextField that's why our syntax looks like that otherwise it looks like -> JTextField cardTexField = new JTextField();
        cardTextField.setBounds(300,125,230,30);
        cardTextField.setFont(new Font("Arial" , Font.BOLD , 20));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raiway",Font.BOLD,28));
        pin.setBounds(120,180,150,40);
        add(pin);

        pinTextField = new JPasswordField();                                     //JPasswordField() is a class here we create a object (pinTextField) of that class through this class we can create a text field for take input from user and this input is not visible on screen because here we use JPasswordField . and we define JPasswordFild globally with his object pinTextField that's why our syntax looks like that otherwise it looks like -> JPasswordField pinTextField = new JPasswordField();
        pinTextField.setBounds(300,185,230,30);
        pinTextField.setFont(new Font("Arial" , Font.BOLD , 20));
        add(pinTextField);

        login = new JButton("SIGN IN");                                     //JButton(button name) is a class here we craete a object (login) of that class through this class we can create a button . and we define JButton globally with his object login that's why our syntax looks like that otherwise it looks like -> JButton login = new JButton('button name');
        login.setBounds(300,250, 100, 30);
        login.setBackground(Color.BLACK);                                       
        login.setForeground(Color.WHITE);                                        //Through setForeground() we can change tha color of font.
        login.addActionListener(this);                                           //Button object.addActionListener(this) is a function which is use to catch the button event.
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,250, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,290, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        exit = new JButton("EXIT");
        exit.setBounds(680,430, 100, 30);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(Color.WHITE);                      //through getContentPane() we pick whole frame after that through setBackground(Color.) we set the Color of Background by using Color class which belongs to awt package.
        //setTitle("Automated Teller Machine");                           //through setTitle we can set the title for frame its just like given the name to your frame.                            
        setSize(800,480);                                    //setSize define the length and width of your frame .
        setLocation(250,100);                                         //u need to set the location of your frame on screen because by default it will open your frame on topLeft of your screen. 
        setUndecorated(true);                                 //when we do setUndecorated(true) then extra components(frame header) on frame are clear use this before doing setVisible(true) otherwise it does not work.
        setVisible(true);                                               //visibility of frame is false by default so u need to do true by using setVisible for visible the frame for users.
        try {                                                             //Thread class can give error(runtime error) which we need to handle by try and catch block.
                Thread.sleep(50);                                  //.sleep is a method in thread class which is use to stop the execution for some milli second .
                
            } catch (Exception e) {
            }  
    }
    public void  actionPerformed(ActionEvent ae){                         //Here we overwrite the abstract method(actionPerformed)
        if(ae.getSource() == clear){                                      //ActionEvent object.geetSouce() is a function which button tells that ? 
            cardTextField.setText("");                                  //Through setText() we can set the text manually . 
            pinTextField.setText("");
        }
        else if(ae.getSource() == login){
            Conn c = new Conn();                                          //here we create a connection with conn class by createing a object of that class.
            String cardNumber = cardTextField.getText();                  //here we extract the value from cardTextField which is JTextField with the help of getText() method and this method return the value in String.
            @SuppressWarnings("deprecation")                              //SuppressWarnings("deprecation") is a annotation which is use to suppress warning related to use of depricated methods or classes.
            String pinNumber = pinTextField.getText();                    //getText() is depricated method for JPasswordField .
            String query = "select * from login where card_Number = '"+cardNumber+"' and pin = '"+pinNumber+"'";                     //here we write a query(DRL command) //"String'"+variable+"'String"
            try {                                                         //now we intrect with datebase which is externel entity so error(Runtime error) chances is high , so u need to use try and catch for exception handling.
                ResultSet rs = c.s.executeQuery(query);                   //Conn class object 'c.s' (which is in Conn class and object of Statement class) after this .executeQuery(query) is method which is use to run DRL(DDL) command. this query returns the data and the datatype of this data is ResultSet so we create a object of ResultSet. 
                if(rs.next()){                                            //.next is a method . If data is available then it returns true.    //rs.next() is a method of the ResultSet class, which advances the cursor to the next row in the result set.
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);;
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN   ");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            try {
                Thread.sleep(50);
                
            } catch (Exception e) {
            }
        }else if(ae.getSource() == exit){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();                                    //Anonymous object of Login class
    }
}