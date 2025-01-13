import inspect\n\ndef get_caller_module_name():\n    frame = inspect.stack()[2]\n    module = inspect.getmodule(frame[0])\n    if module:\n        return module.__name__\n    return None\n\ndef f():\n    caller_module = get_caller_module_name()\n    print(f"Called from module: {caller_module}")