
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
import static Ventanas.Personal.conn;

public class Proveedores extends javax.swing.JFrame {

    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    int fila=0;
    int c=0,d=0,e=0;
    String datos[]=new String[11];
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Proveedores() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        Eliminar.setEnabled(false);
        Guardar.setEnabled(false);
        Calendar Cal= Calendar.getInstance();
        String fec= Cal.get(Cal.DATE)+"/"+(Cal.get(Cal.MONTH)+1)+"/"+Cal.get(Cal.YEAR);
        fecha.setText(fec);
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        
        direccion.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        
        rfc.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        
        contacto.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});        
        
        this.tablaproveedor.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            rs=Conexion.tablaProveedores(rs);//ejecuta la consulta
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
            
            try{
            conn=Conexion.Enlace(conn);
            String MAX="SELECT MAX(ID_PROVEEDOR) AS ID_PROVEEDOR FROM PROVEEDOR";
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        d=Integer.parseInt(rs.getString("ID_PROVEEDOR"));
                    }
        
            
            id.setText(Integer.toString(d+1));
          
              }catch(SQLException ex){ 
                }

            
            
            
        tablaproveedor.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table =(JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            fila=tablaproveedor.getSelectedRow();
            if (Mouse_evt.getClickCount() == 1) {
                id.setText(tablaproveedor.getValueAt(fila, 0).toString());
                nombre.setText(tablaproveedor.getValueAt(fila,1).toString());
                direccion.setText(tablaproveedor.getValueAt(fila,2).toString());
                telefono.setText(tablaproveedor.getValueAt(fila,3).toString());
                email.setText(tablaproveedor.getValueAt(fila,4).toString());
                rfc.setText(tablaproveedor.getValueAt(fila,5).toString());
                contacto.setText(tablaproveedor.getValueAt(fila,6).toString());
                Agregar.setEnabled(false);
                Eliminar.setEnabled(true);
                Guardar.setEnabled(true);
                direccion.setVisible(true);
            }
        }
        });      
            }catch (Exception ex) {
            ex.printStackTrace();
    }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        direccion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        rfc = new javax.swing.JTextField();
        contacto = new javax.swing.JTextField();
        Limpiar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaproveedor = new javax.swing.JTable();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setText("Nombre(s)");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Dirección");

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
        });

        direccion.setColumns(20);
        direccion.setRows(5);
        jScrollPane1.setViewportView(direccion);

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("ID.");

        id.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        id.setText("ID.");

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel6.setText("Email.");

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel7.setText("RFC");

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel8.setText("Contacto");

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel9.setText("Fecha:");

        fecha.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        fecha.setText("Fecha:");

        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });

        rfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rfcKeyTyped(evt);
            }
        });

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

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete-item.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disk.png"))); // NOI18N
        Guardar.setText("Guardar Cambios");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        tablaproveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaproveedor);

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
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Limpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Agregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Eliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Guardar)))
                        .addGap(0, 283, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Regresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Limpiar)
                    .addComponent(Agregar)
                    .addComponent(Eliminar)
                    .addComponent(Guardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Regresar)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
            nombre.setText("");
            direccion.setText("");
            telefono.setText("");
            rfc.setText("");
            id.setText("");
            email.setText("");
            contacto.setText("");
            id.setText(Integer.toString(c));
            Eliminar.setEnabled(false);
            Guardar.setEnabled(false);
            Agregar.setEnabled(true);
    }//GEN-LAST:event_LimpiarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        
try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

        int c=0;
        try {
            conn=Conexion.Enlace(conn);
            if(nombre.getText().trim().length()==0 || telefono.getText().trim().length()==0 || rfc.getText().trim().length()==0 || direccion.getText().trim().length()==0 || contacto.getText().trim().length()==0){
                JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");
            }
            else{
            String sqlinserta="SELECT * FROM PROVEEDOR WHERE NOMBRE = '"+nombre.getText()+"' AND RFC ='" + rfc.getText() + "'";
            PreparedStatement pst;
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "El Proveedor "+nombre.getText()+" ya se encuentra dado de alta en la base de datos. \nCorrobore sus datos");
                }else{
                
                String MAX="SELECT MAX(ID_PROVEEDOR) AS ID_PROVEEDOR FROM PROVEEDOR";
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        c=Integer.parseInt(rs.getString("ID_PROVEEDOR"))+1;
                    }
                }catch(SQLException ex){ 
                }
                String Variable="1";

                String sqlinsertar="INSERT INTO PROVEEDOR@DBLINKCHAVA values (?,?,?,?,?,?,?,?)";
                PreparedStatement psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, direccion.getText());
                psta.setString(4, telefono.getText());
                psta.setString(5, email.getText());
                psta.setString(6, rfc.getText());
                psta.setString(7, contacto.getText());
                psta.setString(8, Variable); 
                psta.execute();
                
                sqlinsertar="INSERT INTO PROVEEDOR@DBLINKBETO values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, direccion.getText());
                psta.setString(4, telefono.getText());
                psta.setString(5, email.getText());
                psta.setString(6, rfc.getText());
                psta.setString(7, contacto.getText());
                psta.setString(8, Variable); 
                psta.execute();
                
                sqlinsertar="INSERT INTO PROVEEDOR@DBLINKHUGO values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, direccion.getText());
                psta.setString(4, telefono.getText());
                psta.setString(5, email.getText());
                psta.setString(6, rfc.getText());
                psta.setString(7, contacto.getText());
                psta.setString(8, Variable); 
                psta.execute();
                
                sqlinsertar="INSERT INTO PROVEEDOR@DBLINKRICHI values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, direccion.getText());
                psta.setString(4, telefono.getText());
                psta.setString(5, email.getText());
                psta.setString(6, rfc.getText());
                psta.setString(7, contacto.getText());
                psta.setString(8, Variable); 
                psta.execute();
                
                sqlinsertar="INSERT INTO PROVEEDOR@DBLINKMATA values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, direccion.getText());
                psta.setString(4, telefono.getText());
                psta.setString(5, email.getText());
                psta.setString(6, rfc.getText());
                psta.setString(7, contacto.getText());
                psta.setString(8, Variable); 
                psta.execute();
                
                sqlinsertar="INSERT INTO PROVEEDOR@DBLINKPROFE values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, direccion.getText());
                psta.setString(4, telefono.getText());
                psta.setString(5, email.getText());
                psta.setString(6, rfc.getText());
                psta.setString(7, contacto.getText());
                psta.setString(8, Variable); 
                psta.execute();
                
                sqlinsertar="INSERT INTO PROVEEDOR values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                datos[0]=id.getText();
                psta.setString(2, nombre.getText());
                datos[1]=this.nombre.getText();
                psta.setString(3, direccion.getText());
                datos[2]=this.direccion.getText();
                psta.setString(4, telefono.getText());
                datos[3]=this.telefono.getText();
                psta.setString(5, email.getText());
                datos[4]=this.email.getText();
                psta.setString(6, rfc.getText());
                datos[5]=this.rfc.getText();
                psta.setString(7, contacto.getText());
                datos[6]=this.contacto.getText();
                psta.setString(8, Variable);
                datos[7]=Variable;
                modelo.addRow(datos); 
                psta.execute();

            JOptionPane.showMessageDialog(null, "El Proveedor "+nombre.getText()+" ha sido agregado con éxito");
            nombre.setText("");
            direccion.setText("");
            telefono.setText("");
            email.setText("");
            id.setText("");
            rfc.setText("");
            contacto.setText("");
            Eliminar.setEnabled(false);
            Guardar.setEnabled(false);
            Agregar.setEnabled(true);
            dispose();
            new Proveedores().setVisible(true);




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
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
    
      try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

Object [] opciones ={"SI","NO"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro de Eliminar el Proveedor: "+nombre.getText()+"?", "Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION){
        try {
        conn=Conexion.Enlace(conn);

            

                PreparedStatement op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKCHAVA SET ID_STATUS ='2' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKBETO SET ID_STATUS ='2' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKHUGO SET ID_STATUS ='2' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKRICHI SET ID_STATUS ='2' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKMATA SET ID_STATUS ='2' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKPROFE SET ID_STATUS ='2' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
            op=conn.prepareStatement("UPDATE PROVEEDOR SET ID_STATUS ='2' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
            op.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro ELIMINADO Satisfactoriamente");
            dispose();
            new Proveedores().setVisible(true);
           
           } catch (SQLException ex) {
            
           }
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

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
    
try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();
    
try {
        

        if(nombre.getText().trim().length()==0 || direccion.getText().trim().length()==0 || telefono.getText().trim().length()==0 || rfc.getText().trim().length()==0 || email.getText().trim().length()==0 || contacto.getText().trim().length()==0) {
        JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");       
        }else{
            String Variable="1";
            
                PreparedStatement op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKCHAVA SET NOMBRE ='"+nombre.getText()+"', DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"', CONTACTO ='"+contacto.getText()+"' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKBETO SET NOMBRE ='"+nombre.getText()+"', DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"', CONTACTO ='"+contacto.getText()+"' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKHUGO SET NOMBRE ='"+nombre.getText()+"', DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"', CONTACTO ='"+contacto.getText()+"' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKRICHI SET NOMBRE ='"+nombre.getText()+"', DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"', CONTACTO ='"+contacto.getText()+"' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKMATA SET NOMBRE ='"+nombre.getText()+"', DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"', CONTACTO ='"+contacto.getText()+"' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PROVEEDOR@DBLINKPROFE SET NOMBRE ='"+nombre.getText()+"', DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"', CONTACTO ='"+contacto.getText()+"' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
                op.executeUpdate();
                
            op=conn.prepareStatement("UPDATE PROVEEDOR SET NOMBRE ='"+nombre.getText()+"', DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"', CONTACTO ='"+contacto.getText()+"' WHERE ID_PROVEEDOR ='"+id.getText()+"'");
            op.executeUpdate();
                datos[0]=this.id.getText();
                datos[1]=this.nombre.getText();
                datos[2]=this.direccion.getText();
                datos[3]=this.telefono.getText();
                datos[4]=this.email.getText();
                datos[5]=this.rfc.getText();
                datos[6]=this.contacto.getText();
                datos[7]=Variable;
                modelo.addRow(datos);
                modelo.removeRow(fila);

            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            dispose();
            new Proveedores().setVisible(true);



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
    }//GEN-LAST:event_GuardarActionPerformed

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
            if(!nombre.getText().matches("[A-Z,Ñ,Á,É,Í,Ó,Ú,.\\s]*")){
           JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
            nombre.setText("");//Limpia campo ciente
            nombre.requestFocus();//Devuelve el curso el inicio del campo
        }
    }//GEN-LAST:event_nombreKeyReleased

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        int limite=10;
        if(telefono.getText().length()>=limite){
            evt.consume();
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void telefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyReleased
        if(!telefono.getText().matches("[0-9]*")){
            JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
            telefono.setText("");//Limpia campo ciente
            telefono.requestFocus();//Devuelve el curso el inicio del campo
        }
    }//GEN-LAST:event_telefonoKeyReleased

    private void rfcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rfcKeyTyped
        int limite=12;
        if(rfc.getText().length()>=limite){
            evt.consume();
        }
    }//GEN-LAST:event_rfcKeyTyped

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
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField contacto;
    private javax.swing.JTextArea direccion;
    private javax.swing.JTextField email;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField rfc;
    private javax.swing.JTable tablaproveedor;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
