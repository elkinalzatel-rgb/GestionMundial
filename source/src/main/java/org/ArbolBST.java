package main.java.org;

import main.java.org.colas.Cola;

public class ArbolBST {
    private Nodo raiz;
    private int height;
    private int totalTeams;

    public ArbolBST() {
        this.raiz = null;
        this.height = 0;
        this.totalTeams = 0;
    }

    public void insert(Seleccion seleccion) {
        raiz = insertNewNode(raiz, seleccion);
        totalTeams++;
    }

    private Nodo insertNewNode(Nodo nodo, Seleccion seleccion) {
        if (nodo == null) {
            return new Nodo(seleccion);
        }
        int rankingActual = nodo.getSeleccion().getRankingFIFA();
        int rankingNuevo = seleccion.getRankingFIFA();

        if (rankingNuevo < rankingActual) {
            nodo.setIzquierda(insertNewNode(nodo.getIzquierda(), seleccion));
            height++;
        } else if (rankingNuevo > rankingActual) {
            nodo.setDerecha(insertNewNode(nodo.getDerecha(), seleccion));
            height++;
        }
        return nodo;
    }

    public void delete(int rankingFIFA) {
        raiz = deleteNode(raiz, rankingFIFA);
        totalTeams--;
    }

    private Nodo deleteNode(Nodo nodo, int rankingFIFA) {
        if (nodo == null) {
            return null;
        }
        int rankingActual = nodo.getSeleccion().getRankingFIFA();

        if (rankingFIFA < rankingActual) {
            nodo.setIzquierda(deleteNode(nodo.getIzquierda(), rankingFIFA));
        } else if (rankingFIFA > rankingActual) {
            nodo.setDerecha(deleteNode(nodo.getDerecha(), rankingFIFA));
        } else {
            if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
                return null;
            }
            if (nodo.getIzquierda() == null) {
                return nodo.getDerecha();
            }
            if (nodo.getDerecha() == null) {
                return nodo.getIzquierda();
            }
            Nodo sucesor = findMin(nodo.getDerecha());
            nodo.setSeleccion(sucesor.getSeleccion());
            nodo.setDerecha(deleteNode(nodo.getDerecha(), sucesor.getSeleccion().getRankingFIFA()));
        }

        return nodo;
    }

    private Nodo findMin(Nodo nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }
        return nodo;
    }

    public Seleccion search(int rankingFIFA) {
        return searchNode(raiz, rankingFIFA);
    }

    private Seleccion searchNode(Nodo nodo, int rankingFIFA) {
        if (nodo == null) {
            return null;
        }

        int rankingActual = nodo.getSeleccion().getRankingFIFA();

        if (rankingFIFA < rankingActual) {
            return searchNode(nodo.getIzquierda(), rankingFIFA);
        } else if (rankingFIFA > rankingActual) {
            return searchNode(nodo.getDerecha(), rankingFIFA);
        } else {
            return nodo.getSeleccion();
        }
    }

    public Seleccion searchFavorite() {
        return search(1);
    }

    public Seleccion searchWeak() {
        return search(totalTeams);
    }

    public void printRanking() {

    }

    public void export() {
    }

    public void printGoalDiff() {

    }

    public void viewTree() {
    }

    public void preorder(Nodo nodo) {
        if (nodo == null) return;
        System.out.print(nodo.getSeleccion().toString() + " ");
        preorder(nodo.getIzquierda());
        preorder(nodo.getDerecha());
    }

    public void inOrder(Nodo nodo) {
        if (nodo == null) return;
        inOrder(nodo.getIzquierda());
        System.out.print(nodo.getSeleccion().toString() + " ");
        inOrder(nodo.getDerecha());
    }

    public void postorder(Nodo nodo) {
        if (nodo == null) return;
        postorder(nodo.getIzquierda());
        postorder(nodo.getDerecha());
        System.out.print(nodo.getSeleccion().toString() + " ");
    }

    public void levelOrder() {
        if (raiz == null) return;
        Cola cola = new Cola();
        cola.enqueue(raiz);
        while (!cola.isEmpty()) {
            Nodo actual = cola.dequeue();
            System.out.print(actual.getSeleccion().toString() + " ");
            if (actual.getIzquierda() != null) cola.enqueue(actual.getIzquierda());
            if (actual.getDerecha() != null) cola.enqueue(actual.getDerecha());
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public int getHeight() {
        return height;
    }

    public int getTotalTeams() {
        return totalTeams;
    }
}
