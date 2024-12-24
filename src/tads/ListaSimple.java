package tads;

public class ListaSimple<T extends Comparable> implements ILista<T> {
    private Nodo<T> inicio;
    private int cantidad;
    private Nodo<T> Ultimo;
    
    public ListaSimple(){
        inicio = null;
        cantidad = 0;
        Ultimo = null;
    }
    
    @Override
    public boolean esVacia() {
        return inicio == null;
    }
        

     @Override
    public void agregarInicio(T n) {
        Nodo<T> nuevo = new Nodo(n);
        if (esVacia()) {
            inicio = nuevo;
            Ultimo = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        cantidad++;
    }
    // Esto sirve para que cuando hay un nodo el inicio y el final apunte al mismo ,
    //pero que cuando hay mas de uno cambie la posicion de inicio y ultimo
    
 
       
    @Override
    public void agregarFinal(T n) {
        
        if(esVacia()){  
            agregarInicio(n);
        }
        else{
         
            Nodo nuevo = new Nodo(n);
            
            Ultimo.setSiguiente(nuevo);
            
            Ultimo = nuevo;
             
            
           
            cantidad++;
        }
    }
      
        

    @Override
    public void borrarInicio() {
        if(!esVacia()){
            if(inicio.getSiguiente() == null){ //Tengo un elemento
                vaciar();
            }
            else{
                Nodo<T> aBorrar = inicio;
                inicio = inicio.getSiguiente();
                aBorrar.setSiguiente(null);
                cantidad--;
            }
        }
    }
        

    @Override
    public void borrarFin() {
        if(inicio.getSiguiente() == null){
            vaciar();
        }else{
            Nodo aux = inicio;
            while(aux.getSiguiente().getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
            cantidad--;
        }
    }

    @Override
    public void vaciar() {
        inicio = null;
        Ultimo = null;
        cantidad = 0;
    }
        

    @Override
    public void mostrar() {
        
        Nodo aux = inicio;
        
        while(aux != null){
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
    }
    @Override
    public String mostrarString() {
        Nodo aux = inicio;
        String ret = "";
        if(aux == null) {
        return ret;
        }
        while(aux.getSiguiente() != null){
            ret += aux.getDato() + "|";
            aux = aux.getSiguiente();
        }
        ret+= aux.getDato();
        return ret;
    }
       
     @Override
    public int cantElementos() {
        Nodo aux = inicio;
        int contador = 0;
        while(aux != null){
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
      
    }
    
   @Override
public void borrarElemento(T n) {
    if (!esVacia()) {
        // Caso 1: El elemento está al inicio de la lista
        if (inicio.getDato().equals(n)) {
            borrarInicio();
        } 
        // Caso 2: El elemento está al final de la lista
        else if (Ultimo.getDato().equals(n)) {
            borrarFin();
        } 
        // Caso 3: El elemento está en el medio de la lista
        else {
            Nodo<T> aux = inicio;
            // Recorrer la lista buscando el nodo anterior al que contiene el dato 'n'
            while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(n)) {
                aux = aux.getSiguiente();
            }

            // Si encontramos el nodo a borrar
            if (aux.getSiguiente() != null) {
                // El siguiente del nodo 'aux' debe saltar el nodo que contiene 'n'
                aux.setSiguiente(aux.getSiguiente().getSiguiente());

                // Si el nodo borrado era el último nodo, actualizamos 'Ultimo'
                if (aux.getSiguiente() == null) {
                    Ultimo = aux;
                }

                // Decrementar la cantidad de elementos
                cantidad--;
            }
        }
    }
}


    
    
    
    @Override
    public void agregarOrd(T n) {

if(esVacia()  || inicio.getDato().compareTo(n)>0){
   
   agregarInicio(n);
}else{
    
    if(Ultimo.getDato().compareTo(n)<0){
     agregarFinal(n);   
    }else{
        Nodo<T> aux = inicio;
        
        while(aux.getSiguiente() != null && aux.getSiguiente().getDato().compareTo(n)<0){
            aux = aux.getSiguiente();
        }
            Nodo<T> nuevo = new Nodo(n);
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            cantidad++;
        }
    }
}
    
    
    
    
    @Override
    public boolean esteElemento(T n) {
        
        boolean esta = false;
       
        if(!esVacia()){
            Nodo<T> aux = inicio;
            
            
            while(aux != null && !esta){
                if(aux.getDato().equals(n)){
                    esta = true;
                }
                aux = aux.getSiguiente();
            }
            
        }
        
        return esta;
       
     }
    
    


    
    public Nodo<T> getInicio() {
    return inicio;
}
    
    @Override
    public void mostrarElemento(T n){
    Nodo aux = inicio;
    while(aux != null) {
    if (aux.getDato() == n) {
        System.out.println(aux.getDato() + " ");
    }
    aux = aux.getSiguiente();
    }
    }
   
    
    @Override
    public T ObtenerElemento(T n){
        Nodo<T> nodo = null;
        Nodo<T> aux = getInicio();
        
        while(aux !=null && nodo == null){
            if(aux.getDato().equals(n)){
                nodo = aux;
            }
            aux = aux.getSiguiente();
        }
        
        
        if (nodo == null) {
        return null;
    }
        
        
        return nodo.getDato();
    }
    @Override public void sumarListas(ListaSimple lista) {
    Nodo<T> aux = lista.inicio;
    while (aux != null) {
        this.agregarFinal(aux.getDato());
        aux = aux.getSiguiente();
    }
    }
    
     @Override
    public T ObtenerElementoIndice(int n){
       
        return ObtenerElementoIndiceRec(inicio,n,0); 
        
       
    }
    
         
    private T ObtenerElementoIndiceRec(Nodo<T> aux,int n, int pos){
       
       if (pos==n) {
           return aux.getDato();
       }else{
           return ObtenerElementoIndiceRec(aux.getSiguiente(), n, pos + 1);
       }
     }
       /*Parte 2 */
       
  @Override  
public String mostrarPrestamosEstudiante(T n) {
    Nodo aux = inicio;
    String ret = "";

    while (aux != null) {
        
        if (aux.getDato().equals(n)) {
            ret += aux.getDato();
        }
        if(aux.getSiguiente() != null){
        ret+="|";    
        }
        
        aux = aux.getSiguiente(); 
    }

    return ret;
}
       
        

      @Override  
public int mostrarPrestamosActivos(T n) {
    Nodo aux = inicio;
    int ret = 0;

    while (aux != null) {
        
        if (aux.getDato().equals(n)) {
            ret++;
        }
       
        
        aux = aux.getSiguiente(); 
    }

    return ret;
}
       
        
       
       
  
       
       
    
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        
       
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
    
    
    

  /*  @Override
    public boolean esteElemento(T n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

   
}
  