package Controller;


import Model.Estados;
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
public class EstadosController 
{
    public static boolean CreateEstado(String estado, String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Estados nuevo = new Estados();
            nuevo.setEstado(estado);
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
    public static List<Estados> ShowEstados ()
    {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       List<Estados> busqueda = sesion.createCriteria(Estados.class).list();
       return busqueda;
    }
    public static Estados Busqueda(int clave)
    {
      Session sesion =HibernateUtil.getSessionFactory().openSession();
      Estados busqueda = (Estados) sesion.createCriteria(Estados.class)
              .add(Restrictions.eq("claveEstado", clave)).uniqueResult();
      return busqueda;
    }
    public static Estados estado(String estado)
    {
      Session sesion =HibernateUtil.getSessionFactory().openSession();
      Estados busqueda = (Estados) sesion.createCriteria(Estados.class)
              .add(Restrictions.eq("estado", estado)).uniqueResult();
      return busqueda;
    }
    public static boolean UpdateEstados(int clave,String estado, String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Estados busqueda = (Estados) sesion.createCriteria(Estados.class)
                    .add(Restrictions.eq("claveEstado", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setEstado(estado);
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
    public static boolean DeleteEstado(int clave)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Estados busqueda= (Estados) sesion.createCriteria(Estados.class)
                    .add(Restrictions.eq("claveEstado", clave)).uniqueResult();
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
