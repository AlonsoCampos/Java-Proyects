package Model;
// Generated 18/08/2013 10:09:46 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Calidades generated by hbm2java
 */
public class Calidades  implements java.io.Serializable {


     private Integer claveCalidad;
     private String calidad;
     private String descripcion;
     private Set<Detallesproductos> detallesproductoses = new HashSet<Detallesproductos>(0);

    public Calidades() {
    }

	
    public Calidades(String calidad, String descripcion) {
        this.calidad = calidad;
        this.descripcion = descripcion;
    }
    public Calidades(String calidad, String descripcion, Set<Detallesproductos> detallesproductoses) {
       this.calidad = calidad;
       this.descripcion = descripcion;
       this.detallesproductoses = detallesproductoses;
    }
   
    public Integer getClaveCalidad() {
        return this.claveCalidad;
    }
    
    public void setClaveCalidad(Integer claveCalidad) {
        this.claveCalidad = claveCalidad;
    }
    public String getCalidad() {
        return this.calidad;
    }
    
    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set<Detallesproductos> getDetallesproductoses() {
        return this.detallesproductoses;
    }
    
    public void setDetallesproductoses(Set<Detallesproductos> detallesproductoses) {
        this.detallesproductoses = detallesproductoses;
    }




}

