package tads;


public interface ILista<T> {

    //Operaciones básicas
    public boolean esVacia();
    public void agregarInicio(T n);
        

    
    public void agregarFinal(T n);
    public void borrarInicio();
    public void borrarFin();
    public void vaciar();
    public void mostrar();

    //Adicionales
    public void agregarOrd(T n);
    public void borrarElemento(T n);
    public int cantElementos();
    public String mostrarString();
    
    
    
    /*Clase*/
    public boolean esteElemento(T n);

    /*Nuestros*/
      public void mostrarElemento(T n);
    //    public boolean ComprobarPrestamoEstudiante(T n);

      
     public T ObtenerElemento(T n);
    public T ObtenerElementoIndice(int n);

    /*Parte 2*/  
    public String mostrarPrestamosEstudiante(T n);
    
    public int mostrarPrestamosActivos(T n);
    public void sumarListas(ListaSimple lista);
    /*Segunda parte*/
//    public void PrestarLibro(T n,T n);
    
    
}
