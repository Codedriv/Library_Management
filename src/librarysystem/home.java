
package librarysystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class home extends JFrame implements ActionListener{
    
    JButton books,journals,other,patron,checkouts;
    
    home()
    {
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/blur.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);
         
        
      
        books =new JButton("Books");
        books.setBounds(100,150,200,40);
        books.setBackground(Color.BLACK);
        books.setForeground(Color.WHITE);
        
        books.addActionListener(this);
        add(books);
        
        journals = new JButton("Journals");
        journals.setBounds(470,150,200,40);
        journals.setBackground(Color.BLACK);
        journals.addActionListener(this);
        journals.setForeground(Color.WHITE);
        add(journals);
        journals.addActionListener(this);
        add(journals);
        
        other = new JButton("Media");
        other.setBounds(900,150,200,40);
        other.setBackground(Color.BLACK);
        other.addActionListener(this);
        other.setForeground(Color.WHITE);
        add(other);
        other.addActionListener(this);
        add(other);
        
        patron = new JButton("Patrons");
        patron.setBounds(270,280,200,40);
        patron.setBackground(Color.BLACK);
        patron.addActionListener(this);
        patron.setForeground(Color.WHITE);
        add(patron);
        patron.addActionListener(this);
        add(patron);
        
        checkouts = new JButton("Checkout");
        checkouts.setBounds(700,280,200,40);
        checkouts.setBackground(Color.BLACK);
        checkouts.addActionListener(this);
        checkouts.setForeground(Color.WHITE);
        add(checkouts);
        checkouts.addActionListener(this);
        add(checkouts);
        
        
        setSize(1170,650);
        setLocation(250,100);
        setVisible(true);
        
        
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==books)
        {
            setVisible(false);
            new viewbooks();
        }
        else if(ae.getSource()==journals)
        {
            setVisible(false);
            new viewjournal();
        }
        else if(ae.getSource()==other)
        {
            setVisible(false);
            new viewmedia();
        }
        else if(ae.getSource()==patron)
        {
            setVisible(false);
            new viewpatron();
        }
        else
        {
            setVisible(false);
                 new viewcheckout();   
        }
    }
    public static void main(String [] args)
    {
        new home();
    }
    
}
