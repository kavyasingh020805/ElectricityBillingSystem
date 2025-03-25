package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton cancel, signup, login;
    JTextField username, password;
    Choice loggingin;
    
    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(300, 20, 100, 20);
        add(lblusername);
        
        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(300, 80, 100, 20);
        add(lblpassword);
        
        password = new JTextField();
        password.setBounds(400, 80, 150, 20);
        add(password);
        
        JLabel logginginas = new JLabel("Logging in as");
        logginginas.setBounds(300, 140, 100, 20);
        add(logginginas);
        
        loggingin = new Choice();
        loggingin.setBounds(400, 140, 150, 20);
        loggingin.add("Admin");
        loggingin.add("Customer");
        add(loggingin);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2= i1.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);
        login = new JButton("Login", new ImageIcon(i2));
        login.setBounds(310, 200, 120, 25);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i4= i3.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);
        signup = new JButton("Sign Up", new ImageIcon(i4));
        signup.setBounds(440, 200, 120, 25);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i6= i5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i6));
        cancel.setBounds(375, 260, 120, 25);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8= i7.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 300, 300);
        add(image);
        
        setSize(600,400);
        setLocation(400,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String susername = username.getText();
            String spassword = password.getText();
            String user = loggingin.getSelectedItem();
            
            try{
                Conn c = new Conn();
                String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"'and user ='"+user+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user, meter);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            
            new SignUp();
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
  
    public static void main(String[] args){
        new Login();
    }
}
