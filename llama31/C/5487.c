DWORD bytesRead;\nSetFilePointer(fileHandle, offset, NULL, FILE_BEGIN);\nReadFile(fileHandle, buffer, length, &bytesRead, NULL);