 package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    String atype, meter;
            
    Project(String atype, String meter){
        
        super("Electricity Billing System");
        
        this.atype = atype;
        this.meter = meter;
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        master.setFont(new Font("monospaced", Font.BOLD, 15));
        
        JMenuItem newcustomer = new JMenuItem("Add New Customer");
        newcustomer.setFont(new Font("monospaced", Font.BOLD, 12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image Image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(Image1);
        newcustomer.setIcon(i4);
        newcustomer.addActionListener(this);
        master.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced", Font.BOLD, 12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image Image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(Image2);
        customerdetails.setIcon(i5);
        customerdetails.addActionListener(this);
        master.add(customerdetails);
        
        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced", Font.BOLD, 12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image Image3 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(Image3);
        depositdetails.setIcon(i6);
        depositdetails.addActionListener(this);
        master.add(depositdetails);
        
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced", Font.BOLD, 12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image Image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(Image4);
        calculatebill.setIcon(i7);
        calculatebill.addActionListener(this);
        master.add(calculatebill);
        
        
        JMenu info = new JMenu("Information");
        info.setForeground(Color.red);
        info.setFont(new Font("monospaced", Font.BOLD, 15));
        
        JMenuItem updateinfo = new JMenuItem("Update Info");
        updateinfo.setFont(new Font("monospaced", Font.BOLD, 12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image Image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(Image5);
        updateinfo.setIcon(i8);
        updateinfo.addActionListener(this);
        info.add(updateinfo);
        
        JMenuItem viewinfo = new JMenuItem("View Info");
        viewinfo.setFont(new Font("monospaced", Font.BOLD, 12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image Image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(Image6);
        viewinfo.setIcon(i9);
        viewinfo.addActionListener(this);
        info.add(viewinfo);
        
        
        JMenu user = new JMenu("User");
        user.setForeground(Color.red);
        user.setFont(new Font("monospaced", Font.BOLD, 15));
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.BOLD, 12));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image Image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(Image7);
        paybill.setIcon(i10);
        paybill.addActionListener(this);
        user.add(paybill);
        
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced", Font.BOLD, 12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image Image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(Image8);
        billdetails.setIcon(i11);
        billdetails.addActionListener(this);
        user.add(billdetails);
        
        
        JMenu report = new JMenu("Report");
        report.setForeground(Color.red);
        report.setFont(new Font("monospaced", Font.BOLD, 15));
        
        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced", Font.BOLD, 12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image Image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(Image9);
        generatebill.setIcon(i12);
        generatebill.addActionListener(this);
        report.add(generatebill);
        
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.black);
        utility.setFont(new Font("monospaced", Font.BOLD, 15));
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.BOLD, 12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image Image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(Image10);
        notepad.setIcon(i13);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.BOLD, 12));
        calculator.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image Image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i14 = new ImageIcon(Image11);
        calculator.setIcon(i14);
        calculator.addActionListener(this);
        utility.add(calculator);
        
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.black);
        exit.setFont(new Font("monospaced", Font.BOLD, 15));
        
        JMenuItem logout = new JMenuItem("LogOut");
        logout.setFont(new Font("monospaced", Font.BOLD, 12));
        logout.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image Image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(Image12);
        logout.setIcon(i15);
        logout.addActionListener(this);
        exit.add(logout);
        
        if(atype.equals("Admin")){
            mb.add(master);
        }else{
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        
        mb.add(utility);
        mb.add(exit);
        
        setLayout(new FlowLayout());
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Add New Customer")){
            new NewCustomer();
        }else if(msg.equals("Customer Details")){
            new CustomerDetails();
        }else if(msg.equals("Deposit Details")){
            new DepositDetails();
        }else if(msg.equals("Calculate Bill")){
            new CalculateBill();
        }else if(msg.equals("View Info")){
            new ViewInformation(meter);
        }else if(msg.equals("Update Info")){
            new UpdateInformation(meter);
        }else if(msg.equals("Bill Details")){
            new BillDetails(meter);
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("LogOut")){
            setVisible(false);
            new Login();
        }else if(msg.equals("Pay Bill")){
            new PayBill(meter);
        }else if(msg.equals("Generate Bill")){
            new GenerateBill(meter);
        }
    }
    
    public static void main (String[] args){
        new Project("", "");
    }
    
} 
