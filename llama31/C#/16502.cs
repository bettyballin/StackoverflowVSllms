[DllImport("CSITCPServer.dll", SetLastError = true)]\nstatic extern Int16 SS_Initialize(\n    UInt16[] ServerIds,\n    UInt16 ServerQty,\n    [MarshalAs(UnmanagedType.LPStr)] string Binding,\n    [MarshalAs(UnmanagedType.LPStr)] string LogPath,\n    UInt16 LogDays,\n    Int16 LogLevel,\n    UInt16 MaxThreads,\n    UInt16 ThreadTTL,\n    ProcessMessageCallback callback);