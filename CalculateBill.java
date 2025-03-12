package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class CalculateBill extends JFrame implements ActionListener {
    
    JLabel tfname, tfaddress; 
    JTextField tfstate;
    JButton cancel, next;
    Choice meternumber, month;
    
    CalculateBill(){  
        
        setSize(650, 450);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(120, 20, 300, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(100, 80, 100, 20);
        p.add(lblmeterno);
        
        meternumber = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                meternumber.add(rs.getString("meter_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        meternumber.setBounds(220, 80, 200, 20);
        p.add(meternumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 120, 100, 20);
        p.add(lblname);
        
        tfname = new JLabel("");
        tfname.setBounds(220, 120, 200, 20);
        p.add(tfname);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        tfaddress = new JLabel("");
        tfaddress.setBounds(220, 160, 200, 20);
        p.add(tfaddress);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        meternumber.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
                    while(rs.next()){
                        tfname.setText(rs.getString("name"));
                        tfaddress.setText(rs.getString("address"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lblstate = new JLabel("Units Consumed");
        lblstate.setBounds(100, 200, 100, 20);
        p.add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(220, 200, 200, 20);
        p.add(tfstate);
        
        JLabel lblcity = new JLabel("Month");
        lblcity.setBounds(100, 240, 100, 20);
        p.add(lblcity);
        
        month = new Choice();
        month.setBounds(220, 240, 200, 20);
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        p.add(month);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(140, 300, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        p.add(cancel);
        
        next = new JButton("Submit");
        next.setBounds(280, 300, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        p.add(next);
        
        setLayout(new BorderLayout());
        
        add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            String meterno = meternumber.getSelectedItem();
            String units = tfstate.getText();
            String months = month.getSelectedItem();
            
            int totalbill = 0;
            int units_consumed = Integer.parseInt(units);
            
            String query = "select * from tax_rent";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    
                    totalbill += units_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swachh_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            String query2 = "insert into bill values ('"+meterno+"','"+months+"','"+units+"','"+totalbill+"', 'unpaid')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query2);  
                
                JOptionPane.showMessageDialog(null, "Bill Details added successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new CalculateBill();
    }
}