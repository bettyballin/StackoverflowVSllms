// Create a named pipe\nHANDLE hPipe = CreateNamedPipe(\n    L"\\\\.\\pipe\\myPipe", // Name of the pipe\n    PIPE_ACCESS_DUPLEX,     // Read/write access\n    PIPE_TYPE_BYTE | PIPE_READMODE_BYTE | PIPE_WAIT,\n    PIPE_UNLIMITED_INSTANCES, // Max instances\n    1024,                  // Output buffer size\n    1024,                  // Input buffer size\n    0,                     // Client time-out\n    NULL                   // Default security attributes\n);