
package Ventanas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NombreProducto extends javax.swing.JFrame {

    int c=0;
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null; 
    
    public NombreProducto() {
        initComponents();
        setLocationRelativeTo(null);
          setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
       
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        
         String MAX="SELECT MAX(ID_NOMBREPRODUCTO) AS ID_NOMBREPRODUCTO FROM NOMBREPRODUCTO";
                try {
                    conn=Conexion.Enlace(conn);
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        c=Integer.parseInt(rs.getString("ID_NOMBREPRODUCTO"))+1;
                    }
                }catch(SQLException ex){ 
                }
                
            id.setText(Integer.toString(c));
            id.disable();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("Ingresa el nombre del nuevo producto.");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del Producto");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("ID.");

        Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.PNG"))); // NOI18N
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.PNG"))); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(Aceptar)
                        .addGap(53, 53, 53)
                        .addComponent(Cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Aceptar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        dispose();
        new Productos().setVisible(true);
    }//GEN-LAST:event_CancelarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
    
try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

try {
            conn=Conexion.Enlace(conn);
            if(nombre.getText().trim().length()==0 ){
                JOptionPane.showMessageDialog(null,"Favor de ingresar el nombre del nuevo Producto");
            }else{
                String sqlinserta="SELECT * FROM NOMBREPRODUCTO WHERE NOMBREPRODUCTO = '"+nombre.getText()+"'";
                PreparedStatement pst;
                pst = conn.prepareStatement(sqlinserta);
                rs = pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "El producto "+nombre.getText()+" ya existe en la base de datos. Corrobore sus datos.");
                }else{  
                    String sqlinsertar="INSERT INTO NOMBREPRODUCTO VALUES (?,?)";
                    PreparedStatement psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.nombre.getText());
                    psta.execute();

                    sqlinsertar="INSERT INTO NOMBREPRODUCTO@DBLINKMIGUEL VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.nombre.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO NOMBREPRODUCTO@DBLINKBETO VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.nombre.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO NOMBREPRODUCTO@DBLINKHUGO VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.nombre.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO NOMBREPRODUCTO@DBLINKCHAVA VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.nombre.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO NOMBREPRODUCTO@DBLINKMATA VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.nombre.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO NOMBREPRODUCTO@DBLINKPROFE VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.nombre.getText());
                    psta.execute();

                    JOptionPane.showMessageDialog(null, "El producto "+nombre.getText()+" fue ingresado con éxito" );
                    dispose();
                    new Productos().setVisible(true);


                    
                    }
            
            }
           } catch (SQLException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
           }
                    
    conn.commit();
    conn.close();      
    } catch (SQLException ex) {
      ex.printStackTrace();
      } try {
           conn.rollback();
           System.out.println("Transaction failed. No records were written to the database.");
            }
             catch (SQLException se) {
             se.printStackTrace();
            }   
    }//GEN-LAST:event_AceptarActionPerformed

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
            java.util.logging.Logger.getLogger(NombreProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NombreProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NombreProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NombreProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NombreProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
