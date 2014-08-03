package Controller;


import Model.HibernateUtil;
import Model.Unidadesmediciones;
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
public class UnidadesMedicionesController 
{
    public static boolean CreateUnidadMedicion(String medicion,String descripcion)
    {
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Unidadesmediciones nuevo=new Unidadesmediciones();
            nuevo.setUnidadMedicion(medicion);
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
    public static List<Unidadesmediciones> ShowUnidadesmediciones()
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        List<Unidadesmediciones> busqueda=sesion.createCriteria(Unidadesmediciones.class).list();
        return busqueda;
            
}
    public static Unidadesmediciones BusquedaClave(int clave)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        Unidadesmediciones busqueda=(Unidadesmediciones) sesion.createCriteria(Unidadesmediciones.class)
                .add(Restrictions.eq("claveUnidadMedicion", clave)).uniqueResult();
        return busqueda;
    }
    public static Unidadesmediciones BusquedaUnidad(String clave)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        Unidadesmediciones busqueda=(Unidadesmediciones) sesion.createCriteria(Unidadesmediciones.class)
                .add(Restrictions.eq("unidadMedicion", clave)).uniqueResult();
        return busqueda;
    }
    public static boolean UdateUnidadMedicion(int clave,String unidad,String descripcion)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Unidadesmediciones busqueda=(Unidadesmediciones) sesion.createCriteria(Unidadesmediciones.class)
                    .add(Restrictions.eq("claveUnidadMedicion", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setDetallesproductoses(null);
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
    public static boolean DeleteUnidadMedicion(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
          Unidadesmediciones busqueda = (Unidadesmediciones) sesion.createCriteria(Unidadesmediciones.class)
                  .add(Restrictions.eq("claveUnidadMedicion", clave)).uniqueResult();
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
