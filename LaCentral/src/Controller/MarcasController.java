package Controller;


import Model.HibernateUtil;
import Model.Marcas;
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
public class MarcasController {
    public static boolean CreateMarca(String marca, String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Marcas nuevo = new Marcas();
            nuevo.setMarca(marca);
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
    public static List<Marcas> ShowMarcas()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Marcas> busqueda = sesion.createCriteria(Marcas.class).list();
        return busqueda;
    }
    public static List<Marcas> Marca(String marca)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Marcas> busqueda = sesion.createCriteria(Marcas.class)
                .add(Restrictions.like("marca", "%"+marca+"%"))
                .list();
        return busqueda;
    }
    public static Marcas BusquedaClave(int Clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Marcas busqueda = (Marcas) sesion.createCriteria(Marcas.class)
                .add(Restrictions.eq("claveMarca", Clave)).uniqueResult();
        return busqueda;
    }
    public static Marcas BusquedaMarca(String Clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Marcas busqueda = (Marcas) sesion.createCriteria(Marcas.class)
                .add(Restrictions.eq("marca", Clave)).uniqueResult();
        return busqueda;
    }
    public static boolean UpdateMarca(int clave,String marca,String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Marcas busqueda = (Marcas) sesion.createCriteria(Marcas.class)
                    .add(Restrictions.eq("claveMarca", clave)).uniqueResult();
            if(busqueda != null)
            {
                busqueda.setMarca(marca);
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
    public static boolean DeleteMarca(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Marcas busqueda = (Marcas) sesion.createCriteria(Marcas.class)
                    .add(Restrictions.eq("claveMarca", clave)).uniqueResult();
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
