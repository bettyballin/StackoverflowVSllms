#include <Windows.h>\n#include <stdio.h>\n\n// Global SRWLock\nSRWLOCK srwLock;\n\nvoid InitializeLock() {\n    InitializeSRWLock(&srwLock);\n}\n\nvoid ReadOperation() {\n    // Acquire the lock in shared mode\n    AcquireSRWLockShared(&srwLock);\n\n    // Perform the read operation\n    printf("Read Operation\n");\n\n    // Release the lock\n    ReleaseSRWLockShared(&srwLock);\n}\n\nvoid WriteOperation() {\n    // Acquire the lock in exclusive mode\n    AcquireSRWLockExclusive(&srwLock);\n\n    // Perform the write operation\n    printf("Write Operation\n");\n\n    // Release the lock\n    ReleaseSRWLockExclusive(&srwLock);\n}\n\nDWORD WINAPI ReaderThread(LPVOID param) {\n    for (int i = 0; i < 5; ++i) {\n        ReadOperation();\n        Sleep(100); // Simulate some work\n    }\n    return 0;\n}\n\nDWORD WINAPI WriterThread(LPVOID param) {\n    for (int i = 0; i < 5; ++i) {\n        WriteOperation();\n        Sleep(200); // Simulate some work\n    }\n    return 0;\n}\n\nint main() {\n    InitializeLock();\n\n    HANDLE hReaders[3];\n    HANDLE hWriter;\n\n    // Create reader threads\n    for (int i = 0; i < 3; ++i) {\n        hReaders[i] = CreateThread(NULL, 0, ReaderThread, NULL, 0, NULL);\n    }\n\n    // Create writer thread\n    hWriter = CreateThread(NULL, 0, WriterThread, NULL, 0, NULL);\n\n    // Wait for all threads to finish\n    WaitForMultipleObjects(3, hReaders, TRUE, INFINITE);\n    WaitForSingleObject(hWriter, INFINITE);\n\n    // Close thread handles\n    for (int i = 0; i < 3; ++i) {\n        CloseHandle(hReaders[i]);\n    }\n    CloseHandle(hWriter);\n\n    return 0;\n}