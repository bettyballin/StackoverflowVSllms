HANDLE hPipe = CreateFile(\n    TEXT("\\\\.\\pipe\\MyPipe"),\n    GENERIC_READ | GENERIC_WRITE,\n    0,\n    NULL,\n    OPEN_EXISTING,\n    FILE_ATTRIBUTE_NORMAL,\n    NULL);