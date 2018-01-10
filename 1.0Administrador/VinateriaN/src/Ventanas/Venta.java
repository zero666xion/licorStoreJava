
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

public class Venta extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;   
    String datos[]=new String[11];
    int fila=0;
    Double tt=0.0;
    Double tproductos=0.0;
    String cap="",idnomp="",idprod="";
    int c=0,d=0,e=0,stok=0,idp=0,idmiguel=0,idmi=0;
    public Venta() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        Calendar Cal= Calendar.getInstance();
        String fec= Cal.get(Cal.DATE)+"/"+(Cal.get(Cal.MONTH)+1)+"/"+Cal.get(Cal.YEAR);
        fecha.setText(fec);
     
        idcliente.setText("1");
        usuariov.disable();
        idpersonalv.disable();
        Finalizar.setEnabled(false);
        stocks.setEditable(false);
        preciou.setEditable(false);
        this.ticket.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            rs=Conexion.ticket(rs);//ejecuta la consulta
            ResultSetMetaData rsMd = rs.getMetaData();//volcamos los resultados de rs a rsmetadata            
            int cantidadColumnas = rsMd.getColumnCount();//La cantidad de columnas que tiene la consulta            
            
            for (int i = 1; i <= cantidadColumnas; i++) {//Establecer como cabezeras el nombre de las columnas
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
            
            rs.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }      
        
        
        
        this.producto.removeAllItems();//materiales
        try{
          conn=Conexion.Enlace(conn);
          
          String MAX="SELECT MAX(ID_VENTA) AS ID_VENTA FROM VENTA";
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        d=Integer.parseInt(rs.getString("ID_VENTA"));
                    }
     
            
            idventa.setText(Integer.toString(d+1));
           
            st=conn.createStatement();
            rs=st.executeQuery("select * from NOMBREPRODUCTO ORDER BY NOMBREPRODUCTO ASC");
          while (rs.next()){
              this.producto.addItem(rs.getString("NOMBREPRODUCTO"));
          }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);//fin de materiales
        }
        
        ticket.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table =(JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            fila=ticket.getSelectedRow();
            if (Mouse_evt.getClickCount() == 1) {
                producto.setSelectedItem(ticket.getValueAt(fila, 0).toString());
                capacidad.setSelectedItem(null);
                cantidad.setText(ticket.getValueAt(fila,1).toString());
                capacidad.setSelectedItem(cap);
            }
        }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        stocks = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        preciou = new javax.swing.JTextField();
        capacidad = new javax.swing.JComboBox<>();
        producto = new javax.swing.JComboBox<>();
        idcliente = new javax.swing.JTextField();
        Agregar = new javax.swing.JButton();
        Quitar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        usuariov = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idpersonalv = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ticket = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        idventa = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totalproductos = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Cobrar = new javax.swing.JButton();
        totalneto = new javax.swing.JTextField();
        Finalizar = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("ID Cliente");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Producto");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("Capacidad");

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel4.setText("Precio Unitario");

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel5.setText("Stock");

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel6.setText("Cantidad");

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel7.setText("Fecha");

        fecha.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        fecha.setText("Fecha");

        capacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "250", "355", "473", "500", "700", "750", "940", "950", "1200", "1", "3" }));
        capacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capacidadActionPerformed(evt);
            }
        });

        producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });

        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addRCompra.png"))); // NOI18N
        Agregar.setText("Agregar al Carrito");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Quitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/deteleCompra.png"))); // NOI18N
        Quitar.setText("Quitar del Carrito");
        Quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel9.setText("Usuario");

        usuariov.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        usuariov.setText("Usuario");

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel11.setText("Id Personal");

        idpersonalv.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        idpersonalv.setText("Id Personal");

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel13.setText("Carrito de Compras");

        ticket.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ticket);

        jLabel14.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel14.setText("ID Venta");

        idventa.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        idventa.setText("ID Venta");

        jLabel16.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel16.setText("Total de Productos");

        totalproductos.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        totalproductos.setText("Total de Productos");

        jLabel18.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel18.setText("Total de Venta");

        jLabel20.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel20.setText("MXN");

        Cobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cash-icon.png"))); // NOI18N
        Cobrar.setText("Cobrar");
        Cobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CobrarActionPerformed(evt);
            }
        });

        Finalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disk.png"))); // NOI18N
        Finalizar.setText("Finalizar Venta");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usuariov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Quitar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(preciou)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                        .addComponent(stocks)
                                        .addComponent(cantidad))
                                    .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idpersonalv))
                    .addComponent(Regresar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idventa))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalproductos)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalneto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(preciou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(stocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(fecha))
                        .addGap(18, 18, 18)
                        .addComponent(Agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Quitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(usuariov))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(idpersonalv)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(idventa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(totalproductos)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)
                            .addComponent(totalneto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cobrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Finalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Regresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
    String np="",precio="",stock="",stat="";
        int stock1=0;

        cap=(String)capacidad.getSelectedItem();
        if(cantidad.getText().trim().length()==0 || producto.getSelectedItem()==null || capacidad.getSelectedItem()==null){
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
        rs=st.executeQuery("SELECT PRECIO_VENTA FROM PRODUCTO WHERE ID_PRODUCTO ='"+np+"'");
        if(rs.next()){
            precio=rs.getString("PRECIO_VENTA");
        }
        
        String sqlinserta="SELECT STOCK FROM INVENTARIO WHERE ID_PRODUCTO = '" + np+ "'";
        PreparedStatement pst=conn.prepareStatement(sqlinserta);
        pst = conn.prepareStatement(sqlinserta);
        rs = pst.executeQuery();
        if(rs.next()){
            stock=rs.getString("STOCK");
        }
        stock1=Integer.parseInt(stock);
        
        sqlinserta="SELECT ID_STATUS FROM PRODUCTO WHERE ID_PRODUCTO = '" + np+ "'";
        pst=conn.prepareStatement(sqlinserta);
        rs = pst.executeQuery();
        if(rs.next()){
            stat=rs.getString("ID_STATUS");
        }
        if(stat.equals("2")){
            JOptionPane.showMessageDialog(null, (String)producto.getSelectedItem()+" está INHABILITADO. Notifique al Administrador");
        }else{
        if(stock1==0){
            JOptionPane.showMessageDialog(null, (String)producto.getSelectedItem()+" está agotado en el inventario. Notifique al Administrador");
        }else{
            
           double ca=Double.parseDouble(cantidad.getText());
            if(ca>stock1){
                JOptionPane.showMessageDialog(null,producto.getSelectedItem()+" de "+capacidad.getSelectedItem() +" insuficiente para realizar la venta. \nSolo quedan "+stock1+" en inventario");
            }else{
            double pr=Double.parseDouble(precio);
            double total=ca*pr;
            tproductos=tproductos+ca;
            datos[0]=(String)producto.getSelectedItem();
            datos[1]=this.cantidad.getText();
            datos[2]=precio;
            datos[3]=Double.toString(total); 
            modelo.addRow(datos); 
            tt=tt+total;
            totalneto.setText(Double.toString(tt));
            totalproductos.setText(tproductos.toString());
            }
        }}
        }else{
            JOptionPane.showMessageDialog(null, producto.getSelectedItem()+" de "+cap+" no está en existencia");
        }
        } catch (SQLException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void CobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CobrarActionPerformed
    try {
        conn=Conexion.Enlace(conn);
        st=conn.createStatement();
        rs=st.executeQuery("select nombre, paterno from cliente where id_cliente = '"+idcliente.getText().toString()+"'");
        
        if(rs.next()){
            String nombre=rs.getString("NOMBRE");
            String paterno=rs.getString("PATERNO");
             new ConfirmacionVenta().setVisible(true);
            ConfirmacionVenta.cobrar.setText(totalneto.getText());
            ConfirmacionVenta.nombrecliente.setText(nombre+" "+paterno);
        }else{
            JOptionPane.showMessageDialog(null, "El ID ingresado no está asignado, tal vez deba darlo de alta o elegir ID 1 de Mostrador");
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_CobrarActionPerformed

    private void QuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitarActionPerformed
        String aux=ticket.getValueAt(fila,3).toString();
        Double auxi=Double.parseDouble(aux);
        String aux2=ticket.getValueAt(fila,1).toString();
        Double auxi2=Double.parseDouble(aux2);
        tproductos=tproductos-auxi2;
        tt=tt-auxi;
        totalneto.setText(Double.toString(tt));
        totalproductos.setText(Double.toString(tproductos));
        modelo.removeRow(fila);
    }//GEN-LAST:event_QuitarActionPerformed

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
    try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

    String idp="",idnom="",stock="",canti="",stock2="";
    int stock1=0,stock3,cantid=0,actualiza=0,actualiza1=0;
    
    String MAX="SELECT MAX(ID_VENTA) AS ID_VENTA FROM VENTA";
    try {
        
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(MAX);
        if(rs.next()){
            c=Integer.parseInt(rs.getString("ID_VENTA"))+1;
        }
    }catch(SQLException e){           
                }
        
        
        
        String Variable="1";
        String sqlinsertar="INSERT INTO VENTA values (?,?,?,?,?,?)";
        PreparedStatement psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, Integer.toString(c));
        psta.setString(2, fecha.getText());
        psta.setString(3, totalneto.getText());
        psta.setString(4, idpersonalv.getText());
        psta.setString(5, idcliente.getText());
        psta.setString(6, Variable);
        psta.execute();

        try{
            
            MAX="SELECT MAX(ID_VENTA) AS ID_VENTA FROM VENTA@DBLINKMIGUEL";
            st=conn.createStatement();
                    rs=st.executeQuery(MAX);
                    if(rs.next()){
                        idmiguel = Integer.parseInt(rs.getString("ID_VENTA"));
                    }
        }catch(SQLException e){
            
        }

        idmi=idmiguel+1;

        sqlinsertar="INSERT INTO VENTA@DBLINKMIGUEL values (?,?,?,?,?,?)";
        psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, Integer.toString(idmi));
        psta.setString(2, fecha.getText());
        psta.setString(3, totalneto.getText());
        psta.setString(4, idpersonalv.getText());
        psta.setString(5, idcliente.getText());
        psta.setString(6, Variable);
        psta.execute();
        
        sqlinsertar="INSERT INTO VENTA@DBLINKBETO values (?,?,?,?,?,?)";
        psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, Integer.toString(c));
        psta.setString(2, fecha.getText());
        psta.setString(3, totalneto.getText());
        psta.setString(4, idpersonalv.getText());
        psta.setString(5, idcliente.getText());
        psta.setString(6, Variable);
        psta.execute();
        
        sqlinsertar="INSERT INTO VENTA@DBLINKHUGO values (?,?,?,?,?,?)";
        psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, Integer.toString(c));
        psta.setString(2, fecha.getText());
        psta.setString(3, totalneto.getText());
        psta.setString(4, idpersonalv.getText());
        psta.setString(5, idcliente.getText());
        psta.setString(6, Variable);
        psta.execute();

        int filass=ticket.getRowCount();
        
        int i=0;
        while(i<filass){
            
            String sqlinserta="SELECT ID_NOMBREPRODUCTO FROM NOMBREPRODUCTO WHERE NOMBREPRODUCTO = '" + ticket.getValueAt(i,0).toString()+ "'";
            PreparedStatement pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idnom=rs.getString("ID_NOMBREPRODUCTO");
            }

            sqlinserta="SELECT ID_PRODUCTO FROM PRODUCTO WHERE ID_NOMBREPRODUCTO = '" + idnom + "' AND PRECIO_VENTA ='"+ ticket.getValueAt(i,2).toString()+ "'";
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
            canti=ticket.getValueAt(i,1).toString();
            cantid=Integer.parseInt(canti);
            actualiza=stock1-cantid;
            actualiza1=stock3-cantid;
            
            PreparedStatement op=conn.prepareStatement("UPDATE INVENTARIO SET STOCK ='"+actualiza+"' WHERE ID_PRODUCTO='"+idp+"'");
            op.executeUpdate();

            op=conn.prepareStatement("UPDATE INVENTARIO@DBLINKMIGUEL SET STOCK ='"+actualiza1+"' WHERE ID_PRODUCTO='"+idp+"'");
            op.executeUpdate();
            
            op=conn.prepareStatement("UPDATE INVENTARIO@DBLINKBETO SET STOCK ='"+actualiza+"' WHERE ID_PRODUCTO='"+idp+"'");
            op.executeUpdate();
            
            op=conn.prepareStatement("UPDATE INVENTARIO@DBLINKHUGO SET STOCK ='"+actualiza+"' WHERE ID_PRODUCTO='"+idp+"'");
            op.executeUpdate();

            String sqlinsert="INSERT INTO DETALLE_VENTA values (?,?,?,?,?,?)";
            psta=conn.prepareStatement(sqlinsert);
            psta.setString(1, Integer.toString(c));
            psta.setString(2, idp);
            psta.setString(3, ticket.getValueAt(i,1).toString());
            psta.setString(4, ticket.getValueAt(i,2).toString());
            psta.setString(5, ticket.getValueAt(i,3).toString());
            psta.setString(6, Variable);
            psta.execute();

            sqlinsert="INSERT INTO DETALLE_VENTA@DBLINKMIGUEL values (?,?,?,?,?,?)";
            psta=conn.prepareStatement(sqlinsert);
            psta.setString(1, Integer.toString(idmi));
            psta.setString(2, idp);
            psta.setString(3, ticket.getValueAt(i,1).toString());
            psta.setString(4, ticket.getValueAt(i,2).toString());
            psta.setString(5, ticket.getValueAt(i,3).toString());
            psta.setString(6, Variable);
            psta.execute();
            
            sqlinsert="INSERT INTO DETALLE_VENTA@DBLINKBETO values (?,?,?,?,?,?)";
            psta=conn.prepareStatement(sqlinsert);
            psta.setString(1, Integer.toString(c));
            psta.setString(2, idp);
            psta.setString(3, ticket.getValueAt(i,1).toString());
            psta.setString(4, ticket.getValueAt(i,2).toString());
            psta.setString(5, ticket.getValueAt(i,3).toString());
            psta.setString(6, Variable);
            psta.execute();
            
            sqlinsert="INSERT INTO DETALLE_VENTA@DBLINKHUGO values (?,?,?,?,?,?)";
            psta=conn.prepareStatement(sqlinsert);
            psta.setString(1, Integer.toString(c));
            psta.setString(2, idp);
            psta.setString(3, ticket.getValueAt(i,1).toString());
            psta.setString(4, ticket.getValueAt(i,2).toString());
            psta.setString(5, ticket.getValueAt(i,3).toString());
            psta.setString(6, Variable);
            psta.execute();

            i++;
       }

        JOptionPane.showMessageDialog(null, "Venta finalizada exitosamente");
        idcliente.setText("");
        producto.setSelectedItem(null);
        capacidad.setSelectedItem(null);
        preciou.setText("");
        stocks.setText("");
        cantidad.setText("");
        this.ticket.setModel(modelo);
        for (int o = 0; o < ticket.getRowCount(); o++) {
        modelo.removeRow(o);
            o-=1;
        }
        idventa.setText(Integer.toString(c+1));
        totalproductos.setText("");
        totalneto.setText("");
       
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

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        stocks.setText("");
        preciou.setText("");
    }//GEN-LAST:event_productoActionPerformed

    private void capacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capacidadActionPerformed
 try{ 
            rs=st.executeQuery("SELECT ID_NOMBREPRODUCTO\n" +
                            "FROM NOMBREPRODUCTO\n" +
                            "WHERE NOMBREPRODUCTO='"+producto.getSelectedItem().toString()+"'");
          if (rs.next()){
              idnomp=rs.getString("ID_NOMBREPRODUCTO");
          } 
          rs=st.executeQuery("SELECT ID_PRODUCTO\n" +
                             "FROM PRODUCTO\n" +
                             "WHERE ID_NOMBREPRODUCTO='"+idnomp+"' AND CAPACIDAD='"+capacidad.getSelectedItem().toString()+"'");
          if (rs.next()){
              idprod=rs.getString("ID_PRODUCTO");
          }
          
          rs=st.executeQuery("SELECT STOCK\n" +
                             "FROM INVENTARIO\n" +
                             "WHERE ID_PRODUCTO='"+idprod+"'");
          if (rs.next()){
              stocks.setText(rs.getString("STOCK"));
          }
          
          rs=st.executeQuery("SELECT PRECIO_VENTA\n" +
                             "FROM  PRODUCTO\n" +
                             "WHERE ID_PRODUCTO='"+idprod+"'");
          if (rs.next()){
              preciou.setText(rs.getString("PRECIO_VENTA"));
          } 
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_capacidadActionPerformed

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Agregar;
    public static javax.swing.JButton Cobrar;
    public static javax.swing.JButton Finalizar;
    public static javax.swing.JButton Quitar;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JComboBox<String> capacidad;
    private javax.swing.JLabel fecha;
    private javax.swing.JTextField idcliente;
    private javax.swing.JLabel idpersonalv;
    public static javax.swing.JLabel idventa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField preciou;
    private javax.swing.JComboBox<String> producto;
    private javax.swing.JTextField stocks;
    public static javax.swing.JTable ticket;
    public static javax.swing.JTextField totalneto;
    private javax.swing.JLabel totalproductos;
    public static javax.swing.JLabel usuariov;
    // End of variables declaration//GEN-END:variables
}
