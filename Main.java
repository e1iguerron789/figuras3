package EjercicioFigura;

import EjercicioPersona.Persona;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Figura> figuras = new ArrayList<>();

        while (true) {
            System.out.println("------Menú de Figuras------");
            System.out.println("1. Ingresar punto");
            System.out.println("2. Ingresar círculo");
            System.out.println("3. Ingresar triángulo");
            System.out.println("4. Ingresar rectángulo");
            System.out.println("5. Imprimir los datos");
            System.out.println("6. Imprimir los cálculos");
            System.out.println("7. Mostrar comparar perimetros entre figuras");
            System.out.println("8. Saliendo");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    ingresarPunto(figuras);
                    break;
                case 2:
                    ingresarCirculo(figuras);
                    break;
                case 3:
                    ingresarTriangulo(figuras);
                    break;
                case 4:
                    ingresarRectangulo(figuras);
                    break;
                case 5:
                    imprimirDatos(figuras);
                    break;
                case 6:
                    imprimirCalculos(figuras);
                    break;
                case 7:
                    compararPerimetros(figuras);
                    break;
                case 8:
                    System.out.println("Saliendo del Programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Saliendo del programa.");
                    System.exit(0);
            }
        }
    }

    private static void ingresarPunto(ArrayList<Figura> figuras) {
        Punto2D punto = new Punto2D();
        punto.leerDatos();
        figuras.add(punto);
    }

    private static void ingresarCirculo(ArrayList<Figura> figuras) {
        Circulo circulo = new Circulo();
        circulo.leerDatos();
        figuras.add(circulo);
    }

    private static void ingresarTriangulo(ArrayList<Figura> figuras) {
        Triangulo triangulo = new Triangulo();
        triangulo.leerDatos();
        figuras.add(triangulo);
    }

    private static void ingresarRectangulo(ArrayList<Figura> figuras) {
        Rectangulo rectangulo = new Rectangulo();
        rectangulo.leerDatos();
        figuras.add(rectangulo);
    }

    private static void imprimirDatos(ArrayList<Figura> figuras) {
        Iterator<Figura> it = figuras.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    private static void imprimirCalculos(ArrayList<Figura> figuras) {
        for (Figura figura : figuras) {
            System.out.println("Tipo de figura: " + figura.getTipo());
            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Perímetro: " + figura.calcularPerimetro());
            System.out.println();
        }
    }
    public static void compararPerimetros(ArrayList<Figura> Lista) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el tipo de la primera figura:");
        String tipoA = sc.next();
        System.out.println("Ingrese el tipo de la segunda figura:");
        String tipoB = sc.next();

        Figura figuraA = buscarFiguraPorTipo(Lista, tipoA);
        Figura figuraB = buscarFiguraPorTipo(Lista, tipoB);

        if (figuraA == null || figuraB == null) {
            System.out.println("No se encontraron figuras con los tipos proporcionados.");
            return;
        }

        System.out.println("Comparación de perímetros:");
        System.out.println("Tipo de Figura A: " + tipoA);
        System.out.println("Tipo de Figura B: " + tipoB);

        if (figuraA.isGreater(figuraA, figuraB)) {
            System.out.println("El Perímetro de " + tipoA + " es mayor que el Perímetro de " + tipoB + ".");
        } else if (figuraA.isLess(figuraA, figuraB)) {
            System.out.println("El Perímetro de " + tipoA + " es menor que el Perímetro de " + tipoB + ".");
        } else {
            System.out.println("Los perímetros son iguales.");
        }
    }

    public static Figura buscarFiguraPorTipo(ArrayList<Figura> Lista, String tipo) {
        for (Figura figura : Lista) {
            if (figura.getTipo() != null && figura.getTipo().equalsIgnoreCase(tipo)) {
                return figura;
            }
        }
        return null;
    }
}
