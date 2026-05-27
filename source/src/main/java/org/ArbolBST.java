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
        height = calculateHeight(raiz);
    }

    private int calculateHeight(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(nodo.getIzquierda()), calculateHeight(nodo.getDerecha()));
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

    public String printGoalDiff(Nodo nodo) {
        int[] totales = {0, 0}; // [golesAFavor, golesEnContra]
        calculateGoalDiff(nodo, totales);

        int diferencia = totales[0] - totales[1];

        String resultado = "\n========== GOAL DIFFERENCE SUMMARY ==========\n" +
                "Total Goals For: " + totales[0] + "\n" +
                "Total Goals Against: " + totales[1] + "\n" +
                "Total Goal Difference: " + diferencia + "\n" +
                "==========================================\n";

        System.out.print(resultado);
        return resultado;
    }

    private void calculateGoalDiff(Nodo nodo, int[] totales) {
        if (nodo == null) {
            return;
        }

        Seleccion seleccion = nodo.getSeleccion();
        totales[0] += seleccion.getGolesAFavor();
        totales[1] += seleccion.getGolesEnContra();

        calculateGoalDiff(nodo.getIzquierda(), totales);
        calculateGoalDiff(nodo.getDerecha(), totales);
    }

    public void exportTree(Nodo nodo) {
        if (nodo == null) return;
        System.out.print(nodo.getSeleccion().toString() + " ");
        exportTree(nodo.getIzquierda());
        exportTree(nodo.getDerecha());
    }

    public void printInOrder(Nodo nodo) {
        if (nodo == null) return;
        printInOrder(nodo.getIzquierda());
        System.out.print(nodo.getSeleccion().toString() + " ");
        printInOrder(nodo.getDerecha());
    }

    public void postOrder(Nodo nodo) {
        if (nodo == null) return;
        postOrder(nodo.getIzquierda());
        postOrder(nodo.getDerecha());
        System.out.print(nodo.getSeleccion().toString() + " ");
    }

    public void viewTree() {
        if (raiz == null) return;

        Cola cola = new Cola();
        cola.enqueue(raiz);

        while (!cola.isEmpty()) {
            int levelSize = cola.getSize();

            for (int i = 0; i < levelSize; i++) {
                Nodo actual = cola.dequeue();
                System.out.print(actual.getSeleccion().getNombre() + " ");

                if (actual.getIzquierda() != null) cola.enqueue(actual.getIzquierda());
                if (actual.getDerecha() != null) cola.enqueue(actual.getDerecha());
            }

            System.out.println();
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
