#include <windows.h>\n#include <stdio.h>\n\nvoid WatchDirectory(LPCWSTR directory) {\n    HANDLE hDir = CreateFileW(\n        directory,\n        FILE_LIST_DIRECTORY,\n        FILE_SHARE_READ | FILE_SHARE_WRITE | FILE_SHARE_DELETE,\n        NULL,\n        OPEN_EXISTING,\n        FILE_FLAG_BACKUP_SEMANTICS,\n        NULL\n    );\n\n    if (hDir == INVALID_HANDLE_VALUE) {\n        printf("CreateFile failed with %d\n", GetLastError());\n        return;\n    }\n\n    char buffer[1024];\n    DWORD bytesReturned;\n\n    while (TRUE) {\n        if (ReadDirectoryChangesW(\n            hDir,\n            &buffer,\n            sizeof(buffer),\n            TRUE,\n            FILE_NOTIFY_CHANGE_FILE_NAME | FILE_NOTIFY_CHANGE_DIR_NAME | FILE_NOTIFY_CHANGE_SIZE | FILE_NOTIFY_CHANGE_LAST_WRITE,\n            &bytesReturned,\n            NULL,\n            NULL\n        )) {\n            FILE_NOTIFY_INFORMATION* pNotify = (FILE_NOTIFY_INFORMATION*)buffer;\n            do {\n                // Process the change...\n                pNotify = (FILE_NOTIFY_INFORMATION*)((char*)pNotify + pNotify->NextEntryOffset);\n            } while (pNotify->NextEntryOffset);\n        }\n    }\n\n    CloseHandle(hDir);\n}