/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import java.time.LocalDateTime;

/**
 *
 * @author alumnoFI
 */
public class Prestamo implements Comparable<Prestamo> {
     private static int contadorID = 0; 
    private int id;
    private Libro libro;
    private Estudiante estudiante;
    private LocalDateTime fechaPrestamo;
 //   private int fechaDevolucion;
    private String Activo;
    
    
    /*Constructor*/
    public Prestamo(Libro libro, Estudiante estudiante,/* int fechaDevolucion,*/String Activo ) {
        this.id = ++contadorID; 
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = LocalDateTime.now(); 
      //  this.fechaDevolucion = fechaDevolucion; 
        this.Activo = Activo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

     public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }
/*
    public int getFechaDevolucion() {
        return fechaDevolucion;
    }*/

    
    public String getActivo(){
        return Activo;
    }
    
    
     // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

 /*  public void setFechaPrestamo(int fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }*/
/* 
    public void setFechaDevolucion(int fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }*/
    
    public void setActivo(String Activo){
        this.Activo = Activo;
    }
    
    
@Override
public int compareTo(Prestamo other) {
    return other.fechaPrestamo.compareTo(this.fechaPrestamo); // Invertir la comparación
}

    
@Override
public boolean equals(Object obj) {
    
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Prestamo prestamo = (Prestamo) obj;
    return this.libro.getISBN().equals(prestamo.libro.getISBN())  &&
           this.estudiante.getNumero() == prestamo.estudiante.getNumero();
            // Verificar que el préstamo esté activo
}



            @Override
public String toString() {
    return  libro.getTitulo()+"#"+libro.getISBN()+"#"+libro.getCategoria().getNombre()+"#"+Activo;
           
}
     
    
    
}
