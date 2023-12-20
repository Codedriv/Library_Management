
package librarysystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class viewjournal extends JFrame implements ActionListener{
    
    JTable table;
    Choice issn;
    JButton Search,add,Print,Back;
    viewjournal()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl =new JLabel("Search by ISBN_Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        issn= new Choice();
        issn.setBounds(180,20,150,20);
        add(issn);
        table = new JTable();
      
        
        try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from journal");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                issn.add(rs.getString("ISSN_ID"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
          try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from journal");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                issn.add(rs.getString("ISBN_ID"));
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
        
        add= new JButton("Add_Journal");
        add.setBounds(220,70,150,20);
        add.addActionListener(this);
        add(add);
        
        Back = new JButton("Back");
        Back.setBounds(390,70,80,20);
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
            String query = "select * from journal where  issn = "+issn.getSelectedItem()+"";
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
        else if(ae.getSource()== add)
        {
           setVisible(false);
          new addjournal(issn.getSelectedItem());
            
        }
        else
        {
          setVisible(false);
          new home();
        }
        
    }
    public static void main(String [] args)
    {
        new viewjournal();
        
    }
}

