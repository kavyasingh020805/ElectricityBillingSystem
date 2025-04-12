package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class NewCustomer extends JFrame implements ActionListener {
    
    JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphoneno;
    JButton cancel, next;
    JLabel lblmeter;
    
    NewCustomer(){ 
        
        super("Add New Customer Details"); 
        
        setSize(650, 500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(150, 20, 200, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 200, 20);
        p.add(tfname);
        
        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        
        lblmeter = new JLabel("");
        lblmeter.setBounds(220, 120, 100, 20);
        p.add(lblmeter);
        
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        lblmeter.setText(""+ Math.abs(number));
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 160, 200, 20);
        p.add(tfaddress);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100, 200, 100, 20);
        p.add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(220, 200, 200, 20);
        p.add(tfstate);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(100, 240, 100, 20);
        p.add(lblcity);
        
        tfcity = new JTextField();
        tfcity.setBounds(220, 240, 200, 20);
        p.add(tfcity);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 280, 200, 20);
        p.add(tfemail);
        
        JLabel lblphoneno = new JLabel("Phone Number");
        lblphoneno.setBounds(100, 320, 100, 20);
        p.add(lblphoneno);
        
        tfphoneno = new JTextField();
        tfphoneno.setBounds(220, 320, 200, 20);
        p.add(tfphoneno);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(140, 380, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        p.add(cancel);
        
        next = new JButton("Next");
        next.setBounds(280, 380, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        p.add(next);
        
        setLayout(new BorderLayout());
        
        add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            String name = tfname.getText();
            String meter = lblmeter.getText();
            String address = tfaddress.getText();
            String state = tfstate.getText();
            String city = tfcity.getText();
            String email = tfemail.getText();
            String phoneno = tfphoneno.getText();
            
            String query1 = "insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phoneno+"')";
            String query2 = "insert into login values('"+meter+"', '', '"+name+"', '', '')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Details added successfully");
                setVisible(false);
                new MeterInfo(meter);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new NewCustomer();
    }
}
