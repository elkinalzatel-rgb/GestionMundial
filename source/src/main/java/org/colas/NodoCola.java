package main.java.org.colas;

import main.java.org.Nodo;

public class NodoCola {
    private Nodo valor;
    private NodoCola siguiente;

    public NodoCola(Nodo valor) {
        this.valor = valor;
    }

    public Nodo getValor() {
        return valor;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
}
