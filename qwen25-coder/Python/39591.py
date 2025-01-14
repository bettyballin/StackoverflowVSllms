def fibonacci(n):\n    a, b = 0, 1\n    for _ in range(n):\n        a, b = b, a + b\n    return a\n\nif __name__ == "__main__":\n    import timeit\n    print(timeit.timeit('fibonacci(35)', globals=globals(), number=100))