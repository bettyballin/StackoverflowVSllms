HANDLE hFile = CreateFile("decrypted_file.txt", GENERIC_WRITE, 0, NULL, CREATE_ALWAYS, FILE_FLAG_DELETE_ON_CLOSE, NULL);\nif (hFile != INVALID_HANDLE_VALUE) {\n    // Write decrypted data to the file\n    WriteFile(hFile, decryptedData, dataSize, &bytesWritten, NULL);\n    CloseHandle(hFile); // File will be deleted when handle is closed\n}