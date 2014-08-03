/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HibernateUtil;
import Model.Sucursales;
import Model.Usuarios;
import View.Login;
import View.ModuloCliente.PrincipalCliente;
import View.ModuloProducto.PrincipalProducto;
import View.ModuloProveedor.PrincipalProveedor;
import View.ModuloVentas.PrincipalVentas;
import View.Principal;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/*
 *
 * @author Hector Campos Alonso
 * @since 07/07/2013
 * @version 1.0
 */
public class UsuarioController 
{
    
    
    /*Este metodo permite registrar a un nuevo usuario
     */
    public static boolean CreateUsuario(String username, String password
            ,String Tipo , String Pregunta,String respuesta, Sucursales sucursal)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Usuarios usuario = new Usuarios();
            usuario.setUsername(username);
            usuario.setPassword(password);
            usuario.setTipo(Tipo);
            usuario.setPreguntaSeguridad(Pregunta);
            usuario.setRespuesta(respuesta);
            usuario.setSucursales(sucursal);
            sesion.save(usuario);
            sesion.getTransaction().commit();
            return true;
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    /*Este metodo permite eliminar un usuario
     * por medio de una busqueda de id
     */
    public static boolean DeleteUsuario (int usuario)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.getTransaction().begin();
        try {
            Usuarios busqueda = (Usuarios)sesion.createCriteria(Usuarios.class).add(Restrictions
                    .eq("clave", usuario)).uniqueResult();
            if(busqueda!=null)
            {
                sesion.delete(busqueda);
                sesion.getTransaction().commit();
            }else{
                JOptionPane.showMessageDialog(null, "Error no existe el usuario", "Error"
                        ,JOptionPane.ERROR_MESSAGE);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    public static boolean UpdateUsuario(String usuario, String password,String tipo ,String pregunta
            ,String respuesta, Sucursales sucursal)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        try {
            Usuarios busqueda = (Usuarios) sesion.createCriteria(Usuarios.class).add(Restrictions.eq
                    ("username", usuario)).uniqueResult();
            if(busqueda!=null){
                busqueda.setUsername(usuario);
                busqueda.setPassword(password);
                busqueda.setTipo(tipo);
                busqueda.setPreguntaSeguridad(pregunta);
                busqueda.setRespuesta(respuesta);
                busqueda.setSucursales(sucursal);
                sesion.update(busqueda);
                sesion.getTransaction().commit();
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "El usuario "+usuario+ " no existe"
                    ,"Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
                sesion.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
            return false;
        }
    }
    
    
    public static List<Usuarios> ShowUsuarios()
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
         List<Usuarios> resultado= sesion.createCriteria(Usuarios.class).list();
        return  resultado;
    }
    
    public static Usuarios UnicoUsuario(String usuario)
    {
        Session session =HibernateUtil.getSessionFactory().openSession();
                 Usuarios busqueda=(Usuarios)session.createCriteria(Usuarios.class)
                         .add(Restrictions.eq("username", usuario)).uniqueResult();  
                 return busqueda;
    }
    public static Usuarios IdUsuario(int usuario)
    {
        Session session =HibernateUtil.getSessionFactory().openSession();
                 Usuarios busqueda=(Usuarios)session.createCriteria(Usuarios.class)
                         .add(Restrictions.eq("clave", usuario)).uniqueResult();  
                 return busqueda;
    }
    public boolean usuario(String usuario){
        return false;
        
    }
    public static boolean Login (String username, String password)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Usuarios busqueda = (Usuarios) sesion.createCriteria(Usuarios.class).add(Restrictions.
                eq("username", username)).uniqueResult();
        if(busqueda!=null)
        {
            //Indica que se encontro y que si es el mismo usuario con la misma contraseña
            if(busqueda.getPassword().equals(password))
            {
                
                new Principal().setVisible(true);
                Principal.tipo=busqueda.getTipo();
                JOptionPane.showMessageDialog(null, "Bienvenido: "+busqueda.getUsername());
                Login n = new Login();
                n.dispose();
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Verique que "
                    + "que haya escrito bien su contraseña"
                    ,"Contraseña no Valida", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            //Busqueda
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El usuario "+username+ " no existe"+ "\n Verique que "
                    + "que haya escrito bien el usuario"
                    ,"Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    
    
    public static void Permisos(String username)
    {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Usuarios busqueda = (Usuarios) sesion.createCriteria(Usuarios.class).add(Restrictions.eq
                ("username", username)).uniqueResult();
         
    }
    
    
   public static List<Usuarios> Busqueda(String usuario)
    {
        Session sesion=HibernateUtil.getSessionFactory().openSession();
         List<Usuarios> resultado= sesion.createCriteria(Usuarios.class)
                 .add(Restrictions.like("username", "%"+usuario+"%"))
                 .list();
        return (List<Usuarios>) resultado;
    }   
    
   
    
}
