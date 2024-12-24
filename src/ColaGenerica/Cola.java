package ColaGenerica;

// SE DEBE IMPLEMENTAR COLA CORRECTAMENTE. MODIFICAR INTERFAZ
public class Cola<T extends Comparable<T>> implements ICola<T>{

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantidad;

    public Cola() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }
    
    @Override
    public void encolar(T x) {
        Nodo nuevo = new Nodo(x);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        this.cantidad++;
    }
    
    @Override
    public void desencolar() {
        if (!esVacia()) {
            Nodo borrar = inicio;
            inicio = inicio.getSiguiente();
            borrar.setSiguiente(null);
            
            this.cantidad--;
        }
    }
    
    @Override
    public T front(){
        if(esVacia()) throw new IllegalStateException("La cola está vacía");
        return this.inicio.getDato();
    }
    
    @Override
    public boolean esVacia() {
        return inicio == null;
    }
    
    @Override
    public void vaciar() {
        this.inicio = null;
        this.cantidad = 0;
    }
    
    @Override
    public int cantidadElementos() {
        return cantidad;
    }
    
    @Override
    public void mostrar() {
        Nodo mostrar = inicio;

        while (mostrar != null) {
            System.out.println(mostrar.getDato());
            mostrar = mostrar.getSiguiente();
        }
    }

}