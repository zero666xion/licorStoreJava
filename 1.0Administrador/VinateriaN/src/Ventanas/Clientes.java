
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

public class Clientes extends javax.swing.JFrame {

    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    int fila=0;
    int c=0,d=0,e=0;
    String datos[]=new String[11];
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Clientes() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        id.disable();
        usuariocl.disable();
        idcli.disable();
        Guardar.setEnabled(false);
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
                
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        
        paterno.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        
        materno.addKeyListener(new java.awt.event.KeyAdapter() {
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
        
            try{
                conn=Conexion.Enlace(conn);    
                String MAX="SELECT MAX(ID_CLIENTE) AS ID_CLIENTE FROM CLIENTE";
                Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        d=Integer.parseInt(rs.getString("ID_CLIENTE"));
                    }

                    id.setText(Integer.toString(d+1));
                    id.disable();
                    rs.close();
                    }catch (Exception ex) {
                    ex.printStackTrace();
                }    
                
        
        this.tablaclientes.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            rs=Conexion.tablaClientes(rs);//ejecuta la consulta
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
            
          tablaclientes.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table =(JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            fila=tablaclientes.getSelectedRow();
            if (Mouse_evt.getClickCount() == 1) {
                id.setText(tablaclientes.getValueAt(fila, 0).toString());
                nombre.setText(tablaclientes.getValueAt(fila,1).toString());
                paterno.setText(tablaclientes.getValueAt(fila,2).toString());
                materno.setText(tablaclientes.getValueAt(fila,3).toString());
                direccion.setText(tablaclientes.getValueAt(fila,4).toString());
                telefono.setText(tablaclientes.getValueAt(fila,5).toString());
                email.setText(tablaclientes.getValueAt(fila,6).toString());
                rfc.setText(tablaclientes.getValueAt(fila,7).toString());
                id.disable();
                Agregar.setEnabled(false);
                Guardar.setEnabled(true);
                Limpiar.setEnabled(true);
            }
        }
        });  
            rs.close();
            }catch (Exception ex) {
            ex.printStackTrace();
    }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        paterno = new javax.swing.JTextField();
        materno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        direccion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rfc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        Limpiar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        Mostrar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        usuariocl = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        idcli = new javax.swing.JTextField();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        jLabel1.setText("\"CLIENTES\"");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setText("Nombre(s)");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("Apellido Paterno");

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel4.setText("Apellido Materno");

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
        });

        paterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paternoKeyReleased(evt);
            }
        });

        materno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maternoKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel5.setText("ID.");

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel6.setText("Dirección.");

        direccion.setColumns(20);
        direccion.setRows(5);
        jScrollPane1.setViewportView(direccion);

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel7.setText("Fecha");

        fecha.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        fecha.setText("Label");

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel9.setText("Telefono");

        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel10.setText("RFC");

        rfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rfcKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel11.setText("Email");

        Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom.png"))); // NOI18N
        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.PNG"))); // NOI18N
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

        Mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload.png"))); // NOI18N
        Mostrar.setText("Mostrar Todo");
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel12.setText("Buscar");

        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaclientes);

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel13.setText("Usuario ");

        jLabel14.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel14.setText("ID.");

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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(paterno, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(58, 58, 58)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(materno, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(fecha)))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 172, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Limpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ok)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuariocl, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idcli, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Regresar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(paterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(materno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fecha)
                    .addComponent(jLabel9)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Limpiar)
                    .addComponent(Agregar)
                    .addComponent(Guardar)
                    .addComponent(Mostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ok))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(usuariocl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(idcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Regresar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
            nombre.setText("");
            paterno.setText("");
            materno.setText("");
            direccion.setText("");
            telefono.setText("");
            rfc.setText("");
            id.setText("");
            email.setText("");
            id.setText(Integer.toString(c));
            Guardar.setEnabled(false);
            Agregar.setEnabled(true);
    }//GEN-LAST:event_LimpiarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
    
    try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

try {
            conn=Conexion.Enlace(conn);
            if(nombre.getText().trim().length()==0 || (paterno.getText().trim().length()==0 || materno.getText().trim().length()==0 || telefono.getText().trim().length()==0 || rfc.getText().trim().length()==0) ){
                JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");
            }
            else{
            String sqlinserta="SELECT * FROM CLIENTE WHERE NOMBRE = '"+nombre.getText()+"' AND PATERNO ='" + paterno.getText() + "' AND MATERNO = '"+ materno.getText()+"'";
            PreparedStatement pst;
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "El personal que desea agregar, ya existe. \nCorrobore sus datos");
                }else{
                
                
                String sqlinsertar="INSERT INTO CLIENTE values (?,?,?,?,?,?,?,?)";
                PreparedStatement psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                datos[0]=id.getText();
                psta.setString(2, nombre.getText());
                datos[1]=this.nombre.getText();
                psta.setString(3, paterno.getText());
                datos[2]=this.paterno.getText();
                psta.setString(4, materno.getText());
                datos[3]=this.materno.getText();
                psta.setString(5, direccion.getText());
                datos[4]=this.direccion.getText();
                psta.setString(6, telefono.getText());
                datos[5]=this.telefono.getText();
                psta.setString(7, email.getText());
                datos[6]=this.email.getText();                
                psta.setString(8, rfc.getText());
                datos[7]=this.rfc.getText();
                modelo.addRow(datos); 
                psta.execute();

                sqlinsertar="INSERT INTO CLIENTE@DBLINKMIGUEL values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, paterno.getText());
                psta.setString(4, materno.getText());
                psta.setString(5, direccion.getText());
                psta.setString(6, telefono.getText());
                psta.setString(7, email.getText());                
                psta.setString(8, rfc.getText());
                psta.execute();
                
                                sqlinsertar="INSERT INTO CLIENTE@DBLINKBETO values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, paterno.getText());
                psta.setString(4, materno.getText());
                psta.setString(5, direccion.getText());
                psta.setString(6, telefono.getText());
                psta.setString(7, email.getText());                
                psta.setString(8, rfc.getText());
                psta.execute();
                
                                sqlinsertar="INSERT INTO CLIENTE@DBLINKHUGO values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, paterno.getText());
                psta.setString(4, materno.getText());
                psta.setString(5, direccion.getText());
                psta.setString(6, telefono.getText());
                psta.setString(7, email.getText());                
                psta.setString(8, rfc.getText());
                psta.execute();
                
                                sqlinsertar="INSERT INTO CLIENTE@DBLINKRICHI values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, paterno.getText());
                psta.setString(4, materno.getText());
                psta.setString(5, direccion.getText());
                psta.setString(6, telefono.getText());
                psta.setString(7, email.getText());                
                psta.setString(8, rfc.getText());
                psta.execute();
                
                                sqlinsertar="INSERT INTO CLIENTE@DBLINKMATA values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, paterno.getText());
                psta.setString(4, materno.getText());
                psta.setString(5, direccion.getText());
                psta.setString(6, telefono.getText());
                psta.setString(7, email.getText());                
                psta.setString(8, rfc.getText());
                psta.execute();
                
                                sqlinsertar="INSERT INTO CLIENTE@DBLINKPROFE values (?,?,?,?,?,?,?,?)";
                psta=conn.prepareStatement(sqlinsertar);
                psta.setString(1, id.getText());
                psta.setString(2, nombre.getText());
                psta.setString(3, paterno.getText());
                psta.setString(4, materno.getText());
                psta.setString(5, direccion.getText());
                psta.setString(6, telefono.getText());
                psta.setString(7, email.getText());                
                psta.setString(8, rfc.getText());
                psta.execute();

                JOptionPane.showMessageDialog(null, nombre.getText()+" "+paterno.getText()+" "+materno.getText()+" ha sido agregado con éxito");
                nombre.setText("");
                paterno.setText("");
                materno.setText("");
                direccion.setText("");
                telefono.setText("");
                email.setText("");
                id.setText("");
                rfc.setText("");
                Guardar.setEnabled(false);
                Agregar.setEnabled(true);
                dispose();
                new Clientes().setVisible(true);


       

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

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

    try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

try {
        conn=Conexion.Enlace(conn);
        if(nombre.getText().trim().length()==0 || paterno.getText().trim().length()==0 || materno.getText().trim().length()==0 || direccion.getText().trim().length()==0 || telefono.getText().trim().length()==0 || rfc.getText().trim().length()==0 || email.getText().trim().length()==0) {
        JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");       
        }else{
            PreparedStatement op=conn.prepareStatement("UPDATE CLIENTE SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"' WHERE ID_CLIENTE ='"+id.getText()+"'");
            op.executeUpdate();
                datos[0]=this.id.getText();
                datos[1]=this.nombre.getText();
                datos[2]=this.paterno.getText();
                datos[3]=this.materno.getText();
                datos[4]=this.direccion.getText();
                datos[5]=this.telefono.getText();
                datos[6]=this.email.getText();
                datos[7]=this.rfc.getText();
                modelo.addRow(datos);
                modelo.removeRow(fila);

            op=conn.prepareStatement("UPDATE CLIENTE@DBLINKMIGUEL SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"' WHERE ID_CLIENTE ='"+id.getText()+"'");
            op.executeUpdate();
            
            op=conn.prepareStatement("UPDATE CLIENTE@DBLINKBETO SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"' WHERE ID_CLIENTE ='"+id.getText()+"'");
            op.executeUpdate();
            
            op=conn.prepareStatement("UPDATE CLIENTE@DBLINKHUGO SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"' WHERE ID_CLIENTE ='"+id.getText()+"'");
            op.executeUpdate();
            
            op=conn.prepareStatement("UPDATE CLIENTE@DBLINKRICHI SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"' WHERE ID_CLIENTE ='"+id.getText()+"'");
            op.executeUpdate();
            
            op=conn.prepareStatement("UPDATE CLIENTE@DBLINKMATA SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"' WHERE ID_CLIENTE ='"+id.getText()+"'");
            op.executeUpdate();
            
            op=conn.prepareStatement("UPDATE CLIENTE@DBLINKPROFE SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', RFC ='"+rfc.getText()+"' WHERE ID_CLIENTE ='"+id.getText()+"'");
            op.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            dispose();
            new Clientes().setVisible(true);

       

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


    }//GEN-LAST:event_GuardarActionPerformed

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed
    this.tablaclientes.setModel(modelo);
        for (int i = 0; i < tablaclientes.getRowCount(); i++) {
        modelo.removeRow(i);
            i-=1;
        }
        
        this.tablaclientes.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            rs=Conexion.tablaClientes(rs);//ejecuta la consulta
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
    }//GEN-LAST:event_MostrarActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        Object [] opciones ={"SI","NO"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"Está a punto de salir de esta pantalla\n¿Desea continuar?","Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {
            if(idcli.getText().equals("1")){
                dispose();
                new Principal().setVisible(true);
            }else{
                dispose();
                new Principal().setVisible(true);
                //new menu2().setVisible(true);
                //menu2.usuario.setText(usuariocl.getText());
                //menu2.idempleado.setText(idcli.getText());
            }
        }
    }//GEN-LAST:event_RegresarActionPerformed

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
        if(!nombre.getText().matches("[A-Z,Ñ,Á,É,Í,Ó,Ú\\s]*")){
           JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
            nombre.setText("");//Limpia campo ciente
            nombre.requestFocus();//Devuelve el curso el inicio del campo
        }
    }//GEN-LAST:event_nombreKeyReleased

    private void paternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paternoKeyReleased
        if(!paterno.getText().matches("[A-Z,Ñ,Á,É,Í,Ó,Ú\\s]*")){
           JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
            paterno.setText("");//Limpia campo ciente
            paterno.requestFocus();//Devuelve el curso el inicio del campo
        }
    }//GEN-LAST:event_paternoKeyReleased

    private void maternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maternoKeyReleased
    if(!materno.getText().matches("[A-Z,Ñ,Á,É,Í,Ó,Ú\\s]*")){
        JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
        materno.setText("");//Limpia campo ciente
        materno.requestFocus();//Devuelve el curso el inicio del campo
    }
    }//GEN-LAST:event_maternoKeyReleased

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
        int limite=13;
        if(rfc.getText().length()>=limite){
            evt.consume();
        }
    }//GEN-LAST:event_rfcKeyTyped

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
    String sqlinserta="SELECT * FROM CLIENTE WHERE NOMBRE = '"+buscar.getText()+"' OR PATERNO ='" + buscar.getText() + "' OR MATERNO ='"+buscar.getText()+"'";
        if(buscar.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"No ha ingresado un criterio de búsqueda");
        }else{
        
        try{
            PreparedStatement pst;
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
            this.tablaclientes.setModel(modelo);
            try {
            for (int i = 0; i < tablaclientes.getRowCount(); i++) {
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
    }//GEN-LAST:event_okActionPerformed

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton Mostrar;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextArea direccion;
    private javax.swing.JTextField email;
    private javax.swing.JLabel fecha;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idcli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField materno;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton ok;
    private javax.swing.JTextField paterno;
    private javax.swing.JTextField rfc;
    private javax.swing.JTable tablaclientes;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField usuariocl;
    // End of variables declaration//GEN-END:variables
}
