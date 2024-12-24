package tads;

public interface IPila<T extends Comparable<T>> {
    
    //POS: Retorna true si la pila es vacía; false en caso contrario.
    public boolean esVacia();
    
	//PRE: Recibe un elemento no nulo
    //POS: Inserta el dato pasado como parámetro al inicio de la pila.
    public void apilar (T x);
    
	//PRE: La pila no es vacía
    //POS: se elimina el primer elemento de la pila (el último agregado).
    public void desapilar();
    
    //PRE: La pila no es vacía
    //POS: Retorna el primer elemento disponible de la pila (el último agregado).
    public T top();
    
    //POS: Vacía la pila.
    public void vaciar();
    
    //POS: Retorna la cantidad de elementos de una pila; 0 si es vacía.
    public int cantidadElementos();
    
    //..
    public void mostrar();
    public ListaSimple deshacerEliminar(int num);

}
