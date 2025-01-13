import ctypes\n\ndef pid_exists(pid):\n    kernel32 = ctypes.WinDLL('kernel32')\n    process_handle = kernel32.OpenProcess(0x0400, False, pid)\n    if process_handle == 0:\n        return False\n    kernel32.CloseHandle(process_handle)\n    return True