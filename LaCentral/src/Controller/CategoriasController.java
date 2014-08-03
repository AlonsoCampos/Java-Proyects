package Controller;


import Model.Categorias;
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
public class CategoriasController
{
    public static boolean CreateCategoria(String categoria, String descripcion)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Categorias nuevo = new Categorias();
            nuevo.setCategoria(categoria);
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
    public static List<Categorias> ShowCategorias()
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        List<Categorias> busqueda = sesion.createCriteria(Categorias.class).list();
        return busqueda;
    }
    public static List<Categorias> Categorias(String categoria)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        List<Categorias> busqueda = sesion.createCriteria(Categorias.class)
                .add(Restrictions.like("categoria","%"+categoria+"%"))
                .list();
        return busqueda;
    }
    public static Categorias BusquedaClave(int Clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Categorias busqueda=(Categorias) sesion.createCriteria(Categorias.class)
             .add(Restrictions.eq("claveCategoria", Clave)).uniqueResult();
        return busqueda;
    }
    public static Categorias BusquedaCategoria(String Clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Categorias busqueda=(Categorias) sesion.createCriteria(Categorias.class)
             .add(Restrictions.eq("categoria", Clave)).uniqueResult();
        return busqueda;
    }
    public static boolean UpdateCategoria(int clave,String categoria,String descripcion)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Categorias busqueda=(Categorias) sesion.createCriteria(Categorias.class)
                    .add(Restrictions.eq("claveCategoria", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setCategoria(categoria);
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
    public static boolean DeleteCategoria(int clave)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Categorias busqueda=(Categorias) sesion.createCriteria(Categorias.class)
                    .add(Restrictions.eq("claveCategoria", clave)).uniqueResult();
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
