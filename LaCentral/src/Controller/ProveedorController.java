/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contactos;
import Model.Empresasproveedoras;
import Model.HibernateUtil;
import Model.Personas;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alonso
 */
public class ProveedorController {
    public static boolean DarAlta(int clave, boolean activo){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
          Empresasproveedoras busqueda=(Empresasproveedoras) sesion.createCriteria(Empresasproveedoras.class)
                  .add(Restrictions.eq("claveEmpresa", clave)).uniqueResult();
          
          busqueda.setActivo(activo);
          sesion.getTransaction().commit();
          return true;
          
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static List<Empresasproveedoras> ShowEmpresas(){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       List<Empresasproveedoras> buscar = sesion.createCriteria(Empresasproveedoras.class).list();
       return buscar;
    }
    public static Empresasproveedoras ShowEmpresa(String nombre)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empresasproveedoras busqueda = (Empresasproveedoras) sesion.createCriteria(Empresasproveedoras.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();
        return busqueda;
    }
    
        public static List<Empresasproveedoras> Lista(String nombre){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       List<Empresasproveedoras> buscar = sesion.createCriteria(Empresasproveedoras.class)
               .add(Restrictions.like("nombre", "%"+nombre+"%" ))
               .list();
       return buscar;
    }
    public static List<Empresasproveedoras> ListaRFC(String rfc){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       List<Empresasproveedoras> buscar = sesion.createCriteria(Empresasproveedoras.class)
               .add(Restrictions.like("rfc", "%"+rfc+"%" ))
               .list();
       return buscar;
    }
    
    public static List<Contactos> Lista2(){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       List<Contactos> buscar = sesion.createCriteria(Contactos.class).list();
       return buscar;
    }
    public static List<Personas> ListaContacto(String nombre){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       List<Personas> buscar = sesion.createCriteria(Personas.class)
               .add(Restrictions.like("nombre", "%"+nombre+"%"))
               .list();
       return buscar;
    }
    public static List<Personas> ListaContactosPaterno(String paterno){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       List<Personas> buscar = sesion.createCriteria(Personas.class)
               .add(Restrictions.like("apellidoPaterno", "%"+paterno+"%"))
               .list();
       return buscar;
    }
    public static List<Personas> ListaContactosTelefono(String telefono){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       List<Personas> buscar = sesion.createCriteria(Personas.class)
               .add(Restrictions.like("telefono", "%"+telefono+"%"))
               .list();
       return buscar;
    }
    public static List<Personas> ListaContactosMaterno(String materno){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       List<Personas> buscar = sesion.createCriteria(Personas.class)
               .add(Restrictions.like("apellidoMaterno", "%"+materno+"%"))
               .list();
       return buscar;
    }
    
}
