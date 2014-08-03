package Controller;


import Model.Domicilios;
import Model.HibernateUtil;
import Model.Personas;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Satellite L645D
 */
public class PersonasController {
     public static boolean CreatePersona (String nombre,String apellidopaterno,String apellidomaterno,
             String telefono,Domicilios domicilio) 
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Personas nuevo = new Personas();
            nuevo.setNombre(nombre);
            nuevo.setApellidoPaterno(apellidopaterno);
            nuevo.setApellidoMaterno(apellidomaterno);
            nuevo.setTelefono(telefono);
            nuevo.setDomicilios(domicilio);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
     public static List<Personas> ShowPersonas()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Personas> busqueda = sesion.createCriteria(Personas.class).list();
        return busqueda;
        
    }
     public static List<Personas> Personas(String nombre)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Personas> busqueda = sesion.createCriteria(Personas.class)
                .add(Restrictions.like("nombre", "%"+nombre+"%"))
                .list();
        return busqueda;
        
    }
     public static int IdLastPersona()
    {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       int last= (int) sesion.createCriteria(Personas.class)
               .setProjection(Projections.max("idPersona")).uniqueResult();
       
       return last;  
   }
     public static List<Personas> PersonasPaterno(String apellido)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Personas> busqueda = sesion.createCriteria(Personas.class)
                .add(Restrictions.like("apellidoPaterno", "%"+apellido+"%"))
                .list();
        return busqueda;
        
    }
     public static List<Personas> PersonasMaterno(String apellido)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Personas> busqueda = sesion.createCriteria(Personas.class)
                .add(Restrictions.like("apellidoMaterno", "%"+apellido+"%"))
                .list();
        return busqueda;
        
    }
    public static Personas BusquedaClave (int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Personas busqueda = (Personas) sesion.createCriteria(Personas.class)
                .add(Restrictions.eq("idPersona", clave)).uniqueResult();
        return busqueda;
    }
    public static boolean UpdatePersona (int clave,String nombre,String apellidopaterno,String apellidomaterno,
             String telefono,Domicilios domicilio) 
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Personas busqueda = (Personas) sesion.createCriteria(Personas.class)
                .add(Restrictions.eq("idPersona", clave)).uniqueResult();
            if(busqueda !=null)
            {
               busqueda.setNombre(nombre);
            busqueda.setApellidoPaterno(apellidomaterno);
            busqueda.setApellidoMaterno(apellidomaterno);
            busqueda.setTelefono(telefono);
            busqueda.setDomicilios(domicilio);
            sesion.save(busqueda);
            sesion.getTransaction().commit();
            return true;
            
         }else
         {
             return false;
         }
         } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }

    }
  public static boolean DeletePersona(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Personas busqueda = (Personas) sesion.createCriteria(Personas.class)
                    .add(Restrictions.eq("idPersona", clave)).uniqueResult();
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
