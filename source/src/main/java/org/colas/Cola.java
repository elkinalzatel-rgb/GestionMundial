package main.java.org.colas;

import main.java.org.Nodo;

public class Cola {
    private NodoCola frente;
    private NodoCola ultimo;
    private int tamanio;

    public Cola() {
        this.frente = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    //enqueue agrega un elemento al final de la cola
    public void enqueue(Nodo valor) {
        NodoCola nuevo = new NodoCola(valor);
        if (isEmpty()) frente = nuevo;
        else {
            ultimo.setSiguiente(nuevo);
        }
        ultimo = nuevo;
        tamanio++;
    }

    //dequeue elimina el elemento del frente y obtiene el valor que tenía
    public Nodo dequeue() {
        if (isEmpty()) throw new RuntimeException("La cola está vacia");
        Nodo valor = frente.getValor();
        frente = frente.getSiguiente();
        if (frente == null) ultimo = null;
        tamanio--;
        return valor;
    }

    //peek retorna el valor del elemento del frente
    public Nodo peek() {
        if (isEmpty()) throw new RuntimeException("La cola esta vacia");
        return frente.getValor();
    }

    //getSize retorna el tamaño de la cola
    public int getSize() {
        return tamanio;
    }

    //nomas imprime y ya
    public void print() {
        NodoCola actual = frente;
        System.out.println("Frente->Ultimo");
        while (actual != null) {
            System.out.println(actual.getValor() + " ");
            if (actual.getSiguiente() == null) break;
            actual = actual.getSiguiente();
        }
        System.out.println("----------");
    }
}