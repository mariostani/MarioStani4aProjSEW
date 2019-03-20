
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mariostani
 */
public class MainWindow extends javax.swing.JFrame {

    private Connection con = null;
    DatabaseMetaData md = null;
    String primary_key = null;
     int cmxindex=0;
    int pkPosition = 0;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not load mysql driver!");
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading MySQL Driver");
            // this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            System.exit(1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        lblServer = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntries = new javax.swing.JTable();
        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblDatabase = new javax.swing.JLabel();
        txtDatabase = new javax.swing.JTextField();
        cbxTables = new javax.swing.JComboBox<>();
        DelBtn = new javax.swing.JButton();
        InsertBtn = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblServer.setText("Server:");

        lblPort.setText("Port: ");

        txtServer.setText("localhost");

        txtPort.setText("3306");
        txtPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPortActionPerformed(evt);
            }
        });

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnDisconnect.setText("Disconnect");
        btnDisconnect.setEnabled(false);
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        tblEntries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEntries.setCellSelectionEnabled(true);
        tblEntries.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblEntriesPropertyChange(evt);
            }
        });
        tblEntries.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblEntriesVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblEntries);

        lblUser.setText("User:");

        lblPassword.setText("Password: ");

        txtUser.setText("root");

        lblDatabase.setText("Database: ");

        txtDatabase.setText("world");

        cbxTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTablesActionPerformed(evt);
            }
        });

        DelBtn.setText("Delete");
        DelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBtnActionPerformed(evt);
            }
        });

        InsertBtn.setText("Insert");
        InsertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DelBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblServer)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPort)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPort))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword)
                            .addComponent(lblUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(txtPassword))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblDatabase)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxTables, 0, 130, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDisconnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(InsertBtn)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServer)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatabase)
                    .addComponent(txtDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisconnect)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DelBtn)
                    .addComponent(InsertBtn))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPortActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        String user = txtUser.getText();
        String password = txtPassword.getText();
        String database = txtDatabase.getText();
        String server = txtServer.getText();

        int port = 0;
        try {
            port = Integer.parseInt(txtPort.getText());
        } catch (NumberFormatException ex) {
            System.out.println("Please insert a correct port number!");
            javax.swing.JOptionPane.showMessageDialog(this, "Please insert a correct port number");
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, user, password);
            txtUser.setEnabled(false);
            txtPassword.setEnabled(false);
            txtDatabase.setEnabled(false);
            txtServer.setEnabled(false);
            txtPort.setEnabled(false);
            btnConnect.setEnabled(false);
            btnDisconnect.setEnabled(true);
            cbxTables.setEnabled(true);
            
            md = con.getMetaData();
            ResultSet res_prim = md.getPrimaryKeys(null, null, "city");
            res_prim.next();
            primary_key = res_prim.getString(4);
            pkPosition =res_prim.getInt("KEY_SEQ")-1;
            System.out.println("pkpos"+pkPosition);
            System.out.println("primary key: " + res_prim.getString(4));

        } catch (SQLException ex) {
            System.out.println("Could not connect to world database!");
            javax.swing.JOptionPane.showMessageDialog(this, "Could not connect to Server");
        }

        /* OPTIONAL LIST TABLES */
        try {
            md = con.getMetaData();

            ResultSet rs = md.getTables(null, null, null, null);
            while (rs.next()) {
                cbxTables.addItem(rs.getString(3));
                //System.out.println(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Could not retrieve database meta-data");
            javax.swing.JOptionPane.showMessageDialog(this, "Could not retrieve database meta-data");
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed

        try {
            con.close();

            txtUser.setEnabled(true);
            txtPassword.setEnabled(true);
            txtDatabase.setEnabled(true);
            txtServer.setEnabled(true);
            txtPort.setEnabled(true);

            btnConnect.setEnabled(true);
            btnDisconnect.setEnabled(false);

            cbxTables.setModel(new DefaultComboBoxModel<String>());
            cbxTables.setEnabled(false);

            tblEntries.setModel(new DefaultTableModel());
            tblEntries.setEnabled(false);
        } catch (SQLException ex) {
            System.out.println("Error closing database connection");
            javax.swing.JOptionPane.showMessageDialog(this, "Error closing database connection");
        }


    }//GEN-LAST:event_btnDisconnectActionPerformed

    private void tableModelChanged(TableModelEvent e) {
        System.out.println("table changed");
        int row = e.getFirstRow();
        String columnName = 
         tblEntries.getModel().getColumnName(e.getColumn());      
        int id = 
                Integer.parseInt(tblEntries.getModel().getValueAt(row, pkPosition).toString());
          System.out.println(columnName +" " +  id);

        String entry_changed = 
                tblEntries.getModel().getValueAt(row, e.getColumn()).toString();  
        try {
            PreparedStatement update =
                    con.prepareStatement(
                            "UPDATE "+cbxTables.getSelectedItem().toString()+" SET "+ columnName + "= ? WHERE " + primary_key + " = ?");
            update.setString(1, entry_changed);
            update.setInt(2, id);
            System.out.println(update);
            System.out.println(update.executeUpdate() + " rows changed");
            
        } catch (SQLException ex) {
            System.out.println("Error updating table");
            javax.swing.JOptionPane.showMessageDialog(this, "Error updating table");
        }
          
          
          
    }
    private void cbxTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTablesActionPerformed
        int num_columns = 0;

        try {
           
            ResultSet result = md.getColumns(
                    null, null, cbxTables.getSelectedItem().toString(), null);

       
           

            while (result.next()) {
                String columnName = result.getString(4);

                tableModel.addColumn(columnName);
                num_columns++;
          
            }
            tblEntries.setModel(tableModel);

        } catch (SQLException ex) {
            System.out.println("Error building column structure for table " + cbxTables.getSelectedItem().toString());
            javax.swing.JOptionPane.showMessageDialog(this, "Error building column structure for table " + cbxTables.getSelectedItem().toString());
        }

        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM " + cbxTables.getSelectedItem().toString());

            while (res.next()) {
                Object[] row = new Object[num_columns];
                for (int i = 1; i <= num_columns; i++) {
                    row[i - 1] = res.getObject(i);
                }
                ((DefaultTableModel) tblEntries.getModel()).insertRow(res.getRow() - 1, row);
            }

            tblEntries.getModel().addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    System.out.println("table changed");
                    tableModelChanged(e);
                }
            });

        } catch (SQLException ex) {
            System.out.println("Error building result table from database");
            javax.swing.JOptionPane.showMessageDialog(this, "Error building result table from database");
        }


    }//GEN-LAST:event_cbxTablesActionPerformed

    private void tblEntriesVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblEntriesVetoableChange
        // System.out.println("row edited");
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEntriesVetoableChange

    private void tblEntriesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblEntriesPropertyChange
        // TODO add your handling code here:
       // System.out.println("row edited");
    }//GEN-LAST:event_tblEntriesPropertyChange

    private void DelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBtnActionPerformed
        // TODO add your handling code here:
     int row= tblEntries.getSelectedRow();
  int id =  Integer.parseInt(tblEntries.getModel().getValueAt(row, pkPosition).toString());
        try{      
            PreparedStatement delete=con.prepareStatement("DELETE from city WHERE id = ?;");
             delete.setInt(1, id);
             delete.executeUpdate();
            tableModel.removeRow(row);
             System.out.println(delete);
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_DelBtnActionPerformed

    private void InsertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertBtnActionPerformed
        try { 
            int num_cols=0;
            int lastRow=tblEntries.getModel().getRowCount()-1;
            ResultSet rs =md.getColumns(null, null, cbxTables.getItemAt(cmxindex).toString(), null);
            String sql="INSERT INTO "+cbxTables.getItemAt(cmxindex)+"(";
            rs.next();
            while(rs.next()){
                sql+=rs.getString(4)+",";
                num_cols++;
            }
            sql = sql.substring(0, sql.length() - 1);
            sql+=") VALUES (";
         
            for(int i=0;i<num_cols;i++){
                sql+="?,";

            }
            sql = sql.substring(0, sql.length() - 1);
            sql+=");";
            System.out.println(sql);
            PreparedStatement prepInsert=con.prepareStatement(sql);
            for(int i=0;i<num_cols;i++){
                prepInsert.setString(i+1, ""+tblEntries.getModel().getValueAt(lastRow, i+1));
            }
            
            prepInsert.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_InsertBtnActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton InsertBtn;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JComboBox<String> cbxTables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblServer;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tblEntries;
    private javax.swing.JTextField txtDatabase;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
       DefaultTableModel tableModel = new DefaultTableModel();
}
