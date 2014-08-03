/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloProducto;

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
public class MarcaProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form MarcaProducto
     */
    public MarcaProducto() {
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
        List<Marcas>consultar = Controller.MarcasController.Marca(buscarjTextField.getText());
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)marcajTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Marcas registro=(Marcas)elemento.next();
        resultado.add(registro.getClaveMarca());
        resultado.add(registro.getMarca());
        resultado.add(registro.getDescripcion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
        void mostar()
        {
        List<Marcas>consultar = Controller.MarcasController.ShowMarcas();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)marcajTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Marcas registro=(Marcas)elemento.next();
        resultado.add(registro.getClaveMarca());
        resultado.add(registro.getMarca());
        resultado.add(registro.getDescripcion());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
    void limpiarTabla()
    {
        while (marcajTable.getRowCount()!=0)
        {
         ((DefaultTableModel)marcajTable.getModel()).removeRow(0);
        }
    }
    
    boolean ValidacionMarca(){
        if(marcajTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puede dejar"
                    + " el\n nombre de la marca vacio"
                    ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(marcajTextField.getText().length()>=20)
        {
            JOptionPane.showMessageDialog(null, "Error no puede"
                    + " sobrepasar mas de 20 letras o espacios"
                    ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(descripcionjTextArea.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puede dejar"
                    + " la\n  descripcion de la marca vacio"
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
            int selected = marcajTable.getSelectedRow();    
            String clave=marcajTable.getValueAt(selected, 0).toString();
            Marcas mostrar = Controller.MarcasController.BusquedaClave(Integer.parseInt(clave));
            marcajTextField.setText(mostrar.getMarca());
            descripcionjTextArea.setText(mostrar.getDescripcion());
    }
    boolean MarcaAdd()
    {
        if(aceptarjButton.getText().equalsIgnoreCase("Guardar"))
        {
            if(ValidacionMarca()==true)
            {
                if(Controller.MarcasController.CreateMarca(marcajTextField.getText()
                        , descripcionjTextArea.getText())==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha guardado una nueva marca"
                            ,"Sistema Central",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error no se ha guardado la marca "
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
                int selected = marcajTable.getSelectedRow();
            if(selected>=0)
            {
                if(Controller.MarcasController.UpdateMarca(clave,marcajTextField.getText()
                        , descripcionjTextArea.getText())==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la informacion de la marca"
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
            if(ValidacionMarca()==true)
            {
                int selected = marcajTable.getSelectedRow();
            if(selected>=0)
            {
                if(Controller.MarcasController.DeleteMarca(clave)==true)
                {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado la informacion de la marca"
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
        marcajTextField.setText("");
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
        marcajTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionjTextArea = new javax.swing.JTextArea();
        aceptarjButton = new javax.swing.JButton();
        buscarjTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        marcajTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setClosable(true);
        setTitle("Marca de Producto");

        principaljPanel.setBackground(new java.awt.Color(163, 220, 236));

        edicionjPanel.setBackground(new java.awt.Color(163, 220, 236));

        jLabel1.setText("Marca:");

        jLabel2.setText("Descripcion:");

        marcajTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcajTextFieldKeyTyped(evt);
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(marcajTextField))
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(edicionjPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(aceptarjButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edicionjPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        edicionjPanelLayout.setVerticalGroup(
            edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edicionjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(marcajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptarjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(edicionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)))
        );

        marcajTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Marca", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        marcajTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                marcajTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(marcajTable);
        marcajTable.getColumnModel().getColumn(0).setResizable(false);
        marcajTable.getColumnModel().getColumn(1).setResizable(false);
        marcajTable.getColumnModel().getColumn(2).setResizable(false);

        javax.swing.GroupLayout principaljPanelLayout = new javax.swing.GroupLayout(principaljPanel);
        principaljPanel.setLayout(principaljPanelLayout);
        principaljPanelLayout.setHorizontalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edicionjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        principaljPanelLayout.setVerticalGroup(
            principaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principaljPanelLayout.createSequentialGroup()
                .addComponent(edicionjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/agregar.png"))); // NOI18N
        jMenu1.setText("Nuevo ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/actualizar.png"))); // NOI18N
        jMenu2.setText("Editar ");
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
        int selected = marcajTable.getSelectedRow();
        String id=marcajTable.getValueAt(selected, 0).toString();
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

    private void marcajTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marcajTableMouseClicked
        CargarInfo();
    }//GEN-LAST:event_marcajTableMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        edicionjPanel.setVisible(true);
        aceptarjButton.setText("Actualizar");
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        edicionjPanel.setVisible(true);
        aceptarjButton.setText("Eliminar");
    }//GEN-LAST:event_jMenu3MouseClicked

    private void marcajTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcajTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_marcajTextFieldKeyTyped

    private void descripcionjTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionjTextAreaKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_descripcionjTextAreaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarjButton;
    private javax.swing.JTextField buscarjTextField;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable marcajTable;
    private javax.swing.JTextField marcajTextField;
    private javax.swing.JPanel principaljPanel;
    // End of variables declaration//GEN-END:variables
}
