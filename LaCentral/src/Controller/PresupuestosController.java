/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Presupuestos;
import Model.Productos;
import Model.Clientes;
import Model.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author usuario
 */
public class PresupuestosController {
    public static boolean CreatePresupuesto(Date fechaPresupuesto, float montototal, Productos producto,Clientes cliente){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Presupuestos nuevo= new Presupuestos();
            nuevo.setFechaPresupuesto(fechaPresupuesto);
            nuevo.setMontoTotal(montototal);
            nuevo.setProductos(producto);
            nuevo.setClientes(cliente);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    public static boolean UpdatePresupuesto(int id,Date fechaPresupuesto,float montototal,Productos producto,Clientes cliente){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Presupuestos busqueda=(Presupuestos) sesion.createCriteria(Presupuestos.class)
                    .add(Restrictions.eq("clave", id)).uniqueResult();
            if(busqueda!=null){
                busqueda.setFechaPresupuesto(fechaPresupuesto);
                busqueda.setMontoTotal(montototal);
                busqueda.setProductos(producto);
                busqueda.setClientes(cliente);
                sesion.update(busqueda);
                sesion.getTransaction().commit();
                return  true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    public static boolean DeletePresupuesto(int id){
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Presupuestos busqueda=(Presupuestos) sesion.createCriteria(Presupuestos.class)
                    .add(Restrictions.eq("clave", id)).uniqueResult();
            if(busqueda!=null){
                sesion.delete(busqueda);
                sesion.getTransaction().commit();
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.beginTransaction().rollback();
            return false;
        }
    }
    
    public static Productos BuscarProducto(int id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Productos busqueda= (Productos) sesion.createCriteria(Productos.class)
                .add(Restrictions.eq("claveProducto", id)).uniqueResult();
        return busqueda;
    }
    
    public static Clientes BuscarCliente(int id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        Clientes busqueda= (Clientes) sesion.createCriteria(Clientes.class)
                .add(Restrictions.eq("claveCliente", id)).uniqueResult();
        return busqueda;
    }
}
