package Ventanas;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.edisoncor.gui.util.WindowsUtil;

public class SPLASHSCREEM extends javax.swing.JFrame implements Runnable {
Login fss = new Login();
    Thread hilo;
    
    public SPLASHSCREEM() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pbSplashScreen = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BETADEVELOPERS.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 6, Short.MAX_VALUE))
            .addComponent(pbSplashScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(pbSplashScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar pbSplashScreen;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        this.setVisible(true);
        WindowsUtil.makeWindowsOpacity(this,0.6f);
    try {
        for(int i=0; i<100;i++){
        pbSplashScreen.setValue(i);
            hilo.sleep(50);}
    } catch (InterruptedException ex) {
        Logger.getLogger(SPLASHSCREEM.class.getName()).log(Level.SEVERE, null, ex);
    }
 this.dispose();     
 fss.setVisible(true);
}
}