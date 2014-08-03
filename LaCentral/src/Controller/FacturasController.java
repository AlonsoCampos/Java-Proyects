package Controller;


import Model.Comprasclientes;
import Model.Facturas;
import Model.HibernateUtil;
import Model.Historiales;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Satellite L645D
 */
public class FacturasController
{
    public static boolean Factura(Date fechafactura,Historiales historial,Comprasclientes ventas)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Facturas nuevo = new Facturas();
            nuevo.setFechaFactura(fechafactura);
            nuevo.setComprasclientes(ventas);
            nuevo.setHistoriales(historial);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
             System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    public static List<Facturas> ShowFacturas()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Facturas> busqueda= sesion.createCriteria(Facturas.class).list();
        return busqueda;
    }
    public static Facturas BusquedaClave(int clave)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        Facturas busqueda=(Facturas) sesion.createCriteria(Facturas.class)
                .add(Restrictions.eq("claveFactura", clave)).uniqueResult();
        return busqueda;
    }
    public static boolean UpdateFactura(int clave,Date fechafactura,Historiales historial,
            Comprasclientes ventas)
    {
       Session sesion =HibernateUtil.getSessionFactory().openSession();
       sesion.beginTransaction();
        try {
            Facturas busqueda = (Facturas) sesion.createCriteria(Facturas.class)
                    .add(Restrictions.eq("claveFactura", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setFechaFactura(fechafactura);
                busqueda.setHistoriales(historial);
                busqueda.setComprasclientes(ventas);
                sesion.update(busqueda);
                sesion.getTransaction().commit();
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    public static boolean DeleteFactura(int clave)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Facturas busqueda=(Facturas) sesion.createCriteria(Facturas.class)
                    .add(Restrictions.eq("claveFactura", clave)).uniqueResult();
            if(busqueda !=null)
            {
                sesion.delete(busqueda);
                sesion.getTransaction().commit();
                return true;
                
            }else{
                return false;
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
}
