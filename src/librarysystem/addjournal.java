
package librarysystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
public class addjournal  extends JFrame implements ActionListener{
    
    JTextField tfname,tfid,tfpublish,tffreq;
    Random ran = new Random();
    int number=ran.nextInt(9999);
    String id;
   
    JButton view,add;
    addjournal(String id)
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Journal Details");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        JLabel labelid = new JLabel("ISSN_ID");
        labelid.setBounds(220,150,150,30);
        labelid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelid);
        
        tfid =new JTextField(""+number);
        tfid.setBounds(360, 150, 150, 30);
        add(tfid);
        
     
        
        
        
        JLabel labelname = new JLabel("Title");
        labelname.setBounds(220,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname =new JTextField();
        tfname.setBounds(360, 220, 150, 30);
        add(tfname);
        
        
        
         JLabel labelpub = new JLabel("Publisher");
        labelpub.setBounds(220,290,150,30);
        labelpub.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelpub);
        
         tfpublish =new JTextField();
        tfpublish.setBounds(360, 290, 150, 30);
        add(tfpublish);
        
        JLabel labeldate=new JLabel("Frequency");
        labeldate.setBounds(220,360,150,30);
        labeldate.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldate);
        
        tffreq=new JTextField();
      tffreq.setBounds(360, 360, 150, 30);
        tffreq.setFont(new Font("SERIF",Font.PLAIN,20));
        add(tffreq);
        
        add = new JButton("Add Details");
        add.setBounds(220,500,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,500,150,40);
        view.addActionListener(this);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        add(view);
        
        
        
        setSize(780,680);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
            
        if(ae.getSource()==add)
        {
            String roll=tfid.getText();
            String name =tfname.getText();
        
            String publisher=tfpublish.getText();
            String freq=tffreq.getText();
         
           
                try 
        {
            conn c = new conn();
            String query = "insert into journal values("+roll+",'"+name+"','"+publisher+"','"+freq+"')";
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
        new addjournal(" ");
    }
}



