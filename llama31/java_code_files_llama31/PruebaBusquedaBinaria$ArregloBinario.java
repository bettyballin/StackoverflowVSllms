/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

static class PruebaBusquedaBinaria.ArregloBinario {
    private int[] datos;

    public PruebaBusquedaBinaria.ArregloBinario(int[] nArray) {
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
