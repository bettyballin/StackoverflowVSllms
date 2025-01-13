import time\nfrom functools import wraps\n\ndef time_it(f):\n    @wraps(f)\n    def wrapper(*args, **kwargs):\n        start = time.perf_counter()\n        result = f(*args, **kwargs)\n        end = time.perf_counter()\n        print(f"Function {f.__name__} took {end - start:.4f} seconds")\n        return result\n    return wrapper