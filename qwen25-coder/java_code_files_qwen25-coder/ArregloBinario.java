package laboratorio9;

import java.util.Arrays;
import java.util.Scanner;

public class ArregloBinario {
    int[] datos;

    public ArregloBinario(int tamanio, Scanner entrada) {
        datos = new int[tamanio];

        System.out.println("Enter the " + tamanio + " elements of the array:");
        for (int i = 0; i < tamanio; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            datos[i] = entrada.nextInt();
        }

        Arrays.sort(datos);
    }

    public int busquedaBinaria(int elementoBusqueda, int inferior, int superior) {
        if (inferior > superior) {
            return -1;
        }

        int medio = (inferior + superior) / 2;

        System.out.print(elementosRestantes(inferior, superior));
        for (int i = 0; i < medio; i++)
            System.out.print("  ");
        System.out.println(" * ");

        if (elementoBusqueda == datos[medio]) {
            return medio;
        } else if (elementoBusqueda < datos[medio]) {
            return busquedaBinaria(elementoBusqueda, inferior, medio - 1);
        } else {
            return busquedaBinaria(elementoBusqueda, medio + 1, superior);
        }
    }

    public String elementosRestantes(int inferior, int superior) {
        StringBuilder temporal = new StringBuilder();

        for (int i = 0; i < inferior; i++)
            temporal.append("  ");

        for (int i = inferior; i <= superior; i++)
            temporal.append(datos[i] + " ");

        temporal.append("\n");
        return temporal.toString();
    }

    public String toString() {
        return elementosRestantes(0, datos.length - 1);
    }
}