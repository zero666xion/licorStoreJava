
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

public class Productos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    int fila=0;
    int c=0;
    String datos[]=new String[11];String cantidad= "0";
    
    public Productos() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        Calendar Cal= Calendar.getInstance();
        String fec= Cal.get(Cal.DATE)+"/"+(Cal.get(Cal.MONTH)+1)+"/"+Cal.get(Cal.YEAR);
        fecha.setText(fec);
       
        try{
            conn=Conexion.Enlace(conn);
            String MAX="SELECT MAX(ID_PRODUCTO) AS ID_PRODUCTO FROM PRODUCTO";
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        c=Integer.parseInt(rs.getString("ID_PRODUCTO"))+1;
                    }
                    
            id.setText(Integer.toString(c));
           
            
            this.nombre.removeAllItems();
            st=conn.createStatement();
            rs=st.executeQuery("SELECT * FROM NOMBREPRODUCTO ORDER BY NOMBREPRODUCTO ASC");
            while (rs.next()){
                this.nombre.addItem(rs.getString("NOMBREPRODUCTO"));
            }
            
            this.marca.removeAllItems();
            rs=st.executeQuery("SELECT * FROM MARCA ORDER BY MARCA ASC");
            while (rs.next()){
                this.marca.addItem(rs.getString("MARCA"));
            }
            
            this.medida.removeAllItems();
            rs=st.executeQuery("SELECT * FROM MEDIDA ORDER BY MEDIDA ASC");
            while (rs.next()){
                this.medida.addItem(rs.getString("MEDIDA"));
            }
            
            this.tipo.removeAllItems();
            rs=st.executeQuery("SELECT * FROM TIPO ORDER BY TIPO ASC");
            while (rs.next()){
                this.tipo.addItem(rs.getString("TIPO"));
            }
            
            this.categoria.removeAllItems();
            rs=st.executeQuery("SELECT * FROM CATEGORIA ORDER BY CATEGORIA ASC");
            while (rs.next()){
                this.categoria.addItem(rs.getString("CATEGORIA"));
            }
            
            this.status.removeAllItems();
            rs=st.executeQuery("SELECT * FROM STATUS ORDER BY STATUS ASC");
            while (rs.next()){
                this.status.addItem(rs.getString("STATUS"));
            }
            
            nombre.setSelectedItem(null);
            medida.setSelectedItem(null);
            marca.setSelectedItem(null);
            tipo.setSelectedItem(null);
            categoria.setSelectedItem(null);
            status.setSelectedItem(null);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);//fin de materiales
        }
        
        this.tablaproductos.setModel(modelo);
        String Msg ="SELECT PRODUCTO.ID_PRODUCTO, \n" +
"                        PRODUCTO.CAPACIDAD, \n" +
"                        MEDIDA.MEDIDA, \n" +
"                        NOMBREPRODUCTO.NOMBREPRODUCTO, \n" +
"                        TIPO.TIPO,\n" +
"                        MARCA.MARCA, \n" +
"                        CATEGORIA.CATEGORIA, \n" +
"                        PRODUCTO.PRECIO_VENTA, \n" +
"                        PRODUCTO.PRECIO_COMPRA, \n" +                
"                        STATUS.STATUS \n"
+"                    FROM PRODUCTO \n" +
"                    INNER JOIN NOMBREPRODUCTO ON PRODUCTO.ID_NOMBREPRODUCTO = NOMBREPRODUCTO.ID_NOMBREPRODUCTO \n" +
"                    INNER JOIN MEDIDA ON PRODUCTO.ID_MEDIDA = MEDIDA.ID_MEDIDA \n" +
"                    INNER JOIN TIPO ON PRODUCTO.ID_TIPO = TIPO.ID_TIPO \n" +
"                    INNER JOIN MARCA ON PRODUCTO.ID_MARCA = MARCA.ID_MARCA \n" +
"                    INNER JOIN CATEGORIA ON PRODUCTO.ID_CATEGORIA = CATEGORIA.ID_CATEGORIA \n" +
"                    INNER JOIN STATUS ON PRODUCTO.ID_STATUS = STATUS.ID_STATUS \n "+ 
"                    ORDER BY PRODUCTO.ID_PRODUCTO ASC";
         
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
            
        tablaproductos.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table =(JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            fila=tablaproductos.getSelectedRow();
            if (Mouse_evt.getClickCount() == 1) {
                id.setText(tablaproductos.getValueAt(fila, 0).toString());
                nombre.setSelectedItem(tablaproductos.getValueAt(fila,3).toString());
                marca.setSelectedItem(tablaproductos.getValueAt(fila,5).toString());
                medida.setSelectedItem(tablaproductos.getValueAt(fila,2).toString());
                capacidad.setText(tablaproductos.getValueAt(fila,1).toString());
                tipo.setSelectedItem(tablaproductos.getValueAt(fila,4).toString());
                categoria.setSelectedItem(tablaproductos.getValueAt(fila,6).toString());
                preciov.setText(tablaproductos.getValueAt(fila,7).toString());
                precioc.setText(tablaproductos.getValueAt(fila,8).toString());
                status.setSelectedItem(tablaproductos.getValueAt(fila, 9));
            }
        }
        });     
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        nombre = new javax.swing.JComboBox<>();
        marca = new javax.swing.JComboBox<>();
        medida = new javax.swing.JComboBox<>();
        capacidad = new javax.swing.JTextField();
        nproducto = new javax.swing.JButton();
        nmarca = new javax.swing.JButton();
        nmedida = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox<>();
        categoria = new javax.swing.JComboBox<>();
        ntipo = new javax.swing.JButton();
        ncategoria = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        preciov = new javax.swing.JTextField();
        precioc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        Limpiar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproductos = new javax.swing.JTable();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Marca:");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Producto:");

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel4.setText("Medida:");

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel5.setText("Capacidad:");

        id.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        id.setText("ID:");

        nombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        medida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        capacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                capacidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capacidadKeyTyped(evt);
            }
        });

        nproducto.setText("Nuevo");
        nproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nproductoActionPerformed(evt);
            }
        });

        nmarca.setText("Nuevo");
        nmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmarcaActionPerformed(evt);
            }
        });

        nmedida.setText("Nuevo");
        nmedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmedidaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel7.setText("Tipo:");

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel8.setText("Categoria:");

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ntipo.setText("Nuevo");
        ntipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntipoActionPerformed(evt);
            }
        });

        ncategoria.setText("Nuevo");
        ncategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncategoriaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel9.setText("Precio Venta:");

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel10.setText("Precio Compra:");

        preciov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                preciovKeyReleased(evt);
            }
        });

        precioc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                preciocKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel11.setText("Status:");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel13.setText("Fecha:");

        fecha.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        fecha.setText("Fecha:");

        Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom.png"))); // NOI18N
        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add-item.png"))); // NOI18N
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disk.png"))); // NOI18N
        Guardar.setText("Guardar Cambios");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nproducto)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(nmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel8))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ntipo))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ncategoria))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(preciov, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(medida, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nmedida)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(precioc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Limpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Agregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Guardar)))
                        .addGap(0, 270, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Regresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nproducto)
                    .addComponent(jLabel7)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ntipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nmarca)
                    .addComponent(jLabel8)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ncategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(preciov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(medida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nmedida)
                    .addComponent(jLabel10)
                    .addComponent(precioc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fecha)
                    .addComponent(jLabel11)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Limpiar)
                    .addComponent(Agregar)
                    .addComponent(Guardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Regresar)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ncategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncategoriaActionPerformed
    dispose();
    new Categoria().setVisible(true);
    }//GEN-LAST:event_ncategoriaActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
    String idmarca="", idnombre="",idtipo="",idcat="",idmedida="", idstatus="";
        
        try {
            conn=Conexion.Enlace(conn);
            if(nombre.getSelectedItem()==null || marca.getSelectedItem()==null ||capacidad.getText().trim().length()==0 || medida.getSelectedItem()==null || tipo.getSelectedItem()==null || status.getSelectedItem()==null || categoria.getSelectedItem()==null || preciov.getText().trim().length()==0 || precioc.getText().trim().length()==0){
                JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");
            }
            else{
            PreparedStatement pst;
            String sqlinserta="SELECT ID_MARCA FROM MARCA WHERE MARCA = '" + marca.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idmarca=rs.getString("ID_MARCA");
            }
            
            sqlinserta="SELECT ID_NOMBREPRODUCTO FROM NOMBREPRODUCTO WHERE NOMBREPRODUCTO = '" + nombre.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idnombre=rs.getString("ID_NOMBREPRODUCTO");
            }
            
            sqlinserta="SELECT ID_TIPO FROM TIPO WHERE TIPO = '" + tipo.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idtipo=rs.getString("ID_TIPO");
            }
            
            sqlinserta="SELECT ID_CATEGORIA FROM CATEGORIA WHERE CATEGORIA = '" + categoria.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idcat=rs.getString("ID_CATEGORIA");
            }
            
            sqlinserta="SELECT ID_MEDIDA FROM MEDIDA WHERE MEDIDA = '" + medida.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idmedida=rs.getString("ID_MEDIDA");
            }
            
            sqlinserta="SELECT ID_STATUS FROM STATUS WHERE STATUS = '" + status.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idstatus=rs.getString("ID_STATUS");
            }
            
            sqlinserta="SELECT * FROM PRODUCTO WHERE ID_NOMBREPRODUCTO = '"+idnombre+"' AND ID_MARCA ='" +idmarca + "' AND CAPACIDAD = '"+capacidad.getText()+"' AND ID_MEDIDA = '"+idmedida+"'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, nombre.getSelectedItem()+" de "+capacidad.getText()+" "+medida.getSelectedItem()+" ya se encuentra dado de alta en la base de datos. \nCorrobore sus datos");
            }else{
                
                String sqlinsertar="INSERT INTO PRODUCTO values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                datos[0]=id.getText();
                psta.setString(2, capacidad.getText());
                datos[1]=this.capacidad.getText();
                psta.setString(3, idmedida);
                datos[2]=idmedida;
                psta.setString(4, idnombre);
                datos[3]=idnombre;
                psta.setString(5, idtipo);
                datos[4]=idtipo;
                psta.setString(6, idmarca);
                datos[5]=idmarca;
                psta.setString(7, idcat);
                datos[6]=idcat;
                psta.setString(8, preciov.getText());
                datos[7]=this.preciov.getText();
                psta.setString(9, preciov.getText());
                datos[8]=this.precioc.getText();
                psta.setString(10, idstatus);
                datos[9]=idstatus;
                modelo.addRow(datos); 
                psta.execute();
                psta.close();
                
                sqlinsertar="INSERT INTO INVENTARIO values (?,?)";
                PreparedStatement psto=conn.prepareStatement(sqlinsertar);
                psto.setString(1, id.getText());
                psto.setString(2, cantidad);
                
                JOptionPane.showMessageDialog(null, "El Producto "+nombre.getSelectedItem()+" ha sido agregado con éxito");
                nombre.setSelectedItem(null);
                medida.setSelectedItem(null);
                marca.setSelectedItem(null);
                tipo.setSelectedItem(null);
                categoria.setSelectedItem(null);   
                status.setSelectedItem(null);
                capacidad.setText("");
                preciov.setText("");
                precioc.setText("");
                id.setText(Integer.toString(c));
                dispose();
                new Productos().setVisible(true);
                }
            }
            
           } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        nombre.setSelectedItem(null);
        medida.setSelectedItem(null);
        marca.setSelectedItem(null);
        tipo.setSelectedItem(null);
        status.setSelectedItem(null);
        categoria.setSelectedItem(null);            
        capacidad.setText("");
        preciov.setText("");
        precioc.setText("");
        id.setText(Integer.toString(c));
    }//GEN-LAST:event_LimpiarActionPerformed

    private void nmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmarcaActionPerformed
        dispose();
        new Marca().setVisible(true);
    }//GEN-LAST:event_nmarcaActionPerformed

    private void nproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nproductoActionPerformed
        dispose();
        new NombreProducto().setVisible(true);
    }//GEN-LAST:event_nproductoActionPerformed

    private void nmedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmedidaActionPerformed
        dispose();
        new Medida().setVisible(true);
    }//GEN-LAST:event_nmedidaActionPerformed

    private void ntipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntipoActionPerformed
        dispose();
        new Tipo().setVisible(true);
    }//GEN-LAST:event_ntipoActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
    String idmarca="", idnombre="",idtipo="",idcat="",idmedida="", idstatus="";

        try{    
            if(nombre.getSelectedItem()==null || marca.getSelectedItem()==null ||capacidad.getText().trim().length()==0 || medida.getSelectedItem()==null || tipo.getSelectedItem()==null || status.getSelectedItem()==null || categoria.getSelectedItem()==null || preciov.getText().trim().length()==0 || precioc.getText().trim().length()==0){
                JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");
            }else{
            
            PreparedStatement pst;
            String sqlinserta="SELECT ID_MARCA FROM MARCA WHERE MARCA = '" + marca.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idmarca=rs.getString("ID_MARCA");
            }
            
            sqlinserta="SELECT ID_NOMBREPRODUCTO FROM NOMBREPRODUCTO WHERE NOMBREPRODUCTO = '" + nombre.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idnombre=rs.getString("ID_NOMBREPRODUCTO");
            }
            
            sqlinserta="SELECT ID_TIPO FROM TIPO WHERE TIPO = '" + tipo.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idtipo=rs.getString("ID_TIPO");
            }
            
            sqlinserta="SELECT ID_CATEGORIA FROM CATEGORIA WHERE CATEGORIA = '" + categoria.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idcat=rs.getString("ID_CATEGORIA");
            }
            
            sqlinserta="SELECT ID_MEDIDA FROM MEDIDA WHERE MEDIDA = '" + medida.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idmedida=rs.getString("ID_MEDIDA");
            }
            
            sqlinserta="SELECT ID_STATUS FROM STATUS WHERE STATUS = '" + status.getSelectedItem()+ "'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                idstatus=rs.getString("ID_STATUS");
            }
            
            sqlinserta="SELECT * FROM PRODUCTO WHERE ID_NOMBREPRODUCTO = '"+idnombre+"' AND ID_MARCA ='" +idmarca + "' AND CAPACIDAD = '"+capacidad.getText()+"' AND ID_MEDIDA = '"+idmedida+"' AND CAPACIDAD = '"+capacidad.getText()+"' AND PRECIO_VENTA = '"+preciov.getText()+"' AND PRECIO_COMPRA = '"+precioc.getText()+"' AND ID_TIPO = '"+idtipo+"'"+ "AND ID_STATUS = '"+idstatus+"'";
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Al Producto "+nombre.getSelectedItem()+" de "+capacidad.getText()+" "+medida.getSelectedItem()+" no se le ha modificado aún. \nCorrobore sus datos");
            }else{
            PreparedStatement op=conn.prepareStatement("UPDATE PRODUCTO SET ID_PRODUCTO ='"+id.getText()+"', CAPACIDAD ='"+capacidad.getText()+"', ID_MEDIDA='"+idmedida+"',ID_NOMBREPRODUCTO='"+idnombre+"', ID_TIPO ='"+idtipo+"',ID_MARCA ='"+idmarca+"',ID_CATEGORIA ='"+idcat+"', PRECIO_VENTA ='" +preciov.getText()+"', ID_STATUS ='"+idstatus+ "' WHERE ID_PRODUCTO ='"+id.getText()+"'");
            op.executeUpdate();
                datos[0]=this.id.getText();
                datos[1]=this.capacidad.getText();
                datos[2]=idmedida;
                datos[3]=idnombre;
                datos[4]=idtipo;
                datos[5]=idmarca;
                datos[6]=idcat;
                datos[7]=this.preciov.getText();
                datos[8]=this.precioc.getText();
                datos[9]=idstatus;        
                modelo.addRow(datos);
                modelo.removeRow(fila);
            op.close();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            dispose();
            new Productos().setVisible(true);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_GuardarActionPerformed

    private void capacidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capacidadKeyReleased
    if(!capacidad.getText().matches("[0-9]*")){
                   JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
                   capacidad.setText("");//Limpia campo ciente
                   capacidad.requestFocus();//Devuelve el curso el inicio del campo
        }
    }//GEN-LAST:event_capacidadKeyReleased

    private void capacidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capacidadKeyTyped
            if(!capacidad.getText().matches("[0-9]*")){
                   evt.consume();
        }
    }//GEN-LAST:event_capacidadKeyTyped

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

    private void preciovKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preciovKeyReleased
            if(!preciov.getText().matches("[0-9]*")){
                   JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
                   preciov.setText("");//Limpia campo ciente
                   preciov.requestFocus();//Devuelve el curso el inicio del campo
        }
    }//GEN-LAST:event_preciovKeyReleased

    private void preciocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preciocKeyReleased
            if(!precioc.getText().matches("[0-9]*")){
            JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
            precioc.setText("");//Limpia campo ciente
            precioc.requestFocus();
        }
    }//GEN-LAST:event_preciocKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField capacidad;
    private javax.swing.JComboBox<String> categoria;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> marca;
    private javax.swing.JComboBox<String> medida;
    private javax.swing.JButton ncategoria;
    private javax.swing.JButton nmarca;
    private javax.swing.JButton nmedida;
    private javax.swing.JComboBox<String> nombre;
    private javax.swing.JButton nproducto;
    private javax.swing.JButton ntipo;
    private javax.swing.JTextField precioc;
    private javax.swing.JTextField preciov;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTable tablaproductos;
    private javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables
}
