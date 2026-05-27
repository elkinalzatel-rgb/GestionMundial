package main.java.org;

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

    public void searchFavorite() {
    }

    public void searchWeak() {
    }

    public void printRanking() {
    }

    public void export() {
    }

    public void printGoalDiff() {
    }

    public void viewTree() {
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
