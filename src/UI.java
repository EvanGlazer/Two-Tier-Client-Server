
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;




/**
 *
 * @author Evan Glazer
 */
public class UI extends javax.swing.JFrame {
   // JDBC driver, database URL, username and password
   static String JDBC_DRIVER;
   String DATABASE_URL = "jdbc:mysql://localhost:3310/project2";
   static String USERNAME;
   static String PASSWORD;
   String DEFAULT_QUERY;
   static final String EMPTY = "";
   
   private ResultSetTableModel tableModel;

    public UI() {
        
        super( "Evan Glazer Two-Tier Client-Server" );
        
      try 
      {
        initComponents();
        queryArea.setText(DEFAULT_QUERY);
        executeBtn.setEnabled(false);
        clearBtn.setEnabled(false);

      } 
     catch(Exception e)
     {
     }
      
      // dispose of window when user quits application (this overrides
      // the default of HIDE_ON_CLOSE)
     // setDefaultCloseOperation( DISPOSE_ON_CLOSE );
      
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
    // end DisplayQueryResults constructor
   
      }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        driverSelector = new javax.swing.JComboBox();
        dbSelector = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        queryArea = new javax.swing.JTextArea();
        connectLabel = new javax.swing.JLabel();
        connectBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        executeBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        clearWindowBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("Enter Database Information");

        jLabel2.setText("JDBC Driver");

        jLabel3.setText("Database URL");

        driverSelector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "com.mysql.jdbc.Driver", "oracle.jdbc.driver.OracleDriver", " COM.ibm.db2.jdbc.net.DB2Driver", " com.jdbc.odbc.JdbcOdbcDriver" }));
        driverSelector.setName("driverSelector"); // NOI18N

        dbSelector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "jdbc:mysql://localhost:3310/project2" }));

        jLabel4.setText("Username");

        jLabel5.setText("Password");

        jLabel6.setText("Enter a SQL Command");
        jLabel6.setToolTipText("");

        queryArea.setColumns(20);
        queryArea.setRows(5);
        jScrollPane1.setViewportView(queryArea);

        connectLabel.setForeground(new java.awt.Color(228, 78, 78));
        connectLabel.setText("No Connection Now");

        connectBtn.setBackground(new java.awt.Color(78, 153, 228));
        connectBtn.setText("Connect to Database");
        connectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear Command");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        executeBtn.setBackground(new java.awt.Color(144, 238, 144));
        executeBtn.setText("Execute SQL Command");
        executeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("SQL Execution Result");

        jScrollPane2.setViewportView(resultTable);

        clearWindowBtn.setBackground(new java.awt.Color(238, 238, 144));
        clearWindowBtn.setText("Clear Result Window");
        clearWindowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearWindowBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(186, 186, 186)
                                        .addComponent(connectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(connectLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(usernameField)
                                                .addComponent(dbSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(passwordField)
                                                .addComponent(driverSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(executeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(clearWindowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(connectBtn)
                            .addComponent(clearBtn)
                            .addComponent(executeBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(driverSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(dbSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearWindowBtn)
                .addContainerGap())
        );

        connectLabel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtnActionPerformed
       try {
           
           if(!(usernameField.equals(EMPTY) && passwordField.equals(EMPTY)))
           
               JDBC_DRIVER = driverSelector.getSelectedItem().toString();
               DATABASE_URL = dbSelector.getSelectedItem().toString();
               USERNAME = usernameField.getText();
               PASSWORD = passwordField.getText();
                // check info put in
                tableModel = new ResultSetTableModel( JDBC_DRIVER, DATABASE_URL,USERNAME, PASSWORD);
           

            // get response
           
           // set label to connect or not
           
           // create TableModel for results of query SELECT * FROM bikes
           //tableModel = new ResultSetTableModel( JDBC_DRIVER, DATABASE_URL,USERNAME, PASSWORD, DEFAULT_QUERY );
       }
     catch (ClassNotFoundException classNotFound ) 
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
           connectBtn.setEnabled(false);
           executeBtn.setEnabled(true);
           clearBtn.setEnabled(true);
           connectLabel.setText("Connected to " + driverSelector.getSelectedItem().toString());
    }//GEN-LAST:event_connectBtnActionPerformed

    private void clearWindowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearWindowBtnActionPerformed
           tableModel.clearTable();
           resultTable.setModel(tableModel);
    }//GEN-LAST:event_clearWindowBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
           queryArea.setText(EMPTY);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void executeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeBtnActionPerformed
              try 
                  {
                        tableModel.setQuery( queryArea.getText() );
                        resultTable.setModel(tableModel);
                        //resultTable = new javax.swing.JTable(tableModel);
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
                  } 
    }//GEN-LAST:event_executeBtnActionPerformed

   public void getDatabaseURL()
   {
       // need to set string list to items
       //dbURL = new String[];
   }
   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clearWindowBtn;
    private javax.swing.JButton connectBtn;
    private javax.swing.JLabel connectLabel;
    private javax.swing.JComboBox dbSelector;
    private javax.swing.JComboBox driverSelector;
    private javax.swing.JButton executeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextArea queryArea;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
