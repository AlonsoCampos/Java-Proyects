/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import View.ModuloVentas.AgregarProducto;
import View.SeleccionarCliente;
import View.SeleccionarDireccion;
import View.SeleccionarDireccionContacto;
import View.SeleccionarDireccionEmpresa;

/**
 *
 * @author Alonso
 */
public class Singleton 
{
    private static SeleccionarCliente instancia;
    
    public static SeleccionarCliente getInstancia()
    {
        if(instancia==null)
        {
            instancia= new SeleccionarCliente();
        }
        return instancia;
    }
    
    private static SeleccionarDireccion direccion;
    
    public static SeleccionarDireccion getDireccion()
    {
        if(direccion==null)
        {
            direccion= new SeleccionarDireccion();
        }
        return direccion;
    }
    
    private static SeleccionarDireccionContacto direccionContacto;
    public static SeleccionarDireccionContacto getDireccionContacto()
    {
        if(direccionContacto==null)
        {
            direccionContacto= new SeleccionarDireccionContacto();
        }
        return direccionContacto;
    }
    
    private static SeleccionarDireccionEmpresa direccionEmpresa;
    
    public static SeleccionarDireccionEmpresa getDireccionEmpresa()
    {
        if(direccionEmpresa==null)
        {
            direccionEmpresa= new SeleccionarDireccionEmpresa();
        }
        return direccionEmpresa;
    }
    
    private static AgregarProducto addProducto;
    
    public static AgregarProducto getProductoAdd()
    {
        if(addProducto==null)
        {
            addProducto= new AgregarProducto();
        }
        return addProducto;
    }
}
