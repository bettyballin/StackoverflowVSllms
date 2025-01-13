[DllImport("kernel32", SetLastError = true)]\nstatic extern IntPtr LoadLibraryEx(string lpFileName, IntPtr hReservedNull, LoadLibraryFlags dwFlags);\n\n[Flags]\nenum LoadLibraryFlags : uint\n{\n    LOAD_LIBRARY_AS_DATAFILE = 0x00000002\n}\n\n// Load the DLL as a data file\nIntPtr hModule = LoadLibraryEx("a.dll", IntPtr.Zero, LoadLibraryFlags.LOAD_LIBRARY_AS_DATAFILE);