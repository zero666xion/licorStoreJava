
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

public class Categoria extends javax.swing.JFrame {

    int c=0;
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;  
    
    public Categoria() {
        initComponents();
        
        setLocationRelativeTo(null);
          setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        categoria.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        
         String MAX="SELECT MAX(ID_CATEGORIA) AS ID_CATEGORIA FROM CATEGORIA";
                try {
                    conn=Conexion.Enlace(conn);
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        c=Integer.parseInt(rs.getString("ID_CATEGORIA"))+1;
                       st.close();
                    }
                }catch(SQLException ex){ 
                }
                
            id.setText(Integer.toString(c));
            id.setEditable(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        categoria = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("Ingresa el nombre de la nueva categoria.");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Categoria.");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("ID.");

        Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add-item.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Aceptar)
                                .addGap(32, 32, 32)
                                .addComponent(Cancelar))
                            .addComponent(jLabel1))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar)
                    .addComponent(Cancelar))
                .addContainerGap(13, Short.MAX_VALUE))
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
            
            if(categoria.getText().trim().length()==0 ){
                JOptionPane.showMessageDialog(null,"Favor de ingresar el nombre de la nueva Categoría de producto");
            }else{
                String sqlinserta="SELECT * FROM CATEGORIA WHERE CATEGORIA = '"+categoria.getText()+"'";
                PreparedStatement pst;
                pst = conn.prepareStatement(sqlinserta);
                rs = pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "La Categoría de producto "+categoria.getText()+" ya existe en la base de datos. Corrobore sus datos.");
                }else{  
                    
                    String sqlinsertar="INSERT INTO CATEGORIA@DBLINKCHAVA VALUES (?,?)";
                    PreparedStatement psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.categoria.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO CATEGORIA@DBLINKBETO VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.categoria.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO CATEGORIA@DBLINKHUGO VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.categoria.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO CATEGORIA@DBLINKRICHI VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.categoria.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO CATEGORIA@DBLINKMATA VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.categoria.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO CATEGORIA@DBLINKPROFE VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.categoria.getText());
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO CATEGORIA VALUES (?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, this.id.getText());
                    psta.setString(2, this.categoria.getText());
                    psta.execute();

                    JOptionPane.showMessageDialog(null, "La Categoría "+categoria.getText()+" fue ingresada con éxito" );
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
                new Categoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField categoria;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
