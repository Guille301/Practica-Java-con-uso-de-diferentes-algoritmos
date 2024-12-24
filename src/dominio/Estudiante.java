/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import dominio.Prestamo;
import java.util.ArrayList;
import java.util.List;
import tads.ListaSimple;

/**
 *
 * @author alumnoFI
 */
public class Estudiante implements Comparable<Estudiante> {
     private String Nombre;
    private String Apellido;
    private int NumeroEstudiante;
    private int cantPrestamos;
    

    
   
            
       /****GET Y SET*****/
    
     public int getCantPrestamos() {
        return cantPrestamos;
    }

  public void setCantPrestamos(int cantPrestamos){
        this.cantPrestamos = cantPrestamos;
    }
    
    
    

    public String getNombre(){
        return Nombre;
    }
    
    
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    
    public String getApellido(){
        return Apellido;
    }
    
    
    public void setApellido(String Apellido){
        this.Apellido = Apellido;
    }
    
    public int getNumeroEstudiante(){
        return NumeroEstudiante;
    }
    
    
    public void setNumeroEstudiante(int NumeroEstudiante){
        this.NumeroEstudiante = NumeroEstudiante;
    }
    
    

  //asi es con int
    
    
    /****CONSTRUCTOR*****/

    public Estudiante(String Nombre, String Apellido, int numeroEstudiante, int cantPrestamos) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.NumeroEstudiante = numeroEstudiante;
        this.cantPrestamos = cantPrestamos;
    }

    // Constructor sin la lista, inicializa una lista vacía
  /*  public Estudiante(String Nombre, String Apellido, int numeroEstudiante) {
        this(Nombre, Apellido, numeroEstudiante, new ListaSimple<>()); // inicializa listaPrestamos vacía
    }*/

    /*Metodos*/
      public int getNumero() {
        return NumeroEstudiante;
    }
     
     public boolean equals(Object o){
        Estudiante e = (Estudiante)o;
        return this.getNumeroEstudiante() == (e.getNumeroEstudiante());
    }
    


     
    @Override
public int compareTo(Estudiante otroEstudiante) {
    return Integer.compare(this.NumeroEstudiante, otroEstudiante.getNumeroEstudiante());
}

     
    @Override
public String toString() {
    return Nombre+"#"+Apellido+"#"+ NumeroEstudiante;
}
   




    @Override
public int hashCode() {
    return Integer.hashCode(getNumeroEstudiante());
}

    

    
}
