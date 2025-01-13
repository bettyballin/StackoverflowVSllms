def longest_run(lst):\n    if not lst:\n        return None, None\n\n    max_run = 1\n    max_run_index = 0\n    current_run = 1\n    current_run_index = 0\n\n    for i in range(1, len(lst)):\n        if lst[i] == lst[i-1]:\n            current_run += 1\n        else:\n            if current_run > max_run:\n                max_run = current_run\n                max_run_index = current_run_index\n            current_run = 1\n            current_run_index = i\n\n    if current_run > max_run:\n        max_run = current_run\n        max_run_index = current_run_index\n\n    return max_run, max_run_index\n\nlst = [1, 2, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1]\nmax_run, max_run_index = longest_run(lst)\nprint(f"Longest run: {max_run} times")\nprint(f"Index of longest run: {max_run_index}")