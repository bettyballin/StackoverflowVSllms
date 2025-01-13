#include <windows.h>\n#include <tchar.h>\n\nBOOL CheckStorageSpace(const TCHAR* lpDirectoryName) {\n    ULARGE_INTEGER freeBytesAvailable;\n    ULARGE_INTEGER totalNumberOfBytes;\n    ULARGE_INTEGER totalNumberOfFreeBytes;\n\n    if (GetDiskFreeSpaceEx(lpDirectoryName, &freeBytesAvailable, &totalNumberOfBytes, &totalNumberOfFreeBytes)) {\n        // Check if the available space is below a certain threshold\n        const DWORDLONG THRESHOLD = 1024 * 1024 * 50; // Example threshold: 50 MB\n        return freeBytesAvailable.QuadPart < THRESHOLD;\n    }\n    return FALSE;\n}