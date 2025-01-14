import java.lang.String;
public class ImageMedianFilter {
    private void medianFilterSquare(int[] source, int[] dest, int rWidth, int rHeight, int radius) {
        int neighbourCount = (radius * 2 + 1) * (radius * 2 + 1);
        int[] rs = new int[neighbourCount];
        int[] gs = new int[neighbourCount];
        int[] bs = new int[neighbourCount];

        int rFirst = radius + (rWidth * radius);

        for(int x = 0; x < rHeight; x++) {
            for(int y = 0; y < rWidth; y++) {
                int destOffset = x * rWidth + y;
                int rOffset = destOffset + rFirst + y * (radius * 2);
                int index = 0;

                for(int xk = -radius; xk <= radius; xk++) {
                    for(int yk = -radius; yk <= radius; yk++) {
                        int kOffset = rOffset + xk + yk * rWidth;
                        int pixel = source[kOffset];
                        rs[index] = (pixel >> 16) & 0xFF;
                        gs[index] = (pixel >> 8) & 0xFF;
                        bs[index] = pixel & 0xFF;
                        index++;
                    }
                }

                dest[destOffset] = ((medianFilter(rs)) << 16) | 
                                   ((medianFilter(gs)) << 8) |
                                   medianFilter(bs);
            }
        }
    }

    // Quickselect algorithm for finding the median
    private int medianFilter(int[] array) {
        return quickSelect(array, 0, array.length - 1, array.length / 2);
    }

    private int quickSelect(int[] a, int lo, int hi, int k) {
        if (lo == hi)
            return a[lo];

        int pivotIndex = partition(a, lo, hi);

        if (k == pivotIndex)
            return a[k];
        else if (k < pivotIndex)
            return quickSelect(a, lo, pivotIndex - 1, k);
        else
            return quickSelect(a, pivotIndex + 1, hi, k);
    }

    private int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
    }
}