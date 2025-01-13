#include <iostream>\n#include <windows.h>\n\nvoid MonitorFileChanges(const std::wstring& path) {\n    HANDLE dirHandle = CreateFile(\n        path.c_str(),\n        FILE_LIST_DIRECTORY,\n        FILE_SHARE_READ | FILE_SHARE_WRITE,\n        NULL,\n        OPEN_EXISTING,\n        FILE_FLAG_BACKUP_SEMANTICS,\n        NULL\n    );\n\n    if (dirHandle == INVALID_HANDLE_VALUE) {\n        std::cerr << "Failed to open directory: " << GetLastError() << std::endl;\n        return;\n    }\n\n    DWORD bytesReturned;\n    char buffer[1024];\n    FILE_NOTIFY_INFORMATION* fni;\n\n    while (ReadDirectoryChangesW(\n                dirHandle,\n                (LPVOID)buffer,\n                sizeof(buffer),\n                FALSE,\n                FILE_NOTIFY_CHANGE_FILE_NAME | FILE_NOTIFY_CHANGE_LAST_WRITE,\n                &bytesReturned,\n                NULL,\n                NULL)) {\n\n        fni = (FILE_NOTIFY_INFORMATION*)buffer;\n        do {\n            if (fni->Action == FILE_ACTION_MODIFIED) {\n                wprintf(L"File changed: %s\n", fni->FileName);\n            }\n        } while (fni->NextEntryOffset);\n\n    }\n\n    CloseHandle(dirHandle);\n}\n\nint main() {\n    std::wstring path = L"C:\\path\\to\\your\\directory";\n    MonitorFileChanges(path);\n    return 0;\n}