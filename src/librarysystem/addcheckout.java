
package librarysystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;

import java.util.*;

public class addcheckout extends JFrame implements ActionListener {
    JButton add,view;
    Choice tfid,tfpid;
    String id;
    JDateChooser cdate,ddate;
    addcheckout(String id)
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Checkout Details");
        heading.setBounds(260, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        
        JLabel labelid = new JLabel("Item_Id");
        labelid.setBounds(220,150,150,30);
        labelid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelid);
        
        tfid=new Choice();
        tfid.setBounds(380, 150, 150, 30);
        add(tfid);
        
        try
        {
            conn c= new conn();
            String query = "Select * from books";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                tfid.add(rs.getString("isbn"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            conn c= new conn();
            String query = "Select * from media";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                tfid.add(rs.getString("Media_Id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            conn c= new conn();
            String query = "Select * from journal";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                tfid.add(rs.getString("issn"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel labelpid = new JLabel("Patron_Id");
        labelpid.setBounds(220,220,150,30);
        labelpid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelpid);
        
        tfpid=new Choice();
        tfpid.setBounds(380, 220, 150, 30);
        add(tfpid);
        
        try
        {
            conn c= new conn();
            String query = "Select * from patron";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                tfpid.add(rs.getString("Patron_Id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        JLabel labeldate=new JLabel("Checkout_Date");
        labeldate.setBounds(220,290,150,30);
        labeldate.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldate);
        
        cdate=new JDateChooser();
        cdate.setBounds(380, 290, 150, 30);
        cdate.setFont(new Font("SERIF",Font.PLAIN,20));
        add(cdate);
        
        JLabel labeldates=new JLabel("Due_Date");
        labeldates.setBounds(220,360,150,30);
        labeldates.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldates);
        
        ddate=new JDateChooser();
        ddate.setBounds(380, 360, 150, 30);
        ddate.setFont(new Font("SERIF",Font.PLAIN,20));
        add(ddate);
        
        
        
       
        
        
              add = new JButton("Add Details");
        add.setBounds(190,460,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,460,150,40);
        view.addActionListener(this);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        add(view);
        
        
        
        setSize(780,600);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            String ids=(String)tfid.getSelectedItem();
            String pid =(String)tfpid.getSelectedItem();
            String date=((JTextField)cdate.getDateEditor().getUiComponent()).getText();
             String dates=((JTextField)ddate.getDateEditor().getUiComponent()).getText();
            
         
           
                try 
        {
            conn c = new conn();
            String query = "insert into checkout values("+ids+","+pid+",'"+date+"','"+dates+"')";
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
        new addcheckout("");
    }
}
