/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Model.Detallescompras;
import Model.HibernateUtil;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Yoshi
 */
public class MultipleRelation 
{
    public static void main (String args[])
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
        Detallescompras compra = new Detallescompras();
        int clave = Integer.parseInt(JOptionPane.showInputDialog("Cliente"));
        int producto = Integer.parseInt(JOptionPane.showInputDialog("Produrco"));
        compra.setComprasclientes(Controller.ComprasclientesController.BusquedaClave(clave));
        compra.setProductos(Controller.ProductosController.BusquedaClave(producto));
        compra.setCantidad(12);
        sesion.save(compra);
        sesion.getTransaction().commit();    
        } catch (HeadlessException | NumberFormatException | HibernateException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
