/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Empresasproveedoras;
import Model.Direcciones;
import Model.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author usuario
 */
public class EmpresaProveedoraController 
{
    public static  boolean CreateEmpresa(String RFC,String nombre,String razonsocial, Date fecharegistro, 
            boolean activo, String telefono, Direcciones direccion)
    {
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Empresasproveedoras nuevo=new Empresasproveedoras();
            nuevo.setRfc(RFC);
            nuevo.setNombre(nombre);
            nuevo.setRazonSocial(razonsocial);
            nuevo.setFechaRegistro(fecharegistro);
            nuevo.setActivo(activo);
            nuevo.setTelefono(telefono);
            nuevo.setDirecciones(direccion);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }            
            
    public static List<Empresasproveedoras> showEmpresa(){
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        List<Empresasproveedoras> busqueda = sesion.createCriteria(Empresasproveedoras.class).list();
        return busqueda;
    }
    
    public static Empresasproveedoras busquedaEmpresa(String nombre)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empresasproveedoras busqueda=(Empresasproveedoras) sesion.createCriteria(Empresasproveedoras.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();
        return busqueda;
    }
    public static Empresasproveedoras Empresa(int clave)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empresasproveedoras busqueda=(Empresasproveedoras) sesion.createCriteria(Empresasproveedoras.class)
                .add(Restrictions.eq("claveEmpresa", clave)).uniqueResult();
        return busqueda;
    }
    public static boolean UpdateEmpresa(int id, String RFC,String nombre,String razonsocial,Date fecharegistro,boolean activo,String telefono,Direcciones direccion){
  Session sesion= HibernateUtil.getSessionFactory().openSession();
  sesion.beginTransaction();
          try {
              Empresasproveedoras busqueda=(Empresasproveedoras) sesion.createCriteria(Empresasproveedoras.class)
                      .add(Restrictions.eq("claveEmpresa", id)).uniqueResult();
              
              if(busqueda!=null)
              {
            Empresasproveedoras nueva = new Empresasproveedoras();
            busqueda.setRfc(RFC);
            busqueda.setNombre(nombre);
            busqueda.setRazonSocial(razonsocial);
            busqueda.setFechaRegistro(fecharegistro);
            busqueda.setActivo(activo);
            busqueda.setTelefono(telefono);
            busqueda.setDirecciones(direccion);
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
    
    public static boolean DeleteEmpresa(int id){
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Empresasproveedoras busqueda= (Empresasproveedoras)sesion.createCriteria(Empresasproveedoras.class)
                    .add(Restrictions.eq("claveEmpresa", id)).uniqueResult();
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
     public static Empresasproveedoras IdLastEmpresa()
     {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
       Empresasproveedoras last= (Empresasproveedoras) sesion.createCriteria(Empresasproveedoras.class)
               .setProjection(Projections.max("claveEmpresa")).uniqueResult();
       return last;  
     }   
       
    public static Direcciones buscarDireccion(int id)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Direcciones busqueda=(Direcciones)sesion.createCriteria(Direcciones.class)
                .add(Restrictions.eq("claveDireccion", id)).uniqueResult();
        return busqueda;
    }
}
