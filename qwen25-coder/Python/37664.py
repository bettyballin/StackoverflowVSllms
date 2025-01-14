def find_mode(arr):\n    # Create a dictionary to store the frequency of each element\n    frequency = {}\n    \n    # Count the occurrences of each number\n    for num in arr:\n        if num in frequency:\n            frequency[num] += 1\n        else:\n            frequency[num] = 1\n    \n    # Find the maximum frequency and corresponding mode(s)\n    max_count = 0\n    modes = []\n    for num, count in frequency.items():\n        if count > max_count:\n            max_count = count\n            modes = [num]\n        elif count == max_count:\n            modes.append(num)\n    \n    return modes\n\n# Example usage\narr = [1.5, 3.2, 4.8, 1.5, 3.2, 1.5, 2.9]\nmode = find_mode(arr)\nprint("Mode:", mode)