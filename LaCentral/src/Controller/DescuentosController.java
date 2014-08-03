package Controller;


import Model.Descuentos;
import Model.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Satellite L645D
 * @author yo 
 */
public class DescuentosController {
       public static boolean CreateDescuento(float descuento,String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Descuentos nuevo = new Descuentos();
            nuevo.setDescuento(descuento);
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
    public static List<Descuentos> ShowDescuentos()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Descuentos> busqueda=sesion.createCriteria(Descuentos.class).list();
        return busqueda;           
    }
    public static Descuentos BusquedadClave(int clave)
    {
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Descuentos busqueda=(Descuentos) sesion.createCriteria(Descuentos.class)
                .add(Restrictions.eq("claveDescuento", clave)).uniqueResult();
        return busqueda;
    }
    public static Descuentos Descuento(float descuento)
    {
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Descuentos busqueda=(Descuentos) sesion.createCriteria(Descuentos.class)
                .add(Restrictions.eq("descuento", descuento)).uniqueResult();
        return busqueda;
    }
    public static List<Descuentos> Busquedad(float clave)
    {
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Descuentos> busqueda=(List<Descuentos>) sesion.createCriteria(Descuentos.class)
                .add(Restrictions.like("descuento", "%"+clave+"%"))
                .list();
        return busqueda;
    }
    public static boolean UpdateDescuento(int clave,float descuento,String descripcion)
    {
       Session sesion=HibernateUtil.getSessionFactory().openSession();
       sesion.beginTransaction();
        try {
            Descuentos busqueda=(Descuentos) sesion.createCriteria(Descuentos.class)
                    .add(Restrictions.eq("claveDescuento", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setDescuento(descuento);
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
    public static boolean DeleteDescuento(int clave)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Descuentos busqueda=(Descuentos) sesion.createCriteria(Descuentos.class)
                    .add(Restrictions.eq("claveFormasPagos", clave)).uniqueResult();
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

    

