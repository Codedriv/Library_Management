
package librarysystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class addpatron  extends JFrame implements ActionListener{
    
    JTextField tfname,tfroll,tfaddress,tfphone,tfemail;
    JComboBox tfgrade;
    String Id;
    JButton view,add;
    addpatron(String Id)
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Patron Detail");
        heading.setBounds(280, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        JLabel labelroll = new JLabel("Patron_ID");
        labelroll.setBounds(220,150,150,30);
        labelroll.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelroll);
        
        tfroll =new JTextField();
        tfroll.setBounds(360, 150, 150, 30);
        add(tfroll);
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(220,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname =new JTextField();
        tfname.setBounds(360, 220, 150, 30);
        add(tfname);
        
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(220,290,150,30);
        labeladdress.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(360, 290, 150, 30);
        add(tfaddress);
        
         JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(220,360,150,30);
        labelphone.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelphone);
        
         tfphone =new JTextField();
        tfphone.setBounds(360, 360, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(220,430,150,30);
        labelemail.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelemail);
        
        tfemail =new JTextField();
        tfemail.setBounds(360,430, 150, 30);
        add(tfemail);
        
        
        
        
        add = new JButton("Add Details");
        add.setBounds(190,560,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,560,150,40);
        view.addActionListener(this);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        add(view);
        
        
        
        setSize(900,680);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
            
        if(ae.getSource()==add)
        {
            String roll=tfroll.getText();
            String name =tfname.getText();
            
            String phone =tfphone.getText();
            String email=tfemail.getText();
            String address=tfaddress.getText();
           
            
                try 
        {
            conn c = new conn();
            String query = "insert into patron values("+roll+",'"+name+"','"+address+"',"+phone+",'"+email+"')";
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
        new addpatron("");
    }
}

