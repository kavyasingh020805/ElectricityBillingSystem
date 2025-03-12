package electricity.billing.system;

import java.awt.Color;
import javax.swing.*;

public class ViewInformation extends JFrame {
    
    ViewInformation(){
        
        setBounds(350, 150, 850, 650);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new ViewInformation();
    }
    
}
