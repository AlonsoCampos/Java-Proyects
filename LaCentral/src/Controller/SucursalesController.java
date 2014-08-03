/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HibernateUtil;
import Model.Sucursales;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alonso
 */
public class SucursalesController {
 
    public static boolean CreateSucursal(String sucursal, String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Sucursales nueva = new Sucursales();
            nueva.setNombre(sucursal);
            nueva.setDescripcion(descripcion);
            sesion.save(nueva);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    public static boolean UpdateSucursal (int clave, String sucursal, String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Sucursales busqueda = (Sucursales) sesion.createCriteria(Sucursales.class).add(
                    Restrictions.eq("claveSucursal", clave)).uniqueResult();
            if(busqueda!=null)
            {
                busqueda.setNombre(sucursal);
                busqueda.setDescripcion(descripcion);
                sesion.update(busqueda);
                sesion.getTransaction().commit();
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error no existe el registro",
                        "Registro no encontrado", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    public static boolean DeleteSucursal(int sucursal)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Sucursales buscar = (Sucursales)sesion.createCriteria(Sucursales.class)
                    .add(Restrictions.eq("claveSucursal", sucursal)).uniqueResult();
            if(buscar!=null)
            {
                sesion.delete(buscar);
                sesion.getTransaction().commit();
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error no existe el registro",
                        "Registro no encontrado", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    public static List<Sucursales> ShowSucursales (){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Sucursales> busqueda = sesion.createCriteria(Sucursales.class).list();
        return (List<Sucursales>) busqueda;
    }
     public static List<Sucursales> Busqueda(String nombre)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
         List<Sucursales> resultado= sesion.createCriteria(Sucursales.class)
                 .add(Restrictions.like("nombre", "%"+nombre+"%")).list();
        return resultado;
    
    }
    public static List<Sucursales> BusquedaD(String descripcion)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
         List<Sucursales> resultado= sesion.createCriteria(Sucursales.class)
                 .add(Restrictions.like("descripcion", "%"+descripcion+"%")).list();
        return resultado;
    
    }
    public static Sucursales Sucursal(String nombre)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Sucursales buscar = (Sucursales) sesion.createCriteria(Sucursales.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
            return buscar;
    }
    public static boolean SucursalExistente(String nombre)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Sucursales buscar = (Sucursales) sesion.createCriteria(Sucursales.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
                if(buscar!=null)
                {
                    return false;
                }else{
                    return true;
                }
    }
     public static Sucursales Sucursal(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Sucursales buscar = (Sucursales) sesion.createCriteria(Sucursales.class)
                .add(Restrictions.eq("claveSucursal", clave))
                .uniqueResult();
        if(buscar!=null)
        {
            return buscar;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error no existe el registro",
                        "Registro no encontrado", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
    }
  
}
