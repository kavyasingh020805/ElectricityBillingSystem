package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MeterInfo extends JFrame implements ActionListener {
    
    JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphoneno;
    JButton cancel, next;
    JLabel lblmeter;
    Choice meterlocation, metertype, phasecode, billtype;
    String meter;
    
    MeterInfo(String meter){ 
        this.meter = meter;      
        
        setSize(650, 500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("Meter Info");
        heading.setBounds(150, 20, 200, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Meter Number");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);
        
        JLabel lblmeternumber = new JLabel(meter);
        lblmeternumber.setBounds(220, 80, 100, 20);
        p.add(lblmeternumber);
        
        JLabel lblmeterno = new JLabel("Meter Location");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        
        meterlocation = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(220, 120, 200, 20);
        p.add(meterlocation);
        
        JLabel lbladdress = new JLabel("Meter Type");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(220, 160, 200, 20);
        p.add(metertype);
        
        JLabel lblstate = new JLabel("Phase Code");
        lblstate.setBounds(100, 200, 100, 20);
        p.add(lblstate);
        
        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(220, 200, 200, 20);
        p.add(phasecode);
        
        JLabel lblcity = new JLabel("Bill Type");
        lblcity.setBounds(100, 240, 100, 20);
        p.add(lblcity);
        
        billtype = new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(220, 240, 200, 20);
        p.add(billtype);
        
        JLabel lblemail = new JLabel("Days");
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);
        
        JLabel lblemails = new JLabel("30 Days");
        lblemails.setBounds(220, 280, 200, 20);
        p.add(lblemails);
        
        JLabel lblphoneno = new JLabel("Note");
        lblphoneno.setBounds(100, 320, 100, 20);
        p.add(lblphoneno);
        
        JLabel lblphonenos = new JLabel("By default bill is calculated for 30 days only.");
        lblphonenos.setBounds(220, 320, 250, 20);
        p.add(lblphonenos);
        
        next = new JButton("Submit");
        next.setBounds(200, 380, 100, 30);
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
            String meterno = meter;
            String location = meterlocation.getSelectedItem();
            String type = metertype.getSelectedItem();
            String code = phasecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String day = "30";
            
            String query = "insert into meter_info values('"+meterno+"','"+location+"','"+type+"','"+code+"','"+typebill+"','"+day+"')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Meter Details added successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
    public static void main(String[] args){
        new MeterInfo(" ");
    }
}
