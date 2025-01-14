import pickle\n\n# Define a safe set of builtins\nsafe_builtins = {\n    '__builtins__': None,  # Disable all standard builtins\n    'True': True,\n    'False': False,\n    'None': None,\n    'abs': abs,\n    'round': round,\n    'min': min,\n    'max': max,\n}\n\n# Allow only a few safe functions and modules\nsafe_functions = {\n    'print': print,\n}\nsafe_modules = {}\n\n# Combine them into a restricted globals dictionary\nrestricted_globals = {\n    **safe_builtins,\n    **safe_functions,\n}\n\n# Example restricted code\ncode = """\ndef add(a, b):\n    return a + b\n\nresult = add(10, 20)\nprint(result)  # This will not print to your stdout due to the empty __builtins__\n"""\n\nexec(code, restricted_globals)\n\n# Trying to use unsafe builtins or functions will fail\ntry:\n    exec("import os", restricted_globals)\nexcept Exception as e:\n    print(f"Error: {e}")\n\ntry:\n    exec("os.listdir('/home')", restricted_globals)\nexcept Exception as e:\n    print(f"Error: {e}")