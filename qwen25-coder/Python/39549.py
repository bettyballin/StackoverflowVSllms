import ctypes\n\n# Load the DLL\ndll = ctypes.WinDLL('path_to_your_dll.dll')\n\n# Define the argument and return types of the functions you want to call from the DLL\n# Example:\n# dll.YourFunction.argtypes = [ctypes.c_int]\n# dll.YourFunction.restype = ctypes.c_int\n\n# Call a function\nresult = dll.YourFunction(123)\nprint(result)