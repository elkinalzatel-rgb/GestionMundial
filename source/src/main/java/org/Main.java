package main.java.org;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBST mundial = new ArbolBST();

        mundial.insert(new Seleccion(1, "Argentina", "A", 10, 2, 9));
        mundial.insert(new Seleccion(3, "Brasil", "C", 11, 4, 8));
        mundial.insert(new Seleccion(8, "Bélgica", "H", 4, 4, 4));
        mundial.insert(new Seleccion(4, "Inglaterra", "D", 7, 2, 6));
        mundial.insert(new Seleccion(5, "España", "E", 6, 3, 6));
        mundial.insert(new Seleccion(6, "Portugal", "F", 8, 5, 5));
        mundial.insert(new Seleccion(7, "Países Bajos", "G", 5, 2, 7));
        mundial.insert(new Seleccion(9, "Croacia", "A", 3, 2, 5));
        mundial.insert(new Seleccion(2, "Francia", "B", 9, 3, 7));
        mundial.insert(new Seleccion(10, "Uruguay", "B", 6, 6, 4));
        mundial.insert(new Seleccion(11, "Colombia", "C", 7, 3, 6));
        mundial.insert(new Seleccion(15, "Japón", "G", 5, 4, 6));
        mundial.insert(new Seleccion(12, "México", "D", 2, 5, 3));
        mundial.insert(new Seleccion(13, "Alemania", "E", 8, 7, 5));
        mundial.insert(new Seleccion(14, "Italia", "F", 4, 1, 7));

        int opcion;

        do {
            System.out.println("1. Registrar selección");
            System.out.println("2. Buscar selección");
            System.out.println("3. Eliminar selección");
            System.out.println("4. Favorito del torneo");
            System.out.println("5. Selección más débil");
            System.out.println("6. Reporte ordenado por rankingFIFA");
            System.out.println("7. Exportar lista de selecciones");
            System.out.println("8. Reporte PostOrder");
            System.out.println("9. Vista BFS");
            System.out.println("10. Diferencia total de goles");
            System.out.println("11. Altura del árbol");
            System.out.println("12. Total selecciones");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ranking FIFA:");
                    int ranking = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();

                    System.out.println("Grupo:");
                    String grupo = sc.nextLine();

                    System.out.println("Goles a favor:");
                    int gf = sc.nextInt();

                    System.out.println("Goles en contra:");
                    int gc = sc.nextInt();

                    System.out.println("Puntos:");
                    int puntos = sc.nextInt();

                    mundial.insert(new Seleccion(ranking, nombre, grupo, gf, gc, puntos));

                    System.out.println("Selección registrada");
                    break;

                case 2:
                    System.out.println("Ingrese ranking:");
                    int buscar = sc.nextInt();

                    Seleccion encontrada = mundial.search(buscar);

                    if (encontrada != null) {
                        System.out.println(encontrada);
                    } else {
                        System.out.println("No encontrada");
                    }
                    break;

                case 3:
                    System.out.println("Ranking a eliminar:");
                    int eliminar = sc.nextInt();

                    mundial.delete(eliminar);

                    System.out.println("Selección eliminada");
                    break;

                case 4:
                    System.out.println("Seleccion con mejor ranking FIFA: " + mundial.searchFavorite(mundial.getRaiz()).toString());
                    break;

                case 5:
                    System.out.println("Seleccion con peor ranking FIFA: " + mundial.searchWeak(mundial.getRaiz()).toString());
                    break;

                case 6:
                    mundial.printInOrder(mundial.getRaiz());
                    break;

                case 7:
                    mundial.exportTree(mundial.getRaiz());
                    break;

                case 8:
                    mundial.postOrder(mundial.getRaiz());
                    break;

                case 9:
                    mundial.viewTree();
                    break;

                case 10:
                    System.out.println(
                            "Diferencia total: " + mundial.printGoalDiff(mundial.getRaiz()));
                    break;

                case 11:
                    System.out.println(
                            "Altura del árbol: " + mundial.getHeight());
                    break;

                case 12:
                    System.out.println(
                            "Total selecciones: " + mundial.getTotalTeams());
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}