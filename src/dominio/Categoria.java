/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author alumnoFI
 */
public class Categoria implements Comparable<Categoria> {
    private String nombre;
    private int cantidad;

    // Constructor
     public Categoria(String categoria) {
        this.nombre = categoria;
       // this.cantidad = 1; // Se inicializa con 1 al detectar el primer libro.
    }
     
    
     
     public void incrementar() {
        this.cantidad = this.cantidad+1;
    }
     

    // Getter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    // Setter para 'nombre'
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para 'cantidad'
    public int getCantidad() {
        return cantidad;
    }

    // Setter para 'cantidad'
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int compareTo(Categoria o) {
        return this.nombre.compareToIgnoreCase(o.nombre); // Orden alfabético ignorando mayúsculas
    }
    
    
  /*             @Override
public String toString() {
    return  nombre+"#"+cantidad;
           
}*/
   
 

  @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categoria categoria = (Categoria) obj;
        return nombre.equalsIgnoreCase(categoria.nombre); // Comparación case-insensitive
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

         
           @Override
public String toString() {
    return  nombre+"#"+cantidad;
           
}

//para mostrar alfabeticamente es con el compare to 
 


}