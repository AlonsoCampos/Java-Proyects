/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloUsuario.Opcion;

import Model.DisplayItem;
import Model.Sucursales;
import Model.Usuarios;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class ViewUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewUsuario
     */
    public ViewUsuario() {
        initComponents();
        controljPanel.setVisible(false);
        actualizar();
        mostar();
        loadSucursales();
    }
    
    public  void loadSucursales()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Sucursales> resultado=Controller.SucursalesController.ShowSucursales();
        /*Se crea un objeto de tipo RecuperacionContraseña para
        * poder acceder a todos los objetos de la clase RecuperacionContraseña
        */  
        for(Sucursales o: resultado){
           DisplayItem d = new DisplayItem(o.getNombre(), o.getClaveSucursal());
            datos.addElement(d);
        
        } 
        sucursaljComboBox.setModel(datos);
    }
    void limpiar()
    {
        usernamejTextField.setText("");
        contraseñajPasswordField.setText("");
        tipojComboBox.setSelectedIndex(0);
        preguntajComboBox.setSelectedIndex(0);
        respuestajTextField.setText("");
        BuscarjTextField.setText("");
    }   
    boolean Validacion()
    {
        Usuarios busqueda = Controller.UsuarioController.UnicoUsuario(usernamejTextField.getText());
        String contraseña = new String(contraseñajPasswordField.getPassword());
        if(usernamejTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Error no puedes dejar el nombre de \n de usuario"
                    + " vacio" , "Usario Invalido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(contraseña.equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puedes dejar la contraseña de \n"
                    + " vacio" , "Contraseña Invalido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(tipojComboBox.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Error tienes que elegir \n el"
                    + " tipo de usuario" , "Tipo Usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(preguntajComboBox.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Error tienes que elegir \n la"
                    + " pregunta de seguridad" , "Pregunta Seguridad", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(respuestajTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puedes dejar la respuesta  \n"
                    + " vacia" , "Respuesta Invalido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(busqueda!=null)
        {
            JOptionPane.showMessageDialog(null, "Error ya existe un usuario  \n"
                    + " con ese mismo nombre" , "Usuario existente", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            return true;
        }
    }
    void actualizar(){
        BuscarjTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                mostarUsuario();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
            }

        });
    }
        void mostarUsuario()
        {
        List<Usuarios>consultar = Controller.UsuarioController.Busqueda(BuscarjTextField.getText());
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)usuariojTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Usuarios registro=(Usuarios)elemento.next();
        resultado.add(registro.getClave());
        resultado.add(registro.getUsername());
        resultado.add(registro.getTipo());
        resultado.add(registro.getSucursales().getNombre());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
        void mostar()
        {
        List<Usuarios>consultar = Controller.UsuarioController.ShowUsuarios();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)usuariojTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Usuarios registro=(Usuarios)elemento.next();
        resultado.add(registro.getClave());
        resultado.add(registro.getUsername());
        resultado.add(registro.getTipo());
        resultado.add(registro.getSucursales().getNombre());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
    void limpiarTabla()
    {
        while (usuariojTable.getRowCount()!=0)
        {
         ((DefaultTableModel)usuariojTable.getModel()).removeRow(0);
        }
    }
    
    void CargarInfo()
    {
            int selected = usuariojTable.getSelectedRow();    
            String clave=usuariojTable.getValueAt(selected, 0).toString();
            Usuarios mostrar = Controller.UsuarioController.IdUsuario(Integer.parseInt(clave));
            
    }
    boolean UsuarioAdd()
    {
        if(aceptarjButton.getText().equalsIgnoreCase("Guardar"))
        {
            if(Validacion()==true)
            {
                String password = new String(contraseñajPasswordField.getPassword());
                Sucursales sucursal= Controller.SucursalesController.Sucursal(sucursaljComboBox.getSelectedItem().toString());
                if(Controller.UsuarioController.CreateUsuario(usernamejTextField.getText()
                        , password,tipojComboBox.getSelectedItem().toString(),
                        preguntajComboBox.getSelectedItem().toString(),
                        respuestajTextField.getText(), sucursal
                        )==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha guardado una nuevo usuario"
                            ,"Sistema Central",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error no se ha guardado el usuario "
                            + "\n intente mas tarde"
                            ,"Sistema Central",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return false;
    }   
        
    boolean UsuarioDelete(int clave)
    {
        if(aceptarjButton.getText().equalsIgnoreCase("Eliminar"))
        {
            int selected = usuariojTable.getSelectedRow();
            if(selected>=0)
            {
                if(Controller.UsuarioController.DeleteUsuario(clave)==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado la informacion de la usuario"
                            ,"Sistema Central",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error no se ha podido eliminar "
                            + "\n intente mas tarde"
                            ,"Sistema Central",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error tienes que seleccionar una fila"
                        ,"Sistema Central",JOptionPane.ERROR_MESSAGE);
            }
            
        }
        return false;
    }
   
    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principaljPanel = new javax.swing.JPanel();
        controljPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernamejTextField = new javax.swing.JTextField();
        aceptarjButton = new javax.swing.JButton();
        buscarjLabel = new javax.swing.JLabel();
        BuscarjTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tipojComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        preguntajComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        respuestajTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sucursaljComboBox = new javax.swing.JComboBox();
        contraseñajPasswordField = new javax.swing.JPasswordField();
        jScrollPane2 = new javax.swing.JScrollPane();
        usuariojTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        nuevojMenu = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setClosable(true);
        setTitle("Usuario");

        principaljPanel.setBackground(new java.awt.Color(163, 220, 236));

        controljPanel.setBackground(new java.awt.Color(163, 220, 236));

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        aceptarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/guardar.png"))); // NOI18N
        aceptarjButton.setText("Aceptar");
        aceptarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aceptarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aceptarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarjButtonActionPerformed(evt);
            }
        });

        buscarjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        buscarjLabel.setText("Buscar:");

        jLabel4.setText("Tipo:");

        tipojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona el tipo de privilegios", "Administrador", "Contador", "Cajero" }));

        jLabel5.setText("Pregunta de Seguridad:");

        preguntajComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona una pregunta", "Lugar de nacimiento de tu madre", "Mejor amigo de tu infancia", "Nombre de tu primera mascota", "Profesor favorito", "Personaje histórico favorito", "Ocupación del abuelo" }));

        jLabel6.setText("Respuesta:");

        jLabel7.setText("Sucursal:");

        javax.swing.GroupLayout controljPanelLayout = new javax.swing.GroupLayout(controljPanel);
        controljPanel.setLayout(controljPanelLayout);
        controljPanelLayout.setHorizontalGroup(
            controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controljPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernamejTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(tipojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(preguntajComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(respuestajTextField)
                    .addComponent(sucursaljComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contraseñajPasswordField))
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controljPanelLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(buscarjLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(controljPanelLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(aceptarjButton))))
        );
        controljPanelLayout.setVerticalGroup(
            controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controljPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contraseñajPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscarjLabel)
                        .addComponent(BuscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(controljPanelLayout.createSequentialGroup()
                        .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(controljPanelLayout.createSequentialGroup()
                                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tipojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(preguntajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(respuestajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(aceptarjButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(sucursaljComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        usuariojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Username", "Tipo", "Sucursal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usuariojTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuariojTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(usuariojTable);
        usuariojTable.getColumnModel().getColumn(0).setResizable(false);
        usuariojTable.getColumnModel().getColumn(1).setResizable(false);
        usuariojTable.getColumnModel().getColumn(2).setResizable(false);
        usuariojTable.getColumnModel().getColumn(3).setResizable(false);

        javax.swing.GroupLayout principaljPanelLayout = new javax.swing.GroupLayout(principaljPanel);
        principaljPanel.setLayout(principaljPanelLayout);
        principaljPanelLayout.setHorizontalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controljPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        principaljPanelLayout.setVerticalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principaljPanelLayout.createSequentialGroup()
                .addComponent(controljPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );

        nuevojMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/agregar.png"))); // NOI18N
        nuevojMenu.setText("Nuevo");
        nuevojMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevojMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(nuevojMenu);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Eliminar.png"))); // NOI18N
        jMenu4.setText("Borrar Usuario");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

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
            .addComponent(principaljPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(principaljPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevojMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevojMenuMouseClicked
        usernamejTextField.setEnabled(true);
        contraseñajPasswordField.setEnabled(true);
        tipojComboBox.setEnabled(true);
        preguntajComboBox.setEnabled(true);
        respuestajTextField.setEnabled(true);
        sucursaljComboBox.setEnabled(true);
        limpiar();
        BuscarjTextField.setVisible(false);
        buscarjLabel.setVisible(false);
        controljPanel.setVisible(true);
        aceptarjButton.setText("Guardar");
    }//GEN-LAST:event_nuevojMenuMouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        limpiar();
        BuscarjTextField.setVisible(true);
        buscarjLabel.setVisible(true);
        controljPanel.setVisible(true);
        aceptarjButton.setText("Eliminar");
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        JOptionPane.showMessageDialog(null, "Ayuda usuario");
    }//GEN-LAST:event_jMenu5MouseClicked

    private void aceptarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjButtonActionPerformed
        if(UsuarioAdd()==true)
        {
            limpiar();
            limpiarTabla();
            mostar();
            controljPanel.setVisible(false);
        }
        int selected = usuariojTable.getSelectedRow();
        String id=usuariojTable.getValueAt(selected, 0).toString();
        int Id = Integer.parseInt(id);
        if(selected>=0)
        {
            if(UsuarioDelete(Id)==true)
            {
                limpiar();
                controljPanel.setVisible(false);
                        limpiarTabla();
                        mostar();
            }
        }
        
    }//GEN-LAST:event_aceptarjButtonActionPerformed

    private void usuariojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariojTableMouseClicked
        if(aceptarjButton.getText().equalsIgnoreCase("Eliminar"))
        {
            usernamejTextField.setEnabled(false);
            contraseñajPasswordField.setEnabled(false);
            tipojComboBox.setEnabled(false);
            preguntajComboBox.setEnabled(false);
            respuestajTextField.setEnabled(false);
            sucursaljComboBox.setEnabled(false);
            int selected = usuariojTable.getSelectedRow();    
            String usuario=usuariojTable.getValueAt(selected, 0).toString();
            Usuarios mostrar = Controller.UsuarioController.IdUsuario(Integer.parseInt(usuario));
            usernamejTextField.setText(mostrar.getUsername());
            tipojComboBox.setSelectedItem(mostrar.getTipo());
            preguntajComboBox.setSelectedItem(mostrar.getPreguntaSeguridad());
            respuestajTextField.setText(mostrar.getRespuesta());
            sucursaljComboBox.setSelectedItem(mostrar.getSucursales().getNombre());
        }
    }//GEN-LAST:event_usuariojTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarjTextField;
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JLabel buscarjLabel;
    private javax.swing.JPasswordField contraseñajPasswordField;
    private javax.swing.JPanel controljPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu nuevojMenu;
    private javax.swing.JComboBox preguntajComboBox;
    private javax.swing.JPanel principaljPanel;
    private javax.swing.JTextField respuestajTextField;
    private javax.swing.JComboBox sucursaljComboBox;
    private javax.swing.JComboBox tipojComboBox;
    private javax.swing.JTextField usernamejTextField;
    public javax.swing.JTable usuariojTable;
    // End of variables declaration//GEN-END:variables
}
