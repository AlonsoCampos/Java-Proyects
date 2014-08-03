/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloProveedor;
import Model.Contactos;
import Model.Empresasproveedoras;
import Model.Personas;
import View.ModuloProveedor.Opcion.*;
import java.util.Vector;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alonso
 */
public class PrincipalProveedor extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalProveedor
     */
    public PrincipalProveedor() {
        initComponents();
        actualizar();
        Mostar();
    }
    
      void actualizar(){
        buscarjTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                buscarEmpresa();
                buscarContacto();
                buscarTelefonoContacto();
                buscarApellidoMaterno();
                buscarApellidoPaterno();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
            }

        });
    }
    void buscarEmpresa()
    {
           for(Empresasproveedoras o: Controller.ProveedorController.Lista(buscarjTextField.getText()))
        {
            for(Contactos oo: Controller.ProveedorController.Lista2())
            {
                String s=String.valueOf(o.getClaveEmpresa());
                String ss= String.valueOf(oo.getEmpresasproveedoras().getClaveEmpresa());
                if(s.equalsIgnoreCase(ss))
                {

                        DefaultTableModel datos=(DefaultTableModel)proveedorjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(oo.getEmpresasproveedoras().getRfc());
                        resultado.add(oo.getEmpresasproveedoras().getRazonSocial());
                        resultado.add(oo.getEmpresasproveedoras().getNombre());
                        resultado.add(oo.getPersonas().getNombre()+" "+ oo.getPersonas().getApellidoPaterno()
                                +" "+oo.getPersonas().getApellidoMaterno());
                        resultado.add(oo.getEmpresasproveedoras().getTelefono());
                        resultado.add(oo.getPersonas().getTelefono());
                        if(oo.getEmpresasproveedoras().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                   
                }

            }
        }

    }
    
    void buscarContacto()
    {
          for(Personas o: Controller.ProveedorController.ListaContacto(buscarjTextField.getText()))
        {
            for(Contactos oo: Controller.ProveedorController.Lista2())
            {
                String s=String.valueOf(o.getIdPersona());
                String ss= String.valueOf(oo.getPersonas().getIdPersona());
                if(s.equalsIgnoreCase(ss))
                {

                        DefaultTableModel datos=(DefaultTableModel)proveedorjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(oo.getEmpresasproveedoras().getRfc());
                        resultado.add(oo.getEmpresasproveedoras().getRazonSocial());
                        resultado.add(oo.getEmpresasproveedoras().getNombre());
                        resultado.add(oo.getPersonas().getNombre()+" "+ oo.getPersonas().getApellidoPaterno()
                                +" "+oo.getPersonas().getApellidoMaterno());
                        resultado.add(oo.getEmpresasproveedoras().getTelefono());
                        resultado.add(oo.getPersonas().getTelefono());
                        if(oo.getEmpresasproveedoras().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                   
                }

            }
        }
     
    }
    void buscarApellidoPaterno()
    {
          for(Personas o: Controller.ProveedorController.ListaContactosPaterno(buscarjTextField.getText()))
        {
            for(Contactos oo: Controller.ProveedorController.Lista2())
            {
                String s=String.valueOf(o.getIdPersona());
                String ss= String.valueOf(oo.getPersonas().getIdPersona());
                if(s.equalsIgnoreCase(ss))
                {

                        DefaultTableModel datos=(DefaultTableModel)proveedorjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(oo.getEmpresasproveedoras().getRfc());
                        resultado.add(oo.getEmpresasproveedoras().getRazonSocial());
                        resultado.add(oo.getEmpresasproveedoras().getNombre());
                        resultado.add(oo.getPersonas().getNombre()+" "+ oo.getPersonas().getApellidoPaterno()
                                +" "+oo.getPersonas().getApellidoMaterno());
                        resultado.add(oo.getEmpresasproveedoras().getTelefono());
                        resultado.add(oo.getPersonas().getTelefono());
                        if(oo.getEmpresasproveedoras().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                   
                }

            }
        }
     
    }
    void buscarTelefonoContacto()
    {
          for(Personas o: Controller.ProveedorController.ListaContactosTelefono(buscarjTextField.getText()))
        {
            for(Contactos oo: Controller.ProveedorController.Lista2())
            {
                String s=String.valueOf(o.getIdPersona());
                String ss= String.valueOf(oo.getPersonas().getIdPersona());
                if(s.equalsIgnoreCase(ss))
                {

                        DefaultTableModel datos=(DefaultTableModel)proveedorjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(oo.getEmpresasproveedoras().getRfc());
                        resultado.add(oo.getEmpresasproveedoras().getRazonSocial());
                        resultado.add(oo.getEmpresasproveedoras().getNombre());
                        resultado.add(oo.getPersonas().getNombre()+" "+ oo.getPersonas().getApellidoPaterno()
                                +" "+oo.getPersonas().getApellidoMaterno());
                        resultado.add(oo.getEmpresasproveedoras().getTelefono());
                        resultado.add(oo.getPersonas().getTelefono());
                        if(oo.getEmpresasproveedoras().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                   
                }

            }
        }
     
    }
    void buscarApellidoMaterno()
    {
          for(Personas o: Controller.ProveedorController.ListaContactosMaterno(buscarjTextField.getText()))
        {
            for(Contactos oo: Controller.ProveedorController.Lista2())
            {
                String s=String.valueOf(o.getIdPersona());
                String ss= String.valueOf(oo.getPersonas().getIdPersona());
                if(s.equalsIgnoreCase(ss))
                {

                        DefaultTableModel datos=(DefaultTableModel)proveedorjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(oo.getEmpresasproveedoras().getRfc());
                        resultado.add(oo.getEmpresasproveedoras().getRazonSocial());
                        resultado.add(oo.getEmpresasproveedoras().getNombre());
                        resultado.add(oo.getPersonas().getNombre()+" "+ oo.getPersonas().getApellidoPaterno()
                                +" "+oo.getPersonas().getApellidoMaterno());
                        resultado.add(oo.getEmpresasproveedoras().getTelefono());
                        resultado.add(oo.getPersonas().getTelefono());
                        if(oo.getEmpresasproveedoras().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                   
                }

            }
        }
     
    }
    void Mostar()
    {
           for(Empresasproveedoras o: Controller.ProveedorController.ShowEmpresas())
        {
            for(Contactos oo: Controller.ProveedorController.Lista2())
            {
                String s=String.valueOf(o.getClaveEmpresa());
                String ss= String.valueOf(oo.getEmpresasproveedoras().getClaveEmpresa());
                if(s.equalsIgnoreCase(ss))
                {

                        DefaultTableModel datos=(DefaultTableModel)proveedorjTable.getModel();
                        Vector resultado=new Vector();      
                        resultado.add(oo.getEmpresasproveedoras().getRfc());
                        resultado.add(oo.getEmpresasproveedoras().getRazonSocial());
                        resultado.add(oo.getEmpresasproveedoras().getNombre());
                        resultado.add(oo.getPersonas().getNombre()+" "+ oo.getPersonas().getApellidoPaterno()
                                +" "+oo.getPersonas().getApellidoMaterno());
                        resultado.add(oo.getEmpresasproveedoras().getTelefono());
                        resultado.add(oo.getPersonas().getTelefono());
                        if(oo.getEmpresasproveedoras().isActivo()==true)
                        {
                            resultado.add("Habilitado");
                        }else{
                            resultado.add("Deshabilitado");
                        }
                        datos.addRow(resultado);
                   
                }

            }
        }

    }
    void limpiarTabla()
    {
        while (proveedorjTable.getRowCount()!=0)
        {
         ((DefaultTableModel)proveedorjTable.getModel()).removeRow(0);
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
        proveedorjTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buscarjTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal Proveedor");
        setMaximumSize(new java.awt.Dimension(1510, 1079));
        setMinimumSize(new java.awt.Dimension(1510, 1079));
        setResizable(false);

        proveedorjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RFC", "Razon Social", "Proveedor", "Contacto", "Telefono Provedor", "Telefono Contacto", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(proveedorjTable);
        proveedorjTable.getColumnModel().getColumn(0).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(1).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(2).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(3).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(4).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(5).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(6).setResizable(false);

        jScrollPane1.setBounds(290, 50, 1160, 1030);
        jLayeredPane2.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setBackground(new java.awt.Color(163, 220, 236));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        jMenu1.setText("Añadir");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_48.png"))); // NOI18N
        jMenuItem4.setText("Añadir Empresa o Proveedor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/usuarios.png"))); // NOI18N
        jMenuItem6.setText("Añador Contacto");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Herramientas.png"))); // NOI18N
        jMenu2.setText("Mantenimiento");

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/actualizar.png"))); // NOI18N
        jMenu3.setText("Editar");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_48.png"))); // NOI18N
        jMenuItem1.setText("Empresa o Proveedor");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/usuarios.png"))); // NOI18N
        jMenuItem7.setText("Contacto");
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem7MouseClicked(evt);
            }
        });
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenu2.add(jMenu3);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Eliminar.png"))); // NOI18N
        jMenu8.setText("Dar de Baja");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_48.png"))); // NOI18N
        jMenuItem2.setText("Empresa o Proveedor");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/usuarios.png"))); // NOI18N
        jMenuItem3.setText("Contacto");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jMenu2.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Cancelar.png"))); // NOI18N
        jMenu9.setText("Dar de Alta");

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_48.png"))); // NOI18N
        jMenuItem8.setText("Empresa o Proveedor");
        jMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem8MouseClicked(evt);
            }
        });
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem8);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/usuarios.png"))); // NOI18N
        jMenuItem9.setText("Contacto");
        jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem9MouseClicked(evt);
            }
        });
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem9);

        jMenu2.add(jMenu9);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_content_48.png"))); // NOI18N
        jMenu4.setText("Reportes");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
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

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        Clases.VistasController.RegresarInicio();
        dispose();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenuItem7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MouseClicked
        new EditarContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem7MouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        new EditarProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        new BajaProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        new BajaContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem8MouseClicked
        new AltaProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem8MouseClicked

    private void jMenuItem9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MouseClicked
        new AltaContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        new ReporteProveedor().setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        new AyudaProveedor().setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new AñadirProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new AñadirContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new EditarProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new EditarContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new BajaProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new BajaContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new AltaProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new AltaContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalProveedor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable proveedorjTable;
    // End of variables declaration//GEN-END:variables
}
