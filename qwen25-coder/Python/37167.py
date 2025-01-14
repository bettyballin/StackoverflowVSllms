import ctypes\n\ndef pid_exists(pid):\n    """Check whether pid exists."""\n    # Attempt to open the process with minimal access rights.\n    handle = ctypes.windll.kernel32.OpenProcess(1, False, pid)\n    if handle == 0:\n        return False\n    else:\n        # Close the handle to free resources and return True as the PID exists.\n        ctypes.windll.kernel32.CloseHandle(handle)\n        return True