// Display the results of queries against the bikes table in the bikedb database.
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class DisplayQueryResults extends JFrame 
{
   // JDBC driver, database URL, username and password
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DATABASE_URL = "jdbc:mysql://localhost:3310/bikedb";
   static final String USERNAME= "root";
   static final String PASSWORD= "root";
   
   // default query retrieves all data from bikes table
   static final String DEFAULT_QUERY = "SELECT * FROM bikes";
   
   private ResultSetTableModel tableModel;
   JTextArea queryArea;
   JLabel dbTxt; // "Enter Database Information"
   JComboBox driverSelector;
   JComboBox urlSelector;
   JLabel jdbcTxt;
   JLabel urlTxt;
   JTextField usernameField;
   JTextField passwordField;
   JLabel username;
   JLabel password;
   JLabel queryTxt; // "Enter a SQL Command"
   JLabel connectTxt; // "Connected to jdbc..//"
   JLabel sqlResultTxt; // "SQL Execution Result"
   JButton connect;
   JButton clearCommand;
   JButton executeCommand;
   JButton clearResult;
   JScrollPane scrollPane;
   JTable resultTable;
   
   // create ResultSetTableModel and GUI
   public DisplayQueryResults() 
   {   
      super( "Evan Glazer Two-Tier Client-Server" );
        
      // create ResultSetTableModel and display database table
      try 
      {
         // create TableModel for results of query SELECT * FROM bikes
        tableModel = new ResultSetTableModel( JDBC_DRIVER, DATABASE_URL,USERNAME, PASSWORD, DEFAULT_QUERY );

         // set up JTextArea in which user types queries
        queryArea = new JTextArea( DEFAULT_QUERY, 10, 5 );
        // queryArea.setWrapStyleWord( true );
        // queryArea.setLineWrap( true );
        dbTxt = new JLabel("Enter Database Information"); // "Enter Database Information"
        driverSelector = new JComboBox();
        urlSelector = new JComboBox();
        jdbcTxt= new JLabel("JDBC Driver");
        urlTxt = new JLabel("Database URL");
        usernameField = new JTextField("");
        passwordField = new JTextField("");
        username = new JLabel("Username");
        password = new JLabel("Password");
        queryTxt = new JLabel("Enter a SQL Command"); // "Enter a SQL Command"
        connectTxt = new JLabel("Connected to jdbc"); // "Connected to jdbc..//"
        sqlResultTxt = new JLabel("SQL Execution Result"); // "SQL Execution Result"
        clearCommand = new JButton("Clear Command");;
        executeCommand = new JButton("Execute Command");;
        clearResult = new JButton("Clear Result Window");;
        connect = new JButton( "Connect to Database" );

        scrollPane = new JScrollPane( queryArea,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
         
         // set up JButton for submitting queries

         // create Box to manage placement of queryArea and 
         // submitButton in GUI
         Box box = Box.createHorizontalBox();
         box.add(dbTxt);
         box.add(jdbcTxt);
         box.add(driverSelector);
         box.add(urlTxt);
         box.add(urlSelector);
         box.add(username);
         box.add(usernameField);
         box.add(password);
         box.add(passwordField);
         /*
         box.add(queryTxt);
         box.add( scrollPane );
         box.add( connectTxt );
         box.add( connect );
         box.add( clearCommand );
         box.add( executeCommand );
*/
         // create JTable delegate for tableModel 
         resultTable = new JTable( tableModel );
         
         // place GUI components on content pane
         add( box, BorderLayout.NORTH );
         Box box2= Box.createHorizontalBox();
         box2.add(sqlResultTxt);
         box2.add(new JScrollPane( resultTable ));
         box2.add(clearResult);
         add( box2, BorderLayout.SOUTH );

         // create event listener for submitButton
         executeCommand.addActionListener( 
         
            new ActionListener() 
            {
               // pass query to table model
               public void actionPerformed( ActionEvent event )
               {
                  // perform a new query
                  try 
                  {
                     tableModel.setQuery( queryArea.getText() );
                  } // end try
                  catch ( SQLException sqlException ) 
                  {
                     JOptionPane.showMessageDialog( null, 
                        sqlException.getMessage(), "Database error", 
                        JOptionPane.ERROR_MESSAGE );
                     
                     // try to recover from invalid user query 
                     // by executing default query
                     try 
                     {
                        tableModel.setQuery( DEFAULT_QUERY );
                        queryArea.setText( DEFAULT_QUERY );
                     } // end try
                     catch ( SQLException sqlException2 ) 
                     {
                        JOptionPane.showMessageDialog( null, 
                           sqlException2.getMessage(), "Database error", 
                           JOptionPane.ERROR_MESSAGE );
         
                        // ensure database connection is closed
                        tableModel.disconnectFromDatabase();
         
                        System.exit( 1 ); // terminate application
                     } // end inner catch                   
                  } // end outer catch
               } // end actionPerformed
            }  // end ActionListener inner class          
         ); // end call to addActionListener

         setSize( 800, 600 ); // set window size
         setVisible( true ); // display window  
      } // end try
      catch ( ClassNotFoundException classNotFound ) 
      {
         JOptionPane.showMessageDialog( null, 
            "MySQL driver not found", "Driver not found",
            JOptionPane.ERROR_MESSAGE );
         
         System.exit( 1 ); // terminate application
      } // end catch
      catch ( SQLException sqlException ) 
      {
         JOptionPane.showMessageDialog( null, sqlException.getMessage(), 
            "Database error", JOptionPane.ERROR_MESSAGE );
               
         // ensure database connection is closed
         tableModel.disconnectFromDatabase();
         
         System.exit( 1 );   // terminate application
      } // end catch
      
      // dispose of window when user quits application (this overrides
      // the default of HIDE_ON_CLOSE)
      setDefaultCloseOperation( DISPOSE_ON_CLOSE );
      
      // ensure database connection is closed when user quits application
      addWindowListener(
      
         new WindowAdapter() 
         {
            // disconnect from database and exit when window has closed
            public void windowClosed( WindowEvent event )
            {
               tableModel.disconnectFromDatabase();
               System.exit( 0 );
            } // end method windowClosed
         } // end WindowAdapter inner class
      ); // end call to addWindowListener
   } // end DisplayQueryResults constructor
   
   
   
      
   public void connectDB()
   {
       // check info put in 
       
       // get response
       
       // set label to connect or not
   
         // create TableModel for results of query SELECT * FROM bikes
        //tableModel = new ResultSetTableModel( JDBC_DRIVER, DATABASE_URL,USERNAME, PASSWORD, DEFAULT_QUERY );
   }
   
   
   
   // execute application
   public static void main( String args[] ) 
   {
      new DisplayQueryResults();     
   } // end main
} // end class DisplayQueryResults
