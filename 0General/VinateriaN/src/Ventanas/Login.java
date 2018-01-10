
package Ventanas;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Login extends javax.swing.JFrame {

    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    int d,e;String password1,status;
    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        password.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Password:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/unlock.png"))); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/shut-down.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jButton1)))
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            try{
            conn=Conexion.Enlace(conn);
            String MAX="SELECT ID_PERSONAL FROM USUARIOS WHERE USUARIO='"+ usuario.getText()+"'";
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        d=Integer.parseInt(rs.getString("ID_PERSONAL"));
                    }
            }catch(Exception ex){               
            }
            
            try{
            conn=Conexion.Enlace(conn);
            String MAX="SELECT ID_JORNADA_LABORAL FROM PERSONAL WHERE ID_PERSONAL="+ d;
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        e=Integer.parseInt(rs.getString("ID_JORNADA_LABORAL"));
                    }
            }catch(Exception ex){               
            }
            
                        try{
            conn=Conexion.Enlace(conn);
            String MAX="SELECT ID_STATUS FROM PERSONAL WHERE ID_PERSONAL="+ d;
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        status=rs.getString("ID_STATUS");
                    }
            }catch(Exception ex){               
            }
            
            if(e==4 || e==5){
                JOptionPane.showMessageDialog(null, "Acceso Denegado");
            }else{
                String estado="2";
                if(status.equals(estado)){
                 JOptionPane.showMessageDialog(null, "Acceso Denegado");   
                }else{            
            String sqlinserta="SELECT * FROM USUARIOS WHERE USUARIO = '"+usuario.getText()+"'";
            try{
            PreparedStatement pst;
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "EL USUARIO NO EXISTE");
                }else{
            try{
            conn=Conexion.Enlace(conn);
            String MAX="SELECT PASSWORD FROM USUARIOS WHERE USUARIO='"+ usuario.getText()+"'";
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        password1= rs.getString("PASSWORD");
                    }
            }catch(Exception ex){               
            } 
            if(password.getText().equals(password1)){
                dispose();
                new Principal().setVisible(true);
            }else{
             JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");   
            }
                
            }
            }catch(Exception ex){ }
            }}
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {

        new Thread(new SPLASHSCREEM()).start();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField password;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
