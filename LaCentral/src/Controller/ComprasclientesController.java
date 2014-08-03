package Controller;


import Model.Comprasclientes;
import Model.Descuentos;
import Model.Formaspagos;
import Model.HibernateUtil;
import Model.Historiales;
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
public class ComprasclientesController 
{
    public static boolean CreateCompracliente(Date fechacompra,float subtotal,float total
            ,Historiales historial,Descuentos descuento,Formaspagos formapago)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Comprasclientes nuevo = new Comprasclientes();
            nuevo.setFechaCompra(fechacompra);
            nuevo.setSubtotal(subtotal);
            nuevo.setTotal(total);
            nuevo.setHistoriales(historial);
            nuevo.setDescuentos(descuento);
            nuevo.setFormaspagos(formapago);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
 }
    public static List<Comprasclientes> ShowComprasclientes()
    {
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        List<Comprasclientes> busqueda = sesion.createCriteria(Comprasclientes.class).list();
        return busqueda;
    }
    public static Comprasclientes BusquedaClave(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Comprasclientes busqueda= (Comprasclientes) sesion.createCriteria(Comprasclientes.class)
                .add(Restrictions.eq("claveCompraCliente", clave)).uniqueResult();
        return busqueda;           
    }
    public static int IdLastCompra(){
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       int last= (int) sesion.createCriteria(Comprasclientes.class)
               .setProjection(Projections.max("claveCompraCliente")).uniqueResult();
      
       return last;  
   }   
    public static boolean UpdateCompracliente(int clave, Date fechacompra,float subtotal,
            float total,Historiales historial,Descuentos descuento,Formaspagos formapago)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Comprasclientes busqueda = (Comprasclientes) sesion.createCriteria(Comprasclientes.class)
                    .add(Restrictions.eq("claveCompraCliente", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setFechaCompra(fechacompra);
                busqueda.setSubtotal(subtotal);
                busqueda.setTotal(total);
                busqueda.setHistoriales(historial);
                busqueda.setDescuentos(descuento);
                busqueda.setFormaspagos(formapago);
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
    public static boolean DeleteCompracliente(int clave)
            {
                Session sesion =HibernateUtil.getSessionFactory().openSession();
                sesion.beginTransaction();
                try {
                    Comprasclientes busqueda = (Comprasclientes) sesion.createCriteria(Comprasclientes.class)
                            .add(Restrictions.eq("claveCompraCliente", clave)).uniqueResult();
                    if(busqueda !=null)
                    {
                        sesion.delete(busqueda);
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
}
