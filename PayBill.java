package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class PayBill extends JFrame implements ActionListener{
    
    Choice month;
    JButton pay, back;
    String meter;
    
    PayBill(String meter){
        this.meter=meter;
        
        setLayout(null);
        setBounds(300, 150, 900, 600);
        
        JLabel heading = new JLabel("Pay Electricity Bill");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(320, 10, 300, 30);
        add(heading); 
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(35, 70, 100, 20);
        add(lblmeternumber);
        
        JLabel labelmeternumber = new JLabel("");
        labelmeternumber.setBounds(200, 70, 200, 20);
        add(labelmeternumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 140, 100, 20);
        add(lblname);
        
        JLabel labelname = new JLabel("");
        labelname.setBounds(200, 140, 200, 20);
        add(labelname);
        
        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(35, 210, 100, 20);
        add(lblmonth);
        
        month = new Choice();
        month.setBounds(200, 210, 200, 20);
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
        add(month);
        
        JLabel lblunits = new JLabel("Units");
        lblunits.setBounds(35, 280, 100, 20);
        add(lblunits);
        
        JLabel labelunits = new JLabel("");
        labelunits.setBounds(200, 280, 200, 20);
        add(labelunits);
        
        JLabel lbltotalbill = new JLabel("Total Bill");
        lbltotalbill.setBounds(35, 350, 100, 20);
        add(lbltotalbill);
        
        JLabel labeltotalbill = new JLabel("");
        labeltotalbill.setBounds(200, 350, 200, 20);
        add(labeltotalbill);
        
        JLabel lblstatus = new JLabel("Status");
        lblstatus.setBounds(35, 420, 100, 20);
        add(lblstatus);
        
        JLabel labelstatus = new JLabel("");
        labelstatus.setBounds(200, 420, 200, 20);
        labelstatus.setForeground(Color.red);
        add(labelstatus);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no ='"+meter+"'");
            while(rs.next()){
               labelmeternumber.setText(meter);
               labelname.setText(rs.getString("name"));
            }
            
            rs = c.s.executeQuery("select * from bill where meter_no ='"+meter+"'and month ='"+month.getSelectedItem()+"'");
            while(rs.next()){
               labelunits.setText(rs.getString("units"));
               labeltotalbill.setText(rs.getString("total_bill"));
               labelstatus.setText(rs.getString("status"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        month.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where meter_no ='"+meter+"'and month ='"+month.getSelectedItem()+"'");
                    while(rs.next()){
                        labelunits.setText(rs.getString("units"));
                        labeltotalbill.setText(rs.getString("total_bill"));
                        labelstatus.setText(rs.getString("status"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
        }
        });
        
        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.white);
        pay.setBounds(100, 480, 100, 30);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(230, 480, 100, 30);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(400,100,600,300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pay){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'paid' where meter_no = '"+meter+"' and month = '"+month.getSelectedItem()+"'");
            }catch(Exception e){
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new PayBill("");
    }
    
}
