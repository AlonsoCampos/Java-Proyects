package Controller;


import Model.Calidades;
import Model.Categorias;
import Model.Detallesproductos;
import Model.Empresasproveedoras;
import Model.HibernateUtil;
import Model.Marcas;
import Model.Productos;
import Model.Sucursales;
import Model.Unidadesmediciones;
import java.util.Date;
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
public class DetallesProductosController 
{
    public static boolean CreateDetalleProducto (float precioUnitario,Date fechaRegistro,
            int existencias,boolean activo,Productos producto,Calidades calidad,
            Categorias categoria,Marcas marca,Unidadesmediciones unidadmedicion
            , Empresasproveedoras empresa, Sucursales sucursal)
    {
        Session sesion= HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Detallesproductos nuevo = new Detallesproductos();
            nuevo.setPrecioUnitario(precioUnitario);
            nuevo.setFechaRegistro(fechaRegistro);
            nuevo.setExistencias(existencias);
            nuevo.setActivo(activo);
            nuevo.setProductos(producto);
            nuevo.setCalidades(calidad);
            nuevo.setCategorias(categoria);
            nuevo.setMarcas(marca);
            nuevo.setUnidadesmediciones(unidadmedicion);
            nuevo.setSucursales(sucursal);
            nuevo.setEmpresasproveedoras(empresa);
            sesion.save(nuevo);
            sesion.getTransaction().commit();
            return true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
             return false;
        }
      }
    public static List<Detallesproductos> showDetallesproductos()
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        List<Detallesproductos> busqueda = sesion.createCriteria(Detallesproductos.class).list();
        return busqueda;
    }
    public static Detallesproductos BusquedaClave(int clave)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        Detallesproductos busqueda = (Detallesproductos) sesion.createCriteria(Detallesproductos.class)
                .add(Restrictions.eq("claveProducto", clave)).uniqueResult();
        return busqueda;
    }
    public static Detallesproductos BusquedaProducto(int clave)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        Detallesproductos busqueda = (Detallesproductos) sesion.createCriteria(Detallesproductos.class)
                .add(Restrictions.eq("producto", clave)).uniqueResult();
        return busqueda;
    }
    public static boolean UpdateDetalleProducto (int clave,float precioUnitario,
            Date fechaRegistro,int existencia,boolean activo, Productos producto,
            Calidades calidad, Categorias categoria,Marcas marca,Unidadesmediciones unidadmedicion
            ,Empresasproveedoras empresa, Sucursales sucursal)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Detallesproductos busqueda= (Detallesproductos) sesion.createCriteria(Detallesproductos.class)
                    .add(Restrictions.eq("claveProducto", clave)).uniqueResult();
            if(busqueda !=null)
            {
                busqueda.setUnidadesmediciones(unidadmedicion);
                busqueda.setFechaRegistro(fechaRegistro);
                busqueda.setExistencias(existencia);
                busqueda.setActivo(activo);
                busqueda.setProductos(producto);
                busqueda.setCalidades(calidad);
                busqueda.setCategorias(categoria);
                busqueda.setMarcas(marca);
                busqueda.setUnidadesmediciones(unidadmedicion);
                busqueda.setEmpresasproveedoras(empresa);
                busqueda.setSucursales(sucursal);
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
    
    public static boolean BajaDetalleProducto(int clave){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Detallesproductos busqueda = (Detallesproductos) sesion.createCriteria(Detallesproductos.class)
                    .add(Restrictions.eq("claveProducto", clave)).uniqueResult();
            if(busqueda!=null){
                busqueda.setActivo(false);
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
    public static boolean AltaDetalleProducto(int clave){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Detallesproductos busqueda = (Detallesproductos) sesion.createCriteria(Detallesproductos.class)
                    .add(Restrictions.eq("claveProducto", clave)).uniqueResult();
            if(busqueda!=null){
                busqueda.setActivo(true);
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
    
    }
            
    

