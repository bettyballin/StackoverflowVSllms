import random\n\ndef partition(arr, low, high):\n    pivot = arr[high]\n    i = low\n    for j in range(low, high):\n        if arr[j] >= pivot:\n            arr[i], arr[j] = arr[j], arr[i]\n            i += 1\n    arr[i], arr[high] = arr[high], arr[i]\n    return i\n\ndef quickselect(arr, low, high, k):\n    if low <= high:\n        pivot_index = partition(arr, low, high)\n        if pivot_index == k:\n            return arr[pivot_index]\n        elif pivot_index > k:\n            return quickselect(arr, low, pivot_index - 1, k)\n        else:\n            return quickselect(arr, pivot_index + 1, high, k)\n    return -1\n\ndef find_kth_largest(arr, k):\n    return quickselect(arr, 0, len(arr) - 1, k - 1)\n\n# Example usage\narr = [3, 2, 1, 5, 6, 4]\nk = 2\nprint(f"The {k}th largest element is {find_kth_largest(arr, k)}")