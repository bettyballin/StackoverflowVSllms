// Original process\nHANDLE hSection = CreateFileMapping(INVALID_HANDLE_VALUE, NULL, PAGE_READWRITE, 0, 1024, L"mySection");\n\n// Remote thread\nHANDLE hSection = OpenFileMapping(FILE_MAP_ALL_ACCESS, FALSE, L"mySection");\nLPVOID pData = MapViewOfFile(hSection, FILE_MAP_ALL_ACCESS, 0, 0, 0);