package Controller;


import Model.Domicilios;
import Model.HibernateUtil;
import Model.Municipios;
import java.util.List;
import org.hibernate.Hibernate;
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
public class DomiciliosController {
    public static boolean CreateDomicilio (String domicilio,String numerointerior,String numeroexterior,
            Municipios municipio) 
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Domicilios nuevo = new Domicilios();
            nuevo.setDomicilio(domicilio);
            nuevo.setNumeroInterno(numerointerior);
            nuevo.setNumeroExterno(numeroexterior);
            nuevo.setMunicipios(municipio);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    public static List<Domicilios> ShowDomicilios()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Domicilios> busqueda = sesion.createCriteria(Domicilios.class).list();
        return busqueda;
        
    }
    public static Domicilios BusquedaClave (int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Domicilios busqueda = (Domicilios) sesion.createCriteria(Domicilios.class)
                .add(Restrictions.eq("claveDomicilio", clave)).uniqueResult();
        return busqueda;
    }
    public static int IdLastDomicilio()
    {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       int last= (int) sesion.createCriteria(Domicilios.class)
               .setProjection(Projections.max("claveDomicilio")).uniqueResult();
      
       return last;  
   }
    public static boolean UpdateDomicilio( int clave,String domicilio,String numerointerno,
            String numeroexterno, Municipios municipio)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Domicilios busqueda = (Domicilios) sesion.createCriteria(Domicilios.class)
                    .add(Restrictions.eq("claveDomicilio", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setDomicilio(domicilio);
                busqueda.setNumeroInterno(numerointerno);
                busqueda.setNumeroExterno(numeroexterno);
                busqueda.setMunicipios(municipio);
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
    public static boolean DeleteDomicilio(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Domicilios busqueda = (Domicilios) sesion.createCriteria(Domicilios.class)
                    .add(Restrictions.eq("claveDomicilio", clave)).uniqueResult();
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
