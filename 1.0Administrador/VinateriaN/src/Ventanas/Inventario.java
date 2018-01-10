
package Ventanas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Inventario extends javax.swing.JFrame {

       DefaultTableModel modelo = new DefaultTableModel();
    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    int fila=0;
    int c=0;
    String datos[]=new String[11];
    String cap="ID_PRODUCTO";
   
    
    void refrescar(String cap) throws SQLException{

        conn=Conexion.Enlace(conn);
        s=conn.createStatement();
        rs =s.executeQuery("SELECT PRODUCTO.ID_PRODUCTO, \n"+
                        "PRODUCTO.CAPACIDAD, \n"+
                        "MEDIDA.MEDIDA, \n"+
                        "NOMBREPRODUCTO.NOMBREPRODUCTO, \n"+
                        "TIPO.TIPO, \n"+
                        "MARCA.MARCA, \n"+
                        "CATEGORIA.CATEGORIA, \n"+
                        "PRODUCTO.PRECIO_VENTA, \n"+
                        "PRODUCTO.PRECIO_COMPRA, \n"+
                        "INVENTARIO.STOCK, \n"+
                        "STATUS.STATUS \n"+  
                    "FROM PRODUCTO \n"+
                    "INNER JOIN NOMBREPRODUCTO ON PRODUCTO.ID_NOMBREPRODUCTO = NOMBREPRODUCTO.ID_NOMBREPRODUCTO \n"+ 
                    "INNER JOIN MEDIDA ON PRODUCTO.ID_MEDIDA = MEDIDA.ID_MEDIDA \n"+
                    "INNER JOIN TIPO ON PRODUCTO.ID_TIPO = TIPO.ID_TIPO \n"+
                    "INNER JOIN MARCA ON PRODUCTO.ID_MARCA = MARCA.ID_MARCA \n"+
                    "INNER JOIN CATEGORIA ON PRODUCTO.ID_CATEGORIA = CATEGORIA.ID_CATEGORIA \n"+
                    "INNER JOIN INVENTARIO ON PRODUCTO.ID_PRODUCTO = INVENTARIO.ID_PRODUCTO \n"+
                    "INNER JOIN STATUS ON PRODUCTO.ID_STATUS = STATUS.ID_STATUS \n "+ 
                    "ORDER BY "+cap+" ASC");
        tablaproductos.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    public Inventario() {
        initComponents();
         setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        Calendar Cal= Calendar.getInstance();
        String fec= Cal.get(Cal.DATE)+"/"+(Cal.get(Cal.MONTH)+1)+"/"+Cal.get(Cal.YEAR);
        fecha.setText(fec); 
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        
        this.tablaproductos.setModel(modelo);

        String Msg ="SELECT PRODUCTO.ID_PRODUCTO, \n"+
                        "PRODUCTO.CAPACIDAD, \n"+
                        "MEDIDA.MEDIDA, \n"+
                        "NOMBREPRODUCTO.NOMBREPRODUCTO, \n"+
                        "TIPO.TIPO, \n"+
                        "MARCA.MARCA, \n"+
                        "CATEGORIA.CATEGORIA, \n"+
                        "PRODUCTO.PRECIO_VENTA, \n"+
                        "PRODUCTO.PRECIO_COMPRA, \n"+
                        "INVENTARIO.STOCK, \n"+
                        "STATUS.STATUS \n"+  
                    "FROM PRODUCTO \n"+
                    "INNER JOIN NOMBREPRODUCTO ON PRODUCTO.ID_NOMBREPRODUCTO = NOMBREPRODUCTO.ID_NOMBREPRODUCTO \n"+ 
                    "INNER JOIN MEDIDA ON PRODUCTO.ID_MEDIDA = MEDIDA.ID_MEDIDA \n"+
                    "INNER JOIN TIPO ON PRODUCTO.ID_TIPO = TIPO.ID_TIPO \n"+
                    "INNER JOIN MARCA ON PRODUCTO.ID_MARCA = MARCA.ID_MARCA \n"+
                    "INNER JOIN CATEGORIA ON PRODUCTO.ID_CATEGORIA = CATEGORIA.ID_CATEGORIA \n"+
                    "INNER JOIN INVENTARIO ON PRODUCTO.ID_PRODUCTO = INVENTARIO.ID_PRODUCTO \n"+
                    "INNER JOIN STATUS ON PRODUCTO.ID_STATUS = STATUS.ID_STATUS \n "+ 
                    "ORDER BY "+cap+" ASC";
         
        try {
            conn=Conexion.Enlace(conn);
            s=conn.createStatement();
            rs=s.executeQuery(Msg);//Codigo para extraer inner join de la BD
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

        jLabel1 = new javax.swing.JLabel();
        ordenar = new javax.swing.JComboBox<>();
        ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        ok2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        Mostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproductos = new javax.swing.JTable();
        Imprimir = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        inventarious = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idinventario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("Ordenar por:");

        ordenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_PRODUCTO", "CAPACIDAD", "MEDIDA", "NOMBREPRODUCTO", "TIPO", "MARCA", "CATEGORIA", "PRECIO_VENTA", "PRECIO_COMPRA", "STOCK" }));

        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Buscar");

        ok2.setText("Ok");
        ok2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("Fecha:");

        fecha.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        fecha.setText("Fecha:");

        Mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bar-chart.png"))); // NOI18N
        Mostrar.setText("Mostrar Todo");
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });

        tablaproductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaproductos);

        Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        Imprimir.setText("Imprimir");
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atraz.PNG"))); // NOI18N
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel5.setText("Usuario");

        inventarious.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        inventarious.setText("Usuario");

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel7.setText("ID:");

        idinventario.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        idinventario.setText("ID:");

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
                                .addComponent(ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ok)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ok2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inventarious, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idinventario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, Short.MAX_VALUE)
                        .addComponent(Mostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Imprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Regresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ok)
                            .addComponent(jLabel2)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ok2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fecha)
                            .addComponent(jLabel5)
                            .addComponent(inventarious)
                            .addComponent(jLabel7)
                            .addComponent(idinventario)))
                    .addComponent(Mostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Imprimir)
                    .addComponent(Regresar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
    try { 
        MessageFormat headerFormat = new MessageFormat("INVENTARIO VINATERIA");
        MessageFormat footerFormat = new MessageFormat(fecha.getText());
        tablaproductos.print(JTable.PrintMode.FIT_WIDTH, headerFormat,footerFormat);
        } catch (Exception ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE,null,ex);    
        }
    }//GEN-LAST:event_ImprimirActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
            cap=(String)ordenar.getSelectedItem();
        try {
            refrescar(cap);
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_okActionPerformed

    private void ok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok2ActionPerformed
    String sqlinserta="SELECT PRODUCTO.ID_PRODUCTO,\n" +
"                        PRODUCTO.CAPACIDAD,\n" +
"                        MEDIDA.MEDIDA,\n" +
"                        NOMBREPRODUCTO.NOMBREPRODUCTO, \n" +
"                        TIPO.TIPO,\n" +
"                        MARCA.MARCA,\n" +
"                        CATEGORIA.CATEGORIA,\n" +
"                        PRODUCTO.PRECIO_VENTA,\n" +
"                        PRODUCTO.PRECIO_COMPRA,\n" +
"                        INVENTARIO.STOCK,\n" +
"                        STATUS.STATUS\n" +
"                    FROM PRODUCTO \n" +
"                    INNER JOIN NOMBREPRODUCTO ON PRODUCTO.ID_NOMBREPRODUCTO = NOMBREPRODUCTO.ID_NOMBREPRODUCTO \n" +
"                    INNER JOIN MEDIDA ON PRODUCTO.ID_MEDIDA = MEDIDA.ID_MEDIDA \n" +
"                    INNER JOIN TIPO ON PRODUCTO.ID_TIPO = TIPO.ID_TIPO \n" +
"                    INNER JOIN MARCA ON PRODUCTO.ID_MARCA = MARCA.ID_MARCA \n" +
"                    INNER JOIN CATEGORIA ON PRODUCTO.ID_CATEGORIA = CATEGORIA.ID_CATEGORIA \n" +
"                    INNER JOIN INVENTARIO ON PRODUCTO.ID_PRODUCTO = INVENTARIO.ID_PRODUCTO\n" +
"                    INNER JOIN STATUS ON PRODUCTO.ID_STATUS = STATUS.ID_STATUS\n" +
"                    WHERE MEDIDA.MEDIDA='"+buscar.getText()+"' OR NOMBREPRODUCTO.NOMBREPRODUCTO='"+buscar.getText()+"' OR TIPO.TIPO='"+buscar.getText()+"' OR MARCA.MARCA='"+buscar.getText()+"' OR CATEGORIA.CATEGORIA='"+buscar.getText()+"' OR STATUS.STATUS='"+buscar.getText()+"'";
        if(buscar.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"No ha ingresado un criterio de búsqueda");
        }else{
        
        try{
            PreparedStatement pst;
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
            this.tablaproductos.setModel(modelo);
            try {
            for (int i = 0; i < tablaproductos.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            s=conn.createStatement();
            rs=s.executeQuery(sqlinserta);
            ResultSetMetaData rsMd = rs.getMetaData();//volcamos los resultados de rs a rsmetadata            
            int cantidadColumnas = rsMd.getColumnCount();//La cantidad de columnas que tiene la consulta            

            
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
            }else{
            JOptionPane.showMessageDialog(null, "La búsqueda no obtubo resultados pruebe otro criterio de busqueda");
            }
            } catch (Exception ex) {
            ex.printStackTrace();
        } 
        }
    }//GEN-LAST:event_ok2ActionPerformed

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed
        this.tablaproductos.setModel(modelo);
        for (int i = 0; i < tablaproductos.getRowCount(); i++) {
        modelo.removeRow(i);
            i-=1;
        }
       String capa="ID_PRODUCTO";
        try {
            refrescar(capa);
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprimir;
    private javax.swing.JButton Mostrar;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel idinventario;
    private javax.swing.JLabel inventarious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok;
    private javax.swing.JButton ok2;
    private javax.swing.JComboBox<String> ordenar;
    private javax.swing.JTable tablaproductos;
    // End of variables declaration//GEN-END:variables
}
