DWORD result = WaitForObject(hObject, dwMilliseconds);\n\nif (result == WAIT_OBJECT_0) {\n    // The event is signaled\n} else if (result == WAIT_TIMEOUT) {\n    // The wait timed out\n} else if (result == WAIT_FAILED) {\n    // The wait failed\n    DWORD error = GetLastError();\n    // Handle error\n}