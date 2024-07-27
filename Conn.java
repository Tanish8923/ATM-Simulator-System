// 5 Steps of JDBC connectivity :
//                               Register the Driver 
//                               Create Connection
//                               Create Statement 
//                               Execute Query
//                               Close Connection
//


//here we import a jar file which name is mysql-connector for mysql connectivity. 
//we import jar file in 'Referenced Libraries'.

package BankManagementSystem;
import java.sql.*;                                                   //used classes - Connection , Statement , DriverManager

public class Conn {
    Connection c;                                                    // here Connection is class and we create object of that class 'c' Globally.
    Statement s;                                                     // here Statement  is class and we create object of that class 's' Globally.
    public Conn(){
        try{                                                         //Mysql is externel entity so error(Runtime error) chances is high , so u need to use try and catch for exception handling.
            c = DriverManager.getConnection("jdbc:mysql:///BANKMANAGEMENTSYSTEM" , "root" , "tg108923");                   //DriverManager is class and  .getConnectiomn is an method of that class and inside this method we need to pass the URL and here url is Connection String which we created ("jdbc:mysql:///BANKMANAGEMENTSYSTEM" , "root" , "#Tg108923") this String is ("jdbc:databaseName(mysql)"://(localhost:3306(3306 is port number and by default myql is run on localhost so we don't need to write this))/database name (BANKMANAGEMENTSYSTEM) ,mysql userName "root", password "#Tg108923"  )
            s = c.createStatement();                                 //here we call createStatement() through Connection object c.
        }catch (Exception e) {
           System.out.println(e); 
        }
    }

}
