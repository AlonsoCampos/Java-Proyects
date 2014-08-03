/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloProducto;

import Model.Calidades;
import Model.Marcas;
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
public class CalidadProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form CalidadProducto
     */
    public CalidadProducto() {
        initComponents();
        edicionjPanel.setVisible(false);
        mostar();
        actualizar();
    }
        void actualizar(){
        buscarjTextField.getDocument().addDocumentListener(new DocumentListener() {
            
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
        List<Calidades>consultar = Controller.CalidadesController.Calidades(buscarjTextField.getText());
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)calidadjTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Calidades registro=(Calidades)elemento.next();
        resultado.add(registro.getClaveCalidad());
        resultado.add(registro.getCalidad());
        resultado.add(registro.getDescripcion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
        void mostar()
        {
        List<Calidades>consultar = Controller.CalidadesController.ShowCalidades();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)calidadjTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Calidades registro=(Calidades)elemento.next();
        resultado.add(registro.getClaveCalidad());
        resultado.add(registro.getCalidad());
        resultado.add(registro.getDescripcion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
    void limpiarTabla()
    {
        while (calidadjTable.getRowCount()!=0)
        {
         ((DefaultTableModel)calidadjTable.getModel()).removeRow(0);
        }
    }
    
    boolean ValidacionMarca(){
        if(calidadjTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puede dejar"
                    + " el\n nombre de la calidad vacio"
                    ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(calidadjTextField.getText().length()>=20)
        {
            JOptionPane.showMessageDialog(null, "Error no puede"
                    + " sobrepasar mas de 20 letras o espacios"
                    ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(descripcionjTextArea.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puede dejar"
                    + " la\n  descripcion de la calidad vacio"
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
            int selected = calidadjTable.getSelectedRow();    
            String clave=calidadjTable.getValueAt(selected, 0).toString();
            Calidades mostrar = Controller.CalidadesController.Busqueda(Integer.parseInt(clave));
            calidadjTextField.setText(mostrar.getCalidad());
            descripcionjTextArea.setText(mostrar.getDescripcion());
    }
    boolean MarcaAdd()
    {
        if(aceptarjButton.getText().equalsIgnoreCase("Guardar"))
        {
            if(ValidacionMarca()==true)
            {
                if(Controller.CalidadesController.CreateCalidad(calidadjTextField.getText()
                        , descripcionjTextArea.getText())==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha guardado una nueva calidad"
                            ,"Sistema Central",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error no se ha guardado la calidad "
                            + "\n intente mas tarde"
                            ,"Sistema Central",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return false;
    }   
        boolean MarcaUpdate(int clave)
    {
        if(aceptarjButton.getText().equalsIgnoreCase("Actualizar"))
        {
            if(ValidacionMarca()==true)
            {
            int selected = calidadjTable.getSelectedRow();
            if(selected>=0)
            {
                if(Controller.CalidadesController.Update(clave,calidadjTextField.getText()
                        , descripcionjTextArea.getText())==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la informacion de la calidad"
                            ,"Sistema Central",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error no se ha podido actualizado "
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
        }
        return false;
    }
    boolean MarcaDelete(int clave)
    {
        if(aceptarjButton.getText().equalsIgnoreCase("Eliminar"))
        {
            calidadjTable.setEnabled(true);
            if(ValidacionMarca()==true)
            {
                int selected = calidadjTable.getSelectedRow();
            if(selected>=0)
            {
                if(Controller.CalidadesController.DeleteCalidad(clave)==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado la informacion de la calidad"
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
        }
        return false;
    }
    void limpiar()
    {
        calidadjTextField.setText("");
        descripcionjTextArea.setText("");
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
        calidadjTextField = new javax.swing.JTextField();
        aceptarjButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcionjTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        buscarjTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        calidadjTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setClosable(true);
        setTitle("Calidad");
        setOpaque(true);

        principaljPanel.setBackground(new java.awt.Color(163, 220, 236));

        edicionjPanel.setBackground(new java.awt.Color(163, 220, 236));

        jLabel1.setText("Calidad:");

        jLabel2.setText("Descripcion:");

        calidadjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                calidadjTextFieldKeyTyped(evt);
            }
        });

        aceptarjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/guardar.png"))); // NOI18N
        aceptarjButton.setText("Aceptar");
        aceptarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aceptarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aceptarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarjButtonActionPerformed(evt);
            }
        });

        descripcionjTextArea.setColumns(20);
        descripcionjTextArea.setRows(5);
        descripcionjTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionjTextAreaKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(descripcionjTextArea);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Search.png"))); // NOI18N
        jLabel3.setText("Buscar:");

        javax.swing.GroupLayout edicionjPanelLayout = new javax.swing.GroupLayout(edicionjPanel);
        edicionjPanel.setLayout(edicionjPanelLayout);
        edicionjPanelLayout.setHorizontalGroup(
            edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edicionjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(calidadjTextField)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(edicionjPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(aceptarjButton))
                    .addGroup(edicionjPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        edicionjPanelLayout.setVerticalGroup(
            edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edicionjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(calidadjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(edicionjPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(edicionjPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(aceptarjButton))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edicionjPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        calidadjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Calidad", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        calidadjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calidadjTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(calidadjTable);
        calidadjTable.getColumnModel().getColumn(0).setResizable(false);
        calidadjTable.getColumnModel().getColumn(1).setResizable(false);
        calidadjTable.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout principaljPanelLayout = new javax.swing.GroupLayout(principaljPanel);
        principaljPanel.setLayout(principaljPanelLayout);
        principaljPanelLayout.setHorizontalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
            .addComponent(edicionjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        principaljPanelLayout.setVerticalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principaljPanelLayout.createSequentialGroup()
                .addComponent(edicionjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
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
        jMenu3.setText("Eliminar");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/ayuda.png"))); // NOI18N
        jMenu4.setText("Ayuda");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
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

    private void aceptarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarjButtonActionPerformed
        if(MarcaAdd()==true)
        {
            limpiar();
            edicionjPanel.setVisible(false);
            limpiarTabla();
            mostar();
        }
        int selected = calidadjTable.getSelectedRow();
        String id=calidadjTable.getValueAt(selected, 0).toString();
        int Id = Integer.parseInt(id);
        if(selected>=0)
        {
            if(MarcaDelete(Id)==true)
            {
                limpiar();
                edicionjPanel.setVisible(false);
                        limpiarTabla();
                        mostar();
            }
            
            if(MarcaUpdate(Id)==true)
            {
                limpiar();
                edicionjPanel.setVisible(false);
                        limpiarTabla();
                        mostar();
            }
        }
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

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        //Apartir de aqui abajo codifica
        
    }//GEN-LAST:event_jMenu4MouseClicked

    private void calidadjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calidadjTableMouseClicked
        CargarInfo();
    }//GEN-LAST:event_calidadjTableMouseClicked

    private void calidadjTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calidadjTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_calidadjTextFieldKeyTyped

    private void descripcionjTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionjTextAreaKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_descripcionjTextAreaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JTextField buscarjTextField;
    private javax.swing.JTable calidadjTable;
    private javax.swing.JTextField calidadjTextField;
    private javax.swing.JTextArea descripcionjTextArea;
    private javax.swing.JPanel edicionjPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel principaljPanel;
    // End of variables declaration//GEN-END:variables
}
