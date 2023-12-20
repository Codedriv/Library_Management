
package librarysystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class splash  extends JFrame implements ActionListener{
    splash()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/library.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);
        
        JButton clickhere =new JButton("Click here to continue");
        clickhere.setBounds(350,400,300,70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
        
    }
    
    public static void main(String args[])
    {
        new splash();
        
    }
}
