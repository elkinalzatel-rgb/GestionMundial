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

    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int diferenciaGoles() {
        return golesAFavor - golesEnContra;
    }

    @Override
    public String toString() {
        return "Ranking FIFA: " + rankingFIFA +
                "\nNombre: " + nombre +
                "\nGrupo: " + grupo +
                "\nGoles a favor: " + golesAFavor +
                "\nGoles en contra: " + golesEnContra +
                "\nPuntos: " + puntos +
                "\n---------------------------";
    }
}