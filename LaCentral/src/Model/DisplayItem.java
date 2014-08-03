/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hector Campos Alonso
 * @since 07/07/2013
 * @version 1.0
 */
public class DisplayItem {
    private String texto;
    private int valor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public DisplayItem(String texto, int valor) {
        this.texto = texto;
        this.valor = valor;
    }

    @Override
    // obtiene una representacion textual de un objeto
    public String toString() {
        return this.texto;
    }
    
}
