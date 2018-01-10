
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import static Ventanas.Inventario.conn;
import static Ventanas.Personal.conn;

public class Usersypasswords extends javax.swing.JFrame {

    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    int fila=0;
    DefaultTableModel modelo = new DefaultTableModel();
    String paterno1="",materno1="",nombre1="",idperso="",sucursal="",ecatepec="ECATEPEC",coacalco="COACALCO";
    
void refrescar() throws SQLException{

    conn=Conexion.Enlace(conn);
    s=conn.createStatement();
    rs =s.executeQuery("SELECT * FROM USUARIOS ORDER BY ID_PERSONAL");
    usuariospassword.setModel(DbUtils.resultSetToTableModel(rs));
}
    public Usersypasswords() {
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
        id.disable();
        this.usuariospassword.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            rs=Conexion.tablaUsuarios(rs);//ejecuta la consulta
            ResultSetMetaData rsMd = rs.getMetaData();//volcamos los resultados de rs a rsmetadata            
            int cantidadColumnas = rsMd.getColumnCount();//La cantidad de columnas que tiene la consulta            
            
            for (int i = 1; i <= cantidadColumnas; i++) {//Establecer como cabezeras el nombre de las columnas
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
            
            while (rs.next()) {//Creando las filas para el JTable
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        usuariospassword.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table =(JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            fila=usuariospassword.getSelectedRow();
            if (Mouse_evt.getClickCount() == 1) {
                id.setText(usuariospassword.getValueAt(fila, 0).toString());
                usuario.setText(usuariospassword.getValueAt(fila,1).toString());
                password.setText(usuariospassword.getValueAt(fila,2).toString());
                id.disable();
            }
        }
        }); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        Actualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuariospassword = new javax.swing.JTable();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("ID.");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuration.png"))); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        usuariospassword.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(usuariospassword);

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atraz.PNG"))); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Actualizar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Salir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
     Object [] opciones ={"SI","NO"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"Está a punto de salir de esta pantalla\n¿Desea continuar?","Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {
            dispose();
            new Principal().setVisible(true);
        }
    }//GEN-LAST:event_SalirActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
            
    try{
                         conn=Conexion.Enlace(conn);
                         String MAX="SELECT NOMBRE,PATERNO,MATERNO FROM PERSONAL WHERE ID_PERSONAL='" + id.getText() +"'";
                         Statement st=conn.createStatement();
                         ResultSet rs=st.executeQuery(MAX);
                         if(rs.next()){
                             paterno1=rs.getString("PATERNO");
                             materno1=rs.getString("MATERNO");
                             nombre1=rs.getString("NOMBRE");
                             sucursal=rs.getString("SUCURSAL");
                          }
                                }catch(SQLException e){
                                    
                                }


if(sucursal.equals(coacalco)){
try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

try{
                         
                         String MAX="SELECT ID_PERSONAL FROM PERSONAL@DBLINKCHAVA WHERE NOMBRE='" + nombre1 +"' AND PATERNO='" + paterno1 + "' AND MATERNO='" + materno1 + "'";
                         Statement st=conn.createStatement();
                         ResultSet rs=st.executeQuery(MAX);
                         if(rs.next()){
                             idperso=rs.getString("ID_PERSONAL");
                          }
                                }catch(SQLException e){
                                    
                                }

try{

            if(usuario.getText().trim().length()==0 || password.getText().trim().length()==0){
                JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");
            }else{                


                               PreparedStatement op=conn.prepareStatement("UPDATE USUARIOS@DBLINKCHAVA SET ID_PERSONAL ='"+idperso+"', USUARIO ='"+usuario.getText()+"', PASSWORD='"+password.getText()+"' WHERE ID_PERSONAL ='"+id.getText()+"'");
                               op.executeUpdate();
                               
                               op=conn.prepareStatement("UPDATE USUARIOS@DBLINKHUGO SET ID_PERSONAL ='"+idperso+"', USUARIO ='"+usuario.getText()+"', PASSWORD='"+password.getText()+"' WHERE ID_PERSONAL ='"+id.getText()+"'");
                               op.executeUpdate();
                               
                               op=conn.prepareStatement("UPDATE USUARIOS@DBLINKBETO SET ID_PERSONAL ='"+idperso+"', USUARIO ='"+usuario.getText()+"', PASSWORD='"+password.getText()+"' WHERE ID_PERSONAL ='"+id.getText()+"'");
                               op.executeUpdate();
                               
                op=conn.prepareStatement("UPDATE USUARIOS SET ID_PERSONAL ='"+id.getText()+"', USUARIO ='"+usuario.getText()+"', PASSWORD='"+password.getText()+"' WHERE ID_PERSONAL ='"+id.getText()+"'");
                op.executeUpdate();

                JOptionPane.showMessageDialog(null, "El Usuario "+usuario.getText()+" con ID '"+id.getText()+"' ha sido actualizado con éxito");
                refrescar();

      
                    }
            
            
           } catch (SQLException ex) {
           
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
 
}
else if(sucursal.equals(ecatepec)){
try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

                     try{
                         
                         String MAX="SELECT ID_PERSONAL FROM PERSONAL@DBLINKRICHI WHERE NOMBRE='" + nombre1 +"' AND PATERNO='" + paterno1 + "' AND MATERNO='" + materno1 + "'";
                         Statement st=conn.createStatement();
                         ResultSet rs=st.executeQuery(MAX);
                         if(rs.next()){
                             idperso=rs.getString("ID_PERSONAL");
                          }
                                }catch(SQLException e){
                                    
                                }
try{

            if(usuario.getText().trim().length()==0 || password.getText().trim().length()==0){
                JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");
            }else{                
                

                               PreparedStatement op=conn.prepareStatement("UPDATE USUARIOS@DBLINKRICHI SET ID_PERSONAL ='"+idperso+"', USUARIO ='"+usuario.getText()+"', PASSWORD='"+password.getText()+"' WHERE ID_PERSONAL ='"+id.getText()+"'");
                               op.executeUpdate();
                               
                               op=conn.prepareStatement("UPDATE USUARIOS@DBLINKMATA SET ID_PERSONAL ='"+idperso+"', USUARIO ='"+usuario.getText()+"', PASSWORD='"+password.getText()+"' WHERE ID_PERSONAL ='"+id.getText()+"'");
                               op.executeUpdate();
                               
                               op=conn.prepareStatement("UPDATE USUARIOS@DBLINKPROFE SET ID_PERSONAL ='"+idperso+"', USUARIO ='"+usuario.getText()+"', PASSWORD='"+password.getText()+"' WHERE ID_PERSONAL ='"+id.getText()+"'");
                               op.executeUpdate();
                   
                op=conn.prepareStatement("UPDATE USUARIOS SET ID_PERSONAL ='"+id.getText()+"', USUARIO ='"+usuario.getText()+"', PASSWORD='"+password.getText()+"' WHERE ID_PERSONAL ='"+id.getText()+"'");
                op.executeUpdate();

                JOptionPane.showMessageDialog(null, "El Usuario "+usuario.getText()+" con ID '"+id.getText()+"' ha sido actualizado con éxito");
                refrescar();

        
                    }
            
            
           } catch (SQLException ex) {
            
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
    
    }
    }//GEN-LAST:event_ActualizarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usersypasswords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Salir;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField usuario;
    private javax.swing.JTable usuariospassword;
    // End of variables declaration//GEN-END:variables
}
