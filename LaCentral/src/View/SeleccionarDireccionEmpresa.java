/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Direcciones;
import Model.Domicilios;
import View.ModuloCliente.Opcion.AñadirCliente;
import View.ModuloCliente.Opcion.EditarCliente;
import View.ModuloProveedor.Opcion.AñadirProveedor;
import View.ModuloProveedor.Opcion.EditarProveedor;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class SeleccionarDireccionEmpresa extends javax.swing.JFrame {

    /**
     * Creates new form SeleccionarDireccion
     */
    public SeleccionarDireccionEmpresa() {
        initComponents();
        mostar();
    }
    void mostar()
    {
        List<Direcciones>consultar = Controller.DireccionController.showDirecciones();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)direccionesjTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Direcciones registro=(Direcciones)elemento.next();
        resultado.add(registro.getClaveDireccion());
        resultado.add(registro.getCalle());
        resultado.add(registro.getNumeroInterno());
        resultado.add(registro.getNumeroExterno());
        resultado.add(registro.getEstados().getEstado());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
    public String CargarInfo()
    {
          int selected = direccionesjTable.getSelectedRow();        
          if(direccionesjTable.isRowSelected(selected))
          {
            String direccion=direccionesjTable.getValueAt(selected, 1).toString();
            String numeroIn=direccionesjTable.getValueAt(selected, 2).toString();
            String numeroEx=direccionesjTable.getValueAt(selected, 3).toString();
            String domicilio=direccion+" "+numeroIn+" "+numeroEx+" ";
            return domicilio;
          }
            else
          {
              return null;
          }           
    }
   
    /*
     * Nota en este caso se esta utilizando 
     * las tablas Direcciones y Domicilios
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        direccionesjTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        seleccionarjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Elige Direccion");
        setResizable(false);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Ima/Fondo_2.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        jButton1.setText("Seleccionar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
                EditarCliente(evt);
            }
        });

        direccionesjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Calle", "Numero Interno", "Numero Externo", "Municipio", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(direccionesjTable);
        direccionesjTable.getColumnModel().getColumn(0).setResizable(false);
        direccionesjTable.getColumnModel().getColumn(1).setResizable(false);
        direccionesjTable.getColumnModel().getColumn(2).setResizable(false);
        direccionesjTable.getColumnModel().getColumn(3).setResizable(false);
        direccionesjTable.getColumnModel().getColumn(4).setResizable(false);
        direccionesjTable.getColumnModel().getColumn(5).setResizable(false);

        jButton2.setText("Agregar Nueva Direccion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        seleccionarjButton.setText("Seleccionar");
        seleccionarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionarjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(seleccionarjButton)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
        );

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new DireccionEmpresa().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       CargarInfo();
       if(!CargarInfo().isEmpty())
       {
            int selected = direccionesjTable.getSelectedRow();                  
            String direccion=direccionesjTable.getValueAt(selected, 0).toString();
            Direcciones direc = Controller.DireccionController.BuscarDireccion(Integer.parseInt(direccion));
            AñadirProveedor.claveDir=direc;
            AñadirProveedor.direccionjTextArea.setText(CargarInfo());
            dispose();
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Error no se ha selecionado ningun registro");
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EditarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarCliente
       
    }//GEN-LAST:event_EditarCliente

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void seleccionarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarjButtonActionPerformed
       if(!CargarInfo().isEmpty())
       {
            int selected = direccionesjTable.getSelectedRow();                  
            String direccion=direccionesjTable.getValueAt(selected, 0).toString();
            Direcciones direc = Controller.DireccionController.BuscarDireccion(Integer.parseInt(direccion));
            EditarProveedor.claveDir=direc;
            EditarProveedor.direccionjTextArea.setText(CargarInfo());
            dispose();
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Error no se ha selecionado ningun registro");
       }
    }//GEN-LAST:event_seleccionarjButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionarDireccionEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarDireccionEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarDireccionEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarDireccionEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionarDireccionEmpresa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable direccionesjTable;
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private org.edisoncor.gui.panel.Panel panel1;
    public javax.swing.JButton seleccionarjButton;
    // End of variables declaration//GEN-END:variables
}
