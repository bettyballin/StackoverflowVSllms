import ctypes\nimport multiprocessing\nimport time\n\n# Load your shared library\nmylib = ctypes.CDLL('./path_to_your_library.so')\n\n# Define an example function in the shared library\n# For example, assume the function is: void long_running_function(int *terminate)\nmylib.long_running_function.argtypes = [ctypes.POINTER(ctypes.c_int)]\n\ndef run_task(terminate_event):\n    terminate_flag = ctypes.c_int(0)\n    while not terminate_event.is_set():\n        # Call the long-running C function\n        mylib.long_running_function(ctypes.byref(terminate_flag))\n        if terminate_flag.value != 0:\n            # Handle early termination\n            break\n\nif __name__ == "__main__":\n    terminate_event = multiprocessing.Event()\n    process = multiprocessing.Process(target=run_task, args=(terminate_event,))\n    process.start()\n\n    # Simulate running for some time\n    time.sleep(10)\n\n    # Signal the process to terminate early\n    terminate_event.set()\n\n    # Wait for the process to finish\n    process.join()