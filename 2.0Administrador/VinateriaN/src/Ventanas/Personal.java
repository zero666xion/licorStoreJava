
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
import static Ventanas.Conexion.st;

public class Personal extends javax.swing.JFrame {

    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    int c=0,d=0,e=0;
    String aux="",jornadalaboral="";
    DefaultTableModel modelo = new DefaultTableModel();
    int fila=0;
    String datos[]=new String[11];int idmiguel=0,idmip=0; 
    
    public Personal() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        setLocationRelativeTo(null);
        
        try{
            conn=Conexion.Enlace(conn);
            String MAX="SELECT MAX(ID_PERSONAL) AS ID_PERSONAL FROM PERSONAL";
            Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        d=Integer.parseInt(rs.getString("ID_PERSONAL"));
                    }
                
          
        id.setText(Integer.toString(d+1));
        Eliminar.setEnabled(false);
        Guardar.setEnabled(false);
        Calendar Cal= Calendar.getInstance();
        String fec= Cal.get(Cal.DATE)+"/"+(Cal.get(Cal.MONTH)+1)+"/"+Cal.get(Cal.YEAR);
        fecha.setText(fec);
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);//fin de materiales
        }
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
        
        Direccion.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            Character c = evt.getKeyChar();
            if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
            }
            }});
        this.tablapersonal.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            rs=Conexion.tablaPersonal(rs);//ejecuta la consulta
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
        
        try {
                String sex="SELECT ID_SEXO FROM PERSONAL WHERE ID_PERSONAL = '"+id.getText()+"'";
                PreparedStatement pst;
                pst = conn.prepareStatement(sex);
                rs = pst.executeQuery();
                if(rs.next()){
                        aux=rs.getString("ID_SEXO");
                    }
                
                this.Sexo.removeAllItems();
                rs=st.executeQuery("SELECT * FROM SEXO");
                while (rs.next()){
                this.Sexo.addItem(rs.getString("SEXO"));
            }
                
                } catch (SQLException ex) {
                    Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                this.Puesto.setSelectedItem(null);
                this.Turno.setSelectedItem(null);
                this.Sexo.setSelectedItem(null);
        
        
        tablapersonal.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent Mouse_evt) {
            JTable table =(JTable) Mouse_evt.getSource();
            Point point = Mouse_evt.getPoint();
            int row = table.rowAtPoint(point);
            fila=tablapersonal.getSelectedRow();

            if (Mouse_evt.getClickCount() == 1) {
                id.setText(tablapersonal.getValueAt(fila, 0).toString());
                nombre.setText(tablapersonal.getValueAt(fila,1).toString());
                paterno.setText(tablapersonal.getValueAt(fila,2).toString());
                materno.setText(tablapersonal.getValueAt(fila,3).toString());
                Direccion.setText(tablapersonal.getValueAt(fila,4).toString());
                telefono.setText(tablapersonal.getValueAt(fila,5).toString());
                email.setText(tablapersonal.getValueAt(fila,6).toString());
                Sexo.setSelectedItem(tablapersonal.getValueAt(fila, 7));
                Agregar.setEnabled(false);
                Eliminar.setEnabled(true);
                Guardar.setEnabled(true);
                if(id.getText().equals("1")){
                    Puesto.setSelectedItem(null);
                    Turno.setSelectedItem(null);
                }
                
                
                try {
                String jornada="SELECT ID_JORNADA_LABORAL FROM PERSONAL WHERE ID_PERSONAL = '"+id.getText()+"'";
                PreparedStatement pstr;
                pstr = conn.prepareStatement(jornada);
                rs = pstr.executeQuery();
                if(rs.next()){
                        jornadalaboral=rs.getString("ID_JORNADA_LABORAL");
                    }
                if(jornadalaboral.equals("1")){
                    Puesto.setSelectedItem("DIRECTOR");
                    Turno.setSelectedItem("MIXTO");
                }
                if(jornadalaboral.equals("2")){
                    Puesto.setSelectedItem("ENCARGADO");
                    Turno.setSelectedItem("MATUTINO");
                }
                
                if(jornadalaboral.equals("3")){
                    Puesto.setSelectedItem("ENCARGADO");
                    Turno.setSelectedItem("VESPERTINO");
                }
                
                if(jornadalaboral.equals("4")){
                    Puesto.setSelectedItem("VENDEDOR");
                    Turno.setSelectedItem("MATUTINO");
                }
                
                if(jornadalaboral.equals("5")){
                    Puesto.setSelectedItem("VENDEDOR");
                    Turno.setSelectedItem("VESPERTINO");
                }
                } catch (SQLException ex) {
                    Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        nombre = new javax.swing.JTextField();
        paterno = new javax.swing.JTextField();
        materno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Sexo = new javax.swing.JComboBox<>();
        Puesto = new javax.swing.JComboBox<>();
        Turno = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        Limpiar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        Mostrar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablapersonal = new javax.swing.JTable();
        Regresar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        Sucursal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        jLabel1.setText("\"PERSONAL\"");

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

        paterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paternoActionPerformed(evt);
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

        id.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel7.setText("Dirección.");

        Direccion.setColumns(20);
        Direccion.setRows(5);
        jScrollPane1.setViewportView(Direccion);

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel8.setText("Telefono");

        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel9.setText("Email");

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel10.setText("Seleccione Sexo");

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel11.setText("Seleccione Puesto");

        jLabel12.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel12.setText("Seleccione Turno");

        Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Puesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DIRECTOR", "ENCARGADO", "VENDEDOR" }));

        Turno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATUTINO", "VESPERTINO", "MIXTO", " " }));

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel13.setText("Fecha");

        fecha.setText("jLabel14");

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

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recycle-full.png"))); // NOI18N
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

        Mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload.png"))); // NOI18N
        Mostrar.setText("Mostrar Todo");
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel14.setText("Buscar");

        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        tablapersonal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablapersonal);

        Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atraz.PNG"))); // NOI18N
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel15.setText("Seleccione Sucursal");

        Sucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COACALCO", "ECATEPEC", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ok)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Limpiar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Agregar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Eliminar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Guardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Mostrar))
                                    .addComponent(jScrollPane2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fecha))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(114, 114, 114))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(materno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(paterno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(id))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Puesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(Turno, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Sucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel12)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel15))))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Regresar)))
                        .addGap(19, 19, 19))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(420, 420, 420))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(paterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(materno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(id)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fecha))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Limpiar)
                    .addComponent(Agregar)
                    .addComponent(Eliminar)
                    .addComponent(Guardar)
                    .addComponent(Mostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ok))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Regresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paternoActionPerformed

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

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
    try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

Object [] opciones ={"SI","NO"};
        String idventa="", idjorn="";
        int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Está seguro de Eliminar a "+nombre.getText()+" " +paterno.getText()+" "+materno.getText()+"?", "Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION){
            try {
        
                    
            PreparedStatement op=conn.prepareStatement("UPDATE PERSONAL SET ID_STATUS ='2' WHERE ID_PERSONAL ='"+id.getText()+"'");
            op.executeUpdate();
                        
            op=conn.prepareStatement("UPDATE USUARIOS SET ID_STATUS ='2' WHERE ID_PERSONAL ='"+id.getText()+"'");
            op.executeUpdate();

                try{
                    
                    String MAX="SELECT ID_PERSONAL FROM PERSONAL@DBLINKMIGUEL WHERE NOMBRE='" + nombre.getText() + "' AND PATERNO='"+ paterno.getText() +"' AND MATERNO='"+ materno.getText() +"' AND TELEFONO='"+ telefono.getText()+"'";
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        idmip = Integer.parseInt(rs.getString("ID_PERSONAL"));
                    }
                    }catch(SQLException e){
            
                    }

                op=conn.prepareStatement("UPDATE PERSONAL@DBLINKMIGUEL SET ID_STATUS ='2' WHERE ID_PERSONAL ='" + idmip +"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PERSONAL@DBLINKMATA SET ID_STATUS ='2' WHERE ID_PERSONAL ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PERSONAL@DBLINKPROFE SET ID_STATUS ='2' WHERE ID_PERSONAL ='"+id.getText()+"'");
                op.executeUpdate();

                op=conn.prepareStatement("UPDATE USUARIOS@DBLINKMIGUEL SET ID_STATUS ='2' WHERE ID_PERSONAL ='" + idmip +"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE USUARIOS@DBLINKMATA SET ID_STATUS ='2' WHERE ID_PERSONAL ='"+id.getText()+"'");
                op.executeUpdate();
            
                op=conn.prepareStatement("UPDATE USUARIOS@DBLINKPROFE SET ID_STATUS ='2' WHERE ID_PERSONAL ='"+id.getText()+"'");
                op.executeUpdate();

            JOptionPane.showMessageDialog(null, "Personal exitosamente eliminado");
            dispose();
            new Personal().setVisible(true);
                              
            
            
           } catch (SQLException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
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

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
    nombre.setText("");
            paterno.setText("");
            materno.setText("");
            Direccion.setText("");
            telefono.setText("");
            email.setText("");
            id.setText(Integer.toString(c));
            Eliminar.setEnabled(false);
            Guardar.setEnabled(false);
            Agregar.setEnabled(true);
            Sexo.setSelectedItem(null);
            Puesto.setSelectedItem(null);
            Turno.setSelectedItem(null);
    }//GEN-LAST:event_LimpiarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
                           
   try{
conn=Conexion.Enlace(conn);   
conn.setAutoCommit(false);
conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
conn.commit();

String idsexo="", idjornada="", idpuesto="", idturno="";
        try {
            conn=Conexion.Enlace(conn);
                       
            if(nombre.getText().trim().length()==0 || paterno.getText().trim().length()==0 || materno.getText().trim().length()==0 || Direccion.getText().trim().length()==0 || telefono.getText().trim().length()==0 || email.getText().trim().length()==0 || Sexo.getSelectedItem()==null || Puesto.getSelectedItem()==null || Turno.getSelectedItem()==null){
                JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");
            }else{
            String sqlinserta="SELECT * FROM PERSONAL WHERE NOMBRE = '"+nombre.getText()+"' AND PATERNO ='" + paterno.getText() + "' AND MATERNO = '"+ materno.getText()+"'";
            PreparedStatement pst;
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "El personal que desea agregar, ya existe. \nCorrobore sus datos");
                }else{

                    sqlinserta="SELECT ID_SEXO FROM SEXO WHERE SEXO = '" + Sexo.getSelectedItem().toString()+ "'";
                    pst = conn.prepareStatement(sqlinserta);
                    rs = pst.executeQuery();
                    if(rs.next()){
                        idsexo=rs.getString("ID_SEXO");
                    }
                    
                    sqlinserta="SELECT ID_PUESTO FROM PUESTO WHERE PUESTO = '" + Puesto.getSelectedItem().toString()+ "'";
                    pst = conn.prepareStatement(sqlinserta);
                    rs = pst.executeQuery();
                    if(rs.next()){
                        idpuesto=rs.getString("ID_PUESTO");
                    }
                    
                    sqlinserta="SELECT ID_TURNO FROM TURNO WHERE TURNO = '" + Turno.getSelectedItem().toString()+ "'";
                    pst = conn.prepareStatement(sqlinserta);
                    rs = pst.executeQuery();
                    if(rs.next()){
                        idturno=rs.getString("ID_TURNO");
                    }
                    
                    sqlinserta="SELECT ID_JORNADA_LABORAL FROM JORNADA_LABORAL WHERE ID_PUESTO = '" + idpuesto+ "' AND ID_TURNO = '"+idturno+"'";
                    pst = conn.prepareStatement(sqlinserta);
                    rs = pst.executeQuery();
                    if(rs.next()){
                        idjornada=rs.getString("ID_JORNADA_LABORAL");
                    }
                    String Variable="1";
                    String sqlinsertar="INSERT INTO PERSONAL values (?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, id.getText());
                    datos[0]=id.getText();
                    psta.setString(2, nombre.getText());
                    datos[1]=this.nombre.getText();
                    psta.setString(3, paterno.getText());
                    datos[2]=this.paterno.getText();
                    psta.setString(4, materno.getText());
                    datos[3]=this.materno.getText();
                    psta.setString(5, Direccion.getText());
                    datos[4]=Direccion.getText();
                    psta.setString(6, telefono.getText());
                    datos[5]=this.telefono.getText();
                    psta.setString(7, email.getText());
                    datos[6]=this.email.getText();
                    psta.setString(8, idsexo);
                    datos[7]=idsexo;
                    psta.setString(9, idjornada);
                    datos[8]=idjornada;
                    psta.setString(10, Sucursal.getSelectedItem().toString());
                    datos[9]=this.Sucursal.getSelectedItem().toString();
                    psta.setString(11,Variable);
                    datos[10]=Variable;
                    modelo.addRow(datos); 
                    psta.execute();

                try{
                    conn=Conexion.Enlace(conn);
                    String MAX="SELECT MAX(ID_PERSONAL) AS ID_PERSONAL FROM PERSONAL@DBLINKMIGUEL";
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        idmiguel = Integer.parseInt(rs.getString("ID_PERSONAL"));
                    }
                    }catch(SQLException e){
            
                    }
                    
                    sqlinsertar="INSERT INTO PERSONAL@DBLINKMIGUEL values (?,?,?,?,?,?,?,?,?,?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, Integer.toString(idmiguel+1));
                    psta.setString(2, nombre.getText());
                    psta.setString(3, paterno.getText());
                    psta.setString(4, materno.getText());
                    psta.setString(5, Direccion.getText());
                    psta.setString(6, telefono.getText());
                    psta.setString(7, email.getText());
                    psta.setString(8, idsexo);
                    psta.setString(9, idjornada);
                    psta.setString(10, Sucursal.getSelectedItem().toString());
                    psta.setString(11,Variable);
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO PERSONAL@DBLINKMATA values (?,?,?,?,?,?,?,?,?,?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, id.getText());
                    psta.setString(2, nombre.getText());
                    psta.setString(3, paterno.getText());
                    psta.setString(4, materno.getText());
                    psta.setString(5, Direccion.getText());
                    psta.setString(6, telefono.getText());
                    psta.setString(7, email.getText());
                    psta.setString(8, idsexo);
                    psta.setString(9, idjornada);
                    psta.setString(10, Sucursal.getSelectedItem().toString());
                    psta.setString(11,Variable);
                    psta.execute();
                    
                    sqlinsertar="INSERT INTO PERSONAL@DBLINKPROFE values (?,?,?,?,?,?,?,?,?,?,?)";
                    psta=conn.prepareStatement(sqlinsertar);
                    psta.setString(1, id.getText());
                    psta.setString(2, nombre.getText());
                    psta.setString(3, paterno.getText());
                    psta.setString(4, materno.getText());
                    psta.setString(5, Direccion.getText());
                    psta.setString(6, telefono.getText());
                    psta.setString(7, email.getText());
                    psta.setString(8, idsexo);
                    psta.setString(9, idjornada);
                    psta.setString(10, Sucursal.getSelectedItem().toString());
                    psta.setString(11,Variable);
                    psta.execute();

                    JOptionPane.showMessageDialog(null, nombre.getText()+" "+paterno.getText()+" "+materno.getText()+" ha sido agregado con éxito");
                    nombre.setText("");
                    paterno.setText("");
                    materno.setText("");
                    Direccion.setText("");
                    telefono.setText("");
                    email.setText("");
                    Eliminar.setEnabled(false);
                    Guardar.setEnabled(false);
                    Agregar.setEnabled(true);
                    Puesto.setSelectedItem(null);
                    Sexo.setSelectedItem(null);
                    Turno.setSelectedItem(null);
                    dispose();
                    new Personal().setVisible(true);
                    new Usuarios().setVisible(true);
                    Usuarios.idpersonal.setText(id.getText());


                    
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

String idsexo="", idjornada="", idpuesto="", idturno="";
    try {
        
        conn=Conexion.Enlace(conn);
        if(nombre.getText().trim().length()==0 || paterno.getText().trim().length()==0 || materno.getText().trim().length()==0 || Direccion.getText().trim().length()==0 || telefono.getText().trim().length()==0 || email.getText().trim().length()==0 || Sexo.getSelectedItem()==null || Puesto.getSelectedItem()==null || Turno.getSelectedItem()==null ){
        JOptionPane.showMessageDialog(null,"POR FAVOR, INGRESE LOS DATOS NECESARIOS");       
        }else{
            
                String sqlinserta="SELECT ID_SEXO FROM SEXO WHERE SEXO = '" + Sexo.getSelectedItem().toString()+ "'";
                PreparedStatement pst = conn.prepareStatement(sqlinserta);
                rs = pst.executeQuery();
                if(rs.next()){
                    idsexo=rs.getString("ID_SEXO");
                }
                    
                sqlinserta="SELECT ID_PUESTO FROM PUESTO WHERE PUESTO = '" + Puesto.getSelectedItem().toString()+ "'";
                pst = conn.prepareStatement(sqlinserta);
                rs = pst.executeQuery();
                if(rs.next()){
                    idpuesto=rs.getString("ID_PUESTO");
                }
                    
                sqlinserta="SELECT ID_TURNO FROM TURNO WHERE TURNO = '" + Turno.getSelectedItem().toString()+ "'";
                pst = conn.prepareStatement(sqlinserta);
                rs = pst.executeQuery();
                if(rs.next()){
                    idturno=rs.getString("ID_TURNO");
                }
                    
                sqlinserta="SELECT ID_JORNADA_LABORAL FROM JORNADA_LABORAL WHERE ID_PUESTO = '" + idpuesto+ "' AND ID_TURNO = '"+idturno+"'";
                pst = conn.prepareStatement(sqlinserta);
                rs = pst.executeQuery();
                if(rs.next()){
                    idjornada=rs.getString("ID_JORNADA_LABORAL");
                }

            String Variable="1";
            PreparedStatement op=conn.prepareStatement("UPDATE PERSONAL SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+Direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', ID_SEXO ='"+idsexo+"', ID_JORNADA_LABORAL ='" +idjornada+ "' WHERE ID_PERSONAL ='"+id.getText()+"'");
            op.executeUpdate();
                datos[0]=this.id.getText();
                datos[1]=this.nombre.getText();
                datos[2]=this.paterno.getText();
                datos[3]=this.materno.getText();
                datos[4]=this.Direccion.getText();
                datos[5]=this.telefono.getText();
                datos[6]=this.email.getText();
                datos[7]=idsexo;
                datos[8]=idjornada;
                datos[9]=this.Sucursal.getSelectedItem().toString();
                datos[10]=Variable;
                modelo.addRow(datos);
                modelo.removeRow(fila);

              try{
                    conn=Conexion.Enlace(conn);
                    String MAX="SELECT ID_PERSONAL FROM PERSONAL@DBLINKMIGUEL WHERE NOMBRE='" + nombre.getText() + "' AND PATERNO='"+ paterno.getText() +"' AND MATERNO='"+ materno.getText() +"' AND TELEFONO='"+ telefono.getText()+"'";
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery(MAX);
                    if(rs.next()){
                        idmip = Integer.parseInt(rs.getString("ID_PERSONAL"));
                    }
                    }catch(SQLException e){
            
                    }

                op=conn.prepareStatement("UPDATE PERSONAL@DBLINKMIGUEL SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+Direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', ID_SEXO ='"+idsexo+"', ID_JORNADA_LABORAL ='" +idjornada+ "' WHERE ID_PERSONAL ='" + idmip +"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PERSONAL@DBLINKMATA SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+Direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', ID_SEXO ='"+idsexo+"', ID_JORNADA_LABORAL ='" +idjornada+ "' WHERE ID_PERSONAL ='"+id.getText()+"'");
                op.executeUpdate();
                
                op=conn.prepareStatement("UPDATE PERSONAL@DBLINKPROFE SET NOMBRE ='"+nombre.getText()+"', PATERNO ='"+paterno.getText()+"', MATERNO='"+materno.getText()+"',DIRECCION='"+Direccion.getText()+"', TELEFONO ='"+telefono.getText()+"',CORREO ='"+email.getText()+"', ID_SEXO ='"+idsexo+"', ID_JORNADA_LABORAL ='" +idjornada+ "' WHERE ID_PERSONAL ='"+id.getText()+"'");
                op.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            dispose();
            new Personal().setVisible(true);
                    
            
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

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
            if(!nombre.getText().matches("[A-Z,Ñ,Á,É,Í,Ó,Ú\\s]*")){
                   JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
                   nombre.setText("");//Limpia campo ciente
                   nombre.requestFocus();//Devuelve el curso el inicio del campo
        }
    }//GEN-LAST:event_nombreKeyReleased

    private void telefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyReleased
            if(!telefono.getText().matches("[0-9]*")){
                   JOptionPane.showMessageDialog(null, "Caracter incorrecto. Corrobore su información y vuelva a intentarlo");
                   telefono.setText("");//Limpia campo ciente
                   telefono.requestFocus();//Devuelve el curso el inicio del campo
        }
    }//GEN-LAST:event_telefonoKeyReleased

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
                int limite=10;
        if(telefono.getText().length()>=limite){
            evt.consume();
        }
    }//GEN-LAST:event_telefonoKeyTyped

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

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
    String sqlinserta="SELECT * FROM PERSONAL WHERE NOMBRE = '"+buscar.getText()+"' OR PATERNO ='" + buscar.getText() + "' OR MATERNO ='"+buscar.getText()+"'";
        if(buscar.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"No ha ingresado un criterio de búsqueda");
        }else{
        
        try{
            PreparedStatement pst;
            pst = conn.prepareStatement(sqlinserta);
            rs = pst.executeQuery();
            if(rs.next()){
            this.tablapersonal.setModel(modelo);
            try {
            for (int i = 0; i < tablapersonal.getRowCount(); i++) {
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

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed
    this.tablapersonal.setModel(modelo);
        for (int i = 0; i < tablapersonal.getRowCount(); i++) {
        modelo.removeRow(i);
            i-=1;
        }
        
        this.tablapersonal.setModel(modelo);
        try {
            conn=Conexion.Enlace(conn);//ejecuta la conexion
            rs=Conexion.tablaPersonal(rs);//ejecuta la consulta
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
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton Mostrar;
    private javax.swing.JComboBox<String> Puesto;
    private javax.swing.JButton Regresar;
    private javax.swing.JComboBox<String> Sexo;
    private javax.swing.JComboBox<String> Sucursal;
    private javax.swing.JComboBox<String> Turno;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField email;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField materno;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton ok;
    private javax.swing.JTextField paterno;
    private javax.swing.JTable tablapersonal;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
