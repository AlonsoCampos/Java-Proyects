/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloProducto;
import Model.Categorias;
import Model.Detallesproductos;
import Model.Marcas;
import Model.Productos;
import View.ModuloProducto.Opcion.*;
import java.util.Vector;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alonso
 */
public class PrincipalProducto extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalProducto
     */
    public PrincipalProducto() {
        initComponents();
        actualizar();
        Mostar();
//        PermisosContador(activoContador);
//        PermisoCajero(activoCajero);
    }
    void actualizar(){
        buscarTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                buscarCategorias();
                buscarMarca();
                buscarProducto();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
            }

        });
    }
    void buscarProducto()
    {
           for(Productos producto: Controller.ProductosController.Productos(buscarTextField.getText()))
        {
            for(Detallesproductos detalles: Controller.DetallesProductosController.showDetallesproductos())
            {
                String s=String.valueOf(producto.getClaveProducto());
                String ss= String.valueOf(detalles.getProductos().getClaveProducto());
                if(s.equalsIgnoreCase(ss))
                {

                        DefaultTableModel datos=(DefaultTableModel)productosjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(detalles.getProductos().getNombre());
                        resultado.add(detalles.getCategorias().getCategoria());
                        resultado.add(detalles.getExistencias());
                        resultado.add(detalles.getPrecioUnitario());
                        resultado.add(detalles.getCalidades().getCalidad());
                        resultado.add(detalles.getMarcas().getMarca());
                        datos.addRow(resultado);
                   
                }

            }
        }

    }
    void buscarMarca()
    {
           for(Productos producto: Controller.ProductosController.ShowProductos())
        {
            for(Detallesproductos detalles: Controller.DetallesProductosController.showDetallesproductos())
            {
                String produc=String.valueOf(producto.getClaveProducto());
                String detallesP= String.valueOf(detalles.getProductos().getClaveProducto());
                if(produc.equalsIgnoreCase(detallesP))
                {
                    for(Marcas marca: Controller.MarcasController.Marca(buscarTextField.getText()))
                    {
                        String marc= String.valueOf(marca.getClaveMarca());
                        if(marc.equalsIgnoreCase(detallesP))
                        {
                            DefaultTableModel datos=(DefaultTableModel)productosjTable.getModel();
                            Vector resultado=new Vector();      
                            resultado.add(detalles.getProductos().getNombre());
                            resultado.add(detalles.getCategorias().getCategoria());
                            resultado.add(detalles.getExistencias());
                            resultado.add(detalles.getPrecioUnitario());
                            resultado.add(detalles.getCalidades().getCalidad());
                            resultado.add(detalles.getMarcas().getMarca());
                            datos.addRow(resultado);
                       }
                    }
                }

            }
        }

    }
        void buscarCategorias()
    {
           for(Productos producto: Controller.ProductosController.ShowProductos())
        {
            for(Detallesproductos detalles: Controller.DetallesProductosController.showDetallesproductos())
            {
                String produc=String.valueOf(producto.getClaveProducto());
                String detallesP= String.valueOf(detalles.getProductos().getClaveProducto());
                if(produc.equalsIgnoreCase(detallesP))
                {
                    for(Categorias  categori: Controller.CategoriasController.Categorias(buscarTextField.getText()))
                    {
                        String cat= String.valueOf(categori.getClaveCategoria());
                        if(cat.equalsIgnoreCase(detallesP))
                        {
                            DefaultTableModel datos=(DefaultTableModel)productosjTable.getModel();
                            Vector resultado=new Vector();      
                            resultado.add(detalles.getProductos().getNombre());
                            resultado.add(detalles.getCategorias().getCategoria());
                            resultado.add(detalles.getExistencias());
                            resultado.add(detalles.getPrecioUnitario());
                            resultado.add(detalles.getCalidades().getCalidad());
                            resultado.add(detalles.getMarcas().getMarca());
                            datos.addRow(resultado);
                       }
                    }
                }

            }
        }

    }
void Mostar()
    {
           for(Productos producto: Controller.ProductosController.ShowProductos())
        {
            for(Detallesproductos detalles: Controller.DetallesProductosController.showDetallesproductos())
            {
                String produc=String.valueOf(producto.getClaveProducto());
                String detallesP= String.valueOf(detalles.getProductos().getClaveProducto());
                if(produc.equalsIgnoreCase(detallesP))
                {
                            DefaultTableModel datos=(DefaultTableModel)productosjTable.getModel();
                            Vector resultado=new Vector();      
                            resultado.add(detalles.getProductos().getNombre());
                            resultado.add(detalles.getCategorias().getCategoria());
                            resultado.add(detalles.getExistencias());
                            resultado.add(detalles.getPrecioUnitario());
                            resultado.add(detalles.getCalidades().getCalidad());
                            resultado.add(detalles.getMarcas().getMarca());
                            datos.addRow(resultado);
                }

            }
        }

    }
    void limpiarTabla()
    {
        while (productosjTable.getRowCount()!=0)
        {
         ((DefaultTableModel)productosjTable.getModel()).removeRow(0);
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

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        productosjTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        buscarTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        homejMenu = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Principal Productos");
        setMaximumSize(new java.awt.Dimension(1510, 1100));
        setMinimumSize(new java.awt.Dimension(1510, 1100));
        setResizable(false);

        productosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Categoria", "Cantidad", "Precio Unitario", "Calidad", "Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productosjTable);
        productosjTable.getColumnModel().getColumn(0).setResizable(false);
        productosjTable.getColumnModel().getColumn(1).setResizable(false);
        productosjTable.getColumnModel().getColumn(2).setResizable(false);
        productosjTable.getColumnModel().getColumn(3).setResizable(false);
        productosjTable.getColumnModel().getColumn(4).setResizable(false);
        productosjTable.getColumnModel().getColumn(5).setResizable(false);

        jScrollPane1.setBounds(350, 50, 1160, 1030);
        jLayeredPane2.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setBackground(new java.awt.Color(163, 220, 236));

        jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        jLabel.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel)
                    .addComponent(buscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBounds(930, 0, 580, 50);
        jLayeredPane2.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Ima/Fondo.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setBounds(0, 0, 1510, 1080);
        jLayeredPane2.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1510, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/agregar.png"))); // NOI18N
        jMenu1.setText("Añadir Producto");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Herramientas.png"))); // NOI18N
        jMenu2.setText("Mantenimiento");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_48.png"))); // NOI18N
        jMenuItem1.setText("Editar Producto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_delete_48.png"))); // NOI18N
        jMenuItem2.setText("Dar de Baja Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_add_48.png"))); // NOI18N
        jMenuItem3.setText("Dar de Alta Producto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/tabs_48.png"))); // NOI18N
        jMenu6.setText("Detalles de Producto");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/tabs_48.png"))); // NOI18N
        jMenuItem4.setText("Calidad de Producto");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/tabs_48.png"))); // NOI18N
        jMenuItem5.setText("Categoria de Producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/tabs_48.png"))); // NOI18N
        jMenuItem6.setText("Marcas de Producto");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar1.add(jMenu6);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_content_chart_48.png"))); // NOI18N
        jMenu4.setText("Reportes");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_48.png"))); // NOI18N
        jMenuItem7.setText("Inventario");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_content_48.png"))); // NOI18N
        jMenuItem8.setText("Productos mas vendidos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        homejMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/inicio.png"))); // NOI18N
        homejMenu.setText("Volver a Menu Principal");
        homejMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homejMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(homejMenu);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/ayuda.png"))); // NOI18N
        jMenu5.setText("Ayuda");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new AñadirProducto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new EditarProducto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new BajaProducto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new AltaProducto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        DetallesProducto nuevo =new DetallesProducto();
        
        nuevo.setVisible(true);
        nuevo.ViewCalidad();
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        DetallesProducto nuevo =new DetallesProducto();
        nuevo.setVisible(true);
        nuevo.ViewCategoria();
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        DetallesProducto nuevo =new DetallesProducto();
        nuevo.setVisible(true);
        nuevo.ViewMarca();
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        new ReporteProducto().setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void homejMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homejMenuMouseClicked
        Clases.VistasController.RegresarInicio();
        dispose();
    }//GEN-LAST:event_homejMenuMouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        new AyudaProducto().setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //Aqui va el codigo para imprimir
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       new ReporteProducto().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalProducto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarTextField;
    private javax.swing.JMenu homejMenu;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable productosjTable;
    // End of variables declaration//GEN-END:variables
}
