package Controller;


import Model.Codigospostales;
import Model.HibernateUtil;
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
public class CodigospostalesController 
{
    public static boolean CreateCodigopostal(String codigopostal, String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Codigospostales nuevo = new Codigospostales();
            nuevo.setCodigoPostal(codigopostal);
            nuevo.setDescripcion(descripcion);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }        
    public static List<Codigospostales> ShowCodigospostales()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Codigospostales> busqueda = sesion.createCriteria(Codigospostales.class).list();
        return busqueda;
    }
    public static Codigospostales BusquedaClave(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Codigospostales busqueda = (Codigospostales) sesion.createCriteria(Codigospostales.class)
                .add(Restrictions.eq("clveCodigoPostal", clave)).uniqueResult();
        return busqueda;
    }
    public static boolean UpdateCodigopostal(int clave, String codigopostal,String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Codigospostales busqueda = (Codigospostales) sesion.createCriteria(Codigospostales.class)
                    .add(Restrictions.eq("clveCodigoPostal", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setCodigoPostal(codigopostal);
                busqueda.setDescripcion(descripcion);
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
    public static boolean DeleteCodigopostal (int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Codigospostales busqueda = (Codigospostales) sesion.createCriteria(Codigospostales.class)
                    .add(Restrictions.eq("claveCodigoPostal", clave)).uniqueResult();
            if(busqueda !=null)
            {
                sesion.delete(busqueda);
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
    
}
