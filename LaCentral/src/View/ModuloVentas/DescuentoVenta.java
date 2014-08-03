/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloVentas;

import Model.Descuentos;
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
public class DescuentoVenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form DescuentoVenta
     */
    public DescuentoVenta() {
        initComponents();
        mostar();
        actualizar();
    }
    boolean ValidacionDescuento()
    {
        if(descuentojTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puedes dejar vacio "
                    + "\nel porcentaje de descuento", "ERROR",
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
            JOptionPane.showMessageDialog(null, "Error no puedes sobrepasar "
                    + "\nlas 45 letras para la descripcion del descuento", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
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
                mostarMarcas();
            }

            public void removeUpdate(DocumentEvent e) {
               limpiarTabla();
            }

            public void changedUpdate(DocumentEvent e) {
             limpiarTabla();
            }

        });
    }
        void mostarMarcas()
        {
        List<Descuentos>consultar = Controller.DescuentosController.Busquedad(Float.parseFloat(BuscarjTextField.getText()));
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
        DefaultTableModel datos=(DefaultTableModel)descuentojTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Descuentos registro=(Descuentos)elemento.next();
        resultado.add(registro.getClaveDescuento());
        resultado.add(String.valueOf(registro.getDescuento()+"%"));
        resultado.add(registro.getDescripcion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
        void mostar()
        {
        List<Descuentos>consultar = Controller.DescuentosController.ShowDescuentos();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)descuentojTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Descuentos registro=(Descuentos)elemento.next();
        resultado.add(registro.getClaveDescuento());
        resultado.add(String.valueOf(registro.getDescuento()+"%"));
        resultado.add(registro.getDescripcion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
    void limpiarTabla()
    {
        while (descuentojTable.getRowCount()!=0)
        {
         ((DefaultTableModel)descuentojTable.getModel()).removeRow(0);
        }
    }
    
    boolean ValidacionMarca(){
        if(descuentojTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puede dejar"
                    + " el\n descuento vacio"
                    ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(descripcionjTextArea.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puede dejar"
                    + " la\n  descripcion del descuento vacio"
                    ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(descripcionjTextArea.getText().length()>=25)
        {
            JOptionPane.showMessageDialog(null, "Error no puede"
                    + " sobrepasar mas de 25 letras"
                    ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            return true;
        }
        
    }
    void CargarInfo()
    {
            int selected = descuentojTable.getSelectedRow();    
            String clave=descuentojTable.getValueAt(selected, 0).toString();
            Descuentos mostrar = Controller.DescuentosController.BusquedadClave(Integer.parseInt(clave));
            descuentojTextField.setText(String.valueOf(mostrar.getDescuento()+"%"));
            descripcionjTextArea.setText(mostrar.getDescripcion());
    }
    void DescuentoAdd()
    {
        if(aceptarjButton.getText().equalsIgnoreCase("Guardar"))
        {
            if(ValidacionMarca()==true)
            {
                if(Controller.MarcasController.CreateMarca(descuentojTextField.getText()
                        , descripcionjTextArea.getText())==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha guardado una nueva marca"
                            ,"Sistema Central",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error no se ha guardado la marca "
                            + "\n intente mas tarde"
                            ,"Sistema Central",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }   
        void DescuentoUpdate(int clave)
    {
        if(aceptarjButton.getText().equalsIgnoreCase("Actualizar"))
        {
            if(ValidacionMarca()==true)
            {
                int selected = descuentojTable.getSelectedRow();
            if(selected>=0)
            {
                if(Controller.MarcasController.UpdateMarca(clave,descuentojTextField.getText()
                        , descripcionjTextArea.getText())==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la informacion de la marca"
                            ,"Sistema Central",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error no se ha podido actualizado "
                            + "\n intente mas tarde"
                            ,"Sistema Central",JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error tienes que seleccionar una fila"
                        ,"Sistema Central",JOptionPane.ERROR_MESSAGE);
            }
            }
        }
    }
    void DescuentoDelete(int clave)
    {
        if(aceptarjButton.getText().equalsIgnoreCase("Actualizar"))
        {
            if(ValidacionMarca()==true)
            {
                int selected = descuentojTable.getSelectedRow();
            if(selected>=0)
            {
                if(Controller.DescuentosController.DeleteDescuento(clave)==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado la informacion de la marca"
                            ,"Sistema Central",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error no se ha podido eliminar "
                            + "\n intente mas tarde"
                            ,"Sistema Central",JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error tienes que seleccionar una fila"
                        ,"Sistema Central",JOptionPane.ERROR_MESSAGE);
            }
            }
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
        descuentojTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionjTextArea = new javax.swing.JTextArea();
        aceptarjButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BuscarjTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descuentojTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setClosable(true);
        setTitle("Descuento de Venta");

        principaljPanel.setBackground(new java.awt.Color(255, 255, 255));

        edicionjPanel.setBackground(new java.awt.Color(163, 220, 236));

        jLabel1.setText("Descuento:");

        jLabel2.setText("Descripcion:");

        descuentojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descuentojTextFieldKeyTyped(evt);
            }
        });

        descripcionjTextArea.setColumns(20);
        descripcionjTextArea.setRows(5);
        descripcionjTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionjTextAreaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(descripcionjTextArea);

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
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(descuentojTextField))
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(edicionjPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(aceptarjButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edicionjPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        edicionjPanelLayout.setVerticalGroup(
            edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edicionjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descuentojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aceptarjButton)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edicionjPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)))
        );

        descuentojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descuento", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        descuentojTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descuentojTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(descuentojTable);
        descuentojTable.getColumnModel().getColumn(0).setResizable(false);
        descuentojTable.getColumnModel().getColumn(1).setResizable(false);
        descuentojTable.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout principaljPanelLayout = new javax.swing.GroupLayout(principaljPanel);
        principaljPanel.setLayout(principaljPanelLayout);
        principaljPanelLayout.setHorizontalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edicionjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        principaljPanelLayout.setVerticalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principaljPanelLayout.createSequentialGroup()
                .addComponent(edicionjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/agregar.png"))); // NOI18N
        jMenu1.setText("Nuevo ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/actualizar.png"))); // NOI18N
        jMenu3.setText("Editar");
        jMenuBar1.add(jMenu3);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Eliminar.png"))); // NOI18N
        jMenu5.setText("Eliminar");
        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/ayuda.png"))); // NOI18N
        jMenu6.setText("Ayuda");
        jMenuBar1.add(jMenu6);

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
                .addComponent(principaljPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        edicionjPanel.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void aceptarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjButtonActionPerformed
        DescuentoAdd();
        int selected = descuentojTable.getSelectedRow();
        String id=descuentojTable.getValueAt(selected, 0).toString();
        int Id = Integer.parseInt(id);
        if(selected>=0)
        {
            DescuentoDelete(Id);
            DescuentoUpdate(Id);
        }
        limpiarTabla();
        mostar();
    }//GEN-LAST:event_aceptarjButtonActionPerformed

    private void descuentojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descuentojTableMouseClicked
        CargarInfo();
    }//GEN-LAST:event_descuentojTableMouseClicked

    private void descuentojTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descuentojTextFieldKeyTyped
        char car = evt.getKeyChar();
if(descuentojTextField.getText().length()>=8) evt.consume();
if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_descuentojTextFieldKeyTyped

    private void descripcionjTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionjTextAreaKeyTyped
        char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_descripcionjTextAreaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarjTextField;
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JTextArea descripcionjTextArea;
    private javax.swing.JTable descuentojTable;
    private javax.swing.JTextField descuentojTextField;
    private javax.swing.JPanel edicionjPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel principaljPanel;
    // End of variables declaration//GEN-END:variables
}
