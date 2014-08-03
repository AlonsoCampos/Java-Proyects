/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Clientes;
import Model.Historiales;
import View.ModuloVentas.Opcion.AñadirVenta;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class SeleccionarCliente extends javax.swing.JFrame {

    /**
     * Creates new form SeleccionarDireccion
     */
    public SeleccionarCliente() {
        initComponents();
        mostar();
    }
    void mostar()
    {
        List<Historiales>consultar = Controller.HistorialesController.ShowHistoriales();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)clientesjTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Historiales registro=(Historiales)elemento.next();
        resultado.add(registro.getClaveHistorial());
        resultado.add(registro.getClientes().getPersonas().getNombre()+" "+registro.getClientes().getPersonas()
                .getApellidoPaterno()+" "+registro.getClientes().getPersonas().getApellidoPaterno());
        if(registro.getClientes().isTipoCliente()==true)
        {
            resultado.add("Cliente Frecuente");
        }
        else
        {
            resultado.add("Cliente Ocasional");
        }
        resultado.add(registro.getClientes().getPersonas().getTelefono());
        
        if(registro.getClientes().isActivo()==true)
        {
            resultado.add("Habilitado");
        }
        else
        {
            resultado.add("Deshabilitado");
        }
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
        public String CargarInfo()
    {
        for(Clientes cliente: Controller.ClientesController.ShowClientes())
        {
            for(Historiales historial: Controller.HistorialesController.ShowHistoriales())
            {
                String cli=String.valueOf(cliente.getClaveCliente());
                String his= String.valueOf(historial.getClientes().getClaveCliente());
                    if(cli.equalsIgnoreCase(his))
                    {
                        int selected = clientesjTable.getSelectedRow();    
                        String codigo=clientesjTable.getValueAt(selected, 0).toString();
                        if(codigo.equalsIgnoreCase(codigo))
                        {
                            String nombre=clientesjTable.getValueAt(selected, 1).toString();
                            return nombre;
                        }
                    }
                }
        }
        return null;
    }
   
    public static Clientes cliente;
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
        clientesjTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Elige Direccion");
        setResizable(false);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Ima/Fondo_2.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        clientesjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cliente", "Tipo", "Telefono", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientesjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientesjTable);
        clientesjTable.getColumnModel().getColumn(0).setResizable(false);
        clientesjTable.getColumnModel().getColumn(1).setResizable(false);
        clientesjTable.getColumnModel().getColumn(2).setResizable(false);
        clientesjTable.getColumnModel().getColumn(3).setResizable(false);
        clientesjTable.getColumnModel().getColumn(4).setResizable(false);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(!CargarInfo().isEmpty())
       {
            int selected = clientesjTable.getSelectedRow();                  
            String direccion=clientesjTable.getValueAt(selected, 0).toString();           
            AñadirVenta.cliente=Controller.HistorialesController.BusquedaClave(Integer.parseInt(direccion));
            AñadirVenta.clientejTextField.setText(CargarInfo());
            AñadirVenta.jRadioButton1.setEnabled(true);
            AñadirVenta.jRadioButton2.setEnabled(true);
            dispose();
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Error no se ha selecionado ningun registro");
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clientesjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesjTableMouseClicked
                
    }//GEN-LAST:event_clientesjTableMouseClicked

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
            java.util.logging.Logger.getLogger(SeleccionarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionarCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable clientesjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
}