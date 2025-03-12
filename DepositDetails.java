package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class DepositDetails extends JFrame implements ActionListener{
    
    Choice meternumber, month;
    JTable table;
    JButton search, print;
    
    DepositDetails(){
        
        super("Deposit Details");
        
        setSize(700,700);
        setLocation(400,100);
        
        getContentPane().setBackground(Color.white);
        
        JLabel lblmeternumber = new JLabel("Search by meter number");
        lblmeternumber.setBounds(20, 20, 150, 20);
        add(lblmeternumber);
        
        meternumber = new Choice();
        meternumber.setBounds(180, 20, 150, 20);
        add(meternumber);
        
        try{
            Conn c = new Conn();
            String query = "select * from customer";
            
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                meternumber.add(rs.getString("meter_no"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblmonth = new JLabel("Search by Month");
        lblmonth.setBounds(400, 20, 120, 20);
        add(lblmonth);
        
        month = new Choice();
        month.setBounds(520, 20, 150, 20);
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
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from bill");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 600);
        add(sp);
        
        search = new JButton("Search");
        search.setBounds(20, 60, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 60, 80, 20);
        print.addActionListener(this);
        add(print);
        
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from bill where meter_no = '"+meternumber.getSelectedItem()+"' and month = '"+month.getSelectedItem()+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                
            }
        }else{
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
    new DepositDetails();
}
    
}