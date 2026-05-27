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

    public void insert(Nodo nodo, int ranking) {
        if (raiz == null) raiz = nodo;
    }

    public void delete() {
    }

    public void search() {
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
