package Controller;


import Model.Clientes;
import Model.HibernateUtil;
import Model.Personas;
import java.util.Date;
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
public class ClientesController 
{
    public static boolean CreateCliente(Date fecharegistro,boolean activo,boolean tipocliente,
            Personas persona)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Clientes nuevo = new Clientes();
            nuevo.setFechaRegistro(fecharegistro);
            nuevo.setActivo(activo);
            nuevo.setTipoCliente(tipocliente);
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
    public static List<Clientes> ShowClientes()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Clientes> busqueda = sesion.createCriteria(Clientes.class).list();
        return busqueda;
    }
    public static int IdLastCliente()
    {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       int last= (int) sesion.createCriteria(Clientes.class)
               .setProjection(Projections.max("claveCliente")).uniqueResult();
       
       return last;  
   }
    public static Clientes BusquedaClave(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Clientes busqueda = (Clientes) sesion.createCriteria(Clientes.class)
                .add(Restrictions.eq("claveCliente", clave)).uniqueResult();
        return busqueda;
    }
    
    public static boolean BajaAltaCliente(int clave, boolean activo)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Clientes busqueda= (Clientes) sesion.createCriteria(Clientes.class)
                    .add(Restrictions.eq("claveCliente", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setActivo(activo);
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
    public static boolean UpdateCliente(int clave,Date fecharegistro,boolean activo,
            boolean tipocliente,Personas persona)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Clientes busqueda= (Clientes) sesion.createCriteria(Clientes.class)
                    .add(Restrictions.eq("claveCliente", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setFechaRegistro(fecharegistro);
                busqueda.setActivo(activo);
                busqueda.setTipoCliente(tipocliente);
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
    
    public static boolean DeleteCliente(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Clientes busqueda = (Clientes) sesion.createCriteria(Clientes.class)
                    .add(Restrictions.eq("claveCliente", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setActivo(false);
                sesion.update(busqueda);
                sesion.getTransaction().commit();
                return true;
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
}
