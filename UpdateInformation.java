package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener {

    JTextField tfaddress, tfcity, tfstate, tfemail, tfphone;
    JButton update, cancel;
    String meter;
    JLabel name;

    UpdateInformation(String meter) {

        this.meter = meter;

        setBounds(300, 150, 1050, 450);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(110, 10, 500, 40);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 70, 100, 20);
        add(lblname);

        name = new JLabel("");
        name.setBounds(160, 70, 200, 20);
        add(name);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(30, 110, 100, 20);
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(160, 110, 200, 20);
        add(meternumber);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 150, 100, 20);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(160, 150, 200, 20);
        add(tfaddress);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(30, 190, 100, 20);
        add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(160, 190, 200, 20);
        add(tfcity);

        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(30, 230, 100, 20);
        add(lblstate);

        tfstate = new JTextField();
        tfstate.setBounds(160, 230, 200, 20);
        add(tfstate);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 270, 100, 20);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(160, 270, 200, 20);
        add(tfemail);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 310, 100, 20);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(160, 310, 200, 20);
        add(tfphone);

        // Allow only digits for phone number input
        tfphone.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || tfphone.getText().length() >= 10) {
                    e.consume(); // ignore non-digit or extra input
                }
            }
        });

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" + meter + "'");

            while (rs.next()) {
                name.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(80, 350, 100, 30);
        add(update);
        update.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(200, 350, 100, 30);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 400, 300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();

            if (!email.endsWith("@gmail.com")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Gmail address ending with @gmail.com");
                return;
            }

            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit phone number.");
                return;
            }

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set address = '" + address + "', city = '" + city + "', state = '" + state + "', email = '" + email + "', phone = '" + phone + "' where meter_no ='" + meter + "'");

                JOptionPane.showMessageDialog(null, "Your details were updated successfully.");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateInformation("");
    }
}
