[DllImport("kernel32.dll")]\nstatic extern IntPtr OpenProcess(int dwDesiredAccess, bool bInheritHandle, int dwProcessId);