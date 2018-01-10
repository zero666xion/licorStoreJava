
package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);      
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Personal = new javax.swing.JButton();
        Proveedores = new javax.swing.JButton();
        Clientes = new javax.swing.JButton();
        Productos = new javax.swing.JButton();
        Inventario = new javax.swing.JButton();
        Usuarios = new javax.swing.JButton();
        MostrarCompras = new javax.swing.JButton();
        MostrarVentas = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        jLabel1.setText("\"ADMINISTRADOR\"");

        Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.PNG"))); // NOI18N
        Personal.setText("Personal");
        Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonalActionPerformed(evt);
            }
        });

        Proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Relationship-icon.png"))); // NOI18N
        Proveedores.setText("Proveedores");
        Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedoresActionPerformed(evt);
            }
        });

        Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clients-icon.png"))); // NOI18N
        Clientes.setText("Clientes");
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });

        Productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/123.png"))); // NOI18N
        Productos.setText("Productos");
        Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductosActionPerformed(evt);
            }
        });

        Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/codigodebarra.png"))); // NOI18N
        Inventario.setText("Inventario");
        Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioActionPerformed(evt);
            }
        });

        Usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/unlock.png"))); // NOI18N
        Usuarios.setText("Usuarios / Contraseñas");
        Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosActionPerformed(evt);
            }
        });

        MostrarCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas.PNG"))); // NOI18N
        MostrarCompras.setText("Mostrar Compras");
        MostrarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarComprasActionPerformed(evt);
            }
        });

        MostrarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bar-chart.png"))); // NOI18N
        MostrarVentas.setText("Mostrar Ventas");
        MostrarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarVentasActionPerformed(evt);
            }
        });

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/shut-down.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(MostrarCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MostrarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Personal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Personal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Proveedores)
                    .addComponent(Clientes))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MostrarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MostrarCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonalActionPerformed
        this.setVisible(false);
        new Personal().setVisible(true);     
    }//GEN-LAST:event_PersonalActionPerformed

    private void ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedoresActionPerformed
        this.setVisible(false);
        new Proveedores().setVisible(true);
    }//GEN-LAST:event_ProveedoresActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        this.setVisible(false);
        new Clientes().setVisible(true);
    }//GEN-LAST:event_ClientesActionPerformed

    private void ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductosActionPerformed
        this.setVisible(false);
        new Productos().setVisible(true);
    }//GEN-LAST:event_ProductosActionPerformed

    private void InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioActionPerformed
        this.setVisible(false);
        new Inventario().setVisible(true);
    }//GEN-LAST:event_InventarioActionPerformed

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosActionPerformed
        this.setVisible(false);
        new Usersypasswords().setVisible(true);
    }//GEN-LAST:event_UsuariosActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
            Object [] opciones ={"SI","NO"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Seguro que desea cerrar sesión?","Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION){
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_SalirActionPerformed

    private void MostrarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarComprasActionPerformed
        this.setVisible(false);
        new Compras().setVisible(true);
    }//GEN-LAST:event_MostrarComprasActionPerformed

    private void MostrarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarVentasActionPerformed
            this.setVisible(false);
        new Ventas().setVisible(true);
    }//GEN-LAST:event_MostrarVentasActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clientes;
    private javax.swing.JButton Inventario;
    private javax.swing.JButton MostrarCompras;
    private javax.swing.JButton MostrarVentas;
    private javax.swing.JButton Personal;
    private javax.swing.JButton Productos;
    private javax.swing.JButton Proveedores;
    private javax.swing.JButton Salir;
    private javax.swing.JButton Usuarios;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
