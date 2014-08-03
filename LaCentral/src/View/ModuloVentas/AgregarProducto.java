/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloVentas;

import Model.Calidades;
import Model.Categorias;
import Model.Detallesproductos;
import Model.DisplayItem;
import Model.Marcas;
import Model.Productos;
import View.ModuloVentas.Opcion.AñadirVenta;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class AgregarProducto extends javax.swing.JInternalFrame {
    java.util.LinkedList<Clases.ListaProductos> lista;
    
    /**
     * Creates new form AgregarProducto
     */
    public AgregarProducto() {
        lista = new java.util.LinkedList<>();
        initComponents();
        loadCalidades();
        loadCategorias();
        loadMarca();
        loadProducto();
        Mostrar();
    }
    void Mostrar()
    {
           for(Productos producto: Controller.ProductosController.ShowProductos())
        {
            for(Detallesproductos detalles: Controller.DetallesProductosController.showDetallesproductos())
            {
                String produc=String.valueOf(producto.getClaveProducto());
                String detallesP= String.valueOf(detalles.getProductos().getClaveProducto());
                if(produc.equalsIgnoreCase(detallesP))
                {
                    
                            DefaultTableModel datos=(DefaultTableModel)productosjTable.getModel();
                            Vector resultado=new Vector();
                            resultado.add(detalles.getProductos().getClaveProducto());
                            resultado.add(detalles.getProductos().getNombre());
                            resultado.add(detalles.getExistencias());
                            resultado.add(detalles.getPrecioUnitario());
                            resultado.add(detalles.getProductos().getDescripcion());                 
                            datos.addRow(resultado);
                }
                }
        }

    }
    
 void loadCategorias()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Categorias> resultado=Controller.CategoriasController.ShowCategorias();
        /*Se crea un objeto de tipo RecuperacionContraseña para
        * poder acceder a todos los objetos de la clase RecuperacionContraseña
        */  
        for(Categorias o: resultado){
           DisplayItem d = new DisplayItem(o.getCategoria(), o.getClaveCategoria());
            datos.addElement(d);
        
        } 
        categoriasjComboBox.setModel(datos);
    }
 public  void loadCalidades()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Calidades> resultado=Controller.CalidadesController.ShowCalidades();
        /*Se crea un objeto de tipo RecuperacionContraseña para
        * poder acceder a todos los objetos de la clase RecuperacionContraseña
        */  
        for(Calidades o: resultado){
           DisplayItem d = new DisplayItem(o.getCalidad(), o.getClaveCalidad());
            datos.addElement(d);
        
        } 
        calidadesjComboBox.setModel(datos);
    }
 public  void loadProducto()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Productos> resultado=Controller.ProductosController.ShowProductos();
        /*Se crea un objeto de tipo RecuperacionContraseña para
        * poder acceder a todos los objetos de la clase RecuperacionContraseña
        */  
        for(Productos  o: resultado){
           DisplayItem d = new DisplayItem(o.getNombre(), o.getClaveProducto());
            datos.addElement(d);
        
        } 
        productosjComboBox.setModel(datos);
    }
 public  void loadMarca()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Marcas> resultado=Controller.MarcasController.ShowMarcas();
        /*Se crea un objeto de tipo RecuperacionContraseña para
        * poder acceder a todos los objetos de la clase RecuperacionContraseña
        */  
        for(Marcas o: resultado){
           DisplayItem d = new DisplayItem(o.getMarca(), o.getClaveMarca());
            datos.addElement(d);
        
        } 
        marcasjComboBox.setModel(datos);
    }
 public void Listar(){
        javax.swing.DefaultListModel modelo;
        modelo= new javax.swing.DefaultListModel();
        for (int i = 0; i < lista.size(); i++)
        {
            modelo.addElement("Codigo: "+lista.get(i).getId()+" Producto: "+lista.get(i).getProducto()+" Cantidad: "+lista.get(i).getCantidad());
            AñadirVenta.productosjList.setModel(modelo);
        }
 }
 public void Subtotal()
 {
        double sumatoria = 0;
        for (int i = 0; i < lista.size(); i++) {
            sumatoria=sumatoria+lista.get(i).getCantidad();
        }
        AñadirVenta.subtotaljTextField.setText(String.valueOf(sumatoria));
 }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel3 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        categoriasjComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        productosjComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        marcasjComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        productosjTable = new javax.swing.JTable();
        imapanel = new org.edisoncor.gui.panel.Panel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        calidadesjComboBox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cantidadjSpinner = new javax.swing.JSpinner();

        setClosable(true);

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Ima/Fondo.png"))); // NOI18N

        jLabel1.setText("Categoria:");

        categoriasjComboBox.setEnabled(false);

        jLabel2.setText("Producto:");

        productosjComboBox.setEnabled(false);

        jLabel3.setText("Marca:");

        marcasjComboBox.setEnabled(false);

        productosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Existencias", "Precio", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productosjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productosjTable);
        productosjTable.getColumnModel().getColumn(0).setResizable(false);
        productosjTable.getColumnModel().getColumn(1).setResizable(false);
        productosjTable.getColumnModel().getColumn(2).setResizable(false);
        productosjTable.getColumnModel().getColumn(3).setResizable(false);
        productosjTable.getColumnModel().getColumn(4).setResizable(false);

        javax.swing.GroupLayout imapanelLayout = new javax.swing.GroupLayout(imapanel);
        imapanel.setLayout(imapanelLayout);
        imapanelLayout.setHorizontalGroup(
            imapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        imapanelLayout.setVerticalGroup(
            imapanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/agregar.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Calidad:");

        calidadesjComboBox.setEnabled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Eliminar.png"))); // NOI18N
        jButton2.setText("Remover");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad:");

        cantidadjSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 200, 1));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calidadesjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(48, 48, 48))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(cantidadjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(imapanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(marcasjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(281, 281, 281))
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(productosjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(281, 281, 281))
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(categoriasjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(281, 281, 281))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(imapanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(categoriasjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(productosjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(marcasjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(calidadesjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cantidadjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosjTableMouseClicked
        for(Productos producto: Controller.ProductosController.ShowProductos())
        {
            for(Detallesproductos detalles: Controller.DetallesProductosController.showDetallesproductos())
            {
                String produc=String.valueOf(producto.getClaveProducto());
                String detallesP= String.valueOf(detalles.getProductos().getClaveProducto());
                    if(produc.equalsIgnoreCase(detallesP))
                    {
                        int selected = productosjTable.getSelectedRow();    
                        String codigo=productosjTable.getValueAt(selected, 0).toString();
                        if(codigo.equalsIgnoreCase(produc))
                        {
                            categoriasjComboBox.setSelectedItem(detalles.getCategorias().getCategoria());
                            productosjComboBox.setSelectedItem(detalles.getProductos().getNombre());
                            calidadesjComboBox.setSelectedItem(detalles.getCalidades().getCalidad());
                            cantidadjSpinner.setValue(detalles.getExistencias());
                            marcasjComboBox.setSelectedItem(detalles.getMarcas().getMarca());
                            imapanel.setIcon(new ImageIcon(detalles.getProductos().getImagen()));
                            imapanel.removeAll();
                            imapanel.updateUI();
                        }
                    }
                }
        }
    }//GEN-LAST:event_productosjTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for(Productos producto: Controller.ProductosController.ShowProductos())
        {
            for(Detallesproductos detalles: Controller.DetallesProductosController.showDetallesproductos())
            {
                String produc=String.valueOf(producto.getClaveProducto());
                String detallesP= String.valueOf(detalles.getProductos().getClaveProducto());
                    if(produc.equalsIgnoreCase(detallesP))
                    {
                        int selected = productosjTable.getSelectedRow();    
                        String codigo=productosjTable.getValueAt(selected, 0).toString();
                        if(codigo.equalsIgnoreCase(produc))
                        {
                            String nombreProducto=productosjTable.getValueAt(selected, 1).toString();
                            int cantidad =Integer.parseInt(cantidadjSpinner.getValue().toString());
                            float precio = Float.parseFloat(productosjTable.getValueAt(selected, 3).toString());
                            lista.add(new Clases.ListaProductos(producto.getClaveProducto(), producto.getNombre(),cantidad, precio));
                            Listar();
                            dispose();
                        }
                    }
                }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        lista.removeFirst();
        Listar();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox calidadesjComboBox;
    private javax.swing.JSpinner cantidadjSpinner;
    private javax.swing.JComboBox categoriasjComboBox;
    private org.edisoncor.gui.panel.Panel imapanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox marcasjComboBox;
    private org.edisoncor.gui.panel.Panel panel3;
    private javax.swing.JComboBox productosjComboBox;
    private javax.swing.JTable productosjTable;
    // End of variables declaration//GEN-END:variables
}
