import timeit\nimport bisect\n\ndef linear_search(arr, target):\n    for i, num in enumerate(arr):\n        if num == target:\n            return i\n    return -1\n\ndef binary_search(arr, target):\n    index = bisect.bisect_left(arr, target)\n    if index != len(arr) and arr[index] == target:\n        return index\n    return -1\n\n# Setup\narray_sizes = [10, 50, 100, 500, 1000, 5000, 10000]\nsetup_code = '''\nfrom __main__ import linear_search, binary_search\nimport random\narr = sorted(random.sample(range(100000), {size}))\ntarget = random.choice(arr)\n'''\n\n# Benchmark\nfor size in array_sizes:\n    linear_time = timeit.timeit(f'linear_search(arr, target)', setup=setup_code.format(size=size), number=1000)\n    binary_time = timeit.timeit(f'binary_search(arr, target)', setup=setup_code.format(size=size), number=1000)\n    print(f'Array size: {size}, Linear search time: {linear_time:.6f}s, Binary search time: {binary_time:.6f}s')