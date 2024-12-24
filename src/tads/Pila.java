package tads;


// SE DEBE IMPLEMENTAR PILA CORRECTAMENTE. MODIFICAR INTERFAZ
public class Pila<T extends Comparable<T>> implements IPila<T>{

    private Nodo<T> tope;
    private int cantidad;

    private Nodo getInicio() {
        return tope;
    }

    public Pila() {
        tope = null;
        cantidad = 0;
    }
    
    @Override
    public boolean esVacia() {
        return tope == null;
    }
    
    @Override
    public void apilar(T n) {
        Nodo nuevo = new Nodo(n);
        nuevo.setSiguiente(tope);
        tope = nuevo;
        
        this.cantidad++;
    }
    
    @Override
    public void desapilar() {
        if (!esVacia()) {
            Nodo borrar = tope;
            tope = tope.getSiguiente();
            borrar.setSiguiente(null);
            
            this.cantidad--;
        }
    }
    @Override
    public ListaSimple deshacerEliminar(int num) {
    ListaSimple ret = new ListaSimple();
    int counter = 0;
    while(counter < num && !this.esVacia()){
        T libro = this.top();
        this.desapilar();
        ret.agregarFinal(libro);
        counter++;
    }
    return ret;
        }
    @Override
    public T top() {
        if(esVacia()) throw new IllegalStateException("La pila está vacía");
        return this.tope.getDato();
    }
    
    @Override
    public void vaciar() {
        this.tope = null;
        this.cantidad = 0;
    }
    
    @Override
    public int cantidadElementos() {
        return cantidad;
    }

    // Para probar
    @Override
    public void mostrar() {

        Nodo mostrar = tope;

        while (mostrar != null) {
            System.out.println(mostrar.getDato());
            mostrar = mostrar.getSiguiente();
        }
    }

}