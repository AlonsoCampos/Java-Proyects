/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DisplayItem;
import Model.Domicilios;
import Model.Municipios;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class Direccion extends javax.swing.JFrame {

    /**
     * Creates new form Direccion
     */
    public Direccion() {
        initComponents();
        loadMunicipios();
        ocultar(false);
        mostar();
    }
    void limpiar()
    {
        callejTextField.setText("");
        numeroInternojTextField.setText("");
        numeroExternojTextField.setText("");
    }
    void mostar()
    {
        List<Domicilios>consultar = Controller.DomiciliosController.ShowDomicilios();
        //para saber si hay elemtos en la lista
        if(consultar.size()>0){
        Iterator elemento=consultar.iterator();
        //hasNext()= si hay un elemto adelante avanzar
        while(elemento.hasNext())
        {
           DefaultTableModel datos=(DefaultTableModel)direccionesjTable.getModel();
        //El vector es para agregar datos a la tabla
        Vector resultado=new Vector();      
        Domicilios registro=(Domicilios)elemento.next();
        resultado.add(registro.getClaveDomicilio());
        resultado.add(registro.getDomicilio());
        resultado.add(registro.getNumeroInterno());
        resultado.add(registro.getNumeroExterno());
        resultado.add(registro.getMunicipios().getMunicipio());
        datos.addRow(resultado);
        }
        }else{
            System.out.print("No hay registros a mostrar");
        }
    }
    void limpiarTabla()
    {
        while (direccionesjTable.getRowCount()!=0)
        {
         ((DefaultTableModel)direccionesjTable.getModel()).removeRow(0);
        }
    }
    void ocultar(boolean activo)
    {
        jLabel1.setVisible(activo);
        jLabel2.setVisible(activo);
        jLabel3.setVisible(activo);
        jLabel4.setVisible(activo);
        callejTextField.setVisible(activo);
        numeroInternojTextField.setVisible(activo);
        numeroExternojTextField.setVisible(activo);
        municipiosjComboBox.setVisible(activo);
        accionjButton.setVisible(activo);
    }
   
    public  void loadMunicipios()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Municipios> resultado=Controller.MunicipiosController.ShowMunicipios();
        /*Se crea un objeto de tipo RecuperacionContraseña para
        * poder acceder a todos los objetos de la clase RecuperacionContraseña
        */  
        for(Municipios o: resultado){
           DisplayItem d = new DisplayItem(o.getMunicipio(), o.getClaveMunicipio());
            datos.addElement(d);
        
        } 
        municipiosjComboBox.setModel(datos);
    }
    void Registro()
    {
            int selected = direccionesjTable.getSelectedRow();    
            String clave=direccionesjTable.getValueAt(selected, 0).toString();
            Domicilios mostrar = Controller.DomiciliosController.BusquedaClave(Integer.parseInt(clave));
            callejTextField.setText(mostrar.getDomicilio());
            numeroInternojTextField.setText(String.valueOf(mostrar.getNumeroInterno()));
            numeroExternojTextField.setText(String.valueOf(mostrar.getNumeroExterno()));
            municipiosjComboBox.setSelectedItem(mostrar.getMunicipios().getMunicipio());
    }
    boolean validarDirecciones()
    {
        if(callejTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puede dejar vacia"
                    + "\n la calle ingrese una calle"
                   ,"Ingresa una calle por favor", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(callejTextField.getText().length()>= 50){
            JOptionPane.showMessageDialog(null, "Error no puedes sobrepasar"
                    + "\n los 45 caracteres para una calle"
                   ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;            
        }
        else if(numeroInternojTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puede dejar vacia"
                    + "\n el numero interno de la calle"
                   ,"Ingresa el numero interno de la calle por favor", JOptionPane.ERROR_MESSAGE); 
             return false;
        }
        else if(numeroInternojTextField.getText().length()>= 3){
            JOptionPane.showMessageDialog(null, "Error no puede sobrepasar del"
                    + "\n 3 numeros"
                   ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;            
        }      
        else if(numeroExternojTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puede dejar vacia"
                    + "\n el numero externo de la calle"
                   ,"Ingresa el numero externo de la calle por favor", JOptionPane.ERROR_MESSAGE);  
             return false;
        }
        else if(numeroExternojTextField.getText().length()>= 3)
        {
            JOptionPane.showMessageDialog(null, "Error no sobrepasar"
                    + "\n del 3 numeros"
                   ,"Error", JOptionPane.ERROR_MESSAGE);
            return false;            
        }
        else
        {
             return true;
        }
    }
    void Agregar(){
        if(validarDirecciones()==true)
        {
            Municipios municipio = Controller.MunicipiosController.
                    BusquedaMunicipio(municipiosjComboBox.getSelectedItem().toString());
            if(Controller.DomiciliosController.CreateDomicilio(callejTextField.getText()
                    ,numeroInternojTextField.getText(),
                    numeroExternojTextField.getText()
                    ,municipio)==true)
            {
                limpiar();
                JOptionPane.showMessageDialog(null, "Guardado Exitosamente", "Sistema Central",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiarTabla();
                mostar();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error no se ha guardado intente nuevamente"
                        ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    void Modificar(int id){
        if(validarDirecciones()==true)
        {
            Municipios municipio = Controller.MunicipiosController.
                    BusquedaMunicipio(municipiosjComboBox.getSelectedItem().toString());
            if(Controller.DomiciliosController.UpdateDomicilio(id,callejTextField.getText()
                    ,numeroInternojTextField.getText(),
                    numeroExternojTextField.getText()
                    ,municipio)==true)
            {
                limpiar();
                JOptionPane.showMessageDialog(null, "Registro Actualizado Exitosamente", "Sistema Central",
                        JOptionPane.INFORMATION_MESSAGE);
                
                limpiarTabla();
                mostar();

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error no se ha actualizar intente nuevamente"
                        ,"Sistema Central", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    void Accion(String opcion)
    {
            
        switch(opcion)
        {  
            case "Guardar":
                Agregar();
                break;
            case "Actualizar":
                int selecte = direccionesjTable.getSelectedRow();        
                String codig=direccionesjTable.getValueAt(selecte, 0).toString();
                if(direccionesjTable.getSelectedRow()!=0)
                {
                     Modificar(Integer.parseInt(codig));  
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error tienes que seleccionar"
                            + " un registro a editar","Sistema Central",JOptionPane.ERROR_MESSAGE );
                }
                break;
                
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
        jLabel1 = new javax.swing.JLabel();
        callejTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numeroInternojTextField = new javax.swing.JTextField();
        numeroExternojTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        municipiosjComboBox = new javax.swing.JComboBox();
        accionjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        direccionesjTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Direcciones");
        setResizable(false);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Ima/Fondo_2.png"))); // NOI18N

        jLabel1.setText("Calle:");

        callejTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                callejTextFieldKeyTyped(evt);
            }
        });

        jLabel2.setText("Numero Interno:");

        jLabel3.setText("Numero Externo:");

        numeroInternojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroInternojTextFieldKeyTyped(evt);
            }
        });

        numeroExternojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroExternojTextFieldKeyTyped(evt);
            }
        });

        jLabel4.setText("Municipio:");

        accionjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/guardar.png"))); // NOI18N
        accionjButton.setText("Guardar");
        accionjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        accionjButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        accionjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionjButtonActionPerformed(evt);
            }
        });

        direccionesjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Calle", "Numero Interno", "Numero Externo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        direccionesjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                direccionesjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(direccionesjTable);
        direccionesjTable.getColumnModel().getColumn(0).setResizable(false);
        direccionesjTable.getColumnModel().getColumn(1).setResizable(false);
        direccionesjTable.getColumnModel().getColumn(2).setResizable(false);
        direccionesjTable.getColumnModel().getColumn(3).setResizable(false);
        direccionesjTable.getColumnModel().getColumn(4).setResizable(false);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(municipiosjComboBox, 0, 149, Short.MAX_VALUE)
                            .addComponent(numeroExternojTextField)
                            .addComponent(numeroInternojTextField)
                            .addComponent(callejTextField))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(accionjButton)
                        .addGap(52, 52, 52)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(callejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numeroInternojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numeroExternojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(municipiosjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(accionjButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/agregar.png"))); // NOI18N
        jMenu1.setText("Agregar");
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

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/izquierda.png"))); // NOI18N
        jMenu3.setText("Regresar");
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
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        accionjButton.setText("Guardar");
        ocultar(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        accionjButton.setText("Actualizar");
        ocultar(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void accionjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionjButtonActionPerformed
        Accion(accionjButton.getText());
        ocultar(true);
    }//GEN-LAST:event_accionjButtonActionPerformed

    private void direccionesjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_direccionesjTableMouseClicked
            if(!"Guardar".equals(accionjButton.getText()))
            {
                Registro();
            } 
    }//GEN-LAST:event_direccionesjTableMouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        Clases.VistasController.RegresarPrincipalCliente();
        dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void callejTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_callejTextFieldKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_callejTextFieldKeyTyped

    private void numeroInternojTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroInternojTextFieldKeyTyped
char car = evt.getKeyChar();
if(numeroInternojTextField.getText().length()>=8) evt.consume();
if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_numeroInternojTextFieldKeyTyped

    private void numeroExternojTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroExternojTextFieldKeyTyped
char car = evt.getKeyChar();
if(numeroExternojTextField.getText().length()>=8) evt.consume();
if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_numeroExternojTextFieldKeyTyped

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
            java.util.logging.Logger.getLogger(Direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Direccion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accionjButton;
    private javax.swing.JTextField callejTextField;
    private javax.swing.JTable direccionesjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox municipiosjComboBox;
    private javax.swing.JTextField numeroExternojTextField;
    private javax.swing.JTextField numeroInternojTextField;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
