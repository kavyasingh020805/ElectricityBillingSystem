package electricity.billing.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class ViewInformation extends JFrame {
    
    ViewInformation(){
        
        setBounds(350, 150, 850, 650);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(275, 10, 500, 40);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70, 80, 100, 20);
        add(lblname);
        
        JLabel name = new JLabel("");
        name.setBounds(200, 80, 100, 20);
        add(name);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(70, 140, 100, 20);
        add(lblmeternumber);
        
        JLabel meternumber = new JLabel("");
        meternumber.setBounds(200, 140, 100, 20);
        add(meternumber);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(70, 200, 100, 20);
        add(lbladdress);
        
        JLabel address = new JLabel("");
        address.setBounds(200, 200, 100, 20);
        add(address);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(70, 260, 100, 20);
        add(lblcity);
        
        JLabel city = new JLabel("");
        city.setBounds(200, 260, 100, 20);
        add(city);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(450, 80, 100, 20);
        add(lblstate);
        
        JLabel state = new JLabel("");
        state.setBounds(580, 80, 100, 20);
        add(state);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(450, 140, 100, 20);
        add(lblemail);
        
        JLabel email = new JLabel("");
        email.setBounds(580, 140, 100, 20);
        add(email);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(450, 200, 100, 20);
        add(lblphone);
        
        JLabel phone = new JLabel("");
        phone.setBounds(580, 200, 100, 20);
        add(phone);
        
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new ViewInformation();
    }
    
}
