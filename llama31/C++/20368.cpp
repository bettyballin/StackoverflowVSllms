DWORD result = WaitForSingleObject(processHandle, INFINITE);\nif (result == WAIT_OBJECT_0) {\n    // Process has terminated, proceed with updating DLLs\n}