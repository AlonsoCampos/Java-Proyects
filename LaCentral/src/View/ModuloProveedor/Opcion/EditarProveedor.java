/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloProveedor.Opcion;

import Model.Direcciones;
import Model.Empresasproveedoras;
import View.SeleccionarDireccionEmpresa;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class EditarProveedor extends javax.swing.JFrame {

    /**
     * Creates new form EditarProveedor
     */
    public EditarProveedor() {
        initComponents();
        actualizar();
        Mostrar();
    }
        boolean ValidarProveedor()
    {
        if(empresajTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "No puede dejar el nombre de la empresa vacio"
                    ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(empresajTextField.getText().length()>=45)
        {
            JOptionPane.showMessageDialog(null, "No sobrepasar los 12 caracteres para el nombre de la empresa"
                    ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(rfcjTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "No puede dejar el RFC de la empresa vacio"
                    ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(rfcjTextField.getText().length()<12)
        {
            JOptionPane.showMessageDialog(null, "No sobrepasar los 12 caracteres para el RFC"
                    ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(rfcjTextField.getText().length()>12)
        {
            JOptionPane.showMessageDialog(null, "No sobrepasar los 12 caracteres para el RFC"
                    ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(telefonojTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "No puede dejar el telefono vacio"
                    ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(telefonojTextField.getText().length()<12)
        {
            JOptionPane.showMessageDialog(null, "Tienes que ingresar 12 caracteres al menos para el telefono","Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(telefonojTextField.getText().length()<12)
        {
            JOptionPane.showMessageDialog(null, "Tienes que ingresar al menos 12 caracteres para el telefono","Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(razonSocialjTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "No puede dejar vacio la razion social"
                    ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(direccionjTextArea.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "No puede dejar vacio la direccion"
                    ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            return true;
        }
    }
         void actualizar(){
        buscarjTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                buscarEmpresa();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
            }

        });
    }
     void Mostrar()
    {  
            for(Empresasproveedoras o: Controller.EmpresaProveedoraController.showEmpresa())
        {
                        DefaultTableModel datos=(DefaultTableModel)proveedorjTable.getModel();
                        Vector resultado=new Vector();
                        
                            resultado.add(o.getClaveEmpresa());
                            resultado.add(o.getNombre());
                            resultado.add(o.getRfc());
                            resultado.add(o.getTelefono());
                            resultado.add(o.getRazonSocial());
                            resultado.add("Habilitado");
                            datos.addRow(resultado);
        }
    }
    void buscarEmpresa()
    {
           for(Empresasproveedoras o: Controller.ProveedorController.Lista(buscarjTextField.getText()))
        {
             
                        DefaultTableModel datos=(DefaultTableModel)proveedorjTable.getModel();
                        Vector resultado=new Vector();
                        
                            resultado.add(o.getClaveEmpresa());
                            resultado.add(o.getNombre());
                            resultado.add(o.getRfc());
                            resultado.add(o.getTelefono());
                            resultado.add(o.getRazonSocial());
                            resultado.add("Habilitado");
                            datos.addRow(resultado);
        }
    }
    void limpiarTabla()
    {
        while (proveedorjTable.getRowCount()!=0)
        {
         ((DefaultTableModel)proveedorjTable.getModel()).removeRow(0);
        }
    }
    void CargarInfo()
    {
            int selected = proveedorjTable.getSelectedRow(); 
            String clave=proveedorjTable.getValueAt(selected, 0).toString();
            int claveEmpresa = Integer.parseInt(clave);
            Empresasproveedoras mostrar = Controller.EmpresaProveedoraController.Empresa(claveEmpresa);
            empresajTextField.setText(mostrar.getNombre());
            rfcjTextField.setText(mostrar.getRfc());
            telefonojTextField.setText(mostrar.getTelefono()); 
            razonSocialjTextField.setText(mostrar.getRazonSocial());
            direccionjTextArea.setText("Calle "+mostrar.getDirecciones().getCalle()+" con numero "
                    + "\n externo"+mostrar.getDirecciones().getNumeroExterno()+" con numero interno "
                    + "\n"+mostrar.getDirecciones().getNumeroInterno());
    }
    public  static Direcciones claveDir;
    void limpiar()
    {
        empresajTextField.setText("");
        rfcjTextField.setText("");
        telefonojTextField.setText("");
        razonSocialjTextField.setText("");
        direccionjTextArea.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new org.edisoncor.gui.panel.Panel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        empresajTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rfcjTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        telefonojTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        direccionjTextArea = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        proveedorjTable = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        buscarjTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        razonSocialjTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
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
        setTitle("Editar Proveedor");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(163, 220, 236));

        jLabel2.setText("Empresa:");

        empresajTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                empresajTextFieldKeyTyped(evt);
            }
        });

        jLabel7.setText("RFC:");

        jLabel8.setText("Telefono:");

        telefonojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonojTextFieldKeyTyped(evt);
            }
        });

        direccionjTextArea.setEditable(false);
        direccionjTextArea.setColumns(20);
        direccionjTextArea.setRows(5);
        jScrollPane3.setViewportView(direccionjTextArea);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/guardar.png"))); // NOI18N
        jButton3.setText("Actualizar");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        proveedorjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Empresa", "RFC", "Telefono", "Razon Social", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        proveedorjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proveedorjTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(proveedorjTable);
        proveedorjTable.getColumnModel().getColumn(0).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(1).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(2).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(3).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(4).setResizable(false);
        proveedorjTable.getColumnModel().getColumn(5).setResizable(false);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Add.png"))); // NOI18N
        jToggleButton1.setText("Dirección");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        jLabel3.setText("Razon Social:");

        razonSocialjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                razonSocialjTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jToggleButton1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rfcjTextField)
                    .addComponent(telefonojTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(empresajTextField)
                    .addComponent(razonSocialjTextField))
                .addGap(107, 107, 107)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(988, 988, 988))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(empresajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rfcjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(telefonojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(razonSocialjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBounds(300, 0, 1210, 1080);
        jLayeredPane3.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Ima/Fondo.png"))); // NOI18N
        jLabel9.setText("jLabel2");
        jLabel9.setBounds(0, 0, 1510, 1080);
        jLayeredPane3.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1510, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        SeleccionarDireccionEmpresa empresa = Clases.Singleton.getDireccionEmpresa();
        empresa.jButton1.setVisible(false);
        empresa.seleccionarjButton.setVisible(true);
        empresa.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(proveedorjTable.getSelectedRow()>=0)
        {
            int selected = proveedorjTable.getSelectedRow(); 
            String clave=proveedorjTable.getValueAt(selected, 0).toString();
            int claveEmpresa = Integer.parseInt(clave);
            Empresasproveedoras mostrar = Controller.EmpresaProveedoraController.Empresa(claveEmpresa);
            if(claveDir==null)
            {
                Direcciones dom = Controller.DireccionController.BuscarDireccion(Controller.DireccionController.IdLastDireccion());
                claveDir= dom;
            }
            
            if(ValidarProveedor()==true)
            {
                    if(Controller.EmpresaProveedoraController.UpdateEmpresa
                            (mostrar.getClaveEmpresa(), rfcjTextField.getText().toUpperCase()
                            ,empresajTextField.getText(), razonSocialjTextField.getText(), mostrar.getFechaRegistro(), 
                            mostrar.isActivo(), telefonojTextField.getText(), claveDir)
                            ==true)
                    {
                        limpiarTabla();
                        Mostrar();
                        JOptionPane.showMessageDialog(null, "Se ha dado de Actualizado correctamente","Sistema Central", JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "A ocurrido un error intente mas tarde","Sistema Central", JOptionPane.ERROR_MESSAGE);
                    }
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Tienes que seleccionar un registro primero","Sistema Central",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void proveedorjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proveedorjTableMouseClicked
        CargarInfo();
    }//GEN-LAST:event_proveedorjTableMouseClicked

    private void telefonojTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonojTextFieldKeyTyped
char car = evt.getKeyChar();
if(telefonojTextField.getText().length()>=12) evt.consume();
if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_telefonojTextFieldKeyTyped

    private void empresajTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empresajTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_empresajTextFieldKeyTyped

    private void razonSocialjTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_razonSocialjTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_razonSocialjTextFieldKeyTyped

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new AñadirProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new AñadirContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        new EditarProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new EditarProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MouseClicked
        new EditarContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem7MouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new EditarContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        new BajaProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new BajaProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        new BajaContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new BajaContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem8MouseClicked
        new AltaProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem8MouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new AltaProveedor().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MouseClicked
        new AltaContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9MouseClicked

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new AltaContacto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        new ReporteProveedor().setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        Clases.VistasController.RegresarPrincipalProveedor();
        dispose();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        new AyudaProveedor().setVisible(true);
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
            java.util.logging.Logger.getLogger(EditarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProveedor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarjTextField;
    public static javax.swing.JTextArea direccionjTextArea;
    private javax.swing.JTextField empresajTextField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane3;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToggleButton jToggleButton1;
    private org.edisoncor.gui.panel.Panel panel2;
    private javax.swing.JTable proveedorjTable;
    private javax.swing.JTextField razonSocialjTextField;
    private javax.swing.JTextField rfcjTextField;
    private javax.swing.JTextField telefonojTextField;
    // End of variables declaration//GEN-END:variables
}
