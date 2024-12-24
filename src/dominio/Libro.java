/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author alumnoFI
 */
public class Libro implements Comparable<Libro> {
    private String ISBN;
    private String Titulo;
    private Categoria categoria;
    private int cantidad;
    private int cantidadPrestamos;
    private Queue<Estudiante> colaReservas;
    
    
    
    public Queue<Estudiante> getColaReservas() { return colaReservas; }
    
    /****GET Y SET*****/
    public String getTitulo () {
        return Titulo;
    }

    public void setTitulo (String Titulo) {
        this.Titulo = Titulo;
    }

   
    
    public Categoria getCategoria () {
        return categoria;
    }

    public void setCategoria (Categoria categoria) {
        this.categoria = categoria;
    }
    
    
     public String getISBN(){
        return ISBN;
    }
    
   
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    
    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }
    
    public void sumarPrestamo() {
        this.cantidadPrestamos++;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    
   public void agregarReserva(Estudiante Estudiante) {
    colaReservas.add(Estudiante);
}

    
        /****CONSTRUCTOR*****/

     public Libro(String ISBN, String Titulo, Categoria categoria, int cantidad) {
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.cantidadPrestamos = 0;
        this.colaReservas = new LinkedList<>(); 
    }

     
     
     
     /*Metodos*/
     
       public boolean equals(Object o){
        Libro l = (Libro)o;
        return this.getISBN().equalsIgnoreCase(l.getISBN());

     }
     //funciona con string
     
     
           @Override
public String toString() {
    return  Titulo+"#"+ISBN+"#"+categoria.getNombre();
           
}
     
public String toStringMasPrestados(){
    return  Titulo+"#"+ISBN+"#"+categoria.getNombre()+"#"+cantidadPrestamos;
}       
     
     
    @Override
    public int compareTo(Libro otroLibro) {
        return this.ISBN.compareTo(otroLibro.getISBN());
    }
   
  

     
     
    
}
