HANDLE hFile = CreateFile("decrypted_file.txt", GENERIC_WRITE, 0, NULL, CREATE_ALWAYS, 0, NULL);\nif (hFile != INVALID_HANDLE_VALUE) {\n    FILE_DISPOSITION_INFO fdi;\n    fdi.DeleteFile = TRUE;\n    SetFileInformationByHandle(hFile, FileDispositionInfo, &fdi, sizeof(FILE_DISPOSITION_INFO));\n    // Write decrypted data to the file\n    WriteFile(hFile, decryptedData, dataSize, &bytesWritten, NULL);\n    CloseHandle(hFile); // File will be deleted when handle is closed\n}