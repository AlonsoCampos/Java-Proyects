package Controller;


import Model.Calidades;
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
public class CalidadesController {
    public static boolean CreateCalidad(String calidad,String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Calidades nuevo = new Calidades();
            nuevo.setCalidad(calidad);
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
    public static List<Calidades> ShowCalidades()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Calidades> busqueda = sesion.createCriteria(Calidades.class).list();
        return busqueda;
   
    }
    public static List<Calidades> Calidades(String calidad)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Calidades> busqueda = sesion.createCriteria(Calidades.class)
                .add(Restrictions.like("calidad", "%"+calidad+"%"))
                .list();
        return busqueda;
   
    }
    public static Calidades Busqueda(int clave)
    {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       Calidades busqueda = (Calidades) sesion.createCriteria(Calidades.class)
               .add(Restrictions.eq("claveCalidad", clave)).uniqueResult();
       return  busqueda;
    }
    public static Calidades BusquedaCalidad(String clave)
    {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       Calidades busqueda = (Calidades) sesion.createCriteria(Calidades.class)
               .add(Restrictions.eq("calidad", clave)).uniqueResult();
       return  busqueda;
    }
    
    public static boolean Update(int clave,String calidad,String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Calidades busqueda = (Calidades) sesion.createCriteria(Calidades.class)
                    .add(Restrictions.eq("claveCalidad", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setCalidad(calidad);
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
    public static boolean DeleteCalidad(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Calidades busqueda = (Calidades) sesion.createCriteria(Calidades.class)
                    .add(Restrictions.eq("claveCalidad", clave)).uniqueResult();
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
