/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ModuloProducto.Opcion;

import Model.Calidades;
import Model.Categorias;
import Model.Detallesproductos;
import Model.DisplayItem;
import Model.Empresasproveedoras;
import Model.Marcas;
import Model.Productos;
import Model.Sucursales;
import Model.Unidadesmediciones;
import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alonso
 */
public class AñadirProducto extends javax.swing.JFrame {

    /**
     * Creates new form AñadirProducto
     */
    public AñadirProducto() {
        initComponents();
        Mostrar();
        cargarcombo();
    }
    void cargarcombo(){
        loadCalidades();
        loadCategorias();
        loadMarcas();
        loadProveedores();
        loadSucursales();
        loadUM();
    }
    void limpiar(){
        panelIma.setIcon(null);
        productojTextField.setText("");
        descripcionjTextArea.setText("");
        preciosjTextField.setText("");
    }
    boolean ValidarProducto()
    {
        int cantidad =(int)cantidadjSpinner.getModel().getValue();
        if(productojTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puedes dejar"
                    + " \nvacio en nombre del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(productojTextField.getText().length()>=45)
        {
            JOptionPane.showMessageDialog(null, "Error no puedes sobrepasar"
                    + " \n45 letras o espacion \n para"
                    + " el nombre del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(descripcionjTextArea.getText().equalsIgnoreCase(""))
        {
          JOptionPane.showMessageDialog(null, "Error no puedes dejar"
                    + " \nvacia la descripcion del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;  
        }
            else  if(cantidad<=0)
        {
            
            JOptionPane.showMessageDialog(null, "Error no puedes dejar la cantidad"
                    + " \nde productos vacio"
                    , "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(cantidad>=10000)
        {
            JOptionPane.showMessageDialog(null, "Error no puedes sobrepasar la cantidad"
                    + " \nde 10000 productos "
                    , "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(preciosjTextField.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Error no puedes dejar vacio"
                    + " \nel precio del producto"
                    , "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            return true;
        }
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
    public  void loadMarcas()
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
        marcajComboBox.setModel(datos);
    }
 public  void loadCategorias()
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
 public  void loadProveedores()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Empresasproveedoras> resultado=Controller.EmpresaProveedoraController.showEmpresa();
        /*Se crea un objeto de tipo RecuperacionContraseña para
        * poder acceder a todos los objetos de la clase RecuperacionContraseña
        */  
        for(Empresasproveedoras o: resultado){
           DisplayItem d = new DisplayItem(o.getNombre(), o.getClaveEmpresa());
            datos.addElement(d);
        
        } 
        proveedoresjComboBox.setModel(datos);
    }
 public  void loadUM()
    {
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Unidadesmediciones> resultado=Controller.UnidadesMedicionesController.ShowUnidadesmediciones();
        /*Se crea un objeto de tipo RecuperacionContraseña para
        * poder acceder a todos los objetos de la clase RecuperacionContraseña
        */  
        for(Unidadesmediciones o: resultado){
           DisplayItem d = new DisplayItem(o.getUnidadMedicion(), o.getClaveUnidadMedicion());
            datos.addElement(d);
        
        } 
        unidadMedicionjComboBox.setModel(datos);
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
                    
                            DefaultTableModel datos=(DefaultTableModel)productojTable.getModel();
                            Vector resultado=new Vector();
                            resultado.add(detalles.getProductos().getNombre());
                            resultado.add(detalles.getExistencias());
                            resultado.add(detalles.getMarcas().getMarca());
                            resultado.add(detalles.getCalidades().getCalidad());
                            resultado.add(detalles.getCategorias().getCategoria());
                            resultado.add(detalles.getPrecioUnitario());                 
                            datos.addRow(resultado);
                }
                }
        }

    }
    
    void limpiarTabla()
    {
        while (productojTable.getRowCount()!=0)
        {
         ((DefaultTableModel)productojTable.getModel()).removeRow(0);
        }
    }
    public static String direccion;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        productojPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        productojTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionjTextArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        panelIma = new org.edisoncor.gui.panel.Panel();
        detallesProductojPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        marcajComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        categoriasjComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        proveedoresjComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        calidadesjComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cantidadjSpinner = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        unidadMedicionjComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        preciosjTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sucursaljComboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        productojTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        homejMenu = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Producto");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(163, 220, 236));

        productojPanel.setBackground(new java.awt.Color(163, 220, 236));

        jLabel1.setText("Producto:");

        productojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productojTextFieldKeyTyped(evt);
            }
        });

        jLabel3.setText("Descripción:");

        descripcionjTextArea.setColumns(20);
        descripcionjTextArea.setRows(5);
        descripcionjTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionjTextAreaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(descripcionjTextArea);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Add.png"))); // NOI18N
        jButton1.setText("Seleccionar Imagen");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImaLayout = new javax.swing.GroupLayout(panelIma);
        panelIma.setLayout(panelImaLayout);
        panelImaLayout.setHorizontalGroup(
            panelImaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelImaLayout.setVerticalGroup(
            panelImaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout productojPanelLayout = new javax.swing.GroupLayout(productojPanel);
        productojPanel.setLayout(productojPanelLayout);
        productojPanelLayout.setHorizontalGroup(
            productojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productojPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(productojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productojTextField)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(panelIma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        productojPanelLayout.setVerticalGroup(
            productojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productojPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(productojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(productojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(panelIma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        detallesProductojPanel.setBackground(new java.awt.Color(163, 220, 236));

        jLabel4.setText("Marca:");

        jLabel5.setText("Categorias:");

        jLabel6.setText("Proveedor:");

        jLabel7.setText("Calidad:");

        jLabel8.setText("Cantidad:");

        cantidadjSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 200, 1));

        jLabel9.setText("Unidad de Medicion:");

        jLabel10.setText("Precio Unitario:");

        preciosjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                preciosjTextFieldKeyTyped(evt);
            }
        });

        jLabel11.setText("en:");

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/guardar.png"))); // NOI18N
        jToggleButton3.setText("Guardar");
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jLabel12.setText("pesos");

        jLabel13.setText("Sucursal:");

        javax.swing.GroupLayout detallesProductojPanelLayout = new javax.swing.GroupLayout(detallesProductojPanel);
        detallesProductojPanel.setLayout(detallesProductojPanelLayout);
        detallesProductojPanelLayout.setHorizontalGroup(
            detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detallesProductojPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detallesProductojPanelLayout.createSequentialGroup()
                        .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sucursaljComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(marcajComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoriasjComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(proveedoresjComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calidadesjComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cantidadjSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(unidadMedicionjComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(preciosjTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)))
                    .addGroup(detallesProductojPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        detallesProductojPanelLayout.setVerticalGroup(
            detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detallesProductojPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(marcajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(categoriasjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(proveedoresjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(calidadesjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(unidadMedicionjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cantidadjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(preciosjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detallesProductojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(sucursaljComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Marca", "Calidad", "Categoria", "Precio Unitario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(productojTable);
        productojTable.getColumnModel().getColumn(0).setResizable(false);
        productojTable.getColumnModel().getColumn(1).setResizable(false);
        productojTable.getColumnModel().getColumn(2).setResizable(false);
        productojTable.getColumnModel().getColumn(3).setResizable(false);
        productojTable.getColumnModel().getColumn(4).setResizable(false);
        productojTable.getColumnModel().getColumn(5).setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(productojPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detallesProductojPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detallesProductojPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productojPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jPanel1.setBounds(300, 0, 1210, 1080);
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
        jMenu1.setText("Añadir Producto");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/Herramientas.png"))); // NOI18N
        jMenu2.setText("Mantenimiento");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_48.png"))); // NOI18N
        jMenuItem1.setText("Editar Producto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_delete_48.png"))); // NOI18N
        jMenuItem2.setText("Dar de Baja Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/user_add_48.png"))); // NOI18N
        jMenuItem3.setText("Dar de Alta Producto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/tabs_48.png"))); // NOI18N
        jMenu6.setText("Detalles de Producto");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/tabs_48.png"))); // NOI18N
        jMenuItem4.setText("Calidad de Producto");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/tabs_48.png"))); // NOI18N
        jMenuItem5.setText("Categoria de Producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/tabs_48.png"))); // NOI18N
        jMenuItem6.setText("Marcas de Producto");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar1.add(jMenu6);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_content_chart_48.png"))); // NOI18N
        jMenu4.setText("Reportes");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_48.png"))); // NOI18N
        jMenuItem7.setText("Inventario");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/paper_content_48.png"))); // NOI18N
        jMenuItem8.setText("Productos mas vendidos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        homejMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/inicio.png"))); // NOI18N
        homejMenu.setText("Volver a Menu Principal");
        homejMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homejMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(homejMenu);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser selector=new JFileChooser();
        FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        selector.setFileFilter(filtroImagen);
        int r=selector.showOpenDialog(null);
        if(r==JFileChooser.APPROVE_OPTION){
            try {
            File f=selector.getSelectedFile();
            panelIma.setIcon(new ImageIcon(f.getAbsolutePath()));
            panelIma.removeAll();
            panelIma.updateUI();
            direccion=f.getAbsolutePath();
            } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if(ValidarProducto()==true)
        {
            if(Controller.ProductosController.createProducto(productojTextField.getText(), direccion
                    , descripcionjTextArea.getText())==true)
            {
                float precio =Float.parseFloat(preciosjTextField.getText());
                Calendar hoy = Calendar.getInstance();
                int existencias = (int) cantidadjSpinner.getModel().getValue();
                Productos producto = Controller.ProductosController.BusquedaClave(Controller.ProductosController.IdLastProduct());
                Calidades calidad = Controller.CalidadesController.BusquedaCalidad(calidadesjComboBox.getSelectedItem().toString());
                Categorias categoria = Controller.CategoriasController.BusquedaCategoria(categoriasjComboBox.getSelectedItem().toString());
                Marcas marca = Controller.MarcasController.BusquedaMarca(marcajComboBox.getSelectedItem().toString());
                Unidadesmediciones unidad = Controller.UnidadesMedicionesController.BusquedaUnidad(unidadMedicionjComboBox.getSelectedItem().toString());
                Sucursales sucursal = Controller.SucursalesController.Sucursal(sucursaljComboBox.getSelectedItem().toString());
                Empresasproveedoras empresa = Controller.EmpresaProveedoraController.busquedaEmpresa(proveedoresjComboBox.getSelectedItem().toString());
               
                if(Controller.DetallesProductosController.CreateDetalleProducto
                        (precio, hoy.getTime(), existencias, true, producto, calidad, categoria, marca, unidad, empresa, sucursal)
                        ==true)
                {
                    JOptionPane.showMessageDialog(null, "Guardado exitosamente","Sistema Cental", JOptionPane.INFORMATION_MESSAGE);
                    limpiarTabla();
                    Mostrar();
                    limpiar();  
                }else{
                    JOptionPane.showMessageDialog(null, "Error intente mas tarde","Sistema Cental", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new AñadirProducto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new EditarProducto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new BajaProducto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new AltaProducto().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        DetallesProducto nuevo =new DetallesProducto();

        nuevo.setVisible(true);
        nuevo.ViewCalidad();
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        DetallesProducto nuevo =new DetallesProducto();
        nuevo.setVisible(true);
        nuevo.ViewCategoria();
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        DetallesProducto nuevo =new DetallesProducto();
        nuevo.setVisible(true);
        nuevo.ViewMarca();
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //Aqui va el codigo para imprimir
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new ReporteProducto().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        new ReporteProducto().setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void homejMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homejMenuMouseClicked
        Clases.VistasController.RegresarPrincipalProducto();
        dispose();
    }//GEN-LAST:event_homejMenuMouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        new AyudaProducto().setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void productojTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productojTextFieldKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_productojTextFieldKeyTyped

    private void descripcionjTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionjTextAreaKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_descripcionjTextAreaKeyTyped

    private void preciosjTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preciosjTextFieldKeyTyped
        char car = evt.getKeyChar();
        if(preciosjTextField.getText().length()>=8) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_preciosjTextFieldKeyTyped

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
            java.util.logging.Logger.getLogger(AñadirProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirProducto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox calidadesjComboBox;
    private javax.swing.JSpinner cantidadjSpinner;
    private javax.swing.JComboBox categoriasjComboBox;
    private javax.swing.JTextArea descripcionjTextArea;
    private javax.swing.JPanel detallesProductojPanel;
    private javax.swing.JMenu homejMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JComboBox marcajComboBox;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panelIma;
    private javax.swing.JTextField preciosjTextField;
    private javax.swing.JPanel productojPanel;
    private javax.swing.JTable productojTable;
    private javax.swing.JTextField productojTextField;
    private javax.swing.JComboBox proveedoresjComboBox;
    private javax.swing.JComboBox sucursaljComboBox;
    private javax.swing.JComboBox unidadMedicionjComboBox;
    // End of variables declaration//GEN-END:variables
}
