SOCKET socket = ...;\nint pid = GetSocketOwningProcessId(socket);\nif (pid != -1) {\n    printf("The PID of the process that owns the socket is %d\n", pid);\n} else {\n    printf("Failed to get the PID of the process that owns the socket\n");\n}