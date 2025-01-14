import random\n\ndef approximate_sort(arr):\n    # This is a very basic simulation of near sorting.\n    # For a real implementation, refer to sophisticated data structures like Soft Heaps.\n    return sorted(arr, key=lambda x: (x + random.uniform(-0.1, 0.1)))\n\n# Example usage\ndata = [random.randint(1, 100) for _ in range(20)]\nsorted_data = approximate_sort(data)\nprint("Original data:", data)\nprint("Approximately sorted data:", sorted_data)