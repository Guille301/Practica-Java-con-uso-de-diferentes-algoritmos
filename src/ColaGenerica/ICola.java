package ColaGenerica;

public interface ICola<T extends Comparable<T>> {
    
	//PRE: Recibe un elemento no nulo
    //POS: Inserta el dato pasado como parámetro al final de la cola.
    public void encolar (T x); 
    
	//PRE: La cola no está vacía
    //POS: se elimina el primer elemento de la cola
    public void desencolar();
    
	//PRE: La cola no está vacía
    //POS: Devuelve el primer elemento de la cola (el primero agregado)
    public T front();
    
    //POS: Returna true si la cola es vacía
    public boolean esVacia();
    
    //POS: Vacía la cola
    public void vaciar();
    
    //Pos: Retorna la cantidad de elementos de la cola.
    public int cantidadElementos ();
    
    // --
    public void mostrar();
}
