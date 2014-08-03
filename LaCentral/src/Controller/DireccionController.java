/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import Model.Direcciones;
import Model.Estados;
import Model.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author usuario
 */
public class DireccionController {
    public static boolean CreateDireccion( String calle, String numeroInterno, String numeroExterno, Estados estado )
    {
Session sesion = HibernateUtil.getSessionFactory().openSession();
sesion.beginTransaction();
        try {
            Direcciones nuevo= new Direcciones();
            nuevo.setCalle(calle);
            nuevo.setNumeroInterno(numeroInterno);
            nuevo.setNumeroExterno(numeroExterno);
            nuevo.setEstados(estado);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    public static List<Direcciones> showDirecciones()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Direcciones> busqueda= sesion.createCriteria(Direcciones.class).list();
        return busqueda;
    }
    
    public static Direcciones busquedaCalle(String calle){
        Session session= HibernateUtil.getSessionFactory().openSession();
        Direcciones busqueda = (Direcciones) session.createCriteria(Direcciones.class)
                .add(Restrictions.eq("calle", calle)).uniqueResult();
        return busqueda;
    }
            
    public static boolean UpdateDirecciones(int id, String calle, String numeroInterno, String numeroExterno, Estados estado)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Direcciones busqueda = (Direcciones) sesion.createCriteria(Direcciones.class)
                    .add(Restrictions.eq("claveDireccion", id)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setCalle(calle);
                busqueda.setNumeroInterno(numeroInterno);
                busqueda.setNumeroExterno(numeroExterno);
                busqueda.setEstados(estado);
                sesion.update(busqueda);
                sesion.getTransaction().commit();
                return  true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    public static boolean DeleteDireccion(int id)
    {
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
     Direcciones busqueda =(Direcciones) sesion.createCriteria(Direcciones.class)
             .add(Restrictions.eq("claveDireccion", id)).uniqueResult();
             if(busqueda!=null){
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
    public static int IdLastDireccion()
    {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       int last= (int) sesion.createCriteria(Direcciones.class)
               .setProjection(Projections.max("claveDireccion")).uniqueResult();
      
       return last;  
   }
    public static Direcciones BuscarDireccion(int  id){
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        Direcciones busqueda =(Direcciones) sesion.createCriteria(Direcciones.class)
                .add(Restrictions.eq("claveDireccion", id)).uniqueResult();
        return busqueda;
    }
  }
