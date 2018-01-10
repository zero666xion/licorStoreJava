
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Compras extends javax.swing.JFrame {

    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    int fila=0;
    public static String pruebaa="";
    String cap="ID_COMPRA";
    DefaultTableModel modelo = new DefaultTableModel();
    String fecha="",total="",proveedor="",idcompra="";
    
    void refrescar(String cap) throws SQLException{

    conn=Conexion.Enlace(conn);
    s=conn.createStatement();
    rs =s.executeQuery("SELECT ID_COMPRA,\n" +
    "FECHA,\n" +
    "TOTAL, \n" +
    "PROVEEDOR.NOMBRE, \n" +
    "STATUS.STATUS \n" +
    "FROM COMPRA\n" +
    "INNER JOIN PROVEEDOR ON COMPRA.ID_PROVEEDOR = PROVEEDOR.ID_PROVEEDOR\n" +
    "INNER JOIN STATUS ON COMPRA.ID_STATUS = STATUS.ID_STATUS \n "+ 
    "ORDER BY "+cap+" ASC");
    datoscompras.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    public Compras() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        IDCOMPRAS.disable();
        this.datoscompras.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            rs=Conexion.tablaCompras(rs);//ejecuta la consulta
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
        
        datoscompras.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table =(JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            fila=datoscompras.getSelectedRow();
            if (Mouse_evt.getClickCount() == 1) {
                IDCOMPRAS.setText(datoscompras.getValueAt(fila, 0).toString());
                fecha= datoscompras.getValueAt(fila, 1).toString();
                total= datoscompras.getValueAt(fila, 2).toString();
                proveedor= datoscompras.getValueAt(fila, 3).toString();
            }
        }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ordenar = new javax.swing.JComboBox<>();
        ok = new javax.swing.JButton();
        MostrarDetalle = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        IDCOMPRAS = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        datoscompras = new javax.swing.JTable();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("Ordenar por: ");

        ordenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_COMPRA", "FECHA", "TOTAL", "NOMBRE" }));

        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        MostrarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        MostrarDetalle.setText("Mostrar Detalle");
        MostrarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarDetalleActionPerformed(evt);
            }
        });

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        datoscompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(datoscompras);

        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atraz.PNG"))); // NOI18N
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IDCOMPRAS, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ok)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MostrarDetalle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Eliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Regresar)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ok))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDCOMPRAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MostrarDetalle)
                    .addComponent(Eliminar)
                    .addComponent(Regresar))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        cap=(String)ordenar.getSelectedItem();
        try {
            refrescar(cap);
        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_okActionPerformed

    private void MostrarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarDetalleActionPerformed
     new DetalleCompra().setVisible(true);
    }//GEN-LAST:event_MostrarDetalleActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
    try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

        Object [] opciones ={"SI","NO"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro de Eliminar la Compra No. "+IDCOMPRAS.getText()+"?", "Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION){
        
            try{
                conn=Conexion.Enlace(conn);
                String MAX="SELECT ID_COMPRA FROM COMPRA@DBLINKCHAVA WHERE FECHA='" + fecha + "' AND TOTAL='"+ total + "' AND PROVEEDOR='"+proveedor+"'";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(MAX);
                if(rs.next()){
                    
                    idcompra=rs.getString("ID_COMPRA");
                    
                    PreparedStatement op=conn.prepareStatement("UPDATE COMPRA@DBLINKCHAVA SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                    op.executeUpdate();
                    
                    op=conn.prepareStatement("UPDATE COMPRA@DBLINKBETO SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                    op.executeUpdate();
                    
                    op=conn.prepareStatement("UPDATE COMPRA@DBLINKHUGO SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                    op.executeUpdate();
                    
                    op=conn.prepareStatement("UPDATE DETALLE_COMPRA@DBLINKCHAVA SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                    op.executeUpdate();
                    
                    op=conn.prepareStatement("UPDATE DETALLE_COMPRA@DBLINKBETO SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                    op.executeUpdate();
                    
                    op=conn.prepareStatement("UPDATE DETALLE_COMPRA@DBLINKHUGO SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                    op.executeUpdate();
                    
                    op=conn.prepareStatement("UPDATE COMPRA SET ID_STATUS ='2' WHERE ID_COMPRA ='"+IDCOMPRAS.getText()+"'");
                    op.executeUpdate();
                    
                    
                    op=conn.prepareStatement("UPDATE DETALLE_COMPRA SET ID_STATUS ='2' WHERE ID_COMPRA ='"+IDCOMPRAS.getText()+"'");
                    op.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Registro ELIMINADO Satisfactoriamente");
                    dispose();
                    new Compras().setVisible(true);
                    
                    
                    
                    
                    
                }else if(!rs.next()){
                    
                    
                    try{
                        conn=Conexion.Enlace(conn);
                        MAX="SELECT ID_COMPRA FROM COMPRA@DBLINKRICHI WHERE FECHA='" + fecha + "' AND TOTAL='"+ total + "' AND PROVEEDOR='"+proveedor+"'";
                        st=conn.createStatement();
                        rs=st.executeQuery(MAX);
                        if(rs.next()){
                            
                            idcompra=rs.getString("ID_COMPRA");
                            
                            PreparedStatement op=conn.prepareStatement("UPDATE COMPRA@DBLINKRICHI SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                            op.executeUpdate();
                            
                            op=conn.prepareStatement("UPDATE COMPRA@DBLINKMATA SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                            op.executeUpdate();
                            
                            op=conn.prepareStatement("UPDATE COMPRA@DBLINKPROFE SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                            op.executeUpdate();
                            
                            op=conn.prepareStatement("UPDATE DETALLE_COMPRA@DBLINKRICHI SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                            op.executeUpdate();
                            
                            op=conn.prepareStatement("UPDATE DETALLE_COMPRA@DBLINKMATA SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                            op.executeUpdate();
                            
                            op=conn.prepareStatement("UPDATE DETALLE_COMPRA@DBLINKPROFE SET ID_STATUS ='2' WHERE ID_COMPRA ='"+ idcompra +"'");
                            op.executeUpdate();
                            
                            op=conn.prepareStatement("UPDATE COMPRA SET ID_STATUS ='2' WHERE ID_COMPRA ='"+IDCOMPRAS.getText()+"'");
                            op.executeUpdate();
                            
                            
                            op=conn.prepareStatement("UPDATE DETALLE_COMPRA SET ID_STATUS ='2' WHERE ID_COMPRA ='"+IDCOMPRAS.getText()+"'");
                            op.executeUpdate();
                            
                            
                        }
                    }catch(SQLException e){}
                    
                }
            }catch(SQLException e){}
            
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
    }//GEN-LAST:event_EliminarActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        Object [] opciones ={"SI","NO"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"Está a punto de salir de esta pantalla\n¿Desea continuar?","Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {
            dispose();
            new Principal().setVisible(true);
        }
    }//GEN-LAST:event_RegresarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    public static javax.swing.JTextField IDCOMPRAS;
    private javax.swing.JButton MostrarDetalle;
    private javax.swing.JButton Regresar;
    private javax.swing.JTable datoscompras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok;
    private javax.swing.JComboBox<String> ordenar;
    // End of variables declaration//GEN-END:variables
}
