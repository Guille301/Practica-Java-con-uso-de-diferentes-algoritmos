package sistemaAutogestion;

import dominio.Categoria;
import dominio.Estudiante;
import dominio.Prestamo;

import dominio.Libro;
import java.util.Date;

import tads.ListaSimple;
import ColaGenerica.Cola;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import tads.Pila;
import java.util.ArrayList;

public class Sistema implements IObligatorio {
  
    private ListaSimple<Estudiante> listaEstudiantes;
    private ListaSimple<Libro> listaLibro;
    private ListaSimple<Prestamo> listaPrestamo;
    private Pila<Libro> pilaEliminados;
    private ListaSimple<Categoria> listaCategoria;



   // private Cola<Prestamo> listaPrestamo;
   
    public Sistema(){
        listaEstudiantes = new ListaSimple<>();
        listaLibro = new ListaSimple();
        listaPrestamo = new ListaSimple();
        listaCategoria = new ListaSimple();
        pilaEliminados = new Pila();
    }
// pos condiciones: retorna un aviso.
    @Override
    public Retorno crearSistemaDeGestion() {
        return Retorno.ok();
    }

    
    
     // Pre: nombre y apellido no nulos ni vacíos; número entre 1 y 500000.
    // Pos: Agrega el estudiante si cumple las condiciones o retorna un error.
    @Override
    public Retorno agregarEstudiante(String nombre, String apellido, int numero) {
        Estudiante E = new Estudiante(nombre, apellido, numero,0);
       if (nombre == null || apellido == null || nombre.isEmpty() || apellido.isEmpty()) {
        return Retorno.error1(); 
    }else if (numero <= 0 || numero > 500000) {
        return Retorno.error2(); 
    } else if (listaEstudiantes.esteElemento(E)) {
        return Retorno.error3(); 
    } else {
        listaEstudiantes.agregarOrd(E);
        return Retorno.ok();
    }
  }
    
    
    // Pre: nombre, ISBN y categoría no nulos ni vacíos,la cantidad debe ser mayor a 0.
    // Pos: Agrega el libro si cumple las condiciones o retorna un error.
    @Override
    public Retorno agregarLibro(String nombre, String ISBN, String categoria, int cantidad) {
        
        if(categoria == null){
          return Retorno.error1(); 

        }
        
        Categoria cat = listaCategoria.ObtenerElemento(new Categoria(categoria));
        
        if(cat == null){
            cat = new Categoria(categoria);
            this.listaCategoria.agregarOrd(cat);
        }
        
        
        Libro L = new Libro(ISBN, nombre,cat,cantidad);
       if (nombre == null ||ISBN == null ||nombre.isEmpty() || ISBN.isEmpty() || categoria.isEmpty()) {
        return Retorno.error1(); 
    }else if (listaLibro.esteElemento(L)) {
        return Retorno.error2(); 
    } else if (cantidad <= 0 ) {
        return Retorno.error3(); 
    } else {
         listaLibro.agregarOrd(L);
         
        return Retorno.ok();
        
    }
       
       

               
       
       
       
       
       
  }
  
 
    
    // Pre: número entre 1 y 500000.
    // Pos: Retorna los datos del estudiante o un error.
   @Override
    public Retorno obtenerEstudiante(int numero) {

    Estudiante E = new Estudiante("","",numero,0);

    if (numero <= 0 || numero > 500000) {
        return Retorno.error1(); 
    }

    Estudiante estudianteObtenido = listaEstudiantes.ObtenerElemento(E);
    if (estudianteObtenido == null) {
        return Retorno.error2();
    }

 
    return Retorno.ok(estudianteObtenido.toString());



}

    
   // Pre: número entre 1 y 500000.
   // Pos: Elimina al estudiante si existe o retorna un error.
  @Override
    public Retorno eliminarEstudiante(int NumeroEstudiante) {
   
     Estudiante E = new Estudiante("", "", NumeroEstudiante,0);

    if (NumeroEstudiante <= 0 || NumeroEstudiante > 500000) {
        return Retorno.error1(); 
    } 
    Estudiante estudianteAEliminar = listaEstudiantes.ObtenerElemento(E);
    if (estudianteAEliminar == null) {
        return Retorno.error2();
    }
    listaEstudiantes.borrarElemento(estudianteAEliminar);
    return Retorno.ok();   
        
        
        
        
        
        
        
        
        

}
    

   // Pre: Ninguna.
   // Pos: Retorna una lista con todos los libros.
    @Override
    public Retorno listarLibros() {

          return Retorno.ok(listaLibro.mostrarString());
  
    }
    
    
    
 // Pre: Ninguna.
 // Pos: Retorna una lista con todos los estudiantes.
        @Override
    public Retorno listarEstudiantes() {
       return Retorno.ok(listaEstudiantes.mostrarString());
        
    }   
    
    
 
 // Pre: categoría no nula ni vacía.
 // Pos: Retorna los libros de la categoría o un error.
@Override
public Retorno listarLibros(String categoria) {
  
    
    if (categoria == null || categoria.isEmpty()) {
        return Retorno.error1();
    } else {
        String resultado = listarLibrosPorCategoria(categoria, 0, "");
        return Retorno.ok(resultado);
    }
}

//Pre : La categoria no debe ser nula
//Pos : Retorna los libros de la categoria que se le ingresa

private String listarLibrosPorCategoria(String categoria, int index, String acumulado) {
    
    if (index < 0 || index >= listaLibro.cantElementos()) {
        return acumulado; 
    }

    Libro libro = listaLibro.ObtenerElementoIndice(index);
    if (libro != null && libro.getCategoria().getNombre().equalsIgnoreCase(categoria)) {
       
        if (!acumulado.isEmpty()) {
            acumulado += "|";
        }
        acumulado += libro; 
    }
    
    return listarLibrosPorCategoria(categoria, index + 1, acumulado);
}


/**********************************************************************/
   /***************************Segundo obligatorio************************/ 
    /**********************************************************************/
   
 
/*Prestar libro*/

 // Pre: ISBN no nulo/ vacío, estudiante y libro registrados, stock disponible, menos de 8 préstamos activos.
 // Pos: Préstamo registrado, decremento de stock, aumento de préstamos del estudiante.
@Override
    public Retorno prestarLibro(String ISBN, int numero) {
        
        Libro L = new Libro(ISBN,"",null,0);
        Estudiante E = new Estudiante("", "", numero,0);
      
        
    if (ISBN == null || ISBN.isEmpty()) {
        return Retorno.error1();
    }

    Libro libroBuscado = listaLibro.ObtenerElemento(L);
    if (libroBuscado == null) {
        return Retorno.error2();
    }

    if (numero <= 0 || numero > 500000) {
        return Retorno.error3();
    }

    Estudiante estudianteBuscado = listaEstudiantes.ObtenerElemento(E);
    if (estudianteBuscado == null) {
        return Retorno.error4();
    }

    if (libroBuscado.getCantidad() == 0) {
        return Retorno.error5(); 
        
    }   
        
    /*Error 6*/
    
    //Parte 1
   estudianteBuscado.setCantPrestamos(estudianteBuscado.getCantPrestamos() + 1);
  //La cantidad de prestamos seria la cantidad de prestamos activos
   if(estudianteBuscado.getCantPrestamos() > 8){
    
       estudianteBuscado.setCantPrestamos(estudianteBuscado.getCantPrestamos() - 1);    
       
       return Retorno.error6();
    }
    
   Prestamo p = new Prestamo(libroBuscado,estudianteBuscado,"activo");
   //Parte 2
    if(listaPrestamo.esteElemento(p)){
       return Retorno.error6();
   }
   
 
   
    
    listaPrestamo.agregarInicio(p);
    libroBuscado.sumarPrestamo();
    libroBuscado.setCantidad(libroBuscado.getCantidad() - 1);
    libroBuscado.getCategoria().incrementar();
    return Retorno.ok();

        
    }

    
    
    
    
        
    /*Eliminar libro*/
    
  // Pre: ISBN no nulo/ vacío, libro registrado, sin préstamos activos.
 // Pos: Libro eliminado y registrado en la pila de eliminados.
        @Override
    public Retorno eliminarLibro(String ISBN) {
        if (ISBN == null || ISBN.isEmpty()) {
        return Retorno.error1(); 
    }
        Libro libroBuscado = listaLibro.ObtenerElemento(new Libro(ISBN, "", null, 0));
    if (libroBuscado == null) {
        return Retorno.error1(); 
    }

    if (libroBuscado.getCantidadPrestamos()>0) {
    return Retorno.error2();
    }
    pilaEliminados.apilar(libroBuscado);
    listaLibro.borrarElemento(libroBuscado);
    return Retorno.ok();
    
    }

  
    
    /*Reservar libro*/
    // Pre: ISBN no nulo/ vacío, libro registrado, estudiante registrado, sin stock.
    // Pos: Reserva registrada en la cola del libro.
   @Override
    public Retorno reservarLibro(String ISBN, int numero) {
        if (ISBN == null || ISBN.isEmpty()) return Retorno.error1();

    Libro libroBuscado = listaLibro.ObtenerElemento(new Libro(ISBN, "", null, 0));
    if (libroBuscado == null) return Retorno.error2();

    if (numero <= 0 || numero > 500000) return Retorno.error3();

    Estudiante estudianteBuscado = listaEstudiantes.ObtenerElemento(new Estudiante("", "", numero,0));
    if (estudianteBuscado == null) return Retorno.error4();

    if (libroBuscado.getCantidad() > 0) {
        return Retorno.error5();
    }
    
    libroBuscado.agregarReserva(estudianteBuscado);
    return Retorno.ok();    }
    
   
    
    
    
    
    
    /*Devolver libro*/
    
 //Pre: ISBN del libro no deber ser nulo ni vacío y el numero del estudiante registrados con préstamo activo.
 // Pos: Préstamo finalizado, stock incrementado, próxima reserva gestionada.
    
    @Override
    public Retorno devolverLibro(String ISBN, int numero) {
        
         Libro L = new Libro(ISBN,"",null,0);
        Estudiante E = new Estudiante("", "", numero,0);
        
        
        
        if (ISBN == null || ISBN.isEmpty()){
            return Retorno.error1();
        }
        
         Libro libroBuscado = listaLibro.ObtenerElemento(L);
            if (libroBuscado == null) {
                return Retorno.error2();
            }
        
         if (numero <= 0 || numero > 500000){
             return Retorno.error3();
           }
            
        Estudiante estudianteBuscado = listaEstudiantes.ObtenerElemento(E);
          if (estudianteBuscado == null) {
                return Retorno.error4();
            }
        
          
    Prestamo prestamoBuscado = new Prestamo(libroBuscado, estudianteBuscado, "activo");

    Prestamo prestamoExistente = listaPrestamo.ObtenerElemento(prestamoBuscado);

    if (prestamoExistente == null) {
        return Retorno.error5(); 
    }
          
          
        prestamoExistente.setActivo("Finalizado");

        if(libroBuscado.getColaReservas().isEmpty()){
        libroBuscado.setCantidad(libroBuscado.getCantidad() + 1);
        estudianteBuscado.setCantPrestamos(estudianteBuscado.getCantPrestamos() - 1); 
       
        }else{
     Estudiante siguienteEstudiante = libroBuscado.getColaReservas().poll();
    prestarLibro(libroBuscado.getISBN(),estudianteBuscado.getNumero());
   
        }
        
         return Retorno.ok(); 
    }
    
    
    
    
    
    /*Listar prestamos*/
    
 // Pre: Número de estudiante válido y registrado.
 // Pos: Devuelve una lista de los préstamos activos asociados al estudiante.
       
   @Override
    public Retorno listarPrestamos(int numero) {
        Estudiante estudiante = new Estudiante("", "", numero,0);
        if (numero <= 0 || numero > 500000){ return Retorno.error1();}
        if (listaEstudiantes.ObtenerElemento(estudiante) == null) {return Retorno.error2();} 
        String resultado = listarPrestamosEstudiante(estudiante, 0, "");
        return Retorno.ok(resultado);
    }

    private String listarPrestamosEstudiante(Estudiante estudiante, int indice, String listaP) {
        if (indice < 0 || indice >= listaPrestamo.cantElementos()) {return listaP;}
       
        Prestamo prestamoE = listaPrestamo.ObtenerElementoIndice(indice);
        if (prestamoE != null && prestamoE.getEstudiante().equals(estudiante)) { 
            if (!listaP.isEmpty()) {listaP += "|";}
            listaP += prestamoE; 
        }
        return listarPrestamosEstudiante(estudiante, indice + 1, listaP);
    }
    
    
    
    
    
    
    
    
    //Libros mas prestados
  // Pre: La lista de libros no debe estar vacía.
 // Pos: Devuelve una lista con los libros que tienen la mayor cantidad de préstamos.
    

  @Override
public Retorno librosMasPrestados() {
    if (listaLibro.esVacia()) {
        return Retorno.error1();
    }
    
    int maxPrestamos = 0;
    ListaSimple<Libro> librosMaxPrestamos = new ListaSimple<>();
    StringBuilder ret = new StringBuilder(); 


    for (int i = 0; i < listaLibro.cantElementos(); i++) {
        Libro libro = listaLibro.ObtenerElementoIndice(i);
        int prestamosLibro = libro.getCantidadPrestamos();

        if (prestamosLibro > maxPrestamos) {
            maxPrestamos = prestamosLibro;
            librosMaxPrestamos.vaciar();
            librosMaxPrestamos.agregarOrd(libro);
        } else if (prestamosLibro == maxPrestamos && !librosMaxPrestamos.esteElemento(libro)) {
            librosMaxPrestamos.agregarOrd(libro);
        }
    }

    
    for (int i = 0; i < librosMaxPrestamos.cantElementos(); i++) {
        ret.append(librosMaxPrestamos.ObtenerElementoIndice(i).toStringMasPrestados());
        if (i < librosMaxPrestamos.cantElementos() - 1) {
            ret.append("|"); 
        }
    }

    return Retorno.ok(ret.toString());
}

    
    
  

  /*Deshacer Eliminaciones*/  
  // Pre: El número de restauraciones debe ser mayor que 0 y debe haber libros eliminados.
 // Pos: Los libros eliminados se reincorporan a la lista principal según lo indicado.

    @Override
    public Retorno deshacerEliminaciones(int n) {
           if (n <= 0) {
            return Retorno.error1();
        }

        if (pilaEliminados.esVacia()) {
            return Retorno.ok(""); 
        }

        ListaSimple <Libro> librosRevenant = new ListaSimple();
        librosRevenant = pilaEliminados.deshacerEliminar(n);
        listaLibro.sumarListas(librosRevenant);
        String ret = librosRevenant.mostrarString();
        
        return Retorno.ok(ret); 
    }

    
    //Cantidad de prestamos activos
  // Pre: ISBN no nulo/ vacío y libro registrado.
 // Pos: Devuelve la cantidad de préstamos activos del libro.
    @Override
public Retorno cantidadPrestamosActivos(String ISBN) {
    if (ISBN == null || ISBN.trim().isEmpty()) {return Retorno.error1();}
    if (listaPrestamo == null || listaPrestamo.cantElementos() == 0) {return Retorno.ok(); }

    Libro L = new Libro(ISBN,"",null,0);
    int CantidadPrestamos = ObtenerCantidadPrestamosActivos(L, 0, 0);
    return Retorno.ok(String.valueOf(CantidadPrestamos));
}

//Pre : Desde la funcion anterior se envia el libro, y el indice y cantidad 0
//Pos : Devuelve la cantidad de prestamos activos 
  private int ObtenerCantidadPrestamosActivos(Libro libroP, int index, int cantidad) {
    if (index >= listaPrestamo.cantElementos()) {return cantidad;}
    Prestamo prestamo = listaPrestamo.ObtenerElementoIndice(index);
    if (prestamo != null && prestamo.getLibro().equals(libroP) && "activo".equals(prestamo.getActivo())) {cantidad++;}
    
    return ObtenerCantidadPrestamosActivos(libroP, index + 1, cantidad); 
}

    
    /*Ranking de categorias*/
  // Pre: Debe haber préstamos registrados en el sistema.
 // Pos: Devuelve un listado con las categorías y sus préstamos ordenados por cantidad.
    @Override
public Retorno prestamosXCategoría() {
    if (listaPrestamo.esVacia()) {
        return Retorno.error1();
    } else {
        List<Categoria> listaCategorias = new ArrayList<>();

        String resultado = listaCategoria.mostrarString();
        return Retorno.ok(resultado);
    }
}

    
    
    
    
    
    
}
    
    

     

    

    
    
    
    
  




