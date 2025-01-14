def bubble_sort(arr):\n    n = len(arr)\n    for i in range(n):\n        # Track if any swap was made\n        swapped = False\n        for j in range(0, n-i-1):\n            if arr[j] > arr[j+1]:\n                # Swap if the element found is greater than the next element\n                arr[j], arr[j+1] = arr[j+1], arr[j]\n                swapped = True\n        # If no two elements were swapped by inner loop, then break\n        if not swapped:\n            break\n    return arr\n\n# Example usage\nexample_array = [64, 34, 25, 12, 22, 11, 90]\nsorted_array = bubble_sort(example_array)\nprint("Sorted array is:", sorted_array)