
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

public class Medida extends javax.swing.JFrame {

    int c=0;
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    
    public Medida() {
        initComponents();
        setLocationRelativeTo(null);
          setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);       
        medida.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        
         String MAX="SELECT MAX(ID_MEDIDA) AS ID_MEDIDA FROM MEDIDA";
                try {
                    conn=Conexion.Enlace(conn);
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        c=Integer.parseInt(rs.getString("ID_MEDIDA"))+1;
                    }
                }catch(SQLException ex){ 
                }
                
            id.setText(Integer.toString(c));
            id.disable();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        medida = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("Ingresa el nombre de la nueva medida.");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Medida");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(medida, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Aceptar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cancelar))
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(medida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
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
            if(medida.getText().trim().length()==0 ){
                JOptionPane.showMessageDialog(null,"Favor de ingresar el nombre de la nueva Medida");
            }else{
                String sqlinserta="SELECT * FROM MEDIDA WHERE MEDIDA = '"+medida.getText()+"'";
                PreparedStatement pst;
                pst = conn.prepareStatement(sqlinserta);
                rs = pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "La Medida "+medida.getText()+" ya existe en la base de datos. Corrobore sus datos.");
                }else{  
                    
                    String sqlinsertar="INSERT INTO MEDIDA@DBLINKCHAVA VALUES (?,?)";
                    PreparedStatement psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.medida.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO MEDIDA@DBLINKBETO VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.medida.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO MEDIDA@DBLINKHUGO VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.medida.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO MEDIDA@DBLINKRICHI VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.medida.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO MEDIDA@DBLINKMATA VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.medida.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO MEDIDA@DBLINKPROFE VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.medida.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO MEDIDA VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.medida.getText());
                    psta.execute();

                    JOptionPane.showMessageDialog(null, "La Medida "+medida.getText()+" fue ingresada con éxito" );
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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medida().setVisible(true);
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
    private javax.swing.JTextField medida;
    // End of variables declaration//GEN-END:variables
}
