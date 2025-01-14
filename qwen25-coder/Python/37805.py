import math\n\ndef find_n_for_complexity(time_limit_operations=10**7, complexity="n*log(n)"):\n    if complexity == "n*log(n)":\n        n = 1\n        while n * math.log2(n) <= time_limit_operations:\n            n += 1\n        return n - 1  # Subtract 1 because we incremented after the last valid n\n\n# Example usage\nmax_n_nlogn = find_n_for_complexity()\nprint("Max n for O(n*log(n)):", max_n_nlogn)