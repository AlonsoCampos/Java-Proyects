/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UsuarioController;
import View.ModuloVentas.PrincipalVentas;
import View.ModuloProducto.PrincipalProducto;
import View.ModuloProveedor.PrincipalProveedor;
import View.ModuloCliente.PrincipalCliente;
import View.ModuloUsuario.PrincipalUsuario;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.edisoncor.gui.util.Avatar;

/**
 *
 * @author Alonso
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        MenuOpciones();
    }
    
    
    public void MenuOpciones()
    {
        List avatares = new ArrayList();
        
                avatares.add(new Avatar("Productos",loadImage("/ima/productos.jpg")));            
                avatares.add(new Avatar("Clientes",loadImage("/ima/Clientes.jpg")));
                avatares.add(new Avatar("Ventas",loadImage("/ima/Ventas.jpg")));
                avatares.add(new Avatar("Proveedores",loadImage("/ima/provedores.jpg")));
                avatares.add(new Avatar("Perfil Usuario",loadImage("/ima/perfil usuario.jpg")));
                avatares.add(new Avatar("Cerrar Sesión",loadImage("/ima/Salir.jpg")));
                avatares.add(new Avatar("Acerca de",loadImage("/ima/Original.png")));
                panelAvatarChooser1.setAvatars(avatares);        
   }
    private static Image loadImage(String FileName){
        try {
            return ImageIO.read(JFrame.class.getResource(FileName));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    public static String tipo;
    public int Modulo(int index){
        switch(index)
                 {
                       case 0:
                           new PrincipalProducto().setVisible(true);
                           dispose();
                           break;
                       case 1:                     
                           new PrincipalCliente().setVisible(true);
                           dispose();
                           break;
                       case 2:
                           new PrincipalVentas().setVisible(true);
                           dispose();
                           break;
                       case 3:
                           new PrincipalProveedor().setVisible(true);
                           dispose();
                           break;
                       case 4:
                           new PrincipalUsuario().setVisible(true);
                           dispose();
                           break;
                       case 5:
                           // Este es la interfaz de Salir
                           JOptionPane.showMessageDialog(null, "Cerrando sesión","Sistema Central", JOptionPane.INFORMATION_MESSAGE);
                           new Login().setVisible(true);
                           /*Tambien podemos bloquear la pantalla Principal
                            * con el patron Singleton para que necesarimente
                            * no pueda acceder sino se registra
                            */
                           dispose();
                           break;
                       case 6:
                           // Este es la interfaz de Salir
                           new AcercaDe().setVisible(true);
                           break;
                 }
        return index;
    }
    /*
    public int Modulo(int index)
    {        
         switch(tipo)
            {
             case "Administrador":
                 
                break;
            case "Contador":
                 
                switch(index)
                 {
                       case 0:
                           PrincipalProducto.activoContador=false;
                           new PrincipalProducto().setVisible(true);
                           dispose();
                           break;
                       case 1:                           
                           PrincipalCliente.activoContador=false;
                           new PrincipalCliente().setVisible(true);
                           dispose();
                           break;
                       case 2:
                           PrincipalVentas.activoContador=false;
                           new PrincipalVentas().setVisible(true);
                           dispose();
                           break;
                       case 3:
                           PrincipalProveedor.activoContador=false;
                           new PrincipalProveedor().setVisible(true);
                           dispose();
                           break;
                       case 4:
                           PrincipalUsuario.activoContador=false;
                          new PrincipalUsuario().setVisible(true);
                          dispose();
                           break;
                       case 5:
                           // Este es la interfaz de Salir
                           JOptionPane.showMessageDialog(null, "Cerrando sesión","Sistema Central", JOptionPane.INFORMATION_MESSAGE);
                           new Login().setVisible(true);
                           /*Tambien podemos bloquear la pantalla Principal
                            * con el patron Singleton para que necesarimente
                            * no pueda acceder sino se registra
                            
                           dispose();
                           break;
                       case 6:
                           // Este es la interfaz de Salir
                           new AcercaDe().setVisible(true);
                           break;
                 }
                break;
            case "Cajero":
                 switch(index)
                 {
                       case 0:
                           PrincipalProducto.activoContador=true;
                           PrincipalProducto.activoCajero=false;
                           new PrincipalProducto().setVisible(true);
                           dispose();
                           break;
                       case 1:
                           PrincipalCliente.activoContador=true;
                           //Se utiliza false para desabilitar los demas componentes de la interfaz
                           PrincipalCliente.accesoCajero=false;
                           new PrincipalCliente().setVisible(true);
                           dispose();
                           break;
                       case 2:
                           PrincipalVentas.activoContador=true;
                           PrincipalVentas.activoCajero=false;
                           new PrincipalVentas().setVisible(true);
                           dispose();
                           break;
                       case 3:
                           PrincipalProveedor.activoContador=true;
                           PrincipalProveedor.activoCajero=false;
                           new PrincipalProveedor().setVisible(true);
                           dispose();
                           break;
                       case 4:
                           PrincipalUsuario.activoContador=true;
                           PrincipalUsuario.activoCajero=false;
                          new PrincipalUsuario().setVisible(true);
                          dispose();
                           break;
                       case 5:
                           // Este es la interfaz de Salir
                           JOptionPane.showMessageDialog(null, "Cerrando sesión","Sistema Central", JOptionPane.INFORMATION_MESSAGE);
                           new Login().setVisible(true);
                           /*Tambien podemos bloquear la pantalla Principal
                            * con el patron Singleton para que necesarimente
                            * no pueda acceder sino se registra
                            
                           dispose();
                           break;
                       case 6:
                           // Este es la interfaz de Salir
                           new AcercaDe().setVisible(true);
                           break;
                 }
                break;
        }
         
        return index;        
    }
    /*
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        panelAvatarChooser1 = new org.edisoncor.gui.panel.PanelAvatarChooser();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setMaximumSize(new java.awt.Dimension(1507, 1131));
        setMinimumSize(new java.awt.Dimension(1507, 1131));
        setResizable(false);

        panelAvatarChooser1.setBackground(new java.awt.Color(255, 255, 255));
        panelAvatarChooser1.setColorPrimario(new java.awt.Color(142, 225, 235));
        panelAvatarChooser1.setColorSecundario(new java.awt.Color(223, 244, 237));
        panelAvatarChooser1.setGradiente(org.edisoncor.gui.panel.Panel.Gradiente.ESQUINA_2);
        panelAvatarChooser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Ima/Fondo_2.png"))); // NOI18N
        panelAvatarChooser1.setOpaque(true);
        panelAvatarChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAvatarChooser1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelAvatarChooser1MouseEntered(evt);
            }
        });
        panelAvatarChooser1.setBounds(290, 0, 1220, 1080);
        jLayeredPane2.add(panelAvatarChooser1, javax.swing.JLayeredPane.PALETTE_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Ima/Fondo.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setBounds(0, 0, 1510, 1080);
        jLayeredPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1507, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelAvatarChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAvatarChooser1MouseClicked
        /*
         * En este evento se realizara la evaluacion 
         * del elemento que esta siendo seleccionado para 
         * que puede ser redireccionado al elemento que esta 
         * siendo seleccionado
         */
        int eleccion =JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres entrar a este modulo"
                + "?"+"\n "+ panelAvatarChooser1.getSelectedtitulo());
        if(eleccion==0)
        {
            int index =panelAvatarChooser1.getAvatarIndex();
            Modulo(index);
        }
        
        //Modulo(numero);
        //Modulo(panelAvatarChooser1.getSelectedAvatar().getTitulo());
        //JOptionPane.showMessageDialog(rootPane, panelAvatarChooser1.getSelectedAvatar().getTitulo());
        
    }//GEN-LAST:event_panelAvatarChooser1MouseClicked

    private void panelAvatarChooser1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAvatarChooser1MouseEntered
        /* En este evento se recorrera todos los elementos que
         * hay en el panelavatarchoser para que cuando sea clickeado 
         * nos redireccione al elemento deseado
         */
        
        
         
    }//GEN-LAST:event_panelAvatarChooser1MouseEntered

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane2;
    private org.edisoncor.gui.panel.Panel panel1;
    public org.edisoncor.gui.panel.PanelAvatarChooser panelAvatarChooser1;
    // End of variables declaration//GEN-END:variables
}
