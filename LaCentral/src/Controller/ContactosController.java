/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;
import Model.*;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Hector Campos Alonso
 * @version 1.0
 * @since 16/07/2013
 */
public class ContactosController 
{
    public static boolean CreateContacto(Date fecha, boolean activo, String telefono
           ,Empresasproveedoras empresa,Personas persona)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Contactos nuevo = new Contactos();
            nuevo.setFechaRegistro(fecha);
            nuevo.setActivo(activo);
            nuevo.setTelefono(telefono);
            nuevo.setEmpresasproveedoras(empresa);
            nuevo.setPersonas(persona);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    public static List<Contactos> ShowContactos ()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Contactos> busqueda = sesion.createCriteria(Contactos.class).list();
        return busqueda;
    }
    public static Contactos BusquedaTelefono(String tel)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Contactos busqueda = (Contactos) sesion.createCriteria(Contactos.class)
                .add(Restrictions.eq("telefono", tel)).uniqueResult();
        return busqueda;
    }
    public static Contactos BusquedaId(int codigo)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Contactos busqueda = (Contactos) sesion.createCriteria(Contactos.class)
                .add(Restrictions.eq("claveContacto", codigo)).uniqueResult();
        return busqueda;
    }
    public static boolean UpdateContacto(int id, Date fecha, boolean activo,
            String telefono, Empresasproveedoras empresa, Personas persona)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
           Contactos busqueda = (Contactos) sesion.createCriteria(Contactos.class)
                   .add(Restrictions.eq("claveContacto", id)).uniqueResult();
           if(busqueda!=null)
           {
               busqueda.setFechaRegistro(fecha);
               busqueda.setActivo(activo);
               busqueda.setTelefono(telefono);
               busqueda.setEmpresasproveedoras(empresa);
               busqueda.setPersonas(persona);
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
    public static boolean BajaContacto(int id)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Contactos busqueda = (Contactos) sesion.createCriteria(Contactos.class)
                    .add(Restrictions.eq("claveContacto", id)).uniqueResult();
            if(busqueda!=null)
            {
                busqueda.setActivo(false);
                sesion.update(busqueda);
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
    public static boolean AltaContacto(int id)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Contactos busqueda = (Contactos) sesion.createCriteria(Contactos.class)
                    .add(Restrictions.eq("claveContacto", id)).uniqueResult();
            if(busqueda!=null)
            {
                busqueda.setActivo(true);
                sesion.update(busqueda);
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
    public static Empresasproveedoras BuscarEmpresa(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empresasproveedoras busqueda = (Empresasproveedoras) sesion.createCriteria(Empresasproveedoras.class)
                .add(Restrictions.eq("claveEmpresa", id)).uniqueResult();
        return busqueda;
        
    }
    public static Personas BuscarPersona(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Personas busqueda = (Personas) sesion.createCriteria(Personas.class)
                .add(Restrictions.eq("idPersona", id)).uniqueResult();
        return busqueda;
        
    }
    public static Contactos IdLastContacto()
     {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       Contactos last= (Contactos) sesion.createCriteria(Contactos.class)
               .setProjection(Projections.max("claveContactos"))
               .uniqueResult();
       return last;  
     }
}
