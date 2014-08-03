/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloVentas;

import Model.Formaspagos;
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
public class FormaPagoVenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormaPagoVenta
     */
    public FormaPagoVenta() {
        initComponents();
        actualizar();
        mostar();
        edicionjPanel.setVisible(false);
        
    }
    
    void actualizar(){
        buscarjTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                limpiarTabla();
                buscarNombre();
            }

            public void removeUpdate(DocumentEvent e) {
                limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
                mostar();
            }

        });
    }
    void CargarInfo()
    {
            int selected = formaPagojTable.getSelectedRow(); 
            String clave=formaPagojTable.getValueAt(selected, 0).toString();
            Formaspagos mostrar = Controller.FormaspagosController.BusquedadClave(Integer.parseInt(clave));
            formaPagojTextField.setText(mostrar.getFormaPago());
            descripcionjTextArea.setText(mostrar.getDescripcion());
    }
    /*Este metodo hace la consulta de todos los
     * registros que tengan coincidencias con 
     * el valor ingresado en el Textfield
     * busca por nombre
     */
    void buscarNombre(){
           List<Formaspagos> consultar = Controller.FormaspagosController
           .Busqueda(buscarjTextField.getText());
            if(consultar.size()>0)
            {
              Iterator elemento=consultar.iterator();
              while(elemento.hasNext())
              {
              DefaultTableModel datos=(DefaultTableModel)formaPagojTable.getModel();
                        Vector resultado=new Vector();      
                        Formaspagos registro=(Formaspagos)elemento.next();
                        resultado.add(registro.getClaveFormasPagos());
                        resultado.add(registro.getFormaPago());
                        resultado.add(registro.getDescripcion());
                        datos.addRow(resultado);
               }
         }
    }
    void FormadePago()
    {
            if(aceptarjButton.getText().equalsIgnoreCase("Guardar"))
        {
            if(ValidacionDescuento()==true)
            {
               if(Controller.FormaspagosController.CreateFormapago(formaPagojTextField.getText(), descripcionjTextArea.getText()
                       )==true)
                {
                    JOptionPane.showMessageDialog(null, "Guardado Exitosamente"
                            ,"Registro Guardado", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                     JOptionPane.showMessageDialog(null, "Error al guardar"
                            ,"Error al guardar", JOptionPane.ERROR_MESSAGE);
                }
                        
            }
        }    
    }    
      boolean ValidacionDescuento()
    {
        if(formaPagojTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puedes dejar vacio el "
                    + "\nla  forma de pago", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(formaPagojTextField.getText().length()==45)
        {
            JOptionPane.showMessageDialog(null, "Error no puedes sobrepsar las 45 "
                    + "\nletras para la forma de pago", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(descripcionjTextArea.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puedes dejar vacio el "
                    + "\nel porcentaje de descuento", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(descripcionjTextArea.getText().length()>=45)
        {
            JOptionPane.showMessageDialog(null, "Error no puedes sobrepasar las 45 "
                    + "\nletras para la descripcion de la forma de pago", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
            else
        {
            return true;
        }        
    }
          void mostar()
    {
        List<Formaspagos>consultar = Controller.FormaspagosController.ShowFormaspagos();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)formaPagojTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Formaspagos registro=(Formaspagos)elemento.next();
        resultado.add(registro.getClaveFormasPagos());
        resultado.add(registro.getFormaPago());
        resultado.add(registro.getDescripcion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
    void limpiarTabla()
    {
        while (formaPagojTable.getRowCount()!=0)
        {
         ((DefaultTableModel)formaPagojTable.getModel()).removeRow(0);
        }
    }
      void Eliminar(int clave)
    {
    if(aceptarjButton.getText().equalsIgnoreCase("Eliminar"))
        { 
                  Formaspagos busqueda = Controller.FormaspagosController.BusquedadClave(clave);
                    if(Controller.FormaspagosController.DeleteFormapago(busqueda.getClaveFormasPagos())==true)
                    {
                        JOptionPane.showMessageDialog(null, "Registro Eliminado", "Sistema Central", JOptionPane.INFORMATION_MESSAGE);
                   }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error no se ha podido eliminar \n"
                                + "correctamente intente nuevamente", "Error al Guardar"
                                , JOptionPane.ERROR_MESSAGE);
                    }
                
                mostar();
            }    
    }
      void Actualizar(int clave)
    {
    if(aceptarjButton.getText().equalsIgnoreCase("Actualizar"))
        { 
                  Formaspagos busqueda = Controller.FormaspagosController.BusquedadClave(clave);
                    if(Controller.FormaspagosController.UpdateFormapago(busqueda.getClaveFormasPagos(),
                            formaPagojTextField.getText(), descripcionjTextArea.getText())==true)
                    {
                        JOptionPane.showMessageDialog(null, "Registro Actualizado","Sistema Central", JOptionPane.INFORMATION_MESSAGE);
                   }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error no se ha podido eliminar \n"
                                + "correctamente intente nuevamente", "Error al Guardar"
                                , JOptionPane.ERROR_MESSAGE);
                    }
                
                mostar();
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

        principaljPanel = new javax.swing.JPanel();
        edicionjPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        formaPagojTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionjTextArea = new javax.swing.JTextArea();
        aceptarjButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        buscarjTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        formaPagojTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setClosable(true);
        setTitle("Forma de Pago");

        principaljPanel.setBackground(new java.awt.Color(255, 255, 255));

        edicionjPanel.setBackground(new java.awt.Color(163, 220, 236));

        jLabel1.setText("Forma de pago:");

        jLabel2.setText("Descripcion:");

        formaPagojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formaPagojTextFieldKeyTyped(evt);
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        jLabel3.setText("Buscar:");

        javax.swing.GroupLayout edicionjPanelLayout = new javax.swing.GroupLayout(edicionjPanel);
        edicionjPanel.setLayout(edicionjPanelLayout);
        edicionjPanelLayout.setHorizontalGroup(
            edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edicionjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(formaPagojTextField))
                .addGap(55, 55, 55)
                .addComponent(aceptarjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        edicionjPanelLayout.setVerticalGroup(
            edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edicionjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(formaPagojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aceptarjButton)
                    .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formaPagojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Forma de pago", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        formaPagojTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formaPagojTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(formaPagojTable);
        formaPagojTable.getColumnModel().getColumn(0).setResizable(false);
        formaPagojTable.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout principaljPanelLayout = new javax.swing.GroupLayout(principaljPanel);
        principaljPanel.setLayout(principaljPanelLayout);
        principaljPanelLayout.setHorizontalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(principaljPanelLayout.createSequentialGroup()
                .addComponent(edicionjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        principaljPanelLayout.setVerticalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principaljPanelLayout.createSequentialGroup()
                .addComponent(edicionjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/agregar.png"))); // NOI18N
        jMenu1.setText("Nuevo");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/actualizar.png"))); // NOI18N
        jMenu2.setText("Editar");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Eliminar.png"))); // NOI18N
        jMenu3.setText("Eliminar ");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/ayuda.png"))); // NOI18N
        jMenu4.setText("Ayuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(principaljPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principaljPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formaPagojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formaPagojTableMouseClicked
        CargarInfo();
    }//GEN-LAST:event_formaPagojTableMouseClicked

    private void aceptarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjButtonActionPerformed
        FormadePago();
        int selected = formaPagojTable.getSelectedRow();
        String id=formaPagojTable.getValueAt(selected, 0).toString();
        int Id = Integer.parseInt(id);
        if(selected>=0)
        {
            Eliminar(Id);
            Actualizar(Id);
        }
        limpiarTabla();
        mostar();        
    }//GEN-LAST:event_aceptarjButtonActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        edicionjPanel.setVisible(true);
        aceptarjButton.setText("Guardar");
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        edicionjPanel.setVisible(true);
        aceptarjButton.setText("Actualizar");
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        edicionjPanel.setVisible(true);
        aceptarjButton.setText("Eliminar");
    }//GEN-LAST:event_jMenu3MouseClicked

    private void formaPagojTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formaPagojTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_formaPagojTextFieldKeyTyped

    private void descripcionjTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionjTextAreaKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_descripcionjTextAreaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JTextField buscarjTextField;
    private javax.swing.JTextArea descripcionjTextArea;
    private javax.swing.JPanel edicionjPanel;
    private javax.swing.JTable formaPagojTable;
    private javax.swing.JTextField formaPagojTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel principaljPanel;
    // End of variables declaration//GEN-END:variables
}
