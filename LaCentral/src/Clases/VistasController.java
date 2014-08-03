/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import View.ModuloCliente.PrincipalCliente;
import View.ModuloProducto.PrincipalProducto;
import View.ModuloProveedor.PrincipalProveedor;
import View.ModuloVentas.PrincipalVentas;
import View.Principal;

/**
 *
 * @author Alonso
 */
public class VistasController {
    
    public static void RegresarInicio(){
        Principal inicio = new Principal();
        inicio.setVisible(true);
    }
    public static void RegresarPrincipalProveedor(){
        PrincipalProveedor inicio = new PrincipalProveedor();
        inicio.setVisible(true);
    }
    public static void RegresarPrincipalVentas(){
        PrincipalVentas inicio = new PrincipalVentas();
        inicio.setVisible(true);
    }
    public static void RegresarPrincipalCliente()
    {
        PrincipalCliente inicio = new PrincipalCliente();
        inicio.setVisible(true);
    }
    public static void RegresarPrincipalProducto()
    {
        PrincipalProducto inicio = new PrincipalProducto();
        inicio.setVisible(true);
    }
    
}
