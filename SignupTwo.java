package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField  panTextField , aadharTextField;
    JButton next; 
    JRadioButton exist , notexist , yes , no;
    JComboBox<String> occupationbox , religionbox , qualificationbox , categorybox , incomebox;
    String formno;

    public SignupTwo(String formno){                               //here we create a parameterized constructor because we want formNumber from that page which call this page so we can use formNumber as key for interrelate the data.

        this.formno = formno;                                      // By writing this.formno = formno; , we are setting the value of the instance variable formno to the value that was passed as a parameter when the constructor was called.

        setLayout(null);

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setBounds(220,20,400,40);
        additionalDetails.setFont(new Font("Osward",Font.BOLD,25));
        add(additionalDetails);

        JLabel religion = new JLabel("Relogion:");
        religion.setBounds(120,100,300,25);
        religion.setFont(new Font("Osward",Font.BOLD,20));
        add(religion);

        String religionval[] ={"Hindu" , "Muslim" , "Sikh" , "Christion" , "Other"};              //here we create  a String of array ehich contains a values of drop down.
        religionbox = new JComboBox<String>(religionval);                                         //here we create a object of JComboBox <data type> (String array name). JComboBox help to create drop down . through Choice class we acn also create drop down. 
        religionbox.setBackground(Color.WHITE);
        religionbox.setBounds(400,100,230,25);
        add(religionbox);
    
        JLabel category = new JLabel("Category:");
        category.setBounds(120,140,300,25);
        category.setFont(new Font("Osward",Font.BOLD,20));
        add(category);

        String categoryval[] ={"General" , "OBC" , "SC" , "ST" , "Other"}; 
        categorybox = new JComboBox<String>(categoryval);
        categorybox.setBackground(Color.WHITE);
        categorybox.setBounds(400,140,230,25);
        add(categorybox);

        JLabel income = new JLabel("Income:");
        income.setBounds(120,180,300,20);
        income.setFont(new Font("Osward",Font.BOLD,20));
        add(income);

        String incomeval[] ={"Null" , "< 1,50,000" , "<2,50,000" , "<5,00,000" , "Upto 10,00,000"}; 
        incomebox = new JComboBox<String>(incomeval);
        incomebox.setBackground(Color.WHITE);
        incomebox.setBounds(400,180,230,25);
        add(incomebox);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(120,220,300,20);
        qualification.setFont(new Font("Osward",Font.BOLD,20));
        add(qualification);

        String qualificationval[] ={"Not-Graduate" , "Graduate" , "Post-Graduate" , "Doctrate" , "Other"}; 
        qualificationbox = new JComboBox<String>(qualificationval);
        qualificationbox.setBackground(Color.WHITE);
        qualificationbox.setBounds(400,220,230,25);
        add(qualificationbox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(120,260,300,20);
        occupation.setFont(new Font("Osward",Font.BOLD,20));
        add(occupation);

        String occupationval[] ={"Salaried" , "Self-Empoyed" , "Business" , "Student" , "Retired" , "Other"}; 
        occupationbox = new JComboBox<String>(occupationval);
        occupationbox.setBackground(Color.WHITE);
        occupationbox.setBounds(400,260,230,25);
        add(occupationbox);

        JLabel pannumber = new JLabel("PAN Number:");
        pannumber.setBounds(120,300,300,20);
        pannumber.setFont(new Font("Osward",Font.BOLD,20));
        add(pannumber);

        panTextField = new JTextField();
        panTextField.setBounds(400,300,230,25);
        panTextField.setFont(new Font("Arial" , Font.PLAIN , 20));
        add(panTextField);

        JLabel aadharnumber = new JLabel("Aadhar Number:");
        aadharnumber.setBounds(120,340,300,20);
        aadharnumber.setFont(new Font("Osward",Font.BOLD,20));
        add(aadharnumber);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(400,340,230,25);
        aadharTextField.setFont(new Font("Arial" , Font.PLAIN , 20));
        add(aadharTextField);

        JLabel seniorcitizon = new JLabel("Senior Citizon:");
        seniorcitizon.setBounds(120,380,300,20);
        seniorcitizon.setFont(new Font("Osward",Font.BOLD,20));
        add(seniorcitizon);

        yes = new JRadioButton("Yes");
        yes.setBounds(400,380 , 115, 25);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("N0");
        no.setBounds(515,380,115,25);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup scitizongroup = new ButtonGroup();
        scitizongroup.add(yes);
        scitizongroup.add(no);

        JLabel existingaccount = new JLabel("Existing Account:");
        existingaccount.setBounds(120,420,300,25);
        existingaccount.setFont(new Font("Osward",Font.BOLD,20));
        add(existingaccount);

        exist = new JRadioButton("Yes");
        exist.setBounds(400,420 , 115, 25);
        exist.setBackground(Color.WHITE);
        add(exist);

        notexist = new JRadioButton("No");
        notexist.setBounds(515,420,115,25);
        notexist.setBackground(Color.WHITE);
        add(notexist);

        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(exist);
        existinggroup.add(notexist);

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
        String religion  = (String)religionbox.getSelectedItem();                            //getSelectedItem() is use to extract the value from drop down and it return object so we need to do typecaste.
        String category = (String)categorybox.getSelectedItem();
        String income = (String)incomebox.getSelectedItem();
        String qualification = (String)qualificationbox.getSelectedItem();
        String occupation = (String)occupationbox.getSelectedItem();
        String panno = panTextField.getText();
        String aadharno = aadharTextField.getText();
        String scitizongroup = null ;

        if(yes.isSelected()){
            scitizongroup = "Yes";
        }else if(no.isSelected()){
            scitizongroup = "No";
        }else{
            JOptionPane.showMessageDialog(null, "Senior Citizon option is Required");
            return;
        }

        String existinggroup = null ;

        if(exist.isSelected()){
            existinggroup = "Yes";
        }else if(notexist.isSelected()){
            existinggroup = "No";
        }else{
            JOptionPane.showMessageDialog(null, "Existing Account option is Required");
            return;
        }

        try {
            if(panno.equals("")){
                JOptionPane.showMessageDialog(null, "PAN is required");
            }else if(aadharno.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar is required");
            } else{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"' , '"+religion+"' , '"+category+"' , '"+income+"' , '"+qualification+"' , '"+occupation+"' , '"+panno+"' , '"+aadharno+"' , '"+scitizongroup+"' , '"+existinggroup+"')";    //make sure our attributes sequence is same in mysql table as the query otherwise it insert values in wrong attributes.  
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                try {
                    Thread.sleep(50);
                    
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
