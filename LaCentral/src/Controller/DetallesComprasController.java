/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Comprasclientes;
import Model.Detallescompras;
import Model.HibernateUtil;
import Model.Productos;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author usuario
 */
public class DetallesComprasController {
public static boolean CreateDetalle(int cantidad){
    Session sesion= HibernateUtil.getSessionFactory().openSession();
    sesion.beginTransaction();
    try {
        Detallescompras nuevo=new Detallescompras();
        nuevo.setCantidad(cantidad);
        sesion.save(nuevo);
        sesion.getTransaction().commit();
        return true;
    } catch (Exception e) {
        System.out.println(e.getMessage());
        sesion.beginTransaction().rollback();
        return false;
    }
}

public static boolean UpdateDetallesCompras(int compracliente, int producto,int cantidad){
    Session sesion= HibernateUtil.getSessionFactory().openSession();
    sesion.beginTransaction();
    try {
        Detallescompras busqueda= (Detallescompras) sesion.createCriteria(Detallescompras.class)
                .add(Restrictions.eq("claveCompraCliente", compracliente)).uniqueResult();
        if(busqueda!=null){
            busqueda.setCantidad(cantidad);
            sesion.update(busqueda);
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

public static boolean DeleteDetallesCompras(int compracliente, int producto,int cantidad){
    Session sesion =HibernateUtil.getSessionFactory().openSession();
    sesion.beginTransaction();
    try {
        Detallescompras busqueda= (Detallescompras) sesion.createCriteria(Detallescompras.class)
                .add(Restrictions.eq("claveCompraCliente", compracliente)).uniqueResult();
        if(busqueda!=null){
            busqueda.setCantidad(cantidad);
            sesion.delete(busqueda);
            sesion.beginTransaction().commit();
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

public static Comprasclientes BuscarCompraCliente(int id){
    Session sesion =HibernateUtil.getSessionFactory().openSession();
    Comprasclientes busqueda=(Comprasclientes) sesion.createCriteria(Comprasclientes.class)
            .add(Restrictions.eq("claveCompraCliente", id)).uniqueResult();
    return busqueda;
}

public static Productos BuscarProducto(int id){
    Session session =HibernateUtil.getSessionFactory().openSession();
    Productos busqueda=(Productos) session.createCriteria(Productos.class)
            .add(Restrictions.eq("claveProducto", id)).uniqueResult();
    return busqueda;
}
}
