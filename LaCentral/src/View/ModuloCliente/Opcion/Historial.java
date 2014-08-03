/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloCliente.Opcion;

import Model.Historiales;
import Model.Personas;
import View.ModuloCliente.DetalleCliente;
import View.ModuloCliente.PrincipalCliente;
import java.util.Vector;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class Historial extends javax.swing.JFrame {

    /**
     * Creates new form Historial
     */
    public Historial() {
        initComponents();
        ocultar();
        actualizar();
        Mostars();
    }

    void ocultar(){
        jButton1.setVisible(false);
        clientejTextField.setVisible(false);
        ultimaComprajTextField.setVisible(false);
        montoTotaljTextField.setVisible(false);
        totaljTextField.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);        
    }
    void mostrar(){
        jButton1.setVisible(true);

        clientejTextField.setVisible(true);
        ultimaComprajTextField.setVisible(true);
        montoTotaljTextField.setVisible(true);
        totaljTextField.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);        
    }
   
    void actualizar(){
        buscarjTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                buscarApellidoMaterno();
                buscarApellidoPaterno();
                buscarNombre();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
            }

        });
    }
    void Mostars()
    {
           for(Personas persona: Controller.PersonasController.ShowPersonas())
            {
            for(Historiales historial: Controller.HistorialesController.ShowHistoriales())
            {
                String idP= String.valueOf(persona.getIdPersona());
                String idH= String.valueOf(historial.getClaveHistorial());
                if(idH.equalsIgnoreCase(idP))
                {
                        DefaultTableModel datos=(DefaultTableModel)clientesjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(historial.getClientes().getClaveCliente());
                        resultado.add(historial.getClientes().getPersonas().getNombre()+" "+
                                historial.getClientes().getPersonas().getApellidoPaterno()+" "
                                +historial.getClientes().getPersonas().getApellidoMaterno());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getMunicipios().getEstados().getEstado());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getMunicipios().getMunicipio());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getDomicilio());
                        if(historial.getClientes().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                    
                }
            
        }// Fin Historiales
       } // Fin Personas    
    }
    void buscarNombre()
    {
           for(Personas persona: Controller.PersonasController.Personas(buscarjTextField.getText()))
            {
            for(Historiales historial: Controller.HistorialesController.ShowHistoriales())
            {
                String idP= String.valueOf(persona.getIdPersona());
                String idH= String.valueOf(historial.getClaveHistorial());
                if(idH.equalsIgnoreCase(idP))
                {
                        DefaultTableModel datos=(DefaultTableModel)clientesjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(historial.getClientes().getClaveCliente());
                        resultado.add(historial.getClientes().getPersonas().getNombre()+" "+
                                historial.getClientes().getPersonas().getApellidoPaterno()+" "
                                +historial.getClientes().getPersonas().getApellidoMaterno());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getMunicipios().getEstados().getEstado());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getMunicipios().getMunicipio());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getDomicilio());
                        if(historial.getClientes().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                }
            
        }// Fin Historiales
       } // Fin Personas    
    }
    void buscarApellidoPaterno()
    {
           for(Personas persona: Controller.PersonasController.PersonasPaterno(buscarjTextField.getText()))
            {
            for(Historiales historial: Controller.HistorialesController.ShowHistoriales())
            {
                String idP= String.valueOf(persona.getIdPersona());
                String idH= String.valueOf(historial.getClaveHistorial());
                if(idH.equalsIgnoreCase(idP))
                {
                        DefaultTableModel datos=(DefaultTableModel)clientesjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(historial.getClientes().getClaveCliente());
                        resultado.add(historial.getClientes().getPersonas().getNombre()+" "+
                                historial.getClientes().getPersonas().getApellidoPaterno()+" "
                                +historial.getClientes().getPersonas().getApellidoMaterno());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getMunicipios().getEstados().getEstado());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getMunicipios().getMunicipio());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getDomicilio());
                        if(historial.getClientes().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                    
                }
            
        }// Fin Historiales
       } // Fin Personas    
    }
    void buscarApellidoMaterno()
    {
           for(Personas persona: Controller.PersonasController.PersonasMaterno(buscarjTextField.getText()))
            {
            for(Historiales historial: Controller.HistorialesController.ShowHistoriales())
            {
                String idP= String.valueOf(persona.getIdPersona());
                String idH= String.valueOf(historial.getClaveHistorial());
                if(idH.equalsIgnoreCase(idP))
                {
                       DefaultTableModel datos=(DefaultTableModel)clientesjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(historial.getClientes().getClaveCliente());
                        resultado.add(historial.getClientes().getPersonas().getNombre()+" "+
                                historial.getClientes().getPersonas().getApellidoPaterno()+" "
                                +historial.getClientes().getPersonas().getApellidoMaterno());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getMunicipios().getEstados().getEstado());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getMunicipios().getMunicipio());
                        resultado.add(historial.getClientes().getPersonas().getDomicilios().getDomicilio());
                        if(historial.getClientes().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                    
                }
            
        }// Fin Historiales
       } // Fin Personas    
    }
    
    void limpiarTabla()
    {
        while (clientesjTable.getRowCount()!=0)
        {
         ((DefaultTableModel)clientesjTable.getModel()).removeRow(0);
        }
    }

    void CargarInfo()
    {
        
           for(Personas persona: Controller.PersonasController.PersonasMaterno(buscarjTextField.getText()))
            {
            for(Historiales historial: Controller.HistorialesController.ShowHistoriales())
            {
                String idP= String.valueOf(persona.getIdPersona());
                String idH= String.valueOf(historial.getClaveHistorial());
                if(idH.equalsIgnoreCase(idP))
                {
                        int selected = clientesjTable.getSelectedRow();              
                        String clave=clientesjTable.getValueAt(selected, 0).toString();
                        String cliente = String.valueOf(historial.getClientes().getClaveCliente());
                        if(clave.equalsIgnoreCase(cliente))
                        {
                            clientejTextField.setText(historial.getClientes().getPersonas().getNombre()+" "
                                    +historial.getClientes().getPersonas().getApellidoPaterno()+" "
                                    +historial.getClientes().getPersonas().getApellidoMaterno());
                            ultimaComprajTextField.setText(String.valueOf(historial.getUltimaCompra().getTime()));
                            montoTotaljTextField.setText(String.valueOf(historial.getMontoTotalUltimaCompra()));
                            totaljTextField.setText(String.valueOf(historial.getTotal()));    
                        }
                        
                }
            
        }// Fin Historiales
       } // Fin Personas                
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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buscarjTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        clientejTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ultimaComprajTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        montoTotaljTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        totaljTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        altaClientejMenuItem = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Historial de Clientes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(163, 220, 236));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_48.png"))); // NOI18N
        jButton1.setText("Ver mas");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        clientesjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cliente", "Estado", "Municipio", "Calle", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        clientesjTable.getColumnModel().getColumn(5).setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        jLabel3.setText("Cliente:");

        clientejTextField.setEnabled(false);

        jLabel4.setText("Ultima Compra:");

        ultimaComprajTextField.setEnabled(false);

        jLabel5.setText("Monto Total:");

        montoTotaljTextField.setEnabled(false);

        jLabel6.setText("Total:");

        totaljTextField.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clientejTextField)
                    .addComponent(ultimaComprajTextField)
                    .addComponent(montoTotaljTextField)
                    .addComponent(totaljTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(93, 93, 93)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(clientejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ultimaComprajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(montoTotaljTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(totaljTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBounds(310, 0, 1200, 640);
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
        jMenu1.setText("Añadir Cliente");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Herramientas.png"))); // NOI18N
        jMenu2.setText("Mantenimiento");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/usuarios.png"))); // NOI18N
        jMenuItem1.setText("Editar Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_delete_48.png"))); // NOI18N
        jMenuItem3.setText("Dar de Baja Cliente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        altaClientejMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_add_48.png"))); // NOI18N
        altaClientejMenuItem.setText("Dar de Alta Cliente");
        altaClientejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaClientejMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(altaClientejMenuItem);

        jMenuBar1.add(jMenu2);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/tabs_48.png"))); // NOI18N
        jMenu6.setText("Historial");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_content_chart_48.png"))); // NOI18N
        jMenu4.setText("Reportes");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_48.png"))); // NOI18N
        jMenuItem2.setText("Listado de Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_content_48.png"))); // NOI18N
        jMenuItem4.setText("Historial de Cliente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/inicio.png"))); // NOI18N
        jMenu7.setText("Volver a Menu Principal");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selected = clientesjTable.getSelectedRow();  
        if(selected>=0)
        {
            String clave=clientesjTable.getValueAt(selected, 0).toString();
            DetalleCliente o  =new DetalleCliente();
            o.Historial(Integer.parseInt(clave));
            o.DetallesClientes(Integer.parseInt(clave));
            o.setVisible(true);
            dispose();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clientesjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesjTableMouseClicked
        mostrar();
        CargarInfo();
    }//GEN-LAST:event_clientesjTableMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new AñadirCliente().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new EditarCliente().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new BajaCliente().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void altaClientejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaClientejMenuItemActionPerformed
        new AltaCliente().setVisible(true);
        dispose();
    }//GEN-LAST:event_altaClientejMenuItemActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        new Historial().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Aqui se ejecutara el codigo para mandar a imprimir
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ReporteCliente nuevo =new ReporteCliente();
        nuevo.setVisible(true);
        nuevo.MostarHistorial();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        Clases.VistasController.RegresarPrincipalCliente();
        dispose();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        new AyudaCliente().setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

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
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem altaClientejMenuItem;
    private javax.swing.JTextField buscarjTextField;
    private javax.swing.JTextField clientejTextField;
    private javax.swing.JTable clientesjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField montoTotaljTextField;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextField totaljTextField;
    private javax.swing.JTextField ultimaComprajTextField;
    // End of variables declaration//GEN-END:variables
}
