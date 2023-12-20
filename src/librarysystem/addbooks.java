
package librarysystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
public class addbooks  extends JFrame implements ActionListener{
    
    JTextField tfname,tfid,tfauthor,tfpublish;
    Random ran = new Random();
    int number=ran.nextInt(9999);
    String id;
    JDateChooser date;
    JButton view,add;
    addbooks(String id)
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Books Detail");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        JLabel labelid = new JLabel("ISBN_ID");
        labelid.setBounds(50,150,150,30);
        labelid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelid);
        
        tfid =new JTextField(""+number);
        tfid.setBounds(150, 150, 150, 30);
        add(tfid);
        
         JLabel labelnames = new JLabel("Author");
        labelnames.setBounds(50,290,150,30);
        labelnames.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelnames);
        
        tfauthor =new JTextField();
         tfauthor.setBounds(150, 290, 150, 30);
        add( tfauthor);
        
        
        
        JLabel labelname = new JLabel("Title");
        labelname.setBounds(50,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname =new JTextField();
        tfname.setBounds(150, 220, 150, 30);
        add(tfname);
        
        
        
         JLabel labelpub = new JLabel("Publisher");
        labelpub.setBounds(50,360,150,30);
        labelpub.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelpub);
        
         tfpublish =new JTextField();
        tfpublish.setBounds(150, 360, 150, 30);
        add(tfpublish);
        
        JLabel labeldate=new JLabel("Date");
        labeldate.setBounds(50,430,150,30);
        labeldate.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldate);
        
        date=new JDateChooser();
        date.setBounds(150, 430, 150, 30);
        date.setFont(new Font("SERIF",Font.PLAIN,20));
        add(date);
        
        add = new JButton("Add Details");
        add.setBounds(220,580,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,580,150,40);
        view.addActionListener(this);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        add(view);
        
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
            
        if(ae.getSource()==add)
        {
            String roll=tfid.getText();
            String name =tfname.getText();
            String author=tfauthor.getText();
            String publisher=tfpublish.getText();
         String dates= ((JTextField)date.getDateEditor().getUiComponent()).getText();
            
           
                try 
        {
            conn c = new conn();
            String query = "insert into books values("+roll+",'"+name+"','"+author+"','"+publisher+"','"+dates+"')";
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
        new addbooks(" ");
    }
}

