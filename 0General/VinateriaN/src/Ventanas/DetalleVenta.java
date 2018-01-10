
package Ventanas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class DetalleVenta extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    int fila=0;
    
    public DetalleVenta() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        this.detallev.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);
            s=conn.createStatement();
            String detalleventas="SELECT ID_VENTA,\n" +
            "ID_PRODUCTO,\n" +
            "CANTIDAD,\n" +
            "PRECIO_UNITARIO,\n" +
            "PRECIO_TOTAL, \n" +
            "STATUS.STATUS \n" +
            "FROM DETALLE_VENTA \n" +
            "INNER JOIN STATUS ON DETALLE_VENTA.ID_STATUS = STATUS.ID_STATUS \n "+ 
            "WHERE ID_VENTA= '"+Ventas.IDVENTA.getText()+"'";
            
            
            rs=s.executeQuery(detalleventas);//Codigo para extraer inner join de la BD
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        detallev = new javax.swing.JTable();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        detallev.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(detallev);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(Regresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Regresar)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
    dispose();
    }//GEN-LAST:event_RegresarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Regresar;
    private javax.swing.JTable detallev;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
