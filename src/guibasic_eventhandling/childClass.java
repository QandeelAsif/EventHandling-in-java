package guibasic_eventhandling;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class childClass {
    //creates items that will be used up in the GUI
    private JTextField entry1;
    private JTextField entry2;
    private JTextField entry3;
    private JPasswordField pass;
    
    public childClass()
    {   //sets up window
        JFrame f = new JFrame("Event handling example");
        //setting layout
        
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,200);
        f.setLocationRelativeTo(null); //pops up the window in centre
        
         //set GUI items to the window
         entry1 = new JTextField(10); //sets field entry limit to 10 characters
         f.add(entry1);
         entry2= new JTextField("Enter text here");
         f.add(entry2);
         entry3= new JTextField("uneditabele");
         entry3.setEditable(false);
         f.add(entry3);
         pass = new JPasswordField("mypassword");
         f.add(pass);
         
         Thehandler handler= new Thehandler();
         entry1.addActionListener(handler);
         entry2.addActionListener(handler);
         entry3.addActionListener(handler);
         pass.addActionListener(handler);
         
         f.setVisible(true);
    }

    void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class Thehandler implements ActionListener{     //this class does some usuable work on the textfields
            public void actionPerformed(ActionEvent event)   //fuction that triggers on event happening
            {
                String str=""; //default string
                if(event.getSource()==entry1) //if an event happens on entry 1, do this
                    str= String.format("entry 1 is : %s",event.getActionCommand()); // format it with 
                else if(event.getSource()==entry2) //if an event happens on entry 2, do this
                    str= String.format("entry 2 is : %s",event.getActionCommand());
                else if(event.getSource()==entry3) //if an event happens on entry 3, do this
                    str= String.format("entry 3 is : %s",event.getActionCommand());
                else if (event.getSource()==pass)
                    str=String.format("password field is %s ",event.getActionCommand() );
                JOptionPane.showMessageDialog(null, str);
            }
     }
}
