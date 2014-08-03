/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloUsuario.Opcion;

import Model.Sucursales;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class ViewSucursal extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewSucursal
     */
    public ViewSucursal() {
        initComponents();
        controljPanel.setVisible(false);
        mostar();
        actualizar();
    }
    /*Este metodo nos permite realizar la busqueda
     * de las sucursales por el nombre y descripcion
     * que es realizada en el Textfield
    */
    void actualizar(){
        buscarjTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                buscarNombre();
                BuscarDescripcion();
            }

            public void removeUpdate(DocumentEvent e) {
                limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
                mostar();
            }

        });
    } 
    /*Este metodo hace la consulta de todos los
     * registros que tengan coincidencias con 
     * el valor ingresado en el Textfield
     * busca por nombre
     */
    void buscarNombre(){
           List<Sucursales> consultar = Controller.SucursalesController
           .Busqueda(buscarjTextField.getText());
            if(consultar.size()>0)
            {
              Iterator elemento=consultar.iterator();
              while(elemento.hasNext())
              {
              DefaultTableModel datos=(DefaultTableModel)sucursaljTable.getModel();
                        Vector resultado=new Vector();      
                        Sucursales registro=(Sucursales)elemento.next();
                        resultado.add(registro.getClaveSucursal());
                        resultado.add(registro.getNombre());
                        resultado.add(registro.getDescripcion());
                        datos.addRow(resultado);
               }
         }
    } 
    /*Este metodo hace la consulta de todos los
     * registros que tengan coincidencias con 
     * el valor ingresado en el Textfield
     * busca por descripcion
     */
    void BuscarDescripcion(){
           List<Sucursales> consultar = Controller.SucursalesController
           .BusquedaD(buscarjTextField.getText());
            if(consultar.size()>0)
            {
              Iterator elemento=consultar.iterator();
              while(elemento.hasNext())
              {
              DefaultTableModel datos=(DefaultTableModel)sucursaljTable.getModel();
                        Vector resultado=new Vector();      
                        Sucursales registro=(Sucursales)elemento.next();
                        resultado.add(registro.getClaveSucursal());
                        resultado.add(registro.getNombre());
                        resultado.add(registro.getDescripcion());
                        datos.addRow(resultado);
               }
         }
    } 
    /*Mustra todos los registros de la Bd
     */
    void mostar(){
        List<Sucursales>consultar = Controller.SucursalesController.ShowSucursales();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)sucursaljTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Sucursales registro=(Sucursales)elemento.next();
        resultado.add(registro.getClaveSucursal());
        resultado.add(registro.getNombre());
        resultado.add(registro.getDescripcion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
    /*Actualiza todos los cambios de
     * la bd
     */
    void limpiarTabla(){
        while (sucursaljTable.getRowCount()!=0)
        {
         ((DefaultTableModel)sucursaljTable.getModel()).removeRow(0);
        }
    }
    //Borra el contenido de todos los 
    //elementos
    void limpiar(){
         nombrejTextField.setText("");
         descripcionjTextArea.setText("");
         buscarjTextField.setText("");
    }
    /*Valida a todas las cajas de texto
     */
    boolean validar(){
         if(nombrejTextField.getText().equalsIgnoreCase(""))
         {
             JOptionPane.showMessageDialog(null, "Error no puedes dejar vacio \n"
                     + "el nombre de la sucursal" ,"Campos Incompletos"
                     ,JOptionPane.ERROR_MESSAGE);
             return false;
         }
         else if(descripcionjTextArea.getText().equalsIgnoreCase(""))
         {
             JOptionPane.showMessageDialog(null, "No puedes dejar vacia la \n"
                     + "la descripcion", "Campos Incompletos"
                     ,JOptionPane.ERROR_MESSAGE);
             return false;
         }
         else
         {
         return true;
         }
     }
    /*Nos permite agrega un nuevo registro 
    en la bd*/
    void AgregarSucursal(){
         if(aceptarjButton.getText().equals("Guardar"))
         {
          if(validar()==true)
          {
              if(Controller.SucursalesController.SucursalExistente(nombrejTextField.getText())==true)
              {
                    if(Controller.SucursalesController.CreateSucursal(nombrejTextField.getText()
                           , descripcionjTextArea.getText())==true)
                   {
                       JOptionPane.showMessageDialog(null, "Registro guardado"
                               ,"", JOptionPane.INFORMATION_MESSAGE);
                       
                       controljPanel.setVisible(false);
                       limpiarTabla();
                       mostar();
                       limpiar();
                       controljPanel.setVisible(false);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Error al guardar intente nuevamente"
                               ,"Error", JOptionPane.ERROR_MESSAGE);
                   }               
              }else{
                  JOptionPane.showMessageDialog(null, "Error ya existe el nombre de la sucursal","Sistema Central", JOptionPane.ERROR_MESSAGE);
              }
          } // Fin validacion de campos
         } //Fin Validacion boton
     }
    /*Nos permite modificar un  registro 
    en la bd*/
    void ModificarSucursal(int id){
         if(aceptarjButton.getText().equals("Actualizar"))
         {
          if(validar()==true)
          {

            if(Controller.SucursalesController.SucursalExistente(nombrejTextField.getText())==true)
              {
                    if(Controller.SucursalesController.UpdateSucursal(id,nombrejTextField.getText()
                            , descripcionjTextArea.getText())==true)
                    {
                        JOptionPane.showMessageDialog(null, "Registro Actualizado"
                                ,"", JOptionPane.INFORMATION_MESSAGE);
                        controljPanel.setVisible(false);
                        limpiarTabla();
                        mostar();
                        limpiar();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error al actualizar intente nuevamente"
                                ,"Error", JOptionPane.ERROR_MESSAGE);
                    }
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Error ya existe el nombre de la sucursal","Sistema Central", JOptionPane.ERROR_MESSAGE);                  
              }
          } // Fin validacion de campos
         } //Fin Validacion boton
     }
    /*Nos permite eliminar un registro 
    en la bd*/
    void EliminarSucursal(int id){
         if(aceptarjButton.getText().equals("Eliminar"))
         {
          
              if(Controller.SucursalesController.DeleteSucursal(id)==true)
              {
                  JOptionPane.showMessageDialog(null, "Registro Borrado"
                          ,"", JOptionPane.INFORMATION_MESSAGE);
                  controljPanel.setVisible(false);          
                  limpiarTabla();
                  mostar();
                  limpiar();
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Error al borrar intente nuevamente"
                          ,"Error", JOptionPane.ERROR_MESSAGE);
              }
         } //Fin Validacion boton
     }
     
    /**
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
        nombrejTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionjTextArea = new javax.swing.JTextArea();
        aceptarjButton = new javax.swing.JButton();
        buscarjLabel = new javax.swing.JLabel();
        buscarjTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        sucursaljTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        nuevojMenu = new javax.swing.JMenu();
        editarjMenu = new javax.swing.JMenu();
        eliminarjMenu = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setClosable(true);
        setTitle("Sucursal");

        principaljPanel.setBackground(new java.awt.Color(163, 220, 236));

        controljPanel.setBackground(new java.awt.Color(163, 220, 236));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Descripcion:");

        nombrejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombrejTextFieldKeyTyped(evt);
            }
        });

        descripcionjTextArea.setColumns(20);
        descripcionjTextArea.setRows(5);
        descripcionjTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionjTextAreaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(descripcionjTextArea);

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

        javax.swing.GroupLayout controljPanelLayout = new javax.swing.GroupLayout(controljPanel);
        controljPanel.setLayout(controljPanelLayout);
        controljPanelLayout.setHorizontalGroup(
            controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controljPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(nombrejTextField))
                .addGap(44, 44, 44)
                .addComponent(aceptarjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(buscarjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        controljPanelLayout.setVerticalGroup(
            controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controljPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscarjLabel)
                        .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(controljPanelLayout.createSequentialGroup()
                        .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nombrejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(controljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aceptarjButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sucursaljTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sucursaljTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sucursaljTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(sucursaljTable);
        sucursaljTable.getColumnModel().getColumn(0).setResizable(false);
        sucursaljTable.getColumnModel().getColumn(1).setResizable(false);
        sucursaljTable.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout principaljPanelLayout = new javax.swing.GroupLayout(principaljPanel);
        principaljPanel.setLayout(principaljPanelLayout);
        principaljPanelLayout.setHorizontalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(controljPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        principaljPanelLayout.setVerticalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principaljPanelLayout.createSequentialGroup()
                .addComponent(controljPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
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

        editarjMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/actualizar.png"))); // NOI18N
        editarjMenu.setText("Editar");
        editarjMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarjMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(editarjMenu);

        eliminarjMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Eliminar.png"))); // NOI18N
        eliminarjMenu.setText("Eliminar");
        eliminarjMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarjMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(eliminarjMenu);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/ayuda.png"))); // NOI18N
        jMenu4.setText("Ayuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principaljPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principaljPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevojMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevojMenuMouseClicked
        limpiar();
        buscarjLabel.setVisible(false);
        buscarjTextField.setVisible(false);
        controljPanel.setVisible(true);
        aceptarjButton.setText("Guardar");
        
    }//GEN-LAST:event_nuevojMenuMouseClicked

    private void editarjMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarjMenuMouseClicked
        limpiar();
        buscarjLabel.setVisible(true);
        buscarjTextField.setVisible(true);
        controljPanel.setVisible(true);
        aceptarjButton.setText("Actualizar");    
    }//GEN-LAST:event_editarjMenuMouseClicked

    private void eliminarjMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarjMenuMouseClicked
        limpiar();
        buscarjLabel.setVisible(true);
        buscarjTextField.setVisible(true);
        controljPanel.setVisible(true);
        aceptarjButton.setText("Eliminar");
    }//GEN-LAST:event_eliminarjMenuMouseClicked

    private void aceptarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjButtonActionPerformed
        validar();
        AgregarSucursal();
        int selected = sucursaljTable.getSelectedRow();        
        String id=sucursaljTable.getValueAt(selected, 0).toString();
        if(aceptarjButton.getText().equalsIgnoreCase("Eliminar") ||
                aceptarjButton.getText().equalsIgnoreCase("Actualizar")){
            ModificarSucursal(Integer.parseInt(id));
            EliminarSucursal(Integer.parseInt(id));
        }
        
    }//GEN-LAST:event_aceptarjButtonActionPerformed

    private void sucursaljTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sucursaljTableMouseClicked
        if(!aceptarjButton.getText().equalsIgnoreCase("Guardar"))
        {
            int selected = sucursaljTable.getSelectedRow();    
            String nombre=sucursaljTable.getValueAt(selected, 1).toString();
            String descripcion=sucursaljTable.getValueAt(selected, 2).toString();
            nombrejTextField.setText(nombre);
            descripcionjTextArea.setText(descripcion);    
        }    
            
    }//GEN-LAST:event_sucursaljTableMouseClicked

    private void nombrejTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombrejTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_nombrejTextFieldKeyTyped

    private void descripcionjTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionjTextAreaKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_descripcionjTextAreaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JLabel buscarjLabel;
    private javax.swing.JTextField buscarjTextField;
    private javax.swing.JPanel controljPanel;
    private javax.swing.JTextArea descripcionjTextArea;
    private javax.swing.JMenu editarjMenu;
    private javax.swing.JMenu eliminarjMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nombrejTextField;
    private javax.swing.JMenu nuevojMenu;
    private javax.swing.JPanel principaljPanel;
    private javax.swing.JTable sucursaljTable;
    // End of variables declaration//GEN-END:variables
}
