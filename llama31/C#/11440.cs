public static extern uint FILES_GetMemoryMapping(\n    [MarshalAs(UnmanagedType.LPStr)] string pPathFile,\n    out ushort Size,\n    [MarshalAs(UnmanagedType.LPStr)] string MapName,\n    out ushort PacketSize,\n    Mapping oMapping, // Note: no ref keyword\n    out byte PagesPerSector)\n{\n    Mapping dummyMapping = new Mapping();\n    return FILES_GetMemoryMapping(pPathFile, out Size, MapName, out PacketSize, ref dummyMapping, out PagesPerSector);\n}