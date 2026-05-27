package main.java.org;

package mundial;

public class Nodo {

    private Seleccion seleccion;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo(Seleccion seleccion) {
        this.seleccion = seleccion;
        this.izquierda = null;
        this.derecha = null;
    }


    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
}
