package Controller;


import Model.Codigospostales;
import Model.Estados;
import Model.HibernateUtil;
import Model.Municipios;
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
public class MunicipiosController 
{
    public static boolean CreateMunicipio(String municipio,String descripcion,Codigospostales codiopostal,
            Estados estado)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Municipios nuevo = new Municipios();
            nuevo.setMunicipio(municipio);
            nuevo.setDescripcion(descripcion);
            nuevo.setCodigospostales(codiopostal);
            nuevo.setEstados(estado);
            sesion.getTransaction().commit();
            return true;
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
             return false;
        }
       
    }
    public static List<Municipios> ShowMunicipios ()
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Municipios> busqueda = sesion.createCriteria(Municipios.class).list();
        return busqueda;
    }
    public static Municipios BusquedaClave(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Municipios busqueda = (Municipios) sesion.createCriteria(Municipios.class)
                .add(Restrictions.eq("claveMunicipio", clave)).uniqueResult();
        return busqueda;
                
    }
    public static Municipios BusquedaMunicipio(String municipio)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Municipios busqueda = (Municipios) sesion.createCriteria(Municipios.class)
                .add(Restrictions.eq("municipio", municipio)).uniqueResult();
        return busqueda;
                
    }
    public static boolean UpdateMunicipio(int clave,String municipio,String descripcion,
            Codigospostales codigopostal,Estados estado)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Municipios busqueda=(Municipios) sesion.createCriteria(Municipios.class)
                    .add(Restrictions.eq("claveMunicipio", clave)).uniqueResult();
            if(busqueda !=null)
            {
               busqueda.setMunicipio(municipio);
               busqueda.setDescripcion(descripcion);
               busqueda.setCodigospostales(codigopostal);
               busqueda.setEstados(estado);
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
    public static boolean DeleteMunicipio(int clave)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Municipios busqueda = (Municipios) sesion.createCriteria(Municipios.class)
                    .add(Restrictions.eq("claveMunicipio", clave)).uniqueResult();
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
