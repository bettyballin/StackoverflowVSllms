import ctypes\nfrom ctypes import wintypes\n\ndef is_64bit_os():\n    return ctypes.sizeof(ctypes.c_void_p) == 8\n\ndef is_process_64bit(pid):\n    PROCESS_QUERY_INFORMATION = 0x0400\n    PROCESS_VM_READ = 0x0010\n\n    kernel32 = ctypes.WinDLL('kernel32', use_last_error=True)\n    OpenProcess = kernel32.OpenProcess\n    IsWow64Process = kernel32.IsWow64Process\n    CloseHandle = kernel32.CloseHandle\n\n    handle = OpenProcess(PROCESS_QUERY_INFORMATION | PROCESS_VM_READ, False, pid)\n    if not handle:\n        raise ctypes.WinError(ctypes.get_last_error())\n\n    is_wow64 = wintypes.BOOL()\n    if not IsWow64Process(handle, ctypes.byref(is_wow64)):\n        CloseHandle(handle)\n        raise ctypes.WinError(ctypes.get_last_error())\n\n    CloseHandle(handle)\n\n    if is_64bit_os():\n        return not is_wow64.value  # 64-bit OS and not WOW64 means it's a 64-bit process\n    else:\n        return False  # 32-bit OS, all processes are 32-bit\n\n# Example usage:\npid = 1234  # Replace with the PID of the process you want to check\ntry:\n    if is_process_64bit(pid):\n        print(f"Process {pid} is 64-bit.")\n    else:\n        print(f"Process {pid} is 32-bit.")\nexcept Exception as e:\n    print(f"Error: {e}")