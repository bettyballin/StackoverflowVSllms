#include <windows.h>\n\nBOOL pread(HANDLE hFile, void* buffer, DWORD nNumberOfBytesToRead, DWORD64 offset, DWORD* lpNumberOfBytesRead) {\n    OVERLAPPED overlapped = {0};\n    overlapped.Offset = (DWORD)(offset & 0xFFFFFFFF);\n    overlapped.OffsetHigh = (DWORD)((offset >> 32) & 0xFFFFFFFF);\n    return ReadFile(hFile, buffer, nNumberOfBytesToRead, lpNumberOfBytesRead, &overlapped);\n}