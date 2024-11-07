import java.util.*;

public class Ejercicio1 {
    static final int EstNum = 10;
    static final Random random = new Random();

    public static void main(String[] args) {
        int[] codigos = new int[EstNum];
        String[] nombres = new String[EstNum];
        double[][] notas = new double[EstNum ][4]; 

    
        for (int i = 0; i < EstNum; i++) {
            codigos[i] = 1 + random.nextInt(100); 
            nombres[i] = "Estudiante" + (i + 1);
            for (int j = 0; j < 3; j++) {
                notas[i][j] = 1.0 + (random.nextDouble() * 4.0); 
            }
        
            notas[i][3] = calcularDefinitiva(notas[i][0], notas[i][1], notas[i][2]);
        }

    
        System.out.println("Lista de Estudiantes:");
        mostrarEstudiantes(codigos, nombres, notas);

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deme el codigo del estudiante el cual quiere ver : ");
        int codigoBuscado = scanner.nextInt();
        buscarEstudiante(codigos, nombres, notas, codigoBuscado);

        
        ordenarPorDefinitiva(codigos, nombres, notas);
        System.out.println("\nLista de Estudiantes ordenada por nota definitiva:");
        mostrarEstudiantes(codigos, nombres, notas);
    }

    static double calcularDefinitiva(double nota1, double nota2, double nota3) {
        return Math.round((nota1 * 0.3 + nota2 * 0.3 + nota3 * 0.3) * 100.0) / 100.0; 
    }

    static void mostrarEstudiantes(int[] codigos, String[] nombres, double[][] notas) {
        for (int i = 0; i < EstNum; i++) {
            System.out.printf("Código: %d, Nombre: %s, Nota1: %.2f, Nota2: %.2f, Nota3: %.2f, Definitiva: %.2f%n",
                    codigos[i], nombres[i], notas[i][0], notas[i][1], notas[i][2], notas[i][3]);
        }
    }

    static void buscarEstudiante(int[] codigos, String[] nombres, double[][] notas, int codigoBuscado) {
        for (int i = 0; i < EstNum; i++) {
            if (codigos[i] == codigoBuscado) {
                System.out.printf("Encontrado - Código: %d, Nombre: %s, Nota1: %.2f, Nota2: %.2f, Nota3: %.2f, Definitiva: %.2f%n",
                        codigos[i], nombres[i], notas[i][0], notas[i][1], notas[i][2], notas[i][3]);
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }

    static void ordenarPorDefinitiva(int[] codigos, String[] nombres, double[][] notas) {
        for (int i = 0; i < EstNum - 1; i++) {
            for (int j = 0; j < EstNum - i - 1; j++) {
                if (notas[j][3] < notas[j + 1][3]) { 
                    
                    int tempCodigo = codigos[j];
                    codigos[j] = codigos[j + 1];
                    codigos[j + 1] = tempCodigo;

                    
                    String tempNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempNombre;

                    
                    double[] tempNotas = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = tempNotas;
                }
            }
        }
    }
}