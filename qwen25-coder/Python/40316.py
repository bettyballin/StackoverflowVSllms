import ctypes\nfrom ctypes import wintypes\n\n# Define constants for access rights\nGENERIC_READ = 0x80000000\nFILE_SHARE_READ = 0x00000001\n\ndef has_read_permission(folder_path):\n    # Prepare the path for Windows API functions\n    path = ctypes.c_wchar_p(folder_path)\n\n    # Open the directory with read access, sharing is required to ensure we do not block other processes\n    handle = ctypes.windll.kernel32.CreateFileW(\n        path,\n        GENERIC_READ,\n        FILE_SHARE_READ,\n        None,\n        wintypes.DWORD(3),  # OPEN_EXISTING\n        wintypes.DWORD(0),  # no flags and attributes\n        None\n    )\n\n    if handle == -1:\n        return False\n\n    # Close the handle as we don't need it anymore\n    ctypes.windll.kernel32.CloseHandle(handle)\n    return True\n\n# Example usage:\nprint(has_read_permission(r'C:\haveaccess'))  # Should print True or False based on actual permissions\nprint(has_read_permission(r'C:\donthaveaccess'))  # Should print True or False based on actual permissions