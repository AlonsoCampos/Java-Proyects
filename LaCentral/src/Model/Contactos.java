package Model;
// Generated 18/08/2013 10:09:46 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Contactos generated by hbm2java
 */
public class Contactos  implements java.io.Serializable {


     private Integer claveContacto;
     private Empresasproveedoras empresasproveedoras;
     private Personas personas;
     private Date fechaRegistro;
     private boolean activo;
     private String telefono;

    public Contactos() {
    }

	
    public Contactos(Empresasproveedoras empresasproveedoras, Personas personas, Date fechaRegistro, boolean activo) {
        this.empresasproveedoras = empresasproveedoras;
        this.personas = personas;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }
    public Contactos(Empresasproveedoras empresasproveedoras, Personas personas, Date fechaRegistro, boolean activo, String telefono) {
       this.empresasproveedoras = empresasproveedoras;
       this.personas = personas;
       this.fechaRegistro = fechaRegistro;
       this.activo = activo;
       this.telefono = telefono;
    }
   
    public Integer getClaveContacto() {
        return this.claveContacto;
    }
    
    public void setClaveContacto(Integer claveContacto) {
        this.claveContacto = claveContacto;
    }
    public Empresasproveedoras getEmpresasproveedoras() {
        return this.empresasproveedoras;
    }
    
    public void setEmpresasproveedoras(Empresasproveedoras empresasproveedoras) {
        this.empresasproveedoras = empresasproveedoras;
    }
    public Personas getPersonas() {
        return this.personas;
    }
    
    public void setPersonas(Personas personas) {
        this.personas = personas;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}

