/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.Scanner;

public class PruebaBusquedaBinaria {
    public static void main(String[] stringArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nArray = new int[n];
        for (int i = 0; i < n; ++i) {
            System.out.print("Enter element " + (i + 1) + ": ");
            nArray[i] = scanner.nextInt();
        }
        ArregloBinario arregloBinario = new ArregloBinario(nArray);
        System.out.println("Array: " + String.valueOf(arregloBinario));
        System.out.print("Enter a value to search (-1 to exit): ");
        int n2 = scanner.nextInt();
        while (n2 != -1) {
            int n3 = arregloBinario.busquedaBinaria(n2);
            if (n3 == -1) {
                System.out.println("Value not found.");
            } else {
                System.out.println("Value found at position " + n3);
            }
            System.out.print("Enter a value to search (-1 to exit): ");
            n2 = scanner.nextInt();
        }
    }

    static class ArregloBinario {
        private int[] datos;

        public ArregloBinario(int[] nArray) {
            this.datos = nArray;
            Arrays.sort(nArray);
        }

        public int busquedaBinaria(int n) {
            return this.busquedaBinariaRecursiva(n, 0, this.datos.length - 1);
        }

        private int busquedaBinariaRecursiva(int n, int n2, int n3) {
            if (n2 > n3) {
                return -1;
            }
            int n4 = (n2 + n3) / 2;
            if (n == this.datos[n4]) {
                return n4;
            }
            if (n < this.datos[n4]) {
                return this.busquedaBinariaRecursiva(n, n2, n4 - 1);
            }
            return this.busquedaBinariaRecursiva(n, n4 + 1, n3);
        }

        public String toString() {
            return Arrays.toString(this.datos);
        }
    }
}
