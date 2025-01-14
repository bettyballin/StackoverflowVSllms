public class Main {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort(new int[]{8,12,79,12,50,44,8,0,7,289,1});
    }
}

class QuickSort {
    public QuickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }

    void quickSort(int arr[], int low, int high) {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}