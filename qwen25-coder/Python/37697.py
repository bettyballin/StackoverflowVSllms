def custom_decorator(decorator):\n    def wrapper(func):\n        func.__original_func = getattr(func, '__original_func', func)\n        return decorator(func)\n    return wrapper\n\n@custom_decorator(aDecorator)\ndef myfunc1():\n    print("Function Execution")