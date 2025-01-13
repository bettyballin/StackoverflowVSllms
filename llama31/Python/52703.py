import functools\n\ndef aDecorator(func):\n    @functools.wraps(func)\n    def wrapper(*args, **kwargs):\n        print("aDecorator")\n        return func(*args, **kwargs)\n    return wrapper\n\ndef otherDecorator(func):\n    @functools.wraps(func)\n    def wrapper(*args, **kwargs):\n        print("otherDecorator")\n        return func(*args, **kwargs)\n    return wrapper\n\n@aDecorator\ndef myfunc1():\n    print("myfunc1")\n\nif __name__ == "__main__":\n    myfunc1()  # prints: aDecorator, myfunc1\n\n    # replace the decorator\n    myfunc1.__wrapped__ = otherDecorator(myfunc1.__wrapped__)\n\n    myfunc1()  # prints: otherDecorator, myfunc1