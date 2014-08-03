package Controller;


import Model.Clientes;
import Model.HibernateUtil;
import Model.Historiales;
import java.util.Date;
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
public class HistorialesController 
{
    public static boolean CreateHistorial(Date ultimacompra,float montototal,float total,
            Clientes clientes)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Historiales nuevo=new Historiales();
            nuevo.setUltimaCompra(ultimacompra);
            nuevo.setMontoTotalUltimaCompra(montototal);
            nuevo.setTotal(total);
            nuevo.setClientes(clientes);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
             System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    public static List<Historiales> ShowHistoriales()
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        List<Historiales> busqueda = sesion.createCriteria(Historiales.class).list();
        return busqueda;
    }
    
    
    public static Historiales BusquedaClave(int clave)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        Historiales busqueda = (Historiales) sesion.createCriteria(Historiales.class)
                .add(Restrictions.eq("claveHistorial", clave)).uniqueResult();
        return busqueda;
    }
    public static Historiales Cliente(int cliente)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        Historiales busqueda = (Historiales) sesion.createCriteria(Historiales.class)
                .add(Restrictions.eq("cliente", cliente)).uniqueResult();
        return busqueda;
    }
    
    public static List<Historiales> BusquedaCliente(int cliente)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        List<Historiales> busqueda = (List<Historiales>) sesion.createCriteria(Historiales.class)
                .add(Restrictions.eq("cliente", cliente)).list();
        return busqueda;
    }   
    
    
    public static boolean UpdateHistorial(int clave,Date ultimacompra,float montototal,
            float total,Clientes cliente)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Historiales busqueda = (Historiales) sesion.createCriteria(Historiales.class)
                    .add(Restrictions.eq("claveHistorial", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setUltimaCompra(ultimacompra);
                busqueda.setMontoTotalUltimaCompra(montototal);
                busqueda.setTotal(total);
                busqueda.setClientes(cliente);
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
    public static boolean DeleteHistorial(int clave)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Historiales busqueda= (Historiales) sesion.createCriteria(Historiales.class)
                    .add(Restrictions.eq("claveHistorial", clave)).uniqueResult();
            if(busqueda !=null)
            {
                sesion.delete(busqueda);
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
