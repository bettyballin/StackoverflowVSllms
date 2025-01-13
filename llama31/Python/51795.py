def subset_sum(numbers, target, partial=[]):\n    s = sum(partial)\n    if s == target: \n        print("sum(%s)=%s" % (partial, target))\n    if s >= target:\n        return\n    for i, n in enumerate(numbers):\n        remaining = numbers[i+1:]\n        subset_sum(remaining, target, partial + [n])\n\n# Example usage:\nnumbers = [3, 34, 4, 12, 5, 2]\ntarget = 9\nsubset_sum(numbers, target)