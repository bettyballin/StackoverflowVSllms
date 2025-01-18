public class QuickSort {
  public static void main(String[] args) {
    int arr[] = new int[]{5, 7, -20, 40};
    System.out.println("Original data:");
    printArray(arr);
    quicksort(arr, 0, arr.length - 1);
    System.out.println("\nSorted data:");
    printArray(arr);
  }

  static void quicksort(int[] arr, int low, int high) {
    if (low < high) {
      // pi is partitioning index, arr[pi] is now at right place
      int pi = partition(arr, low, high);
      quicksort(arr, low, pi - 1);  // Before pi
      quicksort(arr, pi + 1, high); // After pi
    }
  }

  static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];  
    int i = (low - 1); // index of smaller element
    for (int j = low; j < high; j++) {
      // If current element is smaller than the pivot
      if (arr[j] < pivot) {
        i++;
        // swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    // swap arr[i+1] and arr[high] (or pivot)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }

  static void printArray(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}