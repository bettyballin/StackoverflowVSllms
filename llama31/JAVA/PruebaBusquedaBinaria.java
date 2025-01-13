import java.util.Arrays;
import java.util.Scanner;

public class PruebaBusquedaBinaria {
    static class ArregloBinario {
        private int[] datos;

        public ArregloBinario(int[] datos) {
            this.datos = datos;
            Arrays.sort(datos);
        }

        public int busquedaBinaria(int elementoBusqueda) {
            return busquedaBinariaRecursiva(elementoBusqueda, 0, datos.length - 1);
        }

        private int busquedaBinariaRecursiva(int elementoBusqueda, int inferior, int superior) {
            if (inferior > superior) {
                return -1;
            }
            int medio = (inferior + superior) / 2;
            if (elementoBusqueda == datos[medio]) {
                return medio;
            } else if (elementoBusqueda < datos[medio]) {
                return busquedaBinariaRecursiva(elementoBusqueda, inferior, medio - 1);
            } else {
                return busquedaBinariaRecursiva(elementoBusqueda, medio + 1, superior);
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(datos);
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int numElementos = entrada.nextInt();

        int[] arreglo = new int[numElementos];
        for (int i = 0; i < numElementos; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arreglo[i] = entrada.nextInt();
        }

        ArregloBinario arregloBusqueda = new ArregloBinario(arreglo);
        System.out.println("Array: " + arregloBusqueda);

        System.out.print("Enter a value to search (-1 to exit): ");
        int valorBusqueda = entrada.nextInt();

        while (valorBusqueda != -1) {
            int posicion = arregloBusqueda.busquedaBinaria(valorBusqueda);

            if (posicion == -1) {
                System.out.println("Value not found.");
            } else {
                System.out.println("Value found at position " + posicion);
            }

            System.out.print("Enter a value to search (-1 to exit): ");
            valorBusqueda = entrada.nextInt();
        }
    }
}