package main.java.org;

public class Seleccion {
    private int rankingFIFA;
    private String nombre;
    private String grupo;
    private int golesAFavor;
    private int golesEnContra;
    private int puntos;

    public Seleccion(int rankingFIFA, String nombre, String grupo, int golesAFavor, int golesEnContra, int puntos) {
        this.rankingFIFA = rankingFIFA;
        this.nombre = nombre;
        this.grupo = grupo;
        this.golesAFavor = golesAFavor;
        this.golesEnContra = golesEnContra;
        this.puntos = puntos;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    @Override
    public String toString() {
        return "Ranking FIFA: " + rankingFIFA +
                "\nNombre: " + nombre +
                "\nGrupo: " + grupo +
                "\nGoles a favor: " + golesAFavor +
                "\nGoles en contra: " + golesEnContra +
                "\nPuntos: " + puntos +
                "\n---------------------------" +
                "\n";
    }
}