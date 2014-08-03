package Controller;


import Model.Formaspagos;
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
 */
public class FormaspagosController 
{
    public static boolean CreateFormapago(String formapago,String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Formaspagos nuevo = new Formaspagos();
            nuevo.setFormaPago(formapago);
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
    public static List<Formaspagos> ShowFormaspagos()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Formaspagos> busqueda=sesion.createCriteria(Formaspagos.class).list();
        return busqueda;           
    }
    public static List<Formaspagos> Busqueda(String pago)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Formaspagos> busqueda=sesion.createCriteria(Formaspagos.class)
                .add(Restrictions.like("formaPago", "%"+pago+"%"))
                .list();
        return busqueda;           
    }
    public static Formaspagos BusquedadClave(int clave)
    {
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Formaspagos busqueda=(Formaspagos) sesion.createCriteria(Formaspagos.class)
                .add(Restrictions.eq("claveFormasPagos", clave)).uniqueResult();
        return busqueda;
    }
    public static boolean UpdateFormapago(int clave,String formapago,String descripcion)
    {
       Session sesion=HibernateUtil.getSessionFactory().openSession();
       sesion.beginTransaction();
        try {
            Formaspagos busqueda=(Formaspagos) sesion.createCriteria(Formaspagos.class)
                    .add(Restrictions.eq("claveFormasPagos", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setFormaPago(formapago);
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
    public static boolean DeleteFormapago(int clave)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Formaspagos busqueda=(Formaspagos) sesion.createCriteria(Formaspagos.class)
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
