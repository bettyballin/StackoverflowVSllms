def log_combing(data, threshold=0.005):\n    # Initialize a dictionary to store the counts of candidate codes\n    candidates = {}\n    # Initialize a counter for the number of distinct codes\n    distinct_count = 0\n\n    # First pass: find candidate codes\n    for code in data:\n        if code not in candidates:\n            candidates[code] = 1\n            distinct_count += 1\n            if distinct_count > 1 / threshold:\n                # Drop one count from each candidate code\n                for c in list(candidates.keys()):\n                    candidates[c] -= 1\n                    if candidates[c] == 0:\n                        del candidates[c]\n                distinct_count = len(candidates)\n\n    # Second pass: tally the counts of candidate codes\n    counts = {}\n    for code in data:\n        if code in candidates:\n            counts[code] = counts.get(code, 0) + 1\n\n    # Return codes that occur at least 1/2% of the time\n    return [code for code, count in counts.items() if count / len(data) >= threshold]