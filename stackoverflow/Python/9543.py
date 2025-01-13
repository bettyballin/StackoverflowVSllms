>>> def caller(func, *args, **kwargs):\n...     return func(*args, **kwargs)\n...\n>>> def hello(a, b, c):\n...     print a, b, c\n...\n>>> caller(hello, 1, b=5, c=7)\n1 5 7