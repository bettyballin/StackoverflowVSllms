// Example: QuickSort performance variations\n   void quicksort(int arr[], int low, int high) {\n       if (low < high) {\n           int pi = partition(arr, low, high);\n           quicksort(arr, low, pi - 1);  // Tail recursion can be optimized\n           quicksort(arr, pi + 1, high);\n       }\n   }\n   // A bad choice of pivot in sorted data leads to O(n^2) time complexity.