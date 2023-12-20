
package librarysystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class viewpatron  extends JFrame implements ActionListener{
    
    JTable table;
    Choice Patron_Id;
    JButton Search,Add,Print,Back;
    viewpatron()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl =new JLabel("Search by Patron_id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        Patron_Id = new Choice();
        Patron_Id.setBounds(180,20,150,20);
        add(Patron_Id);
        table = new JTable();
      
        
        try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from patron");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                Patron_Id.add(rs.getString("Patron_Id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
          try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from patron");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                Patron_Id.add(rs.getString("Patron_Id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp =new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        Search = new JButton("Search");
        Search.setBounds(20,70,80,20);
        Search.addActionListener(this);
        add(Search);
        
        Print = new JButton("Print ");
        Print .setBounds(120,70,80,20);
        Print .addActionListener(this);
        add(Print );
        
        Add = new JButton("Add");
        Add.setBounds(220,70,80,20);
        Add.addActionListener(this);
        add(Add);
        
        Back = new JButton("Back");
        Back.setBounds(320,70,80,20);
        Back.addActionListener(this);
        add(Back);
        
       setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Search)
        {
            String query = "select * from student where  Roll_no = "+Patron_Id.getSelectedItem()+"";
            try
            {
                conn c=new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()== Print)
        {
            try
            {
                table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== Add)
        {
           setVisible(false);
          new addpatron(Patron_Id.getSelectedItem());
            
        }
        else
        {
          setVisible(false);
          new home();
        }
        
    }
    public static void main(String [] args)
    {
        new viewpatron();
        
    }
}
