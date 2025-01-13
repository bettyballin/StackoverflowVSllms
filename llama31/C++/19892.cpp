#include <Windows.h>\n#include <iostream>\n\nint main() {\n    // Choose the disk\n    char szLogicalDrives[MAX_PATH];\n    DWORD dwSize = MAX_PATH;\n    GetLogicalDriveStrings(dwSize, szLogicalDrives);\n\n    // Open the disk\n    HANDLE hDisk = CreateFile(szLogicalDrives[0], GENERIC_READ | GENERIC_WRITE, 0, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);\n\n    // Set the file pointer\n    SetFilePointer(hDisk, 0, NULL, FILE_BEGIN);\n\n    // Define the block size and number of iterations\n    const int blockSize = 1024 * 1024; // 1MB\n    const int iterations = 10;\n\n    // Measure the time\n    DWORD dwStart = GetTickCount();\n\n    // Read and write data\n    for (int i = 0; i < iterations; i++) {\n        char* pBuffer = new char[blockSize];\n        ReadFile(hDisk, pBuffer, blockSize, NULL, NULL);\n        WriteFile(hDisk, pBuffer, blockSize, NULL, NULL);\n        delete[] pBuffer;\n    }\n\n    // Measure the time\n    DWORD dwEnd = GetTickCount();\n\n    // Calculate the throughput\n    DWORD dwThroughput = (blockSize * iterations) / (dwEnd - dwStart);\n\n    std::cout << "Throughput: " << dwThroughput << " bytes/second" << std::endl;\n\n    // Close the disk\n    CloseHandle(hDisk);\n\n    return 0;\n}