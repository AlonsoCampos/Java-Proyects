/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloCliente.Opcion;

import Model.Clientes;
import Model.Domicilios;
import Model.Historiales;
import Model.Personas;
import View.ModuloCliente.PrincipalCliente;
import View.SeleccionarDireccion;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class EditarCliente extends javax.swing.JFrame {

    /**
     * Creates new form EditarCliente
     */
    public EditarCliente() {
        initComponents();
        actualizar();
        Mostrar();

    }
public static boolean activoCajero;
    public void PermisosCajero(boolean activo)
    {
        jMenu1.setVisible(activo);
        jMenu4.setVisible(activo);
    }
void CargarInfo()
    {
        int selected = clientesjTable.getSelectedRow();  
        if(selected>=0)
        {
            String clave=clientesjTable.getValueAt(selected, 0).toString();
            Clientes mostrar = Controller.ClientesController.BusquedaClave(Integer.parseInt(clave));
            nombrejTextField.setText(mostrar.getPersonas().getNombre());
            paternojTextField.setText(mostrar.getPersonas().getApellidoPaterno());
            maternojTextField.setText(mostrar.getPersonas().getApellidoMaterno());
            telefonojTextField.setText(mostrar.getPersonas().getTelefono());
            direccionjTextArea.setText(mostrar.getPersonas().getDomicilios().getDomicilio());
            if(mostrar.isTipoCliente()==true)
            {
                tipojComboBox.setSelectedItem("Cliente Frecuente");
            }
            else
            {
                tipojComboBox.setSelectedItem("Cliente Ocasional");
            }
        }
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
                buscarNombre();
            }

            public void changedUpdate(DocumentEvent e) {
                buscarNombre();
            }

        });
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
                        
                        if(historial.getClientes().isActivo()!=false)
                        {
                            resultado.add(historial.getClientes().getClaveCliente());
                            resultado.add(historial.getClientes().getPersonas().getNombre()+" "+historial.getClientes().getPersonas().getApellidoPaterno()
                                    +" "+historial.getClientes().getPersonas().getApellidoMaterno());
                            resultado.add(historial.getClientes().getFechaRegistro().getTime());
                            if(historial.getClientes().isTipoCliente()==true)
                            {
                                resultado.add("Cliente Frecuente");
                            }
                            else
                            {
                                resultado.add("Cliente Ocasional");
                            }
                            if(historial.getClientes().isActivo()==true)
                            {
                                resultado.add("Habilitado");
                            }
                            else
                            {
                                resultado.add("Deshabilitado");
                            }
                            datos.addRow(resultado);
                        }
                    
                }
            
        }// Fin Historiales
       } // Fin Personas    
    }
    void Mostrar()
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
                        
                        if(historial.getClientes().isActivo()!=false)
                        {
                            resultado.add(historial.getClientes().getClaveCliente());
                            resultado.add(historial.getClientes().getPersonas().getNombre()+" "+historial.getClientes().getPersonas().getApellidoPaterno()
                                    +" "+historial.getClientes().getPersonas().getApellidoMaterno());
                            resultado.add(historial.getClientes().getFechaRegistro().getTime());
                            if(historial.getClientes().isTipoCliente()==true)
                            {
                                resultado.add("Cliente Frecuente");
                            }
                            else
                            {
                                resultado.add("Cliente Ocasional");
                            }
                            if(historial.getClientes().isActivo()==true)
                            {
                                resultado.add("Habilitado");
                            }
                            else
                            {
                                resultado.add("Deshabilitado");
                            }
                            datos.addRow(resultado);
                        }
                    
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
                        
                        if(historial.getClientes().isActivo()!=false)
                        {
                            resultado.add(historial.getClientes().getClaveCliente());
                            resultado.add(historial.getClientes().getPersonas().getNombre()+" "+historial.getClientes().getPersonas().getApellidoPaterno()
                                    +" "+historial.getClientes().getPersonas().getApellidoMaterno());
                            resultado.add(historial.getClientes().getFechaRegistro().getTime());
                            if(historial.getClientes().isTipoCliente()==true)
                            {
                                resultado.add("Cliente Frecuente");
                            }
                            else
                            {
                                resultado.add("Cliente Ocasional");
                            }
                            if(historial.getClientes().isActivo()==true)
                            {
                                resultado.add("Habilitado");
                            }
                            else
                            {
                                resultado.add("Deshabilitado");
                            }
                            datos.addRow(resultado);
                        }
                    
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
                        
                        if(historial.getClientes().isActivo()!=false)
                        {
                            resultado.add(historial.getClientes().getClaveCliente());                            
                            resultado.add(historial.getClientes().getPersonas().getNombre()+" "+historial.getClientes().getPersonas().getApellidoPaterno()
                                    +" "+historial.getClientes().getPersonas().getApellidoMaterno());
                            resultado.add(historial.getClientes().getFechaRegistro().getTime());
                            if(historial.getClientes().isTipoCliente()==true)
                            {
                                resultado.add("Cliente Frecuente");
                            }
                            else
                            {
                                resultado.add("Cliente Ocasional");
                            }
                            if(historial.getClientes().isActivo()==true)
                            {
                                resultado.add("Habilitado");
                            }
                            else
                            {
                                resultado.add("Deshabilitado");
                            }
                            datos.addRow(resultado);
                        }
                    
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
        public static Domicilios claveEdit;
        public static int editarCliente=2;
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
        jLabel3 = new javax.swing.JLabel();
        nombrejTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        paternojTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        maternojTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        telefonojTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        direccionjTextArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        tipojComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesjTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buscarjTextField = new javax.swing.JTextField();
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
        setTitle("Editar Cliente");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(163, 220, 236));

        jLabel3.setText("Nombre:");

        nombrejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombrejTextFieldKeyTyped(evt);
            }
        });

        jLabel4.setText("Apellido Paterno:");

        paternojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                paternojTextFieldKeyTyped(evt);
            }
        });

        jLabel5.setText("Apellido Materno:");

        maternojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                maternojTextFieldKeyTyped(evt);
            }
        });

        jLabel6.setText("Telefono:");

        telefonojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonojTextFieldKeyTyped(evt);
            }
        });

        jLabel7.setText("Domicilio:");

        direccionjTextArea.setEditable(false);
        direccionjTextArea.setColumns(20);
        direccionjTextArea.setRows(5);
        jScrollPane2.setViewportView(direccionjTextArea);

        jLabel8.setText("Tipo de Cliente:");

        tipojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente Frecuente", "Cliente Ocasional" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/actualizar.png"))); // NOI18N
        jButton1.setText("Actualizar");
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
                "Codigo", "Cliente", "Registrado", "Tipo", "Status"
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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Add.png"))); // NOI18N
        jButton3.setText("Cambiar");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(telefonojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nombrejTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(paternojTextField)
                                    .addComponent(maternojTextField))))
                        .addGap(103, 103, 103)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton1)
                            .addComponent(tipojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(503, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200))))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nombrejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(paternojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(maternojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(telefonojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tipojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SeleccionarDireccion domicilio = Clases.Singleton.getDireccion();
        domicilio.jButton1.setVisible(false);
        domicilio.seleccionarjButton.setVisible(true);
        domicilio.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void clientesjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesjTableMouseClicked
        CargarInfo();
    }//GEN-LAST:event_clientesjTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selected = clientesjTable.getSelectedRow();  
        if(selected>=0)
        {
            if(claveEdit==null)
            {
                Domicilios dom = Controller.DomiciliosController.BusquedaClave(Controller.DomiciliosController.IdLastDomicilio());
                claveEdit= dom;
            }
            String clave=clientesjTable.getValueAt(selected, 0).toString();
            Clientes mostrar = Controller.ClientesController.BusquedaClave(Integer.parseInt(clave));
            boolean tipocliente;
            if(tipojComboBox.getSelectedItem().toString().equalsIgnoreCase("Cliente Frecuente"))
            {
               tipocliente=true;
            }
            else
            {
                tipocliente=false;
            }
            
            if(Controller.PersonasController.UpdatePersona(mostrar.getPersonas().getIdPersona(),nombrejTextField.getText(), 
                    paternojTextField.getText(), maternojTextField.getText(), telefonojTextField.getText(),claveEdit)
                    ==true && Controller.ClientesController.UpdateCliente(mostrar.getClaveCliente(),mostrar.getFechaRegistro(), mostrar.isActivo(), 
                    tipocliente, mostrar.getPersonas())==true)
            {
                limpiarTabla();
                Mostrar();
                JOptionPane.showMessageDialog(null, "Cliente Actualizado","Sistema Central",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Error no se ha podido actualizar intente mas tarde","Sistema Central",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void nombrejTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombrejTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_nombrejTextFieldKeyTyped

    private void paternojTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paternojTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_paternojTextFieldKeyTyped

    private void maternojTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maternojTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_maternojTextFieldKeyTyped

    private void telefonojTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonojTextFieldKeyTyped
char car = evt.getKeyChar();
if(telefonojTextField.getText().length()>=8) evt.consume();
if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_telefonojTextFieldKeyTyped

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
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem altaClientejMenuItem;
    private javax.swing.JTextField buscarjTextField;
    private javax.swing.JTable clientesjTable;
    public static javax.swing.JTextArea direccionjTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField maternojTextField;
    private javax.swing.JTextField nombrejTextField;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTextField paternojTextField;
    private javax.swing.JTextField telefonojTextField;
    private javax.swing.JComboBox tipojComboBox;
    // End of variables declaration//GEN-END:variables
}
