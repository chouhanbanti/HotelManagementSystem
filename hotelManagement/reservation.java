/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class reservation extends javax.swing.JFrame {

    /**
     * Creates new form reservation
     */
    public reservation() {
        initComponents();
        Connect();
        autoID();
        Room_TypeL();
        Room_NoL();
        Bed_TypeL();
        Load_reservation();
    }
    
     Connection con ;
    PreparedStatement pst;
    DefaultTableModel d ;
    
    public void Connect()   //connection in database.
    {
        try 
         {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement1","root","");
             
         } catch (ClassNotFoundException ex) 
         {
            Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
         } catch(SQLException ex) 
         {
            Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
     public void autoID()  // room no auto increament.
    {
        try {
              Statement s = con.createStatement();
              ResultSet rs = s.executeQuery("select MAX(reid) from reservation");
              rs.next();
              rs.getString("MAX(reid)");
            
              if(rs.getString("MAX(reid)")==null)
                {
                   jLabel12.setText("RE001");
                }
                else
                {
                  long id = Long.parseLong(rs.getString("MAX(reid)").substring(2,rs.getString("MAX(reid)").length()));
                  id++;
                  jLabel12.setText("RE" + String.format("%03d",id));
                }
            } catch (SQLException ex)
                {
                  Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
     
    public void Room_TypeL()  // box m room type layenge.
     {
        try {
            pst=con.prepareStatement("select Distinct rtype from room");
            ResultSet rs = pst.executeQuery();
            txtrtype.removeAllItems();
            
            while(rs.next())
            {
             txtrtype.addItem(rs.getString("rtype"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
       public void Load_reservation()      // database se data ko table m rakhna
      {
        int c;
         try
           {
             pst = con.prepareStatement("select * from reservation");
             ResultSet rs = pst.executeQuery();
            
             ResultSetMetaData rsd = rs.getMetaData();
              c = rsd.getColumnCount();
               d= (DefaultTableModel)jTable1.getModel();
                d.setRowCount(0);
          
             while(rs.next())
              {
                Vector v2 = new Vector();
                for(int i=1;i<=c;i++)
                {  
                  v2.add(rs.getString("reid"));
                  v2.add(rs.getString("name"));
                  v2.add(rs.getString("mobile"));
                  v2.add(rs.getString("checkin"));
                  v2.add(rs.getString("checkout"));
                  v2.add(rs.getString("rtype"));
                  v2.add(rs.getString("roomno"));
                  v2.add(rs.getString("bedtype"));
                  v2.add(rs.getString("amount"));
                }
                d.addRow(v2);
              }
           }
             catch (SQLException ex) 
                {
                   Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
                }
      
       }
     
      public void Room_NoL()    // box m room no layenge.
     {
        try {
            pst=con.prepareStatement("select Distinct rid from room");
            ResultSet rs = pst.executeQuery();
            txtrno.removeAllItems();
            
            while(rs.next())
            {
             txtrno.addItem(rs.getString("rid"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      
        public void Bed_TypeL()  // box m bedtype layenge.
     {
        try {
            pst=con.prepareStatement("select Distinct btype from room");
            ResultSet rs = pst.executeQuery();
            txtbtype.removeAllItems();
            
            while(rs.next())
            {
             txtbtype.addItem(rs.getString("btype"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        txtrtype = new javax.swing.JComboBox<String>();
        txtrno = new javax.swing.JComboBox<String>();
        txtbtype = new javax.swing.JComboBox<String>();
        txtamount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtcheckin = new com.toedter.calendar.JDateChooser();
        txtcheckout = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Reservation");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Reservation No");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Address");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Mobile");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Check In");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Check Out");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Room Type");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Room No");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Bed Type");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Amount");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });

        txtmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobileActionPerformed(evt);
            }
        });

        txtamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RID", "Name", "Mobile", "CheckIn", "CheckOut", "RoomType", "RoomNO", "BedType", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));

        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtamount)
                    .addComponent(txtaddress)
                    .addComponent(txtname)
                    .addComponent(txtmobile)
                    .addComponent(txtrno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtrtype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtbtype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtcheckin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE))
                        .addGap(817, 817, 817))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6))
                            .addComponent(txtcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtrtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtrno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
       String reno = jLabel12.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();
        String mobile = txtmobile.getText();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-mm-dd");
        String StartDate = df1.format(txtcheckin.getDate());
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-mm-dd");
        String EndDate = df2.format(txtcheckout.getDate());
        String rtype = txtrtype.getSelectedItem().toString();
        String roomno = txtrno.getSelectedItem().toString();
        String bedtype = txtbtype.getSelectedItem().toString();
        String amount = txtamount.getText();     

        try {
              pst = con.prepareStatement("insert into reservation(reid,name,address,mobile,checkin,checkout,bedtype,roomno,rtype,amount) values(?,?,?,?,?,?,?,?,?,?)");
              pst.setString(1, reno);
              pst.setString(2, name);
              pst.setString(3, address);
              pst.setString(4, mobile);
              pst.setString(5, StartDate);
              pst.setString(6, EndDate);
              pst.setString(7, bedtype);
              pst.setString(8, roomno);
              pst.setString(9, rtype);
              pst.setString(10, amount);
             
              pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"Reservation added");
             
              txtname.setText("");
              txtaddress.setText("");
              txtmobile.setText("");
              txtrtype.setSelectedIndex(-1); // save and clear all box
              txtrno.setSelectedIndex(-1);
              txtbtype.setSelectedIndex(-1);
              txtamount.setText("");
            
             autoID();
             Load_reservation();  // such as room added then data load in table
            } catch (SQLException ex) 
              {
                Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
              }   
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamountActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      
                   // row click ...data on room box
      d= (DefaultTableModel)jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();
        
        jLabel12.setText(d.getValueAt(SelectIndex,0).toString());
        txtname.setText(d.getValueAt(SelectIndex,1).toString());
      //  txtaddress.setText(d.getValueAt(SelectIndex,2).toString());
        txtmobile.setText(d.getValueAt(SelectIndex,2).toString());
        txtcheckin.setDateFormatString(d.getValueAt(SelectIndex,3).toString());
        txtcheckout.setDateFormatString(d.getValueAt(SelectIndex,4).toString());
        txtrtype.setSelectedItem(d.getValueAt(SelectIndex,5).toString());
        txtrno.setSelectedItem(d.getValueAt(SelectIndex,6).toString());
        txtbtype.setSelectedItem(d.getValueAt(SelectIndex,7).toString());
        txtamount.setText(d.getValueAt(SelectIndex,8).toString());
        
         jButton1.setEnabled(false); // save button off  
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

                // Edit button
       String reno =jLabel12.getText();
        String name = txtname.getText();      
        String address = txtaddress.getText();
        String mobile = txtmobile.getText();
       SimpleDateFormat df1 = new SimpleDateFormat();
       String StartDate = df1.format(txtcheckin.getDate());
       SimpleDateFormat df2 = new SimpleDateFormat();
       String EndDate = df2.format(txtcheckout.getDate());
        String rtype = txtrtype.getSelectedItem().toString();
        String roomno = txtrno.getSelectedItem().toString();
        String bedtype = txtbtype.getSelectedItem().toString();
        String amount = txtamount.getText();
        
        try {
              pst = con.prepareStatement("Update reservation set name=?,address=?,mobile=?,checkin=?,checkout=?,bedtype=?,roomno=?,rtype=?,amount=? where reid=?");
              pst.setString(1,name);
             pst.setString(2,address);
               pst.setString(3,mobile);
               
              pst.setString(4,StartDate);
              pst.setString(5,EndDate);
              pst.setString(6,bedtype);
              pst.setString(7,roomno);
              pst.setString(8,rtype);
              pst.setString(9,amount);
              pst.setString(10,reno);
             
              pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"Reservation Edited");
             
              txtname.setText("");
             txtaddress.setText("");
              txtmobile.setText("");
             txtcheckin.setDateFormatString("");
             txtcheckout.setDateFormatString("");
             txtrno.setSelectedIndex(-1);
             txtrtype.setSelectedIndex(-1); // save and clear all box
             txtbtype.setSelectedIndex(-1);
             txtamount.setText("");
             
             autoID();
             Load_reservation();  // such as room added then data load in table
             jButton1.setEnabled(true);
                 
            } catch(SQLException ex) 
            {
              Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
            } 
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     
             txtname.setText("");
             txtaddress.setText("");
             txtmobile.setText("");
             txtrtype.setSelectedIndex(-1); // save and clear all box
             txtrno.setSelectedIndex(-1);
             txtbtype.setSelectedIndex(-1);
             txtamount.setText("");
              autoID();
            // Load_reservation();  // such as room added then data load in table
              jButton1.setEnabled(true);
               
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
      // delete button ..table row delete.
         String roomno = jLabel12.getText();
  
         try {
                pst = con.prepareStatement("Delete from reservation where reid=?");
                pst.setString(1,roomno);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"Reservation Deleted");
            
                 txtname.setText("");
                 txtmobile.setText("");
                 txtrtype.setSelectedIndex(-1); // save and clear all box
                 txtbtype.setSelectedIndex(-1);
                 txtamount.setText("");
                 autoID();
                 Load_reservation();  // such as room added then data load in table
                 jButton1.setEnabled(true);
                 
             } catch(SQLException ex) 
             {
               Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
             } 
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobileActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here: // Close button
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox<String> txtbtype;
    private com.toedter.calendar.JDateChooser txtcheckin;
    private com.toedter.calendar.JDateChooser txtcheckout;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JComboBox<String> txtrno;
    private javax.swing.JComboBox<String> txtrtype;
    // End of variables declaration//GEN-END:variables
}
