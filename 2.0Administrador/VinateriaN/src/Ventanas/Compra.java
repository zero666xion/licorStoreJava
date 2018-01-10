
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
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static Ventanas.Personal.conn;

public class Compra extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;   
    String datos[]=new String[11];
    int fila=0;
    Double tt=0.0;
    Double tproductos=0.0;
    String cap="";
    int c=0,d=0,e=0;
    int idmiguel=0,idmi=0;
    
    public Compra() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        Calendar Cal= Calendar.getInstance();
        String fec= Cal.get(Cal.DATE)+"/"+(Cal.get(Cal.MONTH)+1)+"/"+Cal.get(Cal.YEAR);
        fecha.setText(fec);
        idpersonalv.setText("1");
        usuariov.setText("ADMINISTRADOR");
        Finalizar.setEnabled(false);
        
        this.orden.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            rs=Conexion.compra(rs);//ejecuta la consulta
            ResultSetMetaData rsMd = rs.getMetaData();//volcamos los resultados de rs a rsmetadata            
            int cantidadColumnas = rsMd.getColumnCount();//La cantidad de columnas que tiene la consulta            
            
            for (int i = 1; i <= cantidadColumnas; i++) {//Establecer como cabezeras el nombre de las columnas
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
            rs.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }      
        

        this.proveedores.removeAllItems();//materiales
         
        this.producto.removeAllItems();//materiales
        try{
          conn=Conexion.Enlace(conn);
          
          String MAX="SELECT MAX(ID_COMPRA) AS ID_COMPRA FROM COMPRA";
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        d=Integer.parseInt(rs.getString("ID_COMPRA"));
                    }
                     
            idcompra.setText(Integer.toString(d+1));
           
          
            st=conn.createStatement();
            rs=st.executeQuery("select * from NOMBREPRODUCTO ORDER BY NOMBREPRODUCTO ASC");
          while (rs.next()){
              this.producto.addItem(rs.getString("NOMBREPRODUCTO"));
          }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);//fin de materiales
        }
        
        orden.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table =(JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            fila=orden.getSelectedRow();
            if (Mouse_evt.getClickCount() == 1) {
                producto.setSelectedItem(orden.getValueAt(fila, 0).toString());
                capacidad.setSelectedItem(null);
                cantidad.setText(orden.getValueAt(fila,1).toString());
                capacidad.setSelectedItem(cap);   
            }
        }
        });
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
        proveedores = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        producto = new javax.swing.JComboBox<>();
        capacidad = new javax.swing.JComboBox<>();
        cantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        usuariov = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idpersonalv = new javax.swing.JLabel();
        Agregar = new javax.swing.JButton();
        Quitar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orden = new javax.swing.JTable();
        Imprimir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        idcompra = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalproductos = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totalneto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Finalizar = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        idproveedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("Proveedor");

        proveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedoresActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Producto");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("Capacidad");

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad");

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel5.setText("Fecha");

        fecha.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        fecha.setText("Fecha");

        producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        capacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "245", "250", "355", "473", "500", "700", "750", "940", "1", "3" }));

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel7.setText("Usuario");

        usuariov.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        usuariov.setText("Usuario");

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel9.setText("ID Personal");

        idpersonalv.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        idpersonalv.setText("ID Personal");

        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add-item.png"))); // NOI18N
        Agregar.setText("Agregar a la Orden de Compra");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Quitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add-item.png"))); // NOI18N
        Quitar.setText("Quitar de la Orden de Compra");
        Quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarActionPerformed(evt);
            }
        });

        jLabel11.setText("ORDEN DE COMPRA");

        orden.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(orden);

        Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        Imprimir.setText("Imprimir");
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel12.setText("ID Compra");

        idcompra.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        idcompra.setText("ID Compra");

        jLabel14.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel14.setText("Total de Productos");

        totalproductos.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        totalproductos.setText("Total de Productos");

        jLabel16.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel16.setText("Total de Compra");

        jLabel17.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel17.setText("MXN");

        Finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addRCompra.png"))); // NOI18N
        Finalizar.setText("Finalizar Compra");
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });

        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atraz.PNG"))); // NOI18N
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel18.setText("ID.");

        idproveedor.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        idproveedor.setText("ID.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fecha)))))
                            .addComponent(jLabel7)
                            .addComponent(usuariov, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(idpersonalv)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Quitar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Agregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idproveedor)
                                .addGap(194, 194, 194)
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(idcompra))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(totalproductos)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(totalneto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel17))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(Finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel18)
                    .addComponent(idproveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usuariov)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idpersonalv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Agregar)
                        .addGap(11, 11, 11)
                        .addComponent(Quitar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(idcompra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(totalproductos)))
                            .addComponent(Imprimir))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(totalneto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Finalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(Regresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
    String np="",precio="",stock="";
        int stock1=0;

        cap=(String)capacidad.getSelectedItem();
        if(cantidad.getText().trim().length()==0 || producto.getSelectedItem()==null || capacidad.getSelectedItem()==null || proveedores.getSelectedItem()==null){
                JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");
        }else{
        try {
        conn=Conexion.Enlace(conn);
        st=conn.createStatement();
        rs=st.executeQuery("SELECT PRODUCTO.ID_PRODUCTO, \n"+ 
                           "NOMBREPRODUCTO.NOMBREPRODUCTO \n"+  
                           "FROM PRODUCTO \n"+ 
                           "INNER JOIN NOMBREPRODUCTO ON NOMBREPRODUCTO.ID_NOMBREPRODUCTO= PRODUCTO.ID_NOMBREPRODUCTO WHERE NOMBREPRODUCTO.NOMBREPRODUCTO='"+producto.getSelectedItem()+"'  \n"+
                           "AND PRODUCTO.CAPACIDAD='"+cap+"'");
        if(rs.next()){
        np=rs.getString("ID_PRODUCTO");
        //System.out.println(np); 
        rs=st.executeQuery("SELECT PRECIO_COMPRA FROM PRODUCTO WHERE ID_PRODUCTO ='"+np+"'");
        if(rs.next()){
            precio=rs.getString("PRECIO_COMPRA");
        }

        double c=Double.parseDouble(cantidad.getText());
        double pr=Double.parseDouble(precio);
        double total=c*pr;
        tproductos=tproductos+c;
        datos[0]=(String)producto.getSelectedItem();
        datos[1]=this.cantidad.getText();
        datos[2]=precio;
        datos[3]=Double.toString(total); 
        modelo.addRow(datos); 
        tt=tt+total;
        totalneto.setText(Double.toString(tt));
        totalproductos.setText(tproductos.toString());
        }else{
            JOptionPane.showMessageDialog(null, producto.getSelectedItem()+" de "+cap+" no está en existencia");
        }
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void QuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarActionPerformed
        
        String aux=orden.getValueAt(fila,3).toString();
        Double auxi=Double.parseDouble(aux);
        String aux2=orden.getValueAt(fila,1).toString();
        Double auxi2=Double.parseDouble(aux2);
        tproductos=tproductos-auxi2;
        tt=tt-auxi;
        totalneto.setText(Double.toString(tt));
        totalproductos.setText(Double.toString(tproductos));
        modelo.removeRow(fila);
    }//GEN-LAST:event_QuitarActionPerformed

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
    try {    
            MessageFormat headerFormat = new MessageFormat("VINATERIA S.A. DE C.V \n\nORDEN DE COMPRA\n Descripción:");
            MessageFormat footerFormat = new MessageFormat(jLabel14.getText());
            orden.print(JTable.PrintMode.NORMAL, headerFormat,footerFormat);
          
        }catch (Exception ex) {
          Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE,null,ex);    
                }
        Finalizar.setEnabled(true);
    }//GEN-LAST:event_ImprimirActionPerformed

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
    
        try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

String idp="",idnom="",stock="",canti="",stock2="";
    int stock1=0,stock3=0,actualizar=0,cantid=0,actualiza=0,actualiza1;
    

    try {
        String Variable="1";

        String sqlinsertar="INSERT INTO COMPRA values (?,?,?,?,?)";
        PreparedStatement psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, idcompra.getText());
        psta.setString(2, fecha.getText());
        psta.setString(3, totalneto.getText());
        psta.setString(4, idproveedor.getText());
        psta.setString(5, Variable);
        psta.execute();

        
        try{
         
            String MAX="SELECT MAX(ID_COMPRA) AS ID_COMPRA FROM COMPRA@DBLINKMIGUEL";
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        idmiguel = Integer.parseInt(rs.getString("ID_COMPRA"));
                    }
        }catch(SQLException e){
            
        }

        idmi=idmiguel+1;

        sqlinsertar="INSERT INTO COMPRA@DBLINKMIGUEL values (?,?,?,?,?)";
        psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, Integer.toString(idmi));
        psta.setString(2, fecha.getText());
        psta.setString(3, totalneto.getText());
        psta.setString(4, idproveedor.getText());
        psta.setString(5, Variable);
        psta.execute();
        
                sqlinsertar="INSERT INTO COMPRA@DBLINKMATA values (?,?,?,?,?)";
        psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, idcompra.getText());
        psta.setString(2, fecha.getText());
        psta.setString(3, totalneto.getText());
        psta.setString(4, idproveedor.getText());
        psta.setString(5, Variable);
        psta.execute();
        
                sqlinsertar="INSERT INTO COMPRA@DBLINKPROFE values (?,?,?,?,?)";
        psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, idcompra.getText());
        psta.setString(2, fecha.getText());
        psta.setString(3, totalneto.getText());
        psta.setString(4, idproveedor.getText());
        psta.setString(5, Variable);
        psta.execute();


        int filass=orden.getRowCount();
        
        int i=0;
        while(i<filass){

            String sqlinserta="SELECT ID_NOMBREPRODUCTO FROM NOMBREPRODUCTO WHERE NOMBREPRODUCTO = '" + orden.getValueAt(i,0).toString()+ "'";
            PreparedStatement pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idnom=rs.getString("ID_NOMBREPRODUCTO");
            }
            

            sqlinserta="SELECT ID_PRODUCTO FROM PRODUCTO WHERE ID_NOMBREPRODUCTO = '" + idnom + "' AND PRECIO_COMPRA ='"+ orden.getValueAt(i,2).toString()+ "'";
            PreparedStatement psto = conn.prepareStatement(sqlinserta);
            rs = psto.executeQuery();
            if(rs.next()){
                idp=rs.getString("ID_PRODUCTO");
            }
            
            sqlinserta="SELECT STOCK FROM INVENTARIO WHERE ID_PRODUCTO = '" + idp+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                stock=rs.getString("STOCK");
            }
            
            sqlinserta="SELECT STOCK FROM INVENTARIO@DBLINKMIGUEL WHERE ID_PRODUCTO = '" + idp+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                stock2=rs.getString("STOCK");
            }
            
            stock1=Integer.parseInt(stock);
            stock3=Integer.parseInt(stock2);
            canti=orden.getValueAt(i,1).toString();
            cantid=Integer.parseInt(canti);
            actualiza=stock1+cantid;
            actualiza1=stock3+cantid;
            
            PreparedStatement op=conn.prepareStatement("UPDATE INVENTARIO SET STOCK ='"+actualiza+"' WHERE ID_PRODUCTO='"+idp+"'");
            op.executeUpdate();

            op=conn.prepareStatement("UPDATE INVENTARIO@DBLINKMIGUEL SET STOCK ='"+actualiza1+"' WHERE ID_PRODUCTO='"+idp+"'");
            op.executeUpdate();
            
            op=conn.prepareStatement("UPDATE INVENTARIO@DBLINKMATA SET STOCK ='"+actualiza+"' WHERE ID_PRODUCTO='"+idp+"'");
            op.executeUpdate();
            
            op=conn.prepareStatement("UPDATE INVENTARIO@DBLINKPROFE SET STOCK ='"+actualiza+"' WHERE ID_PRODUCTO='"+idp+"'");
            op.executeUpdate();

            String sqlinsert="INSERT INTO DETALLE_COMPRA values (?,?,?,?,?,?)";
            psta=conn.prepareStatement(sqlinsert);
            psta.setString(1, idcompra.getText());
            psta.setString(2, idp);
            psta.setString(3, orden.getValueAt(i,1).toString());
            psta.setString(4, orden.getValueAt(i,2).toString());
            psta.setString(5, orden.getValueAt(i,3).toString());
            psta.setString(6, Variable);
            psta.execute();

            sqlinsert="INSERT INTO DETALLE_COMPRA@DBLINKMIGUEL values (?,?,?,?,?,?)";
            psta=conn.prepareStatement(sqlinsert);
            psta.setString(1, Integer.toString(idmi));
            psta.setString(2, idp);
            psta.setString(3, orden.getValueAt(i,1).toString());
            psta.setString(4, orden.getValueAt(i,2).toString());
            psta.setString(5, orden.getValueAt(i,3).toString());
            psta.setString(6, Variable);
            psta.execute();
            
            sqlinsert="INSERT INTO DETALLE_COMPRA@DBLINKMATA values (?,?,?,?,?,?)";
            psta=conn.prepareStatement(sqlinsert);
            psta.setString(1, idcompra.getText());
            psta.setString(2, idp);
            psta.setString(3, orden.getValueAt(i,1).toString());
            psta.setString(4, orden.getValueAt(i,2).toString());
            psta.setString(5, orden.getValueAt(i,3).toString());
            psta.setString(6, Variable);
            psta.execute();
            
            sqlinsert="INSERT INTO DETALLE_COMPRA@DBLINKPROFE values (?,?,?,?,?,?)";
            psta=conn.prepareStatement(sqlinsert);
            psta.setString(1, idcompra.getText());
            psta.setString(2, idp);
            psta.setString(3, orden.getValueAt(i,1).toString());
            psta.setString(4, orden.getValueAt(i,2).toString());
            psta.setString(5, orden.getValueAt(i,3).toString());
            psta.setString(6, Variable);
            psta.execute();

            i++;

        JOptionPane.showMessageDialog(null, "Compra realizada exitosamente");
        Finalizar.setEnabled(false);


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
    
    }//GEN-LAST:event_FinalizarActionPerformed

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

    private void proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedoresActionPerformed
    String idprov="";
         try{
            conn=Conexion.Enlace(conn);
            st=conn.createStatement();
            rs=st.executeQuery("select * from PROVEEDOR ORDER BY NOMBRE ASC");
            while (rs.next()){
                this.proveedores.addItem(rs.getString("NOMBRE"));
            }
        String buscapr="SELECT ID_PROVEEDOR FROM PROVEEDOR WHERE NOMBRE = '"+proveedores.getSelectedItem() +"'";
        PreparedStatement psto = conn.prepareStatement(buscapr);
        rs = psto.executeQuery();
        if(rs.next()){
             idprov=rs.getString("ID_PROVEEDOR");
             idproveedor.setText(idprov);
             
        }
        }catch(SQLException ex){ 
        }
    }//GEN-LAST:event_proveedoresActionPerformed

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
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Finalizar;
    private javax.swing.JButton Imprimir;
    private javax.swing.JButton Quitar;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JComboBox<String> capacidad;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel idcompra;
    private javax.swing.JLabel idpersonalv;
    private javax.swing.JLabel idproveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orden;
    private javax.swing.JComboBox<String> producto;
    private javax.swing.JComboBox<String> proveedores;
    private javax.swing.JTextField totalneto;
    private javax.swing.JLabel totalproductos;
    private javax.swing.JLabel usuariov;
    // End of variables declaration//GEN-END:variables
}
