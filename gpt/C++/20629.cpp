#include <windows.h>\n#include <stdio.h>\n\nvoid WatchDirectory(LPCWSTR directory) {\n    HANDLE hChange = FindFirstChangeNotification(\n        directory,\n        TRUE,\n        FILE_NOTIFY_CHANGE_FILE_NAME | FILE_NOTIFY_CHANGE_DIR_NAME | FILE_NOTIFY_CHANGE_SIZE | FILE_NOTIFY_CHANGE_LAST_WRITE\n    );\n\n    if (hChange == INVALID_HANDLE_VALUE) {\n        printf("FindFirstChangeNotification failed with %d\n", GetLastError());\n        return;\n    }\n\n    while (TRUE) {\n        DWORD waitStatus = WaitForSingleObject(hChange, INFINITE);\n        switch (waitStatus) {\n        case WAIT_OBJECT_0:\n            // A change has occurred...\n            if (FindNextChangeNotification(hChange) == FALSE) {\n                printf("FindNextChangeNotification failed with %d\n", GetLastError());\n                return;\n            }\n            break;\n        default:\n            printf("Unexpected wait status: %d\n", GetLastError());\n            return;\n        }\n    }\n\n    FindCloseChangeNotification(hChange);\n}