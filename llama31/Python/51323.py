import somemodule\n\nfor item in dir(somemodule):\n    obj = getattr(somemodule, item)\n    if hasattr(obj, '__doc__'):\n        print(obj.__doc__)