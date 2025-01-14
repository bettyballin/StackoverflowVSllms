import timeit\n\ndef heavy_function():\n    # Simulate a function that performs heavy computations (e.g., data processing, database query)\n    sum = 0\n    for i in range(1000000):\n        sum += i * i\n    return sum\n\n# Measure the execution time of the function\nexecution_time = timeit.timeit(heavy_function, number=100)\nprint(f"Average Execution Time: {execution_time/100} seconds")