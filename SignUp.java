package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener {

    JButton Create, back;
    Choice create;
    JTextField uname, namee, pd, meter;

    SignUp() {

        super("SignUp Page");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(20, 30, 550, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);

        JLabel createacctas = new JLabel("Create Account As");
        createacctas.setBounds(40, 40, 140, 20);
        panel.add(createacctas);

        create = new Choice();
        create.setBounds(180, 40, 150, 20);
        create.add("Admin");
        create.add("Customer");
        panel.add(create);

        JLabel meter_no = new JLabel("Meter No.");
        meter_no.setBounds(40, 100, 140, 20);
        meter_no.setVisible(false);
        panel.add(meter_no);

        meter = new JTextField();
        meter.setBounds(140, 100, 150, 20);
        meter.setVisible(false);
        panel.add(meter);

        JLabel username = new JLabel("Username");
        username.setBounds(40, 130, 140, 20);
        panel.add(username);

        uname = new JTextField();
        uname.setBounds(140, 130, 150, 20);
        panel.add(uname);

        JLabel name = new JLabel("Name");
        name.setBounds(40, 160, 140, 20);
        panel.add(name);

        namee = new JTextField();
        namee.setBounds(140, 160, 150, 20);
        panel.add(namee);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 190, 140, 20);
        panel.add(password);

        pd = new JTextField();
        pd.setBounds(140, 190, 150, 20);
        panel.add(pd);

        meter.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '" + meter.getText() + "'");
                    while (rs.next()) {
                        namee.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        create.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                String user = create.getSelectedItem();

                if (user.equals("Customer")) {
                    meter_no.setVisible(true);
                    meter.setVisible(true);
                    namee.setEditable(false);
                } else {
                    meter_no.setVisible(false);
                    meter.setVisible(false);
                    namee.setEditable(true);
                }
            }
        });

        Create = new JButton("Create");
        Create.setBounds(50, 240, 100, 30);
        Create.addActionListener(this);
        Create.setBackground(Color.black);
        Create.setForeground(Color.white);
        panel.add(Create);

        back = new JButton("Back");
        back.setBounds(170, 240, 100, 30);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(330, 30, 220, 220);
        panel.add(img);

        setSize(600, 400);
        setLocation(400, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Create) {
            String atype = create.getSelectedItem();
            String susername = uname.getText();
            String sname = namee.getText();
            String spassword = pd.getText();
            String smeter = meter.getText();

            // Password validation
            if (!spassword.matches(".*[A-Za-z].*") || !spassword.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Password must contain at least one letter and one number.");
                return;
            }

            try {
                Conn c = new Conn();

                // Check for duplicate username
                ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE username = '" + susername + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username already exists. Please choose another one.");
                    return;
                }

                String query = "";
                if (atype.equals("Admin")) {
                    query = "insert into login values('" + smeter + "','" + susername + "','" + sname + "','" + spassword + "','" + atype + "')";
                } else {
                    query = "update login set username = '" + susername + "', password = '" + spassword + "', user = '" + atype + "' where meter_no = '" + smeter + "'";
                }

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");

                setVisible(false);
                new Login();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
