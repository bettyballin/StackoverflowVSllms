#include <Winnetwk.h>\n\nint main() {\n    NETRESOURCE resource;\n    resource.dwType = RESOURCETYPE_ANY;\n    resource.lpLocalName = "Z:";\n    resource.lpRemoteName = "\\\\192.168.X.X\\somedir";\n    resource.lpProvider = NULL;\n\n    DWORD flags = 0;\n    if (WNetCancelConnection2(&resource, flags, FALSE) == NO_ERROR) {\n        printf("Disconnected successfully\n");\n    } else {\n        printf("Error disconnecting: %d\n", GetLastError());\n    }\n\n    return 0;\n}