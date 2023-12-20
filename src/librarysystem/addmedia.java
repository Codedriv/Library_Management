
package librarysystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
public class addmedia  extends JFrame implements ActionListener{
    
    JTextField tfname,tfid;
    Random ran = new Random();
    int number=ran.nextInt(9999);
    String id;
    JComboBox tftype;
   
    JButton view,add;
    addmedia(String id)
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Media Details");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        JLabel labelid = new JLabel("Media_ID");
        labelid.setBounds(220,150,150,30);
        labelid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelid);
        
        tfid =new JTextField(""+number);
        tfid.setBounds(360, 150, 150, 30);
        add(tfid);
        
      
        
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(220,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname =new JTextField();
        tfname.setBounds(360, 220, 150, 30);
        add(tfname);
        
        
        
        JLabel labeltype = new JLabel("Type");
        labeltype.setBounds(220,290,150,30);
        labeltype.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeltype);
        
        String Type[]={"","DVD","CD","Audio_Books"};
        tftype =new JComboBox(Type);
        tftype.setBounds(360, 290, 150, 30);
        add(tftype);
        
        
        
        add = new JButton("Add Details");
        add.setBounds(190,360,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,360,150,40);
        view.addActionListener(this);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        add(view);
        
        
        
        setSize(780,520);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
            
        if(ae.getSource()==add)
        {
            String roll=tfid.getText();
            String name =tfname.getText();
            String type=(String)tftype.getSelectedItem();
         
           
                try 
        {
            conn c = new conn();
            String query = "insert into media values("+roll+",'"+name+"','"+type+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details Added Successfully");
            setVisible(false);
            new home();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        } 
        else
            {
               setVisible(false);
               new home();
            }
        
    
    }
    public static void main(String [] args)
    {
        new addmedia(" ");
    }
}





