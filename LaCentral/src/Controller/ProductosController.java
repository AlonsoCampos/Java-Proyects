package Controller;


import Model.HibernateUtil;
import Model.Productos;
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
 * @author yo
 * @version 1.0
 * @since 16/07/2013
 */
public class ProductosController {
public static boolean createProducto(String nombre,String imagen,String descripcion)
{
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    sesion.beginTransaction();
    try{
        Productos nuevo=  new Productos ();
        nuevo.setNombre(nombre);
        nuevo.setImagen(imagen);
        nuevo.setDescripcion(descripcion);
        sesion.save(nuevo);
        sesion.getTransaction().commit();
        return  true;
    }catch(Exception e){
        System.out.println(e.getMessage());
        sesion.getTransaction().rollback();
        return false;
    }
   }
public static List<Productos> ShowProductos ()
{
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    List<Productos> busqueda = sesion.createCriteria(Productos.class).list();
    return busqueda;
}
public static List<Productos> Productos(String nombre)
{
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    List<Productos> busqueda = sesion.createCriteria(Productos.class)
            .add(Restrictions.like("nombre", nombre))
            .list();
    return busqueda;
}

public static Productos BusquedaClave(int id)
{
    Session sesion = HibernateUtil.getSessionFactory().openSession();
    Productos busqueda=(Productos) sesion.createCriteria(Productos.class)
            .add(Restrictions.eq("claveProducto", id)).uniqueResult();
    return busqueda;
}
public static boolean UpdateProductos(int clave, String nombre, String imagen,
        String descripcion)
{
    Session sesion =HibernateUtil.getSessionFactory().openSession();
    sesion.beginTransaction();
    try {
        Productos busqueda = (Productos) sesion.createCriteria(Productos.class)
                .add(Restrictions.eq("claveProducto", clave)).uniqueResult();
        if(busqueda !=null)
        {
            busqueda.setNombre(nombre);
            busqueda.setImagen(imagen);
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
        return  false;
    }
}
        
 public static boolean DeleteProductos(int clave)
 {
     Session sesion = HibernateUtil.getSessionFactory().openSession();
     sesion.beginTransaction();
     try {
         Productos busqueda=(Productos) sesion.createCriteria(Productos.class)
                 .add(Restrictions.eq("claveProducto", clave)).uniqueResult();
         if(busqueda !=null)
         {
             sesion.delete(busqueda);
             sesion.getTransaction().commit();
             return true;
         }
         else
         {
             return  false;
         }
     } catch (Exception e) {
         System.out.println(e.getMessage());
         sesion.beginTransaction().rollback();
         return false;
     }
 }
   public static int IdLastProduct(){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       int last= (int) sesion.createCriteria(Productos.class)
               .setProjection(Projections.max("claveProducto")).uniqueResult();
      
       return last;  
   }   
         
 }

